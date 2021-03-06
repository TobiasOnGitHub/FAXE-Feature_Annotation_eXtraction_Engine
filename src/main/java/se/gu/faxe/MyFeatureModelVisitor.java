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
import com.scalified.tree.multinode.ArrayMultiTreeNode;
import se.gu.faxe.grammar.featureModelBaseVisitor;
import se.gu.faxe.grammar.featureModelParser;

import java.util.Vector;

public class MyFeatureModelVisitor extends featureModelBaseVisitor<Object> {
    private TreeNode<Feature> fmTree;
    private final Vector<TreeNode<Feature>> lastUsedFeaturePerLevel = new Vector<>(); // Contains the last element per level (depth). I.e. which need to be extended by a child.
    int projectname_offset = 0;

    @Override
    public TreeNode<Feature> visitFeatureModel(featureModelParser.FeatureModelContext ctx) {
//        System.out.println("MyFeatureModelVisitor::visitFeatureModel");

        visitChildren(ctx);

        return fmTree;
    }

    @Override public Object visitProjectname(featureModelParser.ProjectnameContext ctx) {
        //System.out.println("MyFeatureModelVisitor::visitProjectname");

        Feature projectname = new Feature(ctx.getText());
        fmTree = new ArrayMultiTreeNode<>(projectname);
        lastUsedFeaturePerLevel.add(fmTree.root());

        projectname_offset = ctx.depth();

        return visitChildren(ctx);
    }


    @Override public Object visitFeature(featureModelParser.FeatureContext ctx) {
        //System.out.println("MyFeatureModelVisitor::visitFeature -> " +ctx.getText());

        String featureName = ctx.getText();
        if(ctx.getChildCount()>1) {     // 1 because own content (getText) is a child
            visitChildren(ctx);
        } else {
            // We are in the lowest level (leaf node)

            // Identify parent feature
            int depth = ctx.depth();
            TreeNode<Feature> parentNode = lastUsedFeaturePerLevel.get(depth-1- projectname_offset);  // -1 for parent level ; -projectname_offset for offset to count with 0

            // Extend parent feature with child feature
            TreeNode<Feature> childNode = new ArrayMultiTreeNode<>(new Feature(featureName));
            parentNode.add(childNode);

            // Update reference list
            if(lastUsedFeaturePerLevel.size() <= depth- projectname_offset){ // -projectname_offset for offset to count with 0
                lastUsedFeaturePerLevel.add(childNode);
            } else {
                lastUsedFeaturePerLevel.set(depth- projectname_offset,childNode);
            }

        }

        return null;
    }

}
