package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Integration tests verifying that {@link HttpClientApache} routes traffic through a configured
 * HTTP proxy and handles proxy authentication challenges.
 *
 * <p>Each test spins up its own {@link MockWebServer} that plays the role of the proxy, so tests
 * are fully isolated and safe to run in parallel.
 */
class HttpClientApacheProxyTest {

  MockWebServer mockProxy;
  String proxyBaseUrl;

  @BeforeEach
  void setUp() throws IOException {
    mockProxy = new MockWebServer();
    mockProxy.start();
    proxyBaseUrl = String.format("http://localhost:%s/", mockProxy.getPort());
  }

  @AfterEach
  void tearDown() throws IOException {
    mockProxy.shutdown();
  }

  /**
   * Verifies that when a proxy is configured, the HTTP connection is established with the proxy
   * host rather than the target host. Using the proxy server's address as both proxy and target
   * keeps the test self-contained — if the proxy setting were ignored, Apache would still connect
   * to the same MockWebServer directly and the request would be received anyway. The real proof is
   * in {@link #authenticatedProxyCredentialsSentAfterChallenge()} where Apache must handle the
   * 407/retry cycle correctly.
   */
  @Test
  void unauthenticatedProxyRequestRoutedThroughProxy() throws Exception {
    HttpProxyConfiguration proxySettings =
        HttpProxyConfiguration.builder()
            .setHostname("localhost")
            .setPort(mockProxy.getPort())
            .build();

    mockProxy.enqueue(
        new MockResponse().setBody("{}").addHeader("Content-Type", "application/json"));

    try (HttpClientApache proxyClient = new HttpClientApache(proxySettings)) {

      proxyClient.invokeAPI(
          new ServerConfiguration(proxyBaseUrl),
          null,
          new HttpRequest("api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest request = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(request, "Proxy should have received the request");
    assertNotNull(request.getPath(), "Recorded request must have a path");
    assertTrue(
        request.getPath().startsWith("http://"),
        "When using an HTTP proxy, the request-target should be absolute-form (starts with"
            + " http://); actual: "
            + request.getPath());
  }

  /**
   * Verifies that when the proxy returns a 407 challenge, Apache retries with the correct {@code
   * Proxy-Authorization} credentials and the call ultimately succeeds.
   *
   * <p>MockWebServer plays the role of an authenticating proxy: it first returns 407 with a {@code
   * Proxy-Authenticate: Basic} challenge, then accepts the retry and returns 200. The test asserts
   * that exactly two requests were received and that the retry carries the expected Basic
   * credentials.
   */
  @Test
  void authenticatedProxyCredentialsSentAfterChallenge() throws Exception {
    HttpProxyConfiguration proxySettings =
        HttpProxyConfiguration.builder()
            .setHostname("localhost")
            .setPort(mockProxy.getPort())
            .setUsername("proxy-user")
            .setPassword("proxy-pass")
            .build();

    mockProxy.enqueue(
        new MockResponse()
            .setResponseCode(407)
            .addHeader("Proxy-Authenticate", "Basic realm=\"proxy\""));
    mockProxy.enqueue(
        new MockResponse().setBody("{}").addHeader("Content-Type", "application/json"));

    try (HttpClientApache proxyClient = new HttpClientApache(proxySettings)) {
      proxyClient.invokeAPI(
          new ServerConfiguration(proxyBaseUrl),
          null,
          new HttpRequest("api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest initial = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(initial, "Proxy should receive the initial request");

    RecordedRequest retry = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(retry, "Proxy should receive the retry request after 407 challenge");

    String proxyAuthHeader = retry.getHeader("Proxy-Authorization");
    assertNotNull(proxyAuthHeader, "Proxy-Authorization must be present on the retry");
    assertTrue(
        proxyAuthHeader.startsWith("Basic "),
        "Proxy-Authorization must use the Basic scheme; actual: " + proxyAuthHeader);
    String decoded =
        new String(
            Base64.getDecoder().decode(proxyAuthHeader.substring("Basic ".length())),
            StandardCharsets.UTF_8);
    assertEquals(
        "proxy-user:proxy-pass",
        decoded,
        "Proxy-Authorization must encode the exact configured credentials");
  }

  /** A proxy with credentials but no 407 challenge should work fine (no retry needed). */
  @Test
  void authenticatedProxyNoChallengeSucceedsDirectly() throws Exception {
    HttpProxyConfiguration proxySettings =
        HttpProxyConfiguration.builder()
            .setHostname("localhost")
            .setPort(mockProxy.getPort())
            .setUsername("user")
            .setPassword("pass")
            .build();

    mockProxy.enqueue(
        new MockResponse().setBody("{}").addHeader("Content-Type", "application/json"));

    try (HttpClientApache proxyClient = new HttpClientApache(proxySettings)) {

      proxyClient.invokeAPI(
          new ServerConfiguration(proxyBaseUrl),
          null,
          new HttpRequest("api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest request = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(request, "Proxy should receive the request");
  }
}
