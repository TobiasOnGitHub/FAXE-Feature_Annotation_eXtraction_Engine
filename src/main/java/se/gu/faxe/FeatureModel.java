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

import com.scalified.tree.TreeNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import se.gu.faxe.grammar.featureModelLexer;
import se.gu.faxe.grammar.featureModelParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FeatureModel  {
    /**
     * FeatureModel object to hold object of current feature model
     * FeatureModel base on the {@link TreeNode} class by https://github.com/Scalified/tree
     */
    private TreeNode<Feature> featureModel = null;
    private File featureModelPath = null;

    /**
     * Default constructor. Creates empty {@link FeatureModel} object.
     */
    public FeatureModel() {
    }

    /**
     * Constructor to create {@link FeatureModel} object and load it with given feature model path
     * @param path to the feature model file
     */
    public FeatureModel(File path) {
        loadFeatureModel(path);
    }

    /**
     * Loads @{@link FeatureModel} from feature model file (.featuremodel)
     * @param path {@link File} path to feature model file (.featuremodel)
     * @return {@code true} when feature model is successfully loaded. Otherwise {@code false}
     */
    public Boolean loadFeatureModel(File path){
        //System.out.println(">> FeatureModel::loadFeatureModel");
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
            featureModel = (TreeNode<Feature>) visitor.visit(tree);
            if(featureModel!=null) {
                System.out.println("FM:" +featureModel.toString());
                featureModelPath = path;
                return true;
            } else {
                System.out.println("ERROR: Feature model could not be loaded.");
                return false;
            }
        } catch (ParseCancellationException e) {
            // Catch if given string is not fitting the grammar
            System.out.println("FeatureModel::loadFeatureModel ERROR DETECTED");
        }

        return false;
    }

    /**
     * Checks if given Feature is part of the {@link FeatureModel}.
     * @param feature to be found in FeatureModel
     * @return {@code true} when part of feature model. Otherwise {@code false}.
     */
    public Boolean featureExistInFeatureModel(Feature feature){

        TreeNode<Feature> nodeToFind = featureModel.find(feature);
        return nodeToFind != null;

    }

    /**
     * Checks if given Feature is part of the {@link FeatureModel}.
     * @param lpq to be found in FeatureModel
     * @return {@code true} when part of feature model. Otherwise {@code false}.
     */
    public Boolean featureExistInFeatureModel(String lpq){
        return featureExistInFeatureModel(new Feature(lpq));
    }

    /**
     * Get Feature object of given feature name
     * @param lpq of feature
     * @return object of requested feature name. NULL if not available.
     */
    public Feature getFeature(String lpq){
        return featureModel.find(new Feature(lpq)).data();
    }

    /* Return name */
    public List<Feature> getFeatureByName(String str){

        Collection<? extends TreeNode<Feature>> collFeatures = featureModel.findAll(new Feature(str));

        List<Feature> list = new ArrayList<>();
        for (TreeNode<Feature> f : collFeatures) {
            System.out.println("value= " + f.data());
            list.add(f.data());
        }

        // TODO - Update implementation with LPQ handling

        return list;
    }

}
