/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.webhooks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Flash Call Request Event Response */
@JsonDeserialize(builder = VerificationRequestEventResponseFlashCallImpl.Builder.class)
public interface VerificationRequestEventResponseFlashCall
    extends com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse {

  /**
   * Get action
   *
   * @return action
   */
  VerificationEventResponseAction getAction();

  /**
   * The phone number that will be displayed to the user when the flash call is received on the
   * user's phone. By default, the Sinch dashboard will randomly select the CLI that will be
   * displayed during a phone call from a pool of numbers. If you want to set your own CLI, you can
   * specify it in the response to the Verification Request Event.
   *
   * @return cli
   */
  String getCli();

  /**
   * The maximum time that a phone call verification will be active and can be completed. If the
   * phone number hasn't been verified successfully during this time, then the verification request
   * will fail. By default, the Sinch dashboard will automatically optimize dial time out during a
   * phone call. If you want to set your own dial time out for the phone call, you can specify it in
   * the response to the Verification Request Event.
   *
   * @return dialTimeout
   */
  Integer getDialTimeout();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationRequestEventResponseFlashCallImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse
          .Builder {

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
     * @param cli see getter
     * @return Current builder
     * @see #getCli
     */
    Builder setCli(String cli);

    /**
     * see getter
     *
     * @param dialTimeout see getter
     * @return Current builder
     * @see #getDialTimeout
     */
    Builder setDialTimeout(Integer dialTimeout);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationRequestEventResponseFlashCall build();
  }
}
