package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import com.sinch.sdk.models.UnifiedCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SMSServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void projectIdDoNotAcceptNullKey() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void projectIdDoNotAcceptNullKeySecret() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void projectIdDoNotAcceptNullProject() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void projectIdDoNotAcceptNullCredentials() {

    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new SMSService(null, context, server, httpClient));
    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  @Test
  void projectIdDoNotAcceptNullContext() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new SMSService(credentials, null, server, httpClient));
    assertTrue(exception.getMessage().contains("Context must be defined"));
  }

  @Test
  void projectIdDoNotAcceptNullSmsUrl() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl(null).build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("smsUrl"));
  }

  @Test
  void projectIdUsagePassed() {

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    assertDoesNotThrow(
        () -> new SMSService(credentials, context, server, httpClient), "Init passed");
  }

  @Test
  void servicePlanIdDoNotAcceptNullApiToken() {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder().setApiToken(null).setServicePlanId("foo plan").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("apiToken"));
  }

  @Test
  void servicePlanIdDoNotAcceptNullServicePlanId() {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder().setApiToken("foo token").setServicePlanId(null).build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("servicePlanId"));
  }

  @Test
  void servicePlanIdDoNotAcceptNullCredentials() {

    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SMSService(null, context, httpClient));
    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  @Test
  void servicePlanIdDoNotAcceptNullContext() {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new SMSService(credentials, null, httpClient));
    assertTrue(exception.getMessage().contains("Context must be defined"));
  }

  @Test
  void servicePlanIdDoNotAcceptNullSmsUrl() {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl(null).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("smsUrl"));
  }

  @Test
  void servicePlanIdUsagePassed() {

    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();

    assertDoesNotThrow(() -> new SMSService(credentials, context, httpClient), "Init passed");
  }
}
