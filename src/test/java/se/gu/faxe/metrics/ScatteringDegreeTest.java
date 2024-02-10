package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class ScatteringDegreeTest {

    @Test
    public void testCalculateSD_File_SendCoinsActivity(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsActivity.java"));
        Feature feature = new Feature("DonateCoins");
        try {
            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/), 1); // Number derived from FeatureDashboard
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateSD_File_WalletBalanceFragment(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"));
        Feature feature = new Feature("DonateCoins");
        int sd = 0;
        try {
            sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 3); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateSD_Folder_ui_FeatureDonateCoins(){
        
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        Feature feature = new Feature("DonateCoins");
        int sd = 0;
        try {
            sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 4); // Number 4 derived from FeatureDashboard
    }

    @Test
    public void testCalculateSD_Folder_ui_Fee(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        Feature feature = new Feature("Fee");

        try {
            // Calculate Scattering Degree over individual files from folder "ui" to be able to determine overall TD by hand
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/FeeCategory.java"), feature, true), 1);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/SweepWalletFragment.java"), feature, true), 6);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsFragment.java"), feature, true), 11);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsViewModel.java"), feature, true), 3);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsActivity.java"), feature, true), 4);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/RaiseFeeDialogFragment.java"), feature, true), 1);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/send/MaintenanceDialogFragment.java"), feature, true), 2);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/WalletTransactionsFragment.java"), feature, true), 2);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"), feature, true), 1);
//            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(),new File(".../FAXE-Feature_Annotation_eXtraction_Engine/src/test/testdata/bitcoin-wallet/ui/TransactionsAdapter.java"), feature, true), 13);

            // Final TD calculation for folder ui
            Assert.assertEquals(ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/), 44);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateSD_Folder_service(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/service"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/service"));
        Feature feature = new Feature("DonateCoins");
        int sd = 0;
        try {
            sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 6);
    }

    @Test
    public void testCalculateSD_Folder_wallet(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        Feature feature = new Feature("DonateCoins");
        int sd = 0;
        try {
            sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 11); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateAverageSD_File_SendCoinsActivity(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsActivity.java"));
        try {
            Assert.assertEquals(ScatteringDegree.calculateAverageSD(faxe.getKnownAssets(), searchPath/*, true*/), 2.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateAverageSD_Folder_Send(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send"));
        try {
            Assert.assertEquals(ScatteringDegree.calculateAverageSD(faxe.getKnownAssets(), searchPath /*,true*/), 7.653, 0.001);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateSD_Folder_wallet_real(){
        // Test complete project (root folder)
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));

        double sd = 0;
        try {
            sd = ScatteringDegree.calculateAverageSD(faxe.getKnownAssets(), searchPath/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Assert.assertEquals(ScatteringDegree.calculateAverageSD(faxe.getKnownAssets(), searchPath /*,true*/), 12.843, 0.001);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}