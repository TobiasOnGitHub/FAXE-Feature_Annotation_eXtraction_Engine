package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class TanglingDegreeTest {

    @Test
    public void testCalculateTD_File_SweepWalletFragment() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SweepWalletFragment.java"));
        Feature feature = new Feature("DonateCoins");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 0); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_SendCoinsActivity() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsActivity.java"));
        Feature feature = new Feature("DonateCoins");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 2); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_WalletBalanceFragment() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java"));
        Feature feature = new Feature("DonateCoins");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 6); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_FeeCategory() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/FeeCategory.java"));
        Feature feature = new Feature("Fee");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 3); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_SendCoinsFragment() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsFragment.java"));
        Feature feature = new Feature("Fee");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 21); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_ui_FeatureDonateCoins() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        Feature feature = new Feature("DonateCoins");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 6); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_wallet() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet"));
        Feature feature = new Feature("DonateCoins");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 16); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_Send() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send"));
        Feature feature = new Feature("Fee");
        int td = 0;
        try {
            td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(td, 23); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_ui_FeatureFee() {
        File projectRoot = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        Feature feature = new Feature("Fee");

        try {
            // Calculate Tangling Degree over individual files from folder "ui" to be able to determine overall TD by hand

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/FeeCategory.java")), feature, true), 3);
//            // Feature tangled: [Economic, Priority, Normal]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SweepWalletFragment.java")), feature, true), 7);
//            // Feature tangled: [Denomination, SetPIN, SweepPaperWallet, EmptyWallet, SendCoins, BitcoinBalance, Normal]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsFragment.java")), feature, true), 21);
//            // Feature tangled: [BIP72, BlockchainSync, Bluetooth, Codecs, BackupWallet, SendCoins, Priority, BIP70, ExchangeRates, NFC, Normal, Denomination, DustSpamProtection, Economic, base58, AddressBook, SetPIN, EmptyWallet, BitcoinBalance, CurrencyCalculator, PaymentURL]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsViewModel.java")), feature, true), 5);
//            // Feature tangled: [AddressBook, SendCoins, ExchangeRates, BitcoinBalance, Normal]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/SendCoinsActivity.java")), feature, true), 2);
//            // Feature tangled: [DonateCoins, SendCoins]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/RaiseFeeDialogFragment.java")), feature, true), 5);
//            // Feature tangled: [Denomination, BlockchainSync, BackupWallet, SetPIN, Priority]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/send/MaintenanceDialogFragment.java")), feature, true), 3);
//            // Feature tangled: [Denomination, BackupWallet, SetPIN]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletTransactionsFragment.java")), feature, true), 12);
//            // Feature tangled: [QRCode, Codecs, base58, BackupWallet, AddressBook, ViewAll, IssueReporter, BlockExplorer, BackupReminder, TransactionsFilter, ViewSent, ViewReceived]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletBalanceFragment.java")), feature, true), 6);
//            // Feature tangled: [Denomination, BlockchainSync, DonateCoins, SendCoins, BitcoinBalance, ExchangeRates]

//            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(),new File(new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/TransactionsAdapter.java")), feature, true), 7);
//            // Feature tangled: [DustSpamProtection, BackupWallet, AddressBook, ShowDisclaimer, ExchangeRates, BackupReminder, TransactionsFilter]

            // Final TD calculation for folder ui
            Assert.assertEquals(TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/), 32);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}