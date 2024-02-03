package com.sinch.sdk.domains.verification.models;

public class VerificationReportSMS extends VerificationReport {

  private final Price verificationPrice;
  private final VerificationSourceType source;

  /**
   * @param id The unique ID of the verification request
   * @param status The status of the verification request
   * @param reason Displays the reason why a verification has FAILED, was DENIED, or was ABORTED
   * @param reference The reference that was optionally passed together with the verification
   *     request
   * @param verificationPrice The maximum price charged for this verification process. This property
   *     will appear in the body of the response with a delay. It will become visible only when the
   *     verification status is other than PENDING
   * @param source Used to show if the SMS was intercepted or not
   */
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

  public Price getVerificationPrice() {
    return verificationPrice;
  }

  public VerificationSourceType getSource() {
    return source;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends VerificationReport.Builder<Builder> {

    Price verificationPrice;
    VerificationSourceType source;

    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = verificationPrice;
      return this;
    }

    public Builder setSource(VerificationSourceType source) {
      this.source = source;
      return this;
    }

    public VerificationReportSMS build() {
      return new VerificationReportSMS(id, status, reason, reference, verificationPrice, source);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
