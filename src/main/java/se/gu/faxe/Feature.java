/*************************************************************
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 *************************************************************/
package se.gu.faxe;

public class Feature {
    private String name;
//    private Feature parent = null;
//    private final List<Feature> subFeatures = new ArrayList<>();

    public Feature(String name) {
        if(name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Feature::Feature name is null!");
        }
    }

//    public Feature(String name, Feature parent){
//        if(name != null) {
//            this.name = name;
//            if(parent != null) {
//                this.parent = parent;
//            } else {
//                throw new NullPointerException("Feature::Feature parent is null!");
//            }
//        } else {
//            throw new NullPointerException("Feature::Feature name is null!");
//        }
//    }

    public String getName() {
        return name;
    }

//    public Feature getParent() {
//        return parent;
//    }

//    public Boolean setParent(Feature parent) {
//        if(parent != null) {
//            this.parent = parent;
//        } else {
//            throw new NullPointerException("Feature::setParent parent is null!");
//        }
//        return true;
//    }

//    public List<Feature> getSubFeatures() {
//        return subFeatures;
//    }

    public Feature getFeature(){
        return this;
    }

//    public Boolean addSubFeature(Feature feature){
//        if(feature != null) {
//            return this.subFeatures.add(feature);
//        } else {
//            throw new NullPointerException("Feature::addSubFeature feature is null!");
//        }
//    }

//    public Boolean addSubFeature(List<Feature> feature){
//        if(feature != null) {
//            return this.subFeatures.addAll(feature);
//        } else {
//            throw new NullPointerException("Feature::addSubFeature feature list is null!");
//        }
//    }

//    public Boolean removeSubFeature(Feature feature){
//        return subFeatures.remove(feature);
//    }

    public Boolean renameFeature(String name){
        if(name != null) {
            this.name = name;
        } else {
            throw new NullPointerException("Feature::renameFeature name is null!");
        }
        return true;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * For class {@link Feature} two items are identical when their feature name is identical.
     * @param   o   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
    */
    @Override
    public boolean equals(Object o) {
        if(o.getClass().equals(Feature.class)){
            return this.getName().equals(((Feature) o).getName());
        }
        return false;
    }

    /**
     * Returns a string representation of the Feature object.
     * @return a string representation of the object.
     */
    public String toString() {
        return getName();
    }
}
