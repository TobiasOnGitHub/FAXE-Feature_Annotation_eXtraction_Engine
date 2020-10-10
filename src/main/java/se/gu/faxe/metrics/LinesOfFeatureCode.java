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
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
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
            count ++;
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }


    public static int calculateLoFC(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) throws IOException {
        return calculateLoFC(fullAssetTree, searchedPath, searchFeature, false);
    }

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
                    if(annotation.getClass().equals(AnnotationLine.class)){
                        lofc ++;
                    } else if(annotation.getClass().equals(AnnotationFragment.class)){
                        lofc += ((AnnotationFragment) annotation).getEndline() - ((AnnotationFragment) annotation).getStartline();
                        lofc ++; // Add one for the &end marker line
                    } else if (annotation.getClass().equals(AnnotationFile.class)){
                        lofc += countLinesFile(node.data().getPath().getAbsolutePath());
                    } else if (annotation.getClass().equals(AnnotationFolder.class)){
                        lofc += countLinesFolder(node.data().getPath());
                    } else {
                        System.out.println("LinesOfFeatureCode::calculateLoFC ERROR: UNKNOWN annotation type!");
                    }

                    if (printFoundLocation) {
                        System.out.println("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());
                    }
                }
            }

        }

        //System.out.println("Scattering Degree = " +sd);

        return lofc;
    }


}
