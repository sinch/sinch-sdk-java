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

package com.sinch.sdk.domains.conversation.models.v1.messages.types.media;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A message containing a media component, such as an image, document, or video. */
@JsonDeserialize(builder = MediaMessageImpl.Builder.class)
public interface MediaMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {

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
    return new MediaMessageImpl.Builder();
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
    MediaMessage build();
  }
}
