package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

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
}
