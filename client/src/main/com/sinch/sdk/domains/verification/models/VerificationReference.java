package com.sinch.sdk.domains.verification.models;

public class VerificationReference {

  public final String reference;

  public VerificationReference(String reference) {
    this.reference = reference;
  }

  @Override
  public String toString() {
    return "VerificationReference{" + "reference='" + reference + '\'' + '}';
  }

  public String getReference() {
    return reference;
  }

  public static VerificationReference valueOf(String reference) {
    return new VerificationReference(reference);
  }
}
