package com.sinch.sdk.domains.verification.models;

import java.time.Instant;

/**
 * Verification report related to a {@link
 * com.sinch.sdk.domains.verification.VerificationsService#startSms}
 *
 * @since 1.0
 */
public class VerificationStatusSMS extends VerificationStatus {

  private final Price verificationPrice;
  private final VerificationSourceType source;

  private VerificationStatusSMS(
      VerificationId id,
      VerificationStatusType status,
      VerificationStatusReasonType reason,
      VerificationReference reference,
      Identity identity,
      String countryId,
      Instant verificationTimeStamp,
      Price verificationPrice,
      VerificationSourceType source) {
    super(id, status, reason, reference, identity, countryId, verificationTimeStamp);
    this.verificationPrice = verificationPrice;
    this.source = source;
  }

  /**
   * The maximum price charged for this verification process.
   *
   * <p>This property will appear in the body of the response with a delay. It will become visible
   * only when the verification status is other than {@link VerificationStatusType#PENDING PENDING}
   *
   * @return Verification price object
   * @since 1.0
   */
  public Price getVerificationPrice() {
    return verificationPrice;
  }

  /**
   * Used to show if the SMS was intercepted or not
   *
   * @return Source type value
   * @since 1.0
   */
  public VerificationSourceType getSource() {
    return source;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationStatusSMS{"
        + "verificationPrice="
        + verificationPrice
        + ", source='"
        + source
        + '\''
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
  public static class Builder extends VerificationStatus.Builder<Builder> {

    Price verificationPrice;
    VerificationSourceType source;

    private Builder() {}

    /**
     * See {@link VerificationStatusSMS#getVerificationPrice() getter}
     *
     * @param verificationPrice Price object value
     * @return Current builder
     * @since 1.0
     */
    public Builder setVerificationPrice(Price verificationPrice) {
      this.verificationPrice = verificationPrice;
      return this;
    }

    /**
     * See {@link VerificationStatusSMS#getSource() getter}
     *
     * @param source Source to be set
     * @return Current builder
     * @since 1.0
     */
    public Builder setSource(VerificationSourceType source) {
      this.source = source;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationStatusSMS build() {
      return new VerificationStatusSMS(
          id,
          status,
          reason,
          reference,
          identity,
          countryId,
          verificationTimeStamp,
          verificationPrice,
          source);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
