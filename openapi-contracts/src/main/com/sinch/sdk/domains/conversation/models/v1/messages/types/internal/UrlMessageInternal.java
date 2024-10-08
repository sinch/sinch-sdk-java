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

/** URL Message */
@JsonDeserialize(builder = UrlMessageInternalImpl.Builder.class)
public interface UrlMessageInternal {

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
    return new UrlMessageInternalImpl.Builder();
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
    UrlMessageInternal build();
  }
}
