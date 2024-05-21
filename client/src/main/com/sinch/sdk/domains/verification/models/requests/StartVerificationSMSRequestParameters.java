package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Dedicated request parameters to be used for an SMS verification
 *
 * @since 1.0
 */
public class StartVerificationSMSRequestParameters extends StartVerificationRequestParameters {

  private final OptionalValue<String> acceptLanguage;
  private final OptionalValue<StartVerificationSMSOptions> options;

  private StartVerificationSMSRequestParameters(
      OptionalValue<String> acceptLanguage,
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationSMSOptions> options) {
    super(identity, VerificationMethodType.SMS, reference, custom);
    this.acceptLanguage = acceptLanguage;
    this.options = options;
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

  public OptionalValue<String> getAcceptLanguage() {
    return acceptLanguage;
  }

  public OptionalValue<StartVerificationSMSOptions> getOptions() {
    return options;
  }

  @Override
  public String toString() {
    return "StartVerificationSMSRequestParameters{} " + super.toString();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder extends StartVerificationRequestParameters.Builder<Builder> {

    OptionalValue<String> acceptLanguage = OptionalValue.empty();
    OptionalValue<StartVerificationSMSOptions> options = OptionalValue.empty();

    private Builder() {
    }

    /**
     * Value of <a
     * href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language">Accept-Language</a>
     * header is used to determine the language of an SMS message.
     *
     * @param acceptLanguage Specifies accept language value to be used
     * @return current builder
     * @since 1.0
     */
    public Builder setAcceptLanguage(String acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return self();
    }

    /**
     * SMS options to be used
     *
     * @param options Specifies options
     * @return current builder
     * @since 1.0
     */
    public Builder setOptions(StartVerificationSMSOptions options) {
      this.options = OptionalValue.of(options);
      return self();
    }


    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    @Override
    public StartVerificationSMSRequestParameters build() {
      return new StartVerificationSMSRequestParameters(acceptLanguage, identity, reference, custom,
          options);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
