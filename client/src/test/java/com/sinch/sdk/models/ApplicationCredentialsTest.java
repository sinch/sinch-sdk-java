package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ApplicationCredentialsTest {
  static final String APPLICATION_KEY = "fooApplicationKey";
  static final String APPLICATION_SECRET = "fooApplicationSecret";

  static final ApplicationCredentials credentials =
      ApplicationCredentials.builder()
          .setApplicationKey(APPLICATION_KEY)
          .setApplicationSecret(APPLICATION_SECRET)
          .build();

  @Test
  void testToString() {
    String value = credentials.toString();
    assertFalse(
        value.contains(APPLICATION_KEY), "Config should not contains 'application key' value");
    assertFalse(
        value.contains(APPLICATION_SECRET),
        "Config should not contains 'application secret' value");
  }

  @Test
  void getApplicationKey() {
    assertEquals(APPLICATION_KEY, credentials.getApplicationKey());
  }

  @Test
  void getApplicationSecret() {
    assertEquals(APPLICATION_SECRET, credentials.getApplicationSecret());
  }
}
