package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Test;

class SinchClientTest {

  @Test
  void doNotAcceptNullKey() {
    Configuration configuration =
        Configuration.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    Exception exception =
        assertThrows(NullPointerException.class, () -> new SinchClient(configuration));
    assertTrue(exception.getMessage().contains("projectId"));
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
    assertNotNull(client.getConfiguration().getNumbersUrl());
  }

  @Test
  void defaultSmsUrlAvailable() {
    Configuration configuration =
        Configuration.builder().setKeyId("foo").setKeySecret("foo").setProjectId("foo").build();
    SinchClient client = new SinchClient(configuration);
    assertNotNull(client.getConfiguration().getSmsUrl());
  }
}
