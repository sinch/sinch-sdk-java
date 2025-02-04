package com.sinch.sdk.core.adapters.apache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.auth.adapters.BasicAuthManager;
import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.UnifiedCredentials;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@TestWithResources
class HttpClientTestIT extends BaseTest {

  static final String regExpBoundaryMarker = "--";
  static final String regExpBoundaryItem =
      "^.*(\\s)*"
          + "Content-Disposition: form-data; name=\"%s\"(\\s)*"
          + "Content-Type: text/plain; charset=UTF-8(\\s)*"
          + "%s(\\s)*$";
  static MockWebServer mockBackEnd;

  @GivenTextResource("/client/auth/BearerAuthResponse.json")
  String jsonResponse;

  String serverUrl = String.format("http://localhost:%s", mockBackEnd.getPort());
  UnifiedCredentials credentials = UnifiedCredentials.builder().build();
  ServerConfiguration server = new ServerConfiguration(String.format("%s/auth", serverUrl));
  HttpClientApache httpClient = new HttpClientApache();

  AuthManager basicAuthManager = new BasicAuthManager(credentials);
  OAuthManager oAuthManager =
      new OAuthManager(credentials, server, HttpMapper.getInstance(), () -> httpClient);

  Map<String, AuthManager> authManagers =
      Stream.of(basicAuthManager, oAuthManager)
          .map(e -> new AbstractMap.SimpleEntry<>(e.getSchema(), e))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

  @BeforeAll
  static void classSetUp() throws IOException {
    mockBackEnd = new MockWebServer();
    mockBackEnd.start();
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockBackEnd.shutdown();
  }

  @Test
  void basicAuthorization() throws InterruptedException {

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));
    httpClient.invokeAPI(
        new ServerConfiguration(String.format("%s/foo", serverUrl)),
        authManagers,
        new HttpRequest(
            "foo-path",
            HttpMethod.GET,
            null,
            (String) null,
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
        authManagers,
        new HttpRequest(
            "foo-path",
            HttpMethod.GET,
            null,
            (String) null,
            null,
            null,
            null,
            Collections.singletonList(oAuthManager.getSchema())));

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
          authManagers,
          new HttpRequest(
              "foo-path",
              HttpMethod.GET,
              null,
              (String) null,
              null,
              null,
              null,
              Collections.singletonList(oAuthManager.getSchema())));
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

  @Test
  void httpRequestUrlFromServerConfiguration() throws InterruptedException {

    mockBackEnd.enqueue(new MockResponse().setBody("@&"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest(
              "foo-path",
              HttpMethod.POST,
              null,
              "foo",
              null,
              null,
              Arrays.asList("application/json; charset=utf-8"),
              null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    HttpUrl url = recordedRequest.getRequestUrl();
    assertEquals(url.url().toExternalForm(), String.format("%s/foo/foo-path", serverUrl));
  }

  @Test
  void httpRequestUrlFromHttpRequest() throws InterruptedException {

    mockBackEnd.enqueue(new MockResponse().setBody("@&"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration("https://this-url-have-to-be-ignored.com"),
          null,
          new HttpRequest(
              String.format("%s/foo?query", serverUrl),
              HttpMethod.POST,
              null,
              null,
              null,
              Arrays.asList("application/json; charset=utf-8"),
              null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    HttpUrl url = recordedRequest.getRequestUrl();
    assertEquals(url.url().toExternalForm(), String.format("%s/foo?query", serverUrl));
  }

  @Test
  void httpRequestTextBody() throws InterruptedException {

    String sdkBody = "my body with Unicode characters: ✉";

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest(
              "foo-path",
              HttpMethod.POST,
              null,
              sdkBody,
              null,
              null,
              Arrays.asList("application/json; charset=utf-8"),
              null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    String payloadBody = recordedRequest.getBody().readString(StandardCharsets.UTF_8);
    assertEquals(payloadBody, sdkBody);
  }

  @Test
  void httpRequestFormParamsText() throws InterruptedException {

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    Map<String, Object> formParams =
        Collections.singletonMap("my key", "my value with unicode \uD83D\uDCE7");

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest("foo-path", HttpMethod.POST, null, formParams, null, null, null, null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    assertTrue(recordedRequest.getHeader("Content-Type").contains("multipart/form-data"));

    String payloadBody = recordedRequest.getBody().readString(StandardCharsets.UTF_8);
    String[] split = payloadBody.split(regExpBoundaryMarker);
    assertTrue(
        split[1].matches(
            String.format(regExpBoundaryItem, "my key", "my value with unicode \uD83D\uDCE7")));
  }

  @Test
  void httpRequestFormParamsArray() throws InterruptedException {

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    Map<String, Object> formParams =
        Collections.singletonMap("my key", Arrays.asList("my value 1", "my value 2"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest("foo-path", HttpMethod.POST, null, formParams, null, null, null, null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    assertTrue(recordedRequest.getHeader("Content-Type").contains("multipart/form-data"));
    String payloadBody = recordedRequest.getBody().readString(StandardCharsets.UTF_8);
    String[] split = payloadBody.split(regExpBoundaryMarker);
    assertTrue(split[1].matches(String.format(regExpBoundaryItem, "my key", "my value 1")));
    assertTrue(split[2].matches(String.format(regExpBoundaryItem, "my key", "my value 2")));
  }

  @Test
  void httpRequestFormParamsFile() throws InterruptedException {

    String content = "\uD83D\uDCE7 Sample content \uD83D\uDCE7";
    // create a temporary file to be sent
    File tempFile;
    try {
      tempFile = File.createTempFile("sinch-sdk-java", ".txt");
      tempFile.deleteOnExit();
      try (BufferedWriter out = new BufferedWriter(new FileWriter(tempFile))) {
        out.write(content);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    Map<String, Object> formParams = Collections.singletonMap("my key", Arrays.asList(tempFile));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest("foo-path", HttpMethod.POST, null, formParams, null, null, null, null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();

    assertTrue(recordedRequest.getHeader("Content-Type").contains("multipart/form-data"));
    String payloadBody = recordedRequest.getBody().readString(StandardCharsets.UTF_8);
    String[] split = payloadBody.split(regExpBoundaryMarker);
    assertTrue(split[1].contains(content));
  }

  @Test
  void httpRequestHeaders() throws InterruptedException {
    String key = "My-OAS-Header-Key";
    String value = "OAS Header Value";
    Map<String, String> httpRequest =
        Stream.of(new String[][] {{key, value}})
            .collect(Collectors.toMap(data -> data[0], data -> data[1]));

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest(
              "foo-path", HttpMethod.GET, null, (String) null, httpRequest, null, null, null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    String header = recordedRequest.getHeader(key);
    assertEquals(header, value);
  }

  @Test
  void sdkHeaders() throws InterruptedException {
    String key = "My-Sdk-Header-Key";
    String value = "SDK Header Value";
    httpClient.setRequestHeaders(
        Stream.of(new String[][] {{key, value}})
            .collect(Collectors.toMap(data -> data[0], data -> data[1])));

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    try {
      httpClient.invokeAPI(
          new ServerConfiguration(String.format("%s/foo/", serverUrl)),
          null,
          new HttpRequest("foo-path", HttpMethod.GET, null, (String) null, null, null, null, null));
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    String header = recordedRequest.getHeader(key);
    assertEquals(header, value);
  }
}
