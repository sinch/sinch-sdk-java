package com.sinch.sdk.domains.verification.models;

/** Base class for Identity based objects */
public abstract class Identity {

  public final String type;

  public Identity(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Identity{" + "type='" + type + '\'' + '}';
  }

  public String getType() {
    return type;
  }
}
