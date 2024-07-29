package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel.internal.ChannelEventNotificationChannelEvent;
import java.util.Objects;

@JsonPropertyOrder({ChannelEventNotificationImpl.JSON_PROPERTY_CHANNEL_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChannelEventNotificationImpl implements ChannelEventNotification {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_EVENT = "channel_event";

  private OptionalValue<ChannelEventNotificationChannelEvent> channelEvent;

  public ChannelEventNotificationImpl() {}

  protected ChannelEventNotificationImpl(
      OptionalValue<ChannelEventNotificationChannelEvent> channelEvent) {
    this.channelEvent = channelEvent;
  }

  @JsonIgnore
  public ChannelEventNotificationChannelEvent getChannelEvent() {
    return channelEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelEventNotificationChannelEvent> channelEvent() {
    return channelEvent;
  }

  @JsonIgnore
  public ConversationChannel getChannel() {
    if (null == channelEvent
        || !channelEvent.isPresent()
        || null == channelEvent.get().getChannel()) {
      return null;
    }
    return channelEvent.get().getChannel();
  }

  public OptionalValue<ConversationChannel> channel() {
    return null != channelEvent
        ? channelEvent.map(ChannelEventNotificationChannelEvent::getChannel)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getEventType() {
    if (null == channelEvent
        || !channelEvent.isPresent()
        || null == channelEvent.get().getEventType()) {
      return null;
    }
    return channelEvent.get().getEventType();
  }

  public OptionalValue<String> eventType() {
    return null != channelEvent
        ? channelEvent.map(ChannelEventNotificationChannelEvent::getEventType)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public Object getAdditionalData() {
    if (null == channelEvent
        || !channelEvent.isPresent()
        || null == channelEvent.get().getAdditionalData()) {
      return null;
    }
    return channelEvent.get().getAdditionalData();
  }

  public OptionalValue<Object> additionalData() {
    return null != channelEvent
        ? channelEvent.map(ChannelEventNotificationChannelEvent::getAdditionalData)
        : OptionalValue.empty();
  }

  /** Return true if this ChannelEvent_allOf_channel_event_notification object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelEventNotificationImpl channelEventAllOfChannelEventNotification =
        (ChannelEventNotificationImpl) o;
    return Objects.equals(
        this.channelEvent, channelEventAllOfChannelEventNotification.channelEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelEventNotificationImpl {\n");
    sb.append("    channelEvent: ").append(toIndentedString(channelEvent)).append("\n");
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
  static class Builder implements ChannelEventNotification.Builder {
    OptionalValue<ChannelEventNotificationChannelEvent> channelEvent = OptionalValue.empty();

    ChannelEventNotificationChannelEvent.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_CHANNEL_EVENT)
    public Builder setChannelEvent(ChannelEventNotificationChannelEvent channelEvent) {
      this.channelEvent = OptionalValue.of(channelEvent);
      return this;
    }

    @JsonIgnore
    public Builder setChannel(ConversationChannel channel) {
      getDelegatedBuilder().setChannel(channel);
      return this;
    }

    @JsonIgnore
    public Builder setEventType(String eventType) {
      getDelegatedBuilder().setEventType(eventType);
      return this;
    }

    @JsonIgnore
    public Builder setAdditionalData(Object additionalData) {
      getDelegatedBuilder().setAdditionalData(additionalData);
      return this;
    }

    private ChannelEventNotificationChannelEvent.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ChannelEventNotificationChannelEvent.builder();
      }
      return this._delegatedBuilder;
    }

    public ChannelEventNotification build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.channelEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ChannelEventNotificationImpl(channelEvent);
    }
  }
}
