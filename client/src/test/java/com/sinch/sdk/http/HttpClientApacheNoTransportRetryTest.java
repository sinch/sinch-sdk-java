package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Apache's own retry layer must stay off, so that the SDK policy is the only thing retrying. */
class HttpClientApacheNoTransportRetryTest {

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

  @Test
  void rateLimitedResponseIsReturnedAfterASingleRequest() throws Exception {
    // A Retry-After the transport would otherwise honour, uncapped, before returning
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "30"));
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    HttpResponse response = invoke();

    assertEquals(429, response.getCode(), "the 429 must reach the caller, not be retried away");
    assertEquals(1, server.getRequestCount(), "the transport must not retry a 429");
    assertNotNull(
        response.getHeaders().get("Retry-After"),
        "Retry-After must survive to the caller, which owns the backoff");
  }

  @Test
  void serviceUnavailableResponseIsReturnedAfterASingleRequest() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(503));
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    HttpResponse response = invoke();

    assertEquals(503, response.getCode(), "the 503 must reach the caller, not be retried away");
    assertEquals(1, server.getRequestCount(), "the transport must not retry a 503");
  }

  private HttpResponse invoke() throws Exception {
    RetryConfiguration noSdkRetries =
        RetryConfiguration.builder().setRetryPolicy(RetryPolicy.NONE).build();
    try (HttpClientApache client =
        new HttpClientApache(null, new DefaultRetryManager(noSdkRetries))) {
      HttpResponse response =
          client.invokeAPI(
              new ServerConfiguration(server.url("/").toString()),
              null,
              new HttpRequest("", HttpMethod.GET, null, (String) null, null, null, null, null));
      // give a retry, were one to happen, the chance to reach the server before we count
      server.takeRequest(1, TimeUnit.SECONDS);
      return response;
    }
  }
}
