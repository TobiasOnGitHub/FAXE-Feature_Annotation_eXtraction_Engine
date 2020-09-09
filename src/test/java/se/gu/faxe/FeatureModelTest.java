package se.gu.faxe;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FeatureModelTest {

    @Test
    public void testLoadFeatureModel() {

        String strtestFM = new File("").getAbsolutePath().concat("\\src\\test\\java\\se\\gu\\faxe\\testdata\\featuremodel_valid.cfr");
        File testFM = new File(strtestFM);

        Boolean ret = false;

        if(testFM.exists()) {
            FeatureModel fm = new FeatureModel();
            ret = fm.loadFeatureModel(testFM);
        } else {
            System.out.println("Error with test feature model file " +testFM.toString());
        }

        Assert.assertEquals(ret, Boolean.TRUE);
    }

    @Test
    public void testFeatureExistInFeatureModel() {
    }

    @Test
    public void testTestFeatureExistInFeatureModel() {
    }

    @Test
    public void testGetFeature() {
    }

    @Test
    public void testGetFeatureByName() {
    }
}