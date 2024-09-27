package com.sinch.sdk.domains.conversation.models.v1.events.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all messages response
 *
 * @since 1.3
 */
public class EventsListResponse extends ListResponse<ConversationEvent> {

  private final Page<EventsListRequest, ConversationEvent, String> page;
  private final EventsService service;

  public EventsListResponse(
      EventsService service, Page<EventsListRequest, ConversationEvent, String> page) {
    this.service = service;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  @Override
  public EventsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    EventsListRequest.Builder newParameters = EventsListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  @Override
  public Collection<ConversationEvent> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "EventsListResponse{" + "page=" + page + '}';
  }
}
