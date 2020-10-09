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

import com.scalified.tree.TreeNode;
import se.gu.faxe.Annotation;
import se.gu.faxe.AnnotationFolder;
import se.gu.faxe.Asset;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Number of Folder Annotations: total number of folder annotations directly referencing the feature.
 * --------------------------------------------------------------------------------------------------
 * I.e. the number of appearances of the given feature in all feature-to-folder mapping files
 */

public class NumberOfFolderAnnotations {

    /**
     * Calculate Number of Folder Annotations: total number of folder annotations directly referencing the feature.
     * @param searchedPath Path to create metric from
     * @param searchFeature Searched feature name
     * @return Metric for Number of Folder Annotations of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateNoFoA(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) throws IOException {
        return calculateNoFoA(fullAssetTree, searchedPath, searchFeature, false);
    }

    /**
     * Calculate Number of Folder Annotations: total number of folder annotations directly referencing the feature.
     * @param searchedPath Path to create metric from
     * @param searchFeature Searched feature name
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Metric for Number of Folder Annotations of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateNoFoA(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature, boolean printFoundLocation) throws IOException {
        int noFoA = 0;

        if(!searchedPath.exists()){
            throw new IOException("NumberOfFolderAnnotations::calculateNoFoA ERROR: Given input path " +searchedPath +" not existing!");
        }

        // Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode = fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("NumberOfFolderAnnotations::calculateNoFoA ERROR: Given inout path " +searchedPath +" not existing in fullAssetTree!");
        }

        // Iterate tree and gather scattering information
        for (TreeNode<Asset> node : searchRootNode) {
            //System.out.println("Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                if(annotation.getClass().equals(AnnotationFolder.class)) {
                    if (annotation.getLinkedFeatures().contains(searchFeature)) {
                        noFoA++;
                        if (printFoundLocation) {
                            System.out.println("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());
                        }
                    }
                }
            }
        }

        return noFoA;
    }

}
