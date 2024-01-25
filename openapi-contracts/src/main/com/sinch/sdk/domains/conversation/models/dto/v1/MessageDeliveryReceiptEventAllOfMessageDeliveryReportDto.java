/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto */
@JsonPropertyOrder({
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_MESSAGE_ID,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_CONVERSATION_ID,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_STATUS,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_CHANNEL_IDENTITY,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_CONTACT_ID,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_REASON,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_METADATA,
  MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto {
  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";
  private String messageId;
  private boolean messageIdDefined = false;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";
  private String conversationId;
  private boolean conversationIdDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private DeliveryStatusDto status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";
  private ChannelIdentityDto channelIdentity;
  private boolean channelIdentityDefined = false;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";
  private String contactId;
  private boolean contactIdDefined = false;

  public static final String JSON_PROPERTY_REASON = "reason";
  private ReasonDto reason;
  private boolean reasonDefined = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private String metadata;
  private boolean metadataDefined = false;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";
  private ProcessingModeDto processingMode;
  private boolean processingModeDefined = false;

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto() {}

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto messageId(String messageId) {
    this.messageId = messageId;
    this.messageIdDefined = true;
    return this;
  }

  /**
   * The ID of the app message.
   *
   * @return messageId
   */
  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessageId() {
    return messageId;
  }

  @JsonIgnore
  public boolean getMessageIdDefined() {
    return messageIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessageId(String messageId) {
    this.messageId = messageId;
    this.messageIdDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto conversationId(
      String conversationId) {
    this.conversationId = conversationId;
    this.conversationIdDefined = true;
    return this;
  }

  /**
   * The ID of the conversation the app message is part of. Will be empty if processing_mode is
   * DISPATCH.
   *
   * @return conversationId
   */
  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getConversationId() {
    return conversationId;
  }

  @JsonIgnore
  public boolean getConversationIdDefined() {
    return conversationIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONVERSATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConversationId(String conversationId) {
    this.conversationId = conversationId;
    this.conversationIdDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto status(DeliveryStatusDto status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DeliveryStatusDto getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(DeliveryStatusDto status) {
    this.status = status;
    this.statusDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto channelIdentity(
      ChannelIdentityDto channelIdentity) {
    this.channelIdentity = channelIdentity;
    this.channelIdentityDefined = true;
    return this;
  }

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ChannelIdentityDto getChannelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public boolean getChannelIdentityDefined() {
    return channelIdentityDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChannelIdentity(ChannelIdentityDto channelIdentity) {
    this.channelIdentity = channelIdentity;
    this.channelIdentityDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto contactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
    return this;
  }

  /**
   * The ID of the contact. Will be empty if processing_mode is DISPATCH.
   *
   * @return contactId
   */
  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getContactId() {
    return contactId;
  }

  @JsonIgnore
  public boolean getContactIdDefined() {
    return contactIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto reason(ReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
    return this;
  }

  /**
   * Get reason
   *
   * @return reason
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ReasonDto getReason() {
    return reason;
  }

  @JsonIgnore
  public boolean getReasonDefined() {
    return reasonDefined;
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(ReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto metadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
    return this;
  }

  /**
   * Metadata specified in the message_metadata field of a Send Message request, if any.
   *
   * @return metadata
   */
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMetadata() {
    return metadata;
  }

  @JsonIgnore
  public boolean getMetadataDefined() {
    return metadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
  }

  public MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto processingMode(
      ProcessingModeDto processingMode) {
    this.processingMode = processingMode;
    this.processingModeDefined = true;
    return this;
  }

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ProcessingModeDto getProcessingMode() {
    return processingMode;
  }

  @JsonIgnore
  public boolean getProcessingModeDefined() {
    return processingModeDefined;
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcessingMode(ProcessingModeDto processingMode) {
    this.processingMode = processingMode;
    this.processingModeDefined = true;
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
    MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto
        messageDeliveryReceiptEventAllOfMessageDeliveryReport =
            (MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto) o;
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
    sb.append("class MessageDeliveryReceiptEventAllOfMessageDeliveryReportDto {\n");
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
}
