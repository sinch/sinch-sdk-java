package com.sinch.sdk.domains.verification.models.webhooks;

/** Verification response details related to call out speech */
public class VerificationResponseCalloutSpeech {

  private final String locale;

  /**
   * Indicates the language that should be used for the text-to-speech message. Currently, only
   * en-US is supported.
   *
   * @param locale Locale value
   */
  VerificationResponseCalloutSpeech(String locale) {
    this.locale = locale;
  }

  /**
   * Indicates the language that should be used for the text-to-speech message. Currently, only
   * en-US is supported.
   *
   * @return locale value
   * @since 1.1
   */
  public String getLocale() {
    return locale;
  }

  @Override
  public String toString() {
    return "VerificationResponseCalloutSpeech{" + "locale='" + locale + '\'' + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.1
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.1
   */
  public static class Builder {

    String locale;

    private Builder() {}

    /**
     * See {@link VerificationResponseCalloutSpeech#VerificationResponseCalloutSpeech(String)
     * constructor}
     *
     * @param locale see constructor
     * @return The current builder
     * @since 1.1
     */
    public Builder setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.1
     */
    public VerificationResponseCalloutSpeech build() {
      return new VerificationResponseCalloutSpeech(locale);
    }
  }
}
