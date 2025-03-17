package com.sinch.sdk.domains.conversation.models.v1.events.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageQueue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SendEventRequestImpl.JSON_PROPERTY_APP_ID,
  SendEventRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  SendEventRequestImpl.JSON_PROPERTY_CHANNEL_PRIORITY_ORDER,
  SendEventRequestImpl.JSON_PROPERTY_EVENT,
  SendEventRequestImpl.JSON_PROPERTY_EVENT_METADATA,
  SendEventRequestImpl.JSON_PROPERTY_QUEUE,
  SendEventRequestImpl.JSON_PROPERTY_RECIPIENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendEventRequestImpl implements SendEventRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callback_url";

  private OptionalValue<String> callbackUrl;

  public static final String JSON_PROPERTY_CHANNEL_PRIORITY_ORDER = "channel_priority_order";

  private OptionalValue<List<ConversationChannel>> channelPriorityOrder;

  public static final String JSON_PROPERTY_EVENT = "event";

  private OptionalValue<AppEvent> event;

  public static final String JSON_PROPERTY_EVENT_METADATA = "event_metadata";

  private OptionalValue<String> eventMetadata;

  public static final String JSON_PROPERTY_QUEUE = "queue";

  private OptionalValue<MessageQueue> queue;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<Recipient> recipient;

  public SendEventRequestImpl() {}

  protected SendEventRequestImpl(
      OptionalValue<String> appId,
      OptionalValue<String> callbackUrl,
      OptionalValue<List<ConversationChannel>> channelPriorityOrder,
      OptionalValue<AppEvent> event,
      OptionalValue<String> eventMetadata,
      OptionalValue<MessageQueue> queue,
      OptionalValue<Recipient> recipient) {
    this.appId = appId;
    this.callbackUrl = callbackUrl;
    this.channelPriorityOrder = channelPriorityOrder;
    this.event = event;
    this.eventMetadata = eventMetadata;
    this.queue = queue;
    this.recipient = recipient;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public String getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public List<ConversationChannel> getChannelPriorityOrder() {
    return channelPriorityOrder.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<ConversationChannel>> channelPriorityOrder() {
    return channelPriorityOrder;
  }

  @JsonIgnore
  public AppEvent getEvent() {
    return event.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<AppEvent> event() {
    return event;
  }

  @JsonIgnore
  public String getEventMetadata() {
    return eventMetadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventMetadata() {
    return eventMetadata;
  }

  @JsonIgnore
  public MessageQueue getQueue() {
    return queue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUEUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageQueue> queue() {
    return queue;
  }

  @JsonIgnore
  public Recipient getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Recipient> recipient() {
    return recipient;
  }

  /** Return true if this SendEventRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendEventRequestImpl sendEventRequest = (SendEventRequestImpl) o;
    return Objects.equals(this.appId, sendEventRequest.appId)
        && Objects.equals(this.callbackUrl, sendEventRequest.callbackUrl)
        && Objects.equals(this.channelPriorityOrder, sendEventRequest.channelPriorityOrder)
        && Objects.equals(this.event, sendEventRequest.event)
        && Objects.equals(this.eventMetadata, sendEventRequest.eventMetadata)
        && Objects.equals(this.queue, sendEventRequest.queue)
        && Objects.equals(this.recipient, sendEventRequest.recipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appId, callbackUrl, channelPriorityOrder, event, eventMetadata, queue, recipient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEventRequestImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    channelPriorityOrder: ")
        .append(toIndentedString(channelPriorityOrder))
        .append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    eventMetadata: ").append(toIndentedString(eventMetadata)).append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
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
  static class Builder implements SendEventRequest.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();
    OptionalValue<List<ConversationChannel>> channelPriorityOrder = OptionalValue.empty();
    OptionalValue<AppEvent> event = OptionalValue.empty();
    OptionalValue<String> eventMetadata = OptionalValue.empty();
    OptionalValue<MessageQueue> queue = OptionalValue.empty();
    OptionalValue<Recipient> recipient = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_APP_ID, required = true)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
    public Builder setChannelPriorityOrder(List<ConversationChannel> channelPriorityOrder) {
      this.channelPriorityOrder = OptionalValue.of(channelPriorityOrder);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT, required = true)
    public Builder setEvent(AppEvent event) {
      this.event = OptionalValue.of(event);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_METADATA)
    public Builder setEventMetadata(String eventMetadata) {
      this.eventMetadata = OptionalValue.of(eventMetadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_QUEUE)
    public Builder setQueue(MessageQueue queue) {
      this.queue = OptionalValue.of(queue);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_RECIPIENT, required = true)
    public Builder setRecipient(Recipient recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    public SendEventRequest build() {
      return new SendEventRequestImpl(
          appId, callbackUrl, channelPriorityOrder, event, eventMetadata, queue, recipient);
    }
  }
}
