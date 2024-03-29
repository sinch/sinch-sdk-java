package com.sinch.sdk.domains.verification.models;

/** Verification ID related to a Verification request */
public class VerificationId {

  private final String id;

  private VerificationId(String id) {
    this.id = id;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "VerificationId{" + "id='" + id + '\'' + '}';
  }

  /**
   * Get the verification Id value
   *
   * @return Id Value
   * @since 1.0
   */
  public String getId() {
    return id;
  }

  /**
   * Create a new verification id from a String
   *
   * @param id The id value
   * @return The newly created VerificationId instance
   * @since 1.0
   */
  public static VerificationId valueOf(String id) {
    return new VerificationId(id);
  }
}
