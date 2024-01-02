package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Parameters request to list groups
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Groups/#tag/Groups/operation/ListGroups</a>
 * @since 1.0
 */
public class GroupsListRequestParameters {

  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;

  public GroupsListRequestParameters(OptionalValue<Integer> page, OptionalValue<Integer> pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(GroupsListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();

    private Builder() {}

    private Builder(GroupsListRequestParameters parameters) {
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
    }

    /**
     * @param page The page number starting from 0.
     * @return current builder
     */
    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    /**
     * @param pageSize Determines the size of a page.
     * @return current builder
     */
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public GroupsListRequestParameters build() {
      return new GroupsListRequestParameters(page, pageSize);
    }
  }
}
