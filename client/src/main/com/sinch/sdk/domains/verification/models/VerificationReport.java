package com.sinch.sdk.domains.verification.models;

/**
 * Common class to all verification report responses
 *
 * @since 1.0
 */
public class VerificationReport {

  private final VerificationId id;
  private final VerificationStatusType status;

  protected VerificationReport(VerificationId id, VerificationStatusType status) {
    this.id = id;
    this.status = status;
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
  public VerificationStatusType getStatus() {
    return status;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationStatus{" + "id='" + id + '\'' + ", status=" + status + '}';
  }

  public static Builder<?> builder() {
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
    VerificationStatusType status;

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
    public B setStatus(VerificationStatusType status) {
      this.status = status;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationReport build() {
      return new VerificationReport(id, status);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
