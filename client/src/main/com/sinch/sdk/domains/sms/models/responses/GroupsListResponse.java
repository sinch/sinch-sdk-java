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

  public GroupsListResponse(
      GroupsService service, Page<GroupsListRequestParameters, Group, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && null != page.getNextPageToken().getToken());
  }

  public GroupsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    GroupsListRequestParameters.Builder newParameters =
        GroupsListRequestParameters.builder(page.getParameters());
    Integer nextToken = page.getNextPageToken().getToken();
    newParameters.setPage(nextToken);
    return service.list(newParameters.build());
  }

  public Collection<Group> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "GroupsListResponse{" + "page=" + page + '}';
  }
}
