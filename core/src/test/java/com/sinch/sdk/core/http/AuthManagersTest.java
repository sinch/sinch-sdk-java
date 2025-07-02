package com.sinch.sdk.core.http;

import com.sinch.sdk.core.TestHelpers;
import java.util.Map;
import org.mockito.ArgumentMatcher;

public class AuthManagersTest {

  public static class AuthManagersMatcher implements ArgumentMatcher<Map<String, AuthManager>> {

    private final Map<String, AuthManager> left;

    public AuthManagersMatcher(Map<String, AuthManager> left) {
      this.left = left;
    }

    @Override
    public boolean matches(Map<String, AuthManager> right) {
      try {
        TestHelpers.recursiveEquals(right, left);
      } catch (AssertionError e) {
        return false;
      }
      return true;
    }
  }
}
