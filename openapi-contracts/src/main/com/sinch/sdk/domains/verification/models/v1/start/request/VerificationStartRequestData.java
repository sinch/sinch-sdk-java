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

package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.verification.models.v1.Identity;

/** VerificationStartRequestData */
@JsonDeserialize(builder = VerificationStartRequestDataImpl.Builder.class)
public interface VerificationStartRequestData
    extends com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest {

  /**
   * Get identity
   *
   * @return identity
   */
  Identity getIdentity();

  /**
   * Used to pass your own reference in the request for tracking purposes.
   *
   * @return reference
   */
  String getReference();

  /**
   * Can be used to pass custom data in the request.
   *
   * @return custom
   */
  String getCustom();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationStartRequestDataImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest
          .Builder {

    /**
     * see getter
     *
     * @param identity see getter
     * @return Current builder
     * @see #getIdentity
     */
    Builder setIdentity(Identity identity);

    /**
     * see getter
     *
     * @param reference see getter
     * @return Current builder
     * @see #getReference
     */
    Builder setReference(String reference);

    /**
     * see getter
     *
     * @param custom see getter
     * @return Current builder
     * @see #getCustom
     */
    Builder setCustom(String custom);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationStartRequestData build();
  }
}
