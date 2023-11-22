package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.Configuration;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class BearerAuthManagerTest extends BaseTest {
  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";

  @GivenTextResource("/client/auth/BearerAuthResponse.json")
  String jsonResponse;

  @Mock HttpClient httpClient;
  @Captor ArgumentCaptor<ServerConfiguration> serverConfigurationCaptor;
  @Captor ArgumentCaptor<HttpRequest> httpRequestCaptor;
  Configuration configuration =
      Configuration.builder()
          .setKeyId(KEY)
          .setKeySecret(SECRET)
          .setProjectId(PROJECT)
          .setOAuthUrl("OAuth url")
          .build();

  AuthManager authManager;

  @BeforeEach
  public void initEach() {
    authManager = new BearerAuthManager(configuration, new HttpMapper(), httpClient);
  }

  @Test
  void getSchema() {
    assertEquals("Bearer", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaders() {
    Collection<Pair<String, String>> expectedHeaders =
        Collections.singletonList(new Pair<>("Authorization", "Bearer token value"));

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    Collection<Pair<String, String>> headers =
        authManager.getAuthorizationHeaders(null, null, null, null);

    Assertions.assertThat(headers).usingRecursiveComparison().isEqualTo(expectedHeaders);
  }

  @Test
  void callToOAuthServer() {
    when(httpClient.invokeAPI(
            serverConfigurationCaptor.capture(), any(), httpRequestCaptor.capture()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    authManager.getAuthorizationHeaders(null, null, null, null);

    ServerConfiguration serverConfigurationValue = serverConfigurationCaptor.getValue();
    assertEquals("OAuth url", serverConfigurationValue.getUrl());

    HttpRequest httpRequestCaptorValue = httpRequestCaptor.getValue();
    assertEquals(HttpMethod.POST, httpRequestCaptorValue.getMethod());
    assertTrue(httpRequestCaptorValue.getAuthNames().stream().anyMatch(e -> e.equals("Basic")));
    assertTrue(
        httpRequestCaptorValue.getContentType().stream()
            .anyMatch(e -> e.equals("application/x-www-form-urlencoded")));
    assertEquals("grant_type=client_credentials", httpRequestCaptorValue.getBody());
  }

  @Test
  void resetToken() {
    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    authManager.resetToken();
    authManager.getAuthorizationHeaders(null, null, null, null);

    verify(httpClient, times(1)).invokeAPI(any(), any(), any());
  }

  @Test
  void noInfiniteLoopAndException() {
    ApiAuthException exception =
        assertThrows(
            ApiAuthException.class,
            () -> authManager.getAuthorizationHeaders(null, null, null, null));
    assertEquals(exception.getCode(), 401);
  }
}
