package com.sinch.sdk.models;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** E164 Phone Number representation class helper */
public class E164PhoneNumber {

  private static final Logger LOGGER = Logger.getLogger(E164PhoneNumber.class.getName());
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
  private static final AtomicBoolean STRICT = new AtomicBoolean(false);
  private final String number;

  /**
   * Create a new instance
   *
   * @param number Phone number value
   */
  private E164PhoneNumber(String number) {

    if (!validate(number)) {
      String message = String.format("Invalid E164 format for '%s' number", number);
      if (STRICT.get()) {
        throw new NumberFormatException(message);
      }
      LOGGER.finest(message);
    }
    this.number = number;
  }

  /**
   * Create a new instance
   *
   * @param value Phone number value
   * @return The newly created E164 instance
   */
  public static E164PhoneNumber valueOf(String value) {
    return new E164PhoneNumber(value);
  }

  /**
   * Validate value against E164 representation pattern,
   *
   * @param value String value representation to be checked
   * @return TRUE/FALSE
   */
  public static boolean validate(String value) {
    if (null == value) {
      return false;
    }
    // don't worry about spaces
    Matcher matcher = PATTERN.matcher(value.replaceAll("\\s+", ""));
    return matcher.matches();
  }

  /**
   * Configure if invalid string values will throw an Exception or not
   *
   * @param strict Set strict mode to true/false
   */
  public static void setStrict(boolean strict) {
    E164PhoneNumber.STRICT.set(strict);
  }

  /**
   * Get current value as a String
   *
   * @return The value
   */
  public String stringValue() {
    return number;
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
