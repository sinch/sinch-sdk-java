package com.sinch.sdk.domains.verification.models.webhooks;

import java.util.Collection;

/** Verification response related to a SMS */
public class VerificationResponseSMS extends VerificationResponse {

  private final String code;

  private final Collection<String> acceptLanguage;

  /**
   * SMS response related information
   *
   * @param action Determines whether the verification can be executed.
   * @param code see {@link #getCode() getter}
   * @param acceptLanguage see {@link #getAcceptLanguage() getter}
   */
  public VerificationResponseSMS(
      VerificationResponseActionType action, String code, Collection<String> acceptLanguage) {
    super(action);
    this.code = code;
    this.acceptLanguage = acceptLanguage;
  }

  /**
   * The SMS PIN that should be used. By default, the Sinch dashboard will automatically generate
   * PIN codes for SMS verification. If you want to set your own PIN, you can specify it in the
   * response to the Verification Request Event.
   *
   * @return Code value
   */
  public String getCode() {
    return code;
  }

  /**
   * The SMS verification content language. Set in the verification request.
   *
   * @return Accepted languages list
   */
  public Collection<String> getAcceptLanguage() {
    return acceptLanguage;
  }

  @Override
  public String toString() {
    return "VerificationResponseSMS{"
        + "code='"
        + code
        + '\''
        + ", acceptLanguage="
        + acceptLanguage
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
    Collection<String> acceptLanguage;

    private Builder() {}

    /**
     * See {@link VerificationResponseSMS#getCode()}
     *
     * @param code See {@link VerificationResponseSMS#getCode()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setCode(String code) {
      this.code = code;
      return self();
    }

    /**
     * See {@link VerificationResponseSMS#getAcceptLanguage()}
     *
     * @param acceptLanguage See {@link VerificationResponseSMS#getAcceptLanguage()}
     * @return The current builder
     * @since 1.0
     */
    public Builder setAcceptLanguage(Collection<String> acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationResponseSMS build() {
      return new VerificationResponseSMS(action, code, acceptLanguage);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
