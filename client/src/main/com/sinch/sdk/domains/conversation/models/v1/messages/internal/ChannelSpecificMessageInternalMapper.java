package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificMessageInternal.MessageTypeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChannelSpecificMessageInternalMapper {
  private static final Logger LOGGER =
      Logger.getLogger(ChannelSpecificMessageInternalMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(ChannelSpecificMessage.class, new Deserializer());

    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ChannelSpecificMessage> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ChannelSpecificMessageInternal> vc) {
      super(vc);
    }

    @Override
    public ChannelSpecificMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      Object deserialized = jp.readValueAs(ChannelSpecificMessageInternal.class);

      if (null == deserialized) {
        return null;
      }
      if (!(deserialized instanceof ChannelSpecificMessageInternal)) {
        // do not throw exception to not break all schema's deserialization
        LOGGER.log(Level.SEVERE, "Input data does not match schema: {}", deserialized);
        return null;
      }

      ChannelSpecificMessageInternalImpl channelSpecificMessageInternalImpl =
          (ChannelSpecificMessageInternalImpl) deserialized;
      ChannelSpecificMessageMessageInternalImpl channelSpecificMessageMessageInternal =
          (ChannelSpecificMessageMessageInternalImpl)
              channelSpecificMessageInternalImpl.getMessage();

      if (null == channelSpecificMessageMessageInternal) {
        return null;
      }
      return (ChannelSpecificMessage) channelSpecificMessageMessageInternal.getActualInstance();
    }
  }

  static class ChannelSpecificMessageMapSerializer
      extends StdSerializer<OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>>> {

    public ChannelSpecificMessageMapSerializer() {
      this(null);
    }

    public ChannelSpecificMessageMapSerializer(
        Class<OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>>> t) {
      super(t);
    }

    @Override
    public void serialize(
        OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> raw,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (null == raw || !raw.isPresent()) {
        return;
      }

      Map<ConversationChannel, ChannelSpecificMessage> value = raw.get();
      if (null == value) {
        jgen.writeObject(null);
        return;
      }

      Map<ConversationChannel, ChannelSpecificMessageInternal> out = new HashMap<>(value.size());
      value.forEach(
          (channel, message) -> {
            ChannelSpecificMessageMessageInternalImpl internal =
                new ChannelSpecificMessageMessageInternalImpl();
            internal.setActualInstance(message);

            MessageTypeEnum type = null;
            ChannelSpecificMessageInternal.Builder builder =
                ChannelSpecificMessageInternal.builder();
            if (message instanceof FlowChannelSpecificMessage) {
              type = MessageTypeEnum.FLOWS;
            } else {
              // do not throw exception to not break all schema's serialization
              LOGGER.log(Level.SEVERE, "Unexpected message: {}", message);
            }
            builder.setMessageType(type).setMessage(internal);
            out.put(channel, builder.build());
          });

      jgen.writeObject(out);
    }
  }
}
