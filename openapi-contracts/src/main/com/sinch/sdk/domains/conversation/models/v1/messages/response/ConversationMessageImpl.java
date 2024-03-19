package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ConversationMessageImpl.JSON_PROPERTY_MESSAGE,
  ConversationMessageImpl.JSON_PROPERTY_ACCEPT_TIME,
  ConversationMessageImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  ConversationMessageImpl.JSON_PROPERTY_CONTACT_ID,
  ConversationMessageImpl.JSON_PROPERTY_CONVERSATION_ID,
  ConversationMessageImpl.JSON_PROPERTY_DIRECTION,
  ConversationMessageImpl.JSON_PROPERTY_ID,
  ConversationMessageImpl.JSON_PROPERTY_METADATA,
  ConversationMessageImpl.JSON_PROPERTY_INJECTED,
  ConversationMessageImpl.JSON_PROPERTY_SENDER_ID,
  ConversationMessageImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationMessageImpl implements ConversationMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<InjectMessageRequestMessage> message;

  public static final String JSON_PROPERTY_ACCEPT_TIME = "accept_time";

  private OptionalValue<Instant> acceptTime;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<ConversationDirection> direction;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_INJECTED = "injected";

  private OptionalValue<Boolean> injected;

  public static final String JSON_PROPERTY_SENDER_ID = "sender_id";

  private OptionalValue<String> senderId;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<String> processingMode;

  public ConversationMessageImpl() {}

  protected ConversationMessageImpl(
      OptionalValue<InjectMessageRequestMessage> message,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<String> conversationId,
      OptionalValue<ConversationDirection> direction,
      OptionalValue<String> id,
      OptionalValue<String> metadata,
      OptionalValue<Boolean> injected,
      OptionalValue<String> senderId,
      OptionalValue<String> processingMode) {
    this.message = message;
    this.acceptTime = acceptTime;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.conversationId = conversationId;
    this.direction = direction;
    this.id = id;
    this.metadata = metadata;
    this.injected = injected;
    this.senderId = senderId;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public InjectMessageRequestMessage getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InjectMessageRequestMessage> message() {
    return message;
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
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
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
  public String getConversationId() {
    return conversationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> conversationId() {
    return conversationId;
  }

  @JsonIgnore
  public ConversationDirection getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationDirection> direction() {
    return direction;
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
  public String getMetadata() {
    return metadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> metadata() {
    return metadata;
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
  public String getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> processingMode() {
    return processingMode;
  }

  /** Return true if this ConversationMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationMessageImpl conversationMessage = (ConversationMessageImpl) o;
    return Objects.equals(this.message, conversationMessage.message)
        && Objects.equals(this.acceptTime, conversationMessage.acceptTime)
        && Objects.equals(this.channelIdentity, conversationMessage.channelIdentity)
        && Objects.equals(this.contactId, conversationMessage.contactId)
        && Objects.equals(this.conversationId, conversationMessage.conversationId)
        && Objects.equals(this.direction, conversationMessage.direction)
        && Objects.equals(this.id, conversationMessage.id)
        && Objects.equals(this.metadata, conversationMessage.metadata)
        && Objects.equals(this.injected, conversationMessage.injected)
        && Objects.equals(this.senderId, conversationMessage.senderId)
        && Objects.equals(this.processingMode, conversationMessage.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        message,
        acceptTime,
        channelIdentity,
        contactId,
        conversationId,
        direction,
        id,
        metadata,
        injected,
        senderId,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationMessageImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    injected: ").append(toIndentedString(injected)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
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
  static class Builder implements ConversationMessage.Builder {
    OptionalValue<InjectMessageRequestMessage> message = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<ConversationDirection> direction = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<Boolean> injected = OptionalValue.empty();
    OptionalValue<String> senderId = OptionalValue.empty();
    OptionalValue<String> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(InjectMessageRequestMessage message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPT_TIME)
    public Builder setAcceptTime(Instant acceptTime) {
      this.acceptTime = OptionalValue.of(acceptTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIRECTION)
    public Builder setDirection(ConversationDirection direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INJECTED)
    public Builder setInjected(Boolean injected) {
      this.injected = OptionalValue.of(injected);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SENDER_ID)
    public Builder setSenderId(String senderId) {
      this.senderId = OptionalValue.of(senderId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(String processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public ConversationMessage build() {
      return new ConversationMessageImpl(
          message,
          acceptTime,
          channelIdentity,
          contactId,
          conversationId,
          direction,
          id,
          metadata,
          injected,
          senderId,
          processingMode);
    }
  }
}
