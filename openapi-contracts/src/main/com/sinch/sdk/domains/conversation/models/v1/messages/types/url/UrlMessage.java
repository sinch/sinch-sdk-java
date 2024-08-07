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

package com.sinch.sdk.domains.conversation.models.v1.messages.types.url;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A generic URL message. */
@JsonDeserialize(builder = UrlMessageImpl.Builder.class)
public interface UrlMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {

  /**
   * The title shown close to the URL. The title can be clickable in some cases.
   *
   * @return title
   */
  String getTitle();

  /**
   * The url to show.
   *
   * @return url
   */
  String getUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new UrlMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param title see getter
     * @return Current builder
     * @see #getTitle
     */
    Builder setTitle(String title);

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    UrlMessage build();
  }
}
