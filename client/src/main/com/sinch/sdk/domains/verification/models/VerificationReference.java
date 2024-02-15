package com.sinch.sdk.domains.verification.models;

/** Verification reference related to a Verification request */
public class VerificationReference {

  private final String reference;

  private VerificationReference(String reference) {
    this.reference = reference;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationReference{" + "reference='" + reference + '\'' + '}';
  }

  /**
   * Get the verification reference value
   *
   * @return reference Value
   * @since 1.0
   */
  public String getReference() {
    return reference;
  }

  /**
   * Create a new verification reference from a String
   *
   * @param reference The id value
   * @return The newly created VerificationReference instance
   * @since 1.0
   */
  public static VerificationReference valueOf(String reference) {
    return new VerificationReference(reference);
  }
}
