/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.channel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

/** ChannelEventNotification */
@JsonDeserialize(builder = ChannelEventNotificationImpl.Builder.class)
public interface ChannelEventNotification {

  /**
   * Get channel
   *
   * @return channel
   */
  ConversationChannel getChannel();

  /**
   * The type of event being reported.
   *
   * @return eventType
   */
  String getEventType();

  /**
   * An object containing additional information regarding the event. The contents of the object
   * depend on the channel and the event_type.
   *
   * @return additionalData
   */
  Object getAdditionalData();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ChannelEventNotificationImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel
     */
    Builder setChannel(ConversationChannel channel);

    /**
     * see getter
     *
     * @param eventType see getter
     * @return Current builder
     * @see #getEventType
     */
    Builder setEventType(String eventType);

    /**
     * see getter
     *
     * @param additionalData see getter
     * @return Current builder
     * @see #getAdditionalData
     */
    Builder setAdditionalData(Object additionalData);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ChannelEventNotification build();
  }
}
