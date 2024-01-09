package com.sinch.sdk.models;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E164PhoneNumber {

  // See https://community.sinch.com/t5/Glossary/E-164/ta-p/7537
  private static final Pattern PATTERN =
      // adapted from https://stackoverflow.com/a/40347281
      Pattern.compile(
          String.format(
              "%s%s%s%s",
              // prefix
              "^\\+",
              // 1 to 3 digits: Country code (with or without parentheses) / Do not accept '0' as
              // 1st digit
              // https://en.wikipedia.org/wiki/List_of_country_calling_codes
              "(([\\\\(][1-9][0-9]{0,2}[\\\\)])|([1-9][0-9]{0,2}))",
              // Minimum of 5 digits (for fixed line phones in Solomon Islands)
              "\\d\\d\\d\\d\\d",
              // ending with digits
              "\\d*$"));

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
    // don't worry about spaces
    Matcher matcher = PATTERN.matcher(value.replaceAll("\\s+", ""));
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
