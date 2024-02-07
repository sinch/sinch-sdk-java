package com.sinch.sdk.domains.conversation.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.conversation.ContactService;
import com.sinch.sdk.domains.conversation.models.Contact;
import com.sinch.sdk.domains.conversation.models.requests.ContactListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all contacts
 *
 * @since 1.0
 */
public class ContactListResponse extends ListResponse<Contact> {

  private final Page<ContactListRequestParameters, Contact, String> page;
  private final ContactService service;

  public ContactListResponse(
      ContactService service, Page<ContactListRequestParameters, Contact, String> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  public ContactListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ContactListRequestParameters.Builder newParameters =
        ContactListRequestParameters.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  public Collection<Contact> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ContactListResponse{" + "page=" + page + '}';
  }
}
