package com.sinch.sdk.domains.verification.models;

/**
 * Dedicated report type for a SMS verification
 *
 * <p>Verification report when using {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportSmsById} or {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportSmsByIdentity}
 *
 * @since 1.1
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
   * @since 1.1
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
     * @since 1.1
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
