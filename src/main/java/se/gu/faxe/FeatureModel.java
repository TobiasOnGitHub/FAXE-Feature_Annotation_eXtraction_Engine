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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import se.gu.faxe.grammar.featureModelLexer;
import se.gu.faxe.grammar.featureModelParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FeatureModel  {

    public FeatureModel() {

    }

    public Boolean loadFeatureModel(File path){
        System.out.println(">> FeatureModel::loadFeatureModel");
        System.out.println("Request for feature model " +path.toString());

        CharStream in = null;
        try {
            in = CharStreams.fromFileName(path.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        featureModelLexer lexer = new featureModelLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        featureModelParser parser = new featureModelParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        try {
            ParseTree tree = parser.featureModel();

            MyFeatureModelVisitor visitor = new MyFeatureModelVisitor();
            FeatureModel fm = (FeatureModel) visitor.visit(tree);
            if(fm!=null) System.out.println("FM:" +fm.toString());
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("FeatureModel::loadFeatureModel ERROR DETECTED");
        }

        System.out.println("<< FeatureModel::loadFeatureModel");
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
