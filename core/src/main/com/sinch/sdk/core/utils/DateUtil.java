package com.sinch.sdk.core.utils;

import java.time.Instant;
import java.time.OffsetDateTime;

/** Utility class for Date */
public class DateUtil {

  private DateUtil() {}
  ;

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
}
