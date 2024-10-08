/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Reaction */
@JsonDeserialize(builder = ReactionEventImpl.Builder.class)
public interface ReactionEvent
    extends com.sinch.sdk.domains.conversation.models.v1.events.ContactMessageEvent {

  /**
   * Indicates that an emoji reaction was placed on a message. This value is the string
   * representation of the emoji. For example: &quot;&amp;#2764&amp;#FE0F&quot;
   *
   * @return emoji
   */
  String getEmoji();

  /**
   * Get action
   *
   * @return action
   */
  ReactionAction getAction();

  /**
   * The ID of the MT message that this reaction is associated with.
   *
   * @return messageId
   */
  String getMessageId();

  /**
   * If present, represents the grouping of emojis. Example values: &quot;smile&quot;,
   * &quot;angry&quot;, &quot;sad&quot;, &quot;wow&quot;, &quot;love&quot;, &quot;like&quot;,
   * &quot;dislike&quot;, &quot;other&quot;
   *
   * @return reactionCategory
   */
  String getReactionCategory();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ReactionEventImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param emoji see getter
     * @return Current builder
     * @see #getEmoji
     */
    Builder setEmoji(String emoji);

    /**
     * see getter
     *
     * @param action see getter
     * @return Current builder
     * @see #getAction
     */
    Builder setAction(ReactionAction action);

    /**
     * see getter
     *
     * @param messageId see getter
     * @return Current builder
     * @see #getMessageId
     */
    Builder setMessageId(String messageId);

    /**
     * see getter
     *
     * @param reactionCategory see getter
     * @return Current builder
     * @see #getReactionCategory
     */
    Builder setReactionCategory(String reactionCategory);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ReactionEvent build();
  }
}
