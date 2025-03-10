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
 * An optional property used to enable <a
 * href="https://developers.sinch.com/docs/voice/api-reference/amd_v2">Answering Machine
 * Detection</a> (AMD).
 */
@JsonDeserialize(builder = ConnectPstnAnsweringMachineDetectionImpl.Builder.class)
public interface ConnectPstnAnsweringMachineDetection {

  /**
   * Sets whether AMD is enabled.
   *
   * @return enabled
   */
  Boolean getEnabled();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConnectPstnAnsweringMachineDetectionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param enabled see getter
     * @return Current builder
     * @see #getEnabled
     */
    Builder setEnabled(Boolean enabled);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConnectPstnAnsweringMachineDetection build();
  }
}
