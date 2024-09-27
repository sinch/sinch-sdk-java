package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Recent messages and conversation response
 *
 * @since 1.3
 */
public class ConversationsListRecentResponse extends ListResponse<ConversationRecentMessage> {

  private final Page<ConversationsListRecentRequest, ConversationRecentMessage, String> page;
  private final ConversationsService service;

  public ConversationsListRecentResponse(
      ConversationsService service,
      Page<ConversationsListRecentRequest, ConversationRecentMessage, String> page) {
    this.service = service;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  @Override
  public ConversationsListRecentResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ConversationsListRecentRequest.Builder newParameters =
        ConversationsListRecentRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.listRecent(newParameters.build());
  }

  @Override
  public Collection<ConversationRecentMessage> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ConversationsListRecentResponse{" + "page=" + page + '}';
  }
}
