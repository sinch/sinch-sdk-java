package com.sinch.sdk.domains.verification.models;

/**
 * Verification report related to a {@link
 * com.sinch.sdk.domains.verification.VerificationsService#start(StartVerificationRequestParameters)
 * VerificationsService#start()} of type {@link
 * com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters
 * VerificationReportSMSRequestParameters}
 *
 * @since 1.0
 */
public class VerificationReportSMS extends VerificationReport {

  private final Price verificationPrice;
  private final VerificationSourceType source;

  private VerificationReportSMS(
      VerificationId id,
      VerificationReportStatusType status,
      VerificationReportReasonType reason,
      VerificationReference reference,
      Price verificationPrice,
      VerificationSourceType source) {
    super(id, status, reason, reference);
    this.verificationPrice = verificationPrice;
    this.source = source;
  }

  /**
   * The maximum price charged for this verification process.
   *
   * <p>This property will appear in the body of the response with a delay. It will become visible
   * only when the verification status is other than {@link VerificationReportStatusType#PENDING
   * PENDING}
   *
   * @return Verification price object
   * @since 1.0
   */
  public Price getVerificationPrice() {
    return verificationPrice;
  }

  /**
   * Used to show if the SMS was intercepted or not
   *
   * @return Source type value
   * @since 1.0
   */
  public VerificationSourceType getSource() {
    return source;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationReportSMS{"
        + "verificationPrice="
        + verificationPrice
        + ", source='"
        + source
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

  /** Dedicated Builder */
  public static class Builder extends VerificationReport.Builder<Builder> {

    Price verificationPrice;
    VerificationSourceType source;

    private Builder() {}

    /**
     * See {@link VerificationReportSMS#getVerificationPrice() getter}
     *
     * @param verificationPrice Price object value
     * @return Current builder
     * @since 1.0
     */
    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = verificationPrice;
      return this;
    }

    /**
     * See {@link VerificationReportSMS#getSource() getter}
     *
     * @param source Source to be set
     * @return Current builder
     * @since 1.0
     */
    public Builder setSource(VerificationSourceType source) {
      this.source = source;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReportSMS build() {
      return new VerificationReportSMS(id, status, reason, reference, verificationPrice, source);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
