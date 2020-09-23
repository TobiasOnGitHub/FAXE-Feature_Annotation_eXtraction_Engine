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

import org.antlr.v4.runtime.RuleContext;
import se.gu.faxe.grammar.codeAnnotationBaseVisitor;
import se.gu.faxe.grammar.codeAnnotationParser;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyCodeAnnotationsVisitor extends codeAnnotationBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private List<Annotation> annotationList = new ArrayList<>();

    /**
     * Runs the codeAnnotations Grammar and splits it into found code annotations
     * @param ctx codeAnnotationParser.MarkerContext
     * @return List of found embedded code annotations;
     *      null when no match found
     */
    @Override public List<Annotation> visitMarker(codeAnnotationParser.MarkerContext ctx) {
        //System.out.println("Run visitMarker and extract embedded annotations.");
        visitChildren(ctx);

        if(annotationList.isEmpty()){
            return annotationList;
        }

        // BEGIN and END markers have been discovered independently and need to be merged:
        ListIterator<Annotation> searchBeginItr = annotationList.listIterator(annotationList.size());
        int index = annotationList.size();
        while(searchBeginItr.hasPrevious()) {
            Annotation eaBEGIN = searchBeginItr.previous();
            if(eaBEGIN instanceof AnnotationLine){
                index--;
                continue;
            }

            eaBEGIN = (AnnotationFragment) eaBEGIN;
            //if (eaBEGIN.getEaType() == EmbeddedAnnotation.eEAType.BEGIN) {
            if (((AnnotationFragment) eaBEGIN).getEndline() == POSITION_UNKNOWN) {
                ListIterator<Annotation> searchEndItr = annotationList.listIterator(index);
                while(searchEndItr.hasNext()) {
                    Annotation eaEND = searchEndItr.next();
                    if(eaEND instanceof AnnotationLine){
                        continue;
                    }
                    eaEND = (AnnotationFragment) eaEND;
                    if (((AnnotationFragment) eaEND).getStartline() == POSITION_UNKNOWN) {
                        if(eaBEGIN.equals(eaEND)){
                            AnnotationFragment newAF = new AnnotationFragment(eaBEGIN.getLinkedFeatures().get(0).getFeature(), ((AnnotationFragment) eaBEGIN).getStartline(), ((AnnotationFragment) eaEND).getEndline() );
                            searchBeginItr.set(newAF);
                            searchEndItr.remove();
                            searchBeginItr = annotationList.listIterator(index-1);    // set outer iterator again. Otherwise it gets confused in its iterating positions. Set to position of new created FRAGMENT
                        }
                    }
                } // while(searchEndItr.hasNext())
            }
            index--;
        } // while(searchBeginItr.hasPrevious())

//        System.out.println("Completed visitMarker, found " +eaList.size() +" elements.");
        return annotationList;
    }

//    @Override public List<EmbeddedAnnotation> visitBeginmarker(codeAnnotationParser.BeginmarkerContext ctx) {
//        visitChildren(ctx);
//        return null;
//    }
//
//    @Override public List<EmbeddedAnnotation> visitEndmarker(codeAnnotationParser.EndmarkerContext ctx) {
//        visitChildren(ctx);
//        return null;
//    }
//
//    @Override public List<EmbeddedAnnotation> visitLinemarker(codeAnnotationParser.LinemarkerContext ctx) {
//        visitChildren(ctx);
//        return null;
//    }

    @Override public Annotation visitFeature(codeAnnotationParser.FeatureContext ctx) {
        visitChildren(ctx);
        String filePath = ctx.start.getInputStream().getSourceName();
        String name = ctx.getText();
        RuleContext parent = ctx.getParent().getParent().getRuleContext();
        if(parent instanceof codeAnnotationParser.LinemarkerContext){
            System.out.println("...");
            AnnotationLine al = new AnnotationLine(new Feature(name), ctx.getStart().getLine());
            annotationList.add(al);
            return null;
        } else if (parent instanceof codeAnnotationParser.BeginmarkerContext){
            System.out.println("...");
            AnnotationFragment af = new AnnotationFragment(new Feature(name), ctx.getStart().getLine(),POSITION_UNKNOWN);
            annotationList.add(af);
            return null;
        } else if (parent instanceof codeAnnotationParser.EndmarkerContext){
            System.out.println("...");
            AnnotationFragment af = new AnnotationFragment(new Feature(name), POSITION_UNKNOWN, ctx.getStart().getLine());
            annotationList.add(af);
            return null;
        } else {
            System.out.println("ERROR: MyCodeAnnotationsVisitor::visitFeature NOT COVERED PARENT TYPE: " +parent.getClass().toString());
        }
        return null;
    }

//    @Override
//    protected Object aggregateResult(Object aggregate, Object nextResult) {
//
//        if(aggregate==null && nextResult==null){
//            return null;
//        }
//
//        System.out.println("aggregate=" +aggregate +" nextResult=" +nextResult);
//
//        // Build return list with new found features
//        if(aggregate == null || aggregate instanceof Annotation) {
//
//        }
//
//        if(aggregate == null || aggregate instanceof Annotation) {
//            if (nextResult instanceof EmbeddedAnnotation) {
//                // Add new element to existing list
//                List<EmbeddedAnnotation> eaList = new ArrayList();
//                if(aggregate instanceof List){
//                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
//                }
//                eaList.add((EmbeddedAnnotation) nextResult);
//                return eaList;
//            } else {
//                // Combining results of markers
//                if(aggregate instanceof List && nextResult instanceof List){
//                    List<EmbeddedAnnotation> eaList = new ArrayList();
//                    eaList.addAll((List<EmbeddedAnnotation>) aggregate);
//                    eaList.addAll((List<EmbeddedAnnotation>) nextResult);
//                    return eaList;
//                }
//                // No new result - returning existing aggretation (unchanged) or null
//                if(aggregate instanceof List){
//                    return aggregate;
//                }
//                if(aggregate == null){
//                    if(nextResult instanceof List){
//                        return nextResult;
//                    }
//                    return null;
//                }
//            }
//        }
//
//        System.out.println("MyVisitor::aggregateResult - Unknown SITUATION!");
//        return null;
//
//    }
}
