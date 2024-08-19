package com.sinch.sdk.core.http;

import com.sinch.sdk.core.utils.StringUtil;
import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpContentType {

  public static final String CONTENT_TYPE_HEADER = "content-type";
  public static final String APPLICATION_JSON = "application/json";
  public static final String TEXT_PLAIN = "text/plain";

  static Pattern charsetPattern = Pattern.compile("(.*;$)?\\s*?charset=(.*)");

  public static boolean isMimeJson(Collection<String> mimes) {
    String jsonMime = "(?i)^(" + APPLICATION_JSON + "|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mimes.stream()
        .anyMatch(mime -> mime != null && (mime.matches(jsonMime) || mime.equals("*/*")));
  }

  public static boolean isMimeTextPlain(Collection<String> mimes) {
    return mimes.stream().anyMatch(TEXT_PLAIN::equalsIgnoreCase);
  }

  public static Optional<String> getCharsetValue(String contentTypeHeader) {
    if (StringUtil.isEmpty(contentTypeHeader)) {
      return Optional.empty();
    }

    Matcher m = charsetPattern.matcher(contentTypeHeader);
    if (!m.find()) {
      return Optional.empty();
    }
    String group = m.group(2);
    if (group.contains(";")) {
      return Optional.of(group.substring(0, group.indexOf(";")));
    }
    return Optional.of(group);
  }
}
