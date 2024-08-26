/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Event that contains only a flexible payload field. */
@JsonDeserialize(builder = GenericEventInternalImpl.Builder.class)
public interface GenericEventInternal {

  /**
   * Arbitrary data set to the event. A valid JSON object.
   *
   * @return payload
   */
  Object getPayload();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new GenericEventInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param payload see getter
     * @return Current builder
     * @see #getPayload
     */
    Builder setPayload(Object payload);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    GenericEventInternal build();
  }
}
