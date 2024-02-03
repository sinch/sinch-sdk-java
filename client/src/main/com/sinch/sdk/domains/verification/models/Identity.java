package com.sinch.sdk.domains.verification.models;

/** Base class for Identity objects */
public abstract class Identity {

  private final String type;

  /**
   * Create an instance of identity with type
   *
   * @param type Identity type
   */
  protected Identity(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Identity{" + "type='" + type + '\'' + '}';
  }
}
