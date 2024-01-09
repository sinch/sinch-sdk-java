package com.sinch.sdk.domains.voice.models;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationUser that = (DestinationUser) o;
    return Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }
}
