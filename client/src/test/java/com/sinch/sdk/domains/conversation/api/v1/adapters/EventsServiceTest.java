package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.v1.internal.EventsApi;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.ListEventsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequestDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.models.ConversationContext;
import java.time.Instant;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class EventsServiceTest extends ConversationBaseTest {

  @Mock ConversationContext context;
  @Mock EventsApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> projectIdCaptor;
  @Captor ArgumentCaptor<String> eventIdCaptor;

  EventsService service;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    service = spy(new EventsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  SendEventResponse expectedResponse =
      SendEventResponse.builder().setEventId("event id").setAcceptedTime(Instant.now()).build();

  @GivenJsonResource("/domains/conversation/v1/events/response/EventsListResponse-page-0.json")
  ListEventsResponseInternal eventsListPage0;

  @GivenJsonResource("/domains/conversation/v1/events/response/EventsListResponse-page-1.json")
  ListEventsResponseInternal eventsListPage1;

  @Test
  void get() throws ApiException {

    when(api.eventsGetEvent(
            eq(uriPartID), eq(ConversationEventDtoTest.expectedConversationEventDto.getId())))
        .thenReturn(ConversationEventDtoTest.expectedConversationEventDto);

    ConversationEvent response =
        service.get(ConversationEventDtoTest.expectedConversationEventDto.getId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConversationEventDtoTest.expectedConversationEventDto);
  }

  @Test
  void send() throws ApiException {

    when(api.eventsSendEvent(eq(uriPartID), eq(SendEventRequestDtoTest.sendEventDto)))
        .thenReturn(expectedResponse);

    SendEventResponse response = service.send(SendEventRequestDtoTest.sendEventDto);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
  }

  @Test
  void delete() throws ApiException {

    service.delete(ConversationEventDtoTest.expectedConversationEventDto.getId());

    verify(api).eventsDeleteEvents(projectIdCaptor.capture(), eventIdCaptor.capture());

    Assertions.assertThat(projectIdCaptor.getValue()).isEqualTo(uriPartID);
    Assertions.assertThat(eventIdCaptor.getValue())
        .isEqualTo(ConversationEventDtoTest.expectedConversationEventDto.getId());
  }

  @Test
  void list() throws ApiException, JsonProcessingException {

    when(api.eventsListEvents(eq(uriPartID), eq("conversation id"), eq(null), eq(null), eq(null)))
        .thenReturn(eventsListPage0);

    when(api.eventsListEvents(
            eq(uriPartID),
            eq("conversation id"),
            eq(null),
            eq(null),
            eq(eventsListPage0.getNextPageToken())))
        .thenReturn(eventsListPage1);

    EventsListRequest request =
        EventsListRequest.builder().setConversationId("conversation id").build();

    EventsListResponse response0 = service.list(request);

    Assertions.assertThat(response0.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response0.hasNextPage()).isEqualTo(true);

    EventsListResponse response1 = response0.nextPage();
    Assertions.assertThat(response1.getContent().size()).isEqualTo(1);
    Assertions.assertThat(response1.hasNextPage()).isEqualTo(false);
  }
}
