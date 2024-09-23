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

/** An object that contains the PII analysis of the corresponding messages. */
@JsonDeserialize(builder = MachineLearningPIIResultImpl.Builder.class)
public interface MachineLearningPIIResult {

  /**
   * The message text that was analyzed.
   *
   * @return message
   */
  String getMessage();

  /**
   * The redacted message text in which sensitive information was replaced with appropriate masks. A
   * MISC mask is applied to a term that has been identified as PII, but with low confidence
   * regarding which type of mask to assign.
   *
   * @return masked
   */
  String getMasked();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MachineLearningPIIResultImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(String message);

    /**
     * see getter
     *
     * @param masked see getter
     * @return Current builder
     * @see #getMasked
     */
    Builder setMasked(String masked);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MachineLearningPIIResult build();
  }
}