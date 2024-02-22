package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SmsContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SMSServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    Configuration configuration =
        Configuration.builder()
            .setSmsContext(SmsContext.builder().build())
            .setKeyId(null)
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    Configuration configuration =
        Configuration.builder()
            .setSmsContext(SmsContext.builder().build())
            .setKeyId("foo")
            .setKeySecret(null)
            .setProjectId("foo")
            .build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    Configuration configuration =
        Configuration.builder()
            .setSmsContext(SmsContext.builder().build())
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId(null)
            .build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullContext() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new SMSService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("SMS context must be defined"));
  }
}
