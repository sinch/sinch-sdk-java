/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.time.Instant;

/** An event on a particular channel. */
@JsonDeserialize(builder = ConversationEventImpl.Builder.class)
public interface ConversationEvent {

  /**
   * Get appEvent
   *
   * @return appEvent
   */
  AppEvent getAppEvent();

  /**
   * Optional. The ID of the event's conversation. Will not be present for apps in Dispatch Mode.
   *
   * @return conversationId
   */
  String getConversationId();

  /**
   * Optional. The ID of the contact. Will not be present for apps in Dispatch Mode.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  ChannelIdentity getChannelIdentity();

  /**
   * The processed time of the message in UTC timezone. Must be less than current_time and greater
   * than (current_time - 30 days).
   *
   * @return acceptTime
   */
  Instant getAcceptTime();

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  ProcessingMode getProcessingMode();

  /**
   * Get direction
   *
   * @return direction
   */
  ConversationDirection getDirection();

  /**
   * The ID of the event.
   *
   * @return id
   */
  String getId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConversationEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param appEvent see getter
     * @return Current builder
     * @see #getAppEvent
     */
    Builder setAppEvent(AppEvent appEvent);

    /**
     * see getter
     *
     * @param conversationId see getter
     * @return Current builder
     * @see #getConversationId
     */
    Builder setConversationId(String conversationId);

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId
     */
    Builder setContactId(String contactId);

    /**
     * see getter
     *
     * @param channelIdentity see getter
     * @return Current builder
     * @see #getChannelIdentity
     */
    Builder setChannelIdentity(ChannelIdentity channelIdentity);

    /**
     * see getter
     *
     * @param acceptTime see getter
     * @return Current builder
     * @see #getAcceptTime
     */
    Builder setAcceptTime(Instant acceptTime);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode
     */
    Builder setProcessingMode(ProcessingMode processingMode);

    /**
     * see getter
     *
     * @param direction see getter
     * @return Current builder
     * @see #getDirection
     */
    Builder setDirection(ConversationDirection direction);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConversationEvent build();
  }
}
