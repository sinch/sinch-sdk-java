package com.sinch.sdk.domains.conversation.models.v1.contact.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.api.v1.ContactService;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.IdentityConflictsListRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all IdentityConflicts
 *
 * @since 2.0
 */
public class IdentityConflictsListResponse extends ListResponse<IdentityConflicts> {

  private final Page<IdentityConflictsListRequest, IdentityConflicts, String> page;
  private final ContactService service;

  /**
   * Create paginated list response for IdentityConflicts
   *
   * @param service Service to be used to paginate across responses
   * @param page Page content
   */
  public IdentityConflictsListResponse(
      ContactService service, Page<IdentityConflictsListRequest, IdentityConflicts, String> page) {
    this.service = service;
    this.page = page;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  /** {@inheritDoc} */
  @Override
  public IdentityConflictsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    IdentityConflictsListRequest.Builder newParameters =
        IdentityConflictsListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.listIdentityConflicts(newParameters.build());
  }

  /** {@inheritDoc} */
  @Override
  public Collection<IdentityConflicts> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "IdentityConflictsListResponse{" + "page=" + page + '}';
  }
}
