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
import java.util.List;

/** declaration */
@JsonDeserialize(builder = CarouselMessageImpl.Builder.class)
public interface CarouselMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride {

  /**
   * A list of up to 10 cards.
   *
   * @return cards
   */
  List<CardMessage> getCards();

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
    return new CarouselMessageImpl.Builder();
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
    Builder setCards(List<CardMessage> cards);

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
    CarouselMessage build();
  }
}
