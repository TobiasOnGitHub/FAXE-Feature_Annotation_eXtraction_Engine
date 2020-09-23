package se.gu.faxe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Asset {
    private File path = null;
    private List<Annotation> annotationList = new ArrayList<>();

    public Asset(File path){
        this.path = path;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public boolean addAnnotation(Annotation annotation){
        return annotationList.add(annotation);
    }

    public boolean addAllAnnotation(List<Annotation> annotation){
        return annotationList.addAll(annotation);
    }

    public boolean removeAnnotation(Annotation annotation){
        return annotationList.remove(annotation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(path, asset.path) /*&&
                Objects.equals(annotationList, asset.annotationList)*/; // Skip list comparison as an Asset is unique per path.
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, annotationList);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "path=" + path +
                ", annotationList=" + annotationList +
                '}';
    }
}
