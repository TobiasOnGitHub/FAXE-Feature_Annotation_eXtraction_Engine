import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
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
            //String source = "testData.txt";
            //CharStream cs = fromFileName(source);
            //codeAnnotationLexer lexer = new codeAnnotationLexer(cs);

            List<String> allLines = Files.readAllLines(Paths.get("testData.txt"));
            for (String line : allLines) {
                System.out.println("Check test line \"" +line +"\"");

                CharStream in = CharStreams.fromString(line);
                codeAnnotationLexer lexer = new codeAnnotationLexer(in);
                CommonTokenStream token = new CommonTokenStream(lexer);
                codeAnnotationParser parser = new codeAnnotationParser(token);
                ParseTree tree = parser.marker();

                MyVisitor visitor = new MyVisitor();
                visitor.visit(tree);
                System.out.println("Test completed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test completed.");
    }
}
