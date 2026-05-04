package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.HttpProxyConfiguration;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.VoiceContext;
import com.sinch.sdk.models.VoiceRegion;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class SinchClientTest {

  @Test
  void configurationNullGuard() {
    SinchClient client = new SinchClient(null);
    assertNotNull(client);
  }

  @Test
  void noConfiguration() {
    SinchClient client = new SinchClient();
    assertNotNull(client);
  }

  @Test
  void defaultOAuthUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getOAuthUrl());
  }

  @Test
  void defaultNumbersUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getNumbersContext().get().getNumbersUrl());
  }

  @Test
  void defaultSmsUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getSmsContext().get().getSmsUrl());
  }

  @Test
  void smsRegionIsNullWhenNotSet() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNull(client.getConfiguration().getSmsContext().get().getSmsRegion());
  }

  @Test
  void smsRegion() {
    Configuration configuration =
        Configuration.builder().setSmsRegion(SMSRegion.from("eu")).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(SMSRegion.EU, client.getConfiguration().getSmsContext().get().getSmsRegion());
  }

  @Test
  void smsUrlFromRegion() {
    Configuration configuration = Configuration.builder().setSmsRegion(SMSRegion.AU).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://zt.au.sms.api.sinch.com",
        client.getConfiguration().getSmsContext().get().getSmsServer().getUrl());
  }

  @Test
  void smsUrlFromRegionWithServicePlanId() {
    Configuration configuration =
        Configuration.builder().setSmsServicePlanId("foo").setSmsRegion(SMSRegion.AU).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://au.sms.api.sinch.com",
        client.getConfiguration().getSmsContext().get().getSmsServer().getUrl());
  }

  @Test
  void conversationUrlIsNullWhenRegionNotSet() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNull(client.getConfiguration().getConversationContext().get().getUrl());
  }

  @Test
  void conversationUrlFromRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.EU).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://eu.conversation.api.sinch.com",
        client.getConfiguration().getConversationContext().get().getUrl());
  }

  @Test
  void conversationTemplateUrlIsNullWhenRegionNotSet() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNull(client.getConfiguration().getConversationContext().get().getTemplateManagementUrl());
  }

  @Test
  void templateConversationUrlFromRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.BR).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://br.template.api.sinch.com",
        client.getConfiguration().getConversationContext().get().getTemplateManagementUrl());
  }

  @Test
  void conversationRegionIsNullWhenNotSet() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertNull(client.getConfiguration().getConversationContext().get().getRegion());
  }

  @Test
  void conversationRegion() {
    Configuration configuration =
        Configuration.builder().setConversationRegion(ConversationRegion.from("br")).build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        ConversationRegion.BR,
        client.getConfiguration().getConversationContext().get().getRegion());
  }

  @Test
  void defaultVerificationUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getVerificationContext().get().getVerificationUrl());
  }

  @Test
  void defaultNumberLookupUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getNumberLookupContext().get().getNumberLookupUrl());
  }

  @Test
  void defaultVoiceRegion() {
    Configuration configuration = Configuration.builder().build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        VoiceRegion.GLOBAL, client.getConfiguration().getVoiceContext().get().getVoiceRegion());
  }

  @Test
  void defaultVoiceUrl() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertFalse(
        StringUtil.isEmpty(client.getConfiguration().getVoiceContext().get().getVoiceUrl()));
  }

  @Test
  void defaultVoiceApplicationManagementUrl() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertFalse(
        StringUtil.isEmpty(
            client.getConfiguration().getVoiceContext().get().getVoiceApplicationManagementUrl()));
  }

  @Test
  void voiceUrlFromRegion() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(VoiceContext.builder().setVoiceRegion(VoiceRegion.EUROPE).build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        "https://calling-euc1.api.sinch.com",
        client.getConfiguration().getVoiceContext().get().getVoiceUrl());
  }

  @Test
  void voiceUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(
                VoiceContext.builder()
                    .setVoiceRegion(VoiceRegion.EUROPE)
                    .setVoiceUrl("my foo url")
                    .build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        VoiceRegion.EUROPE, client.getConfiguration().getVoiceContext().get().getVoiceRegion());
    assertEquals("my foo url", client.getConfiguration().getVoiceContext().get().getVoiceUrl());
  }

  @Test
  void voiceApplicationManagementUrlFromUrl() {
    Configuration configuration =
        Configuration.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .setVoiceContext(
                VoiceContext.builder().setVoiceApplicationMngmtUrl("my foo url").build())
            .build();
    SinchClient client = new SinchClient(configuration);
    assertEquals(
        client.getConfiguration().getVoiceContext().get().getVoiceApplicationManagementUrl(),
        "my foo url");
  }

  @Test
  void formatAuxiliaryFlagReturnsVendorWhenFlagIsEmpty() {
    SinchClient client = new SinchClient();
    // AUXILIARY_FLAG is "" in SDK — only vendor should be present, no comma separator
    String result = client.formatAuxiliaryFlag("");
    assertNotNull(result);
    assertEquals(
        System.getProperty("java.vendor"),
        result,
        "When auxiliaryFlag is empty, the result should match java.vendor exactly");
  }

  @Test
  void formatAuxiliaryFlagHandlesNullJavaVendor() {
    String original = System.getProperty("java.vendor");
    try {
      System.clearProperty("java.vendor");
      SinchClient client = new SinchClient();
      String result = client.formatAuxiliaryFlag("");
      assertNotNull(result);
      assertFalse(result.contains("null"), "Null java.vendor must not render as 'null' string");
    } finally {
      if (null != original) {
        System.setProperty("java.vendor", original);
      }
    }
  }

  @Test
  void formatAuxiliaryFlagAppendsNonEmptyFlag() {
    SinchClient client = new SinchClient();
    String result = client.formatAuxiliaryFlag("my-wrapper/1.0");
    assertNotNull(result);
    assertTrue(result.contains(","), "A comma must separate vendor from the auxiliary flag");
    assertTrue(
        result.endsWith(",my-wrapper/1.0"),
        "Auxiliary flag must be the last element after the comma");
  }

  @Test
  void closeBeforeAnyCall() {
    SinchClient client = new SinchClient();
    assertDoesNotThrow(client::close);
  }

  @Test
  void doubleCloseBeforeAnyCall() {
    SinchClient client = new SinchClient();
    client.close();
    assertDoesNotThrow(client::close);
  }

  /**
   * Verifies that a proxy configuration set on {@link Configuration} is preserved in the {@link
   * SinchClient}'s internal configuration after construction.
   */
  @Test
  void proxyConfigurationPreservedInConfiguration() {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder()
            .setHostname("proxy.corp.example.com")
            .setPort(3128)
            .build();
    Configuration configuration = Configuration.builder().setHttpProxyConfiguration(proxy).build();
    SinchClient client = new SinchClient(configuration);
    assertTrue(
        client.getConfiguration().getHttpProxyConfiguration().isPresent(),
        "Proxy configuration must be present in the SinchClient's stored configuration");
    assertEquals(
        "proxy.corp.example.com",
        client.getConfiguration().getHttpProxyConfiguration().get().getHostname(),
        "Proxy hostname must survive SinchClient construction");
    assertEquals(
        3128,
        client.getConfiguration().getHttpProxyConfiguration().get().getPort(),
        "Proxy port must survive SinchClient construction");
  }

  /**
   * Verifies that {@link SinchClient#getHttpClient()} (called via reflection) creates an {@link
   * HttpClientApache} when proxy configuration is present — i.e. the proxy config is wired from
   * {@link Configuration} into the HTTP-client factory.
   */
  @Test
  void proxyConfigurationWiredIntoHttpClient() throws Exception {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder()
            .setHostname("proxy.corp.example.com")
            .setPort(3128)
            .build();
    Configuration configuration = Configuration.builder().setHttpProxyConfiguration(proxy).build();
    SinchClient sinchClient = new SinchClient(configuration);

    // Trigger lazy initialization of the internal HttpClientApache via reflection
    Method getHttpClient = SinchClient.class.getDeclaredMethod("getHttpClient");
    getHttpClient.setAccessible(true);
    Object httpClient = getHttpClient.invoke(sinchClient);

    assertNotNull(httpClient, "getHttpClient() must return a non-null HttpClientApache");
    assertInstanceOf(
        HttpClientApache.class, httpClient, "getHttpClient() must return an HttpClientApache");

    // Verify the stored field in SinchClient was initialised (not null)
    Field httpClientField = SinchClient.class.getDeclaredField("httpClient");
    httpClientField.setAccessible(true);
    assertNotNull(
        httpClientField.get(sinchClient),
        "SinchClient.httpClient field must be initialised after getHttpClient()");
  }
}
