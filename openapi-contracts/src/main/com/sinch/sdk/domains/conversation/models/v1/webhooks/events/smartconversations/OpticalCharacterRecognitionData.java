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

/** OpticalCharacterRecognitionData */
@JsonDeserialize(builder = OpticalCharacterRecognitionDataImpl.Builder.class)
public interface OpticalCharacterRecognitionData {

  /**
   * The data array contains the string(s) identified in one section of an analyzed image.
   *
   * @return data
   */
  List<String> getData();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OpticalCharacterRecognitionDataImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param data see getter
     * @return Current builder
     * @see #getData
     */
    Builder setData(List<String> data);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OpticalCharacterRecognitionData build();
  }
}
