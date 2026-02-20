package com.sinch.sdk.core.http;

import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.mockito.ArgumentMatcher;
import org.skyscreamer.jsonassert.JSONAssert;

public class HttpRequestTest {

  public static class HttpRequestMatcher implements ArgumentMatcher<HttpRequest> {

    private final HttpRequest left;

    public HttpRequestMatcher(HttpRequest left) {
      this.left = left;
    }

    @Override
    public boolean matches(HttpRequest right) {
      try {
        if (null != right.getContentType()
            && right.getContentType().contains(HttpContentType.APPLICATION_JSON)) {
          // ignoring JSON payload differences in formatting (if field order differs, etc)
          // we are doing this to simplify writing input test condition about JSON payload and order
          // of fields within it
          TestHelpers.recursiveEquals(right, left, "body");
          // now check the body specifically as JSON string and do not take fields order into
          // account
          JSONAssert.assertEquals(right.getBody(), left.getBody(), true);
        } else {
          TestHelpers.recursiveEquals(right, left);
        }
      } catch (AssertionError | JSONException e) {
        return false;
      }
      return true;
    }
  }
}
