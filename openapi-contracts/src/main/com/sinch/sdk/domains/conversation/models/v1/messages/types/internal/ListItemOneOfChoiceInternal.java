/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;

/** Choice */
@JsonDeserialize(builder = ListItemOneOfChoiceInternalImpl.Builder.class)
public interface ListItemOneOfChoiceInternal {

  /**
   * Get choice
   *
   * @return choice
   */
  ChoiceItem getChoice();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListItemOneOfChoiceInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param choice see getter
     * @return Current builder
     * @see #getChoice
     */
    Builder setChoice(ChoiceItem choice);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListItemOneOfChoiceInternal build();
  }
}