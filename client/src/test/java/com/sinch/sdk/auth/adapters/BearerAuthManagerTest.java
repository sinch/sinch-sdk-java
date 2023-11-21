package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.auth.AuthManager;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.Configuration;
import java.nio.charset.StandardCharsets;
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

  AuthManager authManager = new BearerAuthManager(configuration, new HttpMapper());

  @Test
  void getSchema() {
    assertEquals("Bearer", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaderValue() {
    String expectedToken = "Bearer token value";

    when(httpClient.invokeAPI(any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));
    authManager.setHttpClient(httpClient);

    String token = authManager.getAuthorizationHeaderValue();

    assertEquals(expectedToken, token);
  }

  @Test
  void callToOAuthServer() {
    when(httpClient.invokeAPI(serverConfigurationCaptor.capture(), httpRequestCaptor.capture()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));
    authManager.setHttpClient(httpClient);

    authManager.getAuthorizationHeaderValue();

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
    when(httpClient.invokeAPI(any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));
    authManager.setHttpClient(httpClient);

    authManager.resetToken();
    authManager.getAuthorizationHeaderValue();

    verify(httpClient, times(1)).invokeAPI(any(), any());
  }

  @Test
  void noInfiniteLoopAndException() {
    authManager.setHttpClient(httpClient);

    ApiAuthException exception =
        assertThrows(ApiAuthException.class, authManager::getAuthorizationHeaderValue);
    assertEquals(exception.getCode(), 401);
  }
}
