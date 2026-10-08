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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.api.v2.ServicesService;
import com.sinch.sdk.domains.voice.models.v2.services.NoneCallBehavior;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.request.CreateServiceRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  ServicesService service;

  @GivenTextResource("/domains/voice/v2/services/request/CreateServiceRequestDto.json")
  String jsonCreateServiceRequestDto;

  @GivenTextResource("/domains/voice/v2/services/response/ServiceResponseDto.json")
  String jsonServiceResponseDto;

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
}
