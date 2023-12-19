package com.sinch.sdk.domains.voice.models;

import java.util.Objects;

/** Destination of type SIP */
public class DestinationSip extends Destination {
  private final String sipAddress;

  public DestinationSip(String sipAddress) {
    Objects.requireNonNull(sipAddress);
    this.sipAddress = sipAddress;
  }

  public String getSIPAddress() {
    return sipAddress;
  }

  @Override
  public String toString() {
    return "DestinationSip{" + "sipAddress='" + sipAddress + '\'' + "} " + super.toString();
  }

  public static DestinationSip valueOf(String sipAddress) {
    return new DestinationSip(sipAddress);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationSip that = (DestinationSip) o;
    return Objects.equals(sipAddress, that.sipAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sipAddress);
  }
}
