package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportCalloutRequestParameters
    extends VerificationReportRequestParameters {

  private final String code;

  public VerificationReportCalloutRequestParameters(String code) {
    super(VerificationMethodType.CALLOUT);
    this.code = code;
  }

  public String getCode() {
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

    String code;

    public Builder() {
      super(VerificationMethodType.CALLOUT);
    }

    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    @Override
    public VerificationReportCalloutRequestParameters build() {
      return new VerificationReportCalloutRequestParameters(code);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
