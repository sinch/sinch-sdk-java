package com.sinch.sdk.domains.verification.models.webhooks;

/** Verification response related to a call out */
public class VerificationResponseCallout extends VerificationResponse {

  private final String code;
  private final VerificationResponseCalloutSpeech speech;

  /**
   * @param action Determines whether the verification can be executed.
   * @param code see {@link #getCode() getter}
   * @param speech see {@link #getSpeech() getter}
   */
  VerificationResponseCallout(
      VerificationResponseActionType action,
      String code,
      VerificationResponseCalloutSpeech speech) {
    super(action);
    this.code = code;
    this.speech = speech;
  }

  /**
   * The Phone Call PIN that should be entered by the user. Sinch servers automatically generate PIN
   * codes for Phone Call verification. If you want to set your own code, you can specify it in the
   * response to the Verification Request Event.
   *
   * @return The code value
   * @since 1.0
   */
  public String getCode() {
    return code;
  }

  /**
   * Speech related information
   *
   * @return Speech information
   * @since 1.0
   */
  public VerificationResponseCalloutSpeech getSpeech() {
    return speech;
  }

  @Override
  public String toString() {
    return "VerificationResponseCallout{"
        + "code='"
        + code
        + '\''
        + ", speech="
        + speech
        + "} "
        + super.toString();
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

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder extends VerificationResponse.Builder<Builder> {

    String code;

    VerificationResponseCalloutSpeech speech;

    private Builder() {}

    /**
     * See {@link VerificationResponseCallout#getCode()}
     *
     * @param code {@link VerificationResponseCallout#getCode()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setCode(String code) {
      this.code = code;
      return self();
    }

    /**
     * See {@link VerificationResponseCallout#getSpeech()}
     *
     * @param speech {@link VerificationResponseCallout#getSpeech()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setSpeech(VerificationResponseCalloutSpeech speech) {
      this.speech = speech;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationResponseCallout build() {
      return new VerificationResponseCallout(action, code, speech);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
