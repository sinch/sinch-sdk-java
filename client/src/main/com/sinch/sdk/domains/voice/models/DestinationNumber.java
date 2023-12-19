package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Objects;

/** Destination of numbers type */
public class DestinationNumber extends Destination {

  private final E164PhoneNumber phoneNumber;
  private final DestinationNumberType type;

  /**
   * Create a destination instance of type PSTN
   *
   * @param phoneNumber Valid E164 phone number
   */
  public DestinationNumber(E164PhoneNumber phoneNumber) {
    this(phoneNumber, DestinationNumberType.PSTN);
  }

  /**
   * Create a destination instance of specified type
   *
   * @param phoneNumber Valid E164 phone number
   * @param type Phone number type
   */
  public DestinationNumber(E164PhoneNumber phoneNumber, DestinationNumberType type) {
    Objects.requireNonNull(phoneNumber);
    this.phoneNumber = phoneNumber;
    this.type = type;
  }

  public E164PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public DestinationNumberType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "DestinationNumber{"
        + "phoneNumber="
        + phoneNumber
        + ", type="
        + type
        + "} "
        + super.toString();
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
    return Objects.equals(phoneNumber, that.phoneNumber) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneNumber, type);
  }
}
