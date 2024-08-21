package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all conversations response
 *
 * @since _NEXT_VERSION_
 */
public class ConversationsListResponse extends ListResponse<Conversation> {

  private final Page<ConversationsListRequest, Conversation, String> page;
  private final ConversationsService service;

  public ConversationsListResponse(
      ConversationsService service, Page<ConversationsListRequest, Conversation, String> page) {
    this.service = service;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  @Override
  public ConversationsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ConversationsListRequest.Builder newParameters =
        ConversationsListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  @Override
  public Collection<Conversation> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ConversationsListResponse{" + "page=" + page + '}';
  }
}
