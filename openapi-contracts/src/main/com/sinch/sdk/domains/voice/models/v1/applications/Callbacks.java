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

/** Callbacks */
@JsonDeserialize(builder = CallbacksImpl.Builder.class)
public interface Callbacks {

  /**
   * Get url
   *
   * @return url
   */
  CallbacksUrl getUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallbacksImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(CallbacksUrl url);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Callbacks build();
  }
}
