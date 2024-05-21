package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Text-To-Speech engine settings
 * <p></p>
 * Dedicated options related to
 * {@link StartVerificationCalloutOptions StartVerificationCalloutOptions}
 *
 * @since 1.0
 */
public class StartVerificationCalloutSpeechOptions {

  private final OptionalValue<String> locale;


  private StartVerificationCalloutSpeechOptions(
      OptionalValue<String> locale) {
    this.locale = locale;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {


    private OptionalValue<String> locale = OptionalValue.empty();

    private Builder() {
    }

    /**
     * A language-region identifier according to IANA. Only a subset of those identifiers is
     * accepted to be used for Text To Speech engine
     *
     * @param locale Specifies expiry time
     * @return current builder
     * @since 1.0
     */
    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }


    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationCalloutSpeechOptions build() {
      return new StartVerificationCalloutSpeechOptions(locale);
    }

  }
}
