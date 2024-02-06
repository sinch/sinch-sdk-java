package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Dedicated request parameters to be used for a SEAMLESS verification
 *
 * @since 1.0
 */
public class StartVerificationSeamlessRequestParameters extends StartVerificationRequestParameters {

  private StartVerificationSeamlessRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom) {
    super(identity, VerificationMethodType.SEAMLESS, reference, custom);
  }

  @Override
  public String toString() {
    return "StartVerificationSeamlessRequestParameters{} " + super.toString();
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
    public StartVerificationSeamlessRequestParameters build() {
      return new StartVerificationSeamlessRequestParameters(identity, reference, custom);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
