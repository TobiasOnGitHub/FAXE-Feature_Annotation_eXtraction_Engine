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

import se.gu.faxe.grammar.folderAnnotationsBaseVisitor;
import se.gu.faxe.grammar.folderAnnotationsParser;

import java.util.ArrayList;
import java.util.List;

public class MyFolderAnnotationVisitor extends folderAnnotationsBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    List<Feature> features = new ArrayList<>();

    @Override
    public Annotation visitFolderAnnotation(folderAnnotationsParser.FolderAnnotationContext ctx) {
//        System.out.println("visitFolderAnnotation");
        visitChildren(ctx);

        Annotation ann = new Annotation(features);

        return ann;
    }

    @Override
    public Object visitFeature(folderAnnotationsParser.FeatureContext ctx) {
//        System.out.println("visitFeature \"" +ctx.getText() +"\"");
        visitChildren(ctx);

        // Find folder name
//        String folderPath = ctx.start.getInputStream().getSourceName();
//        int endIndex = folderPath.lastIndexOf("\\");
//        if (endIndex != -1) {
//            folderPath = folderPath.substring(0, endIndex);
//        }

        features.add(new Feature(ctx.getText()));
        return null;
    }

//    protected Object aggregateResult(Object aggregate, Object nextResult) {
//
//        if(aggregate==null && nextResult==null){
//            return null;
//        }
//
////        System.out.println("aggregateResult");
//
//        if(aggregate == null && nextResult instanceof EmbeddedAnnotation){
//            List<EmbeddedAnnotation> eaList = new ArrayList<>();
//            eaList.add((EmbeddedAnnotation) nextResult);
//            return eaList;
//        }
//
//        if(aggregate instanceof List && nextResult==null){
//            return aggregate;
//        }
//
//        if(aggregate instanceof List && nextResult instanceof EmbeddedAnnotation){
//            ((List) aggregate).add(nextResult);
//            return aggregate;
//        }
//
//        System.out.println("aggregateResult - Uncovered case. aggregate=" +aggregate.toString() +" and nextResult=" +nextResult.toString());
//        return null;
//    }
}
