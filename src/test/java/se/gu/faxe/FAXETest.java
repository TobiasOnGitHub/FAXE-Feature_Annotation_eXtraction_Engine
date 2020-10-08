package se.gu.faxe;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.metrics.Metrics;

import java.io.File;

public class FAXETest {

    @Test
    public void FAXE(){
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));

        FAXE faxe = new FAXE(f);

        File testMetricsOnThisFile = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        //File testMetricsOnThisFile = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java"));
        faxe.getMetrics(testMetricsOnThisFile, Metrics.SD, new Feature("SendCoins"));
        //System.out.println("x");
    }

    @Test
    public void testSerializeEAList2JSON() {
        // Creating JSON object with

        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(f);
        //faxe.getEmbeddedAnnotationsFromTextAsset(new Asset(f));

        File f_fm = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f_fm));

        faxe.serializeToJSON();

        //System.out.println("JSON: " +json);
    }

//    @Test
//    public void testFileExchangeRatesFragmentJava(){
//        FAXE2 faxe = new FAXE2();
//
//        File file = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\ExchangeRatesFragment.java"));
//        faxe.getEmbeddedAnnotationsFromTextAsset(new Asset(file));
//    }


    @Test
    public void testToString(){
        FAXE faxe = new FAXE(new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\backup")));
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\_.feature-model"));
        faxe.getEmbeddedAnnotationsFeatureModel(new Asset(f));

        System.out.println(faxe.toString());
    }

    @Test
    public void testGetMetrics_SD(){
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(f);

        int sd = faxe.getMetrics(f, Metrics.SD, new Feature("Fee"));

        Assert.assertEquals(sd, 44);
    }

    @Test
    public void testGetMetrics_TD(){
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(f);

        int td = faxe.getMetrics(f, Metrics.TD, new Feature("Fee"));

        Assert.assertEquals(td, 32);
    }

    @Test
    public void testGetMetrics_NoFiA(){
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(f);

        int NoFiA = faxe.getMetrics(f, Metrics.NoFiA, new Feature("BitcoinBalance"));

        Assert.assertEquals(NoFiA, 1);
    }

}