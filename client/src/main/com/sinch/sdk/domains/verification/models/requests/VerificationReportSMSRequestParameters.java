package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

/**
 * Dedicated request parameters to be used to start a verification report by SMS
 *
 * @since 1.0
 */
public class VerificationReportSMSRequestParameters extends VerificationReportRequestParameters {

  private final OptionalValue<String> code;
  private final OptionalValue<String> cli;

  private VerificationReportSMSRequestParameters(
      OptionalValue<String> code, OptionalValue<String> cli) {
    super(OptionalValue.of(VerificationMethodType.SMS));
    this.code = code;
    this.cli = cli;
  }

  /**
   * See {@link VerificationReportSMSRequestParameters.Builder#setCode(String) builder setter}
   *
   * @return Code value
   * @since 1.0
   */
  public OptionalValue<String> getCode() {
    return code;
  }

  /**
   * See {@link VerificationReportSMSRequestParameters.Builder#setCli(String) builder setter}
   *
   * @return CLI value
   * @since 1.0
   */
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
  public static class Builder extends VerificationReportRequestParameters.Builder<Builder> {

    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();

    protected Builder() {
      super(VerificationMethodType.SMS);
    }

    /**
     * The code which was received by the user submitting the SMS verification.
     *
     * @param code The code value
     * @return current builder
     * @since 1.0
     */
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    /**
     * The sender ID of the SMS.
     *
     * @param cli The sender ID value
     * @return current builder
     * @since 1.0
     */
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReportSMSRequestParameters build() {
      return new VerificationReportSMSRequestParameters(code, cli);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
