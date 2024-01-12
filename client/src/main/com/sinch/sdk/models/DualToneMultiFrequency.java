package com.sinch.sdk.models;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
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

  private static final Logger LOGGER = Logger.getLogger(DualToneMultiFrequency.class.getName());
  private static final Pattern PATTERN = Pattern.compile("([0-9#w])*");
  private static final AtomicBoolean STRICT = new AtomicBoolean(true);
  private final String dtfm;

  /**
   * Create an instance of DualToneMultiFrequency
   *
   * @param dtfm The dtfm value. Valid characters in the string are "0"-"9", "#" and "w"
   * @throws IllegalArgumentException Throw an exception if value contains invalid characters
   */
  public DualToneMultiFrequency(String dtfm) throws IllegalArgumentException {

    if (!validate(dtfm)) {
      String message = String.format("Invalid DTFM format for '%s' number", dtfm);

      if (STRICT.get()) {
        throw new IllegalArgumentException(message);
      }
      LOGGER.warning(message);
    }
    this.dtfm = dtfm;
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
   * @param strict Set strict mode to true/false
   */
  public static void setStrict(boolean strict) {
    DualToneMultiFrequency.STRICT.set(strict);
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

  /**
   * Get the DTFM value
   *
   * @return The dtfm value
   */
  public String stringValue() {
    return dtfm;
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
