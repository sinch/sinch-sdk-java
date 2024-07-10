/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Reason */
@JsonDeserialize(builder = ReasonImpl.Builder.class)
public interface Reason {

  /**
   * Get code
   *
   * @return code
   */
  ReasonCode getCode();

  /**
   * A textual description of the reason.
   *
   * @return description
   */
  String getDescription();

  /**
   * Get subCode
   *
   * @return subCode
   */
  ReasonSubCode getSubCode();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ReasonImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param code see getter
     * @return Current builder
     * @see #getCode
     */
    Builder setCode(ReasonCode code);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * see getter
     *
     * @param subCode see getter
     * @return Current builder
     * @see #getSubCode
     */
    Builder setSubCode(ReasonSubCode subCode);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Reason build();
  }
}
