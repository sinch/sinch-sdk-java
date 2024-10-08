/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A message containing a media component, such as an image or video. */
@JsonDeserialize(builder = MediaCardMessageImpl.Builder.class)
public interface MediaCardMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody {

  /**
   * Caption for the media on supported channels.
   *
   * @return caption
   */
  String getCaption();

  /**
   * Url to the media file.
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
    return new MediaCardMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param caption see getter
     * @return Current builder
     * @see #getCaption
     */
    Builder setCaption(String caption);

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
    MediaCardMessage build();
  }
}
