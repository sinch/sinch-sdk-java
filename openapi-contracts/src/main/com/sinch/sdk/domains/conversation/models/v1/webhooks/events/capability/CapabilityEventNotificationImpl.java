package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Reason;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CapabilityEventNotificationImpl.JSON_PROPERTY_REQUEST_ID,
  CapabilityEventNotificationImpl.JSON_PROPERTY_CONTACT_ID,
  CapabilityEventNotificationImpl.JSON_PROPERTY_CHANNEL,
  CapabilityEventNotificationImpl.JSON_PROPERTY_IDENTITY,
  CapabilityEventNotificationImpl.JSON_PROPERTY_CAPABILITY_STATUS,
  CapabilityEventNotificationImpl.JSON_PROPERTY_CHANNEL_CAPABILITIES,
  CapabilityEventNotificationImpl.JSON_PROPERTY_REASON
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CapabilityEventNotificationImpl implements CapabilityEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REQUEST_ID = "request_id";

  private OptionalValue<String> requestId;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<String> identity;

  public static final String JSON_PROPERTY_CAPABILITY_STATUS = "capability_status";

  private OptionalValue<CapabilityStatusEnum> capabilityStatus;

  public static final String JSON_PROPERTY_CHANNEL_CAPABILITIES = "channel_capabilities";

  private OptionalValue<List<String>> channelCapabilities;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<Reason> reason;

  public CapabilityEventNotificationImpl() {}

  protected CapabilityEventNotificationImpl(
      OptionalValue<String> requestId,
      OptionalValue<String> contactId,
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> identity,
      OptionalValue<CapabilityStatusEnum> capabilityStatus,
      OptionalValue<List<String>> channelCapabilities,
      OptionalValue<Reason> reason) {
    this.requestId = requestId;
    this.contactId = contactId;
    this.channel = channel;
    this.identity = identity;
    this.capabilityStatus = capabilityStatus;
    this.channelCapabilities = channelCapabilities;
    this.reason = reason;
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
  public CapabilityStatusEnum getCapabilityStatus() {
    return capabilityStatus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CapabilityStatusEnum> capabilityStatus() {
    return capabilityStatus;
  }

  @JsonIgnore
  public List<String> getChannelCapabilities() {
    return channelCapabilities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_CAPABILITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> channelCapabilities() {
    return channelCapabilities;
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

  /** Return true if this CapabilityEvent_allOf_capability_notification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CapabilityEventNotificationImpl capabilityEventAllOfCapabilityNotification =
        (CapabilityEventNotificationImpl) o;
    return Objects.equals(this.requestId, capabilityEventAllOfCapabilityNotification.requestId)
        && Objects.equals(this.contactId, capabilityEventAllOfCapabilityNotification.contactId)
        && Objects.equals(this.channel, capabilityEventAllOfCapabilityNotification.channel)
        && Objects.equals(this.identity, capabilityEventAllOfCapabilityNotification.identity)
        && Objects.equals(
            this.capabilityStatus, capabilityEventAllOfCapabilityNotification.capabilityStatus)
        && Objects.equals(
            this.channelCapabilities,
            capabilityEventAllOfCapabilityNotification.channelCapabilities)
        && Objects.equals(this.reason, capabilityEventAllOfCapabilityNotification.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        requestId, contactId, channel, identity, capabilityStatus, channelCapabilities, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CapabilityEventNotificationImpl {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    capabilityStatus: ").append(toIndentedString(capabilityStatus)).append("\n");
    sb.append("    channelCapabilities: ")
        .append(toIndentedString(channelCapabilities))
        .append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
  static class Builder implements CapabilityEventNotification.Builder {
    OptionalValue<String> requestId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> identity = OptionalValue.empty();
    OptionalValue<CapabilityStatusEnum> capabilityStatus = OptionalValue.empty();
    OptionalValue<List<String>> channelCapabilities = OptionalValue.empty();
    OptionalValue<Reason> reason = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_CAPABILITY_STATUS)
    public Builder setCapabilityStatus(CapabilityStatusEnum capabilityStatus) {
      this.capabilityStatus = OptionalValue.of(capabilityStatus);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_CAPABILITIES)
    public Builder setChannelCapabilities(List<String> channelCapabilities) {
      this.channelCapabilities = OptionalValue.of(channelCapabilities);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(Reason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    public CapabilityEventNotification build() {
      return new CapabilityEventNotificationImpl(
          requestId, contactId, channel, identity, capabilityStatus, channelCapabilities, reason);
    }
  }
}
