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

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/**
 * This callback is used to deliver notifications regarding channel-specific information and
 * updates. For example, if your are using the WhatsApp channel of the Conversation API, and your
 * quality rating has been changed to GREEN, a POST would be made to the CHANNEL_EVENT webhook.
 */
@JsonDeserialize(builder = ChannelEventImpl.Builder.class)
public interface ChannelEvent
    extends com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent {

  /**
   * Id of the subscribed app.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Timestamp marking when the channel callback was accepted/received by the Conversation API.
   *
   * @return acceptedTime
   */
  Instant getAcceptedTime();

  /**
   * Timestamp of the event as provided by the underlying channels.
   *
   * @return eventTime
   */
  Instant getEventTime();

  /**
   * The project ID of the app which has subscribed for the callback.
   *
   * @return projectId
   */
  String getProjectId();

  /**
   * Context-dependent metadata. Refer to specific callback's documentation for exact information
   * provided.
   *
   * @return messageMetadata
   */
  String getMessageMetadata();

  /**
   * The value provided in field correlation_id of a send message request.
   *
   * @return correlationId
   */
  String getCorrelationId();

  /**
   * Get notification
   *
   * @return notification
   */
  ChannelEventNotification getNotification();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ChannelEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder setAppId(String appId);

    /**
     * see getter
     *
     * @param acceptedTime see getter
     * @return Current builder
     * @see #getAcceptedTime
     */
    Builder setAcceptedTime(Instant acceptedTime);

    /**
     * see getter
     *
     * @param eventTime see getter
     * @return Current builder
     * @see #getEventTime
     */
    Builder setEventTime(Instant eventTime);

    /**
     * see getter
     *
     * @param projectId see getter
     * @return Current builder
     * @see #getProjectId
     */
    Builder setProjectId(String projectId);

    /**
     * see getter
     *
     * @param messageMetadata see getter
     * @return Current builder
     * @see #getMessageMetadata
     */
    Builder setMessageMetadata(String messageMetadata);

    /**
     * see getter
     *
     * @param correlationId see getter
     * @return Current builder
     * @see #getCorrelationId
     */
    Builder setCorrelationId(String correlationId);

    /**
     * see getter
     *
     * @param notification see getter
     * @return Current builder
     * @see #getNotification
     */
    Builder setNotification(ChannelEventNotification notification);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ChannelEvent build();
  }
}
