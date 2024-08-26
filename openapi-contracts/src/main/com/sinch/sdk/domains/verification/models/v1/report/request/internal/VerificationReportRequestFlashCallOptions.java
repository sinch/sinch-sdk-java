/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.report.request.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A configuration object containing settings specific to flash call verifications. */
@JsonDeserialize(builder = VerificationReportRequestFlashCallOptionsImpl.Builder.class)
public interface VerificationReportRequestFlashCallOptions {

  /**
   * The caller ID of the flash call.
   *
   * @return cli
   */
  String getCli();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationReportRequestFlashCallOptionsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param cli see getter
     * @return Current builder
     * @see #getCli
     */
    Builder setCli(String cli);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationReportRequestFlashCallOptions build();
  }
}
