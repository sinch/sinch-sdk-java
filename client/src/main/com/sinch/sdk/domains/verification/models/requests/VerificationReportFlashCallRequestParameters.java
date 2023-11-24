package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportFlashCallRequestParameters
    extends VerificationReportRequestParameters {

  private final String cli;

  public VerificationReportFlashCallRequestParameters(String cli) {
    super(VerificationMethodType.FLASH_CALL);
    this.cli = cli;
  }

  public String getCli() {
    return cli;
  }

  @Override
  public String toString() {
    return "VerificationReportFlashCallRequestParameters{"
        + "cli='"
        + cli
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationReportRequestParameters.Builder<Builder> {

    String cli;

    public Builder() {
      super(VerificationMethodType.FLASH_CALL);
    }

    public Builder setCli(String cli) {
      this.cli = cli;
      return this;
    }

    @Override
    public VerificationReportFlashCallRequestParameters build() {
      return new VerificationReportFlashCallRequestParameters(cli);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
