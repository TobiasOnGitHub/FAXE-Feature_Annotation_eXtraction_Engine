package se.gu.faxe;

import com.scalified.tree.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TreeNodeTest {

    @Test
    public void testTreeNode_NotNull() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/")));

        //new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_no.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        Assert.assertNotNull(assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_NotNull_Folder() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_no.java"));
        TreeNode<Asset> assets = faxe.getEmbeddedAnnotations(f);
        Assert.assertNotNull(assets);
    }

}
