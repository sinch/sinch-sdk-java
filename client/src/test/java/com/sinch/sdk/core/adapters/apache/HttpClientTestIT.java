package com.sinch.sdk.core.adapters.apache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.auth.AuthManager;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
class HttpClientTestIT extends BaseTest {
  static MockWebServer mockBackEnd;

  @GivenTextResource("/client/auth/BearerAuthResponse.json")
  String jsonResponse;

  String serverUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
  Configuration configuration =
      Configuration.builder().setOAuthUrl(String.format("%s/auth", serverUrl)).build();

  AuthManager basicAuthManager = new BasicAuthManager(configuration);
  BearerAuthManager bearerAuthManager = new BearerAuthManager(configuration, new HttpMapper());

  Map<String, AuthManager> authManagers =
      Stream.of(basicAuthManager, bearerAuthManager)
          .map(e -> new AbstractMap.SimpleEntry<>(e.getSchema(), e))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  HttpClientApache httpClient = new HttpClientApache(authManagers);

  @BeforeAll
  static void classSetUp() throws IOException {
    mockBackEnd = new MockWebServer();
    mockBackEnd.start();
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockBackEnd.shutdown();
  }

  @BeforeEach
  void testSetUp() {
    bearerAuthManager.setHttpClient(httpClient);
  }

  @Test
  void basicAuthorization() throws InterruptedException {

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));
    httpClient.invokeAPI(
        new ServerConfiguration(String.format("%s/foo", serverUrl)),
        new HttpRequest(
            "foo-path",
            HttpMethod.GET,
            null,
            null,
            null,
            null,
            null,
            Collections.singletonList(basicAuthManager.getSchema())));
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    String header = recordedRequest.getHeader("Authorization");

    assertTrue(header.startsWith("Basic "));
  }

  @Test
  void initialBearerAuthorization() throws InterruptedException {
    mockBackEnd.enqueue(
        new MockResponse().setBody(jsonResponse).addHeader("Content-Type", "application/json"));
    mockBackEnd.enqueue(
        new MockResponse().setBody("foo3").addHeader("Content-Type", "application/json"));
    httpClient.invokeAPI(
        new ServerConfiguration(String.format("%s/foo", serverUrl)),
        new HttpRequest(
            "foo-path",
            HttpMethod.GET,
            null,
            null,
            null,
            null,
            null,
            Collections.singletonList(bearerAuthManager.getSchema())));

    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    String header = recordedRequest.getHeader("Authorization");
    assertTrue(header.startsWith("Basic "));
    assertEquals("/auth", recordedRequest.getPath());
    // unused for this test: but to flush mocked backend request stack and avoid cross tests issue
    mockBackEnd.takeRequest();
  }

  @Test
  void bearerAutoRefresh() throws InterruptedException {
    // return valid token
    mockBackEnd.enqueue(
        new MockResponse().setBody(jsonResponse).addHeader("Content-Type", "application/json"));
    // return unauthorized
    mockBackEnd.enqueue(
        new MockResponse()
            .setResponseCode(HttpStatus.UNAUTHORIZED)
            .setBody("foo2")
            .addHeader("www-authenticate", "token invalid: expired")
            .addHeader("Content-Type", "application/json"));
    // return valid token
    mockBackEnd.enqueue(
        new MockResponse()
            .setBody(jsonResponse.replace("token value", "another token"))
            .addHeader("Content-Type", "application/json"));
    // return a body
    mockBackEnd.enqueue(
        new MockResponse().setBody("foo3").addHeader("Content-Type", "application/json"));
    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          new HttpRequest(
              "foo-path",
              HttpMethod.GET,
              null,
              null,
              null,
              null,
              null,
              Collections.singletonList(bearerAuthManager.getSchema())));
    } catch (ApiException ae) {
      // noop
    }
    // should have requested a token (because of not yet retrieved when service is started)
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    assertEquals("/auth", recordedRequest.getPath());
    String header = recordedRequest.getHeader("Authorization");
    // auth is using Basic authentication
    assertTrue(header.startsWith("Basic "));

    // should have requested the original endpoint but with a token now
    recordedRequest = mockBackEnd.takeRequest();
    assertEquals("/foo/foo-path", recordedRequest.getPath());
    header = recordedRequest.getHeader("Authorization");
    assertEquals(header, "Bearer token value");

    // should have requested another token because the second request triggered an "expired" one
    recordedRequest = mockBackEnd.takeRequest();
    assertEquals("/auth", recordedRequest.getPath());
    header = recordedRequest.getHeader("Authorization");
    assertTrue(header.startsWith("Basic "));

    recordedRequest = mockBackEnd.takeRequest();
    assertEquals("/foo/foo-path", recordedRequest.getPath());
    header = recordedRequest.getHeader("Authorization");
    assertEquals(header, "Bearer another token");
  }
}
