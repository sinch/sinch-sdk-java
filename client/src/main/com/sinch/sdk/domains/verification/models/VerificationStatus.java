package com.sinch.sdk.domains.verification.models;

import java.time.Instant;

/**
 * Common class to all verification status responses
 *
 * @since 1.0
 */
public class VerificationStatus {

  private final VerificationId id;
  private final VerificationStatusType status;
  private final VerificationStatusReasonType reason;
  private final VerificationReference reference;
  private final Identity identity;
  private final String countryId;
  private final Instant verificationTimeStamp;

  protected VerificationStatus(
      VerificationId id,
      VerificationStatusType status,
      VerificationStatusReasonType reason,
      VerificationReference reference,
      Identity identity,
      String countryId,
      Instant verificationTimeStamp) {
    this.id = id;
    this.status = status;
    this.reason = reason;
    this.reference = reference;
    this.identity = identity;
    this.countryId = countryId;
    this.verificationTimeStamp = verificationTimeStamp;
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

  /**
   * The reason why a verification has {@link VerificationStatusType#FAIL FAIL}, was {@link
   * VerificationStatusType#DENIED DENIED}, or was {@link VerificationStatusType#ABORTED ABORTED}.
   *
   * @return The reason value
   * @since 1.0
   */
  public VerificationStatusReasonType getReason() {
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

  /**
   * @see Identity
   * @return The identity
   */
  public Identity getIdentity() {
    return identity;
  }

  /**
   * The ID of the country to which the verification was sent
   *
   * @return Country ID value
   */
  public String getCountryId() {
    return countryId;
  }

  /**
   * Verification time stamp
   *
   * @return Verification timestamp value
   */
  public Instant getVerificationTimeStamp() {
    return verificationTimeStamp;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationStatus{"
        + "id="
        + id
        + ", status="
        + status
        + ", reason="
        + reason
        + ", reference="
        + reference
        + ", identity="
        + identity
        + ", countryId='"
        + countryId
        + '\''
        + ", verificationTimeStamp="
        + verificationTimeStamp
        + '}';
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
    VerificationStatusReasonType reason;
    VerificationReference reference;
    Identity identity;
    String countryId;
    Instant verificationTimeStamp;

    protected Builder() {}

    /**
     * Setter
     *
     * <p>See {@link VerificationStatus#getId()} getter
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
     * <p>See {@link VerificationStatus#getStatus()} getter
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
     * Setter
     *
     * <p>See {@link VerificationStatus#getReason()} getter
     *
     * @param reason See getter
     * @return Current builder
     * @since 1.0
     */
    public B setReason(VerificationStatusReasonType reason) {
      this.reason = reason;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationStatus#getReference()} getter
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
     * Setter
     *
     * <p>See {@link VerificationStatus#getIdentity()} ()} getter
     *
     * @param identity See getter
     * @return Current builder
     * @since 1.0
     */
    public B setIdentity(Identity identity) {
      this.identity = identity;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationStatus#getCountryId()} ()} getter
     *
     * @param countryId See getter
     * @return Current builder
     * @since 1.0
     */
    public B setCountryId(String countryId) {
      this.countryId = countryId;
      return self();
    }

    /**
     * Setter
     *
     * <p>See {@link VerificationStatus#getVerificationTimeStamp()} ()} ()} getter
     *
     * @param verificationTimeStamp See getter
     * @return Current builder
     * @since 1.0
     */
    public B setVerificationTimeStamp(Instant verificationTimeStamp) {
      this.verificationTimeStamp = verificationTimeStamp;
      return self();
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationStatus build() {
      return new VerificationStatus(
          id, status, reason, reference, identity, countryId, verificationTimeStamp);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
