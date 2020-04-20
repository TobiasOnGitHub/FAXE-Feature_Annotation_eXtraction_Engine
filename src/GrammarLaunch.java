import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class GrammarLaunch {

    public static void main(String[] args) {
        // basic implementation taken from https://www.youtube.com/watch?v=dPWWcH5uM0g
        System.out.println("Test started.");
        try {
            List<String> allLines = Files.readAllLines(Paths.get("testData.txt"));
            for (String line : allLines) {
                System.out.print("Check test line \"" +line +"\"");

                boolean ret = parseCodeAnnotation(line);
                if(ret==true){
                    System.out.println(" - ACCEPTED");
                } else {
                    System.out.println(" - REJECTED");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test completed.");
    }


    public static boolean parseCodeAnnotation(String line) {
        CharStream in = CharStreams.fromString(line);
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.marker();

            //TODO - Check if visitor actually needed for this application
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            // System.out.println("ERROR DETECTED :)");
            return false;
        }
        return true;
    }
}