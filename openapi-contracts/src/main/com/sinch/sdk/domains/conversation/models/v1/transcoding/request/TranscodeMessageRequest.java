/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.transcoding.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import java.util.List;

/** TranscodeMessageRequest */
@JsonDeserialize(builder = TranscodeMessageRequestImpl.Builder.class)
public interface TranscodeMessageRequest {

  /**
   * The ID of the app used to transcode the message.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Get appMessage
   *
   * @return appMessage
   */
  AppMessage<?> getAppMessage();

  /**
   * The list of channels for which the message shall be transcoded to.
   *
   * @return channels
   */
  List<ConversationChannel> getChannels();

  /**
   * Optional.
   *
   * @return from
   */
  String getFrom();

  /**
   * Optional.
   *
   * @return to
   */
  String getTo();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TranscodeMessageRequestImpl.Builder();
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
     * @param appMessage see getter
     * @return Current builder
     * @see #getAppMessage
     */
    Builder setAppMessage(AppMessage<?> appMessage);

    /**
     * see getter
     *
     * @param channels see getter
     * @return Current builder
     * @see #getChannels
     */
    Builder setChannels(List<ConversationChannel> channels);

    /**
     * see getter
     *
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(String from);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(String to);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TranscodeMessageRequest build();
  }
}
