/*
 * Verification | Sinch
 *
 * OpenAPI document version: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Text-To-Speech engine settings */
@JsonDeserialize(builder = PhoneCallSpeechImpl.Builder.class)
public interface PhoneCallSpeech {

  /**
   * A <code>language-region</code> identifier according to <a
   * href="https://www.iana.org/assignments/language-subtag-registry/language-subtag-registry">IANA</a>.
   * Only a subset of those identifiers is accepted.
   *
   * @return locale
   */
  String getLocale();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PhoneCallSpeechImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param locale see getter
     * @return Current builder
     * @see #getLocale
     */
    Builder setLocale(String locale);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PhoneCallSpeech build();
  }
}
