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
import com.sinch.sdk.domains.voice.api.v2.SvamlService;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.DescribeSvamlRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.response.SvamlDescriptionResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class SvamlServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  SvamlService service;

  @GivenTextResource("/domains/voice/v2/svaml/request/DescribeSvamlRequestDto.json")
  String jsonDescribeSvamlRequestDto;

  @GivenTextResource("/domains/voice/v2/svaml/response/SvamlDescriptionResponseDto.json")
  String jsonSvamlDescriptionResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new SvamlServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), PROJECT_ID);
  }

  @Test
  void describe() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/svaml/describe",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonDescribeSvamlRequestDto,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonSvamlDescriptionResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SvamlDescriptionResponse response =
        service.describe(DescribeSvamlRequestDtoTest.expectedDescribeSvamlRequest);

    TestHelpers.recursiveEquals(
        response, SvamlDescriptionResponseDtoTest.expectedSvamlDescriptionResponse);
  }

  @Test
  void describeMissingRequestThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.describe(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void describeMissingProjectIdThrows() {

    SvamlService serviceWithoutProjectId =
        new SvamlServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () ->
                serviceWithoutProjectId.describe(
                    DescribeSvamlRequestDtoTest.expectedDescribeSvamlRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }
}
