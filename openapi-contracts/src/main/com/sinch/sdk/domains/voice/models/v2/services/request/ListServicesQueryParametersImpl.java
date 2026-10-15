package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ListServicesQueryParametersImpl implements ListServicesQueryParameters {

  private final OptionalValue<String> filter;
  private final OptionalValue<Boolean> isDefault;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Integer> page;

  private ListServicesQueryParametersImpl(
      OptionalValue<String> filter,
      OptionalValue<Boolean> isDefault,
      OptionalValue<Integer> pageSize,
      OptionalValue<Integer> page) {
    this.filter = filter;
    this.isDefault = isDefault;
    this.pageSize = pageSize;
    this.page = page;
  }

  public OptionalValue<String> getFilter() {
    return filter;
  }

  public OptionalValue<Boolean> getIsDefault() {
    return isDefault;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  /** Return true if this ListServicesQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListServicesQueryParametersImpl parameters = (ListServicesQueryParametersImpl) o;
    return Objects.equals(this.filter, parameters.filter)
        && Objects.equals(this.isDefault, parameters.isDefault)
        && Objects.equals(this.pageSize, parameters.pageSize)
        && Objects.equals(this.page, parameters.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filter, isDefault, pageSize, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListServicesQueryParametersImpl {\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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

  static class Builder implements ListServicesQueryParameters.Builder {
    OptionalValue<String> filter = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListServicesQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListServicesQueryParametersImpl parameters = (ListServicesQueryParametersImpl) _parameters;
      this.filter = parameters.getFilter();
      this.isDefault = parameters.getIsDefault();
      this.pageSize = parameters.getPageSize();
      this.page = parameters.getPage();
    }

    public Builder setFilter(String filter) {
      this.filter = OptionalValue.of(filter);
      return this;
    }

    public Builder setIsDefault(Boolean isDefault) {
      this.isDefault = OptionalValue.of(isDefault);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public ListServicesQueryParameters build() {
      return new ListServicesQueryParametersImpl(filter, isDefault, pageSize, page);
    }
  }
}
