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

/** VerificationRequestEventResponse */
public interface VerificationRequestEventResponse {

  /**
   * Get action
   *
   * @return action
   */
  VerificationEventResponseAction getAction();

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
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationRequestEventResponse build();
  }
}
