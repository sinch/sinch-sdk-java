package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;

/** Destination of type number for PSTN endpoints */
public class DestinationNumber extends Destination {
  private final E164PhoneNumber phoneNumber;

  public DestinationNumber(E164PhoneNumber phoneNumber) {
    Objects.requireNonNull(phoneNumber);
    this.phoneNumber = phoneNumber;
  }

  public E164PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "DestinationNumber{" + "phoneNumber=" + phoneNumber + "} " + super.toString();
  }

  public static DestinationNumber valueOf(String e164PhoneNumber) {
    return new DestinationNumber(E164PhoneNumber.valueOf(e164PhoneNumber));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationNumber that = (DestinationNumber) o;
    return Objects.equals(phoneNumber, that.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber);
  }
}
