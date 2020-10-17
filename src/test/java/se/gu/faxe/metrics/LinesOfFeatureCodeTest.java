package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class LinesOfFeatureCodeTest {

    @Test
    public void testCalculateLoFC_Line_InactivityNotificationService_Fee() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service\\InactivityNotificationService.java"));
        Feature feature = new Feature("Fee");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_Fragment_BlockchainState_BlockchainSync() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service\\BlockchainState.java"));
        Feature feature = new Feature("BlockchainSync");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_Fragment_InactivityNotificationService_DonateCoins() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service\\InactivityNotificationService.java"));
        Feature feature = new Feature("DonateCoins");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 43);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_File_Logging_BitcoinBalance() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\Logging.java"));
        Feature feature = new Feature("BitcoinBalance");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 96);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_File_Logging_AppLog() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\Logging.java"));
        Feature feature = new Feature("AppLog");

        try {
            // AppLog is mapped via feature-to-file as well as in text annotations: file is 96 lines long, text annotation 65 lines
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 96+65);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_Folder_subfolder_Subfolder() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-folder"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-folder\\subfolder"));
        Feature feature = new Feature("Subfolder");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 253);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFC_Folder_featureToFolder_MainFolder() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-folder"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-folder"));
        Feature feature = new Feature("MainFolder");

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFC(faxe.getKnownAssets(), searchPath, feature/*, true*/), 253+2+378);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateLoFCTotal_File_BlockchainService() {

        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service\\BlockchainService.java"));

        try {
            Assert.assertEquals(LinesOfFeatureCode.calculateLoFCTotal(faxe.getKnownAssets(), searchPath, true), 181);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testCalculateLoFCTotal_File_BlockchainState() {
//
//        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service"));
//        FAXE faxe = new FAXE(projectRoot);
//
//        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\service\\BlockchainState.java"));
//
//        try {
//            Assert.assertEquals(LinesOfFeatureCode.calculateLoFCTotal(faxe.getKnownAssets(), searchPath, true), 5);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}