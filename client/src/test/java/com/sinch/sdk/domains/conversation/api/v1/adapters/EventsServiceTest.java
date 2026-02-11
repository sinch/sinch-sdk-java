package com.sinch.sdk.domains.conversation.api.v1.adapters;

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
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListQueryParameters;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class EventsServiceTest extends ConversationBaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String uriUUID = "foo";
  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "oAuth2");

  EventsService service;

  @GivenTextResource("domains/conversation/v1/events/ConversationEventGenericEventDto.json")
  String jsonConversationEvent;

  @GivenTextResource("/domains/conversation/v1/events/response/EventsListResponse-page-0.json")
  String eventsListPage0;

  @GivenTextResource("/domains/conversation/v1/events/response/EventsListResponse-page-1.json")
  String eventsListPage1;

  @GivenTextResource("/domains/conversation/v1/events/request/SendEventRequestDto.json")
  String jsonSendEventRequestDto;

  @GivenTextResource("domains/conversation/v1/events/response/SendEventResponseDto.json")
  String jsonSendEventResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new EventsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), uriUUID);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/events/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    ConversationEventDtoTest.expectedConversationEventDto.getId())),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonConversationEvent.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ConversationEvent response =
        service.get(ConversationEventDtoTest.expectedConversationEventDto.getId());

    TestHelpers.recursiveEquals(response, ConversationEventDtoTest.expectedConversationEventDto);
  }

  @Test
  void send() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format("/v1/projects/%s/events:send", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.POST,
            Collections.emptyList(),
            jsonSendEventRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonSendEventResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendEventResponse response = service.send(SendEventRequestDtoTest.sendEventDto);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(SendEventResponseDtoTest.expectedResponse);
  }

  @Test
  void delete() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            String.format(
                "/v1/projects/%s/events/%s",
                URLPathUtils.encodePathSegment(uriUUID),
                URLPathUtils.encodePathSegment(
                    SendEventResponseDtoTest.expectedResponse.getEventId())),
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

    service.delete(SendEventResponseDtoTest.expectedResponse.getEventId());
  }

  @Test
  void list() throws ApiException {

    HttpRequest httpRequest1 =
        new HttpRequest(
            String.format("/v1/projects/%s/events", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(new URLParameter("conversation_id", "conversation id", STYLE.FORM, true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpRequest httpRequest2 =
        new HttpRequest(
            String.format("/v1/projects/%s/events", URLPathUtils.encodePathSegment(uriUUID)),
            HttpMethod.GET,
            Arrays.asList(
                new URLParameter("conversation_id", "conversation id", STYLE.FORM, true),
                new URLParameter(
                    "page_token",
                    "ChowMUhRN1c0WjFSMTI2N0RCQlI4UzQ3TlZQOEoGCP70264G",
                    STYLE.FORM,
                    true)),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse1 =
        new HttpResponse(200, null, Collections.emptyMap(), eventsListPage0.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(200, null, Collections.emptyMap(), eventsListPage1.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest1))))
        .thenReturn(httpResponse1);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest2))))
        .thenReturn(httpResponse2);

    EventsListQueryParameters request =
        EventsListQueryParameters.builder().setConversationId("conversation id").build();

    EventsListResponse response0 = service.list(request);

    Assertions.assertThat(response0.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    EventsListResponse response1 = response0.nextPage();
    Assertions.assertThat(response1.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }
}
