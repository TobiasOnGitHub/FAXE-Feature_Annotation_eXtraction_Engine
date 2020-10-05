package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;

public class ScatteringDegreeTest {

    @Test
    public void testCalculateSD_File_WalletBalanceFragment(){
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletBalanceFragment.java");
        Feature feature = new Feature("DonateCoins");
        int sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(sd, 3); // Number 4 derived from FeatureDashboard
    }

    @Test
    public void testCalculateSD_Folder_ui(){
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\ui");
        Feature feature = new Feature("DonateCoins");
        int sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(sd, 4); // Number 4 derived from FeatureDashboard
    }

    @Test
    public void testCalculateSD_Folder_service(){
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\service");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet\\service");
        Feature feature = new Feature("DonateCoins");
        int sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(sd, 7); // Number 4 derived from FeatureDashboard
    }

    @Test
    public void testCalculateSD_Folder_wallet(){
        File projectRoot = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet");
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File("C:\\Users\\Tobias\\IdeaProjects\\FAXE-Feature_Annotation_eXtraction_Engine\\src\\test\\testdata\\bitcoin-wallet");
        Feature feature = new Feature("DonateCoins");
        int sd = ScatteringDegree.calculateSD(faxe.getKnownAssets(), searchPath, feature/*, true*/);

        Assert.assertEquals(sd, 12); // Number 4 derived from FeatureDashboard
    }

}