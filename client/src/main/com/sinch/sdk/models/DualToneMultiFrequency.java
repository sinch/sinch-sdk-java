package com.sinch.sdk.models;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * DTMF played to the callee.
 *
 * <p>Valid characters in the string are "0"-"9", "#" and "w". A "w" will render a 500 ms pause.
 *
 * <p>Example: "ww1234#w#" will render a 1s pause, the DTMF tones "1", "2", "3", "4" and "#"
 * followed by a 0.5s pause and finally the DTMF tone for "#".
 *
 * <p>This can be used if the callout destination for instance require a conference PIN code or an
 * extension to be entered.
 */
public class DualToneMultiFrequency {

  private static final Pattern PATTERN = Pattern.compile("([0-9#w])*");
  private final String dtfm;

  private static boolean relax = false;

  /**
   * Create an instance of DualToneMultiFrequency
   *
   * @param dtfm The dtfm value. Valid characters in the string are "0"-"9", "#" and "w"
   * @throws IllegalArgumentException Throw an exception if value contains invalid characters
   */
  public DualToneMultiFrequency(String dtfm) throws IllegalArgumentException {

    if (!relax && !validate(dtfm)) {
      throw new IllegalArgumentException(
          String.format("Invalid DTFM format for '%s' number", dtfm));
    }
    this.dtfm = dtfm;
  }

  /**
   * Get the DTFM value
   *
   * @return The dtfm value
   */
  public String stringValue() {
    return dtfm;
  }

  /**
   * Create an instance from String
   *
   * @param value See {@link DualToneMultiFrequency(String)} constructor
   * @return a DualToneMultiFrequency
   */
  public static DualToneMultiFrequency valueOf(String value) {
    return new DualToneMultiFrequency(value);
  }

  /**
   * Configure if invalid string values will throw an Exception or not
   *
   * @param relax Set relax mode to true/false
   */
  public static void setRelax(boolean relax) {
    DualToneMultiFrequency.relax = relax;
  }

  /**
   * Validate string against authorized values for DTFM value
   *
   * @param value The value to be validated
   * @return Is string valid or not
   */
  public static boolean validate(String value) {
    return PATTERN.matcher(value).matches();
  }

  @Override
  public String toString() {
    return "DualToneMultiFrequency{" + "dtfm='" + dtfm + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DualToneMultiFrequency that = (DualToneMultiFrequency) o;
    return Objects.equals(dtfm, that.dtfm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtfm);
  }
}
