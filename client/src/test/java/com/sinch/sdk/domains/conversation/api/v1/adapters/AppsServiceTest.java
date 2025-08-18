package com.sinch.sdk.domains.conversation.api.v1.adapters;

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
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.conversation.api.v1.AppsService;
import com.sinch.sdk.domains.conversation.models.v1.apps.AppDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.AppResponse;
import com.sinch.sdk.domains.conversation.models.v1.apps.response.AppsListResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class AppsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  AppsService service;

  @GivenTextResource("/domains/conversation/v1/apps/AppListResponseDto.json")
  String jsonListAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/apps/AppResponseDto.json")
  String jsonLoadedAppsResponseDto;

  @GivenTextResource("/domains/conversation/v1/apps/AppCreateRequestDto.json")
  String jsonAppCreateRequestDto;

  @GivenTextResource("/domains/conversation/v1/apps/AppUpdateRequestDto.json")
  String jsonAppUpdateRequestDto;

  @BeforeEach
  public void initMocks() {
    service =
        new AppsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/apps", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonListAppsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AppsListResponse response = service.list();
    Iterator<AppResponse> iterator = response.iterator();

    AppsListResponse expectedAppsListResponse =
        new AppsListResponse(
            new Page<>(null, AppDtoTest.expectedListAppsResponseDto.getApps(), null));
    Iterator<AppResponse> expectedIterator = expectedAppsListResponse.iterator();

    while (iterator.hasNext()) {
      AppResponse item = iterator.next();
      AppResponse expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(AppDtoTest.expectedAppResponseDto.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonLoadedAppsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AppResponse response = service.get(AppDtoTest.expectedAppResponseDto.getId());

    TestHelpers.recursiveEquals(response, AppDtoTest.expectedAppResponseDto);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/apps", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonAppCreateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonLoadedAppsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AppResponse response = service.create(AppDtoTest.appCreateRequestDto);

    TestHelpers.recursiveEquals(response, AppDtoTest.expectedAppResponseDto);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(AppDtoTest.expectedAppResponseDto.getId())),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonAppUpdateRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonLoadedAppsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    AppResponse response =
        service.update(AppDtoTest.expectedAppResponseDto.getId(), AppDtoTest.appUpdateRequestDto);

    TestHelpers.recursiveEquals(response, AppDtoTest.expectedAppResponseDto);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/apps/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(AppDtoTest.expectedAppResponseDto.getId())),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.delete(AppDtoTest.expectedAppResponseDto.getId());
  }
}
