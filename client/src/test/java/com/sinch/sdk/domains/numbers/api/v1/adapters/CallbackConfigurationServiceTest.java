package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.models.v1.CallbackConfigurationDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class CallbackConfigurationServiceTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/callbacks/callback-get-response.json")
  String jsonGetResponse;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;
  CallbackConfigurationService service;

  static final String uriUUID = "foo";

  static final Collection<String> NUMBERS_AUTH_NAMES = Arrays.asList("Basic", "OAuth2.0");

  @BeforeEach
  public void initMocks() {
    service =
        new CallbackConfigurationServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(uriUUID) + "/callbackConfiguration",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGetResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    CallbackConfigurationResponse response = service.get();

    TestHelpers.recursiveEquals(response, CallbackConfigurationDtoTest.getResponse);
  }

  @Test
  void update() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(uriUUID) + "/callbackConfiguration",
            HttpMethod.PATCH,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    CallbackConfigurationDtoTest.updateRequest),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGetResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    CallbackConfigurationResponse response =
        service.update(CallbackConfigurationDtoTest.updateRequest);

    TestHelpers.recursiveEquals(response, CallbackConfigurationDtoTest.getResponse);
  }
}
