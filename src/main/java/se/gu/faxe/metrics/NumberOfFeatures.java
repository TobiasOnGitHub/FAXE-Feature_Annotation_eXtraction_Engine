package se.gu.faxe.metrics;

import com.scalified.tree.TreeNode;
import se.gu.faxe.Annotation;
import se.gu.faxe.Asset;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfFeatures {

    /**
     * Calculate Number of Features: total number of different features (i.e. used text, file, and folder annotations)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @return Number of Features of given feature in given path.
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    public static int calculateNoF(TreeNode<Asset> fullAssetTree, File searchedPath) throws IOException {
        return calculateNoF(fullAssetTree, searchedPath, false);
    }

        /**
         * Calculate Number of Features: total number of different features (i.e. used text, file, and folder annotations)
         * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
         * @param searchedPath Sub-Tree to search for data
         * @param printFoundLocation Enable print to list locations relevant to this metric.
         * @return Number of Features of given feature in given path.
         * @throws IOException in case searchedPath does not exist in fullAssetTree.
         */
    public static int calculateNoF(TreeNode<Asset> fullAssetTree, File searchedPath, boolean printFoundLocation) throws IOException {

        Set<String> featureSet = getUniqueFeaturesSet(fullAssetTree, searchedPath, printFoundLocation);

        return featureSet.size();
    }

    /**
     * Provides a Set of unique features for the given scope.
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @return Set with unique features
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    static Set<String> getUniqueFeaturesSet(TreeNode<Asset> fullAssetTree, File searchedPath) throws IOException {
        return getUniqueFeaturesSet(fullAssetTree, searchedPath, false);
    }

    /**
     * Provides a Set of unique features for the given scope.
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Set with unique features
     * @throws IOException in case searchedPath does not exist in fullAssetTree.
     */
    static Set<String> getUniqueFeaturesSet(TreeNode<Asset> fullAssetTree, File searchedPath, boolean printFoundLocation) throws IOException {
        if(!searchedPath.exists()){
            throw new IOException("NumberOfFeatures::calculateNoF ERROR: Given input path " + searchedPath +" not existing!");
        }

        // Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode = fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("NumberOfFeatures::calculateNoF ERROR: Given inout path " + searchedPath +" not existing in fullAssetTree!");
        }

        // Iterate tree and gather information
        // Usage of String (instead of type Feature) to not count different Feature objects (with different line positions)
        Set<String> featureSet = new HashSet<>();
        for (TreeNode<Asset> node : searchRootNode) {
            //System.out.println("Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                // Go through each node + to through each annotations -> Add feature to Set
                for (Feature f : annotation.getLinkedFeatures()) {
                    featureSet.add(f.getLpq());
                    if (printFoundLocation) {
                        System.out.println("   Feature " + f.getName() +" added to the Set");
                    }
                }
            }
        }

        if (printFoundLocation) {
            System.out.println("Number of features = " +featureSet.size());
            System.out.println(featureSet.toString());
        }
        return featureSet;
    }

}
