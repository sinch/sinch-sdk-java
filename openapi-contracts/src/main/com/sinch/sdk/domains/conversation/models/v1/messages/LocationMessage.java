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

/** declaration */
@JsonDeserialize(builder = LocationMessageImpl.Builder.class)
public interface LocationMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverrideMessage {

  /**
   * Get coordinates
   *
   * @return coordinates
   */
  Coordinates getCoordinates();

  /**
   * Label or name for the position.
   *
   * @return label
   */
  String getLabel();

  /**
   * The title is shown close to the button or link that leads to a map showing the location. The
   * title can be clickable in some cases.
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
    return new LocationMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param coordinates see getter
     * @return Current builder
     * @see #getCoordinates
     */
    Builder setCoordinates(Coordinates coordinates);

    /**
     * see getter
     *
     * @param label see getter
     * @return Current builder
     * @see #getLabel
     */
    Builder setLabel(String label);

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
    LocationMessage build();
  }
}
