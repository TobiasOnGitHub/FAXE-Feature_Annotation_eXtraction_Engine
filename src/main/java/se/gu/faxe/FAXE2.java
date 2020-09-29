package se.gu.faxe;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.javatuples.Pair;
import se.gu.faxe.grammar.codeAnnotationLexer;
import se.gu.faxe.grammar.codeAnnotationParser;
import se.gu.faxe.grammar.fileAnnotationsLexer;
import se.gu.faxe.grammar.fileAnnotationsParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FAXE2 {

    private TreeNode<Asset> knownAssets;
    private FeatureModel featureModel = null;

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

        /*****************************************************************************************/
        /** ANALYSIS OF FEATURE HIERARCHY as *.feature-model, feature-model or *.cfr or . file **/
        /****************************************************************************************/
         Supplier<Stream<Path>> streamSupplier = () -> {
             try {
                 return Files.walk(Paths.get(rootDirectory.getPath()));
             } catch (IOException e) {
                 e.printStackTrace();
                 return null;
             }
        };
        String pathFM = streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-model") || f.endsWith(".cfr") || f.equals("feature-model")).findFirst().get();
        featureModel = new FeatureModel(new File(pathFM));

        /***********************************************************************/
        /** GO THROUGH ALL ASSETS, CREATE ASSET TREE AND FILL ANNOTATION DATA **/
        /***********************************************************************/
        // Add root node
        Asset as = new Asset(rootDirectory);
        knownAssets = new ArrayMultiTreeNode<>(as);

        for (File file : rootDirectory.listFiles()) {
            Asset nextAsset = new Asset(file);

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                //showFiles(file.listFiles()); // Calls same method again.
                // TODO - Go recursive through folders
            } else {
                System.out.println("File: " + file.getName());
                // TODO - extract data via Grammar and link it

                if(file.getName().endsWith(".feature-to-folder")){
                    System.out.println("x");
                } else if(file.getName().endsWith(".feature-to-file")){
                    List<Pair<File,Annotation>> eaList = getEmbeddedAnnotationsFromFeatureFileMapping(nextAsset);
                    /***************************************/
                    /** Merge mapping file data to Assets **/
                    /***************************************/
                    for(Pair<File,Annotation> pair : eaList){
                        TreeNode<Asset> nodeAsset = knownAssets.find(new Asset(pair.getValue0()));
                        Asset asset = nodeAsset.data();
                        asset.addAnnotation(pair.getValue1());

                        //nodeAsset.setData(asset);

                        System.out.println("x");
                    }
                } else if(file.getName().endsWith("feature-model")){
                    // Skip feature model file
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

        System.out.println(knownAssets);


        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/



        System.out.println("c");
    }



    /**
     * Method to extract embedded annotations on source code level of given file.
     * @param assetToAnalyze Asset object to be analyzed file.
     * @return List of found embedded annotations.
     */
    private static Asset getEmbeddedAnnotationsFromTextAsset(Asset assetToAnalyze){
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

}
