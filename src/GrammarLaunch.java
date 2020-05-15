import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.json.CDL;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * This class offers the access to the library functions to extract embedded annotations of your project/source code.
 */
public class GrammarLaunch {

    /** Main function for testing purposes **/
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String projectRoot = "C:\\\\Users\\\\Tobias\\\\IdeaProjects\\\\ANTLR4_EmbeddedAnnotations\\\\test\\\\testProjectBitcoinWallet\\\\";
        List<EmbeddedAnnotation> eaList = extractEAfromRootDirectory(projectRoot);

        System.out.println("Found " +eaList.size() +" embedded annotation elements. Duration=" +((System.nanoTime()-startTime)/1000000) +"ms.");
        if(eaList!=null) System.out.println("EA:" +eaList.toString());

        JSONArray json = serializeEAList2JSON(eaList);

        System.out.println("x");

        List<EmbeddedAnnotation> eaList2 = new ArrayList<>();
        eaList2 = deserializeEAList2JSON(json);

        System.out.println("x");
    }


    /**
     * Method to extract embedded annotations from given root directory. The root directory and all sub-directories are
     * checked for EA in source code, files and folders. In addition the hierarchy file is analysed.
     * @param rootDirectory String of root directory.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromRootDirectory(String rootDirectory){
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        System.out.println("EA extraction process started ...");

        /* Create a re-usable object for "Stream<Path> paths = Files.walk(Paths.get("C:\\\\EA_Examples\\\\ClaferMooVisualizer\\\\Server\\\\Client\\\\")) " */
        Supplier<Stream<Path>> streamSupplier = () -> {
            try {
                return Files.walk(Paths.get(rootDirectory));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };

        /**********************************/
        /** ANALYSIS OF SOURCE CODE      **/
        /**********************************/
        //eaList.addAll(performEvaluationCodeAnnotations("test/testData_codeAnnotations.txt"));

        /* From root directory go through all individual files */
        /* Check for EA in each file */
//        streamSupplier.get().filter(Files::isRegularFile).forEach(s -> System.out.println(s.toString()));
        streamSupplier.get().filter(Files::isRegularFile).forEach(s -> eaList.addAll(extractEAfromSourceCode(s.toString())));


        /**********************************/
        /** ANALYSIS OF FEATURE-TO-FILE  **/
        /**********************************/
        //parseFileAnnotationLine("fileA fileB\n" + "Reference1 Reference2");
        //eaList.addAll(performEvaluationFileAnnotations("test/testData_fileAnnotations.txt"));

//        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(System.out::println);
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(s -> eaList.addAll(extractEAfromFeatureFile(s.toString())));

        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/
        //parseFolderAnnotationLine("featureA1, featureB1, featureC1");
        //eaList.addAll(performEvaluationFolderAnnotations("test/testData_folderAnnotations.txt"));

//        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-folder")).forEach(System.out::println);
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-folder")).forEach(s -> eaList.addAll(extractEAfromFeatureFolder(s.toString())));

        /******************************************/
        /** ANALYSIS OF CLAFER FEATURE HIERARCHY **/
        /******************************************/
        //TODO - Implement CLAFER hierarchy file interpretation according to given Grammar


        return eaList;
    }


    /**
     * Method to extract embedded annotations on source code level of given file.
     * @param fileToAnalyze String of to be analyzed file.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromSourceCode(String fileToAnalyze){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(fileToAnalyze);
        } catch (IOException e) {
            e.printStackTrace();
        }
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        try {
            ParseTree tree = parser.marker();

            MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
//            System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            //return false;
        }
        return eaList;
    }


    /**
     * Method to extract embedded annotations on file level of given file.
     * @param fileUnderTest String of to be analyzed file.
     * @return
     */
    public static List<EmbeddedAnnotation> extractEAfromFeatureFile(String fileUnderTest){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(fileUnderTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        fileAnnotationsParser parser = new fileAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        try {
            ParseTree tree = parser.fileAnnotations();

            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            //if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }


    /**
     * Method to extract embedded annotations on folder level of given folder.
     * @param folderUnderTest String of to be analyzed folder.
     * @return List of found embedded annotations.
     */
    public static List<EmbeddedAnnotation> extractEAfromFeatureFolder(String folderUnderTest){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName(folderUnderTest);
            //in = CharStreams.fromFileName("testData_folderAnnotations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        folderAnnotationsLexer lexer = new folderAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        folderAnnotationsParser parser = new folderAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        List<EmbeddedAnnotation> eaList;
        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
//            if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return null;
        }
        return eaList;
    }



    /**
     * Takes input String and checks if valid according to code annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseCodeAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.marker();

            MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Takes input String and checks if valid according to file annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseFileAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        fileAnnotationsParser parser = new fileAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.fileAnnotation();

            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            if (eaList != null) System.out.println("EA:" + eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Takes input String and checks if valid according to folder annotation grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    static boolean parseFolderAnnotationLine(String line) {
        CharStream in = CharStreams.fromString(line);
        folderAnnotationsLexer lexer = new folderAnnotationsLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        folderAnnotationsParser parser = new folderAnnotationsParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.folderAnnotation();

            MyFolderAnnotationVisitor visitor = new MyFolderAnnotationVisitor();
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            if(eaList!=null) System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }


    /**
     * Transforms list of {@link EmbeddedAnnotation} to JSON object.
     * @param eaList List of {@link EmbeddedAnnotation}
     * @return JSON object out of parameter.
     */
    public static JSONArray serializeEAList2JSON(List<EmbeddedAnnotation> eaList){
        JSONArray ja = new JSONArray();
        ja.put("eaType");
        ja.put("File");
        ja.put("OpeningLine");
        ja.put("ClosingLine");
        ja.put("Feature");

        String serialList = "";
        for(int i=0; i<eaList.size(); i++){
            serialList += eaList.get(i).serialize()+'\n';
        }

        JSONArray result = CDL.toJSONArray(ja, serialList);

        return result;
    }


    /**
     * Transforms JSON object to list of {@link EmbeddedAnnotation}
     * @param jsonArray JSON object
     * @return List of {@link EmbeddedAnnotation} out of parameter.
     */
    public static List<EmbeddedAnnotation> deserializeEAList2JSON(JSONArray jsonArray){
        ArrayList<EmbeddedAnnotation> list = new ArrayList<>();

        if (jsonArray != null) {
            for (int i=0;i<jsonArray.length();i++){
                list.add(EmbeddedAnnotation.deserialize(jsonArray.get(i).toString()));
            }
        } else {
            System.out.println("WARNING: deserializeEAList2JSON - empty JSONArray file (null)!");
        }

        return list;
    }

}