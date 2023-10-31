package com.sinch.sdk.core.outbound.models;

import com.sinch.sdk.core.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpResponseTest {

  static final Integer code = 201;
  static final String message = "my message";
  static final Map<String, List<String>> headers =
      Stream.of(new String[][] {{"headerKey1", "headerValue1"}})
          .collect(Collectors.toMap(data -> data[0], data -> Collections.singletonList(data[1])));

  static final String responseString = "My response";

  static final byte[] response = responseString.getBytes(StandardCharsets.UTF_8);
  final HttpResponse httpResponse = new HttpResponse(code, message, headers, response);

  @Test
  void getCode() {
    Assertions.assertThat(httpResponse.getCode()).isEqualTo(code);
  }

  @Test
  void getMessage() {
    Assertions.assertThat(httpResponse.getMessage()).isEqualTo(message);
  }

  @Test
  void getHeaders() {
    Assertions.assertThat(httpResponse.getHeaders()).usingRecursiveComparison().isEqualTo(headers);
  }

  @Test
  void getContent() {
    String result =
        new BufferedReader(new InputStreamReader(httpResponse.getContent()))
            .lines()
            .collect(Collectors.joining(""));
    Assertions.assertThat(result).isEqualTo(responseString);
  }
}
