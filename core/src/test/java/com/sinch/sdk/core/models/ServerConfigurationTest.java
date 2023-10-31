package com.sinch.sdk.core.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServerConfigurationTest {

  @Test
  void getUrl() {
    String URL = "my url";
    ServerConfiguration configuration = new ServerConfiguration(URL);
    assertEquals(URL, configuration.getUrl());
  }
}
