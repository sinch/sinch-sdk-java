package com.sinch.sdk.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

/** Utility class for Date */
public class DateUtil {

  private static final DateTimeFormatter RFC822_ZONED_FORMAT =
      DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss z");

  private static final DateTimeFormatter RFC822_GMT_FORMAT =
      DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss").withZone(ZoneId.of("GMT"));

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

    String trimmed = null == value ? "" : value.trim();

    if (trimmed.isEmpty()) {
      return null;
    }

    Instant parsed = parseISO8601(trimmed);
    if (null != parsed) {
      return parsed;
    }

    parsed = parseISO8601WithOffset(trimmed);
    if (null != parsed) {
      return parsed;
    }

    // fallback: this is not an ISO8601 compliant format: give a chance and assume it is GMT zone
    parsed = parseISO8601WithoutOffset(trimmed);
    if (null != parsed) {
      return parsed;
    }

    parsed = parseEpochSeconds(trimmed);
    if (null != parsed) {
      return parsed;
    }

    // do not break deserialization: fallback to empty value
    LOGGER.severe(String.format("Unable to parse '%s' date string", value));

    return null;
  }

  private static Instant parseISO8601(String trimmed) {
    try {
      return Instant.parse(trimmed);
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }

  private static Instant parseISO8601WithOffset(String trimmed) {
    try {
      return OffsetDateTime.parse(trimmed).toInstant();
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }

  private static Instant parseISO8601WithoutOffset(String trimmed) {
    try {
      return LocalDateTime.parse(trimmed).toInstant(ZoneOffset.UTC);
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }

  private static Instant parseEpochSeconds(String trimmed) {
    try {
      return Instant.ofEpochSecond(Long.parseLong(trimmed));
    } catch (NumberFormatException _unused) {
      return null;
    }
  }

  /**
   * Convert String to Instant
   *
   * <p>Consume a date time in form of RFC-822 format
   *
   * @param value An RFC-822 compliant string
   * @return Extracted Instant value
   * @since __TO_BE_DEFINED__
   */
  public static Instant RFC822StringToInstant(String value) {

    String trimmed = null == value ? "" : value.trim();

    if (trimmed.isEmpty()) {
      return null;
    }

    Instant parsed = parseRFC822(trimmed);
    if (null != parsed) {
      return parsed;
    }

    parsed = parseRFC822WithZone(trimmed);
    if (null != parsed) {
      return parsed;
    }

    // fallback: this is not an RFC compliant format: give a chance and assume it is GMT zone
    parsed = parseRFC822WithoutZoneNorOffset(trimmed);
    if (null != parsed) {
      return parsed;
    }

    LOGGER.severe(String.format("Unable to parse '%s' date string", value));
    return null;
  }

  private static Instant parseRFC822(String trimmed) {
    try {
      return Instant.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(trimmed));
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }

  private static Instant parseRFC822WithZone(String trimmed) {
    try {
      return ZonedDateTime.parse(trimmed, RFC822_ZONED_FORMAT).toInstant();
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }

  private static Instant parseRFC822WithoutZoneNorOffset(String trimmed) {
    try {
      return ZonedDateTime.parse(trimmed, RFC822_GMT_FORMAT).toInstant();
    } catch (DateTimeParseException _unused) {
      return null;
    }
  }
}
