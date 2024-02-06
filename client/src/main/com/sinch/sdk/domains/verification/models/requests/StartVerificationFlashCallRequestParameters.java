package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/**
 * Dedicated request parameters to be used for a FLASH_CALL verification
 *
 * @since 1.0
 */
public class StartVerificationFlashCallRequestParameters
    extends StartVerificationRequestParameters {

  private final OptionalValue<Integer> dialTimeOut;

  private StartVerificationFlashCallRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom,
      OptionalValue<Integer> dialTimeOut) {
    super(identity, VerificationMethodType.FLASH_CALL, reference, custom);
    this.dialTimeOut = dialTimeOut;
  }

  /**
   * See {@link StartVerificationFlashCallRequestParameters.Builder#setDialTimeOut(Integer) builder
   * setter}
   *
   * @return Dial Time Out value
   * @since 1.0
   */
  public OptionalValue<Integer> getDialTimeOut() {
    return dialTimeOut;
  }

  @Override
  public String toString() {
    return "StartVerificationFlashCallRequestParameters{"
        + "dialTimeOut="
        + dialTimeOut
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
  public static class Builder extends StartVerificationRequestParameters.Builder<Builder> {

    OptionalValue<Integer> dialTimeOut = OptionalValue.empty();

    private Builder() {}

    /**
     * Set the dial timeout
     *
     * @param dialTimeOut The dial timeout in seconds.
     * @return current builder
     * @since 1.0
     */
    public Builder setDialTimeOut(Integer dialTimeOut) {
      this.dialTimeOut = OptionalValue.of(dialTimeOut);
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    @Override
    public StartVerificationFlashCallRequestParameters build() {
      return new StartVerificationFlashCallRequestParameters(
          identity, reference, custom, dialTimeOut);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
