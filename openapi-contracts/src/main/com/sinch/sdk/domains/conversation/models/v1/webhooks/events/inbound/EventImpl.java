package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.ContactEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.ContactMessageEvent;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  EventImpl.JSON_PROPERTY_ID,
  EventImpl.JSON_PROPERTY_DIRECTION,
  EventImpl.JSON_PROPERTY_CONTACT_EVENT,
  EventImpl.JSON_PROPERTY_CONTACT_MESSAGE_EVENT,
  EventImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  EventImpl.JSON_PROPERTY_CONTACT_ID,
  EventImpl.JSON_PROPERTY_CONVERSATION_ID,
  EventImpl.JSON_PROPERTY_ACCEPT_TIME,
  EventImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventImpl implements Event {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<DirectionEnum> direction;

  public static final String JSON_PROPERTY_CONTACT_EVENT = "contact_event";

  private OptionalValue<ContactEvent> contactEvent;

  public static final String JSON_PROPERTY_CONTACT_MESSAGE_EVENT = "contact_message_event";

  private OptionalValue<ContactMessageEvent> contactMessageEvent;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_CONVERSATION_ID = "conversation_id";

  private OptionalValue<String> conversationId;

  public static final String JSON_PROPERTY_ACCEPT_TIME = "accept_time";

  private OptionalValue<Instant> acceptTime;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public EventImpl() {}

  protected EventImpl(
      OptionalValue<String> id,
      OptionalValue<DirectionEnum> direction,
      OptionalValue<ContactEvent> contactEvent,
      OptionalValue<ContactMessageEvent> contactMessageEvent,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<String> conversationId,
      OptionalValue<Instant> acceptTime,
      OptionalValue<ProcessingMode> processingMode) {
    this.id = id;
    this.direction = direction;
    this.contactEvent = contactEvent;
    this.contactMessageEvent = contactMessageEvent;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.conversationId = conversationId;
    this.acceptTime = acceptTime;
    this.processingMode = processingMode;
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
  public DirectionEnum getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DirectionEnum> direction() {
    return direction;
  }

  @JsonIgnore
  public ContactEvent getContactEvent() {
    return contactEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactEvent> contactEvent() {
    return contactEvent;
  }

  @JsonIgnore
  public ContactMessageEvent getContactMessageEvent() {
    return contactMessageEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactMessageEvent> contactMessageEvent() {
    return contactMessageEvent;
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
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
  }

  /** Return true if this EventInbound_allOf_event object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventImpl eventInboundAllOfEvent = (EventImpl) o;
    return Objects.equals(this.id, eventInboundAllOfEvent.id)
        && Objects.equals(this.direction, eventInboundAllOfEvent.direction)
        && Objects.equals(this.contactEvent, eventInboundAllOfEvent.contactEvent)
        && Objects.equals(this.contactMessageEvent, eventInboundAllOfEvent.contactMessageEvent)
        && Objects.equals(this.channelIdentity, eventInboundAllOfEvent.channelIdentity)
        && Objects.equals(this.contactId, eventInboundAllOfEvent.contactId)
        && Objects.equals(this.conversationId, eventInboundAllOfEvent.conversationId)
        && Objects.equals(this.acceptTime, eventInboundAllOfEvent.acceptTime)
        && Objects.equals(this.processingMode, eventInboundAllOfEvent.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        direction,
        contactEvent,
        contactMessageEvent,
        channelIdentity,
        contactId,
        conversationId,
        acceptTime,
        processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    contactEvent: ").append(toIndentedString(contactEvent)).append("\n");
    sb.append("    contactMessageEvent: ")
        .append(toIndentedString(contactMessageEvent))
        .append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    conversationId: ").append(toIndentedString(conversationId)).append("\n");
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
  static class Builder implements Event.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<DirectionEnum> direction = OptionalValue.empty();
    OptionalValue<ContactEvent> contactEvent = OptionalValue.empty();
    OptionalValue<ContactMessageEvent> contactMessageEvent = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<String> conversationId = OptionalValue.empty();
    OptionalValue<Instant> acceptTime = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIRECTION)
    public Builder setDirection(DirectionEnum direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_EVENT)
    public Builder setContactEvent(ContactEvent contactEvent) {
      this.contactEvent = OptionalValue.of(contactEvent);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_MESSAGE_EVENT)
    public Builder setContactMessageEvent(ContactMessageEvent contactMessageEvent) {
      this.contactMessageEvent = OptionalValue.of(contactMessageEvent);
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

    public Event build() {
      return new EventImpl(
          id,
          direction,
          contactEvent,
          contactMessageEvent,
          channelIdentity,
          contactId,
          conversationId,
          acceptTime,
          processingMode);
    }
  }
}
