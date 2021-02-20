package se.gu.faxe;

import com.scalified.tree.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeNodeTest {

    /**
     * Compares subtree of asset tree of given file and check by depth first search if features are in expected position
     * @param targetAnnotations list of features in depth first
     * @param f file to search for
     * @param assets Assets in FAXE model
     */
    private void compareFileTreeWithExpectedAnnotations(List<String> targetAnnotations, File f, TreeNode<Asset> assets) {
        // Find node of file
        TreeNode<Asset> rootNode = assets.find(new Asset(f));
        // Inspect data that according definition
        Iterator<TreeNode<Asset>> iterator = rootNode.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            //TreeNode<String> node = iterator.next();
            Asset nextItem = iterator.next().data();
            String a = "";
            if(nextItem.getAnnotationList().size()!=0) {
                a = nextItem.getAnnotationList().get(0).toString();
            }
            System.out.println("Checking feature: " +a);
            Assert.assertEquals(a, targetAnnotations.get(i));
            i++;
        }
        Assert.assertNotNull(assets);
    }

    @Test
    public void testTreeNode_NotNull() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/")));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        Assert.assertNotNull(assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_no() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[Feature1]", "[Feature2]", "[Feature3]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_no.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_inner() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[Feature1]", "[Feature11]", "[Feature111]", "[Feature2]", "[Feature22]", "[Feature3]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_inner.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        // Find node of file
        TreeNode<Asset> rootNode = assets.find(new Asset(f));
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_basic_inner_single() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureB]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_inner_single.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_basic_inner_multiple() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureC]", "[FeatureB]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_inner_multiple.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_basic_inner_multiple2() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureC]", "[FeatureB]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_inner_multiple2.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_overlapping() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[Feature1]", "[Feature2]", "[Feature3]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_overlapping.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_basic_sameStart_differentEnd() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureC]", "[FeatureB]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_sameStart_differentEnd.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_basic_differentStart_sameEnd() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureB]", "[FeatureC]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_differentStart_sameEnd.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_TestFile_nesting_basic_overlapping_single() {
        // Input list as expected nodes in tree. Starting from root in Depth first.
        List<String> targetAnnotations = Arrays.asList("", "[FeatureA]", "[FeatureB]", "[FeatureB1]", "[FeatureA1]");
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/nested-file-annotations/nesting_basic_overlapping_single.java"));
        TreeNode<Asset> assets = faxe.getKnownAssets();
        compareFileTreeWithExpectedAnnotations(targetAnnotations, f, assets);
    }

}
