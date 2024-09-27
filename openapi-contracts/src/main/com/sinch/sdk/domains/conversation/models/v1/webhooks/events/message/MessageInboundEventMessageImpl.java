package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  MessageInboundEventMessageImpl.JSON_PROPERTY_ID,
  MessageInboundEventMessageImpl.JSON_PROPERTY_DIRECTION,
  MessageInboundEventMessageImpl.JSON_PROPERTY_CONTACT_MESSAGE,
  MessageInboundEventMessageImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  MessageInboundEventMessageImpl.JSON_PROPERTY_CONVERSATION_ID,
  MessageInboundEventMessageImpl.JSON_PROPERTY_CONTACT_ID,
  MessageInboundEventMessageImpl.JSON_PROPERTY_METADATA,
  MessageInboundEventMessageImpl.JSON_PROPERTY_ACCEPT_TIME,
  MessageInboundEventMessageImpl.JSON_PROPERTY_SENDER_ID,
  MessageInboundEventMessageImpl.JSON_PROPERTY_PROCESSING_MODE,
  MessageInboundEventMessageImpl.JSON_PROPERTY_INJECTED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageInboundEventMessageImpl implements MessageInboundEventMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<DirectionEnum> direction;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE = "contact_message";

  private OptionalValue<ContactMessage> contactMessage;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_ACCEPT_TIME = "accept_time";

  private OptionalValue<Instant> acceptTime;

  public static final String JSON_PROPERTY_SENDER_ID = "sender_id";

  private OptionalValue<String> senderId;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public static final String JSON_PROPERTY_INJECTED = "injected";

  private OptionalValue<Boolean> injected;

  public MessageInboundEventMessageImpl() {}

  protected MessageInboundEventMessageImpl(
      OptionalValue<String> id,
      OptionalValue<DirectionEnum> direction,
      OptionalValue<ContactMessage> contactMessage,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> conversationId,
      OptionalValue<String> contactId,
      OptionalValue<String> metadata,
      OptionalValue<Instant> acceptTime,
      OptionalValue<String> senderId,
      OptionalValue<ProcessingMode> processingMode,
      OptionalValue<Boolean> injected) {
    this.id = id;
    this.direction = direction;
    this.contactMessage = contactMessage;
    this.channelIdentity = channelIdentity;
    this.conversationId = conversationId;
    this.contactId = contactId;
    this.metadata = metadata;
    this.acceptTime = acceptTime;
    this.senderId = senderId;
    this.processingMode = processingMode;
    this.injected = injected;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public DirectionEnum getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DirectionEnum> direction() {
    return direction;
  }

  @JsonIgnore
  public ContactMessage getContactMessage() {
    return contactMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactMessage> contactMessage() {
    return contactMessage;
  }

  @JsonIgnore
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public String getConversationId() {
    return conversationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> conversationId() {
    return conversationId;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contactId() {
    return contactId;
  }

  @JsonIgnore
  public String getMetadata() {
    return metadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> metadata() {
    return metadata;
  }

  @JsonIgnore
  public Instant getAcceptTime() {
    return acceptTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPT_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> acceptTime() {
    return acceptTime;
  }

  @JsonIgnore
  public String getSenderId() {
    return senderId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SENDER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> senderId() {
    return senderId;
  }

  @JsonIgnore
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  @JsonIgnore
  public Boolean getInjected() {
    return injected.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INJECTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> injected() {
    return injected;
  }

  /** Return true if this MessageInboundEventItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageInboundEventMessageImpl messageInboundEventItem = (MessageInboundEventMessageImpl) o;
    return Objects.equals(this.id, messageInboundEventItem.id)
        && Objects.equals(this.direction, messageInboundEventItem.direction)
        && Objects.equals(this.contactMessage, messageInboundEventItem.contactMessage)
        && Objects.equals(this.channelIdentity, messageInboundEventItem.channelIdentity)
        && Objects.equals(this.conversationId, messageInboundEventItem.conversationId)
        && Objects.equals(this.contactId, messageInboundEventItem.contactId)
        && Objects.equals(this.metadata, messageInboundEventItem.metadata)
        && Objects.equals(this.acceptTime, messageInboundEventItem.acceptTime)
        && Objects.equals(this.senderId, messageInboundEventItem.senderId)
        && Objects.equals(this.processingMode, messageInboundEventItem.processingMode)
        && Objects.equals(this.injected, messageInboundEventItem.injected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        direction,
        contactMessage,
        channelIdentity,
        conversationId,
        contactId,
        metadata,
        acceptTime,
        senderId,
        processingMode,
        injected);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageInboundEventMessageImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    contactMessage: ").append(toIndentedString(contactMessage)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    injected: ").append(toIndentedString(injected)).append("\n");
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
  static class Builder implements MessageInboundEventMessage.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<DirectionEnum> direction = OptionalValue.empty();
    OptionalValue<ContactMessage> contactMessage = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<String> senderId = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();
    OptionalValue<Boolean> injected = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIRECTION)
    public Builder setDirection(DirectionEnum direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
    public Builder setContactMessage(ContactMessage contactMessage) {
      this.contactMessage = OptionalValue.of(contactMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPT_TIME)
    public Builder setAcceptTime(Instant acceptTime) {
      this.acceptTime = OptionalValue.of(acceptTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SENDER_ID)
    public Builder setSenderId(String senderId) {
      this.senderId = OptionalValue.of(senderId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INJECTED)
    public Builder setInjected(Boolean injected) {
      this.injected = OptionalValue.of(injected);
      return this;
    }

    public MessageInboundEventMessage build() {
      return new MessageInboundEventMessageImpl(
          id,
          direction,
          contactMessage,
          channelIdentity,
          conversationId,
          contactId,
          metadata,
          acceptTime,
          senderId,
          processingMode,
          injected);
    }
  }
}
