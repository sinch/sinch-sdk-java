package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

public class VerificationReportFlashCallRequestParameters
    extends VerificationReportRequestParameters {

  private final OptionalValue<String> cli;

  private VerificationReportFlashCallRequestParameters(OptionalValue<String> cli) {
    super(OptionalValue.of(VerificationMethodType.FLASH_CALL));
    this.cli = cli;
  }

  public OptionalValue<String> getCli() {
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

    OptionalValue<String> cli = OptionalValue.empty();

    protected Builder() {
      super(VerificationMethodType.FLASH_CALL);
    }

    /**
     * @param cli The caller ID of the FlashCall
     * @return current builder
     */
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    public VerificationReportFlashCallRequestParameters build() {
      return new VerificationReportFlashCallRequestParameters(cli);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
