package se.gu.faxe;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.Test;
import se.gu.faxe.grammar.featureModelLexer;
import se.gu.faxe.grammar.featureModelParser;

public class FeatureModelTest {

    @Test
    public void testLoadFeatureModel() {
        String line = "line";

        CharStream in = CharStreams.fromString(line);
        featureModelLexer lexer = new featureModelLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        featureModelParser parser = new featureModelParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.featuretree();

            MyFeatureModelVisitor visitor = new MyFeatureModelVisitor();
            FeatureModel fm = (FeatureModel) visitor.visit(tree);
            if(fm!=null) System.out.println("FM:" +fm.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("ERROR DETECTED :)");
        }

    }

    @Test
    public void testFeatureExistInFeatureModel() {
    }

    @Test
    public void testTestFeatureExistInFeatureModel() {
    }

    @Test
    public void testGetFeature() {
    }

    @Test
    public void testGetFeatureByName() {
    }
}