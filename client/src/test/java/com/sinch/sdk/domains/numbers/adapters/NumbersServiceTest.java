package com.sinch.sdk.domains.numbers.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NumbersServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    Configuration configuration =
        Configuration.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new NumbersService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new NumbersService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new NumbersService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }
}
