package com.sinch.sdk.domains.voice.models.requests;

import java.util.Objects;

/** Destination of type username for data endpoints. */
public class DestinationUser extends Destination {
  private final String userName;

  public DestinationUser(String userName) {
    Objects.requireNonNull(userName);
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  @Override
  public String toString() {
    return "DestinationUser{" + "userName='" + userName + '\'' + "} " + super.toString();
  }

  public static DestinationUser valueOf(String user) {
    return new DestinationUser(user);
  }
}
