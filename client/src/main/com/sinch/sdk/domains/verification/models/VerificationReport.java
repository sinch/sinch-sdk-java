package com.sinch.sdk.domains.verification.models;

/**
 * Common class to all verification report responses
 *
 * @since 1.0
 */
public class VerificationReport {

  private final VerificationId id;
  private final VerificationReportStatusType status;
  private final VerificationReportReasonType reason;
  private final VerificationReference reference;

  protected VerificationReport(
      VerificationId id,
      VerificationReportStatusType status,
      VerificationReportReasonType reason,
      VerificationReference reference) {
    this.id = id;
    this.status = status;
    this.reason = reason;
    this.reference = reference;
  }

  /**
   * ID related to verification request
   *
   * @return Verification ID
   * @since 1.0
   */
  public VerificationId getId() {
    return id;
  }

  /**
   * Current verification status
   *
   * @return The status value
   * @since 1.0
   */
  public VerificationReportStatusType getStatus() {
    return status;
  }

  /**
   * The reason why a verification has {@link VerificationReportStatusType#FAIL FAIL}, was {@link
   * VerificationReportStatusType#DENIED DENIED}, or was {@link VerificationReportStatusType#ABORTED
   * ABORTED}.
   *
   * @return The reason value
   * @since 1.0
   */
  public VerificationReportReasonType getReason() {
    return reason;
  }

  /**
   * The reference value that was optionally passed together with the verification request.
   *
   * @return The reference value
   */
  public VerificationReference getReference() {
    return reference;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationReport{"
        + "id='"
        + id
        + '\''
        + ", status="
        + status
        + ", reason="
        + reason
        + ", reference='"
        + reference
        + '\''
        + '}';
  }

  protected static Builder<?> builder() {
    return new Builder<>();
  }

  /**
   * Dedicated Builder
   *
   * @param <B> Builder
   * @since 1.0
   */
  public static class Builder<B extends Builder<B>> {

    VerificationId id;
    VerificationReportStatusType status;
    VerificationReportReasonType reason;
    VerificationReference reference;

    protected Builder() {}

    /**
     * Setter
     *
     * <p>See {@link VerificationReport#getId()} getter
     *
     * @param id See getter
     * @return Current builder
     * @since 1.0
     */
    public B setId(VerificationId id) {
      this.id = id;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationReport#getStatus()} getter
     *
     * @param status See getter
     * @return Current builder
     * @since 1.0
     */
    public B setStatus(VerificationReportStatusType status) {
      this.status = status;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationReport#getReason()} getter
     *
     * @param reason See getter
     * @return Current builder
     * @since 1.0
     */
    public B setReason(VerificationReportReasonType reason) {
      this.reason = reason;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationReport#getReference()} getter
     *
     * @param reference See getter
     * @return Current builder
     * @since 1.0
     */
    public B setReference(VerificationReference reference) {
      this.reference = reference;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReport build() {
      return new VerificationReport(id, status, reason, reference);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
