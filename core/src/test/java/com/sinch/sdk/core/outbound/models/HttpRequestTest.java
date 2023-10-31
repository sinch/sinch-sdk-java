package com.sinch.sdk.core.outbound.models;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.URLParameter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpRequestTest {

  static final String path = " a path";
  static final HttpMethod method = HttpMethod.POST;
  static final Collection<URLParameter> queryParameters =
      Arrays.asList(new URLParameter("key1", "value1"), new URLParameter("key2", "value2"));
  static final String body = "my body";
  static final Map<String, String> headerParams =
      Stream.of(
              new String[][] {
                {"headerKey1", "headerValue1"}, {"headerKey2", "headerValue2"},
              })
          .collect(Collectors.toMap(data -> data[0], data -> data[1]));
  static final Collection<String> accept = Arrays.asList("accept1", "accept2");
  static final Collection<String> contentType = Arrays.asList("content1", "content2");
  static final Collection<String> authNames = Collections.singletonList("auth1");
  final HttpRequest httpRequest =
      new HttpRequest(
          path, method, queryParameters, body, headerParams, accept, contentType, authNames);

  @Test
  void getPath() {
    Assertions.assertThat(httpRequest.getPath().get()).isEqualTo(path);
  }

  @Test
  void getMethod() {
    Assertions.assertThat(httpRequest.getMethod()).isEqualTo(method);
  }

  @Test
  void getQueryParameters() {
    Collection<URLParameter> collection =
        Arrays.asList(new URLParameter("key1", "value1"), new URLParameter("key2", "value2"));

    Assertions.assertThat(httpRequest.getQueryParameters())
        .usingRecursiveComparison()
        .isEqualTo(collection);
  }

  @Test
  void getBody() {
    Assertions.assertThat(httpRequest.getBody()).isEqualTo(body);
  }

  @Test
  void getHeaderParams() {
    Map<String, String> map =
        Stream.of(
                new String[][] {
                  {"headerKey1", "headerValue1"}, {"headerKey2", "headerValue2"},
                })
            .collect(Collectors.toMap(data -> data[0], data -> data[1]));
    Assertions.assertThat(httpRequest.getHeaderParams()).usingRecursiveComparison().isEqualTo(map);
  }

  @Test
  void getAccept() {
    Collection<String> collection = Arrays.asList("accept1", "accept2");

    Assertions.assertThat(httpRequest.getAccept()).usingRecursiveComparison().isEqualTo(collection);
  }

  @Test
  void getContentType() {
    Collection<String> collection = Arrays.asList("content1", "content2");

    Assertions.assertThat(httpRequest.getContentType())
        .usingRecursiveComparison()
        .isEqualTo(collection);
  }

  @Test
  void getAuthNames() {
    Collection<String> collection = Collections.singletonList("auth1");

    Assertions.assertThat(httpRequest.getAuthNames())
        .usingRecursiveComparison()
        .isEqualTo(collection);
  }
}
