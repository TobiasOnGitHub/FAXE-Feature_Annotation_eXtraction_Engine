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

import java.io.File;
import java.util.List;

public class FeatureModel extends Feature {

    public FeatureModel(String name) {
        super(name);
    }

    public Boolean loadFeatureModel(File path){
        System.out.println(">> FeatureModel::loadFeatureModel");



        return false;
    }

    public Boolean featureExistInFeatureModel(Feature feature){

        return false;
    }

    /* Return LPQ */
    public Boolean featureExistInFeatureModel(String str){

        return false;
    }

    /* Return LPQ */
    public Feature getFeature(String str){

        return null;
    }

    /* Return name */
    public List<Feature> getFeatureByName(String str){

        return null;
    }

}
