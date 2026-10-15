package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.models.HttpProxyConfiguration;
import com.sinch.sdk.models.TransportSettings;
import org.junit.jupiter.api.Test;

class HttpClientApacheLifecycleTest {

  @Test
  void freshInstanceIsNotClosed() throws Exception {
    try (HttpClientApache client =
        new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertFalse(client.isClosed());
    }
  }

  @Test
  void closeMarksInstanceAsClosed() throws Exception {
    HttpClientApache client =
        new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS);
    client.close();
    assertTrue(client.isClosed());
  }

  @Test
  void doubleCloseIsIdempotent() throws Exception {
    HttpClientApache client =
        new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS);
    client.close();
    assertDoesNotThrow(client::close);
  }

  @Test
  void closeViaAutoCloseable() {
    assertDoesNotThrow(
        () -> {
          try (HttpClientApache client =
              new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
            assertFalse(client.isClosed());
          }
        });
  }

  @Test
  void proxyConstructorCreatesOpenInstance() throws Exception {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder().setHostname("proxy.example.com").setPort(3128).build();
    try (HttpClientApache client =
        new HttpClientApache(proxy, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertFalse(client.isClosed(), "HttpClientApache created with proxy config must be open");
    }
  }

  @Test
  void proxyConstructorWithNullBehavesAsNoArgConstructor() throws Exception {
    try (HttpClientApache client =
        new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertFalse(client.isClosed(), "HttpClientApache(null) must behave like no-arg constructor");
    }
  }

  @Test
  void proxyConstructorWithAuthCreatesOpenInstance() throws Exception {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder()
            .setHostname("proxy.example.com")
            .setPort(3128)
            .setUsername("user")
            .setPassword("pass")
            .build();
    try (HttpClientApache client =
        new HttpClientApache(proxy, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertFalse(
          client.isClosed(),
          "HttpClientApache created with authenticated proxy config must be open");
    }
  }
}
