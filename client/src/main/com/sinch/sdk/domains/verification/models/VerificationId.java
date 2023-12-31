package com.sinch.sdk.domains.verification.models;

public class VerificationId {

  public final String id;

  public VerificationId(String id) {
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
