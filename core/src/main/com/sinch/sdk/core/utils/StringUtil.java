package com.sinch.sdk.core.utils;

/** Utility class for string */
public class StringUtil {

  private StringUtil() {}

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

  /**
   * Checks that the specified object reference is not {@code null} not an empty string. This method
   * is designed primarily for doing parameter validation in methods and constructors
   *
   * @param obj the object reference to check for nullity
   * @param message detail message to be used in the event that a {@code IllegalArgumentException}
   *     is thrown
   * @return {@code obj} if not {@code null} nor empty
   * @throws IllegalArgumentException if {@code obj} is {@code null} or {@code empty}
   */
  public static String requireNonEmpty(String obj, String message) {
    if (isEmpty(obj)) {
      throw new IllegalArgumentException(message);
    }
    return obj;
  }
}
