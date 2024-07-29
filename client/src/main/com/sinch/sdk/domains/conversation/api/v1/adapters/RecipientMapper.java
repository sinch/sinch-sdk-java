package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import java.io.IOException;
import java.util.logging.Logger;

public class RecipientMapper extends StdSerializer<Recipient> {

  private static final Logger LOGGER = Logger.getLogger(RecipientMapper.class.getName());

  public RecipientMapper() {
    this(null);
  }

  public RecipientMapper(Class<Recipient> t) {
    super(t);
  }

  public static void initMapper() {
    SimpleModule module = new SimpleModule();
    module.addSerializer(Recipient.class, new RecipientMapper());
    Mapper.getInstance().registerModule(module);
  }

  @Override
  public void serialize(Recipient value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    /*  TODO: To avoid recursive calls we should be able to add a rootName at class level (not for global mapper)
     * Need to be enhanced in the future: one solution https://github.com/FasterXML/jackson-databind/issues/1022
     */
    ObjectMapper mapper = (ObjectMapper) jgen.getCodec();

    jgen.writeStartObject();
    if (value instanceof ContactId) {
      // hardcoded value: regression test have to be used to ensure proper validation
      jgen.writeFieldName("contact_id");
      String stringValue = mapper.writeValueAsString(((ContactId) value).getContactId());
      jgen.writeRawValue(stringValue);
    } else if (value instanceof ChannelRecipientIdentities) {
      // hardcoded value: regression test have to be used to ensure proper validation
      jgen.writeFieldName("identified_by");
      jgen.writeStartObject();
      jgen.writeFieldName("channel_identities");
      String stringValue =
          mapper.writeValueAsString(((ChannelRecipientIdentities) value).toArray());
      jgen.writeRawValue(stringValue);
      jgen.writeEndObject();
    } else {
      LOGGER.severe("Unexpected class '" + value.getClass() + "'");
    }
    jgen.writeEndObject();
  }
}
