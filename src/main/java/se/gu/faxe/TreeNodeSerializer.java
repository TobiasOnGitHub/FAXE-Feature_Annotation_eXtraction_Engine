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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.scalified.tree.TreeNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNodeSerializer extends StdSerializer<TreeNode> {

    protected TreeNodeSerializer(Class<TreeNode> t) {
        super(t);
    }
    @Override
    public void serialize(TreeNode treeNode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        //jsonGenerator.writeStringField("name", treeNode.toString());

        ;
        if(treeNode.data().getClass().equals(Asset.class)){
            jsonGenerator.writeStringField("path", ((Asset)treeNode.data()).getPath().getCanonicalPath());
            //jsonGenerator.writeStringField("annotations", ((Asset)treeNode.data()).getAnnotationList().stream().map(s -> s.toJSONObject() ).collect(Collectors.joining(",")));

            jsonGenerator.writeFieldName("annotations");
            List<String> lAnnotationStrings = new ArrayList<>();
            // map converts Annotation elements to String object list which is merged with collect to one String.
            List<String> tmp = ((Asset)treeNode.data()).getAnnotationList().stream().map(s -> s.toJSON() ).collect(Collectors.toList());
            lAnnotationStrings.addAll(tmp);
            String[] a = lAnnotationStrings.toArray(new String[0]);
            jsonGenerator.writeArray(a,0,a.length);
        }
        jsonGenerator.writeEndObject();
    }
}