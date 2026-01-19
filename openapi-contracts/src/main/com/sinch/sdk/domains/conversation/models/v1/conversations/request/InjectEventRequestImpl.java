package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  InjectEventRequestImpl.JSON_PROPERTY_APP_EVENT,
  InjectEventRequestImpl.JSON_PROPERTY_CONVERSATION_ID,
  InjectEventRequestImpl.JSON_PROPERTY_CONTACT_ID,
  InjectEventRequestImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  InjectEventRequestImpl.JSON_PROPERTY_ACCEPT_TIME,
  InjectEventRequestImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InjectEventRequestImpl implements InjectEventRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_EVENT = "app_event";

  private OptionalValue<AppEvent> appEvent;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_ACCEPT_TIME = "accept_time";

  private OptionalValue<Instant> acceptTime;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public InjectEventRequestImpl() {}

  protected InjectEventRequestImpl(
      OptionalValue<AppEvent> appEvent,
      OptionalValue<String> conversationId,
      OptionalValue<String> contactId,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ProcessingMode> processingMode) {
    this.appEvent = appEvent;
    this.conversationId = conversationId;
    this.contactId = contactId;
    this.channelIdentity = channelIdentity;
    this.acceptTime = acceptTime;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public AppEvent getAppEvent() {
    return appEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AppEvent> appEvent() {
    return appEvent;
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
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
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
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  /** Return true if this InjectConversationEventRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InjectEventRequestImpl injectConversationEventRequest = (InjectEventRequestImpl) o;
    return Objects.equals(this.appEvent, injectConversationEventRequest.appEvent)
        && Objects.equals(this.conversationId, injectConversationEventRequest.conversationId)
        && Objects.equals(this.contactId, injectConversationEventRequest.contactId)
        && Objects.equals(this.channelIdentity, injectConversationEventRequest.channelIdentity)
        && Objects.equals(this.acceptTime, injectConversationEventRequest.acceptTime)
        && Objects.equals(this.processingMode, injectConversationEventRequest.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appEvent, conversationId, contactId, channelIdentity, acceptTime, processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InjectEventRequestImpl {\n");
    sb.append("    appEvent: ").append(toIndentedString(appEvent)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
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
  static class Builder implements InjectEventRequest.Builder {
    OptionalValue<AppEvent> appEvent = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_EVENT)
    public Builder setAppEvent(AppEvent appEvent) {
      this.appEvent = OptionalValue.of(appEvent);
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

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ACCEPT_TIME, required = true)
    public Builder setAcceptTime(Instant acceptTime) {
      this.acceptTime = OptionalValue.of(acceptTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public InjectEventRequest build() {
      return new InjectEventRequestImpl(
          appEvent, conversationId, contactId, channelIdentity, acceptTime, processingMode);
    }
  }
}
