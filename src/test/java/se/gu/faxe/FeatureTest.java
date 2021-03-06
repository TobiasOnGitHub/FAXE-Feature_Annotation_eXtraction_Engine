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

import org.testng.Assert;
import org.testng.annotations.Test;

public class FeatureTest {

    @Test
    public void testFeature_String_ValidContent(){
        String name = "root";

        Feature root = new Feature(name);

        Assert.assertNotNull(root);
    }

    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::Feature name is null!")
    public void testFeature_String_NullContent(){
        new Feature(null);
    }

//    @Test
//    public void testFeature_StringFeature_ValidContent(){
//        String name = "root";
//        Feature parent = new Feature("parent");
//
//        Feature root = new Feature(name, parent);
//
//        Assert.assertNotNull(root);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::Feature name is null!")
//    public void testFeature_StringFeature_NullContent_name(){
//        Feature parent = new Feature("parent");
//
//        new Feature(null, parent);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::Feature parent is null!")
//    public void testFeature_StringFeature_NullContent_parent(){
//        String name = "root";
//
//        new Feature(name, null);
//    }

//    @Test
//    public void testGetSubFeatures_ValidContent_emptySubFeature() {
//        Feature root = new Feature("root");
//
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertEquals(ret.size(), 0);
//    }

//    @Test
//    public void testAddSubFeature_ValidContent_AddValue() {
//        Feature root = new Feature("root");
//        Feature sub1 = new Feature("sub1");
//
//        Boolean ret = root.addSubFeature(sub1);
//
//        Assert.assertEquals(ret, Boolean.TRUE);
//    }

//    @Test
//    public void testAddSubFeature_ValidContent_twoValuesIndividual_size() {
//        Feature root = new Feature("root");
//        Feature sub1 = new Feature("sub1");
//        Feature sub2 = new Feature("sub2");
//
//        root.addSubFeature(sub1);
//        root.addSubFeature(sub2);
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertEquals(ret.size(), 2);
//    }

//    @Test
//    public void testAddSubFeature_ValidContent_twoValuesIndividual_content() {
//        Feature root = new Feature("root");
//        Feature sub1 = new Feature("sub1");
//        Feature sub2 = new Feature("sub2");
//
//        root.addSubFeature(sub1);
//        root.addSubFeature(sub2);
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertTrue(ret.contains(sub1));
//        Assert.assertTrue(ret.contains(sub2));
//    }

//    @Test
//    public void testAddSubFeature_ValidContent_addValue() {
//        Feature root = new Feature("root");
//        List<Feature> list = Arrays.asList(
//                new Feature("sub1"),
//                new Feature("sub2")
//        );
//        Boolean ret = root.addSubFeature(list);
//
//        Assert.assertEquals(ret, Boolean.TRUE);
//    }


//    @Test
//    public void testAddSubFeature_ValidContent_twoValuesList_size() {
//        Feature root = new Feature("root");
//        List<Feature> list = Arrays.asList(
//                new Feature("sub1"),
//                new Feature("sub2")
//        );
//        root.addSubFeature(list);
//
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertEquals(ret.size(), 2);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::addSubFeature feature is null!")
//    public void testAddSubFeature_InvalidContent_null_feature() {
//        Feature root = new Feature("root");
//
//        root.addSubFeature((Feature)null);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::addSubFeature feature list is null!")
//    public void testAddSubFeature_InvalidContent_null_featureList() {
//        Feature root = new Feature("root");
//
//        root.addSubFeature((List<Feature>)null);
//    }

//    @Test
//    public void testRemoveSubFeature_ValidContent_twoValuesList_content_addThreeValues_removeLast() {
//        Feature root = new Feature("root");
//        List<Feature> list = Arrays.asList(
//                new Feature("sub1"),
//                new Feature("sub2"),
//                new Feature("sub3")
//        );
//
//        root.addSubFeature(list);
//        root.removeSubFeature(list.get(2));
//
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertTrue(ret.contains(list.get(0)));
//        Assert.assertTrue(ret.contains(list.get(1)));
//    }

//    @Test
//    public void testRemoveSubFeature_ValidContent_twoValuesList_content_addThreeValues_removeFirst() {
//        Feature root = new Feature("root");
//        List<Feature> list = Arrays.asList(
//                new Feature("sub1"),
//                new Feature("sub2"),
//                new Feature("sub3")
//        );
//
//        root.addSubFeature(list);
//        root.removeSubFeature(list.get(0));
//
//        List<Feature> ret = root.getSubFeatures();
//
//        Assert.assertTrue(ret.contains(list.get(1)));
//        Assert.assertTrue(ret.contains(list.get(2)));
//    }

//    @Test
//    public void testRemoveSubFeature_InvalidContent_RemoveNonSubFeature() {
//        Feature root = new Feature("root");
//        List<Feature> list = Arrays.asList(
//                new Feature("sub1"),
//                new Feature("sub2"),
//                new Feature("sub3")
//        );
//        Feature nonAddedFeature = new Feature("nonAddedFeature");
//
//        root.addSubFeature(list);
//        Boolean ret = root.removeSubFeature(nonAddedFeature);
//
//        Assert.assertEquals(ret, Boolean.FALSE);
//    }

//    @Test
//    public void testRenameFeature_ValidContent() {
//        String name_old = "name_old";
//        Feature root = new Feature(name_old);
//        Assert.assertEquals(root.getName(), name_old);
//
//        String name_new = "name_new";
//        root.renameFeature(name_new);
//        Assert.assertEquals(root.getName(), name_new);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::renameFeature name is null!")
//    public void testRenameFeature_InvalidContent_Null() {
//        String name_old = "name_old";
//        Feature root = new Feature(name_old);
//
//        root.renameFeature(null);
//    }

    @Test
    public void testGetName() {
        String name = "root";
        Feature root = new Feature(name);

        Assert.assertEquals(root.getName(), name);
    }

//    @Test
//    public void testGetParent() {
//        Feature root = new Feature("root");
//
//        Feature parent = root.getParent();
//
//        Assert.assertNull(parent);
//    }

//    @Test
//    public void testSetParent_ValidContent() {
//        Feature root = new Feature("root");
//        Feature parent = new Feature("parent");
//
//        Boolean ret = root.setParent(parent);
//
//        Assert.assertEquals(ret, Boolean.TRUE);
//    }

//    @Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Feature::setParent parent is null!")
//    public void testSetParent_InvalidContent_Null() {
//        Feature root = new Feature("root");
//
//        root.setParent(null);
//    }

    @Test
    public void testGetFeature() {
        Feature root = new Feature("root");

        Feature newRoot = root.getFeature();

        Assert.assertEquals(root, newRoot);
    }

    @Test
    public void testEquals_Valid_Equal(){
        Feature a = new Feature("test");
        Feature b = new Feature("test");

        Assert.assertTrue(a.equals(b));
        Assert.assertTrue(b.equals(a));
    }

    @Test
    public void testEquals_Valid_Unequal(){
        Feature a = new Feature("47");
        Feature b = new Feature("11");

        Assert.assertFalse(a.equals(b));
        Assert.assertFalse(b.equals(a));
    }

    @Test
    public void testEquals_Valid_Unequal_SmallCapital(){
        Feature a = new Feature("feature");
        Feature b = new Feature("Feature");

        Assert.assertFalse(a.equals(b));
        Assert.assertFalse(b.equals(a));
    }

    @Test
    public void testEquals_Valid_Unequal_SmallCapital_2(){
        Feature a = new Feature("feature");
        Feature b = new Feature("FEATURE");

        Assert.assertFalse(a.equals(b));
        Assert.assertFalse(b.equals(a));
    }

    @Test
    public void testEquals_Valid_DifferentClasses(){
        Feature a = new Feature("47");
        Object b = new Object();

        Assert.assertFalse(a.equals(b));
        Assert.assertFalse(b.equals(a));
    }

    @Test
    public void testToString(){
        String rootName = "root";
        Feature root = new Feature(rootName);

        String name = root.toString();

        Assert.assertEquals(name, rootName);

    }
}