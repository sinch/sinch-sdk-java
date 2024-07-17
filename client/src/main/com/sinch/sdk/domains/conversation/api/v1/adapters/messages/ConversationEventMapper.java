package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.events.app.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.app.internal.AppEventFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.app.internal.AppEventFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.ContactEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.internal.ContactEventFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.internal.ContactEventFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.ContactMessageEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.internal.ContactMessageEventFieldInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.internal.ContactMessageEventFieldInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.conversation.ConversationEventContent;
import com.sinch.sdk.domains.conversation.models.v1.events.conversation.ConversationEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.conversation.internal.ConversationEventEventInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class ConversationEventMapper {

  private static final Logger LOGGER = Logger.getLogger(ConversationEventMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addDeserializer(
                ConversationEventContent.class, new ConversationEventContentDeserializer());
    Mapper.getInstance()
        .addMixIn(ConversationEventImpl.class, ConversationEventMixin.class)
        .registerModule(module);
  }

  static class ConversationEventContentDeserializer
      extends StdDeserializer<ConversationEventContent> {

    public ConversationEventContentDeserializer() {
      this(null);
    }

    public ConversationEventContentDeserializer(Class<ConversationEventContent> vc) {
      super(vc);
    }

    @Override
    public ConversationEventContent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      Object deserialized =
          jp.readValueAs(ConversationEventEventInternalImpl.class).getActualInstance();
      if (deserialized instanceof AppEventFieldInternal) {
        return ((AppEventFieldInternal) deserialized).getAppEvent();
      } else if (deserialized instanceof ContactEventFieldInternal) {
        return ((ContactEventFieldInternal) deserialized).getContactEvent();
      } else if (deserialized instanceof ContactMessageEventFieldInternal) {
        return ((ContactMessageEventFieldInternal) deserialized).getContactMessageEvent();
      } else {
        LOGGER.severe("Unexpected content'" + deserialized + "'");
        return null;
      }
    }
  }

  static class ConversationEventMixin extends ConversationEventImpl {

    @Override
    @JsonSerialize(using = DelegatedEventSerializer.class)
    public OptionalValue<ConversationEventContent> event() {
      return super.event();
    }
  }

  static class DelegatedEventSerializer
      extends JsonSerializer<OptionalValue<ConversationEventContent>> {

    @Override
    public void serialize(
        OptionalValue<ConversationEventContent> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      Object content = value.get();
      if (content instanceof AppEvent) {
        jgen.writeObject(
            new ConversationEventEventInternalImpl(
                (AppEventFieldInternalImpl)
                    AppEventFieldInternal.builder().setAppEvent((AppEvent) content).build()));
      } else if (content instanceof ContactEvent) {
        jgen.writeObject(
            new ConversationEventEventInternalImpl(
                (ContactEventFieldInternalImpl)
                    ContactEventFieldInternal.builder()
                        .setContactEvent((ContactEvent) content)
                        .build()));
      } else if (content instanceof ContactMessageEvent) {
        jgen.writeObject(
            new ConversationEventEventInternalImpl(
                (ContactMessageEventFieldInternalImpl)
                    ContactMessageEventFieldInternal.builder()
                        .setContactMessageEvent((ContactMessageEvent) content)
                        .build()));
      } else {
        LOGGER.severe("Unexpected content': " + content + "'");
      }
    }
  }
}
