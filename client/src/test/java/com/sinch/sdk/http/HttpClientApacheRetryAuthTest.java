package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.RetryConfiguration;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A retry must re-sign the request, not replay the first attempt's headers. ApplicationAuthManager
 * (Voice, Verification) signs an x-timestamp, so a retry that waited out a backoff and reused the
 * original signature would be rejected by the server rather than succeeding.
 */
class HttpClientApacheRetryAuthTest {

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
  void eachRetryAttemptIsSignedAfresh() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "1"));
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    Map<String, AuthManager> auth =
        Collections.singletonMap(
            "Basic", new ApplicationAuthManager("key", "c2VjcmV0LXZhbHVlLWZvci10ZXN0aW5n"));

    try (HttpClientApache client =
        new HttpClientApache(
            null,
            new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(1).build()))) {
      client.invokeAPI(
          new ServerConfiguration(server.url("/").toString()),
          auth,
          new HttpRequest(
              "",
              HttpMethod.GET,
              null,
              (String) null,
              null,
              null,
              null,
              Collections.singletonList("Basic")));
    }

    assertEquals(2, server.getRequestCount(), "expected the 429 to be retried once");
    RecordedRequest first = server.takeRequest();
    RecordedRequest second = server.takeRequest();

    assertNotNull(first.getHeader("x-timestamp"));
    assertNotNull(second.getHeader("x-timestamp"));
    assertNotEquals(
        first.getHeader("x-timestamp"),
        second.getHeader("x-timestamp"),
        "the retry replayed the first attempt's timestamp, so its signature is stale");
    assertNotEquals(
        first.getHeader("Authorization"),
        second.getHeader("Authorization"),
        "a fresh timestamp must produce a fresh signature");
  }
}
