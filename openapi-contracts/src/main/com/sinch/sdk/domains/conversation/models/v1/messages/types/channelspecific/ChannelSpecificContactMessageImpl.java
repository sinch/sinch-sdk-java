package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificContactInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificContactInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChannelSpecificContactMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({ChannelSpecificContactMessageImpl.JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelSpecificContactMessageImpl
    implements ChannelSpecificContactMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE = "channel_specific_message";

  private OptionalValue<ChannelSpecificContactInternal> channelSpecificMessage;

  public ChannelSpecificContactMessageImpl() {}

  protected ChannelSpecificContactMessageImpl(
      OptionalValue<ChannelSpecificContactInternal> channelSpecificMessage) {
    this.channelSpecificMessage = channelSpecificMessage;
  }

  @JsonIgnore
  public ChannelSpecificContactInternal getChannelSpecificMessage() {
    return channelSpecificMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelSpecificContactInternal> channelSpecificMessage() {
    return channelSpecificMessage;
  }

  @JsonIgnore
  public MessageTypeEnum getMessageType() {
    if (null == channelSpecificMessage
        || !channelSpecificMessage.isPresent()
        || null == channelSpecificMessage.get().getMessageType()) {
      return null;
    }
    return MessageTypeEnum.from(channelSpecificMessage.get().getMessageType().value());
  }

  public OptionalValue<MessageTypeEnum> messageType() {
    return null != channelSpecificMessage
        ? channelSpecificMessage.map(
            f -> MessageTypeEnum.from(channelSpecificMessage.get().getMessageType().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public ChannelSpecificContactMessageInternal getMessage() {
    if (null == channelSpecificMessage
        || !channelSpecificMessage.isPresent()
        || null == channelSpecificMessage.get().getMessage()) {
      return null;
    }
    return channelSpecificMessage.get().getMessage();
  }

  public OptionalValue<ChannelSpecificContactMessageInternal> message() {
    return null != channelSpecificMessage
        ? channelSpecificMessage.map(ChannelSpecificContactInternal::getMessage)
        : OptionalValue.empty();
  }

  /** Return true if this ChannelSpecificContactMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelSpecificContactMessageImpl channelSpecificContactMessage =
        (ChannelSpecificContactMessageImpl) o;
    return Objects.equals(
        this.channelSpecificMessage, channelSpecificContactMessage.channelSpecificMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelSpecificMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelSpecificContactMessageImpl {\n");
    sb.append("    channelSpecificMessage: ")
        .append(toIndentedString(channelSpecificMessage))
        .append("\n");
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
  static class Builder implements ChannelSpecificContactMessage.Builder {
    OptionalValue<ChannelSpecificContactInternal> channelSpecificMessage = OptionalValue.empty();

    ChannelSpecificContactInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE, required = true)
    public Builder setChannelSpecificMessage(
        ChannelSpecificContactInternal channelSpecificMessage) {
      this.channelSpecificMessage = OptionalValue.of(channelSpecificMessage);
      return this;
    }

    @JsonIgnore
    public Builder setMessageType(MessageTypeEnum messageType) {
      getDelegatedBuilder()
          .setMessageType(
              null != messageType
                  ? ChannelSpecificContactInternalImpl.MessageTypeEnum.from(messageType.value())
                  : null);
      return this;
    }

    @JsonIgnore
    public Builder setMessage(ChannelSpecificContactMessageInternal message) {
      getDelegatedBuilder().setMessage(message);
      return this;
    }

    private ChannelSpecificContactInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ChannelSpecificContactInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ChannelSpecificContactMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.channelSpecificMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ChannelSpecificContactMessageImpl(channelSpecificMessage);
    }
  }
}
