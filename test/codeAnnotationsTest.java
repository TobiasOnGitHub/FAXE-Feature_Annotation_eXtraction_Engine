import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class codeAnnotationsTest {

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_VALID(){
        return new Object[][]{
                // BEGINMARKER
                {"&begin a", true},
                {"&begin[a] source", true},
                {"&begin[a]source", true},
                {"source&begin(a)", true},  // TODO - Unclear why this one fails
                {"source &line(a)", true},

                {"&begin a", true},
                {"&end a", true},
                {"&line a", true},
                {"&begin(a)", true},
                {"&begin[a]", true},
                {"&begin{a}", true},
                {"&end (a)", true},
                {"&end  (a)", true},
                {"&end (a) ", true},
                {"&end (a)  ", true},
                {"&line(a b)", true},
                {"&line(a,b)", true},
                {"&line(a b c)", true},
                {"&line(a,b,c)", true},
                {"&begin(feature)", true},
                {"&begin(Feature)", true},
                {"&begin(fEATURE)", true},
                {"&begin(f1)", true},
                {"&begin(1F)", true},
                {"&begin(thisIsALongFeatureName)", true},
                {"&begin(feature FEATURE)", true},
                {"&begin(f1,f2,f3)", true},
                {"&begin(aBcD1Ef fE2DcBa)", true},
                {"&begin(abcdefghijklmnopqrstuvwxyz 0123456789)", true},
                {"&begin(Parent::Child)", true},
                {"&begin(Child::Grandchild)", true},
                {"&begin(Parent::Child Child::Grandchild)", true},
                {"&begin(Parent::Child,Child::Grandchild)", true},
                {"&begin(Parent::Child, Child::Grandchild)", true},
                {"&begin(Parent::Child ,Child::Grandchild)", true},
                {"&begin(Parent::Child    ,        Child::Grandchild   )", true},
                {"&begin(Parent::Grandchild)", true},
                {"&begin(Parent::Child::Grandchild)", true},
                {"&begin(Parent::Child::GrandChild::GrandGrandChild)", true}

        };
    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_VALID")
    public void validEmbeddedCodeAnnotations(String strUnderTest, boolean expResult){

        boolean ret = GrammarLaunch.parseCodeAnnotation(strUnderTest);

        Assert.assertEquals(ret, expResult);
    }



    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_INVALID(){
        return new Object[][]{
                // MARKERS UNKNOWN
                {"&fun a", false},
                {"&aun a", false},
                {"Bla a", false},

                // BEGINMARKER
                {"begin a", false},
                {"&begin", false},
                {"&begin ", false},
                {" &begin ", false},

                // ENDMARKER
                {"end b", false},

                // LINEMARKER
                {"line a", false},

                // PARAMETER

                // ANNOSEPARATOR

                // COMMENT

                // LPQ

                // STRING
        };
    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_INVALID")
    public void invalidEmbeddedCodeAnnotations(String strUnderTest, boolean expResult){

        boolean ret = GrammarLaunch.parseCodeAnnotation(strUnderTest);

        Assert.assertEquals(ret, expResult);
    }
}
