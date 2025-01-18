package com.sinch.sdk.core.models;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

public class ServerConfigurationTest {

  @Test
  void getUrl() {
    String URL = "my url";
    ServerConfiguration configuration = new ServerConfiguration(URL);
    assertEquals(URL, configuration.getUrl());
  }

  public static class ServerConfigurationMatcher implements ArgumentMatcher<ServerConfiguration> {

    private final ServerConfiguration left;

    public ServerConfigurationMatcher(ServerConfiguration left) {
      this.left = left;
    }

    @Override
    public boolean matches(ServerConfiguration right) {
      try {
        TestHelpers.recursiveEquals(right, left);
      } catch (AssertionError e) {
        return false;
      }
      return true;
    }
  }
}
