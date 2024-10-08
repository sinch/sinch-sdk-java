/*
 * Voice API | Sinch
 *
 * OpenAPI document version: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Call Headers can be used to pass custom data from a Sinch SDK client to another, or specified in
 * an ICE response to be made available to the receiving client. Further, if Call Headers is
 * specified they will be available in ICE and DICE events.
 */
@JsonDeserialize(builder = CallHeaderImpl.Builder.class)
public interface CallHeader {

  /**
   * The call header key of the key value pair.
   *
   * @return key
   */
  String getKey();

  /**
   * The call header value of the key value pair.
   *
   * @return value
   */
  String getValue();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallHeaderImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param key see getter
     * @return Current builder
     * @see #getKey
     */
    Builder setKey(String key);

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see #getValue
     */
    Builder setValue(String value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CallHeader build();
  }
}