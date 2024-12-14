package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.UnifiedCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SMSServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    SmsContext context = SmsContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    SmsContext context = SmsContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    SmsContext context = SmsContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new SMSService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullCredentials() {

    SmsContext context = SmsContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new SMSService(null, context, server, httpClient));
    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  @Test
  void doNotAcceptNullContext() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new SMSService(credentials, null, server, httpClient));
    assertTrue(exception.getMessage().contains("Context must be defined"));
  }
}
