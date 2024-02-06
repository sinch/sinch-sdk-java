package com.sinch.sdk.domains.verification.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;

/**
 * Dedicated request parameters to be used to start a verification report by flash call (missed
 * call)
 *
 * @since 1.0
 */
public class VerificationReportFlashCallRequestParameters
    extends VerificationReportRequestParameters {

  private final OptionalValue<String> cli;

  private VerificationReportFlashCallRequestParameters(OptionalValue<String> cli) {
    super(OptionalValue.of(VerificationMethodType.FLASH_CALL));
    this.cli = cli;
  }

  /**
   * See {@link VerificationReportFlashCallRequestParameters.Builder#setCli(String) builder setter}
   *
   * @return CLI value
   * @since 1.0
   */
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

    OptionalValue<String> cli = OptionalValue.empty();

    protected Builder() {
      super(VerificationMethodType.FLASH_CALL);
    }

    /**
     * The caller ID of the FlashCall
     *
     * @param cli The caller ID value
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
    public VerificationReportFlashCallRequestParameters build() {
      return new VerificationReportFlashCallRequestParameters(cli);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
