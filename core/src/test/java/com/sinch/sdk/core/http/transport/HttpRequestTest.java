package com.sinch.sdk.core.http.transport;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class HttpRequestTest {

  @Test
  void build() {
    HttpContent content = HttpContent.ofString("{}");
    HttpRequest request =
        HttpRequest.builder()
            .setMethod(HttpMethod.POST)
            .setUrl("https://foo.com/v1/bar")
            .setQueryParameters("?a=1&b=%2B2")
            .setHeaders(new HttpHeaders().add("content-type", "application/json"))
            .setContent(content)
            .build();

    assertEquals(HttpMethod.POST, request.getMethod());
    assertEquals("https://foo.com/v1/bar", request.getUrl());
    assertEquals(Optional.of("?a=1&b=%2B2"), request.getQueryParameters());
    assertEquals(Optional.of("application/json"), request.getHeaders().getFirst("Content-Type"));
    assertSame(content, request.getContent().get());
  }

  @Test
  void buildWithDefaults() {
    HttpRequest request =
        HttpRequest.builder().setMethod(HttpMethod.GET).setUrl("https://foo.com").build();

    assertEquals(Optional.empty(), request.getQueryParameters());
    assertTrue(request.getHeaders().isEmpty());
    assertEquals(Optional.empty(), request.getContent());
  }

  @Test
  void headersAreCopied() {
    HttpHeaders headers = new HttpHeaders().add("A", "1");
    HttpRequest request =
        HttpRequest.builder()
            .setMethod(HttpMethod.GET)
            .setUrl("https://foo.com")
            .setHeaders(headers)
            .build();

    headers.add("A", "2");

    assertEquals(1, request.getHeaders().getAll("A").size());
  }

  @Test
  void builderFromRequestDoesNotChangeTheSource() {
    HttpRequest source =
        HttpRequest.builder()
            .setMethod(HttpMethod.GET)
            .setUrl("https://foo.com")
            .setHeaders(new HttpHeaders().add("A", "1"))
            .build();

    HttpRequest updated =
        HttpRequest.builder(source)
            .setHeaders(new HttpHeaders(source.getHeaders()).set("A", "2"))
            .build();

    assertEquals(Optional.of("1"), source.getHeaders().getFirst("A"));
    assertEquals(Optional.of("2"), updated.getHeaders().getFirst("A"));
    assertEquals(source.getUrl(), updated.getUrl());
    assertEquals(source.getMethod(), updated.getMethod());
  }

  @Test
  void methodAndUrlAreRequired() {
    assertThrows(
        NullPointerException.class, () -> HttpRequest.builder().setUrl("https://foo.com").build());
    assertThrows(
        NullPointerException.class, () -> HttpRequest.builder().setMethod(HttpMethod.GET).build());
  }

  @Test
  void queryParametersMustStartWithQuestionMark() {
    HttpRequest.Builder builder =
        HttpRequest.builder()
            .setMethod(HttpMethod.GET)
            .setUrl("https://foo.com")
            .setQueryParameters("a=1");

    assertThrows(IllegalArgumentException.class, builder::build);
  }
}
