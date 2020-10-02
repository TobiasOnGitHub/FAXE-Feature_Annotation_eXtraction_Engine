package se.gu.faxe;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.javatuples.Pair;
import se.gu.faxe.grammar.*;
import se.gu.faxe.metrics.Metrics;
import se.gu.faxe.metrics.ScatteringDegree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FAXE2 {

    private TreeNode<Asset> knownAssets;
    private FeatureModel featureModel = null;

    public FAXE2 (){

    }

    public FAXE2 (File rootDirectory){
        if(rootDirectory==null){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory equals NULL!");
        }

        if(!rootDirectory.exists()){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory does NOT exist!");
        }

        if(!rootDirectory.isDirectory()){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory NOT!");
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

    public TreeNode<Asset> getEmbeddedAnnotations(File rootDirectory) {

        for (File file : rootDirectory.listFiles()) {
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

                if(file.getName().endsWith(".feature-to-folder")){
                    Annotation annotation = getEmbeddedAnnotationsFromFeatureFolderMapping(nextAsset);
                    File parentPath = file.getParentFile();
                    TreeNode<Asset> parent = knownAssets.find(new Asset(parentPath));
                    Asset parentAsset = parent.data();
                    parentAsset.addAnnotation(annotation);
                } else if(file.getName().endsWith(".feature-to-file")){
                    List<Pair<File,Annotation>> eaList = getEmbeddedAnnotationsFromFeatureFileMapping(nextAsset);
                    /***************************************/
                    /** Merge mapping file data to Assets **/
                    /***************************************/
                    for(Pair<File,Annotation> pair : eaList){
                        TreeNode<Asset> nodeAsset = knownAssets.find(new Asset(pair.getValue0()));
                        Asset asset = nodeAsset.data();
                        asset.addAnnotation(pair.getValue1());
                    }
                } else if(file.getName().endsWith(".feature-model")
                        | file.getName().endsWith("feature-model")
                        | file.getName().endsWith(".cfr")
                        ){
                    /*****************************************************************************************/
                    /** ANALYSIS OF FEATURE HIERARCHY as *.feature-model, feature-model or *.cfr or . file **/
                    /****************************************************************************************/
                    getEmbeddedAnnotationsFeatureModel(new Asset(file));
                } else {
                    // CASE: Regular text file
                    getEmbeddedAnnotationsFromTextAsset(nextAsset);
                    /*****************************/
                    /**  ADD TO ASSET-TREE      **/
                    /*****************************/
                    File parent = file.getParentFile();
                    TreeNode<Asset> nodeParent = knownAssets.find(new Asset(parent));
                    nodeParent.add(new ArrayMultiTreeNode<>(nextAsset));
                }

            }


        }
        return knownAssets;
    }


    private void getEmbeddedAnnotationsFeatureModel(Asset fmAsset){
        featureModel = new FeatureModel(fmAsset.getPath());
    }

    /**
     * Method to extract embedded annotations on source code level of given file.
     * @param assetToAnalyze Asset object to be analyzed file.
     * @return List of found embedded annotations.
     */
    public Asset getEmbeddedAnnotationsFromTextAsset(Asset assetToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) + "\\" +assetToAnalyze.getPath().getAbsolutePath());
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
            List<Annotation> eaList = (List<Annotation>) visitor.visit(tree);
            assetToAnalyze.addAllAnnotation(eaList);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
        }
        return assetToAnalyze;
    }

    /**
     * Method to extract embedded annotations on file level of given file.
     * @param assetToAnalyze Asset object to be analyzed file.
     * @return List of found embedded annotations.
     */
    private static List<Pair<File,Annotation>> getEmbeddedAnnotationsFromFeatureFileMapping(Asset assetToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) + "\\" +assetToAnalyze.getPath().getAbsolutePath());
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

        List<Pair<File,Annotation>> eaList = new ArrayList<>();
        try {
            ParseTree tree = parser.fileAnnotations();
            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            eaList = (List<Pair<File,Annotation>>) visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }


    /**
     * Method to extract embedded annotations on folder level of given folder.
     * @param assetToAnalyze Asset object to be analyzed folder.
     * @return List of found embedded annotations.
     */
    private static Annotation getEmbeddedAnnotationsFromFeatureFolderMapping(Asset assetToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(assetToAnalyze.getPath().getAbsolutePath());
        } catch (IOException e) {
            try {
                System.out.println("No file found: " +(new File(".").getCanonicalPath()) + "\\" +assetToAnalyze.getPath().getAbsolutePath());
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

        Annotation annotation = null;
        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            annotation = (Annotation) visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return annotation;
    }


    public int getMetrics(File file, Metrics metric, Feature feature, boolean export) {

        getMetrics(file, metric, feature);

        if(export) {
            // TODO - Handling export if true
        }

        return 0;
    }

    public int getMetrics(File file, Metrics metric, Feature feature) {
//        System.out.println(">>> FAXE.getMetrics(File, Metrics, LPQ)");
        // 	-> FeatureDasboard Metrics!
        //	-> Say that "implemented by ... in ..." And in Javadoc Author adding him/her

        System.out.println("Path    " +file.toString());
        System.out.println("Metric  " +metric);
        System.out.println("Feature " +feature.getName());

        //TanglingDegree.calculateTD(eaList,file,feature);

        int ret = ScatteringDegree.calculateSD(knownAssets,file,feature);

//        System.out.println("<<< FAXE.getMetrics(File, Metrics, LPQ)");
        return ret;
    }

}
