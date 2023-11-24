package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import java.util.Optional;

public class VerificationReportSMSRequestParameters extends VerificationReportRequestParameters {

  private final String code;
  private final String cli;

  public VerificationReportSMSRequestParameters(String code, String cli) {
    super(VerificationMethodType.SMS);
    this.code = code;
    this.cli = cli;
  }

  public String getCode() {
    return code;
  }

  public Optional<String> getCli() {
    return Optional.ofNullable(cli);
  }

  @Override
  public String toString() {
    return "VerificationReportSMSRequestParameters{"
        + "code='"
        + code
        + '\''
        + ", cli='"
        + cli
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationReportRequestParameters.Builder<Builder> {

    String code;
    String cli;

    public Builder() {
      super(VerificationMethodType.SMS);
    }

    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    public Builder setCli(String cli) {
      this.cli = cli;
      return this;
    }

    @Override
    public VerificationReportSMSRequestParameters build() {
      return new VerificationReportSMSRequestParameters(code, cli);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
