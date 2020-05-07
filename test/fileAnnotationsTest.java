import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class fileAnnotationsTest {

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_VALID(){
        return new Object[][]{
                {"Feature1\nReference1"},
                {"   Feature11\n     Reference1"},
                {"Feature12   \nReference1    "},
                {"Feature2 Feature3\nReference1 Reference2"},
                {"Feature2   Feature3\nReference1   Reference2"},
                {"Feature2, Feature3\nReference1, Reference2"},
                {"Feature4,Feature5,Feature6\nReference1,Reference2,Reference3"},
                {"Feature7, Feature8, Feature9, Feature10\nReference1, Reference2"}
        };
    }


    @Test(dataProvider = "provide_StrUnderTest_ExpResult_VALID")
    public void testFileAnnotation_GrammarCheck_SingleLine_VALID(String strUnderTest){
        boolean a = GrammarLaunch.parseFileAnnotationLine(strUnderTest);

        Assert.assertEquals(a, true);
    }

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_INVALID(){
        return new Object[][]{
                {"Character"},
                //TODO - Add more negative test cases
        };
    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_INVALID")
    public void testFileAnnotation_GrammarCheck_SingleLine_INVALID(String strUnderTest){
        boolean a = GrammarLaunch.parseFileAnnotationLine(strUnderTest);

        Assert.assertEquals(a, false);
    }


    private static List<EmbeddedAnnotation> referenceValue_FeatureFile = new ArrayList(){{
        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_FILE, "Configuration.java", -1, -1, "OwnName"));
    }};

    @Test
    public void testFileAnnotation_GrammarCheck_File(){
        List<EmbeddedAnnotation> foundEA = GrammarLaunch.extractEAfromFeatureFile("test/testProjectBitcoinWallet/src/de/schildbach/wallet/_.feature-file");

        Assert.assertEquals(foundEA.size(), 1);
    }

}
