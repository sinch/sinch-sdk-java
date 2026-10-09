package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.IdempotencyKey;
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
 * The transport generates the <code>Idempotency-Key</code> of the operations that accept one, so
 * that the adapters only forward the key set by the user.
 */
class HttpClientApacheIdempotencyKeyTest {

  private MockWebServer server;
  private HttpClientApache client;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
    client =
        new HttpClientApache(
            null,
            new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(1).build()));
  }

  @AfterEach
  void tearDown() throws Exception {
    client.close();
    server.shutdown();
  }

  @Test
  void generatesKeyWhenNoneIsSet() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.emptyMap(), true);

    assertNotNull(server.takeRequest().getHeader(IdempotencyKey.HEADER));
  }

  @Test
  void keepsKeySetByUser() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.singletonMap(IdempotencyKey.HEADER, "user-key-0123456789"), true);

    assertEquals("user-key-0123456789", server.takeRequest().getHeader(IdempotencyKey.HEADER));
  }

  // Header names are case-insensitive: a key set in lower case must not get a second, generated one
  @Test
  void keepsKeySetByUserInLowerCase() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.singletonMap("idempotency-key", "user-key-0123456789"), true);

    RecordedRequest request = server.takeRequest();
    assertEquals(1, request.getHeaders().values(IdempotencyKey.HEADER).size());
    assertEquals("user-key-0123456789", request.getHeader(IdempotencyKey.HEADER));
  }

  @Test
  void noKeyWhenOperationDoesNotAcceptOne() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.emptyMap(), false);

    assertNull(server.takeRequest().getHeader(IdempotencyKey.HEADER));
  }

  // The key identifies the operation: the server can only answer a retry with the cached response
  // of the first attempt if both carry the same key
  @Test
  void rateLimitedRetrySendsSameKey() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "0"));
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.emptyMap(), true);

    assertEquals(2, server.getRequestCount(), "expected the 429 to be retried once");
    RecordedRequest first = server.takeRequest();
    RecordedRequest second = server.takeRequest();
    assertNotNull(first.getHeader(IdempotencyKey.HEADER));
    assertEquals(first.getHeader(IdempotencyKey.HEADER), second.getHeader(IdempotencyKey.HEADER));
  }

  @Test
  void eachCallGetsItsOwnKey() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
    server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));

    invoke(Collections.emptyMap(), true);
    invoke(Collections.emptyMap(), true);

    assertNotEquals(
        server.takeRequest().getHeader(IdempotencyKey.HEADER),
        server.takeRequest().getHeader(IdempotencyKey.HEADER));
  }

  private void invoke(Map<String, String> headers, boolean idempotent) {
    client.invokeAPI(
        new ServerConfiguration(server.url("/").toString()),
        Collections.emptyMap(),
        new HttpRequest(
            "",
            HttpMethod.POST,
            Collections.emptyList(),
            "{}",
            headers,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            idempotent));
  }
}
