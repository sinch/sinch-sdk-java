package com.sinch.sdk.auth;

import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class SinchEventsApplicationAuthValidationTest {

  protected static final String AUTHORIZATION_HEADER = "authorization";
  protected static final String CONTENT_TYPE_HEADER = "content-type";
  protected static final String TIMESTAMP_HEADER = "x-timestamp";

  protected static final String METHOD = "POST";

  protected abstract boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload);

  protected abstract String applicationKey();

  protected abstract String path();

  protected abstract String contentType();

  protected abstract String timestamp();

  protected abstract String payload();

  protected abstract String signature();

  @Test
  void checkValidRequest() {

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), validHeaders(), payload()))
        .isTrue();
  }

  @Test
  void checkValidRequestWithHeaderNamesCaseInsensitivity() {

    Map<String, String> headers =
        headers(
            entry("Authorization", authorizationHeaderValue()),
            entry("Content-Type", contentType()),
            entry("X-Timestamp", timestamp()));

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isTrue();
  }

  @Test
  void checkValidRequestWithAuthorizationKeywordCaseInsensitivity() {

    Map<String, String> headers =
        validHeadersWith(
            AUTHORIZATION_HEADER, "APPLICATION " + applicationKey() + ":" + signature());

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isTrue();
  }

  @Test
  void checkFailureOnMissingAuthorizationHeader() {

    Map<String, String> headers = validHeadersWithout(AUTHORIZATION_HEADER);

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnEmptyAuthorizationHeader() {

    Map<String, String> headers = validHeadersWith(AUTHORIZATION_HEADER, "");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnNullAuthorizationHeader() {

    Map<String, String> headers = validHeadersWith(AUTHORIZATION_HEADER, null);

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnUnknownAuthorizationKeyword() {

    Map<String, String> headers =
        validHeadersWith(AUTHORIZATION_HEADER, "bearer " + applicationKey() + ":" + signature());

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnBasicAuthorizationKeyword() {

    Map<String, String> headers =
        validHeadersWith(AUTHORIZATION_HEADER, "basic " + applicationKey() + ":" + signature());

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  private String authorizationHeaderValue() {
    return "application " + applicationKey() + ":" + signature();
  }

  private Map<String, String> validHeaders() {
    return headers(
        entry(AUTHORIZATION_HEADER, authorizationHeaderValue()),
        entry(CONTENT_TYPE_HEADER, contentType()),
        entry(TIMESTAMP_HEADER, timestamp()));
  }

  private Map<String, String> validHeadersWith(String header, String value) {
    Map<String, String> headers = validHeaders();
    headers.put(header, value);
    return headers;
  }

  private Map<String, String> validHeadersWithout(String header) {
    Map<String, String> headers = validHeaders();
    headers.remove(header);
    return headers;
  }

  @SafeVarargs
  private static Map<String, String> headers(Map.Entry<String, String>... entries) {
    // not relying on Collectors.toMap: null values are part of the scenarios
    Map<String, String> headers = new LinkedHashMap<>();
    for (Map.Entry<String, String> entry : entries) {
      headers.put(entry.getKey(), entry.getValue());
    }
    return headers;
  }

  private static Map.Entry<String, String> entry(String key, String value) {
    return new java.util.AbstractMap.SimpleEntry<>(key, value);
  }
}
