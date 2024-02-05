package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportCalloutRequestParameters
    extends VerificationReportRequestParameters {

  private final OptionalValue<String> code;

  private VerificationReportCalloutRequestParameters(OptionalValue<String> code) {
    super(OptionalValue.of(VerificationMethodType.CALLOUT));
    this.code = code;
  }

  public OptionalValue<String> getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "VerificationReportCalloutRequestParameters{"
        + "code='"
        + code
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationReportRequestParameters.Builder<Builder> {

    OptionalValue<String> code = OptionalValue.empty();

    protected Builder() {
      super(VerificationMethodType.CALLOUT);
    }

    /**
     * @param code The code which was received by the user submitting the Phone Call verification.
     * @return current builder
     */
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    public VerificationReportCalloutRequestParameters build() {
      return new VerificationReportCalloutRequestParameters(code);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
