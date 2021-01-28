package se.gu.faxe;

import com.scalified.tree.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.metrics.Metrics;

import java.io.File;

public class FAXETest {

    @Test
    public void testFAXE_NotNull() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);
        Assert.assertNotNull(faxe);
    }

    @Test
    public void testGetKnownAssets_NotNull() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        TreeNode<Asset> knownAssets = faxe.getKnownAssets();
        Assert.assertNotNull(knownAssets);
    }

    @Test
    public void testGetEmbeddedAnnotations_NotNull_Folder() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data"));
        TreeNode<Asset> assets = faxe.getEmbeddedAnnotations(f);
        Assert.assertNotNull(assets);
    }

    @Test
    public void testGetEmbeddedAnnotations_NotNull_File() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"));
        TreeNode<Asset> assets = faxe.getEmbeddedAnnotations(f);
        Assert.assertNotNull(assets);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGetEmbeddedAnnotations_throwUnsupportedOperation() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data"));
        FAXE.getEmbeddedAnnotations(f, new Feature("AddressBook"));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGetEmbeddedAnnotationContent_throwUnsupportedOperation() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        faxe.getEmbeddedAnnotationContent(new AnnotationLine(new Feature("F"), 0));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGetMappedEmbeddedAnnotationContentFile_throwUnsupportedOperation() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        faxe.getMappedEmbeddedAnnotationContentFile(new AnnotationLine(new Feature("F"), 0));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRenameFeatureName_throwUnsupportedOperation() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        faxe.renameFeatureName(new Feature("F"), "NewName");
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGetMetricsExport_throwUnsupportedOperation() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data"));
        faxe.getMetrics(f, Metrics.ALL, new Feature("feature"), true);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testCheckConsistency_throwUnsupportedOperation() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data")));

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/data"));
        faxe.checkConsistency(f);
    }

    @Test
    public void testSerializeEAList2JSON() {
        // Creating JSON object with
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);

        File f_fm = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f_fm));

        faxe.serializeToJSON();
    }

    @Test
    public void testSerializeEAList2JSON_FAXE() {
        // Creating JSON object with
        File f = new File(new File("").getAbsolutePath().concat("/src/main/java/se/gu"));
        FAXE faxe = new FAXE(f);

        File f_fm = new File(new File("").getAbsolutePath().concat("/src/main/java/se/gu/faxe"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f_fm));

        faxe.serializeToJSON();
    }

    @Test
    public void testSerializeEAList2JSON_BitcoinWallet() {
        // Creating JSON object with
        File f = new File("C:/Users/Tobias/git/ea-bitcoin-wallet/Bitcoin-wallet/src/de/schildbach/wallet");
        FAXE faxe = new FAXE(f);

        File f_fm = new File("C:/Users/Tobias/git/ea-bitcoin-wallet/Bitcoin-wallet/src/de/schildbach/wallet");
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f_fm));

        faxe.serializeToJSON();
    }

    @Test
    public void testToString() {
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/backup")));
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f));

        System.out.println(faxe.toString());
    }

    @Test
    public void testGetMetrics_SD() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);

        double sd = faxe.getMetrics(f, Metrics.SD, new Feature("Fee"));

        Assert.assertEquals(sd, 44.0);
    }

    @Test
    public void testGetMetrics_TD() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);

        double td = faxe.getMetrics(f, Metrics.TD, new Feature("Fee"));

        Assert.assertEquals(td, 32.0);
    }

    @Test
    public void testGetMetrics_NoFiA() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        double NoFiA = faxe.getMetrics(f, Metrics.NoFiA, new Feature("BitcoinBalance"));

        Assert.assertEquals(NoFiA, 2.0);
    }

    @Test
    public void testGetMetrics_NoAF() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        double NoFiA = faxe.getMetrics(f, Metrics.NoAF, new Feature("BitcoinBalance"));

        Assert.assertEquals(NoFiA, 2.0);
    }

    @Test
    public void testGetMetrics_NoFoA() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.NoFoA, new Feature("Bluetooth::Codecs")), 1.0);
    }

    @Test
    public void testGetMetrics_LoFC() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/service"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.LoFC, new Feature("AddressBook")), 15.0);
    }

    @Test
    public void testGetMetrics_AvgND() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.AvgND, new Feature("BackupWallet")), 1.833, 0.001);
    }

    @Test
    public void testGetMetrics_MaxND() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.MaxND, new Feature("BackupWallet")), 4.0);
    }

    @Test
    public void testGetMetrics_MinND() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.MinND, new Feature("BackupWallet")), 1.0);
    }

    @Test
    public void testGetMetrics_NoF() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.NoF, null), 10.0);
    }

    @Test
    public void testGetMetrics_pAvgLoFC() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.pAvgLoFC, null), 57.3);
    }

    @Test
    public void testGetMetrics_pAvgND() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.pAvgND, null), 1.566, 0.001);
    }

    @Test
    public void testGetMetrics_pAvgSD() {
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.pAvgSD, null), 2.5);
    }

    @Test
    public void testGetEmbeddedAnnotations() {
        // TODO - Create a test which checks that entries are not added multiple times. E.g. through constructor and then getEmbeddedAnnotations again
    }

}