package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

public class ListVersionsQueryParametersImpl implements ListVersionsQueryParameters {

  private final OptionalValue<PageEnum> page;
  private final OptionalValue<Integer> limit;
  private final OptionalValue<String> pivot;

  private ListVersionsQueryParametersImpl(
      OptionalValue<PageEnum> page, OptionalValue<Integer> limit, OptionalValue<String> pivot) {
    this.page = page;
    this.limit = limit;
    this.pivot = pivot;
  }

  public OptionalValue<PageEnum> getPage() {
    return page;
  }

  public OptionalValue<Integer> getLimit() {
    return limit;
  }

  public OptionalValue<String> getPivot() {
    return pivot;
  }

  /**
   * Return true if this GETV3DomainNameTemplatesTemplateNameVersionsQueryParameters object is equal
   * to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListVersionsQueryParametersImpl geTV3DomainNameTemplatesTemplateNameVersionsQueryParameters =
        (ListVersionsQueryParametersImpl) o;
    return Objects.equals(
            this.page, geTV3DomainNameTemplatesTemplateNameVersionsQueryParameters.page)
        && Objects.equals(
            this.limit, geTV3DomainNameTemplatesTemplateNameVersionsQueryParameters.limit)
        && Objects.equals(
            this.pivot, geTV3DomainNameTemplatesTemplateNameVersionsQueryParameters.pivot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, limit, pivot);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListVersionsQueryParametersImpl {\n");
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

  static class Builder implements ListVersionsQueryParameters.Builder {
    OptionalValue<PageEnum> page = OptionalValue.empty();
    OptionalValue<Integer> limit = OptionalValue.empty();
    OptionalValue<String> pivot = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ListVersionsQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ListVersionsQueryParametersImpl parameters = (ListVersionsQueryParametersImpl) _parameters;
      this.page = parameters.getPage();
      this.limit = parameters.getLimit();
      this.pivot = parameters.getPivot();
    }

    public Builder setPage(PageEnum page) {
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

    public ListVersionsQueryParameters build() {
      return new ListVersionsQueryParametersImpl(page, limit, pivot);
    }
  }
}
