package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ListTemplatesQueryParametersImpl implements ListTemplatesQueryParameters {

  private final OptionalValue<String> page;
  private final OptionalValue<Integer> limit;
  private final OptionalValue<String> pivot;

  private ListTemplatesQueryParametersImpl(
      OptionalValue<String> page, OptionalValue<Integer> limit, OptionalValue<String> pivot) {
    this.page = page;
    this.limit = limit;
    this.pivot = pivot;
  }

  public OptionalValue<String> getPage() {
    return page;
  }

  public OptionalValue<Integer> getLimit() {
    return limit;
  }

  public OptionalValue<String> getPivot() {
    return pivot;
  }

  /** Return true if this GETV3DomainNameTemplatesQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTemplatesQueryParametersImpl geTV3DomainNameTemplatesQueryParameters =
        (ListTemplatesQueryParametersImpl) o;
    return Objects.equals(this.page, geTV3DomainNameTemplatesQueryParameters.page)
        && Objects.equals(this.limit, geTV3DomainNameTemplatesQueryParameters.limit)
        && Objects.equals(this.pivot, geTV3DomainNameTemplatesQueryParameters.pivot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, limit, pivot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTemplatesQueryParametersImpl {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    pivot: ").append(toIndentedString(pivot)).append("\n");
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

  static class Builder implements ListTemplatesQueryParameters.Builder {
    OptionalValue<String> page = OptionalValue.empty();
    OptionalValue<Integer> limit = OptionalValue.empty();
    OptionalValue<String> pivot = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListTemplatesQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListTemplatesQueryParametersImpl parameters = (ListTemplatesQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.limit = parameters.getLimit();
      this.pivot = parameters.getPivot();
    }

    public Builder setPage(String page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    public Builder setLimit(Integer limit) {
      this.limit = OptionalValue.of(limit);
      return this;
    }

    public Builder setPivot(String pivot) {
      this.pivot = OptionalValue.of(pivot);
      return this;
    }

    public ListTemplatesQueryParameters build() {
      return new ListTemplatesQueryParametersImpl(page, limit, pivot);
    }
  }
}
