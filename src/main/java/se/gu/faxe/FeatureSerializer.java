package se.gu.faxe;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class FeatureSerializer extends StdSerializer<Feature> {

    protected FeatureSerializer(Class<Feature> t) {
        super(t);
    }

    public void serialize(Feature feature, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", feature.getName());
        jsonGenerator.writeEndObject();
    }
}
