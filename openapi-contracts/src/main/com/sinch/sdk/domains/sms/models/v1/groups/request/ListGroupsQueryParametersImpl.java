package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ListGroupsQueryParametersImpl implements ListGroupsQueryParameters {

  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;

  private ListGroupsQueryParametersImpl(
      OptionalValue<Integer> page, OptionalValue<Integer> pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  /** Return true if this ListGroupsQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListGroupsQueryParametersImpl listGroupsQueryParameters = (ListGroupsQueryParametersImpl) o;
    return Objects.equals(this.page, listGroupsQueryParameters.page)
        && Objects.equals(this.pageSize, listGroupsQueryParameters.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListGroupsQueryParametersImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

  static class Builder implements ListGroupsQueryParameters.Builder {
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListGroupsQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListGroupsQueryParametersImpl parameters = (ListGroupsQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.pageSize = parameters.getPageSize();
    }

    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public ListGroupsQueryParameters build() {
      return new ListGroupsQueryParametersImpl(page, pageSize);
    }
  }
}
