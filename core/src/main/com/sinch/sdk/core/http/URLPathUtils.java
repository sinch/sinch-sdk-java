package com.sinch.sdk.core.http;

import com.sinch.sdk.core.utils.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;

public class URLPathUtils {

  public static String encodePathSegment(String segment) {

    if (StringUtil.isEmpty(segment)) {
      return "";
    }
    URI uri;
    try {
      uri = new URI("foo", "foo", "/" + segment, null);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    return uri.getRawPath().substring(1);
  }
}
