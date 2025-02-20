/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.applications;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Contains primary and or fallback callback URLs */
@JsonDeserialize(builder = CallbacksUrlImpl.Builder.class)
public interface CallbacksUrl {

  /**
   * Your primary callback URL
   *
   * @return primary
   */
  String getPrimary();

  /**
   * Your fallback callback URL (returned if configured). It is used only if Sinch platform gets a
   * timeout or error from your primary callback URL.
   *
   * @return fallback
   */
  String getFallback();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallbacksUrlImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param primary see getter
     * @return Current builder
     * @see #getPrimary
     */
    Builder setPrimary(String primary);

    /**
     * see getter
     *
     * @param fallback see getter
     * @return Current builder
     * @see #getFallback
     */
    Builder setFallback(String fallback);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CallbacksUrl build();
  }
}
