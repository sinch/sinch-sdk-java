package com.sinch.sdk.models;

import java.util.Objects;

public class E164PhoneNumber {
  private final String number;

  public E164PhoneNumber(String number) {
    this.number = number;
  }

  public String stringValue() {
    return number;
  }

  public static E164PhoneNumber valueOf(String value) {
    return new E164PhoneNumber(value);
  }

  @Override
  public String toString() {
    return "E164PhoneNumber{" + "number='" + number + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    E164PhoneNumber that = (E164PhoneNumber) o;
    return Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
