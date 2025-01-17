package com.sinch.sdk.core.http;

import com.sinch.sdk.core.TestHelpers;
import org.mockito.ArgumentMatcher;

public class HttpRequestTest {

  public static class HttpRequestMatcher implements ArgumentMatcher<HttpRequest> {

    private final HttpRequest left;

    public HttpRequestMatcher(HttpRequest left) {
      this.left = left;
    }

    @Override
    public boolean matches(HttpRequest right) {
      try {
        TestHelpers.recursiveEquals(right, left);
      } catch (AssertionError e) {
        return false;
      }
      return true;
    }
  }
}
