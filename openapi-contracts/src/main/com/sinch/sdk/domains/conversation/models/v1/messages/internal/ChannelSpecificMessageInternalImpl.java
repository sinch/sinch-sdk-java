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
  ChannelSpecificMessageInternalImpl.JSON_PROPERTY_MESSAGE_TYPE,
  ChannelSpecificMessageInternalImpl.JSON_PROPERTY_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelSpecificMessageInternalImpl implements ChannelSpecificMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_TYPE = "message_type";

  private OptionalValue<MessageTypeEnum> messageType;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<ChannelSpecificMessageMessageInternal> message;

  public ChannelSpecificMessageInternalImpl() {}

  protected ChannelSpecificMessageInternalImpl(
      OptionalValue<MessageTypeEnum> messageType,
      OptionalValue<ChannelSpecificMessageMessageInternal> message) {
    this.messageType = messageType;
    this.message = message;
  }

  @JsonIgnore
  public MessageTypeEnum getMessageType() {
    return messageType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MessageTypeEnum> messageType() {
    return messageType;
  }

  @JsonIgnore
  public ChannelSpecificMessageMessageInternal getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChannelSpecificMessageMessageInternal> message() {
    return message;
  }

  /** Return true if this ChannelSpecificMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSpecificMessageInternalImpl channelSpecificMessage =
        (ChannelSpecificMessageInternalImpl) o;
    return Objects.equals(this.messageType, channelSpecificMessage.messageType)
        && Objects.equals(this.message, channelSpecificMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageType, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSpecificMessageInternalImpl {\n");
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
  static class Builder implements ChannelSpecificMessageInternal.Builder {
    OptionalValue<MessageTypeEnum> messageType = OptionalValue.empty();
    OptionalValue<ChannelSpecificMessageMessageInternal> message = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
    public Builder setMessageType(MessageTypeEnum messageType) {
      this.messageType = OptionalValue.of(messageType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(ChannelSpecificMessageMessageInternal message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public ChannelSpecificMessageInternal build() {
      return new ChannelSpecificMessageInternalImpl(messageType, message);
    }
  }
}
