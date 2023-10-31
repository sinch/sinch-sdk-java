package com.sinch.sdk.core.utils;

/** Utility class for string */
public class StringUtil {

  /**
   * Check if a string is empty
   *
   * @param value String to be cheked
   * @return true if String is null, empty or contains only spaces characters
   * @since 1.0
   */
  public static boolean isEmpty(String value) {
    return (null == value || value.trim().isEmpty());
  }
}
