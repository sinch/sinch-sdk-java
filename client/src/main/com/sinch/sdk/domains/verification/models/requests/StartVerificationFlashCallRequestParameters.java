package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import java.util.Optional;

/** Dedicated request parameters to be use for a flash call verification */
public class StartVerificationFlashCallRequestParameters
    extends StartVerificationRequestParameters {

  private final Integer dialTimeOut;

  /**
   * @param identity Specifies the type of endpoint that will be verified and the particular
   *     endpoint. number is currently the only supported endpoint type
   * @param reference Used to pass your own reference in the request for tracking purposes.
   * @param custom Can be used to pass custom data in the request.
   * @param dialTimeOut The dial timeout in seconds.
   */
  public StartVerificationFlashCallRequestParameters(
      Identity identity, String reference, String custom, Integer dialTimeOut) {
    super(identity, VerificationMethodType.FLASH_CALL, reference, custom);
    this.dialTimeOut = dialTimeOut;
  }

  public Optional<Integer> getDialTimeOut() {
    return Optional.ofNullable(dialTimeOut);
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

    Integer dialTimeOut;

    public Builder() {
      super(VerificationMethodType.FLASH_CALL);
    }

    public Builder setDialTimeOut(Integer dialTimeOut) {
      this.dialTimeOut = dialTimeOut;
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
