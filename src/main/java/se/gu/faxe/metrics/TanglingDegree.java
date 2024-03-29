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
import se.gu.faxe.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Tangling Degree (TD) as defined by Liebig, Jörg et. al. (2010). An
 * Analysis of the Variability in Forty Preprocessor-Based Software Product Lines.
 * ----------------------------------------------------------
 * The TD metric is the number of different feature constants
 * that occur in a feature expression. A low TD is preferable,
 * because a high number of tangled feature constants in feature
 * expressions may impair program comprehension.
 */

public class TanglingDegree {

    /**
     * Tangling Degree: number of other features that share the same artifacts (or parts of such)
     * with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param searchFeature Searched feature name
     * @return Tangling Degree of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateTD(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) throws IOException {
        return calculateTD(fullAssetTree, searchedPath, searchFeature, false);
    }

    /**
     * Tangling Degree: number of other features that share the same artifacts (or parts of such)
     * with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param searchFeature Searched feature name
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Tangling Degree of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateTD(TreeNode< Asset > fullAssetTree, File searchedPath, Feature searchFeature, Boolean printFoundLocation) throws IOException {
        HashSet<String> tangledFeatures = new HashSet<>();

        if(!searchedPath.exists()){
            throw new IOException("TanglingDegree::calculateTD ERROR: Given input path " +searchedPath +" not existing!");
        }

        // Reduce Tree to searched Area
        TreeNode<Asset> searchRootNode =fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("TanglingDegree::calculateTD ERROR: Given inout path " +searchedPath +" not existing in fullAssetTree!");
        }
        Collection<? extends TreeNode<Asset>> preOrderedCollection = searchRootNode.preOrdered();
        // Check if searched feature is in Asset
        for (TreeNode<Asset> node : preOrderedCollection) {
            // When searched feature is in Asset, add available feature to tangled map
            List<Annotation> annotations = node.data().getAnnotationList();
            boolean searchedFeatureInAsset = false;
            for(Annotation annotation : annotations){
                if(annotation.getLinkedFeatures().contains(searchFeature)){
                    // Found searched Feature in this Asset -> Asset data to be considered for Tangling Degree
                    searchedFeatureInAsset = true;
                    break;
                }
            }
            if(searchedFeatureInAsset){
                for(Annotation annotation : annotations){
                    for(Feature feature : annotation.getLinkedFeatures()){
                        if(!feature.equals(searchFeature)){          // Skipp searched feature for metric
                            tangledFeatures.add(feature.getLpq());  // Using LPQ as same feature names might appear close to each other.
                            if (printFoundLocation) {
                                System.out.print("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());

                                if (annotation instanceof AnnotationFolder){
                                    // Add all sub-feature to this tangling degree
                                    for (TreeNode<Asset> subNode : node) {
                                        List<Annotation> subAnnotations = subNode.data().getAnnotationList();
                                        for(Annotation subAnnotation : subAnnotations){
                                            for(Feature subFeature : subAnnotation.getLinkedFeatures()){
                                                if(!feature.equals(searchFeature)){
                                                    tangledFeatures.add(subFeature.getLpq());
                                                }
                                            }
                                        }
                                    }
                                }

                                if(annotation instanceof AnnotationLine){
                                    System.out.println(" at line: " + ((AnnotationLine) annotation).getLine());
                                } else if (annotation instanceof AnnotationFragment){
                                    System.out.println(" at lines: " + ((AnnotationFragment) annotation).getStartline() +"-" +((AnnotationFragment) annotation).getEndline());
                                } else if (annotation instanceof AnnotationFile){
                                    System.out.println("at File level.");
                                } else if (annotation instanceof AnnotationFolder){
                                    System.out.println("at Folder level.");
                                } else {
                                    System.out.println("");
                                }
                            }
                        }
                    }
                }
            }

        }

        if (printFoundLocation) {
            System.out.println("   Feature tangled: " + tangledFeatures.toString());
        }

//        System.out.println("<< TanglingDegree::calculateTD");
        return tangledFeatures.size();
    }

}
