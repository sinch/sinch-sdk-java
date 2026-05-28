package com.sinch.sdk.domains.number_lookup.api.v2.adapters;

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
import com.sinch.sdk.domains.number_lookup.api.v2.NumberLookupV2Service;
import com.sinch.sdk.domains.number_lookup.models.v2.request.NumberLookupRequestDtoTest;
import com.sinch.sdk.domains.number_lookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.domains.number_lookup.models.v2.response.NumberLookupResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class NumberLookupV2ServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "OAuth2");

  NumberLookupV2Service service;

  @GivenTextResource("/domains/number_lookup/v2/request/NumberLookupRequestMinimalDto.json")
  String jsonNumberLookupRequestMinimalDto;

  @GivenTextResource("/domains/number_lookup/v2/request/NumberLookupRequestWithFeaturesDto.json")
  String jsonNumberLookupRequestWithFeaturesDto;

  @GivenTextResource("/domains/number_lookup/v2/request/NumberLookupRequestWithRndOptionsDto.json")
  String jsonNumberLookupRequestWithRndOptionsDto;

  @GivenTextResource("/domains/number_lookup/v2/response/NumberLookupResponseMinimalDto.json")
  String jsonNumberLookupResponseMinimalDto;

  @GivenTextResource("/domains/number_lookup/v2/response/NumberLookupResponseFullDto.json")
  String jsonNumberLookupResponseFullDto;

  @BeforeEach
  public void initMocks() {
    service =
        new NumberLookupV2ServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), PROJECT_ID);
  }

  @Test
  void numberLookupWithRequiredParameters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/lookups",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonNumberLookupRequestMinimalDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonNumberLookupResponseMinimalDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    NumberLookupResponse response =
        service.numberLookup(NumberLookupRequestDtoTest.numberLookupRequestMinimalDto);

    TestHelpers.recursiveEquals(
        response, NumberLookupResponseDtoTest.numberLookupResponseMinimalDto);
  }

  @Test
  void numberLookupWithFeatures() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/lookups",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonNumberLookupRequestWithFeaturesDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonNumberLookupResponseFullDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    NumberLookupResponse response =
        service.numberLookup(NumberLookupRequestDtoTest.numberLookupRequestWithFeaturesDto);

    TestHelpers.recursiveEquals(response, NumberLookupResponseDtoTest.numberLookupResponseFullDto);
  }

  @Test
  void numberLookupWithRndOptions() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/lookups",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonNumberLookupRequestWithRndOptionsDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonNumberLookupResponseFullDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    NumberLookupResponse response =
        service.numberLookup(NumberLookupRequestDtoTest.numberLookupRequestWithRndOptionsDto);

    TestHelpers.recursiveEquals(response, NumberLookupResponseDtoTest.numberLookupResponseFullDto);
  }

  @Test
  void numberLookupMissingProjectIdThrows() {

    NumberLookupV2Service serviceWithoutProjectId =
        new NumberLookupV2ServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () ->
                serviceWithoutProjectId.numberLookup(
                    NumberLookupRequestDtoTest.numberLookupRequestMinimalDto));

    Assertions.assertEquals(400, thrown.getCode());
  }
}
