import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.Assert;
import org.testng.annotations.Test;

public class codeAnnotationsTest {

    @Test
    public void f(String code, String expectedText){
        CharStream in = CharStreams.fromString("&begin a");
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        ParseTree tree = parser.marker();

        //Assert.assertEquals(tree., expectedText);
    }
}
