/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** declaration */
@JsonDeserialize(builder = CalloutRequestEventResponseCalloutContentImpl.Builder.class)
public interface CalloutRequestEventResponseCalloutContent {

  /**
   * The Phone Call PIN that should be entered by the user. Sinch servers automatically generate PIN
   * codes for Phone Call verification. If you want to set your own code, you can specify it in the
   * response to the Verification Request Event.
   *
   * @return code
   */
  String getCode();

  /**
   * Get speech
   *
   * @return speech
   */
  CalloutRequestEventResponseCalloutSpeechContent getSpeech();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CalloutRequestEventResponseCalloutContentImpl.Builder();
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
    Builder setCode(String code);

    /**
     * see getter
     *
     * @param speech see getter
     * @return Current builder
     * @see #getSpeech
     */
    Builder setSpeech(CalloutRequestEventResponseCalloutSpeechContent speech);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    CalloutRequestEventResponseCalloutContent build();
  }
}
