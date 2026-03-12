package com.sinch.sdk.domains.voice.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
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
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.EventDestinations;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateEventDestinationsRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequestTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.GetEventDestinationsResponseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumberInformation;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersListResponse;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponseTest;
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
public class ApplicationsServiceTest extends VoiceBaseTest {

  @GivenTextResource("/domains/voice/v1/applications/response/OwnedNumbersResponseDto.json")
  String ownedNumbersResponseDto;

  @GivenTextResource("/domains/voice/v1/applications/response/GetEventDestinationsResponseDto.json")
  String getEventDestinationsResponseDto;

  @GivenTextResource(
      "/domains/voice/v1/applications/request/UpdateEventDestinationsRequestDto.json")
  String updateEventDestinationsRequestDto;

  @GivenTextResource("/domains/voice/v1/applications/request/UpdateNumbersRequestDto.json")
  String updateNumbersRequestDto;

  @GivenTextResource("/domains/voice/v1/applications/request/UnAssignNumberRequestDto.json")
  String unAssignNumberRequestDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Signed");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  ApplicationsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new ApplicationsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void getNumbers() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/configuration/numbers",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), ownedNumbersResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    OwnedNumbersListResponse response = service.listNumbers();

    Iterator<OwnedNumberInformation> iterator = response.iterator();

    OwnedNumbersListResponse expectedListResponse =
        new OwnedNumbersListResponse(
            new Page<>(OwnedNumbersResponseTest.expected.getNumbers(), null));
    Iterator<OwnedNumberInformation> expectedIterator = expectedListResponse.iterator();

    while (iterator.hasNext()) {
      OwnedNumberInformation item = iterator.next();
      OwnedNumberInformation expectedItem = expectedIterator.next();
      TestHelpers.recursiveEquals(item, expectedItem);
    }
    Assertions.assertThat(expectedIterator.hasNext()).isEqualTo(false);
  }

  @Test
  void getEventDestinations() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/configuration/callbacks/applications/" + URLPathUtils.encodePathSegment("app/id"),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), getEventDestinationsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    EventDestinations response = service.getEventDestinations("app/id");

    TestHelpers.recursiveEquals(response, GetEventDestinationsResponseTest.expected);
  }

  @Test
  void updateEventDestinations() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/configuration/callbacks/applications/" + URLPathUtils.encodePathSegment("app/key"),
            HttpMethod.POST,
            Collections.emptyList(),
            updateEventDestinationsRequestDto,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.updateEventDestinations("app/key", UpdateEventDestinationsRequestTest.expected);
  }

  @Test
  void updateNumbers() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/configuration/numbers",
            HttpMethod.POST,
            Collections.emptyList(),
            updateNumbersRequestDto,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.assignNumbers(UpdateNumbersRequestTest.updateNumbersDto);
  }

  @Test
  void unassignNumber() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v1/configuration/numbers",
            HttpMethod.DELETE,
            Collections.emptyList(),
            unAssignNumberRequestDto,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.unassignNumber(UnAssignNumberRequestTest.unAssignNumberDto);
  }
}
