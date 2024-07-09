package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NumbersServiceTest {

  @Mock HttpClient httpClient;

  NumbersContext context = NumbersContext.builder().setNumbersUrl("foo url").build();

  @Test
  void doNotAcceptNullKey() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new NumbersService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new NumbersService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new NumbersService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullContext() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new NumbersService(credentials, null, httpClient));
    assertTrue(exception.getMessage().contains("context must be defined"));
  }

  @Test
  void doNotAcceptNullNumbersUrl() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    NumbersContext context = NumbersContext.builder().build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new NumbersService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("numbersUrl"));
  }
}
