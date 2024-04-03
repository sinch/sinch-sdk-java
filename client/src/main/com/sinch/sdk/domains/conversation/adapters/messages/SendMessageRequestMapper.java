package com.sinch.sdk.domains.conversation.adapters.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequestImpl;
import java.io.IOException;
import java.util.logging.Logger;

@JsonFilter("uninitializedFilter")
public class SendMessageRequestMapper extends SendMessageRequestImpl {

  private static final Logger LOGGER = Logger.getLogger(SendMessageRequestMapper.class.getName());

  public SendMessageRequestMapper() {
    super();
  }

  public static void initMapper() {
    Mapper.getInstance().addMixIn(SendMessageRequestImpl.class, SendMessageRequestMapper.class);
  }

  @Override
  @JsonSerialize(using = TTLSerializer.class)
  public OptionalValue<Integer> ttl() {
    return super.ttl();
  }

  @Override
  @JsonSerialize(using = AppMessageSerializer.class)
  public OptionalValue<AppMessage<?>> message() {
    return super.message();
  }

  /**
   * Serializer TTL value ttl values are defined as Integer for ease of use from SDK but unto
   * serialize/deserialize: it had to be managed as String with a trailing `s` as "seconds"
   */
  static class TTLSerializer extends JsonSerializer<OptionalValue<Integer>> {

    public TTLSerializer() {
      super();
    }

    @Override
    public void serialize(
        OptionalValue<Integer> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
      if (value.isPresent()) {
        jgen.writeObject(String.format("%ds", value.get()));
      }
    }
  }

  /**
   * Serializer an AppMessage: handle "single dedicated message type" vs "JSON payload oneOf
   * representation with multiple fields" conversion
   */
  static class AppMessageSerializer extends JsonSerializer<OptionalValue<AppMessageImpl<?>>> {

    public AppMessageSerializer() {
      super();
    }

    @Override
    public void serialize(
        OptionalValue<AppMessageImpl<?>> optional, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!optional.isPresent()) {
        return;
      }
      AppMessageImpl<?> value = optional.get();
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
}
