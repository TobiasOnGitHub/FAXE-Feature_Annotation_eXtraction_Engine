package se.gu.faxe.metrics;

import se.gu.faxe.EmbeddedAnnotation;
import se.gu.faxe.LPQ;

import java.io.File;
import java.io.IOException;
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
     *
     */
    public static int calculateTD(List<EmbeddedAnnotation> eaList, File rootFolder, LPQ searchFeature){
        int td = 0;

        // 1. Reduce eaList to elements below rootFolder
        for(int i = 0; i<eaList.size(); i++) {
            try {
                if (!(new File(eaList.get(i).getFile()).getCanonicalPath().equals(rootFolder.getCanonicalPath()))) {
                    String child = new File(eaList.get(i).getFile()).getCanonicalPath();
                    String parent = rootFolder.getCanonicalPath() + File.separator;
                    boolean areRelated = new File(eaList.get(i).getFile()).getCanonicalPath().contains(rootFolder.getCanonicalPath() + File.separator);
                    if(!areRelated) {
                        System.out.println("File outside searched File found. Remove it.");
                        eaList.remove(i);
                    }
                } else {
                    System.out.println("Root and searched File equal.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 2. Reduce eaList to elements which contain searchedFeature
        List<EmbeddedAnnotation> searchFeatureInFiles = EmbeddedAnnotationOperations.extractSpecificFeature(eaList, searchFeature);

        // 3. Reduce eaList to files with specific features
        eaList = EmbeddedAnnotationOperations.extractSpecificFiles(eaList, searchFeatureInFiles);

        // 4. Per file, create unique list of features


        return td;
    }

}
