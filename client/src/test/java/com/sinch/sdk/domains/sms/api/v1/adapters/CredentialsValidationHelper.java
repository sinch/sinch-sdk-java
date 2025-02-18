package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {

    projectIdDoNotAcceptNullKey(httpClientSupplier, service);

    projectIdDoNotAcceptNullKeySecret(httpClientSupplier, service);
    projectIdDoNotAcceptNullProject(httpClientSupplier, service);
    projectIdDoNotAcceptNullCredentials(httpClientSupplier, service);
    projectIdDoNotAcceptNullContext(httpClientSupplier, service);
    projectIdDoNotAcceptNullSmsUrl(httpClientSupplier, service);
    projectIdUsagePassed(httpClientSupplier, service);
    servicePlanIdDoNotAcceptNullApiToken(httpClientSupplier, service);
    servicePlanIdDoNotAcceptNullServicePlanId(httpClientSupplier, service);
    servicePlanIdDoNotAcceptNullCredentials(httpClientSupplier, service);
    servicePlanIdDoNotAcceptNullContext(httpClientSupplier, service);
    servicePlanIdDoNotAcceptNullSmsUrl(httpClientSupplier, service);
    servicePlanIdUsagePassed(httpClientSupplier, service);
  }

  static void projectIdDoNotAcceptNullKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  static void projectIdDoNotAcceptNullKeySecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  static void projectIdDoNotAcceptNullProject(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  static void projectIdDoNotAcceptNullCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {

    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new SMSService(null, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  static void projectIdDoNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
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
            () -> service.accept(new SMSService(credentials, null, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Context must be defined"));
  }

  static void projectIdDoNotAcceptNullSmsUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
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
            () -> service.accept(new SMSService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("smsUrl"));
  }

  static void projectIdUsagePassed(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    assertDoesNotThrow(
        () -> service.accept(new SMSService(credentials, context, server, httpClientSupplier)),
        "Init passed");
  }

  static void servicePlanIdDoNotAcceptNullApiToken(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder().setApiToken(null).setServicePlanId("foo plan").build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("apiToken"));
  }

  static void servicePlanIdDoNotAcceptNullServicePlanId(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder().setApiToken("foo token").setServicePlanId(null).build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("servicePlanId"));
  }

  static void servicePlanIdDoNotAcceptNullCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {

    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new SMSService(null, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  static void servicePlanIdDoNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new SMSService(credentials, null, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Context must be defined"));
  }

  static void servicePlanIdDoNotAcceptNullSmsUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {
    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl(null).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new SMSService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("smsUrl"));
  }

  static void servicePlanIdUsagePassed(
      Supplier<HttpClient> httpClientSupplier, Consumer<SMSService> service) {

    SmsServicePlanCredentials credentials =
        SmsServicePlanCredentials.builder()
            .setApiToken("foo token")
            .setServicePlanId("foo plan")
            .build();
    SmsContext context = SmsContext.builder().setSmsUrl("https://sms.foo.url").build();

    assertDoesNotThrow(
        () -> service.accept(new SMSService(credentials, context, httpClientSupplier)),
        "Init passed");
  }
}
