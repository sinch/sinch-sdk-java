package com.sinch.sdk.models;

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
  static final ConversationRegion CONVERSATION_REGION = ConversationRegion.BR;
  static final String CONVERSATION_SERVER = "%sfooCONVERSATION_SERVER";
  static final String CONVERSATION_TEMPLATE_SERVER = "%sfooCONVERSATION_TEMPLATE_SERVER";

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
            .setConversationContext(
                ConversationContext.builder()
                    .setRegion(CONVERSATION_REGION)
                    .setUrl(CONVERSATION_SERVER)
                    .setTemplateManagementUrl(CONVERSATION_TEMPLATE_SERVER)
                    .build())
            .build();
    Assertions.assertEquals(OAUTH_URL, builder.getOAuthServer().getUrl());
    Assertions.assertEquals(
        NUMBERS_SERVER, builder.getNumbersContext().get().getNumbersServer().getUrl());
    Assertions.assertTrue(
        builder.getSmsContext().get().getSmsRegion().toString().contains(SMS_REGION.value()),
        "SMS Region present within SMS server URL");
    Assertions.assertTrue(
        builder.getSmsContext().get().getSmsServer().getUrl().contains("fooSMS_SERVER"),
        "SMS server present within SMS server URL");

    Assertions.assertTrue(
        builder
            .getConversationContext()
            .get()
            .getRegion()
            .toString()
            .contains(CONVERSATION_REGION.value()),
        "Conversation Region present within SMS server URL");
    Assertions.assertTrue(
        builder
            .getConversationContext()
            .get()
            .getServer()
            .getUrl()
            .contains("fooCONVERSATION_SERVER"),
        "Conversation server present within conversation server URL");
    Assertions.assertTrue(
        builder
            .getConversationContext()
            .get()
            .getTemplateManagementServer()
            .getUrl()
            .contains("fooCONVERSATION_TEMPLATE_SERVER"),
        "Conversation template server present within conversation template server URL");
  }
}
