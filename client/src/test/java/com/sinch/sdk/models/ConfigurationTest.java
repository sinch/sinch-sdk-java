package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfigurationTest {
  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";
  static final String APPLICATION_KEY = "fooApplicationKey";
  static final String APPLICATION_SECRET = "fooApplicationSecret";

  static final String OAUTH_URL = "foo oauth url";
  static final String NUMBERS_SERVER = "fooNUMBERS_SERVER";
  static final SMSRegion SMS_REGION = SMSRegion.AU;
  static final String SMS_SERVER = "%sfooSMS_SERVER";

  static final Configuration configuration =
      new Configuration.Builder()
          .setKeyId(KEY)
          .setKeySecret(SECRET)
          .setProjectId(PROJECT)
          .setOAuthUrl(OAUTH_URL)
          .setNumbersUrl(NUMBERS_SERVER)
          .setSmsRegion(SMS_REGION)
          .setSmsUrl(SMS_SERVER)
          .setApplicationKey(APPLICATION_KEY)
          .setApplicationSecret(APPLICATION_SECRET)
          .build();

  @Test
  void testToString() {
    String value = configuration.toString();
    assertFalse(value.contains(KEY), "Config should not contains 'key' value");
    assertFalse(value.contains(SECRET), "Config should not contains 'secret' value");
    assertFalse(value.contains(PROJECT), "Config should not contains 'project' value");
    assertFalse(
        value.contains(APPLICATION_KEY), "Config should not contains 'application key' value");
    assertFalse(
        value.contains(APPLICATION_SECRET),
        "Config should not contains 'application secret' value");
  }

  @Test
  void getKeyId() {
    assertEquals(KEY, configuration.getKeyId());
  }

  @Test
  void getKeySecret() {
    assertEquals(SECRET, configuration.getKeySecret());
  }

  @Test
  void getProjectId() {
    assertEquals(PROJECT, configuration.getProjectId());
  }

  @Test
  void defaultUSForSmSRegion() {
    Configuration configuration =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .setNumbersUrl(NUMBERS_SERVER)
            .setSmsUrl(SMS_SERVER)
            .build();
    assertEquals(configuration.getSmsRegion(), SMSRegion.US);
  }
}
