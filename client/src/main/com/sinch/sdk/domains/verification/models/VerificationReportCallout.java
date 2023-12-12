package com.sinch.sdk.domains.verification.models;

public class VerificationReportCallout extends VerificationReport {

  private final Price verificationPrice;
  private final Price terminationPrice;
  private final Integer billableDuration;
  private final Boolean callComplete;

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
   * @param callComplete Shows whether the call is complete or not.
   */
  public VerificationReportCallout(
      VerificationId id,
      VerificationReportStatusType status,
      VerificationReportReasonType reason,
      VerificationReference reference,
      Price verificationPrice,
      Price terminationPrice,
      Integer billableDuration,
      Boolean callComplete) {
    super(id, status, reason, reference);
    this.verificationPrice = verificationPrice;
    this.terminationPrice = terminationPrice;
    this.billableDuration = billableDuration;
    this.callComplete = callComplete;
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

  public Boolean getCallComplete() {
    return callComplete;
  }

  @Override
  public String toString() {
    return "VerificationReportCallout{"
        + "verificationPrice="
        + verificationPrice
        + ", terminationPrice="
        + terminationPrice
        + ", billableDuration="
        + billableDuration
        + ", callComplete="
        + callComplete
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
    Boolean callComplete;

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

    public Builder setCallComplete(Boolean callComplete) {
      this.callComplete = callComplete;
      return this;
    }

    public VerificationReportCallout build() {
      return new VerificationReportCallout(
          id,
          status,
          reason,
          reference,
          verificationPrice,
          terminationPrice,
          billableDuration,
          callComplete);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
