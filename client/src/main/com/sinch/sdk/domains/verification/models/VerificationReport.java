package com.sinch.sdk.domains.verification.models;

/** Comme class to all verification report responses */
public class VerificationReport {

  private final String id;
  private final VerificationReportStatusType status;
  private final VerificationReportReasonType reason;
  private final String reference;

  public VerificationReport(
      String id,
      VerificationReportStatusType status,
      VerificationReportReasonType reason,
      String reference) {
    this.id = id;
    this.status = status;
    this.reason = reason;
    this.reference = reference;
  }

  public String getId() {
    return id;
  }

  public VerificationReportStatusType getStatus() {
    return status;
  }

  public VerificationReportReasonType getReason() {
    return reason;
  }

  public String getReference() {
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

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    String id;
    VerificationReportStatusType status;
    VerificationReportReasonType reason;
    String reference;

    public B setId(String id) {
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

    public B setReference(String reference) {
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
