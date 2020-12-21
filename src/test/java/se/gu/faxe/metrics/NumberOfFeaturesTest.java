package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class NumberOfFeaturesTest {

    @Test
    public void testCalculateNoF_File_WalletBalanceFragment(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_File_WalletViewModel(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletViewModel.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_File_RequestCoinsFragment(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/RequestCoinsFragment.java"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 13);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_scan(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/scan"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/scan"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_ui(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));

        try {
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 55);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoF_Folder_bitcoinWallet(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));

        try {
            // FeatureDashboard reports 63, but here added LPQ Bluetooth::Codecs -> 64
            Assert.assertEquals(NumberOfFeatures.calculateNoF(faxe.getKnownAssets(), searchPath/*, true*/), 64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUniqueFeaturesSet_File_Constants(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/Constants.java"));

        Set<String> uniqueFeatures = null;
        try {
            uniqueFeatures = NumberOfFeatures.getUniqueFeaturesSet(faxe.getKnownAssets(), searchPath/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(uniqueFeatures);
        Assert.assertEquals(uniqueFeatures.size(), 14);
        Assert.assertTrue(uniqueFeatures.contains("BlockChainSync"));
        Assert.assertTrue(uniqueFeatures.contains("ExchangeRates"));
        Assert.assertTrue(uniqueFeatures.contains("SweepPaperWallets"));
        Assert.assertTrue(uniqueFeatures.contains("BlockExplorer"));
        Assert.assertTrue(uniqueFeatures.contains("BackupWallet"));
        Assert.assertTrue(uniqueFeatures.contains("Codecs"));
        Assert.assertTrue(uniqueFeatures.contains("base58"));
        Assert.assertTrue(uniqueFeatures.contains("Fee"));
        Assert.assertTrue(uniqueFeatures.contains("SetDefault"));
        Assert.assertTrue(uniqueFeatures.contains("DonateCoins"));
        Assert.assertTrue(uniqueFeatures.contains("IssueReporter"));
        Assert.assertTrue(uniqueFeatures.contains("SkipDiscovery"));
        Assert.assertTrue(uniqueFeatures.contains("BitcoinBalance"));
        Assert.assertTrue(uniqueFeatures.contains("NotifyReceived"));

    }


    @Test
    public void testGetUniqueFeaturesSet_Folder_featureToFile(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/feature-to-file"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/feature-to-file"));

        Set<String> uniqueFeatures = null;
        try {
            uniqueFeatures = NumberOfFeatures.getUniqueFeaturesSet(faxe.getKnownAssets(), searchPath/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(uniqueFeatures);
        Assert.assertEquals(uniqueFeatures.size(), 11);
        Assert.assertTrue(uniqueFeatures.contains("TangleHer"));
        Assert.assertTrue(uniqueFeatures.contains("featureB"));
        Assert.assertTrue(uniqueFeatures.contains("TestData"));
        Assert.assertTrue(uniqueFeatures.contains("featureLine1"));
        Assert.assertTrue(uniqueFeatures.contains("TangleMe"));
        Assert.assertTrue(uniqueFeatures.contains("featureA"));
        Assert.assertTrue(uniqueFeatures.contains("featureLine4"));
        Assert.assertTrue(uniqueFeatures.contains("DummyFeature"));
        Assert.assertTrue(uniqueFeatures.contains("featureLine2"));
        Assert.assertTrue(uniqueFeatures.contains("TangleHim"));
        Assert.assertTrue(uniqueFeatures.contains("featureLine3"));

    }

    @Test
    public void testGetUniqueFeaturesSet_Folder_featureToFolder(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/feature-to-folder"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/feature-to-folder"));

        Set<String> uniqueFeatures = null;
        try {
            uniqueFeatures = NumberOfFeatures.getUniqueFeaturesSet(faxe.getKnownAssets(), searchPath/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(uniqueFeatures);
        Assert.assertEquals(uniqueFeatures.size(), 24);
        Assert.assertTrue(uniqueFeatures.contains("New"));
        Assert.assertTrue(uniqueFeatures.contains("BlockchainSync"));
        Assert.assertTrue(uniqueFeatures.contains("Codecs"));
        Assert.assertTrue(uniqueFeatures.contains("Bluetooth"));
        Assert.assertTrue(uniqueFeatures.contains("BackupWallet"));
        Assert.assertTrue(uniqueFeatures.contains("Old"));
        Assert.assertTrue(uniqueFeatures.contains("Fee"));
        Assert.assertTrue(uniqueFeatures.contains("IssueReporter"));
        Assert.assertTrue(uniqueFeatures.contains("MainFolder"));
        Assert.assertTrue(uniqueFeatures.contains("ExchangeRates"));
        Assert.assertTrue(uniqueFeatures.contains("BlockExplorer"));
        Assert.assertTrue(uniqueFeatures.contains("FeatureA"));
        Assert.assertTrue(uniqueFeatures.contains("BlockChainSync"));
        Assert.assertTrue(uniqueFeatures.contains("ResetBlockChain"));
        Assert.assertTrue(uniqueFeatures.contains("DonateCoins"));
        Assert.assertTrue(uniqueFeatures.contains("base58"));
        Assert.assertTrue(uniqueFeatures.contains("SkipDiscovery"));
        Assert.assertTrue(uniqueFeatures.contains("Subfolder"));
        Assert.assertTrue(uniqueFeatures.contains("BitcoinBalance"));
        Assert.assertTrue(uniqueFeatures.contains("SweepPaperWallets"));
        Assert.assertTrue(uniqueFeatures.contains("SetDefault"));
        Assert.assertTrue(uniqueFeatures.contains("NotifyReceived"));
        Assert.assertTrue(uniqueFeatures.contains("BackupReminder"));
        Assert.assertTrue(uniqueFeatures.contains("RestoreWallet"));
    }


    @Test
    public void testGetUniqueFeaturesSet_FAXE_project(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/main/java/se/gu/faxe"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/main/java/se/gu/faxe"));

        Set<String> uniqueFeatures = null;
        try {
            uniqueFeatures = NumberOfFeatures.getUniqueFeaturesSet(faxe.getKnownAssets(), searchPath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(uniqueFeatures);

    }
}