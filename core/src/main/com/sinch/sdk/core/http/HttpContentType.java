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
  public static final String MULTIPART_FORM_DATA = "multipart/form-data";
  static Pattern charsetPattern = Pattern.compile("(.*;$)?\\s*?charset=\\s*([^;\\s]+)");

  public static boolean isMimeJson(Collection<String> mimes) {
    String jsonMime = "(?i)^(" + APPLICATION_JSON + "|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mimes.stream()
        .anyMatch(mime -> mime != null && (mime.matches(jsonMime) || mime.equals("*/*")));
  }

  public static boolean isMimeTextPlain(Collection<String> mimes) {
    return mimes.stream().anyMatch(TEXT_PLAIN::equalsIgnoreCase);
  }

  public static boolean isMimeMultiPartFormData(Collection<String> mimes) {
    return null != mimes && mimes.stream().anyMatch(MULTIPART_FORM_DATA::equalsIgnoreCase);
  }

  public static Optional<String> getCharsetValue(String contentTypeHeader) {
    if (StringUtil.isEmpty(contentTypeHeader)) {
      return Optional.empty();
    }

    Matcher m = charsetPattern.matcher(contentTypeHeader);
    if (!m.find()) {
      return Optional.empty();
    }
    return Optional.of(m.group(2));
  }
}
