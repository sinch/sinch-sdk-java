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

package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardHeight;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageMedia;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import java.util.List;

/** Message containing text, media and choices. */
@JsonDeserialize(builder = CardMessageInternalImpl.Builder.class)
public interface CardMessageInternal {

  /**
   * You may include choices in your Card Message. The number of choices is limited to 10.
   *
   * @return choices
   */
  List<Choice<?>> getChoices();

  /**
   * This is an optional description field that is displayed below the title on the card.
   *
   * @return description
   */
  String getDescription();

  /**
   * Get height
   *
   * @return height
   */
  CardHeight getHeight();

  /**
   * Get media
   *
   * @return media
   */
  CardMessageMedia getMedia();

  /**
   * The title of the card message.
   *
   * @return title
   */
  String getTitle();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CardMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param choices see getter
     * @return Current builder
     * @see #getChoices
     */
    Builder setChoices(List<Choice<?>> choices);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param height see getter
     * @return Current builder
     * @see #getHeight
     */
    Builder setHeight(CardHeight height);

    /**
     * see getter
     *
     * @param media see getter
     * @return Current builder
     * @see #getMedia
     */
    Builder setMedia(CardMessageMedia media);

    /**
     * see getter
     *
     * @param title see getter
     * @return Current builder
     * @see #getTitle
     */
    Builder setTitle(String title);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CardMessageInternal build();
  }
}
