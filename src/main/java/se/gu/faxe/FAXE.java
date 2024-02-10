package se.gu.faxe;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.gu.faxe.grammar.codeAnnotationLexer;
import se.gu.faxe.grammar.codeAnnotationParser;
import se.gu.faxe.grammar.fileAnnotationsLexer;
import se.gu.faxe.grammar.fileAnnotationsParser;
import se.gu.faxe.grammar.folderAnnotationsLexer;
import se.gu.faxe.grammar.folderAnnotationsParser;
import se.gu.faxe.metrics.LinesOfFeatureCode;
import se.gu.faxe.metrics.Metrics;
import se.gu.faxe.metrics.NestingDepths;
import se.gu.faxe.metrics.NumberOfAnnotatedFiles;
import se.gu.faxe.metrics.NumberOfFeatures;
import se.gu.faxe.metrics.NumberOfFileAnnotations;
import se.gu.faxe.metrics.NumberOfFolderAnnotations;
import se.gu.faxe.metrics.ScatteringDegree;
import se.gu.faxe.metrics.TanglingDegree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * FAXE is an open source library (Apache 2.0) for parsing and receiving embedded annotations from software projects.
 */
public class FAXE {

    private TreeNode<Asset> knownAssets;
    private FeatureModel featureModel = null;

    /**
     * Default constructor to create an empty FAXE object.
     */
    public FAXE(){

    }

    /**
     * Create a FAXE instance, containing the parsed embedded annotations data from the given folder path
     * @param rootDirectory File folder path to root directory of project
     */
    public FAXE(File rootDirectory){
        if(rootDirectory==null){
            throw new IllegalArgumentException("FAXE::FAXE Given rootDirectory equals NULL!");
        }

        if(!rootDirectory.exists()){
            throw new IllegalArgumentException("FAXE::FAXE Given rootDirectory does NOT exist!");
        }

        if(!rootDirectory.isDirectory()){
            throw new IllegalArgumentException("FAXE::FAXE Given rootDirectory NOT!");
        }

        /***********************************************************************/
        /** GO THROUGH ALL ASSETS, CREATE ASSET TREE AND FILL ANNOTATION DATA **/
        /***********************************************************************/
        // Add root node
        Asset as = new Asset(rootDirectory);
        knownAssets = new ArrayMultiTreeNode<>(as);

        getEmbeddedAnnotations(rootDirectory);

        //System.out.println(knownAssets);


        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/



        //System.out.println("c");
    }

    @Override
    public String toString() {
        return "FAXE{" +
                "knownAssets=" + knownAssets +
                ", featureModel=" + featureModel +
                '}';
    }

    /**
     * Request tree object of all known assets.
     * @return Tree object of known assets.
     */
    public TreeNode<Asset> getKnownAssets() {
        return knownAssets;
    }

    /**
     * Request embedded annotation information for given directory.
     * @param rootDirectory File directory to analyze for embedded annotations.
     * @return Tree object with embedded annotated assets.
     */
    public TreeNode<Asset> getEmbeddedAnnotations(File rootDirectory) {

        if(rootDirectory == null){
            throw new NullPointerException("FAXE::getEmbeddedAnnotations Input rootDirectory is NULL.");
        }

        // in case of only one file to handle, add this as File item to to-be-handled array
        File[] rootDirectory_list = rootDirectory.listFiles();
        if(rootDirectory_list == null && rootDirectory.isFile()){
            rootDirectory_list = new File[1];
            rootDirectory_list[0] = rootDirectory;
        }
        for (File file : rootDirectory_list) {
            Asset nextAsset = new Asset(file);

            if (file.isDirectory()) {
                //System.out.println("Directory: " + file.getName());
                /*****************************/
                /**  ADD TO ASSET-TREE      **/
                /*****************************/
                File parent = file.getParentFile();
                TreeNode<Asset> nodeParent = knownAssets.find(new Asset(parent));
                nodeParent.add(new ArrayMultiTreeNode<>(nextAsset));
                /** Iterate through sub-directory **/
                getEmbeddedAnnotations(file);
            } else {
                //System.out.println("File: " + file.getName());

                //&begin(FolderMapping)
                if(file.getName().endsWith(".feature-to-folder")){
                    AnnotationFolder annotation = getEmbeddedAnnotationsFromFeatureFolderMapping(nextAsset);
                    File parentPath = file.getParentFile();
                    TreeNode<Asset> parent = knownAssets.find(new Asset(parentPath));
                    Asset parentAsset = parent.data();
                    parentAsset.addAnnotation(annotation);
                //&end(FolderMapping)
                //&begin(FileMapping)
                } else if(file.getName().endsWith(".feature-to-file")){
                    List<Pair<File,AnnotationFile>> eaList = getEmbeddedAnnotationsFromFeatureFileMapping(nextAsset);
                    /***************************************/
                    /** Merge mapping file data to Assets **/
                    /***************************************/
                    assert eaList != null;
                    for(Pair<File,AnnotationFile> pair : eaList){
                        TreeNode<Asset> nodeAsset = knownAssets.find(new Asset(pair.getValue0()));
                        if(nodeAsset!=null) {
                            Asset asset = nodeAsset.data();
                            asset.addAnnotation(pair.getValue1());
                        } else {
                            System.out.println("FAXE::getEmbeddedAnnotations - ERROR: Pair=" +pair.toString() +" not found in knownAssets: " +knownAssets.toString());
                        }
                    }
                //&end(FileMapping)
                //&begin(FeatureModel)
                } else if(file.getName().endsWith(".feature-model")
                        | file.getName().endsWith("feature-model")
                        | file.getName().endsWith(".cfr")
                        ){
                    /*****************************************************************************************/
                    /** ANALYSIS OF FEATURE HIERARCHY as *.feature-model, feature-model or *.cfr or . file **/
                    /****************************************************************************************/
                    getEmbeddedAnnotationsFeatureModel(new Asset(file));
                //&end(FeatureModel)
                //&begin(TextMapping)
                } else {
                    // CASE: Regular text file
                    TreeNode<Asset> nextAssetNode = getEmbeddedAnnotationsFromTextAsset(nextAsset);
                    /*****************************/
                    /**  ADD TO ASSET-TREE      **/
                    /*****************************/
                    File parent = file.getParentFile();
                    TreeNode<Asset> nodeParent = knownAssets.find(new Asset(parent));
                    if(nodeParent.find(nextAsset)==null) {
                        nodeParent.add(nextAssetNode);
                    } else {
                        // Update parameters
                        TreeNode<Asset> node = nodeParent.find(nextAsset);
                        node.setData(nextAsset);
                    }
                }
                //&end(TextMapping)
            }


        }
        return knownAssets;
    }

    /**
     * Request all embedded annotations for one specific feature, inside the given directory.
     * @param rootDirectory File directory to analyze.
     * @param feature Feature of interest.
     * @return List of annotations.
     * @throws UnsupportedOperationException thrown to indicate that method not implemented yet.
     */
    public static List<Annotation> getEmbeddedAnnotations(File rootDirectory, Feature feature) throws UnsupportedOperationException {
        System.out.println("UC7 - Return all embedded annotations for one specific feature");
        System.out.println("Search for Feature " +feature);

        throw new UnsupportedOperationException();
    }

    /**
     * Create feature model file.
     * @param fmAsset Asset object
     */
    void getEmbeddedAnnotationsFeatureModel(Asset fmAsset){
        featureModel = new FeatureModel(fmAsset.getPath());
    }

    //&begin(TextMapping)
    /**
     * Extract embedded annotations from text asset, based on given file asset.
     * @param assetToAnalyze Asset file object to be analyzed file.
     * @return List of found embedded annotations.
     */
    public TreeNode<Asset> getEmbeddedAnnotationsFromTextAsset(Asset assetToAnalyze){
        //System.out.println(">> getEmbeddedAnnotationsFromTextAsset - File " +assetToAnalyze.getPath());
        TreeNode<Asset> fileNode = new ArrayMultiTreeNode<>(assetToAnalyze);    // file object to add text annotations
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) +File.separator +assetToAnalyze.getPath().getAbsolutePath());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.marker();

            MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
            List<Annotation> eaList = new ArrayList<>();
            try {
                eaList = (List<Annotation>) visitor.visit(tree);
            } catch (IllegalStateException e) {
                System.out.println("Parsing error happened in File " +assetToAnalyze.getPath());
                e.printStackTrace();
            }

            // Transform eaList to tree objects which can be attached to file node -> In flat node list
            for(Annotation ea : eaList){
                Asset nextAsset = new Asset(assetToAnalyze.getPath());
                nextAsset.addAnnotation(ea);
                fileNode.add(new ArrayMultiTreeNode<>(nextAsset));
            }

            // Organize flat node list to proper hierarchy
            TreeNode<Asset> fileNodeHierarchy = new ArrayMultiTreeNode<>(fileNode.root().data());
            List<TreeNode<Asset>> lastNodeStack = new ArrayList<>();
            List<Integer> lastNodeEndLineStack = new ArrayList<>();
            Collection<? extends TreeNode<Asset>> preOrderedCollection = fileNode.preOrdered();
            for (TreeNode<Asset> node : preOrderedCollection) {
                // Put node in the correct position in new fileNodeHierarchy
                if(node.isRoot()) {
                    continue;
                }
                if(lastNodeStack.isEmpty()){
                    // Only Fragment annotation can be parent of others
                    if (node.data().getAnnotationList().get(0) instanceof AnnotationFragment) {
                        lastNodeStack.add(node);
                        lastNodeEndLineStack.add(((AnnotationFragment) node.data().getAnnotationList().get(0)).getEndline());
                        fileNodeHierarchy.root().add(node);
                    }
                    continue;
                }

                Annotation nodeAnnotation = node.data().getAnnotationList().get(0);
                int start_next_feature = 0;
                if (nodeAnnotation instanceof AnnotationFragment) {
                    // potential parent is a fragment (only option that child of)
                    start_next_feature = ((AnnotationFragment) nodeAnnotation).getStartline();
                } else if (nodeAnnotation instanceof AnnotationLine) {
                    start_next_feature = ((AnnotationLine) nodeAnnotation).getLine();
                } else {
                    System.out.println("FAXE::getEmbeddedAnnotationsFromTextAsset - ERROR (1): This should never happen as inside text asset only Fragment and Line are allowed.");
                }
                // Next annotation considered as child when it starts before the previous annotation ends.
                for(int i = lastNodeStack.size()-1 ; i>=0; i--){
                    TreeNode<Asset> lastNode = lastNodeStack.get(i);
                    int endLine = lastNodeEndLineStack.get(i);
                    if (start_next_feature < endLine) {
                        lastNodeStack.add(node);
                        if (nodeAnnotation instanceof AnnotationFragment) {
                            lastNodeEndLineStack.add(((AnnotationFragment) node.data().getAnnotationList().get(0)).getEndline());
                        } else if (nodeAnnotation instanceof AnnotationLine) {
                            lastNodeEndLineStack.add(((AnnotationLine) node.data().getAnnotationList().get(0)).getLine());
                        } else {
                            System.out.println("FAXE::getEmbeddedAnnotationsFromTextAsset - ERROR (2): This should never happen as inside text asset only Fragment and Line are allowed.");
                        }
                        lastNode.add(node);
                        break;  // Stop loop as item added to correct position
                    } else {
                        lastNodeStack.remove(i);
                        lastNodeEndLineStack.remove(i);
                    }
                    if(lastNodeStack.isEmpty()){
                        // Back at level 0. Start new EA hierarchy
                        lastNodeStack.add(node);
                        if (nodeAnnotation instanceof AnnotationFragment) {
                            lastNodeEndLineStack.add(((AnnotationFragment) node.data().getAnnotationList().get(0)).getEndline());
                        } else if (nodeAnnotation instanceof AnnotationLine) {
                            lastNodeEndLineStack.add(((AnnotationLine) node.data().getAnnotationList().get(0)).getLine());
                        } else {
                            System.out.println("FAXE::getEmbeddedAnnotationsFromTextAsset - ERROR (3): This should never happen as inside text asset only Fragment and Line are allowed.");
                        }
                        fileNodeHierarchy.root().add(node);
                    }
                }

                fileNode = fileNodeHierarchy;
            }
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("FAXE::getEmbeddedAnnotationsFromTextAsset ERROR DETECTED :)");
        }
        return fileNode;
    }
    //&end(TextMapping)

    //&begin(FileMapping)
    /**
     * Method to extract embedded annotations on file level of given file.
     * @param assetToAnalyze Asset object to be analyzed file.
     * @return List of found embedded annotations.
     */
    public List<Pair<File,AnnotationFile>> getEmbeddedAnnotationsFromFeatureFileMapping(Asset assetToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) +File.separator +assetToAnalyze.getPath().getAbsolutePath());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        fileAnnotationsParser parser = new fileAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<Pair<File,AnnotationFile>> eaList;
        try {
            ParseTree tree = parser.fileAnnotations();
            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            eaList = (List<Pair<File,AnnotationFile>>) visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }
    //&end(FileMapping)

    //&begin(FolderMapping)
    /**
     * Method to extract embedded annotations on folder level of given folder.
     * @param assetToAnalyze Asset object to be analyzed folder.
     * @return List of found embedded annotations.
     */
    public static AnnotationFolder getEmbeddedAnnotationsFromFeatureFolderMapping(Asset assetToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) +File.separator +assetToAnalyze.getPath().getAbsolutePath());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
        folderAnnotationsLexer lexer = new folderAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        folderAnnotationsParser parser = new folderAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        AnnotationFolder annotation;
        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            annotation = (AnnotationFolder) visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("FAXE::getEmbeddedAnnotationsFromFeatureFolderMapping ERROR DETECTED.");
            return null;
        }
        return annotation;
    }
    //&end(FolderMapping)

    public String getEmbeddedAnnotationContent(Annotation ann) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String getMappedEmbeddedAnnotationContentFile(Annotation ann) throws UnsupportedOperationException {
        // Copy-Paste from "old" FAXE interface. Unclear of needed with new concept
        throw new UnsupportedOperationException();
    }


    /**
     * Renames given LPQ by new LPQ name. Changes are done permanent in file System.
     * @param lpq_before Feature to be renamed
     * @param lpq_after New feature name
     * @return Count of changed appearances.
     * @throws UnsupportedOperationException thrown to indicate that method not implemented yet.
     */
    public int renameFeatureName(Feature lpq_before, String lpq_after) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    //&begin(CalculateMetrics)
    /**
     * Request specific embedded annotation metric for given file and for some metrics feature.
     * @param file Path of file/folder to calculate metric of.
     * @param metric Metric which shall be calculated.
     * @param feature Feature to be used for calculation.
     * @param export Flag to export metric information. True to export.
     * @throws UnsupportedOperationException thrown to indicate that method not implemented yet.
     * @return Metric value.
     */
    public double getMetrics(File file, Metrics metric, Feature feature, boolean export) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();

//        double retMetric = getMetrics(file, metric, feature);
//        if(export) {
//            // TODO - Handling export if true
//        }
//        return retMetric;
    }
    //&end(CalculateMetrics)

    //&begin(CalculateMetrics)
    /**
     * Request specific embedded annotation metric for given file and for some metrics feature.
     * @param file Path of file/folder to calculate metric of.
     * @param metric Metric which shall be calculated.
     * @param feature Feature to be used for calculation.
     * @return Metric value.
     */
    public double getMetrics(File file, Metrics metric, Feature feature) {
//        System.out.println(">>> FAXE.getMetrics(File, Metrics, LPQ)");

        System.out.println("Path    " + file.toString());
        System.out.println("Metric  " + metric);
        if(feature!=null) {
            System.out.println("Feature " + feature.getName());
        }

        double ret = -1;
        try {
            switch (metric) {
                case SD:
                    ret = ScatteringDegree.calculateSD(knownAssets, file, feature); //&line(ScatteringDegree)
                    break;
                case TD:
                    ret = TanglingDegree.calculateTD(knownAssets, file, feature);   //&line(TanglingDegree)
                    break;
                case NoFiA:
                    ret = NumberOfFileAnnotations.calculateNoFiA(file, feature);    //&line(NumberOfFileAnnotations)
                    break;
                case NoFoA:
                    ret = NumberOfFolderAnnotations.calculateNoFoA(knownAssets, file, feature); //&line(NumberOfFolderAnnotations)
                    break;
                case NoAF:
                    ret = NumberOfAnnotatedFiles.calculateNoFA(knownAssets, file, feature); //&line(NumberOfAnnotatedFiles)
                    break;
                case LoFC:
                    ret = LinesOfFeatureCode.calculateLoFC(knownAssets, file, feature); //&line(LinesOfFeatureCode)
                    break;
                case AvgND:
                    ret = NestingDepths.calculateAvgND(knownAssets, file, feature);     //&line(NestingDepthsAverage)
                    break;
                case MaxND:
                    ret = NestingDepths.calculateMaxND(knownAssets, file, feature);     //&line(NestingDepthsMax)
                    break;
                case MinND:
                    ret = NestingDepths.calculateMinND(knownAssets, file, feature);     //&line(NestingDepthsMin)
                    break;
                case NoF:
                    ret = NumberOfFeatures.calculateNoF(knownAssets, file);             //&line(NumberOfFeatures)
                    break;
                case pAvgLoFC:
                    ret = LinesOfFeatureCode.calculateAverageLoFC(knownAssets, file);   //&line(AverageLinesOfFeatureCode)
                    break;
                case pAvgND:
                    ret = NestingDepths.calculateAvgAvgND(knownAssets, file);           //&line(AverageFeatureNestingDepth)
                    break;
                case pAvgSD:
                    ret = ScatteringDegree.calculateAverageSD(knownAssets, file);       //&line(AverageFeatureScatteringDegree)
                    break;
                default:
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

//        System.out.println("<<< FAXE.getMetrics(File, Metrics, LPQ)");
        return ret;
    }
    //&end(CalculateMetrics)


    /**
     * Check consistency according to embedded annotation specification and returns detected {@link ConsistencyViolation}s
     * Check is performed for one file or a folder, including sub-assets. Consistency violations checked for:
     * - Feature (LPQ) not part of FeatureModel + give recommendation which existing one could fit.
     * @param file File/Folder to check for embedded annotation consistency
     * @return List of violation of the embedded annotation specification
     * @throws UnsupportedOperationException thrown to indicate that method not implemented yet.
     */
    public List<ConsistencyViolation> checkConsistency(File file) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
        // Consistency Rules: begin/end annotations; line marker without content; Embedded Annotation part of feature model; brace missing
    }

    //&begin(JSON)
    /**
     * Serialize the currently stored feature mode and known assets to JSON format.
     * The output is stored into the same directory as the FAXE library is located.
     */
    public void serializeToJSON(){

        /*******************/
        /** FEATURE MODEL **/
        /*******************/
        // Creating JSON objects with org.json or Jackson library not possible.
        // TreeNode object has no good way to store the data and show its hierarchy.
        // Hierarchy must be persisted for feature model
        if(featureModel!=null) {
            String jsonFeatureModel = featureModel.serializeToJSON();
            if (!isJSONValid(jsonFeatureModel)) {
                System.out.println("WARNING with FeatureModel JSON! Internal generated version can't be transformed neither to JSONObject nor JSONArray!");
            } else {
                FileWriter myWriter;
                try {
                    myWriter = new FileWriter("featureModel.json");
                    myWriter.write(jsonFeatureModel);
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("FAXE::serializeToJSON ERROR - Feature Model not instantiated. NOT part of JSON export.");
        }

        /*******************/
        /** KNOWN ASSETS  **/
        /*******************/
        TreeNodeSerializer treeNodeSerializer = new TreeNodeSerializer(TreeNode.class);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule moduleTreeNode = new SimpleModule("TreeNodeSerializer", new Version(2, 1, 3, null, null, null));
        moduleTreeNode.addSerializer(TreeNode.class, treeNodeSerializer);
        objectMapper.registerModule(moduleTreeNode);


        List<TreeNode<Asset>> assetList = new ArrayList<TreeNode<Asset>>();
        for (TreeNode<Asset> node : knownAssets.preOrdered()) {
            assetList.add(node);
        }
        ArrayNode array = objectMapper.valueToTree(assetList);
        ObjectNode assetsNode = objectMapper.createObjectNode();
        assetsNode.putArray("Assets").addAll(array);
        JsonNode jsonAssets = objectMapper.createObjectNode().setAll(assetsNode);

        //System.out.println(jsonAssets.toPrettyString());
        if (!isJSONValid(jsonAssets.toString()) ) {
            System.out.println("ERROR with FeatureModel JSON! Internal generated version can't be transformed neither to JSONObject nor JSONArray!");
        } else {
            FileWriter myWriter;
            try {
                myWriter = new FileWriter("assets.json");
                myWriter.write(jsonAssets.toPrettyString());
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //&end(JSON)

    //&begin(JSON)
    /**
     * Try to transform given String into a JSONObject or JSONArray. In case of exception this is not the case.
     * Implementation taken from https://stackoverflow.com/questions/10174898/how-to-check-whether-a-given-string-is-valid-json-in-java/10174938#10174938
     * @param json Object to be tested if conform to JSON format.
     * @return True, if input has valid JSON format. False otherwise.
     */
    private boolean isJSONValid(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException ex) {
            try {
                new JSONArray(json);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
    //&end(JSON)

    //&begin(JSON)
    /**
     * Transforms JSON object to list of {@link Annotation}
     * Private method as currently no use case seen to perform this action
     * @param jsonArray JSON object
     * @return List of {@link Annotation} out of parameter.
     * @throws UnsupportedOperationException thrown to indicate that method not implemented yet.
     */
    private static List<Annotation> deserializeFromJSON(JSONArray jsonArray) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();

//        ArrayList<Annotation> list = new ArrayList<>();
//        if (jsonArray != null) {
//            for (int i=0;i<jsonArray.length();i++){
//                list.add(EmbeddedAnnotation.deserialize(jsonArray.get(i).toString()));
//            }
//        } else {
//            System.out.println("WARNING: deserializeEAList2JSON - empty JSONArray file (null)!");
//        }
//        return list;
    }
    //&end(JSON)

}
