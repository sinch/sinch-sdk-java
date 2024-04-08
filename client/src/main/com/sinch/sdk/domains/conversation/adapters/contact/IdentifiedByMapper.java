package com.sinch.sdk.domains.conversation.adapters.contact;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.IdentifiedBy;
import java.io.IOException;
import java.util.logging.Logger;

public class IdentifiedByMapper extends StdSerializer<IdentifiedBy> {

  private static final Logger LOGGER = Logger.getLogger(IdentifiedByMapper.class.getName());

  public IdentifiedByMapper() {
    this(null);
  }

  public IdentifiedByMapper(Class<IdentifiedBy> t) {
    super(t);
  }

  public static void initMapper() {
    SimpleModule module = new SimpleModule();
    module.addSerializer(IdentifiedBy.class, new IdentifiedByMapper());
    Mapper.getInstance().registerModule(module);
  }

  @Override
  public void serialize(IdentifiedBy value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    /*  TODO: To avoid recursive calls we should be able to add a rootName at class level (not for global mapper)
     * Need to be enhanced in the future: one solution https://github.com/FasterXML/jackson-databind/issues/1022
     */
    ObjectMapper mapper = (ObjectMapper) jgen.getCodec();

    jgen.writeStartObject();
    // hardcoded value: regression test have to be used to ensure proper validation
    jgen.writeFieldName("identified_by");

    jgen.writeStartObject();
    jgen.writeFieldName("channel_identities");
    String stringValue = mapper.writeValueAsString(value.getChannelIdentities());
    jgen.writeRawValue(stringValue);
    jgen.writeEndObject();

    jgen.writeEndObject();
  }
}
