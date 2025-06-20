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
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionsService;
import com.sinch.sdk.domains.numbers.models.v1.AvailableRegionsDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class AvailableRegionsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;
  AvailableRegionsService service;

  static final String uriUUID = "foo";
  static final Collection<String> NUMBERS_AUTH_NAMES = Arrays.asList("Basic", "OAuth2.0");

  @GivenTextResource("/domains/numbers/v1/regions/available-regions-list.json")
  String jsonRegionsResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new AvailableRegionsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void listWithoutFilters() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(uriUUID) + "/availableRegions",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonRegionsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableRegionListResponse response = service.list();

    TestHelpers.recursiveEquals(
        response.getContent(), AvailableRegionsDtoTest.availableRegionList.getAvailableRegions());
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/projects/" + URLPathUtils.encodePathSegment(uriUUID) + "/availableRegions",
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("types", Arrays.asList(NumberType.MOBILE), STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            NUMBERS_AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonRegionsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AvailableRegionListResponse response =
        service.list(
            AvailableRegionsListQueryParameters.builder()
                .setTypes(Arrays.asList(NumberType.MOBILE))
                .build());

    TestHelpers.recursiveEquals(
        response.getContent(), AvailableRegionsDtoTest.availableRegionList.getAvailableRegions());
  }
}
