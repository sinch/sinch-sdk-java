package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Test;

class SinchClientTest {

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
