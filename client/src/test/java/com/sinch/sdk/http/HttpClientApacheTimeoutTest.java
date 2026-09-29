package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpClientApacheTimeoutTest {

  private MockWebServer server;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  private HttpResponse invoke(HttpClientApache client) {
    return client.invokeAPI(
        new ServerConfiguration(server.url("/").toString()),
        null,
        new HttpRequest("", HttpMethod.GET, null, (String) null, null, null, null, null));
  }

  @Test
  void slowHeadersTripTheTimeout() throws Exception {
    server.enqueue(new MockResponse().setBody("{}").setHeadersDelay(3, TimeUnit.SECONDS));

    try (HttpClientApache client = new HttpClientApache(null, RetryManager.NO_RETRY, 1)) {
      long start = System.currentTimeMillis();
      assertThrows(ApiException.class, () -> invoke(client));
      long elapsed = System.currentTimeMillis() - start;
      assertTrue(
          elapsed < 2_000,
          "expected the 1s timeout to fire before the 3s headers delay, took " + elapsed);
    }
  }

  @Test
  void aResponseInsideTheTimeoutSucceeds() throws Exception {
    server.enqueue(new MockResponse().setBody("{}"));

    try (HttpClientApache client = new HttpClientApache(null, RetryManager.NO_RETRY, 5)) {
      assertEquals(200, invoke(client).getCode());
    }
  }

  @Test
  @SuppressWarnings("deprecation")
  void theDefaultTimeoutIsUsedWhenNoneIsGiven() throws Exception {
    server.enqueue(new MockResponse().setBody("{}"));

    try (HttpClientApache client = new HttpClientApache(null, RetryManager.NO_RETRY)) {
      assertEquals(200, invoke(client).getCode());
    }
  }
}
