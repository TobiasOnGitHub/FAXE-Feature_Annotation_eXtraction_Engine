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

import se.gu.faxe.grammar.codeAnnotationBaseVisitor;
import se.gu.faxe.grammar.codeAnnotationParser;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyCodeAnnotationsVisitor extends codeAnnotationBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;

    /**
     * Runs the codeAnnotations Grammar and splits it into found code annotations
     * @param ctx codeAnnotationParser.MarkerContext
     * @return List of found embedded code annotations;
     *      null when no match found
     */
    @Override public List<EmbeddedAnnotation> visitMarker(codeAnnotationParser.MarkerContext ctx) {
        //System.out.println("Run visitMarker and extract embedded annotations.");
        List<EmbeddedAnnotation> eaList = new ArrayList<>();
        List<EmbeddedAnnotation> eaListTmp = (List<EmbeddedAnnotation>) visitChildren(ctx);

        if(eaListTmp!=null){
            eaList.addAll(eaListTmp);
        }

        // BEGIN and END markers have been discovered independently and need to be merged to FRAGMENTS now:
        ListIterator<EmbeddedAnnotation> searchBeginItr = eaList.listIterator(eaList.size());
        int index = eaList.size();
        while(searchBeginItr.hasPrevious()) {
            EmbeddedAnnotation eaBEGIN = searchBeginItr.previous();
            if (eaBEGIN.getEaType() == EmbeddedAnnotation.eEAType.BEGIN) {
                ListIterator<EmbeddedAnnotation> searchEndItr = eaList.listIterator(index);
                while(searchEndItr.hasNext()) {
                    EmbeddedAnnotation eaEND = searchEndItr.next();
                    if (eaEND.getEaType() == EmbeddedAnnotation.eEAType.END) {
                        if(eaBEGIN.getFeature().equals(eaEND.getFeature())){
                            if(eaBEGIN.getClosingLine()==POSITION_UNKNOWN && eaEND.getOpeningLine()==POSITION_UNKNOWN){
                                //System.out.println("MERGING: " +eaBEGIN.toString());
                                //System.out.println("WITH   : " +eaEND.toString());
                                // Match confirmed - replace two entries with one "FRAGMENT"
                                eaBEGIN.setClosingLine(eaEND.getClosingLine());
                                eaBEGIN.setEaType(EmbeddedAnnotation.eEAType.FRAGMENT);
                                //System.out.println("TO     : " +eaBEGIN.toString());
                                searchEndItr.remove();
                                searchBeginItr = eaList.listIterator(index-1);    // set outer iterator again. Otherwise it gets confused in its iterating positions. Set to position of new created FRAGMENT
                            }
                        }
                    }
                } // while(searchEndItr.hasNext())
            }
            index--;
        } // while(searchBeginItr.hasPrevious())

//        System.out.println("Completed visitMarker, found " +eaList.size() +" elements.");
        return eaList;
    }

    @Override public List<EmbeddedAnnotation> visitBeginmarker(codeAnnotationParser.BeginmarkerContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        // Add for new created feature entries that they are found in BEGIN
        eaList.forEach(
                ea -> {
                    ea.setEaType(EmbeddedAnnotation.eEAType.BEGIN);
                    ea.setOpeningLine(ctx.getStart().getLine());
                }
        );
        return eaList;
    }

    @Override public List<EmbeddedAnnotation> visitEndmarker(codeAnnotationParser.EndmarkerContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        // Add for new created feature entries that they are found in END
        eaList.forEach(
                ea -> {
                    ea.setEaType(EmbeddedAnnotation.eEAType.END);
                    ea.setClosingLine(ctx.getStart().getLine());
                }
        );
        return eaList;
    }

    @Override public List<EmbeddedAnnotation> visitLinemarker(codeAnnotationParser.LinemarkerContext ctx) {
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitChildren(ctx);
        // Add for new created feature entries that they are found in END
        eaList.forEach(
                ea -> {
                    ea.setEaType(EmbeddedAnnotation.eEAType.LINE);
                    ea.setOpeningLine(ctx.getStart().getLine());
                    ea.setClosingLine(ctx.getStart().getLine());
                }
        );
        return eaList;
    }

    @Override public EmbeddedAnnotation visitFeature(codeAnnotationParser.FeatureContext ctx) {
        visitChildren(ctx);
        String filePath = ctx.start.getInputStream().getSourceName();
        return new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.UNKNOWN, filePath, POSITION_UNKNOWN, POSITION_UNKNOWN, ctx.getText());
    }

    @Override
    protected Object aggregateResult(Object aggregate, Object nextResult) {

        if(aggregate==null && nextResult==null){
            return null;
        }

        //System.out.println("aggregate=" +aggregate +" nextResult=" +nextResult);

        // Build return list with new found features
        if(aggregate == null || aggregate instanceof List) {
            if (nextResult instanceof EmbeddedAnnotation) {
                // Add new element to existing list
                List<EmbeddedAnnotation> eaList = new ArrayList();
                if(aggregate instanceof List){
                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
                }
                eaList.add((EmbeddedAnnotation) nextResult);
                return eaList;
            } else {
                // Combining results of markers
                if(aggregate instanceof List && nextResult instanceof List){
                    List<EmbeddedAnnotation> eaList = new ArrayList();
                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
                    eaList.addAll((List<EmbeddedAnnotation>) nextResult);
                    return eaList;
                }
                // No new result - returning existing aggretation (unchanged) or null
                if(aggregate instanceof List){
                    return aggregate;
                }
                if(aggregate == null){
                    if(nextResult instanceof List){
                        return nextResult;
                    }
                    return null;
                }
            }
        }

        System.out.println("MyVisitor::aggregateResult - Unknown SITUATION!");
        return null;

    }
}
