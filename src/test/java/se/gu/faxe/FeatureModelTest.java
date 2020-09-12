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

        Boolean ret = fm.featureExistInFeatureModel(new Feature("Door"));

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

        Feature featureFromFM = fm.getFeature("Window");
        Feature localFeature = new Feature("Window");

        Assert.assertEquals(featureFromFM, localFeature);
    }

    @Test
    public void testGetFeatureByName() {
        FeatureModel fm = new FeatureModel(new File(new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr")));

        List<Feature> featureList = fm.getFeatureByName("Door");


    }
}