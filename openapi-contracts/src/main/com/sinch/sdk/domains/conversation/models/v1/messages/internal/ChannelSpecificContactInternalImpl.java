package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelSpecificContactInternalImpl.JSON_PROPERTY_MESSAGE_TYPE,
  ChannelSpecificContactInternalImpl.JSON_PROPERTY_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelSpecificContactInternalImpl implements ChannelSpecificContactInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_TYPE = "message_type";

  private OptionalValue<MessageTypeEnum> messageType;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<ChannelSpecificContactMessageInternal> message;

  public ChannelSpecificContactInternalImpl() {}

  protected ChannelSpecificContactInternalImpl(
      OptionalValue<MessageTypeEnum> messageType,
      OptionalValue<ChannelSpecificContactMessageInternal> message) {
    this.messageType = messageType;
    this.message = message;
  }

  @JsonIgnore
  public MessageTypeEnum getMessageType() {
    return messageType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageTypeEnum> messageType() {
    return messageType;
  }

  @JsonIgnore
  public ChannelSpecificContactMessageInternal getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelSpecificContactMessageInternal> message() {
    return message;
  }

  /**
   * Return true if this ChannelSpecificContactMessage_channel_specific_message object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSpecificContactInternalImpl channelSpecificContactMessageChannelSpecificMessage =
        (ChannelSpecificContactInternalImpl) o;
    return Objects.equals(
            this.messageType, channelSpecificContactMessageChannelSpecificMessage.messageType)
        && Objects.equals(
            this.message, channelSpecificContactMessageChannelSpecificMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageType, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSpecificContactInternalImpl {\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ChannelSpecificContactInternal.Builder {
    OptionalValue<MessageTypeEnum> messageType = OptionalValue.empty();
    OptionalValue<ChannelSpecificContactMessageInternal> message = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
    public Builder setMessageType(MessageTypeEnum messageType) {
      this.messageType = OptionalValue.of(messageType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(ChannelSpecificContactMessageInternal message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public ChannelSpecificContactInternal build() {
      return new ChannelSpecificContactInternalImpl(messageType, message);
    }
  }
}
