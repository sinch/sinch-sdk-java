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

package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Represents an agent that is involved in a conversation. */
@JsonDeserialize(builder = AgentImpl.Builder.class)
public interface Agent {

  /**
   * Agent&#39;s display name
   *
   * @return displayName
   */
  String getDisplayName();

  /**
   * Agent&#39;s classification. It can be UNKNOWN_AGENT_TYPE, HUMAN or BOT.
   *
   * @return type
   */
  String getType();

  /**
   * The Agent&#39;s picture url.
   *
   * @return pictureUrl
   */
  String getPictureUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AgentImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param displayName see getter
     * @return Current builder
     * @see #getDisplayName
     */
    Builder setDisplayName(String displayName);

    /**
     * see getter
     *
     * @param type see getter
     * @return Current builder
     * @see #getType
     */
    Builder setType(String type);

    /**
     * see getter
     *
     * @param pictureUrl see getter
     * @return Current builder
     * @see #getPictureUrl
     */
    Builder setPictureUrl(String pictureUrl);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Agent build();
  }
}
