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

/** Media Properties */
@JsonDeserialize(builder = MediaPropertiesInternalImpl.Builder.class)
public interface MediaPropertiesInternal {

  /**
   * An optional parameter. Will be used where it is natively supported.
   *
   * @return thumbnailUrl
   */
  String getThumbnailUrl();

  /**
   * Url to the media file.
   *
   * @return url
   */
  String getUrl();

  /**
   * Overrides the media file name.
   *
   * @return filenameOverride
   */
  String getFilenameOverride();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MediaPropertiesInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param thumbnailUrl see getter
     * @return Current builder
     * @see #getThumbnailUrl
     */
    Builder setThumbnailUrl(String thumbnailUrl);

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * see getter
     *
     * @param filenameOverride see getter
     * @return Current builder
     * @see #getFilenameOverride
     */
    Builder setFilenameOverride(String filenameOverride);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MediaPropertiesInternal build();
  }
}
