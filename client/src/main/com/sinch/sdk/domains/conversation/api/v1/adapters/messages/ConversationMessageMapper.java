package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.internal.ConversationMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.internal.ConversationMessageInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageWithExtensions;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class ConversationMessageMapper {

  private static final Logger LOGGER = Logger.getLogger(ConversationMessageMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(ConversationMessage.class, new Serializer())
            .addDeserializer(ConversationMessage.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ConversationMessage> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ConversationMessage> vc) {
      super(vc);
    }

    @Override
    public ConversationMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ConversationMessageInternal deserialized = jp.readValueAs(ConversationMessageInternal.class);
      return convert(deserialized);
    }
  }

  static class Serializer extends StdSerializer<ConversationMessage> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<ConversationMessage> t) {
      super(t);
    }

    @Override
    public void serialize(ConversationMessage raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      Object value = convert(raw);
      if (null != value) {
        jgen.writeObject(value);
      }
    }
  }

  public static ConversationMessageInternal convert(ConversationMessage _from) {
    if (null == _from) {
      return null;
    }
    ConversationMessageImpl from = (ConversationMessageImpl) _from;
    ConversationMessageInternal.Builder internal = ConversationMessageInternal.builder();

    if (from.content().isPresent()) {
      Object content = from.content().get();
      if (content instanceof AppMessageWithExtensions) {
        internal.setAppMessage((AppMessageWithExtensions<?>) content);
      } else {
        internal.setContactMessage((ContactMessage) content);
      }
    }
    from.acceptTime().ifPresent(internal::setAcceptTime);
    from.channelIdentity().ifPresent(internal::setChannelIdentity);
    from.contactId().ifPresent(internal::setContactId);
    from.conversationId().ifPresent(internal::setConversationId);
    from.direction().ifPresent(internal::setDirection);
    from.id().ifPresent(internal::setId);
    from.metadata().ifPresent(internal::setMetadata);
    from.injected().ifPresent(internal::setInjected);
    from.senderId().ifPresent(internal::setSenderId);
    from.processingMode().ifPresent(internal::setProcessingMode);
    return internal.build();
  }

  public static ConversationMessage convert(ConversationMessageInternal _from) {
    if (null == _from) {
      return null;
    }
    ConversationMessageInternalImpl from = (ConversationMessageInternalImpl) _from;
    ConversationMessage.Builder internal = ConversationMessage.builder();

    from.appMessage().ifPresent(internal::setContent);
    from.contactMessage().ifPresent(internal::setContent);
    from.acceptTime().ifPresent(internal::setAcceptTime);
    from.channelIdentity().ifPresent(internal::setChannelIdentity);
    from.contactId().ifPresent(internal::setContactId);
    from.conversationId().ifPresent(internal::setConversationId);
    from.direction().ifPresent(internal::setDirection);
    from.id().ifPresent(internal::setId);
    from.metadata().ifPresent(internal::setMetadata);
    from.injected().ifPresent(internal::setInjected);
    from.senderId().ifPresent(internal::setSenderId);
    from.processingMode().ifPresent(internal::setProcessingMode);
    return internal.build();
  }
}
