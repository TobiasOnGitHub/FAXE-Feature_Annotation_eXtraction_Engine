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

import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * As defined by Andam, Berima et. al. (2017)
 * Number of File Annotations: total number of file annotations directly referencing the feature
 * ---------------------------------------------------------------------------------------------
 * This metric counts all appearances of the specific feature in the feature-to-file mapping
 * files.
 */

public class NumberOfFileAnnotations {

    /**
     * Calculate Number of File Annotations: total number of file annotations directly referencing the feature
     * @param searchedPath Path to create metric from
     * @param searchFeature Searched feature name
     * @return Metric for Number of File Annotations of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateNoFiA(File searchedPath, Feature searchFeature) throws IOException {
        return calculateNoFiA(searchedPath, searchFeature, false);
    }

    /**
     * Calculate Number of File Annotations: total number of file annotations directly referencing the feature
     * @param searchedPath Path to create metric from
     * @param searchFeature Searched feature name
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Metric for Number of File Annotations of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateNoFiA(File searchedPath, Feature searchFeature, Boolean printFoundLocation) throws IOException {
        int NoFiA = 0;

        // Check on TreeNode not possible. Information from feature-fo-file mapping file is not stored (from which mapping
        // file the actual annotation is derived.

        if(!searchedPath.exists()){
            throw new IOException("NumberOfFileAnnotations::calculateNoFiA ERROR: Given input path " +searchedPath +" not existing!");
        }

        if (searchedPath.isDirectory()) {
            for (File concreteFile : Objects.requireNonNull(searchedPath.listFiles())) {
                NoFiA += calculateNoFiA(concreteFile, searchFeature, printFoundLocation);
            }
        } else {
            if (searchedPath.getName().endsWith(".feature-to-file")) {
                Scanner scanner = new Scanner(searchedPath);
                while (scanner.hasNextLine()) {
                    String lineFile = scanner.nextLine();
                    if (!lineFile.isEmpty()) {
                        // Found first line with text
                        String lineFeature = scanner.nextLine();
                        while (lineFeature.isEmpty()) {
                            lineFeature = scanner.nextLine();
                        }
                        // Next Line shall contain Features
                        if (lineFeature.contains(searchFeature.getLpq())) {
                            if (printFoundLocation) {
                                System.out.println("   Feature " + searchFeature.toString() + " found in " + searchedPath.getName());
                            }
                            NoFiA++;
                            break;  // Go to next .feature-to-file file
                        }
                    }
                }
                scanner.close();
            }
        }
        return NoFiA;
    }

}
