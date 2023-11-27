package com.sinch.sdk.domains.sms.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.GroupsService;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupsListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Groups List response
 *
 * @since 1.0
 */
public class GroupsListResponse extends ListResponse<Group> {

  private final Page<GroupsListRequestParameters, Group, Integer> page;
  private final GroupsService service;
  private GroupsListResponse nextPage;

  public GroupsListResponse(
      GroupsService service, Page<GroupsListRequestParameters, Group, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == nextPage) {
      GroupsListRequestParameters.Builder newParameters =
          GroupsListRequestParameters.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public GroupsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    GroupsListResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<Group> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "GroupsListResponse{" + "page=" + page + '}';
  }
}
