package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import com.sinch.sdk.models.TransportSettings;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class DefaultSinchHttpClientTest {

  private static final String TOKEN_RESPONSE =
      "{\"access_token\":\"%s\",\"expires_in\":3600,\"token_type\":\"bearer\"}";

  private MockWebServer server;
  private SinchClient sinchClient;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    if (null != sinchClient) {
      sinchClient.close();
    }
    server.shutdown();
  }

  @Test
  void getSendsTheUrlTheQueryAndTheHeadersAsIs() throws Exception {
    enqueueToken("first");
    server.enqueue(json(200, "{\"activeNumbers\":[{\"phoneNumber\":\"+12015555555\"}]}"));

    HttpResponse response =
        client(configuration())
            .get(
                url("/v1/projects/P1/activeNumbers"),
                HttpCallParameters.builder()
                    .setQueryParameters("?regionCode=US&number=%2B1234")
                    .setHeaders(new HttpHeaders().set("accept", "application/json"))
                    .build());

    assertEquals(200, response.getStatus());
    assertEquals(
        Collections.singletonList(Collections.singletonMap("phoneNumber", "+12015555555")),
        response.getContent().asMap().get("activeNumbers"));

    RecordedRequest token = server.takeRequest();
    assertEquals("/oauth2/token", token.getPath());

    RecordedRequest request = server.takeRequest();
    assertEquals("GET", request.getMethod());
    assertEquals("/v1/projects/P1/activeNumbers?regionCode=US&number=%2B1234", request.getPath());
    assertEquals("application/json", request.getHeader("accept"));
    assertEquals("Bearer first", request.getHeader("Authorization"));
  }

  @Test
  void projectIdIsNotRequired() throws Exception {
    enqueueToken("first");
    server.enqueue(json(200, "{}"));

    Configuration configuration =
        Configuration.builder()
            .setKeyId("keyId")
            .setKeySecret("keySecret")
            .setOAuthUrl(url("/oauth2/token"))
            .build();

    assertEquals(200, client(configuration).get(url("/v1/foo")).getStatus());
  }

  @Test
  void userAgentFlagsTheHttpClientAndReplacesTheCallerOne() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .get(
            url("/v1/foo"),
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("user-agent", "caller"))
                .build());

    RecordedRequest request = server.takeRequest();
    assertEquals(1, request.getHeaders().values("User-Agent").size());
    assertTrue(
        request.getHeader("User-Agent").matches("^sinch-sdk/.* \\(Java/.*; Apache; .*,http\\)$"),
        request.getHeader("User-Agent"));
  }

  @Test
  void queryParametersWithoutTheQuestionMarkArePrefixed() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .get(
            url("/v1/foo"),
            HttpCallParameters.builder().setQueryParameters("regionCode=US").build());

    assertEquals("/v1/foo?regionCode=US", server.takeRequest().getPath());
  }

  @Test
  void queryParametersOfTheUrlAreSentAsIs() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth()).get(url("/v1/foo?regionCode=US&a=b%20c"));

    assertEquals("/v1/foo?regionCode=US&a=b%20c", server.takeRequest().getPath());
  }

  @Test
  void queryParametersSetTwiceAreRejected() {
    SinchHttpClient client = client(withoutAuth());
    HttpCallParameters parameters = HttpCallParameters.builder().setQueryParameters("?b=2").build();

    assertThrows(IllegalArgumentException.class, () -> client.get(url("/v1/foo?a=1"), parameters));
    assertEquals(0, server.getRequestCount());
  }

  @Test
  void noAuthorizationWhenTheClientDisablesIt() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .get(
            url("/v1/foo"),
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("Authorization", "Bearer sms-api-token"))
                .build());

    assertEquals(1, server.getRequestCount());
    assertEquals("Bearer sms-api-token", server.takeRequest().getHeader("Authorization"));
  }

  @Test
  void aCallEnablesTheAuthenticationDisabledByTheClient() throws Exception {
    enqueueToken("first");
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .get(url("/v1/foo"), withOptions(HttpRequestOptions.builder().setUseSinchAuth(true)));

    assertEquals("/oauth2/token", server.takeRequest().getPath());
    assertEquals("Bearer first", server.takeRequest().getHeader("Authorization"));
  }

  @Test
  void aCallDisablesTheAuthenticationEnabledByTheClient() throws Exception {
    server.enqueue(json(200, "{}"));

    client(configuration())
        .get(url("/v1/foo"), withOptions(HttpRequestOptions.builder().setUseSinchAuth(false)));

    assertEquals(1, server.getRequestCount());
    assertNull(server.takeRequest().getHeader("Authorization"));
  }

  @Test
  void anAuthenticatedCallRequiresTheKeys() {
    SinchHttpClient client =
        client(Configuration.builder().setOAuthUrl(url("/oauth2/token")).build());

    RuntimeException e = assertThrows(RuntimeException.class, () -> client.get(url("/v1/foo")));

    assertTrue(e.getMessage().startsWith("HTTP client requires"), e.getMessage());
    assertEquals(0, server.getRequestCount());
  }

  @Test
  void theTokenIsCachedAcrossCalls() throws Exception {
    enqueueToken("first");
    server.enqueue(json(200, "{}"));
    server.enqueue(json(200, "{}"));

    SinchHttpClient client = client(configuration());
    client.get(url("/v1/foo"));
    client.get(url("/v1/bar"));

    assertEquals(3, server.getRequestCount());
  }

  @Test
  void anExpiredTokenIsRefreshedAndTheRequestSentAgain() throws Exception {
    enqueueToken("first");
    server.enqueue(
        new MockResponse()
            .setResponseCode(401)
            .addHeader("WWW-Authenticate", "Bearer error=\"invalid_token\", error=\"expired\""));
    enqueueToken("second");
    server.enqueue(json(200, "{}"));

    HttpResponse response = client(configuration()).delete(url("/v1/foo"));

    assertEquals(200, response.getStatus());
    server.takeRequest();
    assertEquals("Bearer first", server.takeRequest().getHeader("Authorization"));
    server.takeRequest();
    RecordedRequest retried = server.takeRequest();
    assertEquals("DELETE", retried.getMethod());
    assertEquals("Bearer second", retried.getHeader("Authorization"));
  }

  @Test
  void anUnauthorizedResponseWithoutExpiredTokenIsThrown() {
    enqueueToken("first");
    server.enqueue(new MockResponse().setResponseCode(401));

    ApiHttpException e =
        assertThrows(ApiHttpException.class, () -> client(configuration()).get(url("/v1/foo")));

    assertEquals(401, e.getCode());
    assertEquals(2, server.getRequestCount());
  }

  @Test
  void textBodyIsEncodedWithTheContentTypeCharset() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .post(
            url("/v1/foo"),
            "{\"text\":\"é\"}",
            HttpCallParameters.builder()
                .setHeaders(
                    new HttpHeaders().set("content-type", "application/json; charset=ISO-8859-1"))
                .build());

    RecordedRequest request = server.takeRequest();
    assertEquals("application/json; charset=ISO-8859-1", request.getHeader("Content-Type"));
    assertArrayEquals(
        "{\"text\":\"é\"}".getBytes(StandardCharsets.ISO_8859_1),
        request.getBody().readByteArray());
  }

  @Test
  void aTextBodyRequiresTheContentType() {
    SinchHttpClient client = client(withoutAuth());

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> client.post(url("/v1/foo"), "{}", null));

    assertTrue(e.getMessage().contains("content-type"), e.getMessage());
    assertEquals(0, server.getRequestCount());
  }

  @Test
  void aBinaryBodyRequiresTheContentType() {
    SinchHttpClient client = client(withoutAuth());
    HttpCallParameters parameters =
        HttpCallParameters.builder()
            .setHeaders(new HttpHeaders().set("accept", "application/json"))
            .build();

    assertThrows(
        IllegalArgumentException.class,
        () -> client.put(url("/v1/foo"), new byte[] {1}, parameters));
    assertEquals(0, server.getRequestCount());
  }

  @Test
  void aFileBodyRequiresANonBlankContentType(@TempDir File directory) throws Exception {
    SinchHttpClient client = client(withoutAuth());
    File file = new File(directory, "photo.jpg");
    Files.write(file.toPath(), new byte[] {1});
    HttpCallParameters parameters =
        HttpCallParameters.builder().setHeaders(new HttpHeaders().set("content-type", " ")).build();

    assertThrows(
        IllegalArgumentException.class, () -> client.patch(url("/v1/foo"), file, parameters));
    assertEquals(0, server.getRequestCount());
  }

  @Test
  void textBodyIsEncodedInUtf8ByDefault() throws Exception {
    server.enqueue(json(200, "{}"));

    client(withoutAuth())
        .put(
            url("/v1/foo"),
            "{\"text\":\"é\"}",
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("content-type", "application/json"))
                .build());

    RecordedRequest request = server.takeRequest();
    assertEquals("PUT", request.getMethod());
    assertEquals("{\"text\":\"é\"}", request.getBody().readUtf8());
  }

  @Test
  void binaryBodyIsSentAsIs() throws Exception {
    server.enqueue(json(200, "{}"));
    byte[] body = new byte[] {(byte) 0xff, (byte) 0xd8, 0x00, 0x10};

    client(withoutAuth())
        .patch(
            url("/v1/foo"),
            body,
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("content-type", "image/jpeg"))
                .build());

    RecordedRequest request = server.takeRequest();
    assertEquals("PATCH", request.getMethod());
    assertEquals("image/jpeg", request.getHeader("Content-Type"));
    assertArrayEquals(body, request.getBody().readByteArray());
  }

  @Test
  void fileBodyIsSentAsIs(@TempDir File directory) throws Exception {
    server.enqueue(json(200, "{}"));
    File file = new File(directory, "photo.jpg");
    Files.write(file.toPath(), new byte[] {1, 2, 3});

    client(withoutAuth())
        .post(
            url("/v1/foo"),
            file,
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("content-type", "image/jpeg"))
                .build());

    assertArrayEquals(new byte[] {1, 2, 3}, server.takeRequest().getBody().readByteArray());
  }

  @Test
  void formDataIsSentAsMultipart() throws Exception {
    server.enqueue(json(200, "{}"));
    Map<String, Object> form = new LinkedHashMap<>();
    form.put("to", "someone@adomain.com");
    form.put("text", "Hello from Sinch");

    client(withoutAuth())
        .postFormData(
            url("/v1/foo"),
            form,
            HttpCallParameters.builder()
                .setHeaders(new HttpHeaders().set("content-type", "application/json"))
                .build());

    RecordedRequest request = server.takeRequest();
    String contentType = request.getHeader("Content-Type");
    assertTrue(
        contentType.startsWith("multipart/form-data;") && contentType.contains("boundary="),
        contentType);
    String body = request.getBody().readUtf8();
    assertTrue(
        body.matches("(?s).*name=\"to\"\r\n(?:[^\r\n]+\r\n)*\r\nsomeone@adomain.com\r\n.*"), body);
    assertTrue(
        body.matches("(?s).*name=\"text\"\r\n(?:[^\r\n]+\r\n)*\r\nHello from Sinch\r\n.*"), body);
  }

  @Test
  void anErrorStatusIsThrownWithTheMessageOfASinchError() throws Exception {
    server.enqueue(
        json(
            404,
            "{\"error\":{\"code\":404,\"message\":\"Number +1234 not"
                + " found\",\"status\":\"NOT_FOUND\"}}"));

    ApiHttpException e =
        assertThrows(ApiHttpException.class, () -> client(withoutAuth()).get(url("/v1/foo")));

    assertEquals(404, e.getCode());
    assertEquals("NOT_FOUND: Number +1234 not found", e.getMessage());
    assertEquals(404, e.getResponse().getStatus());
    assertTrue(e.getResponse().getContent().asString().contains("NOT_FOUND"));
  }

  @Test
  void anErrorStatusWithoutSinchErrorIsThrownWithTheStatus() {
    server.enqueue(new MockResponse().setResponseCode(503).setBody("unavailable"));

    ApiHttpException e =
        assertThrows(ApiHttpException.class, () -> client(withoutAuth()).get(url("/v1/foo")));

    assertEquals(503, e.getCode());
    assertTrue(e.getMessage().startsWith("HTTP 503"), e.getMessage());
    assertEquals("unavailable", e.getResponse().getContent().asString());
  }

  @Test
  void aRateLimitedResponseIsRetriedUnderTheClientPolicy() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "0"));
    server.enqueue(json(200, "{}"));

    Configuration configuration =
        Configuration.builder(withoutAuth())
            .setRetryConfiguration(RetryConfiguration.builder().setMaxRetryCount(1).build())
            .build();

    assertEquals(200, client(configuration).get(url("/v1/foo")).getStatus());
    assertEquals(2, server.getRequestCount());
  }

  @Test
  void aCallReplacesTheRetryPolicy() {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "0"));
    server.enqueue(json(200, "{}"));

    Configuration configuration =
        Configuration.builder(withoutAuth())
            .setRetryConfiguration(RetryConfiguration.builder().setMaxRetryCount(1).build())
            .build();
    HttpCallParameters parameters =
        withOptions(
            HttpRequestOptions.builder()
                .setRetryConfiguration(
                    RetryConfiguration.builder().setRetryPolicy(RetryPolicy.NONE).build()));

    ApiHttpException e =
        assertThrows(
            ApiHttpException.class, () -> client(configuration).get(url("/v1/foo"), parameters));

    assertEquals(429, e.getCode());
    assertEquals(1, server.getRequestCount());
  }

  @Test
  void aCallReplacesTheTimeout() {
    server.enqueue(json(200, "{}").setHeadersDelay(3, TimeUnit.SECONDS));

    HttpCallParameters parameters = withOptions(HttpRequestOptions.builder().setTimeoutSeconds(1));

    ApiException e =
        assertThrows(
            ApiException.class, () -> client(withoutAuth()).get(url("/v1/foo"), parameters));

    assertFalse(e instanceof ApiHttpException);
    assertInstanceOf(SocketTimeoutException.class, e.getCause());
  }

  @Test
  void aNegativeTimeoutIsRejected() {
    HttpRequestOptions.Builder builder = HttpRequestOptions.builder().setTimeoutSeconds(-1);

    assertThrows(IllegalArgumentException.class, builder::build);
  }

  @Test
  void parametersCopyTheHeaders() {
    HttpHeaders headers = new HttpHeaders().set("accept", "application/json");
    HttpCallParameters parameters = HttpCallParameters.builder().setHeaders(headers).build();

    headers.set("accept", "text/plain");
    parameters.getHeaders().get().set("accept", "image/png");

    assertEquals("application/json", parameters.getHeaders().get().getFirst("accept").get());
  }

  @Test
  void headersCanBeSetFromAMap() throws Exception {
    server.enqueue(json(200, "{}"));
    Map<String, String> headers = new LinkedHashMap<>();
    headers.put("accept", "application/json");
    headers.put("x-ignored", null);

    client(withoutAuth())
        .get(url("/v1/foo"), HttpCallParameters.builder().setHeaders(headers).build());

    RecordedRequest request = server.takeRequest();
    assertEquals("application/json", request.getHeader("accept"));
    assertNull(request.getHeader("x-ignored"));
  }

  @Test
  void nullFormDataValuesAreOmitted() throws Exception {
    server.enqueue(json(200, "{}"));
    Map<String, Object> form = new LinkedHashMap<>();
    form.put("to", "someone@adomain.com");
    form.put("cc", null);

    client(withoutAuth()).postFormData(url("/v1/foo"), form, null);

    String body = server.takeRequest().getBody().readUtf8();
    assertTrue(body.contains("name=\"to\""), body);
    assertFalse(body.contains("name=\"cc\""), body);
  }

  private SinchHttpClient client(Configuration configuration) {
    sinchClient = new SinchClient(configuration);
    return sinchClient.http();
  }

  private Configuration configuration() {
    return Configuration.builder()
        .setKeyId("keyId")
        .setKeySecret("keySecret")
        .setOAuthUrl(url("/oauth2/token"))
        .build();
  }

  private Configuration withoutAuth() {
    return Configuration.builder(configuration())
        .setTransportSettings(TransportSettings.builder().setUseSinchAuth(false).build())
        .build();
  }

  private static HttpCallParameters withOptions(HttpRequestOptions.Builder options) {
    return HttpCallParameters.builder().setOptions(options.build()).build();
  }

  private String url(String path) {
    return server.url(path).toString();
  }

  private void enqueueToken(String token) {
    server.enqueue(json(200, String.format(TOKEN_RESPONSE, token)));
  }

  private static MockResponse json(int status, String body) {
    return new MockResponse()
        .setResponseCode(status)
        .addHeader("Content-Type", "application/json")
        .setBody(body);
  }
}
