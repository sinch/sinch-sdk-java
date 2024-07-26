package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternal;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  InjectMessageRequestImpl.JSON_PROPERTY_APP_MESSAGE,
  InjectMessageRequestImpl.JSON_PROPERTY_CONTACT_MESSAGE,
  InjectMessageRequestImpl.JSON_PROPERTY_ACCEPT_TIME,
  InjectMessageRequestImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  InjectMessageRequestImpl.JSON_PROPERTY_CONTACT_ID,
  InjectMessageRequestImpl.JSON_PROPERTY_DIRECTION,
  InjectMessageRequestImpl.JSON_PROPERTY_CONVERSATION_ID,
  InjectMessageRequestImpl.JSON_PROPERTY_INJECTED,
  InjectMessageRequestImpl.JSON_PROPERTY_SENDER_ID,
  InjectMessageRequestImpl.JSON_PROPERTY_PROCESSING_MODE,
  InjectMessageRequestImpl.JSON_PROPERTY_METADATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InjectMessageRequestImpl implements InjectMessageRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_MESSAGE = "app_message";

  private OptionalValue<AppMessageInternal> appMessage;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE = "contact_message";

  private OptionalValue<ContactMessage> contactMessage;

  public static final String JSON_PROPERTY_ACCEPT_TIME = "accept_time";

  private OptionalValue<Instant> acceptTime;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<ConversationDirection> direction;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_INJECTED = "injected";

  private OptionalValue<Boolean> injected;

  public static final String JSON_PROPERTY_SENDER_ID = "sender_id";

  private OptionalValue<String> senderId;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public InjectMessageRequestImpl() {}

  protected InjectMessageRequestImpl(
      OptionalValue<AppMessageInternal> appMessage,
      OptionalValue<ContactMessage> contactMessage,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<ConversationDirection> direction,
      OptionalValue<String> conversationId,
      OptionalValue<Boolean> injected,
      OptionalValue<String> senderId,
      OptionalValue<ProcessingMode> processingMode,
      OptionalValue<String> metadata) {
    this.appMessage = appMessage;
    this.contactMessage = contactMessage;
    this.acceptTime = acceptTime;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.direction = direction;
    this.conversationId = conversationId;
    this.injected = injected;
    this.senderId = senderId;
    this.processingMode = processingMode;
    this.metadata = metadata;
  }

  @JsonIgnore
  public AppMessageInternal getAppMessage() {
    return appMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<AppMessageInternal> appMessage() {
    return appMessage;
  }

  @JsonIgnore
  public ContactMessage getContactMessage() {
    return contactMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ContactMessage> contactMessage() {
    return contactMessage;
  }

  @JsonIgnore
  public Instant getAcceptTime() {
    return acceptTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPT_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> acceptTime() {
    return acceptTime;
  }

  @JsonIgnore
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> contactId() {
    return contactId;
  }

  @JsonIgnore
  public ConversationDirection getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ConversationDirection> direction() {
    return direction;
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
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
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

  /** Return true if this InjectMessageRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InjectMessageRequestImpl injectMessageRequest = (InjectMessageRequestImpl) o;
    return Objects.equals(this.appMessage, injectMessageRequest.appMessage)
        && Objects.equals(this.contactMessage, injectMessageRequest.contactMessage)
        && Objects.equals(this.acceptTime, injectMessageRequest.acceptTime)
        && Objects.equals(this.channelIdentity, injectMessageRequest.channelIdentity)
        && Objects.equals(this.contactId, injectMessageRequest.contactId)
        && Objects.equals(this.direction, injectMessageRequest.direction)
        && Objects.equals(this.conversationId, injectMessageRequest.conversationId)
        && Objects.equals(this.injected, injectMessageRequest.injected)
        && Objects.equals(this.senderId, injectMessageRequest.senderId)
        && Objects.equals(this.processingMode, injectMessageRequest.processingMode)
        && Objects.equals(this.metadata, injectMessageRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appMessage,
        contactMessage,
        acceptTime,
        channelIdentity,
        contactId,
        direction,
        conversationId,
        injected,
        senderId,
        processingMode,
        metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InjectMessageRequestImpl {\n");
    sb.append("    appMessage: ").append(toIndentedString(appMessage)).append("\n");
    sb.append("    contactMessage: ").append(toIndentedString(contactMessage)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    injected: ").append(toIndentedString(injected)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
  static class Builder implements InjectMessageRequest.Builder {
    OptionalValue<AppMessageInternal> appMessage = OptionalValue.empty();
    OptionalValue<ContactMessage> contactMessage = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<ConversationDirection> direction = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<Boolean> injected = OptionalValue.empty();
    OptionalValue<String> senderId = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_MESSAGE)
    public Builder setAppMessage(AppMessageInternal appMessage) {
      this.appMessage = OptionalValue.of(appMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE)
    public Builder setContactMessage(ContactMessage contactMessage) {
      this.contactMessage = OptionalValue.of(contactMessage);
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

    @JsonProperty(JSON_PROPERTY_DIRECTION)
    public Builder setDirection(ConversationDirection direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
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
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    public InjectMessageRequest build() {
      return new InjectMessageRequestImpl(
          appMessage,
          contactMessage,
          acceptTime,
          channelIdentity,
          contactId,
          direction,
          conversationId,
          injected,
          senderId,
          processingMode,
          metadata);
    }
  }
}
