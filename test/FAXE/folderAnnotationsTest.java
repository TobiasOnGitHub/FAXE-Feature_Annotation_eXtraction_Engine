package FAXE;

import FAXE.FAXE;
import FAXE.Grammar.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class folderAnnotationsTest {


    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_VALID(){
        return new Object[][]{
                {"Feature1"},
                {"   Feature11"},
                {"Feature12   "},
                {"Feature2 Feature3"},
                {"Feature2   Feature3"},
                {"Feature2, Feature3"},
                {"Feature2\nFeature3"},
                {"Feature4,Feature5,Feature6"},
                {"Feature7, Feature8, Feature9, Feature10"}
        };
    }


    @Test(dataProvider = "provide_StrUnderTest_ExpResult_VALID")
    public void testFolderAnnotation_GrammarCheck_SingleLine_VALID(String strUnderTest){
        boolean a = FAXE.parseFolderAnnotationLine(strUnderTest);

        Assert.assertEquals(a, true);
    }

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_INVALID(){
        return new Object[][]{
                {"Character"},
        };
    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_INVALID")
    public void testFolderAnnotation_GrammarCheck_SingleLine_INVALID(String strUnderTest){
        boolean a = FAXE.parseFolderAnnotationLine(strUnderTest);

        Assert.assertEquals(a, true);
    }


    private static List<EmbeddedAnnotation> referenceValue_FeatureFolder = new ArrayList(){{
        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FOLDER, null, -1, -1, "Main"));
    }};

    @Test
    public void testFolderAnnotation_GrammarCheck_File(){
        List<EmbeddedAnnotation> foundEA = FAXE.extractEAfromFeatureFolder("test/testProjectBitcoinWallet/src/de/schildbach/wallet/_.feature-folder");

        Assert.assertEquals(foundEA.size(), 1);
    }
}
