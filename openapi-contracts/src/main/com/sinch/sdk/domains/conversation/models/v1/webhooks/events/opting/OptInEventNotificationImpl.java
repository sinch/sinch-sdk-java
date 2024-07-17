package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.util.Objects;

@JsonPropertyOrder({
  OptInEventNotificationImpl.JSON_PROPERTY_REQUEST_ID,
  OptInEventNotificationImpl.JSON_PROPERTY_CONTACT_ID,
  OptInEventNotificationImpl.JSON_PROPERTY_CHANNEL,
  OptInEventNotificationImpl.JSON_PROPERTY_IDENTITY,
  OptInEventNotificationImpl.JSON_PROPERTY_STATUS,
  OptInEventNotificationImpl.JSON_PROPERTY_ERROR_DETAILS,
  OptInEventNotificationImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OptInEventNotificationImpl implements OptInEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REQUEST_ID = "request_id";

  private OptionalValue<String> requestId;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<String> identity;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> status;

  public static final String JSON_PROPERTY_ERROR_DETAILS = "error_details";

  private OptionalValue<OptInEventNotificationErrorDetails> errorDetails;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public OptInEventNotificationImpl() {}

  protected OptInEventNotificationImpl(
      OptionalValue<String> requestId,
      OptionalValue<String> contactId,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> identity,
      OptionalValue<StatusEnum> status,
      OptionalValue<OptInEventNotificationErrorDetails> errorDetails,
      OptionalValue<ProcessingMode> processingMode) {
    this.requestId = requestId;
    this.contactId = contactId;
    this.channel = channel;
    this.identity = identity;
    this.status = status;
    this.errorDetails = errorDetails;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public String getRequestId() {
    return requestId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> requestId() {
    return requestId;
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
  public ConversationChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ConversationChannel> channel() {
    return channel;
  }

  @JsonIgnore
  public String getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> identity() {
    return identity;
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusEnum> status() {
    return status;
  }

  @JsonIgnore
  public OptInEventNotificationErrorDetails getErrorDetails() {
    return errorDetails.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OptInEventNotificationErrorDetails> errorDetails() {
    return errorDetails;
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

  /** Return true if this OptInEvent_allOf_opt_in_notification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OptInEventNotificationImpl optInEventAllOfOptInNotification = (OptInEventNotificationImpl) o;
    return Objects.equals(this.requestId, optInEventAllOfOptInNotification.requestId)
        && Objects.equals(this.contactId, optInEventAllOfOptInNotification.contactId)
        && Objects.equals(this.channel, optInEventAllOfOptInNotification.channel)
        && Objects.equals(this.identity, optInEventAllOfOptInNotification.identity)
        && Objects.equals(this.status, optInEventAllOfOptInNotification.status)
        && Objects.equals(this.errorDetails, optInEventAllOfOptInNotification.errorDetails)
        && Objects.equals(this.processingMode, optInEventAllOfOptInNotification.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        requestId, contactId, channel, identity, status, errorDetails, processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OptInEventNotificationImpl {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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
  static class Builder implements OptInEventNotification.Builder {
    OptionalValue<String> requestId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<StatusEnum> status = OptionalValue.empty();
    OptionalValue<OptInEventNotificationErrorDetails> errorDetails = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REQUEST_ID)
    public Builder setRequestId(String requestId) {
      this.requestId = OptionalValue.of(requestId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(String identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(StatusEnum status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_DETAILS)
    public Builder setErrorDetails(OptInEventNotificationErrorDetails errorDetails) {
      this.errorDetails = OptionalValue.of(errorDetails);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public OptInEventNotification build() {
      return new OptInEventNotificationImpl(
          requestId, contactId, channel, identity, status, errorDetails, processingMode);
    }
  }
}
