/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/**
 * An object containing a result array that reports the machine learning engine's character
 * extraction results.
 */
@JsonDeserialize(builder = OpticalCharacterRecognitionImpl.Builder.class)
public interface OpticalCharacterRecognition {

  /**
   * The result of the OCR process.
   *
   * @return result
   */
  List<OpticalCharacterRecognitionData> getResult();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OpticalCharacterRecognitionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param result see getter
     * @return Current builder
     * @see #getResult
     */
    Builder setResult(List<OpticalCharacterRecognitionData> result);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OpticalCharacterRecognition build();
  }
}
