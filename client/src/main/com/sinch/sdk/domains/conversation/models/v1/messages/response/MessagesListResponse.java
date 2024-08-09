package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all messages response
 *
 * @since _NEXT_VERSION_
 */
public class MessagesListResponse extends ListResponse<ConversationMessage> {

  private final Page<MessagesListRequest, ConversationMessage, String> page;
  private final MessagesService service;

  public MessagesListResponse(
      MessagesService service, Page<MessagesListRequest, ConversationMessage, String> page) {
    this.service = service;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  @Override
  public MessagesListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    MessagesListRequest.Builder newParameters = MessagesListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  @Override
  public Collection<ConversationMessage> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "MessagesListResponse{" + "page=" + page + '}';
  }
}
