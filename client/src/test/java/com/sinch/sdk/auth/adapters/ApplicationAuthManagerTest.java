package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.utils.Pair;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class ApplicationAuthManagerTest {

  static final String KEY = "my-key-id";
  static final String SECRET =
      Base64.getEncoder().encodeToString("my-key-secret".getBytes(StandardCharsets.UTF_8));
  static final String METHOD = HttpMethod.POST.name();
  static final String CONTENT_TYPE = HttpContentType.APPLICATION_JSON + "; charset=UTF-8";
  static final String PATH = "/path/pathParamValue";
  static final String PAYLOAD =
      "{\"identity\":{\"type\":\"number\",\"endpoint\":\"+33444555666\"},\"method\":\"sms\"}";
  static final Instant TIMESTAMP = Instant.parse("2023-11-22T09:10:11.999Z");
  static final String HASH = "QP3OzQZVzRZAEev6DBLvJkgpiqyZPuXYsc7oyjUV0K8=";
  AuthManager authManager = new ApplicationAuthManager(KEY, SECRET);

  @Test
  void getSchema() {
    assertEquals("Basic", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaderValue() {

    try (MockedStatic<Instant> utilities = Mockito.mockStatic(Instant.class)) {
      utilities.when(Instant::now).thenReturn(TIMESTAMP);

      Collection<Pair<String, String>> expectedHeaders =
          Arrays.asList(
              new Pair<>("Authorization", "Application " + KEY + ":" + HASH),
              new Pair<>("x-timestamp", TIMESTAMP.toString()));

      Collection<Pair<String, String>> headers =
          authManager.getAuthorizationHeaders(METHOD, CONTENT_TYPE, PATH, PAYLOAD);

      Assertions.assertThat(headers).usingRecursiveComparison().isEqualTo(expectedHeaders);
    }
  }

  @Test
  void checkValidateAuthenticatedRequest() throws ApiException {

    Map<String, String> headers = getHeaders("application", KEY, HASH);

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, headers, PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(true);
  }

  @Test
  void checkApplicationAuthenticationFailureOnBadKeyword() throws ApiException {

    Map<String, String> headers = getHeaders("a bad keyword", KEY, HASH);

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, headers, PAYLOAD);
    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnKey() throws ApiException {

    Map<String, String> headers = getHeaders("application", " a bad key", HASH);

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, headers, PAYLOAD);
    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnHash() throws ApiException {

    Map<String, String> headers = getHeaders("application", KEY, "a bad hash value");

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, headers, PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkValidateAuthenticatedRequestWithQueryParametersInPath() {

    // query parameters are not part of the signed data
    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH + "?foo=bar&baz=42", validHeaders(), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(true);
  }

  @Test
  void checkValidateAuthenticatedRequestWithAbsoluteUrlAsPath() {

    // only the path part of an absolute URL is signed
    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, "https://callbacks.yourdomain.com" + PATH, validHeaders(), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(true);
  }

  @Test
  void checkApplicationAuthenticationFailureOnKeywordOnly() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeadersWith("authorization", "application"), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnMissingHash() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, getHeaders("application", KEY, ""), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnMissingTimestamp() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeadersWithout("x-timestamp"), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnTimestamp() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeadersWith("x-timestamp", "2019-11-03T10:59:41Z"), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnMissingContentType() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeadersWithout("content-type"), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnContentType() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeadersWith("content-type", "text/plain"), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnMethod() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            HttpMethod.GET.name(), PATH, validHeaders(), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnPath() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, "/not/that/path", validHeaders(), PAYLOAD);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnPayload() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(
            METHOD, PATH, validHeaders(), "{\"hello\":\"world\"}");

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnEmptyPayload() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, validHeaders(), "");

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationAuthenticationFailureOnNullPayload() {

    boolean authenticationResult =
        authManager.validateAuthenticatedRequest(METHOD, PATH, validHeaders(), null);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  private static Map<String, String> validHeaders() {
    return getHeaders("application", KEY, HASH);
  }

  private static Map<String, String> validHeadersWith(String header, String value) {
    Map<String, String> headers = validHeaders();
    headers.put(header, value);
    return headers;
  }

  private static Map<String, String> validHeadersWithout(String header) {
    Map<String, String> headers = validHeaders();
    headers.remove(header);
    return headers;
  }

  private static Map<String, String> getHeaders(String keyword, String key, String hash) {
    return Stream.of(
            new AbstractMap.SimpleEntry<>("authorization", keyword + " " + key + ":" + hash),
            new AbstractMap.SimpleEntry<>("content-type", CONTENT_TYPE),
            new AbstractMap.SimpleEntry<>("x-timestamp", TIMESTAMP.toString()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
