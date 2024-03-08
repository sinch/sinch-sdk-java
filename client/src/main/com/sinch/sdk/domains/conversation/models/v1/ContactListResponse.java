package com.sinch.sdk.domains.conversation.models.v1;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.ContactService;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all contacts
 *
 * @since 1.0
 */
public class ContactListResponse extends ListResponse<Contact> {

  private final Page<ContactListRequest, Contact, String> page;
  private final ContactService service;

  /**
   * Create paginated list response for Contacts
   *
   * @param service Service to be used to paginate across responses
   * @param page Page content
   */
  public ContactListResponse(
      ContactService service, Page<ContactListRequest, Contact, String> page) {
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
  public ContactListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ContactListRequest.Builder newParameters = ContactListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  /** {@inheritDoc} */
  @Override
  public Collection<Contact> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ContactListResponse{" + "page=" + page + '}';
  }
}
