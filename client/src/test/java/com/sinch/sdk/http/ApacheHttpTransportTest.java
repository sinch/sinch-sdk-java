package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.models.TransportSettings;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class ApacheHttpTransportTest {

  private MockWebServer server;
  private ApacheHttpTransport transport;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
    transport = new ApacheHttpTransport(null, TransportSettings.DEFAULT_TIMEOUT_SECONDS);
  }

  @AfterEach
  void tearDown() throws IOException {
    transport.close();
    server.shutdown();
  }

  @ParameterizedTest
  @EnumSource(HttpMethod.class)
  void sendsTheMethod(HttpMethod method) throws Exception {
    server.enqueue(new MockResponse().setResponseCode(204));

    try (HttpResponse response = transport.send(request(method).build())) {
      assertEquals(204, response.getStatus());
    }
    assertEquals(method.name(), server.takeRequest().getMethod());
  }

  @Test
  void sendsTheQueryParametersAsIs() throws Exception {
    server.enqueue(new MockResponse());

    transport
        .send(
            request(HttpMethod.GET)
                .setQueryParameters("?pageSize=5&number=%2B1234&a=b%20c")
                .build())
        .close();

    assertEquals(
        "/v1/projects/P1/activeNumbers?pageSize=5&number=%2B1234&a=b%20c",
        server.takeRequest().getPath());
  }

  @Test
  void sendsEveryHeaderValueInOrder() throws Exception {
    server.enqueue(new MockResponse());

    transport
        .send(
            request(HttpMethod.GET)
                .setHeaders(
                    new HttpHeaders()
                        .add("X-Multi", "first")
                        .add("Accept", "application/json")
                        .add("x-multi", "second"))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals(Arrays.asList("first", "second"), recorded.getHeaders().values("X-Multi"));
    assertEquals("application/json", recorded.getHeader("Accept"));
  }

  @Test
  void sendsStringContentWithTheContentTypeCharset() throws Exception {
    server.enqueue(new MockResponse());
    String body = "{\"text\":\"café\"}";

    transport
        .send(
            request(HttpMethod.POST)
                .setHeaders(
                    new HttpHeaders().add("Content-Type", "application/json; charset=ISO-8859-1"))
                .setContent(HttpContent.ofString(body))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals("application/json; charset=ISO-8859-1", recorded.getHeader("Content-Type"));
    assertArrayEquals(
        body.getBytes(StandardCharsets.ISO_8859_1), recorded.getBody().readByteArray());
  }

  @Test
  void sendsStringContentAsUtf8ByDefault() throws Exception {
    server.enqueue(new MockResponse());
    String body = "{\"text\":\"café\"}";

    transport
        .send(
            request(HttpMethod.PUT)
                .setHeaders(new HttpHeaders().add("Content-Type", "application/json"))
                .setContent(HttpContent.ofString(body))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals("application/json", recorded.getHeader("Content-Type"));
    assertEquals(body, recorded.getBody().readUtf8());
  }

  @Test
  void sendsBytesContentUntouched() throws Exception {
    server.enqueue(new MockResponse());
    byte[] body = {(byte) 0xff, (byte) 0xd8, (byte) 0xff, (byte) 0xe0, 0, 0x10};

    transport
        .send(
            request(HttpMethod.PATCH)
                .setHeaders(new HttpHeaders().add("Content-Type", "image/jpeg"))
                .setContent(HttpContent.ofBytes(body))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals("image/jpeg", recorded.getHeader("Content-Type"));
    assertArrayEquals(body, recorded.getBody().readByteArray());
  }

  @Test
  void sendsFileContent(@TempDir File directory) throws Exception {
    server.enqueue(new MockResponse());
    File file = new File(directory, "photo.bin");
    byte[] body = {1, 2, 3, (byte) 0xff};
    Files.write(file.toPath(), body);

    transport
        .send(
            request(HttpMethod.POST)
                .setHeaders(new HttpHeaders().add("Content-Type", "application/octet-stream"))
                .setContent(HttpContent.ofFile(file))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals("application/octet-stream", recorded.getHeader("Content-Type"));
    assertArrayEquals(body, recorded.getBody().readByteArray());
  }

  @Test
  void sendsFormDataWithTheBoundaryContentType() throws Exception {
    server.enqueue(new MockResponse());
    Map<String, Object> parameters = new LinkedHashMap<>();
    parameters.put("to", "someone@adomain.com");
    parameters.put("text", "Hello from Sinch");
    parameters.put("tags", Arrays.asList("a", "b"));
    parameters.put("attachment", new byte[] {1, 2});

    transport
        .send(
            request(HttpMethod.POST)
                .setHeaders(new HttpHeaders().add("Content-Type", "multipart/form-data"))
                .setContent(HttpContent.ofFormData(parameters))
                .build())
        .close();

    RecordedRequest recorded = server.takeRequest();
    assertEquals(1, recorded.getHeaders().values("Content-Type").size());
    String contentType = recorded.getHeader("Content-Type");
    assertTrue(contentType.startsWith("multipart/form-data"), contentType);
    String boundary = contentType.replaceAll(".*boundary=", "");
    String body = recorded.getBody().readUtf8();
    assertTrue(body.contains("--" + boundary), body);
    assertTrue(body.contains("name=\"to\""), body);
    assertTrue(body.contains("someone@adomain.com"), body);
    assertTrue(body.contains("Hello from Sinch"), body);
    assertEquals(2, body.split("name=\"tags\"", -1).length - 1, body);
    assertTrue(body.contains("name=\"attachment\""), body);
    assertTrue(body.trim().endsWith("--" + boundary + "--"), body);
  }

  @Test
  void receivesStatusReasonAndHeaders() throws Exception {
    server.enqueue(
        new MockResponse()
            .setStatus("HTTP/1.1 404 Not Here")
            .addHeader("Content-Type", "application/json")
            .addHeader("X-Multi", "first")
            .addHeader("X-Multi", "second"));

    try (HttpResponse response = transport.send(request(HttpMethod.GET).build())) {
      assertEquals(404, response.getStatus());
      assertEquals("Not Here", response.getReasonPhrase().orElse(null));
      assertEquals(Arrays.asList("first", "second"), response.getHeaders().getAll("x-multi"));
      assertEquals("application/json", response.getHeaders().getFirst("content-type").get());
    }
  }

  @Test
  void receivesBinaryContentUntouched() throws Exception {
    byte[] body = {(byte) 0xff, (byte) 0xfe, 0, (byte) 0x80, 0x7f};
    server.enqueue(
        new MockResponse()
            .setHeader("Content-Type", "application/octet-stream")
            .setBody(new Buffer().write(body)));

    try (HttpResponse response = transport.send(request(HttpMethod.GET).build())) {
      assertArrayEquals(body, response.getContent().asBytes());
    }
  }

  @Test
  void receivesTextContentInItsCharset() throws Exception {
    String text = "Ünïcödé résülts";
    server.enqueue(
        new MockResponse()
            .setHeader("Content-Type", "text/plain; charset=ISO-8859-1")
            .setBody(new Buffer().write(text.getBytes(StandardCharsets.ISO_8859_1))));

    try (HttpResponse response = transport.send(request(HttpMethod.GET).build())) {
      assertEquals(text, response.getContent().asString());
    }
  }

  @Test
  void receivesJsonContentAsMap() throws Exception {
    server.enqueue(
        new MockResponse()
            .setHeader("Content-Type", "application/json")
            .setBody("{\"recipient\":{\"phoneNumber\":\"+1234\"}}"));

    try (HttpResponse response = transport.send(request(HttpMethod.GET).build())) {
      assertEquals(
          Collections.singletonMap("phoneNumber", "+1234"),
          response.getContent().asMap().get("recipient"));
    }
  }

  @Test
  void receivesNoContent() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(204));

    try (HttpResponse response = transport.send(request(HttpMethod.DELETE).build())) {
      assertEquals("", response.getContent().asString());
      assertEquals(0, response.getContent().asBytes().length);
    }
  }

  @Test
  void timeoutIsApplied() throws Exception {
    try (ApacheHttpTransport shortTimeout = new ApacheHttpTransport(null, 1)) {
      server.enqueue(new MockResponse().setHeadersDelay(3, TimeUnit.SECONDS));

      assertThrows(
          SocketTimeoutException.class, () -> shortTimeout.send(request(HttpMethod.GET).build()));
    }
  }

  @Test
  void closedTransportRefusesToSend() throws Exception {
    transport.close();
    transport.close();

    assertThrows(IOException.class, () -> transport.send(request(HttpMethod.GET).build()));
  }

  private HttpRequest.Builder request(HttpMethod method) {
    return HttpRequest.builder()
        .setMethod(method)
        .setUrl(server.url("/v1/projects/P1/activeNumbers").toString());
  }
}
