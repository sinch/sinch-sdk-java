/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.events.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;

/** App Event Type */
@JsonDeserialize(builder = AppEventFieldInternalImpl.Builder.class)
public interface AppEventFieldInternal {

  /**
   * Get appEvent
   *
   * @return appEvent
   */
  AppEvent getAppEvent();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AppEventFieldInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param appEvent see getter
     * @return Current builder
     * @see #getAppEvent
     */
    Builder setAppEvent(AppEvent appEvent);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AppEventFieldInternal build();
  }
}
