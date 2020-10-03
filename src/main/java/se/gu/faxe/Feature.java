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
    private String lpq;     // Least-Partially-Qualified name. Unique identifier for feature.

    /**
     * Creates {@link Feature} object based on its name
     * @param name of feature
     * @throws NullPointerException in case @name is null
     */
    public Feature(String name) {
        if(name != null) {
            this.name = name;
            this.lpq  = name;
        } else {
            throw new NullPointerException("Feature::Feature name is null!");
        }
    }

    /**
     * Creates {@link Feature} object based on its name and lpq
     * @param name of feature
     * @param lpq of feature
     * @throws NullPointerException in case @name is null
     */
    public Feature(String name, String lpq) {
        if(name != null && lpq != null) {
            this.name = name;
            this.lpq = lpq;
        } else {
            throw new NullPointerException("Feature::Feature name or LPQ is null!");
        }
    }

    public String getName() {
        return name;
    }

    public String getLpq() {
        return lpq;
    }

    public void setLpq(String lpq) {
        this.lpq = lpq;
    }

    public Feature getFeature(){
        return this;
    }

    /**
     * Renames feature name to new given @name. (no LPQ change and no file-system change!)
     * @param newName of feature
     * @return {@code true} when renaming succeeded. {@code false} otherwise.
     */
    public boolean renameFeature(String newName){
        throw new UnsupportedOperationException();
//      TODO - Change of LPQ required
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
            return this.getLpq().equals(((Feature) o).getLpq());
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

    public String toJSON() { return "\"name\": " +"\"" +getName() +"\"";}

}
