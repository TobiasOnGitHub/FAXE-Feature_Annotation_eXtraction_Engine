//package se.gu.faxe.metrics;
//
//import se.gu.faxe.EmbeddedAnnotation;
//import se.gu.faxe.LPQ;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//class EmbeddedAnnotationOperations {
//
//    /**
//     * Extracts specific feature from List of {@link EmbeddedAnnotation}.
//     * @param eaList List to extract feature from.
//     * @param searchFeature To be searched feature.
//     * @return List of {@link EmbeddedAnnotation} for only the given feature.
//     */ // put private as functionality now with parameter in getEA methods
//    protected static List<EmbeddedAnnotation> extractSpecificFeature(List<EmbeddedAnnotation> eaList, LPQ searchFeature){
//        List<EmbeddedAnnotation> eaListFiltered = eaList.stream()
//                .filter(ea -> ea.getFeature().equals(searchFeature.getName()))
//                .collect(Collectors.toList());
//
//        return eaListFiltered;
//    }
//
//    protected static List<EmbeddedAnnotation> extractSpecificFile(List<EmbeddedAnnotation> eaList, String searchedFile){
//        List<EmbeddedAnnotation> eaListFiltered = eaList.stream()
//                .filter(ea -> ea.getFile().equals(searchedFile))
//                .collect(Collectors.toList());
//
//        return eaListFiltered;
//    }
//
//    protected static List<EmbeddedAnnotation> extractSpecificFiles(List<EmbeddedAnnotation> eaList, List<EmbeddedAnnotation> searchedFile){
//        List<EmbeddedAnnotation> eaListFiltered = eaList.stream()
//                .filter(searched -> searchedFile.stream()
//                        .anyMatch(original -> original.getFile().equals(searched.getFile()))
//                )
//                .collect(Collectors.toList());
//
//        return eaListFiltered;
//    }
//}
