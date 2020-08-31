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

import java.util.Objects;

public class EmbeddedAnnotation {
    public enum eEAType {
        UNKNOWN ("UNKNOWN"),
        FOLDER  ("FOLDER"),
        FILE    ("FILE"),
        BEGIN   ("BEGIN"),
        END     ("END"),
        FRAGMENT("FRAGMENT"),
        LINE    ("LINE"),
        COUNT   ("COUNT");

        private final String type;
        eEAType(String s) {
            this.type = s;
        }
        @Override
        public String toString() { return type; }
    }

    private eEAType eaType;
    private String file;
    private int openingLine;
    private int closingLine;
    private String feature;

    public EmbeddedAnnotation(eEAType eaType, String file, int openingLine, int closingLine, String feature){
        this.eaType = eaType;
        this.file = file;
        this.openingLine = openingLine;
        this.closingLine = closingLine;
        this.feature = feature;
    }

    public EmbeddedAnnotation getEmbeddedAnnotation(){
        return this;
    }

    public String toString(){
        if(eaType==eEAType.FILE || eaType==eEAType.FOLDER){
            return "\n{" +eaType.toString() +"\t" +file +"-"         +" " +"-"         +" " +feature +"}";
        } else {
            return "\n{" +eaType.toString() +"\t" +file +" " +openingLine +" " +closingLine +" " +feature +"}";
        }
    }

    /**
     * Compares two EmbededAnnotation objects.
     * @param first EmbededAnnotation object.
     * @param second EmbededAnnotation objects.
     * @return 0 for equal ; -1 for unequal
     */
    public int compare(EmbeddedAnnotation first, EmbeddedAnnotation second){
        if(first.eaType == second.eaType){
            if(first.file.equals(second.file)){
                if(first.openingLine == second.openingLine){
                    if(first.closingLine == second.closingLine) {
                        if(first.feature.equals(second.feature)){
                            return 0;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public String serialize(){
        return eaType.toString() +"," +file +"," +openingLine +"," +closingLine +"," +feature;
    }

    public static EmbeddedAnnotation deserialize(String string){

        eEAType eaType = eEAType.UNKNOWN;
        String file = "";
        int openingLine = 0;
        int closingLine = 0;
        String feature = "";

        // remove unwanted characters
        string = string.replace("{","");
        string = string.replace("}","");
        string = string.replace("\"","");

        String sArr[] = string.split(",");
        for(String s : sArr) {
            if (s.startsWith("eaType")) {
                eaType = eEAType.valueOf(s.substring(s.indexOf(":")+1));
            } else if ( s.startsWith("File") ) {
                file = s.substring(s.indexOf(":")+1);
            } else if ( s.startsWith("OpeningLine") ) {
                openingLine = Integer.valueOf(s.substring(s.indexOf(":")+1));
            } else if ( s.startsWith("ClosingLine") ) {
                closingLine = Integer.valueOf(s.substring(s.indexOf(":")+1));
            } else if ( s.startsWith("Feature") ) {
                feature = s.substring(s.indexOf(":")+1);
            } else {
                System.out.println("WARNING: FAXE.EmbeddedAnnotation::deserialize Unknown type \"" +s +"\"!");
            }
        }

        return new EmbeddedAnnotation(eaType, file, openingLine, closingLine, feature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddedAnnotation that = (EmbeddedAnnotation) o;
        return openingLine == that.openingLine &&
                closingLine == that.closingLine &&
                eaType == that.eaType &&
                Objects.equals(feature, that.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eaType, openingLine, closingLine, feature);
    }

    public eEAType getEaType() {
        return eaType;
    }
    public String getFile(){ return file; }
    public int getClosingLine() {
        return closingLine;
    }
    public int getOpeningLine() {
        return openingLine;
    }
    public String getFeature() {
        return feature;
    }

    public void setEaType(eEAType eaType){
        this.eaType = eaType;
    }
    public void setFile(String file) { this.file = file; }
    public void setOpeningLine(int openingLine){
        this.openingLine = openingLine;
    }
    public void setClosingLine(int closingLine){
        this.closingLine = closingLine;
    }
}
