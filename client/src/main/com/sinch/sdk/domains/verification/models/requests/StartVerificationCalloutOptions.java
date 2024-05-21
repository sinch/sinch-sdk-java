package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Dedicated options related to
 * {@link StartVerificationCalloutRequestParameters StartVerificationCalloutRequestParameters}
 *
 * @since 1.0
 */
public class StartVerificationCalloutOptions {

  private final OptionalValue<StartVerificationCalloutSpeechOptions> speech;

  private StartVerificationCalloutOptions(
      OptionalValue<StartVerificationCalloutSpeechOptions> speech) {
    this.speech = speech;
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

  public OptionalValue<StartVerificationCalloutSpeechOptions> getSpeech() {
    return speech;
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {


    OptionalValue<StartVerificationCalloutSpeechOptions> speech = OptionalValue.empty();

    private Builder() {
    }

    /**
     * Speech settings
     *
     * @param speech Set speech settings
     * @return current builder
     * @since 1.0
     */
    public Builder setSpeech(StartVerificationCalloutSpeechOptions speech) {
      this.speech = OptionalValue.of(speech);
      return this;
    }


    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StartVerificationCalloutOptions build() {
      return new StartVerificationCalloutOptions(speech);
    }

  }
}
