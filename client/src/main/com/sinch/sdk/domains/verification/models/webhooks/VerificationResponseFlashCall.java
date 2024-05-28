package com.sinch.sdk.domains.verification.models.webhooks;

/** Verification response related to a flash call */
public class VerificationResponseFlashCall extends VerificationResponse {

  private final String cli;

  private final Integer dialTimeout;

  /**
   * Flash call response related information
   *
   * @param action Determines whether the verification can be executed.
   * @param cli see {@link #getCli() getter}
   * @param dialTimeout see {@link #getDialTimeout() getter}
   */
  public VerificationResponseFlashCall(
      VerificationResponseActionType action, String cli, Integer dialTimeout) {
    super(action);
    this.cli = cli;
    this.dialTimeout = dialTimeout;
  }

  /**
   * The phone number that will be displayed to the user when the flashcall is received on the
   * user's phone. By default, the Sinch dashboard will randomly select the CLI that will be
   * displayed during a flashcall from a pool of numbers. If you want to set your own CLI, you can
   * specify it in the response to the Verification Request Event.
   *
   * @return CLI value
   * @since 1.0
   */
  public String getCli() {
    return cli;
  }

  /**
   * The maximum time that a flashcall verification will be active and can be completed. If the
   * phone number hasn't been verified successfully during this time, then the verification request
   * will fail. By default, the Sinch dashboard will automatically optimize dial time out during a
   * flashcall. If you want to set your own dial time out for the flashcall, you can specify it in
   * the response to the Verification Request Event.
   *
   * @return The dial timeout value
   * @since 1.0
   */
  public Integer getDialTimeout() {
    return dialTimeout;
  }

  @Override
  public String toString() {
    return "VerificationResponseFlashCall{"
        + "cli='"
        + cli
        + '\''
        + ", dialTimeout="
        + dialTimeout
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

    String cli;

    Integer dialTimeout;

    private Builder() {}

    /**
     * See {@link VerificationResponseFlashCall#getCli()}
     *
     * @param cli See {@link VerificationResponseFlashCall#getCli()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setCli(String cli) {
      this.cli = cli;
      return self();
    }

    /**
     * See {@link VerificationResponseFlashCall#getDialTimeout()}
     *
     * @param dialTimeout See {@link VerificationResponseFlashCall#getDialTimeout()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = dialTimeout;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationResponseFlashCall build() {
      return new VerificationResponseFlashCall(action, cli, dialTimeout);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
