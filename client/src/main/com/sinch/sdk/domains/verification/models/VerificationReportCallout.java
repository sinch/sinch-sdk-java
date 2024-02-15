package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.domains.verification.models.NumberIdentity.Builder;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;

/**
 * Verification report related to a {@link
 * com.sinch.sdk.domains.verification.VerificationsService#startCallout(StartVerificationCalloutRequestParameters)}
 * of type {@link
 * com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters
 * VerificationReportCalloutRequestParameters}
 *
 * @since 1.0
 */
public class VerificationReportCallout extends VerificationReport {

  private final Price verificationPrice;
  private final Price terminationPrice;
  private final Integer billableDuration;
  private final Boolean callComplete;

  private VerificationReportCallout(
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
   * The maximum cost of the call made during this verification process.
   *
   * <p>Present only when termination debiting is enabled (disabled by default).
   *
   * <p>This property will appear in the body of the response with a delay. It will become visible
   * only after the call is completed, when its cost is known to Sinch.
   *
   * @return The termination price object
   * @since 1.0
   */
  public Price getTerminationPrice() {
    return terminationPrice;
  }

  /**
   * The time of the call for which the fee was charged.
   *
   * <p>Present only when termination debiting is enabled (disabled by default).
   *
   * <p>Depending on the type of rounding used, the value is the actual call time rounded to the
   * nearest second, minute or other value.
   *
   * @return The billable price object
   * @since 1.0
   */
  public Integer getBillableDuration() {
    return billableDuration;
  }

  /**
   * Shows whether the call is complete or not.
   *
   * @return TRUE.FALSE
   * @since 1.0
   */
  public Boolean getCallComplete() {
    return callComplete;
  }

  /** {@inheritDoc} */
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
    Price terminationPrice;
    Integer billableDuration;
    Boolean callComplete;

    private Builder() {}

    /**
     * See {@link VerificationReportCallout#getVerificationPrice()} getter
     *
     * @param verificationPrice See getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = verificationPrice;
      return this;
    }

    /**
     * See {@link VerificationReportCallout#getTerminationPrice()} getter
     *
     * @param terminationPrice See getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setTerminationPrice(Price terminationPrice) {
      this.terminationPrice = terminationPrice;
      return this;
    }

    /**
     * See {@link VerificationReportCallout#getBillableDuration()} getter
     *
     * @param billableDuration See getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setBillableDuration(Integer billableDuration) {
      this.billableDuration = billableDuration;
      return this;
    }

    /**
     * See {@link VerificationReportCallout#getCallComplete()} getter
     *
     * @param callComplete See getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setCallComplete(Boolean callComplete) {
      this.callComplete = callComplete;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
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
