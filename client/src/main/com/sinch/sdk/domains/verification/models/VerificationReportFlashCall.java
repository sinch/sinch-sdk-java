package com.sinch.sdk.domains.verification.models;

public class VerificationReportFlashCall extends VerificationReport {

  private final Price verificationPrice;
  private final Price terminationPrice;
  private final Integer billableDuration;
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
   * @param terminationPrice The maximum cost of the call made during this verification process.
   *     Present only when termination debiting is enabled (disabled by default). This property will
   *     appear in the body of the response with a delay. It will become visible only after the call
   *     is completed, when its cost is known to Sinch
   * @param billableDuration The time of the call for which the fee was charged. Present only when
   *     termination debiting is enabled (disabled by default). Depending on the type of rounding
   *     used, the value is the actual call time rounded to the nearest second, minute or other
   *     value.
   * @param source Used to show if the call was intercepted or not
   */
  public VerificationReportFlashCall(
      VerificationId id,
      VerificationReportStatusType status,
      VerificationReportReasonType reason,
      VerificationReference reference,
      Price verificationPrice,
      Price terminationPrice,
      Integer billableDuration,
      VerificationSourceType source) {
    super(id, status, reason, reference);
    this.verificationPrice = verificationPrice;
    this.terminationPrice = terminationPrice;
    this.billableDuration = billableDuration;
    this.source = source;
  }

  public Price getVerificationPrice() {
    return verificationPrice;
  }

  public Price getTerminationPrice() {
    return terminationPrice;
  }

  public Integer getBillableDuration() {
    return billableDuration;
  }

  public VerificationSourceType getSource() {
    return source;
  }

  @Override
  public String toString() {
    return "VerificationReportFlashCall{"
        + "verificationPrice="
        + verificationPrice
        + ", terminationPrice="
        + terminationPrice
        + ", billableDuration="
        + billableDuration
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
    Price terminationPrice;
    Integer billableDuration;
    VerificationSourceType source;

    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = verificationPrice;
      return this;
    }

    public Builder setTerminationPrice(Price terminationPrice) {
      this.terminationPrice = terminationPrice;
      return this;
    }

    public Builder setBillableDuration(Integer billableDuration) {
      this.billableDuration = billableDuration;
      return this;
    }

    public Builder setSource(VerificationSourceType source) {
      this.source = source;
      return this;
    }

    public VerificationReportFlashCall build() {
      return new VerificationReportFlashCall(
          id,
          status,
          reason,
          reference,
          verificationPrice,
          terminationPrice,
          billableDuration,
          source);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
