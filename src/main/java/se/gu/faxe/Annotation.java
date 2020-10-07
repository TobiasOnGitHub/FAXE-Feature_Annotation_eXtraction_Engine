package se.gu.faxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Annotation {
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

    public String toJSON() {
        return null;
    }
//    public String toJSONObject() {
//        // Build hard coded JSON String to simplify JSON handling
//        String ret = "";
//        boolean firstItem = true;
//
//        for (Feature feature : linkedFeatures){
//            // after first item add for all items a comma before writing the next one
//            if(!firstItem){
//                ret += ",";
//                firstItem = false;
//            }
//            ret += "{ \"name\": \"" +feature.getName() +"\"}";
//        }
//
//
//        return ret;
//    }

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
