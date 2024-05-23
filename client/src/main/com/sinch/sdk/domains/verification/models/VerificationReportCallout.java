package com.sinch.sdk.domains.verification.models;

/**
 * Dedicated report type for a callout verification
 *
 * <p>Verification report when using {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportCalloutById} or {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportCalloutByIdentity}
 *
 * @since 1.1
 */
public class VerificationReportCallout extends VerificationReport {

  protected VerificationReportCallout(VerificationId id, VerificationStatusType status) {
    super(id, status);
  }

  @Override
  public String toString() {
    return "VerificationReportCallout{} " + super.toString();
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
    public VerificationReportCallout build() {
      return new VerificationReportCallout(id, status);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
