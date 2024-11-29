package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class MailgunServiceTest {
  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey(null).build();
    MailgunContext context = MailgunContext.builder().build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new MailgunService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("apiKey"));
  }

  @Test
  void doNotAcceptNullContext() {
    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();
    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new MailgunService(credentials, null, httpClient));
    assertTrue(exception.getMessage().contains("Mailgun service requires context to be defined"));
  }

  @Test
  void doNotAcceptEmptyURL() {
    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();
    MailgunContext context = MailgunContext.builder().setUrl("").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new MailgunService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("Mailgun service requires 'url' to be defined"));
  }

  @Test
  void doNotAcceptNullURL() {
    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();
    MailgunContext context = MailgunContext.builder().build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new MailgunService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("Mailgun service requires 'url' to be defined"));
  }

  @Test
  void passInit() {
    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();
    MailgunContext context = MailgunContext.builder().setUrl("foo").build();
    assertDoesNotThrow(() -> new MailgunService(credentials, context, httpClient), "Init passed");
  }
}
