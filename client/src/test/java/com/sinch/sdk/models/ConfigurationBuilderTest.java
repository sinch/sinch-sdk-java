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
    Configuration builder =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .setNumbersContext(NumbersContext.builder().setNumbersUrl(NUMBERS_SERVER).build())
            .setSmsContext(
                SmsContext.builder().setSmsRegion(SMS_REGION).setSmsUrl(SMS_SERVER).build())
            .build();
    assertEquals(KEY, builder.getKeyId());
    assertEquals(SECRET, builder.getKeySecret());
    assertEquals(PROJECT, builder.getProjectId());
    Assertions.assertEquals(OAUTH_URL, builder.getOAuthServer().getUrl());
    Assertions.assertEquals(
        NUMBERS_SERVER, builder.getNumbersContext().get().getNumbersServer().getUrl());
    Assertions.assertTrue(
        builder.getSmsContext().get().getSmsRegion().toString().contains(SMS_REGION.value()),
        "SMS Region present within SMS server URL");
    Assertions.assertTrue(
        builder.getSmsContext().get().getSmsServer().getUrl().contains("fooSMS_SERVER"),
        "SMS server present within SMS server URL");
  }
}
