package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.LogRecorder;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.SMSRegion;
import com.sinch.sdk.models.SmsContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SMSServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsBatches() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::batches);
  }

  @Test
  void checkCredentialsInbounds() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::inbounds);
  }

  @Test
  void checkCredentialsDeliveryReports() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::deliveryReports);
  }

  @Test
  void checkCredentialsGroups() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::groups);
  }

  @Test
  void checkCredentialsWebhooks() {
    assertDoesNotThrow(() -> new SMSService(null, null, null, null).webhooks(), "Init passed");
  }

  @Test
  void passInitWithoutSettings() {
    assertDoesNotThrow(() -> new SMSService(null, null, null, null), "Init passed");
  }

  @Test
  void defaultRegionWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    SmsContext context =
        SmsContext.builder()
            .setSmsUrl("https://sms.foo.url")
            .setSmsRegion(SMSRegion.US)
            .setRegionAsDefault(true)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    new SMSService(credentials, context, server, () -> httpClient).batches();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for SMS 'us"))
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

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    SmsContext context =
        SmsContext.builder()
            .setSmsUrl("https://sms.foo.url")
            .setSmsRegion(SMSRegion.US)
            .setRegionAsDefault(false)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");
    new SMSService(credentials, context, server, () -> httpClient).batches();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for SMS 'us"))
            .findFirst();

    assertFalse(record.isPresent());
    LogManager.getLogManager().reset();
  }
}
