package com.sinch.sdk.core.http;

import com.sinch.sdk.core.utils.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;

public class URLPathUtils {

  public static String encodePathSegment(String segment) {

    if (StringUtil.isEmpty(segment)) {
      return "";
    }
    String pathSegment;
    try {
      URI uri = new URI("https", "f", "/" + segment, null);
      // remove the first 10 characters from the generated URL to only keep encoded path part
      // - protocol ("https://"): 8 characters
      // - domain name ("f"): 1 character
      // - path ("/"): 1 character
      pathSegment = uri.toASCIIString().substring(10);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    // URI is considering '/' as a separator but here this function is to convert a
    // single path element: then a '/' mean it is part of the string to be encoded but not the
    // hierarchical separator
    return pathSegment.replaceAll("/", "%2F");
  }
}
