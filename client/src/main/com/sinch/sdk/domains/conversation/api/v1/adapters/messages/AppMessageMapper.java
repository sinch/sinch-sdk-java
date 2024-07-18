package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedLocationSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedMediaSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedTextSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateMessage;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class AppMessageMapper {

  private static final Logger LOGGER = Logger.getLogger(AppMessageMapper.class.getName());

  public static void initMapper() {
    SimpleModule module = new SimpleModule().addSerializer(AppMessageImpl.class, new Serializer());
    Mapper.getInstance()
        .addMixIn(AppMessageInternalImpl.class, AppMessageMapperMixin.class)
        .registerModule(module);
  }

  static class Serializer extends StdSerializer<AppMessageImpl> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<AppMessageImpl> t) {
      super(t);
    }

    @Override
    public void serialize(AppMessageImpl raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      AppMessageImpl<?> value = (AppMessageImpl<?>) raw;
      AppMessageInternal.Builder internal = AppMessageInternal.builder();

      value.explicitChannelMessage().ifPresent(internal::setExplicitChannelMessage);
      value.explicitChannelOmniMessage().ifPresent(internal::setExplicitChannelOmniMessage);
      value.channelSpecificMessage().ifPresent(internal::setChannelSpecificMessage);
      value.agent().ifPresent(internal::setAgent);
      value
          .message()
          .ifPresent(
              message -> {
                if (message instanceof CardMessage) {
                  internal.setCardMessage((CardMessage) message);
                } else if (message instanceof CarouselMessage) {
                  internal.setCarouselMessage((CarouselMessage) message);
                } else if (message instanceof ChoiceMessage) {
                  internal.setChoiceMessage((ChoiceMessage) message);
                } else if (message instanceof ContactInfoMessage) {
                  internal.setContactInfoMessage((ContactInfoMessage) message);
                } else if (message instanceof ListMessage) {
                  internal.setListMessage((ListMessage) message);
                } else if (message instanceof LocationMessage) {
                  internal.setLocationMessage((LocationMessage) message);
                } else if (message instanceof MediaMessage) {
                  internal.setMediaMessage((MediaMessage) message);
                } else if (message instanceof TemplateMessage) {
                  internal.setTemplateMessage((TemplateMessage) message);
                } else if (message instanceof TextMessage) {
                  internal.setTextMessage((TextMessage) message);
                } else {
                  LOGGER.severe("Unexpected class '" + message.getClass() + "'");
                }
              });

      jgen.writeObject(internal.build());
    }
  }

  public static class AppMessageMapperMixin extends AppMessageInternalImpl {

    @Override
    @JsonSerialize(using = DelegatedLocationSerializer.class)
    public OptionalValue<LocationMessage> locationMessage() {
      return super.locationMessage();
    }

    @Override
    @JsonSerialize(using = DelegatedMediaSerializer.class)
    public OptionalValue<MediaMessage> mediaMessage() {
      return super.mediaMessage();
    }

    @Override
    @JsonSerialize(using = DelegatedTextSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }

    @Override
    @JsonSerialize(using = OmniMessageOverrideSerializer.class)
    public OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
        explicitChannelOmniMessage() {
      return super.explicitChannelOmniMessage();
    }

    static class OmniMessageOverrideSerializer
        extends JsonSerializer<
            OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>> {

      @Override
      public void serialize(
          OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
              value,
          JsonGenerator jgen,
          SerializerProvider provider)
          throws IOException {

        if (!value.isPresent()) {
          return;
        }
        Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride> map = value.get();
        for (Map.Entry<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride> entry :
            map.entrySet()) {
          jgen.writeStartObject();
          jgen.writeFieldName(entry.getKey().getChannel().value());
          OmniMessageOverrideMapperHelper.serialize(entry.getValue(), jgen);
          jgen.writeEndObject();
        }
      }
    }
  }
}
