/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEventMessage;
import java.time.Instant;

/**
 * This callback delivers contact (end-user) messages to the API clients. The content of the message
 * goes through an A.I. analysis and is redacted if required.
 */
@JsonDeserialize(builder = MessageInboundSmartConversationRedactionEventImpl.Builder.class)
public interface MessageInboundSmartConversationRedactionEvent
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
   * Get message
   *
   * @return message
   */
  MessageInboundEventMessage getMessage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MessageInboundSmartConversationRedactionEventImpl.Builder();
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
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(MessageInboundEventMessage message);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MessageInboundSmartConversationRedactionEvent build();
  }
}
