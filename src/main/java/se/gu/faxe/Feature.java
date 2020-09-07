package se.gu.faxe;

import java.util.ArrayList;
import java.util.List;

public class Feature {
    private String name;
    private Feature parent = null;
    private final List<Feature> subFeatures = new ArrayList<>();

    public Feature(String name) {
        if(name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Feature::Feature name is null!");
        }
    }

    public Feature(String name, Feature parent){
        if(name != null) {
            this.name = name;
            if(parent != null) {
                this.parent = parent;
            } else {
                throw new NullPointerException("Feature::Feature parent is null!");
            }
        } else {
            throw new NullPointerException("Feature::Feature name is null!");
        }
    }

    public String getName() {
        return name;
    }

    public Feature getParent() {
        return parent;
    }

    public Boolean setParent(Feature parent) {
        if(parent != null) {
            this.parent = parent;
        } else {
            throw new NullPointerException("Feature::setParent parent is null!");
        }
        return true;
    }

    public List<Feature> getSubFeatures() {
        return subFeatures;
    }

    public Feature getFeature(){
        return this;
    }

    public Boolean addSubFeature(Feature feature){
        if(feature != null) {
            return this.subFeatures.add(feature);
        } else {
            throw new NullPointerException("Feature::addSubFeature feature is null!");
        }
    }

    public Boolean addSubFeature(List<Feature> feature){
        if(feature != null) {
            return this.subFeatures.addAll(feature);
        } else {
            throw new NullPointerException("Feature::addSubFeature feature list is null!");
        }
    }

    public Boolean removeSubFeature(Feature feature){
        return subFeatures.remove(feature);
    }

    public Boolean renameFeature(String name){
        if(name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Feature::renameFeature name is null!");
        }
        return true;
    }
}
