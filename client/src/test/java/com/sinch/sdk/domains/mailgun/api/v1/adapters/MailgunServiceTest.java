package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.LogRecorder;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunCredentials;
import com.sinch.sdk.models.MailgunRegion;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
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

  @Test
  void defaultRegionWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();
    MailgunContext context =
        MailgunContext.builder()
            .setUrl("foo value")
            .setRegion(MailgunRegion.US)
            .setRegionAsDefault(true)
            .build();

    new MailgunService(credentials, context, httpClient);

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for Mailgun 'us"))
            .findFirst();

    assertTrue(record.isPresent());
    assertEquals(record.get().getLevel(), Level.WARNING);
    LogManager.getLogManager().reset();
  }

  @Test
  void regionNoWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    MailgunCredentials credentials = MailgunCredentials.builder().setApiKey("foo").build();

    MailgunContext context =
        MailgunContext.builder()
            .setUrl("foo value")
            .setRegion(MailgunRegion.EUROPE)
            .setRegionAsDefault(false)
            .build();
    new MailgunService(credentials, context, httpClient);

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for Mailgun 'us"))
            .findFirst();

    assertFalse(record.isPresent());
    LogManager.getLogManager().reset();
  }
}
