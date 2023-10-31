package com.sinch.sdk.core.http;

import java.util.Collection;

public class HttpContentType {

  public static final String CONTENT_TYPE_HEADER = "content-type";
  public static final String APPLICATION_JSON = "application/json";
  public static final String TEXT_PLAIN = "text/plain";

  public static boolean isMimeJson(Collection<String> mimes) {
    String jsonMime = "(?i)^(" + APPLICATION_JSON + "|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mimes.stream()
        .anyMatch(mime -> mime != null && (mime.matches(jsonMime) || mime.equals("*/*")));
  }

  public static boolean isMimeTextPlain(Collection<String> mimes) {
    return mimes.stream().anyMatch(TEXT_PLAIN::equalsIgnoreCase);
  }
}
