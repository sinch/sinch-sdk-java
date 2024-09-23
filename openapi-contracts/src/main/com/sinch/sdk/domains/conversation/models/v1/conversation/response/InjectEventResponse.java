/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/** InjectEventResponse */
@JsonDeserialize(builder = InjectEventResponseImpl.Builder.class)
public interface InjectEventResponse {

  /**
   * Event id.
   *
   * @return eventId
   */
  String getEventId();

  /**
   * Get acceptedTime
   *
   * @return acceptedTime
   */
  Instant getAcceptedTime();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new InjectEventResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param eventId see getter
     * @return Current builder
     * @see #getEventId
     */
    Builder setEventId(String eventId);

    /**
     * see getter
     *
     * @param acceptedTime see getter
     * @return Current builder
     * @see #getAcceptedTime
     */
    Builder setAcceptedTime(Instant acceptedTime);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    InjectEventResponse build();
  }
}