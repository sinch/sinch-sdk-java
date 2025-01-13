package com.sinch.sdk.domains.sms.models.v1.groups.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ApiGroupListImpl.JSON_PROPERTY_PAGE,
  ApiGroupListImpl.JSON_PROPERTY_PAGE_SIZE,
  ApiGroupListImpl.JSON_PROPERTY_COUNT,
  ApiGroupListImpl.JSON_PROPERTY_GROUPS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiGroupListImpl implements ApiGroupList {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PAGE = "page";

  private OptionalValue<Integer> page;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  private OptionalValue<Integer> pageSize;

  public static final String JSON_PROPERTY_COUNT = "count";

  private OptionalValue<Integer> count;

  public static final String JSON_PROPERTY_GROUPS = "groups";

  private OptionalValue<List<Group>> groups;

  public ApiGroupListImpl() {}

  protected ApiGroupListImpl(
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<Integer> count,
      OptionalValue<List<Group>> groups) {
    this.page = page;
    this.pageSize = pageSize;
    this.count = count;
    this.groups = groups;
  }

  @JsonIgnore
  public Integer getPage() {
    return page.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> page() {
    return page;
  }

  @JsonIgnore
  public Integer getPageSize() {
    return pageSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> pageSize() {
    return pageSize;
  }

  @JsonIgnore
  public Integer getCount() {
    return count.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> count() {
    return count;
  }

  @JsonIgnore
  public List<Group> getGroups() {
    return groups.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Group>> groups() {
    return groups;
  }

  /** Return true if this ApiGroupList object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiGroupListImpl apiGroupList = (ApiGroupListImpl) o;
    return Objects.equals(this.page, apiGroupList.page)
        && Objects.equals(this.pageSize, apiGroupList.pageSize)
        && Objects.equals(this.count, apiGroupList.count)
        && Objects.equals(this.groups, apiGroupList.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, count, groups);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiGroupListImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ApiGroupList.Builder {
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Integer> count = OptionalValue.empty();
    OptionalValue<List<Group>> groups = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PAGE)
    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUNT)
    public Builder setCount(Integer count) {
      this.count = OptionalValue.of(count);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_GROUPS)
    public Builder setGroups(List<Group> groups) {
      this.groups = OptionalValue.of(groups);
      return this;
    }

    public ApiGroupList build() {
      return new ApiGroupListImpl(page, pageSize, count, groups);
    }
  }
}
