package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.record;

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
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_ENTITY_ID,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_RECORD_STATUS,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_CONTACT_ID,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_CONVERSATION_ID,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_REASON,
  RecordNotificationEventNotificationImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RecordNotificationEventNotificationImpl
    implements RecordNotificationEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENTITY_ID = "entity_id";

  private OptionalValue<String> entityId;

  public static final String JSON_PROPERTY_RECORD_STATUS = "record_status";

  private OptionalValue<RecordStatusEnum> recordStatus;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<Reason> reason;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public RecordNotificationEventNotificationImpl() {}

  protected RecordNotificationEventNotificationImpl(
      OptionalValue<String> entityId,
      OptionalValue<RecordStatusEnum> recordStatus,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<String> conversationId,
      OptionalValue<Reason> reason,
      OptionalValue<ProcessingMode> processingMode) {
    this.entityId = entityId;
    this.recordStatus = recordStatus;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.conversationId = conversationId;
    this.reason = reason;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public String getEntityId() {
    return entityId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENTITY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> entityId() {
    return entityId;
  }

  @JsonIgnore
  public RecordStatusEnum getRecordStatus() {
    return recordStatus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECORD_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RecordStatusEnum> recordStatus() {
    return recordStatus;
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
  public Reason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Reason> reason() {
    return reason;
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

  /** Return true if this RecordNotificationEvent_allOf_record_notification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecordNotificationEventNotificationImpl recordNotificationEventAllOfRecordNotification =
        (RecordNotificationEventNotificationImpl) o;
    return Objects.equals(this.entityId, recordNotificationEventAllOfRecordNotification.entityId)
        && Objects.equals(
            this.recordStatus, recordNotificationEventAllOfRecordNotification.recordStatus)
        && Objects.equals(
            this.channelIdentity, recordNotificationEventAllOfRecordNotification.channelIdentity)
        && Objects.equals(this.contactId, recordNotificationEventAllOfRecordNotification.contactId)
        && Objects.equals(
            this.conversationId, recordNotificationEventAllOfRecordNotification.conversationId)
        && Objects.equals(this.reason, recordNotificationEventAllOfRecordNotification.reason)
        && Objects.equals(
            this.processingMode, recordNotificationEventAllOfRecordNotification.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        entityId, recordStatus, channelIdentity, contactId, conversationId, reason, processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecordNotificationEventNotificationImpl {\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    recordStatus: ").append(toIndentedString(recordStatus)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
  static class Builder implements RecordNotificationEventNotification.Builder {
    OptionalValue<String> entityId = OptionalValue.empty();
    OptionalValue<RecordStatusEnum> recordStatus = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<Reason> reason = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENTITY_ID)
    public Builder setEntityId(String entityId) {
      this.entityId = OptionalValue.of(entityId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECORD_STATUS)
    public Builder setRecordStatus(RecordStatusEnum recordStatus) {
      this.recordStatus = OptionalValue.of(recordStatus);
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

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(Reason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public RecordNotificationEventNotification build() {
      return new RecordNotificationEventNotificationImpl(
          entityId,
          recordStatus,
          channelIdentity,
          contactId,
          conversationId,
          reason,
          processingMode);
    }
  }
}
