package se.gu.faxe;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.metrics.Metrics;

import java.io.File;

public class FAXETest {

    @Test
    public void FAXE(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));

        FAXE faxe = new FAXE(f);

        File testMetricsOnThisFile = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        //File testMetricsOnThisFile = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"));
        faxe.getMetrics(testMetricsOnThisFile, Metrics.SD, new Feature("SendCoins"));
        //System.out.println("x");
    }

    @Test
    public void testSerializeEAList2JSON() {
        // Creating JSON object with

        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);
        //faxe.getEmbeddedAnnotationsFromTextAsset(new Asset(f));

        File f_fm = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f_fm));

        faxe.serializeToJSON();

        //System.out.println("JSON: " +json);
    }

//    @Test
//    public void testFileExchangeRatesFragmentJava(){
//        FAXE2 faxe = new FAXE2();
//
//        File file = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/ExchangeRatesFragment.java"));
//        faxe.getEmbeddedAnnotationsFromTextAsset(new Asset(file));
//    }


    @Test
    public void testToString(){
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/backup")));
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f));

        System.out.println(faxe.toString());
    }

    @Test
    public void testGetMetrics_SD(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);

        double sd = faxe.getMetrics(f, Metrics.SD, new Feature("Fee"));

        Assert.assertEquals(sd, 44.0);
    }

    @Test
    public void testGetMetrics_TD(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(f);

        double td = faxe.getMetrics(f, Metrics.TD, new Feature("Fee"));

        Assert.assertEquals(td, 32.0);
    }

    @Test
    public void testGetMetrics_NoFiA(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        double NoFiA = faxe.getMetrics(f, Metrics.NoFiA, new Feature("BitcoinBalance"));

        Assert.assertEquals(NoFiA, 1.0);
    }

    @Test
    public void testGetMetrics_NoAF(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        double NoFiA = faxe.getMetrics(f, Metrics.NoAF, new Feature("BitcoinBalance"));

        Assert.assertEquals(NoFiA, 2.0);
    }

    @Test
    public void testGetMetrics_NoFoA(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.NoFoA, new Feature("Bluetooth::Codecs")), 1.0);
    }

    @Test
    public void testGetMetrics_LoFC(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/service"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.LoFC, new Feature("AddressBook")), 15.0);
    }

    @Test
    public void testGetMetrics_AvgND(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.AvgND, new Feature("BackupWallet")), 1.833, 0.001);
    }

    @Test
    public void testGetMetrics_MaxND(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.MaxND, new Feature("BackupWallet")), 4.0);
    }

    @Test
    public void testGetMetrics_MinND(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util/"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.MinND, new Feature("BackupWallet")), 1.0);
    }

    @Test
    public void testGetMetrics_NoF(){
        File f = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/util"));
        FAXE faxe = new FAXE(f);

        Assert.assertEquals(faxe.getMetrics(f, Metrics.NoF, null), 10.0);
    }

    @Test
    public void testGetEmbeddedAnnotations(){
        // TODO - Create a test which checks that entries are not added multiple times. E.g. through constructor and then getEmbeddedAnnotations again
    }

}