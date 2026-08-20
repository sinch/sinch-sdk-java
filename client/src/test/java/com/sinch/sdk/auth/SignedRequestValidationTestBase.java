package com.sinch.sdk.auth;

import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class SignedRequestValidationTestBase {

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
  void checkValidRequestWithQueryParametersInPath() {

    // query parameters are not part of the signed data
    Assertions.assertThat(
            validateAuthenticationHeader(
                METHOD, path() + "?foo=bar&baz=42", validHeaders(), payload()))
        .isTrue();
  }

  @Test
  void checkValidRequestWithAbsoluteUrlAsPath() {

    // only the path part of an absolute URL is signed
    Assertions.assertThat(
            validateAuthenticationHeader(
                METHOD, "https://callbacks.yourdomain.com" + path(), validHeaders(), payload()))
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

  @Test
  void checkFailureOnAuthorizationKeywordOnly() {

    Map<String, String> headers = validHeadersWith(AUTHORIZATION_HEADER, "application");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnMissingSignature() {

    Map<String, String> headers =
        validHeadersWith(AUTHORIZATION_HEADER, "application " + applicationKey() + ":");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnUnknownApplicationKey() {

    Map<String, String> headers =
        validHeadersWith(
            AUTHORIZATION_HEADER,
            "application 00000000-0000-0000-0000-000000000000:" + signature());

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousSignature() {

    Map<String, String> headers =
        validHeadersWith(
            AUTHORIZATION_HEADER,
            "application " + applicationKey() + ":Ig2LOfF3B0DlWSF9uUKp5vJyFCK2eBHqxYFvKgUqPVU=");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnMissingTimestampHeader() {

    Map<String, String> headers = validHeadersWithout(TIMESTAMP_HEADER);

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousTimestampHeader() {

    Map<String, String> headers = validHeadersWith(TIMESTAMP_HEADER, "2019-11-03T10:59:41Z");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnMissingContentTypeHeader() {

    Map<String, String> headers = validHeadersWithout(CONTENT_TYPE_HEADER);

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousContentTypeHeader() {

    Map<String, String> headers = validHeadersWith(CONTENT_TYPE_HEADER, "text/plain");

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), headers, payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousHttpMethod() {

    Assertions.assertThat(validateAuthenticationHeader("GET", path(), validHeaders(), payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousPath() {

    Assertions.assertThat(
            validateAuthenticationHeader(METHOD, "/not/that/path", validHeaders(), payload()))
        .isFalse();
  }

  @Test
  void checkFailureOnErroneousPayload() {

    Assertions.assertThat(
            validateAuthenticationHeader(METHOD, path(), validHeaders(), "{\"hello\":\"world\"}"))
        .isFalse();
  }

  @Test
  void checkFailureOnEmptyPayload() {

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), validHeaders(), ""))
        .isFalse();
  }

  @Test
  void checkFailureOnNullPayload() {

    Assertions.assertThat(validateAuthenticationHeader(METHOD, path(), validHeaders(), null))
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
