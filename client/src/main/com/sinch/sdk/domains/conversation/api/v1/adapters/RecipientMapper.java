package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.internal.RecipientInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.IdentifiedByFieldInternal;
import java.io.IOException;
import java.util.logging.Logger;

public class RecipientMapper {

  private static final Logger LOGGER = Logger.getLogger(RecipientMapper.class.getName());

  public static void initMapper() {
    SimpleModule module = new SimpleModule();
    module
        .addSerializer(Recipient.class, new RecipientSerializer())
        .addDeserializer(Recipient.class, new RecipientDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class RecipientSerializer extends StdSerializer<Recipient> {

    public RecipientSerializer() {
      this(null);
    }

    public RecipientSerializer(Class<Recipient> t) {
      super(t);
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

  static class RecipientDeserializer extends StdDeserializer<Recipient> {

    public RecipientDeserializer() {
      this(null);
    }

    public RecipientDeserializer(Class<Recipient> vc) {
      super(vc);
    }

    @Override
    public Recipient deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      RecipientInternalImpl deserialized = jp.readValueAs(RecipientInternalImpl.class);
      Object value = deserialized.getActualInstance();
      if (value instanceof IdentifiedByFieldInternal) {
        return ((IdentifiedByFieldInternal) value).getIdentifiedBy();
      } else if (value instanceof ContactId) {
        return (ContactId) value;
      }
      LOGGER.severe("Unexpected class '" + value.getClass() + "'");
      return null;
    }
  }
}
