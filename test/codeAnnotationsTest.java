import org.testng.Assert;
import org.testng.annotations.Test;

public class codeAnnotationsTest {

    //TODO - Refactor testing that report shows which case exactly failed

    @Test
    public void validEmbeddedCodeAnnotations(){

        boolean ret = GrammarLaunch.parseCodeAnnotation("&begin a");

        Assert.assertEquals(ret, true);
    }

    @Test
    public void invalidEmbeddedCodeAnnotations(){

        Assert.assertEquals(GrammarLaunch.parseCodeAnnotation("begin a"), false);
        Assert.assertEquals(GrammarLaunch.parseCodeAnnotation("end a"), false);
        Assert.assertEquals(GrammarLaunch.parseCodeAnnotation("line a"), false);
        Assert.assertEquals(GrammarLaunch.parseCodeAnnotation("&fun a"), false);
        Assert.assertEquals(GrammarLaunch.parseCodeAnnotation("&aun a"), false);
    }
}
