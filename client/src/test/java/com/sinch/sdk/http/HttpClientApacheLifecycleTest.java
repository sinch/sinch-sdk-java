package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.models.HttpProxyConfiguration;
import org.junit.jupiter.api.Test;

class HttpClientApacheLifecycleTest {

  @Test
  void freshInstanceIsNotClosed() throws Exception {
    try (HttpClientApache client = new HttpClientApache()) {
      assertFalse(client.isClosed());
    }
  }

  @Test
  void closeMarksInstanceAsClosed() throws Exception {
    HttpClientApache client = new HttpClientApache();
    client.close();
    assertTrue(client.isClosed());
  }

  @Test
  void doubleCloseIsIdempotent() throws Exception {
    HttpClientApache client = new HttpClientApache();
    client.close();
    assertDoesNotThrow(client::close);
  }

  @Test
  void closeViaAutoCloseable() {
    assertDoesNotThrow(
        () -> {
          try (HttpClientApache client = new HttpClientApache()) {
            assertFalse(client.isClosed());
          }
        });
  }

  @Test
  void proxyConstructorCreatesOpenInstance() throws Exception {
    HttpProxyConfiguration proxy =
        HttpProxyConfiguration.builder().setHostname("proxy.example.com").setPort(3128).build();
    try (HttpClientApache client = new HttpClientApache(proxy)) {
      assertFalse(client.isClosed(), "HttpClientApache created with proxy config must be open");
    }
  }

  @Test
  void proxyConstructorWithNullBehavesAsNoArgConstructor() throws Exception {
    try (HttpClientApache client = new HttpClientApache(null)) {
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
    try (HttpClientApache client = new HttpClientApache(proxy)) {
      assertFalse(
          client.isClosed(),
          "HttpClientApache created with authenticated proxy config must be open");
    }
  }
}
