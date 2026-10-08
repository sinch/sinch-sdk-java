package com.sinch.sdk.domains.voice.api.v2.adapters;

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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.api.v2.ServicesService;
import com.sinch.sdk.domains.voice.models.v2.services.NoneCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.services.request.ListServicesQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceShortResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServicesListResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.internal.ServicesListResponseInternalDtoTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class ServicesServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final String CONFIGURED_SERVER_URL = "https://configured.server.com";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  ServicesService service;

  @GivenTextResource("/domains/voice/v2/services/request/CreateServiceRequestDto.json")
  String jsonCreateServiceRequestDto;

  @GivenTextResource("/domains/voice/v2/services/request/UpdateServiceRequestDto.json")
  String jsonUpdateServiceRequestDto;

  @GivenTextResource("/domains/voice/v2/services/response/ServiceResponseDto.json")
  String jsonServiceResponseDto;

  @GivenTextResource(
      "/domains/voice/v2/services/response/internal/ServicesListResponseInternalDto.json")
  String jsonServicesListResponseDto;

  @GivenTextResource(
      "/domains/voice/v2/services/response/internal/ServicesListResponseInternalLastPageDto.json")
  String jsonServicesListLastPageResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new ServicesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), PROJECT_ID);
  }

  @Test
  void create() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/services",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonCreateServiceRequestDto,
            Collections.singletonMap(
                "Idempotency-Key",
                CreateServiceRequestDtoTest.expectedCreateServiceRequest.getIdempotencyKey()),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(201, null, Collections.emptyMap(), jsonServiceResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ServiceResponse response =
        service.create(CreateServiceRequestDtoTest.expectedCreateServiceRequest);

    TestHelpers.recursiveEquals(response, ServiceResponseDtoTest.expectedServiceResponse);
  }

  @Test
  void createWithoutIdempotencyKeySendsNoHeader() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/services",
            HttpMethod.POST,
            Collections.emptyList(),
            "{\"name\":\"Example service\",\"callBehavior\":{\"type\":\"NONE\"}}",
            Collections.emptyMap(),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(201, null, Collections.emptyMap(), jsonServiceResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ServiceResponse response =
        service.create(
            CreateServiceRequest.builder()
                .setName("Example service")
                .setCallBehavior(NoneCallBehavior.NONE_CALL_BEHAVIOR)
                .build());

    TestHelpers.recursiveEquals(response, ServiceResponseDtoTest.expectedServiceResponse);
  }

  @Test
  void createMissingRequestThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.create(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void createMissingProjectIdThrows() {

    ServicesService serviceWithoutProjectId =
        new ServicesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () ->
                serviceWithoutProjectId.create(
                    CreateServiceRequestDtoTest.expectedCreateServiceRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/services/"
                + URLPathUtils.encodePathSegment("6e124178-c29d-46a5-943c-5c2ae544aade"),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonServiceResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ServiceResponse response = service.get("6e124178-c29d-46a5-943c-5c2ae544aade");

    TestHelpers.recursiveEquals(response, ServiceResponseDtoTest.expectedServiceResponse);
  }

  @Test
  void getMissingServiceIdThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.get(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/services/"
                + URLPathUtils.encodePathSegment("6e124178-c29d-46a5-943c-5c2ae544aade"),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonUpdateServiceRequestDto,
            Collections.singletonMap(
                "Idempotency-Key",
                UpdateServiceRequestDtoTest.expectedUpdateServiceRequest.getIdempotencyKey()),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonServiceResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ServiceResponse response =
        service.update(
            "6e124178-c29d-46a5-943c-5c2ae544aade",
            UpdateServiceRequestDtoTest.expectedUpdateServiceRequest);

    TestHelpers.recursiveEquals(response, ServiceResponseDtoTest.expectedServiceResponse);
  }

  @Test
  void updateWithoutIdempotencyKeySendsNoHeader() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/services/"
                + URLPathUtils.encodePathSegment("6e124178-c29d-46a5-943c-5c2ae544aade"),
            HttpMethod.PATCH,
            Collections.emptyList(),
            "{\"isDefault\":true}",
            Collections.emptyMap(),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonServiceResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ServiceResponse response =
        service.update(
            "6e124178-c29d-46a5-943c-5c2ae544aade",
            UpdateServiceRequest.builder().setIsDefault(true).build());

    TestHelpers.recursiveEquals(response, ServiceResponseDtoTest.expectedServiceResponse);
  }

  @Test
  void updateMissingServiceIdThrows() {

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () -> service.update(null, UpdateServiceRequestDtoTest.expectedUpdateServiceRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void updateMissingRequestThrows() {

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class, () -> service.update("6e124178-c29d-46a5-943c-5c2ae544aade", null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void list() throws ApiException {

    List<URLParameter> urlParameters =
        Arrays.asList(
            new URLParameter("filter", "Service", URLParameter.form, true),
            new URLParameter("isDefault", false, URLParameter.form, true),
            new URLParameter("pageSize", 2, URLParameter.form, true),
            new URLParameter("page", 1, URLParameter.form, true));

    mockListPage(urlParameters, jsonServicesListResponseDto);
    mockNextListPage(jsonServicesListLastPageResponseDto);

    ListServicesQueryParameters queryParameters =
        ListServicesQueryParameters.builder()
            .setFilter("Service")
            .setIsDefault(false)
            .setPageSize(2)
            .setPage(1)
            .build();

    ServicesListResponse response = service.list(queryParameters);

    TestHelpers.recursiveEquals(
        new ArrayList<>(response.getContent()),
        new ArrayList<>(
            ServicesListResponseInternalDtoTest.expectedServicesListResponse.getServices()));
    Assertions.assertTrue(response.hasNextPage());

    ServicesListResponse nextResponse = response.nextPage();

    TestHelpers.recursiveEquals(
        new ArrayList<>(nextResponse.getContent()),
        new ArrayList<>(
            ServicesListResponseInternalDtoTest.expectedServicesListLastPageResponse
                .getServices()));
    Assertions.assertFalse(nextResponse.hasNextPage());
  }

  @Test
  void listIteratesOverAllPages() throws ApiException {

    mockListPage(Collections.emptyList(), jsonServicesListResponseDto);
    mockNextListPage(jsonServicesListLastPageResponseDto);

    ServicesListResponse response = service.list();

    List<ServiceShortResponse> services = new ArrayList<>();
    response.iterator().forEachRemaining(services::add);

    List<ServiceShortResponse> expected =
        new ArrayList<>(
            ServicesListResponseInternalDtoTest.expectedServicesListResponse.getServices());
    expected.addAll(
        ServicesListResponseInternalDtoTest.expectedServicesListLastPageResponse.getServices());
    TestHelpers.recursiveEquals(services, expected);
  }

  @Test
  void listMissingProjectIdThrows() {

    ServicesService serviceWithoutProjectId =
        new ServicesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(ApiException.class, () -> serviceWithoutProjectId.list());

    Assertions.assertEquals(400, thrown.getCode());
  }

  // The "next" link served by the fixture targets https://voice.api.sinch.com: its path and query
  // are expected to be sent to the configured server instead
  private void mockNextListPage(String jsonResponse) {
    when(serverConfiguration.getUrl()).thenReturn(CONFIGURED_SERVER_URL);

    HttpRequest httpRequest =
        new HttpRequest(
            CONFIGURED_SERVER_URL
                + "/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/services?page=2&pageSize=2",
            HttpMethod.GET,
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
  }

  private void mockListPage(List<URLParameter> urlParameters, String jsonResponse) {
    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/services",
            HttpMethod.GET,
            urlParameters,
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
  }
}
