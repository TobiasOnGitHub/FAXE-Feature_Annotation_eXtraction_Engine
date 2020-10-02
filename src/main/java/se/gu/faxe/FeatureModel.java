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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

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
        try {
            loadFeatureModel(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets path of feature model file
     * @return File path of feature model file
     */
    public File getFeatureModelPath() {
        return featureModelPath;
    }


    boolean lineStartsWithLetterOrDigit(String s){
        if(Character.isLetterOrDigit(s.charAt(0))){
            return true;
        }
        return false;
    }

    boolean lineStartsWithSpaces(String s){
        //Character.isSpaceChar(s.charAt(0));
        if(s.startsWith("    ") || s.startsWith("   ")){
            return true;
        }
        return false;
    }

    /**
     * Checks if feature model file is valid to be parsed by grammar. E.g. checked if tabs are used.
     * @param path {@link File} path to feature model file (.featuremodel)
     * @return {@code true} when file good. Otherwise {@code false}.
     */
    public boolean verifyFeatureModelFile(File path){

        /**
         * CASE 1: Spaces used instead of Tabs
         */
        try {
            Scanner scanner = new Scanner(path);
            String projectname = null;
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                System.out.println(nextLine);
                // Skip empty lines
                if(nextLine.isEmpty()){
                    continue;
                }
                // Identify project name
                if(projectname == null) {
                    if (lineStartsWithLetterOrDigit(nextLine)) {
                        projectname = nextLine;
                        continue;
                    }
                    return false;
                }

                if(lineStartsWithSpaces(nextLine)){
                    System.out.println("ERROR: Spaces are used instead of tabs for hierarchy indentation.");
                    return false;
                }

                // Alternative: Check that next content line must start with ONE \t followed by feature name
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return true;
    }

    /**
     * Loads @{@link FeatureModel} from feature model file (.featuremodel)
     * @param path {@link File} path to feature model file (.featuremodel)
     * @return {@code true} when feature model is successfully loaded. Otherwise {@code false}
     */
    public Boolean loadFeatureModel(File path) throws IOException {
        //System.out.println(">> FeatureModel::loadFeatureModel");
        //System.out.println("Request for feature model " +path.toString());

        // fromFileName throws IOException in case file does not exist
        CharStream in = CharStreams.fromFileName(path.getAbsolutePath());

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
                //System.out.println("FM:" +featureModel.toString());
                featureModelPath = path;

                generateLPQs();

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

    /**
     * Gets all {@link Feature} which belong to the searched feature name.
     * @param searchedFeatureName which shall be searched.
     * @return List of {@link Feature} which belongs to searchedName.
     */
    public List<Feature> getFeatureByName(String searchedFeatureName){
        List<Feature> listFeatureByName = new ArrayList<>();

        for (TreeNode<Feature> node : featureModel) {
            if (node.data().getName().equals(searchedFeatureName)) {
                listFeatureByName.add(node.data());
            }
        }

        return listFeatureByName;
    }


    /**
     * Generates LPQs based on loaded FeatureModel.
     * @return {@code true} when all LPQs are unique and {@code false} when at least one LPQ is non-unique.
     */
    public boolean generateLPQs(){
        boolean uniqueLPQs = true;

        for (TreeNode<Feature> node : featureModel) {

            Collection<? extends TreeNode<Feature>> nodesToFind = featureModel.findAll(node.data());
            if(nodesToFind.size() > 1){
                for (TreeNode<Feature> treeNode : nodesToFind){
                    String parentLPQ = treeNode.parent().data().getLpq();
                    String featureLPQ = treeNode.data().getLpq();
                    treeNode.data().setLpq(parentLPQ +"::" +featureLPQ);
                }
                uniqueLPQs = false;
            } /*else{
                // Feature Name equals 1 =>  Unique -> Continue
            } */
        }

        if(!uniqueLPQs){
            generateLPQs();
        }
        return true;
    }


    /**
     * Renames feature name to new given @name. LPQs are re-generated based on new situation. (no file-system change!)
     * @param newName of feature
     * @return {@code true} when renaming succeeded. {@code false} otherwise.
     */
    public boolean renameFeature(String newName){
        throw new UnsupportedOperationException();
//      TODO - Rename Feature itself
//      TODO - Change of LPQ required
    }
}
