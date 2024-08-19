package com.sinch.sdk.core.http;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpContentTypeTest {

  @Test
  void getCharsetValueDefaultEmpty() {
    Assertions.assertThat(HttpContentType.getCharsetValue("")).isEqualTo(Optional.empty());
  }

  @Test
  void getCharsetValueNullEmpty() {
    Assertions.assertThat(HttpContentType.getCharsetValue(null)).isEqualTo(Optional.empty());
  }

  @Test
  void getCharsetValueNoCharset() {
    Assertions.assertThat(HttpContentType.getCharsetValue("text/html")).isEqualTo(Optional.empty());
  }

  @Test
  void getCharsetValueNoCharsetWithSemiColon() {
    Assertions.assertThat(HttpContentType.getCharsetValue("text/html;"))
        .isEqualTo(Optional.empty());
  }

  @Test
  void getCharsetValueStartOfString() {
    Assertions.assertThat(HttpContentType.getCharsetValue(" charset=utf-16; text/html"))
        .isEqualTo(Optional.of("utf-16"));
  }

  @Test
  void getCharsetValueStartOfStringWithSemiColon() {
    Assertions.assertThat(HttpContentType.getCharsetValue(" charset=utf-16; text/html;"))
        .isEqualTo(Optional.of("utf-16"));
  }

  @Test
  void getCharsetValueEndOfString() {
    Assertions.assertThat(HttpContentType.getCharsetValue("text/html; charset=utf-16"))
        .isEqualTo(Optional.of("utf-16"));
  }

  @Test
  void getCharsetValueEndOfStringWithSemiColon() {
    Assertions.assertThat(HttpContentType.getCharsetValue("text/html; charset=utf-16;"))
        .isEqualTo(Optional.of("utf-16"));
  }

  @Test
  void getCharsetValue() {
    Assertions.assertThat(
            HttpContentType.getCharsetValue(
                "multipart/form-data; charset=utf-16; boundary=ExampleBoundaryString"))
        .isEqualTo(Optional.of("utf-16"));
  }

  @Test
  void getCharsetValueWithSemiColon() {
    Assertions.assertThat(
            HttpContentType.getCharsetValue(
                "multipart/form-data; charset=utf-16; boundary=ExampleBoundaryString;"))
        .isEqualTo(Optional.of("utf-16"));
  }
}
