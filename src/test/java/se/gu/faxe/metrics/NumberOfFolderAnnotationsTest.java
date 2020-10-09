package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class NumberOfFolderAnnotationsTest {

    @Test
    public void testCalculateNoFoA_bitcoinWallet_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("DonateCoins");
        try {
            Assert.assertEquals(NumberOfFolderAnnotations.calculateNoFoA(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testCalculateNoFoA_bitcoinWallet_BluetoothCodecs() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("Bluetooth::Codecs");
        try {
            Assert.assertEquals(NumberOfFolderAnnotations.calculateNoFoA(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCalculateNoFoA_featureToFolder_MainFolder() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-folder"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-folder"));
        Feature feature = new Feature("MainFolder");
        try {
            Assert.assertEquals(NumberOfFolderAnnotations.calculateNoFoA(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCalculateNoFoA_featureToFolder_FeatureA() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-folder"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\feature-to-folder"));
        Feature feature = new Feature("FeatureA");
        try {
            Assert.assertEquals(NumberOfFolderAnnotations.calculateNoFoA(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}