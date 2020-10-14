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
import java.util.Stack;

public class MyCodeAnnotationsVisitor extends codeAnnotationBaseVisitor<Object> {
    private static final int POSITION_UNKNOWN = -1;
    private final List<Annotation> annotationList = new ArrayList<>();

    /**
     * Runs the codeAnnotations Grammar and splits it into found code annotations
     *
     * @param ctx codeAnnotationParser.MarkerContext
     * @return List of found embedded code annotations;
     * null when no match found
     */
    @Override
    public List<Annotation> visitMarker(codeAnnotationParser.MarkerContext ctx) throws IllegalStateException {
        //System.out.println("Run visitMarker and extract embedded annotations.");
        visitChildren(ctx);

        if (annotationList.isEmpty()) {
            return annotationList;
        }

        // Merge individual begin and end annotations into one element.
        // Assumption starting from top t
        for (ListIterator<Annotation> forwardIterator = annotationList.listIterator(); forwardIterator.hasNext(); ) {
            Annotation annotationBegin = forwardIterator.next();
            if (annotationBegin.getClass().equals(AnnotationLine.class)) {
                continue;
            }
            if (((AnnotationFragment) annotationBegin).getStartline() != POSITION_UNKNOWN && ((AnnotationFragment) annotationBegin).getEndline() != POSITION_UNKNOWN) {
                // Fragment complete, continue
                continue;
            }

            // Going over all elements from this feature and complete it.
            Stack<Annotation> featureStack = new Stack<>();
            featureStack.push(annotationBegin);
            ListIterator<Annotation> innerIterator = annotationList.listIterator(forwardIterator.nextIndex());
            while (innerIterator.hasNext()) {
                Annotation innerAnnotation = innerIterator.next();
                if (annotationBegin.equals(innerAnnotation)) {    // Same Feature marker found
                    if (((AnnotationFragment) innerAnnotation).getEndline() == POSITION_UNKNOWN) {  // &begin marker found
                        featureStack.push(innerAnnotation);
                    } else if (((AnnotationFragment) innerAnnotation).getStartline() == POSITION_UNKNOWN) {  // &end marker found
                        Annotation beginAnnotation = featureStack.pop();
                        ((AnnotationFragment) beginAnnotation).setEndline(((AnnotationFragment) innerAnnotation).getEndline());
                        innerIterator.remove();
                        forwardIterator = annotationList.listIterator(forwardIterator.previousIndex()); // set outer iterator again. Otherwise it gets confused in its iterating positions.
                        break;
                    }
                }
            }
        }
//        System.out.println("Completed visitMarker, found " +annotationList.size() +" elements.");
        return annotationList;
    }

    @Override
    public Annotation visitFeature(codeAnnotationParser.FeatureContext ctx) {
        visitChildren(ctx);
        String name = ctx.getText();
        RuleContext parent = ctx.getParent().getParent().getRuleContext();
        if (parent instanceof codeAnnotationParser.LinemarkerContext) {
            AnnotationLine al = new AnnotationLine(new Feature(name), ctx.getStart().getLine());
            annotationList.add(al);
            return null;
        } else if (parent instanceof codeAnnotationParser.BeginmarkerContext) {
            AnnotationFragment af = new AnnotationFragment(new Feature(name), ctx.getStart().getLine(), POSITION_UNKNOWN);
            annotationList.add(af);
            return null;
        } else if (parent instanceof codeAnnotationParser.EndmarkerContext) {
            AnnotationFragment af = new AnnotationFragment(new Feature(name), POSITION_UNKNOWN, ctx.getStart().getLine());
            annotationList.add(af);
            return null;
        } else {
            System.out.println("ERROR: MyCodeAnnotationsVisitor::visitFeature NOT COVERED PARENT TYPE: " + parent.getClass().toString());
        }
        return null;
    }

}
