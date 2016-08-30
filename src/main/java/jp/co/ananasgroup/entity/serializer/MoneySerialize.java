package jp.co.ananasgroup.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MoneySerialize extends JsonSerializer<Float> {

  public static final String _$ = "$";

  @Override
  public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    gen.writeString(new StringBuilder().append(_$).append(String.valueOf(value)).toString());
  }
}