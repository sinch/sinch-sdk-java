package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import java.util.Optional;

public class StartVerificationFlashCallRequestParameters
    extends StartVerificationRequestParameters {

  private final Integer dialTimeOut;

  public StartVerificationFlashCallRequestParameters(
      Identity identity,
      VerificationMethod method,
      String reference,
      String custom,
      Integer dialTimeOut) {
    super(identity, method, reference, custom);
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

  public static class Builder extends StartVerificationRequestParameters.Builder {

    Integer dialTimeOut;

    public Builder setDialTimeOut(Integer dialTimeOut) {
      this.dialTimeOut = dialTimeOut;
      return this;
    }

    public StartVerificationFlashCallRequestParameters build() {
      return new StartVerificationFlashCallRequestParameters(
          identity, method, reference, custom, dialTimeOut);
    }
  }
}
