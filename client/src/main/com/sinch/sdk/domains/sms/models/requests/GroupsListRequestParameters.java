package com.sinch.sdk.domains.sms.models.requests;

import java.util.Optional;

/**
 * Parameters request to list groups
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups</a>
 * @since 1.0
 */
public class GroupsListRequestParameters {

  private final Integer page;
  private final Integer pageSize;

  /**
   * @param page The page number starting from 0.
   * @param pageSize Determines the size of a page.
   */
  public GroupsListRequestParameters(Integer page, Integer pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  public Optional<Integer> getPage() {
    return Optional.ofNullable(page);
  }

  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(GroupsListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    Integer page;
    Integer pageSize;

    private Builder() {}

    private Builder(GroupsListRequestParameters parameters) {
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
    }

    public Builder setPage(Integer page) {
      this.page = page;
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public GroupsListRequestParameters build() {
      return new GroupsListRequestParameters(page, pageSize);
    }
  }
}
