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

  private StartVerificationSMSRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom) {
    super(identity, VerificationMethodType.SMS, reference, custom);
  }

  @Override
  public String toString() {
    return "StartVerificationSMSRequestParameters{} " + super.toString();
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
  public static class Builder extends StartVerificationRequestParameters.Builder<Builder> {

    private Builder() {}

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    @Override
    public StartVerificationSMSRequestParameters build() {
      return new StartVerificationSMSRequestParameters(identity, reference, custom);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
