package com.sinch.sdk.domains.verification.models;

/**
 * Dedicated report type for a flashcall verification
 *
 * <p>Verification report when using {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportFlashCallById} or {@link
 * com.sinch.sdk.domains.verification.VerificationsService#reportFlashCallByIdentity}
 *
 * @since 1.1
 */
public class VerificationReportFlashCall extends VerificationReport {

  protected VerificationReportFlashCall(VerificationId id, VerificationStatusType status) {
    super(id, status);
  }

  @Override
  public String toString() {
    return "VerificationReportFlashCall{} " + super.toString();
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
    public VerificationReportFlashCall build() {
      return new VerificationReportFlashCall(id, status);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
