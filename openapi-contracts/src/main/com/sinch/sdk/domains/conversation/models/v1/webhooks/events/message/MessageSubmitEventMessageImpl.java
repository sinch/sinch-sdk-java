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
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageWithExtensions;
import java.util.Objects;

@JsonPropertyOrder({
  MessageSubmitEventMessageImpl.JSON_PROPERTY_MESSAGE_ID,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_CONVERSATION_ID,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_CONTACT_ID,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_SUBMITTED_MESSAGE,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_METADATA,
  MessageSubmitEventMessageImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageSubmitEventMessageImpl implements MessageSubmitEventMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_SUBMITTED_MESSAGE = "submitted_message";

  private OptionalValue<AppMessageWithExtensions<?>> submittedMessage;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public MessageSubmitEventMessageImpl() {}

  protected MessageSubmitEventMessageImpl(
      OptionalValue<String> messageId,
      OptionalValue<String> conversationId,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<AppMessageWithExtensions<?>> submittedMessage,
      OptionalValue<String> metadata,
      OptionalValue<ProcessingMode> processingMode) {
    this.messageId = messageId;
    this.conversationId = conversationId;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.submittedMessage = submittedMessage;
    this.metadata = metadata;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public String getMessageId() {
    return messageId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messageId() {
    return messageId;
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
  public AppMessageWithExtensions<?> getSubmittedMessage() {
    return submittedMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUBMITTED_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppMessageWithExtensions<?>> submittedMessage() {
    return submittedMessage;
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
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  /**
   * Return true if this MessageSubmitEvent_allOf_message_submit_notification object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageSubmitEventMessageImpl messageSubmitEventAllOfMessageSubmitNotification =
        (MessageSubmitEventMessageImpl) o;
    return Objects.equals(
            this.messageId, messageSubmitEventAllOfMessageSubmitNotification.messageId)
        && Objects.equals(
            this.conversationId, messageSubmitEventAllOfMessageSubmitNotification.conversationId)
        && Objects.equals(
            this.channelIdentity, messageSubmitEventAllOfMessageSubmitNotification.channelIdentity)
        && Objects.equals(
            this.contactId, messageSubmitEventAllOfMessageSubmitNotification.contactId)
        && Objects.equals(
            this.submittedMessage,
            messageSubmitEventAllOfMessageSubmitNotification.submittedMessage)
        && Objects.equals(this.metadata, messageSubmitEventAllOfMessageSubmitNotification.metadata)
        && Objects.equals(
            this.processingMode, messageSubmitEventAllOfMessageSubmitNotification.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        messageId,
        conversationId,
        channelIdentity,
        contactId,
        submittedMessage,
        metadata,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageSubmitEventMessageImpl {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    submittedMessage: ").append(toIndentedString(submittedMessage)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
  static class Builder implements MessageSubmitEventMessage.Builder {
    OptionalValue<String> messageId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<AppMessageWithExtensions<?>> submittedMessage = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    public Builder setMessageId(String messageId) {
      this.messageId = OptionalValue.of(messageId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
    public Builder setConversationId(String conversationId) {
      this.conversationId = OptionalValue.of(conversationId);
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

    @JsonProperty(JSON_PROPERTY_SUBMITTED_MESSAGE)
    public Builder setSubmittedMessage(AppMessageWithExtensions<?> submittedMessage) {
      this.submittedMessage = OptionalValue.of(submittedMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public MessageSubmitEventMessage build() {
      return new MessageSubmitEventMessageImpl(
          messageId,
          conversationId,
          channelIdentity,
          contactId,
          submittedMessage,
          metadata,
          processingMode);
    }
  }
}
