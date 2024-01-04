package com.sinch.sdk.models;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E164PhoneNumber {

  private static final Pattern pattern = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");

  private final String number;

  public E164PhoneNumber(String number) {

    if (!validate(number)) {
      throw new NumberFormatException(String.format("Invalid E164 format for '%s' number", number));
    }
    this.number = number;
  }

  public String stringValue() {
    return number;
  }

  public static E164PhoneNumber valueOf(String value) {
    return new E164PhoneNumber(value);
  }

  public static boolean validate(String value) {
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
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
