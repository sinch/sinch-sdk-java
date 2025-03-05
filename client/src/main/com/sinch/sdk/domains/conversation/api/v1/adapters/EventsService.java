package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.conversation.api.v1.internal.EventsApi;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.ListEventsResponseInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.ListEventsResponseInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class EventsService implements com.sinch.sdk.domains.conversation.api.v1.EventsService {

  private final String uriUUID;
  private final EventsApi api;

  public EventsService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new EventsApi(httpClient, context.getServer(), authManagers, HttpMapper.getInstance());
  }

  protected EventsApi getApi() {
    return this.api;
  }

  public SendEventResponse send(SendEventRequest request) {
    return getApi().eventsSendEvent(uriUUID, request);
  }

  public ConversationEvent get(String eventId) {
    return getApi().eventsGetEvent(uriUUID, eventId);
  }

  public void delete(String eventId) {

    getApi().eventsDeleteEvents(uriUUID, eventId);
  }

  public EventsListResponse list(EventsListRequest request) {

    String conversationId = request.getConversationId().orElse(null);
    String contactId = request.getContactId().orElse(null);
    Integer pageSize = request.getPageSize().orElse(null);
    String pageToken = request.getPageToken().orElse(null);

    ListEventsResponseInternal response =
        getApi().eventsListEvents(uriUUID, conversationId, contactId, pageSize, pageToken);

    return mapForPaging(request, response);
  }

  private EventsListResponse mapForPaging(
      EventsListRequest parameters, ListEventsResponseInternal _dto) {

    ListEventsResponseInternalImpl dto = (ListEventsResponseInternalImpl) _dto;

    String nextPageToken = dto.nextPageToken().orElse(null);
    Collection<ConversationEvent> list = dto.events().orElse(Collections.emptyList());

    Pair<Collection<ConversationEvent>, TokenPageNavigator> paginated =
        new Pair<>(list, new TokenPageNavigator(nextPageToken));

    return new EventsListResponse(
        this, new Page<>(parameters, paginated.getLeft(), paginated.getRight()));
  }
}
