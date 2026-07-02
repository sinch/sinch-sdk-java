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

class HttpClientApacheProxyTest {

  MockWebServer mockProxy;

  @BeforeEach
  void setUp() throws IOException {
    mockProxy = new MockWebServer();
    mockProxy.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    mockProxy.shutdown();
  }

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
          new ServerConfiguration("http://foo.com"),
          null,
          new HttpRequest(
              "/api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest request = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(request, "Proxy should have received the request");
    assertTrue(
        request.getRequestLine().startsWith("GET http://foo.com/api/path"),
        "Initial request should be a full URL as per RFC 7230 when sent to a proxy; actual: "
            + request.getRequestLine());
    assertNotNull(request.getRequestUrl(), "Recorded request must have an URL");
    assertEquals(
        "localhost",
        request.getRequestUrl().host(),
        "Proxy request should be sent to the proxy host");
    assertEquals(
        mockProxy.getPort(),
        request.getRequestUrl().port(),
        "Proxy request should be sent to the proxy port");
    assertEquals(
        "/", request.getRequestUrl().encodedPath(), "Initial request should have the proxy path");

    RecordedRequest noMoreRequest = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNull(noMoreRequest, "Proxy should not receive more than 1 request for the same call");
  }

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
          new ServerConfiguration("http://foo.com"),
          null,
          new HttpRequest(
              "/api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest initial = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(initial, "Proxy should have received the request");
    assertTrue(
        initial.getRequestLine().startsWith("GET http://foo.com/api/path"),
        "Initial request should be a full URL as per RFC 7230 when sent to a proxy; actual: "
            + initial.getRequestLine());
    assertNotNull(initial.getRequestUrl(), "Recorded request must have an URL");
    assertEquals(
        "localhost",
        initial.getRequestUrl().host(),
        "Proxy request should be sent to the proxy host");
    assertEquals(
        mockProxy.getPort(),
        initial.getRequestUrl().port(),
        "Proxy request should be sent to the proxy port");
    assertEquals(
        "/", initial.getRequestUrl().encodedPath(), "Initial request should have the proxy path");

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

    RecordedRequest noMoreRequest = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNull(
        noMoreRequest,
        "Proxy should not receive more than 2 requests for the same call (initial + retry)");
  }

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
          new ServerConfiguration("http://foo.com"),
          null,
          new HttpRequest(
              "/api/path", HttpMethod.GET, null, (String) null, null, null, null, null));
    }

    RecordedRequest request = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNotNull(request, "Proxy should have received the request");
    assertTrue(
        request.getRequestLine().startsWith("GET http://foo.com/api/path"),
        "Initial request should be a full URL as per RFC 7230 when sent to a proxy; actual: "
            + request.getRequestLine());
    assertNotNull(request.getRequestUrl(), "Recorded request must have an URL");
    assertEquals(
        "localhost",
        request.getRequestUrl().host(),
        "Proxy request should be sent to the proxy host");
    assertEquals(
        mockProxy.getPort(),
        request.getRequestUrl().port(),
        "Proxy request should be sent to the proxy port");
    assertEquals(
        "/", request.getRequestUrl().encodedPath(), "Initial request should have the proxy path");

    RecordedRequest noMoreRequest = mockProxy.takeRequest(5, TimeUnit.SECONDS);
    assertNull(noMoreRequest, "Proxy should not receive more than 1 request for the same call");
  }
}
