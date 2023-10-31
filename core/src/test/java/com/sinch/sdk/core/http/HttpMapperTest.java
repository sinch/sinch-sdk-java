package com.sinch.sdk.core.http;

import static com.sinch.sdk.core.http.HttpContentType.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.core.exceptions.ApiException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpMapperTest {

  final HttpMapper mapper = new HttpMapper();

  @Test
  void deserializeNullResponse() throws ApiException {
    TypeReference<String> returnType = new TypeReference<String>() {};

    Assertions.assertThat(mapper.deserialize(null, returnType)).isNull();
  }

  @Test
  void deserializeNullReference() throws ApiException {

    HttpResponse httpResponse = new HttpResponse(-100, null, null, null);
    Assertions.assertThat(mapper.deserialize(httpResponse, (TypeReference<String>) null)).isNull();
  }

  @Test
  void deserializeNoContentType() throws ApiException {

    FooSerialization value = new FooSerialization("my value");
    HttpResponse httpResponse =
        new HttpResponse(
            -100, "a message", null, "{\"value\": \"my value\"}".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(
            mapper.deserialize(httpResponse, new TypeReference<FooSerialization>() {}))
        .usingRecursiveComparison()
        .isEqualTo(value);
  }

  @Test
  void deserializeJsonContentType() throws ApiException {

    FooSerialization value = new FooSerialization("my value");
    HttpResponse httpResponse =
        new HttpResponse(
            -100,
            "a message",
            Stream.of(new String[][] {{CONTENT_TYPE_HEADER, APPLICATION_JSON}})
                .collect(
                    Collectors.toMap(data -> data[0], data -> Collections.singletonList(data[1]))),
            "{\"value\": \"my value\"}".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(
            mapper.deserialize(httpResponse, new TypeReference<FooSerialization>() {}))
        .usingRecursiveComparison()
        .isEqualTo(value);
  }

  @Test
  void deserializeTextContentType() throws ApiException {

    HttpResponse httpResponse =
        new HttpResponse(
            -100,
            "a message",
            Stream.of(new String[][] {{CONTENT_TYPE_HEADER, TEXT_PLAIN}})
                .collect(
                    Collectors.toMap(data -> data[0], data -> Collections.singletonList(data[1]))),
            "my text plain content".getBytes(StandardCharsets.UTF_8));

    Assertions.assertThat(mapper.deserialize(httpResponse, new TypeReference<String>() {}))
        .isEqualTo("my text plain content");
  }

  @Test
  void serializeJSON() throws ApiException {

    FooSerialization value = new FooSerialization("to deserialized");

    Assertions.assertThat(mapper.serialize(null, value))
        .isEqualTo("{\"value\":\"to deserialized\"}");
  }

  static class FooSerialization {
    public static final String JSON_PROPERTY = "value";
    private String value;

    public FooSerialization() {}

    public FooSerialization(String value) {
      this.value = value;
    }

    @JsonProperty(JSON_PROPERTY)
    public String getValue() {
      return value;
    }

    @JsonProperty(JSON_PROPERTY)
    public void setValue(String value) {
      this.value = value;
    }
  }
}
