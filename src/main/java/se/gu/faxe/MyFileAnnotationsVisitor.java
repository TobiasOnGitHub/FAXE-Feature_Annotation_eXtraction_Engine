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

import org.javatuples.Pair;
import se.gu.faxe.grammar.fileAnnotationsBaseVisitor;
import se.gu.faxe.grammar.fileAnnotationsParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyFileAnnotationsVisitor extends fileAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private static final String NAME_UNKNOWN = null;
    private List<String> fileReferences = new ArrayList<>();
    private List<Feature> featureReferences = new ArrayList<>();
    List<Pair<File,AnnotationFile>> eaList = new ArrayList<>();

    @Override
    public List<Pair<File,AnnotationFile>> visitFileAnnotations(fileAnnotationsParser.FileAnnotationsContext ctx) {
        visitChildren(ctx);

        return eaList;
    }

    @Override
    public List<Pair<File,AnnotationFile>> visitFileAnnotation(fileAnnotationsParser.FileAnnotationContext ctx) {
//        System.out.println("visitFileAnnotation");
        fileReferences.clear();
        featureReferences.clear();
        visitChildren(ctx);

        // Merge all found files with their annotations
        for(String file : fileReferences){
            // "file" is provided in feature-file with relative path -> adjust this path to its project root
            String annotationFilePath = ctx.start.getInputStream().getSourceName();
            int endIndex = annotationFilePath.lastIndexOf("\\");
            if (endIndex != -1) {
                annotationFilePath = annotationFilePath.substring(0, endIndex);
            }
            file = annotationFilePath+"\\"+file;

            // Verify that file actually exist, if not print warning
            if(new File(file).exists()==false){
                System.out.println("WARNING: Referred file \"" +file +"\" does not exist in file system!");
            } else {
                eaList.add(new Pair<>(new File(file), new AnnotationFile(featureReferences)));
            }
        }

        return eaList;
    }

    @Override
    public Object visitFileName(fileAnnotationsParser.FileNameContext ctx) {
//        System.out.println("visitFileName");
        fileReferences.add(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitFeature(fileAnnotationsParser.FeatureContext ctx) {
//        System.out.println("visitFeature");
        featureReferences.add(new Feature(ctx.getText()));
        return visitChildren(ctx);
    }

}
