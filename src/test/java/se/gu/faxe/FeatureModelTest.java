package se.gu.faxe;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FeatureModelTest {

    @Test
    public void testFeatureModel(){
        String nonFeatureFilePath = new File("").getAbsolutePath();
        FeatureModel fm = new FeatureModel(new File(nonFeatureFilePath));

        // Implicit test that FM was not generated
        Assert.assertNull(fm.getFeatureModelPath());
    }

    @Test
    public void testGetFeatureModelPath(){
        String filePathOrg = new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr");
        FeatureModel fm = new FeatureModel(new File(filePathOrg));

        File filePathFM = fm.getFeatureModelPath();

        Assert.assertTrue(filePathOrg.equals(filePathFM.getAbsolutePath()));
    }

    @Test
    public void testLineStartsWithLetter(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Assert.assertTrue(fm.lineStartsWithLetterOrDigit("String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit(" String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit("    String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit("\tString"));
        Assert.assertTrue(fm.lineStartsWithLetterOrDigit("1String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit(" 2String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit("    3String"));
        Assert.assertFalse(fm.lineStartsWithLetterOrDigit("\t4String"));
    }

    @Test
    public void testLineStartsWithSpaces(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Assert.assertTrue(fm.lineStartsWithSpaces("   String"));
        Assert.assertTrue(fm.lineStartsWithSpaces("    String"));
        Assert.assertFalse(fm.lineStartsWithSpaces("String"));
        Assert.assertFalse(fm.lineStartsWithSpaces("1String"));
    }


    @Test
    public void testVerifyFeatureModelFile_Valid_featuremodel_valid() {
        FeatureModel fm = new FeatureModel();
        File fmPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr"));

        boolean ret = fm.verifyFeatureModelFile(fmPath);

        Assert.assertTrue(ret);
    }

    @Test
    public void testVerifyFeatureModelFile_Invalid_featuremodel_invalid_spaces() {
        FeatureModel fm = new FeatureModel();
        File fmPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_invalid_spaces.feature-model"));

        boolean ret = fm.verifyFeatureModelFile(fmPath);

        Assert.assertFalse(ret);
    }

        @Test
    public void testLoadFeatureModel_Valid_Functionality() {

        String strTestFM = new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr");
        File testFMFile = new File(strTestFM);

        Boolean ret = false;

        if(testFMFile.exists()) {
            FeatureModel fm = new FeatureModel();
            try {
                ret = fm.loadFeatureModel(testFMFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error with test feature model file " +testFMFile.toString());
        }

        Assert.assertEquals(ret, Boolean.TRUE);
    }

    @Test(expectedExceptions = IOException.class)
    public void testLoadFeatureModel_Invalid_EmptyInputFile() throws IOException {

        File testFMFile = new File("");

        FeatureModel fm = new FeatureModel();
        fm.loadFeatureModel(testFMFile);
    }

    @Test
    public void testLoadFeatureModel_Invalid_NonFMFile() throws IOException {
        File testNonFMFile = new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_textonly.cfr"));
        FeatureModel fm = new FeatureModel();

        fm.loadFeatureModel(testNonFMFile);
    }

    @Test
    public void testFeatureExistInFeatureModel_Valid_RootNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel(new Feature("featuremodel_valid"));

        Assert.assertTrue(ret);
    }

    @Test
    public void testFeatureExistInFeatureModel_Valid_MiddleNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel(new Feature("House"));

        Assert.assertTrue(ret);
    }

    @Test
    public void testFeatureExistInFeatureModel_Valid_LeafNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel(new Feature("Countryside"));

        Assert.assertTrue(ret);
    }

    @Test
    public void testTestFeatureExistInFeatureModel_Valid_String_RootNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel("featuremodel_valid");

        Assert.assertTrue(ret);
    }

    @Test
    public void testTestFeatureExistInFeatureModel_Valid_String_MiddleNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel("Road");

        Assert.assertTrue(ret);
    }

    @Test
    public void testTestFeatureExistInFeatureModel_Valid_String_LeafNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Boolean ret = fm.featureExistInFeatureModel("Countryside");

        Assert.assertTrue(ret);
    }

    @Test
    public void testGetFeature_Valid_RootNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Feature featureFromFM = fm.getFeature("featuremodel_valid");
        Feature localFeature = new Feature("featuremodel_valid");

        Assert.assertEquals(featureFromFM, localFeature);
    }

    @Test
    public void testGetFeature_Valid_MiddleNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Feature featureFromFM = fm.getFeature("House");
        Feature localFeature = new Feature("House");

        Assert.assertEquals(featureFromFM, localFeature);
    }

    @Test
    public void testGetFeature_Valid_LeafNode() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Feature featureFromFM = fm.getFeature("Plane::Window");
        Feature localFeature = new Feature("Plane::Window");

        Assert.assertEquals(featureFromFM, localFeature);
    }

    @Test
    public void testGetFeatureByName_Valid_FeatureDoor() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        List<Feature> featureList = fm.getFeatureByName("Door");

        Assert.assertEquals(featureList.size(), 3);

        Assert.assertEquals(featureList.get(0).getLpq(),"House::Door");
        Assert.assertEquals(featureList.get(1).getLpq(),"Plane::Door");
        Assert.assertEquals(featureList.get(2).getLpq(),"Car::Door");
    }

    @Test
    public void testGetFeatureByName_Valid_FeatureUnknown() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        List<Feature> featureList = fm.getFeatureByName("Unknown");

        Assert.assertEquals(featureList.size(), 0);
    }

    @Test
    public void testGenerateLPQs_Valid(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Assert.assertTrue(fm.generateLPQs());
    }

    @Test
    public void testGenerateLPQs_Valid_LPQLevel1(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Assert.assertTrue(fm.generateLPQs());

        Assert.assertTrue(fm.featureExistInFeatureModel("featuremodel_valid"));
        Assert.assertTrue(fm.featureExistInFeatureModel("House"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Boat"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Water"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Plane"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Air"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Car"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Road"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Countryside"));
        Assert.assertTrue(fm.featureExistInFeatureModel("City"));

    }

    @Test
    public void testGenerateLPQs_Valid_LPQLevel2(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        Assert.assertTrue(fm.generateLPQs());

        Assert.assertTrue(fm.featureExistInFeatureModel("House::Door"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Plane::Door"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Car::Door"));
        Assert.assertTrue(fm.featureExistInFeatureModel("House::Window"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Boat::Window"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Plane::Window"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Car::Window"));
    }

    @Test
    public void testGenerateLPQs_Valid_LPQLevel3(){
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_lpq3.cfr")));

        Assert.assertTrue(fm.generateLPQs());

        Assert.assertTrue(fm.featureExistInFeatureModel("Feature1::FeatureA::FeatureA1"));
        Assert.assertTrue(fm.featureExistInFeatureModel("Feature2::FeatureA::FeatureA1"));
    }
}