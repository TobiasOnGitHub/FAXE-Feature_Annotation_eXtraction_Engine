package se.gu.faxe;

import java.util.List;

public class AnnotationFile extends Annotation {

    AnnotationFile(List<Feature> listFeature){
        linkedFeatures.addAll(listFeature);
    }

}
