package se.gu.faxe.metrics;

import com.scalified.tree.TreeNode;
import se.gu.faxe.Annotation;
import se.gu.faxe.Asset;
import se.gu.faxe.Feature;

import java.io.File;
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

    public static int calculateTD(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature){
        return calculateTD(fullAssetTree, searchedPath, searchFeature, false);
    }

    /**
     * Tangling Degree: number of other features that share the same artifacts (or parts of such)
     * with the feature. Two features share (parts of) artifacts when the latter is annotated with both features.
     *
     */
    public static int calculateTD(TreeNode< Asset > fullAssetTree, File searchedPath, Feature searchFeature, Boolean printFoundLocation){
//        System.out.println(">> TanglingDegree::calculateTD");
        HashSet<String> tangledFeatures = new HashSet<>();

        // Reduce Tree to searched Area
        TreeNode<Asset> searchRootNode =fullAssetTree.find(new Asset(searchedPath));

        // Check if searched feature is in Asset
        for (TreeNode<Asset> node : searchRootNode) {
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
                if (printFoundLocation) {
                    System.out.println("   Feature " + searchFeature.toString() + " found in " + node.data().getPath());
                }
                for(Annotation annotation : annotations){
                    for(Feature feature : annotation.getLinkedFeatures()){
                        if(!feature.equals(searchFeature)){          // Skipp searched feature for metric
                            tangledFeatures.add(feature.getLpq());  // Using LPQ as same feature names might appear close to each other.
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
