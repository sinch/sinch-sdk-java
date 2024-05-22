package com.sinch.sdk.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

/** Utility class for Date */
public class DateUtil {

  private DateUtil() {}

  /**
   * Convert an OffsetDateTime to Instant with null value protection
   *
   * @param value Value to be converted
   * @return Converted value to Instant or null if source value was null
   * @since 1.0
   */
  public static Instant toInstant(OffsetDateTime value) {
    return (null == value ? null : value.toInstant());
  }

  /**
   * Convert String to Instant
   *
   * <p>Consume a date time in form of
   *
   * <ul>
   *   <li>ISO8601 with TZ
   *   <li>YYYY-MM-DDThh:mm:ss.SSS without timezone
   *   <li>YYYY-MM-DDThh:mm:ss.SSSZ with timezone
   * </ul>
   *
   * When timezone is not known, UTC is assumed
   *
   * @param value A nearly IS08601 compliant string
   * @return Extracted Instant value
   */
  public static Instant failSafeTimeStampToInstant(String value) {

    if (null == value) {
      return null;
    }

    Instant timestamp;
    try {
      timestamp = Instant.parse(value);
    } catch (DateTimeParseException e) {
      try {
        timestamp = OffsetDateTime.parse(value).toInstant();
      } catch (DateTimeParseException dte) {
        timestamp = LocalDateTime.parse(value).toInstant(ZoneOffset.UTC);
      }
    }
    return timestamp;
  }
}
