/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Footer of the interactive message. */
@JsonDeserialize(builder = WhatsAppInteractiveFooterImpl.Builder.class)
public interface WhatsAppInteractiveFooter {

  /**
   * The footer content (60 characters maximum). Emojis, Markdown and links are supported.
   *
   * @return text
   */
  String getText();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new WhatsAppInteractiveFooterImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    WhatsAppInteractiveFooter build();
  }
}
