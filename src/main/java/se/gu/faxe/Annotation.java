package se.gu.faxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Annotation {
    protected static int ANNOTATION_POSITION_UNDEFINED = -1;
    List<Feature> linkedFeatures = new ArrayList<>();

    Annotation(){
    }

    Annotation(List<Feature> listFeature){
        linkedFeatures.addAll(listFeature);
    }

    public List<Feature> getLinkedFeatures() {
        return linkedFeatures;
    }

    @Override
    public String toString() {
        return linkedFeatures.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annotation that = (Annotation) o;
        return linkedFeatures.equals(that.linkedFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkedFeatures);
    }
}
