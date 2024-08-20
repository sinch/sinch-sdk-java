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

package com.sinch.sdk.domains.conversation.models.v1.conversation.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import java.time.Instant;

/** Inject Event request */
@JsonDeserialize(builder = InjectEventRequestImpl.Builder.class)
public interface InjectEventRequest {

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
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new InjectEventRequestImpl.Builder();
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
     * Create instance
     *
     * @return The instance build with current builder values
     */
    InjectEventRequest build();
  }
}