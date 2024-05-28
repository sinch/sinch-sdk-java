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
@JsonDeserialize(builder = SMSRequestEventResponseImpl.Builder.class)
public interface SMSRequestEventResponse {

  /**
   * Get action
   *
   * @return action
   */
  VerificationEventResponseAction getAction();

  /**
   * Get sms
   *
   * @return sms
   */
  SMSRequestEventResponseSMSContent getSms();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SMSRequestEventResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param action see getter
     * @return Current builder
     * @see #getAction
     */
    Builder setAction(VerificationEventResponseAction action);

    /**
     * see getter
     *
     * @param sms see getter
     * @return Current builder
     * @see #getSms
     */
    Builder setSms(SMSRequestEventResponseSMSContent sms);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SMSRequestEventResponse build();
  }
}
