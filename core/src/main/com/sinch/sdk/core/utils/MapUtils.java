package com.sinch.sdk.core.utils;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MapUtils {

  /**
   * @param headers Map to be transformed
   * @return A cloned map with case-insensitive comparator when looking for key value
   */
  public static <T> Map<String, T> getCaseInsensitiveMap(Map<String, T> headers) {

    // convert header keys to use case-insensitive map keys
    Map<String, T> caseInsensitiveHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    // ensure no null key value
    headers.entrySet().removeIf(entry -> Objects.isNull(entry.getKey()));
    caseInsensitiveHeaders.putAll(headers);
    return caseInsensitiveHeaders;
  }
}
