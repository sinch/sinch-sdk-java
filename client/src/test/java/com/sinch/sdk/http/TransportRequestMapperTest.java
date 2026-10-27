package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.transport.BufferedHttpContentParser;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class TransportRequestMapperTest {

  private static final ServerConfiguration SERVER =
      new ServerConfiguration("https://numbers.api.sinch.com");

  @Test
  void pathIsRelativeToTheServer() {
    HttpRequest request =
        TransportRequestMapper.toTransportRequest(
            SERVER, serviceRequest("/v1/projects/P1/activeNumbers", null), null, null);

    assertEquals(HttpMethod.GET, request.getMethod());
    assertEquals("https://numbers.api.sinch.com/v1/projects/P1/activeNumbers", request.getUrl());
    assertEquals(Optional.empty(), request.getQueryParameters());
    assertEquals(Optional.empty(), request.getContent());
  }

  @Test
  void queryParametersAreEncoded() {
    HttpRequest request =
        TransportRequestMapper.toTransportRequest(
            SERVER,
            serviceRequest(
                "/v1/projects/P1/activeNumbers",
                Arrays.asList(
                    new URLParameter("pageSize", 5),
                    new URLParameter("numberPattern.pattern", "+1 23"))),
            null,
            null);

    assertEquals("https://numbers.api.sinch.com/v1/projects/P1/activeNumbers", request.getUrl());
    assertEquals(
        Optional.of("?pageSize=5&numberPattern%2Epattern=%2B1+23"), request.getQueryParameters());
  }

  @Test
  void fullUrlQueryIsSplit() {
    com.sinch.sdk.core.http.HttpRequest serviceRequest =
        new com.sinch.sdk.core.http.HttpRequest(
            "https://calling.api.sinch.com/v2/calls?page=2&pageSize=10",
            HttpMethod.GET,
            null,
            null,
            null,
            null,
            null);

    HttpRequest request =
        TransportRequestMapper.toTransportRequest(SERVER, serviceRequest, null, null);

    assertEquals("https://calling.api.sinch.com/v2/calls", request.getUrl());
    assertEquals(Optional.of("?page=2&pageSize=10"), request.getQueryParameters());
  }

  @Test
  void headersAreSetInOrderTheLaterOnesWinning() {
    Map<String, String> headerParams = new HashMap<>();
    headerParams.put("Idempotency-Key", "key");
    headerParams.put("accept", "text/plain");
    Map<String, String> additionalHeaders = Collections.singletonMap("User-Agent", "sdk");

    com.sinch.sdk.core.http.HttpRequest serviceRequest =
        new com.sinch.sdk.core.http.HttpRequest(
            "/v1/foo",
            HttpMethod.POST,
            null,
            "{}",
            headerParams,
            Arrays.asList("application/json", "application/problem+json"),
            Collections.singletonList("application/json; charset=utf-8"),
            null);

    HttpRequest request =
        TransportRequestMapper.toTransportRequest(
            SERVER, serviceRequest, headerParams, additionalHeaders);

    HttpHeaders headers = request.getHeaders();
    assertEquals(Collections.singletonList("text/plain"), headers.getAll("Accept"));
    assertEquals(Optional.of("key"), headers.getFirst("Idempotency-Key"));
    assertEquals(Optional.of("sdk"), headers.getFirst("User-Agent"));
    assertEquals(Optional.of("application/json; charset=utf-8"), headers.getFirst("Content-Type"));
    assertEquals("{}", ((HttpContent.StringContent) request.getContent().get()).getValue());
  }

  @Test
  void acceptValuesAreJoined() {
    com.sinch.sdk.core.http.HttpRequest serviceRequest =
        new com.sinch.sdk.core.http.HttpRequest(
            "/v1/foo",
            HttpMethod.GET,
            null,
            (String) null,
            null,
            Arrays.asList("application/json", "application/problem+json"),
            Collections.singletonList("application/json"),
            null);

    HttpRequest request =
        TransportRequestMapper.toTransportRequest(SERVER, serviceRequest, null, null);

    assertEquals(
        Optional.of("application/json,application/problem+json"),
        request.getHeaders().getFirst("Accept"));
    // no content: no content type
    assertFalse(request.getHeaders().contains("Content-Type"));
  }

  @Test
  void formParamsAreFormData() {
    Map<String, Object> formParams = Collections.singletonMap("to", "someone@adomain.com");
    com.sinch.sdk.core.http.HttpRequest serviceRequest =
        new com.sinch.sdk.core.http.HttpRequest(
            "/v1/foo",
            HttpMethod.POST,
            null,
            formParams,
            null,
            null,
            Collections.singletonList("multipart/form-data"),
            null);

    HttpRequest request =
        TransportRequestMapper.toTransportRequest(SERVER, serviceRequest, null, null);

    assertEquals(
        formParams, ((HttpContent.FormDataContent) request.getContent().get()).getParameters());
    assertFalse(request.getHeaders().contains("Content-Type"));
  }

  @Test
  void authorizationPathIsTheEncodedPathAndQuery() {
    assertEquals(
        "/v1/a%20b/c?x=1&y=%2B2",
        TransportRequestMapper.authorizationPath(
            HttpRequest.builder()
                .setMethod(HttpMethod.GET)
                .setUrl("https://foo.com/v1/a%20b/c")
                .setQueryParameters("?x=1&y=%2B2")
                .build()));
    assertEquals(
        "/",
        TransportRequestMapper.authorizationPath(
            HttpRequest.builder().setMethod(HttpMethod.GET).setUrl("https://foo.com").build()));
  }

  @Test
  void responseIsMapped() throws IOException {
    byte[] content = "{\"a\":\"é\"}".getBytes(StandardCharsets.UTF_8);
    HttpResponse response =
        new HttpResponse(
            201,
            "Created",
            new HttpHeaders()
                .add("Content-Type", "application/json")
                .add("X-A", "1")
                .add("x-a", "2"),
            new BufferedHttpContentParser(content, "application/json"));

    com.sinch.sdk.core.http.HttpResponse mapped =
        TransportRequestMapper.toServiceResponse(response);

    assertEquals(201, mapped.getCode());
    assertEquals("Created", mapped.getMessage());
    assertEquals(
        Collections.singletonList("application/json"), mapped.getHeaders().get("Content-Type"));
    assertEquals(Arrays.asList("1", "2"), mapped.getHeaders().get("X-A"));
    try (InputStream in = mapped.getContent()) {
      byte[] read = new byte[content.length + 1];
      assertEquals(content.length, in.read(read));
    }
  }

  @Test
  void responseWithoutReasonPhraseHasAnEmptyMessage() {
    com.sinch.sdk.core.http.HttpResponse mapped =
        TransportRequestMapper.toServiceResponse(
            new HttpResponse(
                200, null, new HttpHeaders(), new BufferedHttpContentParser(null, null)));

    assertEquals("", mapped.getMessage());
  }

  private static com.sinch.sdk.core.http.HttpRequest serviceRequest(
      String path, java.util.List<URLParameter> queryParameters) {
    return new com.sinch.sdk.core.http.HttpRequest(
        path, HttpMethod.GET, queryParameters, (String) null, null, null, null, null);
  }
}
