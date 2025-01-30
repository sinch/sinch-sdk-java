package com.sinch.sdk.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

/** Utility class for Date */
public class DateUtil {

  private static final DateTimeFormatter RFC822_ZONED_FORMAT =
      DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss z");

  private static final Logger LOGGER = Logger.getLogger(DateUtil.class.getName());

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
   * @since 1.1
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

  /**
   * Convert String to Instant
   *
   * <p>Consume a date time in form of RFC-822 format
   *
   * @param value A RFC-822 compliant string
   * @return Extracted Instant value
   * @since __TO_BE_DEFINED__
   */
  public static Instant RFC822StringToInstant(String value) {

    if (null == value) {
      return null;
    }

    try {
      return Instant.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(value));
    } catch (DateTimeParseException _unused) {
      try {
        return ZonedDateTime.parse(value, RFC822_ZONED_FORMAT).toInstant();
      } catch (DateTimeParseException e) {
        // do not break deserialization: fallback to empty value
        LOGGER.severe(String.format("Unable to parse '%s' date string: %s", value, e.getMessage()));
        return null;
      }
    }
  }
}
