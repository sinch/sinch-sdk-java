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

/** MachineLearningImageRecognitionResult */
@JsonDeserialize(builder = MachineLearningImageRecognitionResultImpl.Builder.class)
public interface MachineLearningImageRecognitionResult {

  /**
   * The URL of the image that was processed.
   *
   * @return url
   */
  String getUrl();

  /**
   * Get documentImageClassification
   *
   * @return documentImageClassification
   */
  DocumentImageClassification getDocumentImageClassification();

  /**
   * Get opticalCharacterRecognition
   *
   * @return opticalCharacterRecognition
   */
  OpticalCharacterRecognition getOpticalCharacterRecognition();

  /**
   * Get documentFieldClassification
   *
   * @return documentFieldClassification
   */
  DocumentFieldClassification getDocumentFieldClassification();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MachineLearningImageRecognitionResultImpl.Builder();
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
    Builder setUrl(String url);

    /**
     * see getter
     *
     * @param documentImageClassification see getter
     * @return Current builder
     * @see #getDocumentImageClassification
     */
    Builder setDocumentImageClassification(DocumentImageClassification documentImageClassification);

    /**
     * see getter
     *
     * @param opticalCharacterRecognition see getter
     * @return Current builder
     * @see #getOpticalCharacterRecognition
     */
    Builder setOpticalCharacterRecognition(OpticalCharacterRecognition opticalCharacterRecognition);

    /**
     * see getter
     *
     * @param documentFieldClassification see getter
     * @return Current builder
     * @see #getDocumentFieldClassification
     */
    Builder setDocumentFieldClassification(DocumentFieldClassification documentFieldClassification);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MachineLearningImageRecognitionResult build();
  }
}
