package com.sinch.sdk.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
  static final ConversationRegion CONVERSATION_REGION = ConversationRegion.EU;
  static final String CONVERSATION_SERVER = "fooCONVERSATION_SERVER";
  static final String CONVERSATION_TEMPLATE_SERVER = "fooCONVERSATION_TEMPLATE_SERVER";
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
    Configuration configuration = new Configuration.Builder().build();
    assertEquals(configuration.getSmsRegion(), SMSRegion.US);
  }

  @Test
  void defaultUSForConversationRegion() {
    Configuration configuration = new Configuration.Builder().build();
    assertEquals(configuration.getConversationRegion(), ConversationRegion.US);
  }

  @Test
  void builder() {
    Configuration value =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .setNumbersUrl(NUMBERS_SERVER)
            .setSmsRegion(SMS_REGION)
            .setSmsUrl(SMS_SERVER)
            .setConversationRegion(CONVERSATION_REGION)
            .setConversationUrl(CONVERSATION_SERVER)
            .setConversationTemplateManagementUrl(CONVERSATION_TEMPLATE_SERVER)
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
    Assertions.assertEquals(
        value.getConversationRegion(), ConversationRegion.EU, "Conversation region value set");
    Assertions.assertEquals(
        value.getConversationServer().getUrl(),
        CONVERSATION_SERVER,
        "Conversation server present within Conversation server URL");
    Assertions.assertEquals(
        value.getConversationTemplateManagementUrlServer().getUrl(),
        CONVERSATION_TEMPLATE_SERVER,
        "Conversation Template server present within Conversation Template server URL");
  }
}
