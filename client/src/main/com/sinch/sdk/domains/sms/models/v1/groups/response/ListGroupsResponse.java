package com.sinch.sdk.domains.sms.models.v1.groups.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.ListGroupsQueryParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ListGroupsResponse extends ListResponse<Group> {

  private final Page<ListGroupsQueryParameters, Group, Integer> page;
  private final GroupsService service;
  private ListGroupsResponse nextPage;

  public ListGroupsResponse(
      GroupsService service, Page<ListGroupsQueryParameters, Group, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == page.getNextPageToken() || null == getContent() || getContent().isEmpty()) {
      return false;
    }
    if (null == nextPage) {
      ListGroupsQueryParameters.Builder newParameters =
          ListGroupsQueryParameters.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public ListGroupsResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    ListGroupsResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<Group> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ListGroupsResponse {" + "page=" + page + '}';
  }
}
