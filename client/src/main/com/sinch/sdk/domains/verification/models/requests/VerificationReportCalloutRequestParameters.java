package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

/**
 * Dedicated request parameters to be used to start a verification report by callout (Verification
 * by placing a PSTN call to the user's phone)
 *
 * @since 1.0
 */
public class VerificationReportCalloutRequestParameters
    extends VerificationReportRequestParameters {

  private final OptionalValue<String> code;

  private VerificationReportCalloutRequestParameters(OptionalValue<String> code) {
    super(OptionalValue.of(VerificationMethodType.CALLOUT));
    this.code = code;
  }

  /**
   * See {@link VerificationReportCalloutRequestParameters.Builder#setCode(String) builder setter}
   *
   * @return Code value
   * @since 1.0
   */
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

    protected Builder() {
      super(VerificationMethodType.CALLOUT);
    }

    /**
     * The code which was received by the user submitting the SMS verification.
     *
     * @param code The code which was received by the user submitting the Phone Call verification.
     * @return current builder
     */
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReportCalloutRequestParameters build() {
      return new VerificationReportCalloutRequestParameters(code);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
