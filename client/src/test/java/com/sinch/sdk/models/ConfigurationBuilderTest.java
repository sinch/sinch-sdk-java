package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigurationBuilderTest {
  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";
  static final String OAUTH_URL = "foo oauth url";
  static final String NUMBERS_SERVER = "fooNUMBERS_SERVER";
  static final SMSRegion SMS_REGION = SMSRegion.AU;
  static final String SMS_SERVER = "%sfooSMS_SERVER";

  @Test
  void build() {
    Configuration value =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .setNumbersUrl(NUMBERS_SERVER)
            .setSmsRegion(SMS_REGION)
            .setSmsUrl(SMS_SERVER)
            .build();
    assertEquals(KEY, value.getKeyId());
    assertEquals(SECRET, value.getKeySecret());
    assertEquals(PROJECT, value.getProjectId());
    Assertions.assertEquals(OAUTH_URL, value.getOAuthServer().getUrl());
    Assertions.assertEquals(NUMBERS_SERVER, value.getNumbersServer().getUrl());
    Assertions.assertTrue(
        value.getSmsServer().getUrl().contains(SMS_REGION.value()),
        "SMS Region present within SMS server URL");
    Assertions.assertTrue(
        value.getSmsServer().getUrl().contains("fooSMS_SERVER"),
        "SMS server present within SMS server URL");
  }
}
