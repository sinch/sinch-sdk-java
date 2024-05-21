package com.sinch.sdk.domains.verification.models;

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
public class VerificationReportSMS extends VerificationReport {

  protected VerificationReportSMS(VerificationId id, VerificationStatusType status) {
    super(id, status);
  }

  @Override
  public String toString() {
    return "VerificationReportSMS{} " + super.toString();
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

    private Builder() {}

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReportSMS build() {
      return new VerificationReportSMS(id, status);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
