package se.gu.faxe;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FeatureModelTest {

    @Test
    public void testLoadFeatureModel_Functionality() {

        String strTestFM = new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr");
        File testFMFile = new File(strTestFM);

        Boolean ret = false;

        if(testFMFile.exists()) {
            FeatureModel fm = new FeatureModel();
            ret = fm.loadFeatureModel(testFMFile);
        } else {
            System.out.println("Error with test feature model file " +testFMFile.toString());
        }

        Assert.assertEquals(ret, Boolean.TRUE);
    }

    @Test
    public void testLoadFeatureModel_Invalid_EmptyInputFile(){

        File testFMFile = new File("");

        Boolean ret = false;

        if(testFMFile.exists()) {
            FeatureModel fm = new FeatureModel();
            ret = fm.loadFeatureModel(testFMFile);
        } else {
            System.out.println("Error with test feature model file " +testFMFile.toString());
        }

        Assert.assertFalse(ret);
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