package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class NumberOfAnnotatedFilesTest {

    @Test
    public void testCalculateNoFA_bitcoinWallet(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("AppLog");
        int sd = 0;
        try {
            sd = NumberOfAnnotatedFiles.calculateNoFA(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 2); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateNoFA_srcTestJava_TestData(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-file"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-file"));
        Feature feature = new Feature("TestData");
        int sd = 0;
        try {
            sd = NumberOfAnnotatedFiles.calculateNoFA(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 4); // Number derived from FeatureDashboard
    }

}