package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class NumberOfFileAnnotationsTest {

    @Test
    public void testCalculateNoFiA_bitcoinWallet_AppLog() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("AppLog");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoFiA_bitcoinWallet_NonExistingFeature() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("NonExistingFeature");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCalculateNoFiA_FAXE_NonExistingFeature() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\main\\java\\se\\gu\\faxe\\metrics"));
        Feature feature = new Feature("NonExistingFeature");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCalculateNoFiA_FAXE_ScatteringDegree() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\main\\java\\se\\gu\\faxe\\metrics"));
        Feature feature = new Feature("ScatteringDegree");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoFiA_TestData_TestData() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java"));
        Feature feature = new Feature("TestData");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoFiA_TestData_DummyFeature() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java"));
        Feature feature = new Feature("DummyFeature");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNoFiA_TestData_NoFeatureName() {
        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\java"));
        Feature feature = new Feature("NoFeatureName");
        try {
            Assert.assertEquals(NumberOfFileAnnotations.calculateNoFiA(searchPath, feature/*, true*/), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}