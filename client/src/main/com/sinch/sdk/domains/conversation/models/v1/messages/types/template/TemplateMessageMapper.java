package com.sinch.sdk.domains.conversation.models.v1.messages.types.template;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReference;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceImpl;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternal;
import com.sinch.sdk.domains.conversation.models.v1.internal.TemplateReferenceInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TemplateMessageFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TemplateMessageFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TemplateMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.TemplateMessageInternalImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TemplateMessageMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .registerModule(
            new SimpleModule()
                .addSerializer(TemplateMessage.class, new Serializer())
                .addDeserializer(TemplateMessage.class, new DeSerializer()));
  }

  public static class Serializer extends StdSerializer<TemplateMessage> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<TemplateMessage> vc) {
      super(vc);
    }

    @Override
    public void serialize(TemplateMessage raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
      jgen.writeObject(
          TemplateMessageFieldInternal.builder().setTemplateMessage(convert(raw)).build());
    }
  }

  static class DeSerializer extends StdDeserializer<TemplateMessage> {

    public DeSerializer() {
      this(null);
    }

    public DeSerializer(Class<TemplateMessage> vc) {
      super(vc);
    }

    @Override
    public TemplateMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      TemplateMessageFieldInternalImpl deserialized =
          jp.readValueAs(TemplateMessageFieldInternalImpl.class);
      return convert(deserialized);
    }
  }

  private static TemplateMessage convert(TemplateMessageFieldInternalImpl from) {
    TemplateMessage.Builder builder = TemplateMessage.builder();

    from.templateMessage()
        .ifPresent(
            f -> {
              TemplateMessageInternalImpl impl = (TemplateMessageInternalImpl) f;
              impl.channelTemplate()
                  .ifPresent(
                      m -> {
                        Map<ConversationChannel, TemplateReference> newMap = new HashMap<>();
                        m.forEach((channel, reference) -> newMap.put(channel, convert(reference)));
                        builder.setChannelTemplate(newMap);
                      });
              impl.omniTemplate().ifPresent(o -> builder.setOmniTemplate(convert(o)));
            });

    return builder.build();
  }

  private static TemplateMessage convert(TemplateMessageInternal _from) {

    TemplateMessage.Builder builder = TemplateMessage.builder();
    TemplateMessageInternalImpl from = (TemplateMessageInternalImpl) _from;
    from.channelTemplate()
        .ifPresent(
            m -> {
              Map<ConversationChannel, TemplateReference> newMap = new HashMap<>();
              m.forEach((channel, reference) -> newMap.put(channel, convert(reference)));
              builder.setChannelTemplate(newMap);
            });
    from.omniTemplate().ifPresent(o -> builder.setOmniTemplate(convert(o)));
    return builder.build();
  }

  private static TemplateMessageInternal convert(TemplateMessage _from) {

    TemplateMessageImpl from = (TemplateMessageImpl) _from;
    TemplateMessageInternal.Builder internal = TemplateMessageInternal.builder();

    from.channelTemplate()
        .ifPresent(
            m -> {
              Map<ConversationChannel, TemplateReferenceInternal> newMap = new HashMap<>();
              m.forEach((channel, reference) -> newMap.put(channel, convert(reference)));
              internal.setChannelTemplate(newMap);
            });
    from.omniTemplate().ifPresent(o -> internal.setOmniTemplate(convert(o)));
    return internal.build();
  }

  private static TemplateReferenceInternal convert(TemplateReference _from) {
    TemplateReferenceImpl from = (TemplateReferenceImpl) _from;
    TemplateReferenceInternal.Builder builder = TemplateReferenceInternal.builder();
    from.languageCode().ifPresent(builder::setLanguageCode);
    from.parameters().ifPresent(builder::setParameters);
    from.templateId().ifPresent(builder::setTemplateId);
    from.version().ifPresent(builder::setVersion);
    return builder.build();
  }

  private static TemplateReference convert(TemplateReferenceInternal _from) {
    TemplateReferenceInternalImpl from = (TemplateReferenceInternalImpl) _from;
    TemplateReference.Builder builder = TemplateReference.builder();
    from.languageCode().ifPresent(builder::setLanguageCode);
    from.parameters().ifPresent(builder::setParameters);
    from.templateId().ifPresent(builder::setTemplateId);
    from.version().ifPresent(builder::setVersion);
    return builder.build();
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<TemplateMessage>> {

    @Override
    public void serialize(
        OptionalValue<TemplateMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      jgen.writeObject(convert(value.get()));
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<TemplateMessage> {
    @Override
    public TemplateMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {
      TemplateMessageInternalImpl deserialized = jp.readValueAs(TemplateMessageInternalImpl.class);
      return convert(deserialized);
    }
  }
}
