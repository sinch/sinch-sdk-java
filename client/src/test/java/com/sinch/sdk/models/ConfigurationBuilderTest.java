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
  static final String PROXY_HOST = "proxy.corp.example.com";
  static final int PROXY_PORT = 3128;
  static final String PROXY_USER = "proxyUser";
  static final String PROXY_PASS = "proxyPass";

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
            .setHttpProxyConfiguration(
                HttpProxyConfiguration.builder()
                    .setHostname(PROXY_HOST)
                    .setPort(PROXY_PORT)
                    .setUsername(PROXY_USER)
                    .setPassword(PROXY_PASS)
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

    Assertions.assertTrue(
        builder.getHttpProxyConfiguration().isPresent(), "Proxy configuration should be present");
    Assertions.assertEquals(
        PROXY_HOST, builder.getHttpProxyConfiguration().get().getHostname(), "Proxy hostname");
    Assertions.assertEquals(
        PROXY_PORT, builder.getHttpProxyConfiguration().get().getPort(), "Proxy port");
    Assertions.assertEquals(
        PROXY_USER,
        builder.getHttpProxyConfiguration().get().getUsername().orElse(null),
        "Proxy username");
    Assertions.assertArrayEquals(
        PROXY_PASS.toCharArray(),
        builder.getHttpProxyConfiguration().get().getPassword().orElse(null),
        "Proxy password");
  }

  @Test
  void buildWithoutProxy() {
    Configuration config =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .build();
    Assertions.assertFalse(
        config.getHttpProxyConfiguration().isPresent(),
        "Proxy configuration should be absent when not configured");
  }

  @Test
  void builderCopyPreservesProxyConfiguration() {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder().setHostname(PROXY_HOST).setPort(PROXY_PORT).build();
    Configuration original =
        new Configuration.Builder()
            .setKeyId(KEY)
            .setKeySecret(SECRET)
            .setProjectId(PROJECT)
            .setOAuthUrl(OAUTH_URL)
            .setHttpProxyConfiguration(proxy)
            .build();

    Configuration copy = Configuration.builder(original).build();
    Assertions.assertTrue(copy.getHttpProxyConfiguration().isPresent());
    Assertions.assertEquals(
        PROXY_HOST,
        copy.getHttpProxyConfiguration().get().getHostname(),
        "Hostname preserved in copy");
    Assertions.assertEquals(
        PROXY_PORT, copy.getHttpProxyConfiguration().get().getPort(), "Port preserved in copy");
  }
}
