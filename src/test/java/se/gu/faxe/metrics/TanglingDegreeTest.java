package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;

public class TanglingDegreeTest {

    @Test
    public void testCalculateTD_File_SweepWalletFragment() {
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui\\send\\SweepWalletFragment.java");
        Feature feature = new Feature("DonateCoins");
        int td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(td, 0); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_SendCoinsActivity() {
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui\\send\\SendCoinsActivity.java");
        Feature feature = new Feature("DonateCoins");
        int td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(td, 2); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_File_WalletBalanceFragment() {
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java");
        Feature feature = new Feature("DonateCoins");
        int td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(td, 6); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_ui() {
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        Feature feature = new Feature("DonateCoins");
        int td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(td, 6); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateTD_Folder_wallet() {
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet");
        Feature feature = new Feature("DonateCoins");
        int td = TanglingDegree.calculateTD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(td, 16); // Number derived from FeatureDashboard
    }

}