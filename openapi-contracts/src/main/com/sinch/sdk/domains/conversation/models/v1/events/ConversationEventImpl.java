package com.sinch.sdk.domains.conversation.models.v1.events;

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
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ConversationEventImpl.JSON_PROPERTY_APP_EVENT,
  ConversationEventImpl.JSON_PROPERTY_DIRECTION,
  ConversationEventImpl.JSON_PROPERTY_ID,
  ConversationEventImpl.JSON_PROPERTY_CONVERSATION_ID,
  ConversationEventImpl.JSON_PROPERTY_CONTACT_ID,
  ConversationEventImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  ConversationEventImpl.JSON_PROPERTY_ACCEPT_TIME,
  ConversationEventImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConversationEventImpl implements ConversationEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_EVENT = "app_event";

  private OptionalValue<AppEvent> appEvent;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<ConversationDirection> direction;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

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

  public ConversationEventImpl() {}

  protected ConversationEventImpl(
      OptionalValue<AppEvent> appEvent,
      OptionalValue<ConversationDirection> direction,
      OptionalValue<String> id,
      OptionalValue<String> conversationId,
      OptionalValue<String> contactId,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ProcessingMode> processingMode) {
    this.appEvent = appEvent;
    this.direction = direction;
    this.id = id;
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
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
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  /** Return true if this ConversationEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConversationEventImpl conversationEvent = (ConversationEventImpl) o;
    return Objects.equals(this.appEvent, conversationEvent.appEvent)
        && Objects.equals(this.direction, conversationEvent.direction)
        && Objects.equals(this.id, conversationEvent.id)
        && Objects.equals(this.conversationId, conversationEvent.conversationId)
        && Objects.equals(this.contactId, conversationEvent.contactId)
        && Objects.equals(this.channelIdentity, conversationEvent.channelIdentity)
        && Objects.equals(this.acceptTime, conversationEvent.acceptTime)
        && Objects.equals(this.processingMode, conversationEvent.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appEvent,
        direction,
        id,
        conversationId,
        contactId,
        channelIdentity,
        acceptTime,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversationEventImpl {\n");
    sb.append("    appEvent: ").append(toIndentedString(appEvent)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
  static class Builder implements ConversationEvent.Builder {
    OptionalValue<AppEvent> appEvent = OptionalValue.empty();
    OptionalValue<ConversationDirection> direction = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_ACCEPT_TIME)
    public Builder setAcceptTime(Instant acceptTime) {
      this.acceptTime = OptionalValue.of(acceptTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public ConversationEvent build() {
      return new ConversationEventImpl(
          appEvent,
          direction,
          id,
          conversationId,
          contactId,
          channelIdentity,
          acceptTime,
          processingMode);
    }
  }
}
