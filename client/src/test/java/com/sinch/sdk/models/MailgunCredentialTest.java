package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class MailgunCredentialTest {

  static final String API_KEY = "fooKey";

  static final MailgunCredentials credentials =
      MailgunCredentials.builder().setApiKey(API_KEY).build();

  @Test
  void testToString() {
    String value = credentials.toString();
    assertFalse(value.contains(API_KEY), "Credentials should not contains 'key' value");
  }

  @Test
  void getApiUser() {
    assertEquals("api", credentials.getApiUser());
  }

  @Test
  void getKeyId() {
    assertEquals(API_KEY, credentials.getApiKey());
  }
}
