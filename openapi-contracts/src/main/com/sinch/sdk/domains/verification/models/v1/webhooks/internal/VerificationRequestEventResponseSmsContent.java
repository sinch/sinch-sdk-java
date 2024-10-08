/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.webhooks.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/** VerificationRequestEventResponseSmsContent */
@JsonDeserialize(builder = VerificationRequestEventResponseSmsContentImpl.Builder.class)
public interface VerificationRequestEventResponseSmsContent {

  /**
   * The SMS PIN that should be used. By default, the Sinch dashboard will automatically generate
   * PIN codes for SMS verification. If you want to set your own PIN, you can specify it in the
   * response to the Verification Request Event.
   *
   * @return code
   */
  String getCode();

  /**
   * The SMS verification content language. Set in the verification request.
   *
   * @return acceptLanguage
   */
  List<String> getAcceptLanguage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VerificationRequestEventResponseSmsContentImpl.Builder();
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
     * @param acceptLanguage see getter
     * @return Current builder
     * @see #getAcceptLanguage
     */
    Builder setAcceptLanguage(List<String> acceptLanguage);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VerificationRequestEventResponseSmsContent build();
  }
}
