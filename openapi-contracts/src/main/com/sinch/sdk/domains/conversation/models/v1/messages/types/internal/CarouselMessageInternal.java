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
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import java.util.List;

/** Carousel Message */
@JsonDeserialize(builder = CarouselMessageInternalImpl.Builder.class)
public interface CarouselMessageInternal {

  /**
   * A list of up to 10 cards.
   *
   * @return cards
   */
  List<CardMessageInternal> getCards();

  /**
   * Optional. Outer choices on the carousel level. The number of outer choices is limited to 3.
   *
   * @return choices
   */
  List<Choice<?>> getChoices();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CarouselMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param cards see getter
     * @return Current builder
     * @see #getCards
     */
    Builder setCards(List<CardMessageInternal> cards);

    /**
     * see getter
     *
     * @param choices see getter
     * @return Current builder
     * @see #getChoices
     */
    Builder setChoices(List<Choice<?>> choices);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CarouselMessageInternal build();
  }
}