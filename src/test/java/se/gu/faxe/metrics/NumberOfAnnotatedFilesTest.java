/*************************************************************
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 *************************************************************/
package se.gu.faxe.metrics;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.gu.faxe.FAXE;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;

public class NumberOfAnnotatedFilesTest {

    @Test
    public void testCalculateNoFA_bitcoinWallet(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));
        Feature feature = new Feature("AppLog");
        int sd = 0;
        try {
            sd = NumberOfAnnotatedFiles.calculateNoFA(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 2); // Number derived from FeatureDashboard
    }

    @Test
    public void testCalculateNoFA_srcTestJava_TestData(){
        File projectRoot = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-file"));
        FAXE faxe = new FAXE(projectRoot);

        File searchPath = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\feature-to-file"));
        Feature feature = new Feature("TestData");
        int sd = 0;
        try {
            sd = NumberOfAnnotatedFiles.calculateNoFA(faxe.getKnownAssets(), searchPath, feature/*, true*/);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(sd, 4); // Number derived from FeatureDashboard
    }

}