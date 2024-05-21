package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Dedicated request parameters to be used for a CALLOUT verification
 *
 * @since 1.0
 */
public class StartVerificationCalloutRequestParameters extends StartVerificationRequestParameters {

  private final OptionalValue<StartVerificationCalloutOptions> options;

  private StartVerificationCalloutRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationCalloutOptions> options) {
    super(identity, VerificationMethodType.CALLOUT, reference, custom);
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

  public OptionalValue<StartVerificationCalloutOptions> getOptions() {
    return options;
  }

  @Override
  public String toString() {
    return "StartVerificationCalloutRequestParameters{} " + super.toString();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder extends StartVerificationRequestParameters.Builder<Builder> {

    OptionalValue<StartVerificationCalloutOptions> options = OptionalValue.empty();

    private Builder() {
    }

    /**
     * Callout options to be used
     *
     * @param options Specifies options
     * @return current builder
     * @since 1.0
     */
    public Builder setOptions(StartVerificationCalloutOptions options) {
      this.options = OptionalValue.of(options);
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    @Override
    public StartVerificationCalloutRequestParameters build() {
      return new StartVerificationCalloutRequestParameters(identity, reference, custom, options);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
