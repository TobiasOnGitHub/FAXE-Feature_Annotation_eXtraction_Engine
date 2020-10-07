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

public class AnnotationLine extends Annotation {
    private int line = ANNOTATION_POSITION_UNDEFINED;

    public AnnotationLine(Feature f, int line) {
        this.linkedFeatures.add(f);     // TODO - Ask FeatureModel about Feature ; Create MESSAGE WHEN NOT EXISTING
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toJSON() {
        // Build hard coded JSON String to simplify JSON handling
        String ret = "";
        boolean firstItem = true;

        for (Feature feature : linkedFeatures){
            // after first item add for all items a comma before writing the next one
            if(!firstItem){
                ret += ",";
                firstItem = false;
            }
            ret += "{ \"name\": \"" +feature.getName() +"\", \"line\":" +getLine() +"}";
        }


        return ret;
    }

}
