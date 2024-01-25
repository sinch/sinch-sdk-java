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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** SendEventRequestDto */
@JsonPropertyOrder({
  SendEventRequestDto.JSON_PROPERTY_APP_ID,
  SendEventRequestDto.JSON_PROPERTY_EVENT,
  SendEventRequestDto.JSON_PROPERTY_RECIPIENT,
  SendEventRequestDto.JSON_PROPERTY_CALLBACK_URL,
  SendEventRequestDto.JSON_PROPERTY_CHANNEL_PRIORITY_ORDER,
  SendEventRequestDto.JSON_PROPERTY_EVENT_METADATA,
  SendEventRequestDto.JSON_PROPERTY_QUEUE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendEventRequestDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_APP_ID = "app_id";
  private String appId;
  private boolean appIdDefined = false;

  public static final String JSON_PROPERTY_EVENT = "event";
  private AppEventDto event;
  private boolean eventDefined = false;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";
  private SendEventRequestRecipientDto recipient;
  private boolean recipientDefined = false;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callback_url";
  private String callbackUrl;
  private boolean callbackUrlDefined = false;

  public static final String JSON_PROPERTY_CHANNEL_PRIORITY_ORDER = "channel_priority_order";
  private List<ConversationChannelDto> channelPriorityOrder;
  private boolean channelPriorityOrderDefined = false;

  public static final String JSON_PROPERTY_EVENT_METADATA = "event_metadata";
  private String eventMetadata;
  private boolean eventMetadataDefined = false;

  public static final String JSON_PROPERTY_QUEUE = "queue";
  private MessageQueueDto queue;
  private boolean queueDefined = false;

  public SendEventRequestDto() {}

  public SendEventRequestDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * The ID of the app sending the event.
   *
   * @return appId
   */
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getAppId() {
    return appId;
  }

  @JsonIgnore
  public boolean getAppIdDefined() {
    return appIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAppId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
  }

  public SendEventRequestDto event(AppEventDto event) {
    this.event = event;
    this.eventDefined = true;
    return this;
  }

  /**
   * Get event
   *
   * @return event
   */
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public AppEventDto getEvent() {
    return event;
  }

  @JsonIgnore
  public boolean getEventDefined() {
    return eventDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEvent(AppEventDto event) {
    this.event = event;
    this.eventDefined = true;
  }

  public SendEventRequestDto recipient(SendEventRequestRecipientDto recipient) {
    this.recipient = recipient;
    this.recipientDefined = true;
    return this;
  }

  /**
   * Get recipient
   *
   * @return recipient
   */
  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public SendEventRequestRecipientDto getRecipient() {
    return recipient;
  }

  @JsonIgnore
  public boolean getRecipientDefined() {
    return recipientDefined;
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecipient(SendEventRequestRecipientDto recipient) {
    this.recipient = recipient;
    this.recipientDefined = true;
  }

  public SendEventRequestDto callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
    return this;
  }

  /**
   * Overwrites the default callback url for delivery receipts for this message The REST URL should
   * be of the form: &#x60;http://host[:port]/path&#x60;
   *
   * @return callbackUrl
   */
  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public boolean getCallbackUrlDefined() {
    return callbackUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
  }

  public SendEventRequestDto channelPriorityOrder(
      List<ConversationChannelDto> channelPriorityOrder) {
    this.channelPriorityOrder = channelPriorityOrder;
    this.channelPriorityOrderDefined = true;
    return this;
  }

  public SendEventRequestDto addChannelPriorityOrderItem(
      ConversationChannelDto channelPriorityOrderItem) {
    if (this.channelPriorityOrder == null) {
      this.channelPriorityOrder = new ArrayList<>();
    }
    this.channelPriorityOrderDefined = true;
    this.channelPriorityOrder.add(channelPriorityOrderItem);
    return this;
  }

  /**
   * Optional. A single element array that dictates on what channel should the Conversation API try
   * to send the event. It overrides any default set on the contact. Providing more than one option
   * has no effect.
   *
   * @return channelPriorityOrder
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ConversationChannelDto> getChannelPriorityOrder() {
    return channelPriorityOrder;
  }

  @JsonIgnore
  public boolean getChannelPriorityOrderDefined() {
    return channelPriorityOrderDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_PRIORITY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChannelPriorityOrder(List<ConversationChannelDto> channelPriorityOrder) {
    this.channelPriorityOrder = channelPriorityOrder;
    this.channelPriorityOrderDefined = true;
  }

  public SendEventRequestDto eventMetadata(String eventMetadata) {
    this.eventMetadata = eventMetadata;
    this.eventMetadataDefined = true;
    return this;
  }

  /**
   * Optional. Eventual metadata that should be associated to the event.
   *
   * @return eventMetadata
   */
  @JsonProperty(JSON_PROPERTY_EVENT_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEventMetadata() {
    return eventMetadata;
  }

  @JsonIgnore
  public boolean getEventMetadataDefined() {
    return eventMetadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVENT_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEventMetadata(String eventMetadata) {
    this.eventMetadata = eventMetadata;
    this.eventMetadataDefined = true;
  }

  public SendEventRequestDto queue(MessageQueueDto queue) {
    this.queue = queue;
    this.queueDefined = true;
    return this;
  }

  /**
   * Get queue
   *
   * @return queue
   */
  @JsonProperty(JSON_PROPERTY_QUEUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MessageQueueDto getQueue() {
    return queue;
  }

  @JsonIgnore
  public boolean getQueueDefined() {
    return queueDefined;
  }

  @JsonProperty(JSON_PROPERTY_QUEUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQueue(MessageQueueDto queue) {
    this.queue = queue;
    this.queueDefined = true;
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
    SendEventRequestDto sendEventRequest = (SendEventRequestDto) o;
    return Objects.equals(this.appId, sendEventRequest.appId)
        && Objects.equals(this.event, sendEventRequest.event)
        && Objects.equals(this.recipient, sendEventRequest.recipient)
        && Objects.equals(this.callbackUrl, sendEventRequest.callbackUrl)
        && Objects.equals(this.channelPriorityOrder, sendEventRequest.channelPriorityOrder)
        && Objects.equals(this.eventMetadata, sendEventRequest.eventMetadata)
        && Objects.equals(this.queue, sendEventRequest.queue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appId, event, recipient, callbackUrl, channelPriorityOrder, eventMetadata, queue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEventRequestDto {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    channelPriorityOrder: ")
        .append(toIndentedString(channelPriorityOrder))
        .append("\n");
    sb.append("    eventMetadata: ").append(toIndentedString(eventMetadata)).append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
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
