package se.gu.faxe.metrics;

import com.scalified.tree.TreeNode;
import se.gu.faxe.Annotation;
import se.gu.faxe.Asset;
import se.gu.faxe.Feature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Scattering Degree (SD) as defined by Liebig, Jörg et. al. (2010). An
 * Analysis of the Variability in Forty Preprocessor-Based Software Product Lines.
 * ----------------------------------------------------------
 * The SD metric is the number of the occurrences of feature
 * constants in different feature expressions. We measure this
 * metric by extracting feature constants from feature expressions
 * and calculate the average and standard deviation per
 * project of all occurring feature constants. This metrics tells us
 * about the complexity of feature implementations. A widely
 * scattered feature that extends a software system in several
 * files and at multiple extension points is more complex (e.g.,
 * for maintenance tasks) than a feature that makes only a few
 * extensions in a single file.
 */

public class ScatteringDegree {

    /**
     * Calculate Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it).
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param searchFeature Searched feature name
     * @return Scattering Degree of given feature in given path.
     */
    public static int calculateSD(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) throws IOException {
        return calculateSD(fullAssetTree, searchedPath, searchFeature, false);
    }

    /**
     * Calculate Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it)
     * @param fullAssetTree Asset tree generated by FAXE to traverse for metrics
     * @param searchedPath Sub-Tree to search for data
     * @param searchFeature Searched feature name
     * @param printFoundLocation Enable print to list locations relevant to this metric.
     * @return Scattering Degree of given feature in given path.
     */
    public static int calculateSD(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature, boolean printFoundLocation) throws IOException {
        int sd = 0;

        if(!searchedPath.exists()){
            System.out.println("ScatteringDegree::calculateSD ERROR: given input path " +searchedPath +" not existing!");
        }

        // Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode =fullAssetTree.find(new Asset(searchedPath));
        if(searchRootNode==null){
            throw new IOException("Given path " +searchedPath.getPath() +" not existing!");
        }

        // Iterate tree and gather scattering information
        for (TreeNode<Asset> node : searchRootNode) {
            //System.out.println("Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                if (annotation.getLinkedFeatures().contains(searchFeature)) {
                    if (printFoundLocation) {
                        System.out.println("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());
                    }
                    sd++;
                }
            }
        }

        //System.out.println("Scattering Degree = " +sd);

        return sd;
    }

}
