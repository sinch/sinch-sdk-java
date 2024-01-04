package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportSMSRequestParameters extends VerificationReportRequestParameters {

  private final OptionalValue<String> code;
  private final OptionalValue<String> cli;

  private VerificationReportSMSRequestParameters(
      OptionalValue<String> code, OptionalValue<String> cli) {
    super(OptionalValue.of(VerificationMethodType.SMS));
    this.code = code;
    this.cli = cli;
  }

  public OptionalValue<String> getCode() {
    return code;
  }

  public OptionalValue<String> getCli() {
    return cli;
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

    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();

    public Builder() {
      super(VerificationMethodType.SMS);
    }

    /**
     * @param code The code which was received by the user submitting the SMS verification.
     * @return current builder
     */
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    /**
     * @param cli The sender ID of the SMS.
     * @return current builder
     */
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
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
