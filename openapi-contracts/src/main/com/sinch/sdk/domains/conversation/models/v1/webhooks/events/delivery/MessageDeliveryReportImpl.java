package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.Reason;
import java.util.Objects;

@JsonPropertyOrder({
  MessageDeliveryReportImpl.JSON_PROPERTY_MESSAGE_ID,
  MessageDeliveryReportImpl.JSON_PROPERTY_CONVERSATION_ID,
  MessageDeliveryReportImpl.JSON_PROPERTY_STATUS,
  MessageDeliveryReportImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  MessageDeliveryReportImpl.JSON_PROPERTY_CONTACT_ID,
  MessageDeliveryReportImpl.JSON_PROPERTY_REASON,
  MessageDeliveryReportImpl.JSON_PROPERTY_METADATA,
  MessageDeliveryReportImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageDeliveryReportImpl implements MessageDeliveryReport {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";

  private OptionalValue<String> messageId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<DeliveryStatus> status;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<Reason> reason;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public MessageDeliveryReportImpl() {}

  protected MessageDeliveryReportImpl(
      OptionalValue<String> messageId,
      OptionalValue<String> conversationId,
      OptionalValue<DeliveryStatus> status,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<Reason> reason,
      OptionalValue<String> metadata,
      OptionalValue<ProcessingMode> processingMode) {
    this.messageId = messageId;
    this.conversationId = conversationId;
    this.status = status;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.reason = reason;
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
  public DeliveryStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DeliveryStatus> status() {
    return status;
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
  public Reason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Reason> reason() {
    return reason;
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
   * Return true if this MessageDeliveryReceiptEvent_allOf_message_delivery_report object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageDeliveryReportImpl messageDeliveryReceiptEventAllOfMessageDeliveryReport =
        (MessageDeliveryReportImpl) o;
    return Objects.equals(
            this.messageId, messageDeliveryReceiptEventAllOfMessageDeliveryReport.messageId)
        && Objects.equals(
            this.conversationId,
            messageDeliveryReceiptEventAllOfMessageDeliveryReport.conversationId)
        && Objects.equals(this.status, messageDeliveryReceiptEventAllOfMessageDeliveryReport.status)
        && Objects.equals(
            this.channelIdentity,
            messageDeliveryReceiptEventAllOfMessageDeliveryReport.channelIdentity)
        && Objects.equals(
            this.contactId, messageDeliveryReceiptEventAllOfMessageDeliveryReport.contactId)
        && Objects.equals(this.reason, messageDeliveryReceiptEventAllOfMessageDeliveryReport.reason)
        && Objects.equals(
            this.metadata, messageDeliveryReceiptEventAllOfMessageDeliveryReport.metadata)
        && Objects.equals(
            this.processingMode,
            messageDeliveryReceiptEventAllOfMessageDeliveryReport.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        messageId,
        conversationId,
        status,
        channelIdentity,
        contactId,
        reason,
        metadata,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageDeliveryReportImpl {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
  static class Builder implements MessageDeliveryReport.Builder {
    OptionalValue<String> messageId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<DeliveryStatus> status = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<Reason> reason = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(DeliveryStatus status) {
      this.status = OptionalValue.of(status);
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

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(Reason reason) {
      this.reason = OptionalValue.of(reason);
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

    public MessageDeliveryReport build() {
      return new MessageDeliveryReportImpl(
          messageId,
          conversationId,
          status,
          channelIdentity,
          contactId,
          reason,
          metadata,
          processingMode);
    }
  }
}
