package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;

import java.io.File;
import java.io.IOException;

public class NumberOfFeaturesTest {

    @Test
    public void testCalculateNoF_File_WalletBalanceFragment(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_File_WalletViewModel(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletViewModel.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_File_RequestCoinsFragment(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\RequestCoinsFragment.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 13);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_scan(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\scan"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\scan"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_ui(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 55);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_bitcoinWallet(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));

        try {
            // FeatureDashboard reports 63, but here added LPQ Bluetooth::Codecs -> 64
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}