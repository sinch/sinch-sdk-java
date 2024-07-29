package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Objects;

@JsonPropertyOrder({
  ChannelEventNotificationChannelEventImpl.JSON_PROPERTY_CHANNEL,
  ChannelEventNotificationChannelEventImpl.JSON_PROPERTY_EVENT_TYPE,
  ChannelEventNotificationChannelEventImpl.JSON_PROPERTY_ADDITIONAL_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelEventNotificationChannelEventImpl
    implements ChannelEventNotificationChannelEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<ConversationChannel> channel;

  public static final String JSON_PROPERTY_EVENT_TYPE = "event_type";

  private OptionalValue<String> eventType;

  public static final String JSON_PROPERTY_ADDITIONAL_DATA = "additional_data";

  private OptionalValue<Object> additionalData;

  public ChannelEventNotificationChannelEventImpl() {}

  protected ChannelEventNotificationChannelEventImpl(
      OptionalValue<ConversationChannel> channel,
      OptionalValue<String> eventType,
      OptionalValue<Object> additionalData) {
    this.channel = channel;
    this.eventType = eventType;
    this.additionalData = additionalData;
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
  public String getEventType() {
    return eventType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventType() {
    return eventType;
  }

  @JsonIgnore
  public Object getAdditionalData() {
    return additionalData.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Object> additionalData() {
    return additionalData;
  }

  /**
   * Return true if this ChannelEvent_allOf_channel_event_notification_channel_event object is equal
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
    ChannelEventNotificationChannelEventImpl channelEventAllOfChannelEventNotificationChannelEvent =
        (ChannelEventNotificationChannelEventImpl) o;
    return Objects.equals(
            this.channel, channelEventAllOfChannelEventNotificationChannelEvent.channel)
        && Objects.equals(
            this.eventType, channelEventAllOfChannelEventNotificationChannelEvent.eventType)
        && Objects.equals(
            this.additionalData,
            channelEventAllOfChannelEventNotificationChannelEvent.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, eventType, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelEventNotificationChannelEventImpl {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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
  static class Builder implements ChannelEventNotificationChannelEvent.Builder {
    OptionalValue<ConversationChannel> channel = OptionalValue.empty();
    OptionalValue<String> eventType = OptionalValue.empty();
    OptionalValue<Object> additionalData = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(ConversationChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_TYPE)
    public Builder setEventType(String eventType) {
      this.eventType = OptionalValue.of(eventType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
    public Builder setAdditionalData(Object additionalData) {
      this.additionalData = OptionalValue.of(additionalData);
      return this;
    }

    public ChannelEventNotificationChannelEvent build() {
      return new ChannelEventNotificationChannelEventImpl(channel, eventType, additionalData);
    }
  }
}
