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

import java.io.*;
import java.util.List;
import java.util.Set;

/**
 * Lines of Feature Code: lines of code belonging to artifacts, either directly annotated,
 * or indirectly (when a folder is annotated, all descendants are taken into account)
 * =========================================================================================
 * Lines of Feature Code as defined by Liebig, Jörg et. al. (2010). An
 * Analysis of the Variability in Forty Preprocessor-Based Software Product Lines.
 * -----------------------------------------------------------------------------------------
 * Lines of Feature Code (LOF). The LOF metric is the number lines of feature code that are
 * linked to feature expressions. It tells us whether a small or a large fraction of the
 * code base is variable. We extract this metric by counting the number of lines between
 * two #ifdefs in source code files and sum them per project.
 * =========================================================================================
 * In the context of FAXE this means that for a specific feature ALL annotated elements are
 * considered. I.e. on source code, feature-to-file mapping and feature-to-folder mapping
 * - For the calculation of Fragments (annotated code scopes), all lines from the &begin till
 *   &end line are considered.
 *   Example - 5 lines of fragment code
 *     //&begin[BlockchainSync]
 *     public final Date bestChainDate;
 *     public final int bestChainHeight;
 *     public final boolean replaying;
 *     //&end[BlockchainSync]
 *   This is for stability reasons to cover all ways of how text fragment annotations can be written.
 *     /*&begin[BlockchainSync] * /public final bestValue;
 *     public final Date bestChainDate;
 *     public final int bestChainHeight;
 *     public final boolean replaying;
 *     public final boolean play //&end[BlockchainSync]
 *
 */
public class LinesOfFeatureCode {

    private static int countLinesFolder(File inputFile) throws IOException {
        int lineCount = 0;
        if(inputFile.isDirectory()){
            File[] files = inputFile.listFiles();
            assert files != null;
            for (File file : files) {
                lineCount += countLinesFolder(file);
            }
        } else {
            lineCount += countLinesFile(inputFile.getAbsolutePath());
            System.out.println("countLinesFolder: " +inputFile.getAbsolutePath() +" Count = " +lineCount);
        }

        return lineCount;
    }

    // Following approach of https://stackoverflow.com/a/453067 by martinus
    private static int countLinesFile(String filename) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            // Add count+1 to count last line which ends with eof
            count++;
            return (!empty && count == 0) ? 1 : count;
        }
    }

    private static int getLinesOfFeatureCode(TreeNode<Asset> node, Annotation annotation, boolean printFoundLocation) throws IOException {
        final int POSITION_UNKNOWN = -1;    // Value taken from MyCodeAnnotationsVisitor
        int totalLoFC = 0;

        if (annotation.getClass().equals(AnnotationLine.class)) {
            totalLoFC++;
        } else if (annotation.getClass().equals(AnnotationFragment.class)) {
            if(((AnnotationFragment) annotation).getEndline()!=POSITION_UNKNOWN
                && ((AnnotationFragment) annotation).getStartline()!=POSITION_UNKNOWN) {
                totalLoFC += ((AnnotationFragment) annotation).getEndline() - ((AnnotationFragment) annotation).getStartline();
                totalLoFC++; // Add one for the &end marker line
            } else {
                // Annotation incomplete -> Print error and skip it
                System.out.println("LinesOfFeatureCode::getLinesOfFeatureCode ERROR: Incomplete Annotation: " +annotation.toString() +" at " +((AnnotationFragment) annotation).getStartline() +":" +((AnnotationFragment) annotation).getEndline());
            }
        } else if (annotation.getClass().equals(AnnotationFile.class)) {
            totalLoFC += countLinesFile(node.data().getPath().getAbsolutePath());
        } else if (annotation.getClass().equals(AnnotationFolder.class)) {
            totalLoFC += countLinesFolder(node.data().getPath());
        } else {
            System.out.println("LinesOfFeatureCode::getLinesOfFeatureCode ERROR: UNKNOWN annotation type!");
        }

        if(printFoundLocation){
            System.out.println("LinesOfFeatureCode::getLinesOfFeatureCode - Annotation " +annotation.toString() +" added. Total LoFC=" +totalLoFC);
        }

        return totalLoFC;
    }


    public static int calculateLoFCTotal(TreeNode<Asset> fullAssetTree, File searchedPath, boolean printFoundLocation) throws IOException {
        int totalLoFC = 0;

        if(!searchedPath.exists()){
            throw new IOException("LinesOfFeatureCode::calculateLoFC ERROR: Given input path " +searchedPath +" not existing!");
        }

        // Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode = fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("LinesOfFeatureCode::calculateLoFC ERROR: Given inout path " +searchedPath +" not existing in fullAssetTree!");
        }

        // Iterate tree and gather scattering information
        for (TreeNode<Asset> node : searchRootNode) {
            //System.out.println("Testing Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                // Add all appearances of specific feature to sum
                totalLoFC += getLinesOfFeatureCode(node, annotation, printFoundLocation);

            }
        }

        return totalLoFC;
    }

    /**
     * Calculate Lines of Feature Code: lines of code belonging to a specific features for all artifacts, either
     * directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @return Average nesting depth of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateLoFC(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) throws IOException {
        return calculateLoFC(fullAssetTree, searchedPath, searchFeature, false);
    }

    /**
     * Calculate Lines of Feature Code: lines of code belonging to a specific features for all artifacts, either
     * directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Average nesting depth of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateLoFC(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature, boolean printFoundLocation) throws IOException {
        int lofc = 0;

        if(!searchedPath.exists()){
            throw new IOException("LinesOfFeatureCode::calculateLoFC ERROR: Given input path " +searchedPath +" not existing!");
        }

        // Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode = fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("LinesOfFeatureCode::calculateLoFC ERROR: Given inout path " +searchedPath +" not existing in fullAssetTree!");
        }

        // Iterate tree and gather scattering information
        for (TreeNode<Asset> node : searchRootNode) {
            //System.out.println("Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                if (annotation.getLinkedFeatures().contains(searchFeature)) {
                    // Add all appearances of specific feature to sum
                    lofc += getLinesOfFeatureCode(node, annotation, printFoundLocation);

                    if (printFoundLocation) {
                        System.out.println("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());
                    }
                }
            }
        }

        return lofc;
    }

    /**
     * Calculate Average Lines of Feature Code: average lines of code belonging to all features for all artifacts, either
     * directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @return Average nesting depth of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static double calculateAverageLoFC(TreeNode<Asset> fullAssetTree, File searchedPath) throws IOException {
        return calculateAverageLoFC(fullAssetTree, searchedPath, false);
    }

    /**
     * Calculate Average Lines of Feature Code: average lines of code belonging to all features for all artifacts, either
     * directly annotated, or indirectly (when a folder is annotated, all descendants are taken into account)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Average nesting depth of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static double calculateAverageLoFC(TreeNode<Asset> fullAssetTree, File searchedPath, boolean printFoundLocation) throws IOException {

        /**
         * GET ALL FEATURES IN GIVEN SCOPE (searchedPath)
         */
        Set<String> uniqueFeatures = NumberOfFeatures.getUniqueFeaturesSet(fullAssetTree, searchedPath /*,false*/);

        /**
         * CALCULATE LoFC PER FEATURE IN SCOPE
         */
        double sumLoFC = 0.0;
        for(String feature : uniqueFeatures){
            Feature searchFeature = new Feature(feature);
            int LoFC = calculateLoFC(fullAssetTree, searchedPath, searchFeature/*, printFoundLocation*/);
            sumLoFC += LoFC;
            if (printFoundLocation) {
                System.out.println("calculateAverageLoFC for feature \"" + searchFeature + "\" has LoFC=" + LoFC);
            }
        }

        double avgLoFC = sumLoFC / ((double) uniqueFeatures.size());
        if (printFoundLocation) {
            System.out.println("calculateAverageLoFC total average LoFC = " + avgLoFC);
        }
        return avgLoFC;
    }

}
