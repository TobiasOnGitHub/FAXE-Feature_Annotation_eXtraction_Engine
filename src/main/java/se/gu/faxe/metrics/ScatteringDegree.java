package se.gu.faxe.metrics;

import com.scalified.tree.TreeNode;
import se.gu.faxe.Annotation;
import se.gu.faxe.Asset;
import se.gu.faxe.Feature;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Scattering Degree (SD) as defined by Liebig, Jörg et. al. (2010). An
 * Analysis of the Variability in Forty Preprocessor-Based Software Product Lines.
 * ----------------------------------------------------------
 * The SD metric is the number of the occurrences of feature
 * constants in different feature expressions. We measure this
 * metric by extracting feature constants from feature expres-
 * sions and calculate the average and standard deviation per
 * project of all occurring feature constants. This metrics tells us
 * about the complexity of feature implementations. A widely
 * scattered feature that extends a software system in several
 * files and at multiple extension points is more complex (e.g.,
 * for maintenance tasks) than a feature that makes only a few
 * extensions in a single file.
 */

public class ScatteringDegree {

    /**
     *
     * Adapted from https://www.baeldung.com/java-streams-distinct-by
     * @param keyExtractor
     * @param <T>
     * @return
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Calculate Scattering Degree: total number of all annotations directly referencing the feature (i.e., in-file, folder, and file annotations referencing it)
     * @param fullAssetTree
     * @param searchedPath
     * @param searchFeature
     * @return
     */
    public static int calculateSD(TreeNode<Asset> fullAssetTree, File searchedPath, Feature searchFeature) {
        int sd = 0;

        if(!searchedPath.exists()){
            System.out.println("ScatteringDegree::calculateSD ERROR: given input path " +searchedPath +" not existing!");
        }

        // 1. Reduce eaList to elements below searchedPath
        TreeNode<Asset> searchRootNode =fullAssetTree.find(new Asset(searchedPath));

        Iterator<TreeNode<Asset>> iterator = searchRootNode.iterator();
        while (iterator.hasNext()) {
            TreeNode<Asset> node = iterator.next();
            //System.out.println("Node = " +node.toString());
            List<Annotation> annotationList = node.data().getAnnotationList();
            for (Annotation annotation : annotationList) {
                if(annotation.getLinkedFeatures().contains(searchFeature)){
                    System.out.println("   Feature " +searchFeature.toString() +" found in " +node.data().getPath());
                    sd++;
                }
            }

        }

        //System.out.println("Scattering Degree = " +sd);

        return sd;
    }

}
