package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class UnifiedCredentialTest {
  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";

  static final UnifiedCredentials credentials =
      UnifiedCredentials.builder().setKeyId(KEY).setKeySecret(SECRET).setProjectId(PROJECT).build();

  @Test
  void testToString() {
    String value = credentials.toString();
    assertFalse(value.contains(KEY), "Credentials should not contains 'key' value");
    assertFalse(value.contains(SECRET), "Credentials should not contains 'secret' value");
    assertFalse(value.contains(PROJECT), "Credentials should not contains 'project' value");
  }

  @Test
  void getKeyId() {
    assertEquals(KEY, credentials.getKeyId());
  }

  @Test
  void getKeySecret() {
    assertEquals(SECRET, credentials.getKeySecret());
  }

  @Test
  void getProjectId() {
    assertEquals(PROJECT, credentials.getProjectId());
  }
}
