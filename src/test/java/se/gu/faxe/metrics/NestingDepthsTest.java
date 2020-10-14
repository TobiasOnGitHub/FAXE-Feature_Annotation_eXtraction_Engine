package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class NestingDepthsTest {

    @Test
    public void testCalculateAvgND_bitcoinWallet_to_WalletBalanceFragment_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java"));
        Feature feature = new Feature("DonateCoins");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCalculateAvgND_bitcoinWallet_to_WalletBalanceFragment_NotExistingFeature() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java"));
        Feature feature = new Feature("NotExistingFeature");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0.0);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAvgND_bitcoinWallet_to_ui_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        Feature feature = new Feature("DonateCoins");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAvgND_bitcoinWallet_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("DonateCoins");

        try {
            // Pre-verification of files serving for the main result
            // Constants.java  - 1 appearance with level 1
//            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), new File(searchPath.getAbsolutePath().concat("\\Constants.java")), feature/*, true*/), 1.0);
            // WalletBalanceFragment.java - 3 appearance with level 2
//            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), new File(searchPath.getAbsolutePath().concat("\\ui\\WalletBalanceFragment.java")), feature/*, true*/), 2.0);
            // SendCoinsActivity.java - 1 appearance with level 2
//            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), new File(searchPath.getAbsolutePath().concat("\\ui\\send\\SendCoinsActivity.java")), feature/*, true*/), 2.0);
            // InactivityNotificationService.java - 7 appearance with level 1+1+2+2+2+2+1
//            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), new File(searchPath.getAbsolutePath().concat("\\service\\InactivityNotificationService.java")), feature/*, true*/), 1.57,0.01);

            // Main Test:
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.666, 0.001);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 2.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAvgND_ui_to_WalletBalanceFragment_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java"));
        Feature feature = new Feature("DonateCoins");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAvgND_bitcoinWallet_to_SweepWalletActivity_SweepPaperWallets() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\send\\SweepWalletActivity.java"));
        Feature feature = new Feature("SweepPaperWallets");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAvgND_util_to_WalletUtils_BackupWallet() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\util"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\util\\WalletUtils.java"));
        Feature feature = new Feature("BackupWallet");

        try {
            Assert.assertEquals(NestingDepths.calculateAvgND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0.833, 0.001);
            Assert.assertEquals(NestingDepths.calculateMaxND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 3.0);
            Assert.assertEquals(NestingDepths.calculateMinND(faxe.getKnownAssets(), searchPath, feature/*, true*/), 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}