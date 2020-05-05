import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class GrammarLaunch {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<EmbeddedAnnotation> eaList = new ArrayList<>();

        /* Create a re-usable object for "Stream<Path> paths = Files.walk(Paths.get("C:\\\\EA_Examples\\\\ClaferMooVisualizer\\\\Server\\\\Client\\\\")) " */
        String projectRoot = "C:\\\\Users\\\\Tobias\\\\IdeaProjects\\\\ANTLR4_EmbeddedAnnotations\\\\test\\\\testProjectBitcoinWallet\\\\";
        Supplier<Stream<Path>> streamSupplier = () -> {
            try {
                return Files.walk(Paths.get(projectRoot));
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
        streamSupplier.get().filter(Files::isRegularFile).forEach(s -> eaList.addAll(performEvaluationCodeAnnotations(s.toString())));


        /**********************************/
        /** ANALYSIS OF FEATURE-TO-FILE  **/
        /**********************************/
        //parseFileAnnotationLine("fileA fileB\n" + "Reference1 Reference2");
        //eaList.addAll(performEvaluationFileAnnotations("test/testData_fileAnnotations.txt"));

//        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(System.out::println);
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-file")).forEach(s -> eaList.addAll(performEvaluationFileAnnotations(s.toString())));

        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/
        //parseFolderAnnotationLine("featureA1, featureB1, featureC1");
        //eaList.addAll(performEvaluationFolderAnnotations("test/testData_folderAnnotations.txt"));

//        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-folder")).forEach(System.out::println);
        streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-folder")).forEach(s -> eaList.addAll(performEvaluationFolderAnnotations(s.toString())));

        /******************************************/
        /** ANALYSIS OF CLAFER FEATURE HIERARCHY **/
        /******************************************/
        //TODO - CLAFER
        // https://github.com/gsdlab/clafer/blob/master/src/clafer.cf


        System.out.println("Found " +eaList.size() +" embedded annotation elements. Duration=" +((System.nanoTime()-startTime)/1000000) +"ms.");
        if(eaList!=null) System.out.println("EA:" +eaList.toString());
    }

    private static List<EmbeddedAnnotation> performEvaluationCodeAnnotations(String fileToAnalyze){
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



    public static List<EmbeddedAnnotation> performEvaluationFileAnnotations(String fileUnderTest){
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



    public static List<EmbeddedAnnotation> performEvaluationFolderAnnotations(String folderUnderTest){
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
     * Takes input String and checks if valid according to Grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    public static boolean parseCodeAnnotationLine(String line) {
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
     * Takes input String and checks if valid according to Grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    public static boolean parseFileAnnotationLine(String line) {
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
     * Takes input String and checks if valid according to Grammar.
     * @param line source code line under verification
     * @return true when valid ; false when invalid
     */
    public static boolean parseFolderAnnotationLine(String line) {
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
}