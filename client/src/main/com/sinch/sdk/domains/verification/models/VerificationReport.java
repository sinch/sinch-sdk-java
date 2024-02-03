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

  public VerificationId getId() {
    return id;
  }

  public VerificationReportStatusType getStatus() {
    return status;
  }

  public VerificationReportReasonType getReason() {
    return reason;
  }

  public VerificationReference getReference() {
    return reference;
  }

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

  public static class Builder<B extends Builder<B>> {

    VerificationId id;
    VerificationReportStatusType status;
    VerificationReportReasonType reason;
    VerificationReference reference;

    public B setId(VerificationId id) {
      this.id = id;
      return self();
    }

    public B setStatus(VerificationReportStatusType status) {
      this.status = status;
      return self();
    }

    public B setReason(VerificationReportReasonType reason) {
      this.reason = reason;
      return self();
    }

    public B setReference(VerificationReference reference) {
      this.reference = reference;
      return self();
    }

    public VerificationReport build() {
      return new VerificationReport(id, status, reason, reference);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
