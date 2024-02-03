package com.sinch.sdk.domains.verification.models;

public class VerificationId {

  private final String id;

  private VerificationId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "VerificationId{" + "id='" + id + '\'' + '}';
  }

  public String getId() {
    return id;
  }

  public static VerificationId valueOf(String id) {
    return new VerificationId(id);
  }
}
