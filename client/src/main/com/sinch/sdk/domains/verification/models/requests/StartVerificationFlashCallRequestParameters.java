package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;

/** Dedicated request parameters to be used for a flash call verification */
public class StartVerificationFlashCallRequestParameters
    extends StartVerificationRequestParameters {

  private final OptionalValue<Integer> dialTimeOut;

  private StartVerificationFlashCallRequestParameters(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationReference> reference,
      OptionalValue<String> custom,
      OptionalValue<Integer> dialTimeOut) {
    super(identity, OptionalValue.of(VerificationMethodType.FLASH_CALL), reference, custom);
    this.dialTimeOut = dialTimeOut;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends StartVerificationRequestParameters.Builder<Builder> {

    OptionalValue<Integer> dialTimeOut = OptionalValue.empty();

    public Builder() {
      super(VerificationMethodType.FLASH_CALL);
    }

    /**
     * @param dialTimeOut The dial timeout in seconds.
     * @return current builder
     */
    public Builder setDialTimeOut(Integer dialTimeOut) {
      this.dialTimeOut = OptionalValue.of(dialTimeOut);
      return this;
    }

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
