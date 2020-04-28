import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

public class GrammarLaunch {

    public static void main(String[] args) {

        /**********************************/
        /** ANALYSIS OF SOURCE CODE      **/
        /**********************************/
        //performEvaluationCodeAnnotations();


        /**********************************/
        /** ANALYSIS OF FEATURE-TO-FILE  **/
        /**********************************/
//        CharStream in = CharStreams.fromString("fileA fileB\n" + "Reference1 Reference2");
//        fileAnnotationsLexer lexer = new fileAnnotationsLexer(in);
//        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
//        CommonTokenStream token = new CommonTokenStream(lexer);
//        fileAnnotationsParser parser = new fileAnnotationsParser(token);
//        parser.removeErrorListeners();
//        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
//
//        try {
//            ParseTree tree = parser.fileAnnotation();
//
//            MyFileAnnotationsVisitor visitor = new MyFileAnnotationsVisitor();
//            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
//            if(eaList!=null) System.out.println("EA:" +eaList.toString());
//        } catch (ParseCancellationException e) {
//            // Catch if given string is not fitting the grammar
//            System.out.println("ERROR DETECTED :)");
//            //return false;
//        }
//        //return true;

        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/
        //parseFolderAnnotationLine("featureA1, featureB1, featureC1");
        performEvaluationFolderAnnotations();

        /******************************************/
        /** ANALYSIS OF CLAFER FEATURE HIERARCHY **/
        /******************************************/
    }

    private static void performEvaluationCodeAnnotations(/*String rootFolder*/){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName("test/testData_codeAnnotations.txt");
        } catch (IOException e) {
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
            List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);
            System.out.println("EA:" +eaList.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
            //return false;
        }
    }



    private static void performEvaluationFolderAnnotations(/*String rootFolder*/){
        CharStream in = null;
        try {
            //in = CharStreams.fromPath(Paths.get("C:\\Users\\Tobias\\IdeaProjects\\ANTLR4_EmbeddedAnnotations\\test\\testData_folderAnnotations.txt.txt")) ;
            in = CharStreams.fromFileName("testData_folderAnnotations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            //return false;
        }
        //return true;
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
            // System.out.println("ERROR DETECTED :)");
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