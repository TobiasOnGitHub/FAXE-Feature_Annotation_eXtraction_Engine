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