package se.gu.faxe.metrics;

import se.gu.faxe.EmbeddedAnnotation;
import se.gu.faxe.LPQ;

import java.io.File;
import java.io.IOException;
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
     * @param eaList
     * @param rootFolder
     * @param searchFeature
     * @return
     */
    public static int calculateSD(List<EmbeddedAnnotation> eaList, File rootFolder, LPQ searchFeature) {
        int sd = 0;

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

        // 2. reduce eaList to searched feature
        eaList = EmbeddedAnnotationOperations.extractSpecificFeature(eaList, searchFeature);

//        // 3. reduce eaList to appearances per file (unique file list)
//        eaList = eaList.stream()
//                .filter(distinctByKey(ea -> ea.getFile()))
//                .collect(Collectors.toList());

        sd = eaList.size();

        System.out.println("Scattering Degree = " +sd);

        return sd;
    }

}
