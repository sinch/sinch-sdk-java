package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  PaginationMetaImpl.JSON_PROPERTY_TOTAL_COUNT,
  PaginationMetaImpl.JSON_PROPERTY_PAGE_COUNT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PaginationMetaImpl implements PaginationMeta {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TOTAL_COUNT = "totalCount";

  private OptionalValue<Integer> totalCount;

  public static final String JSON_PROPERTY_PAGE_COUNT = "pageCount";

  private OptionalValue<Integer> pageCount;

  public PaginationMetaImpl() {}

  protected PaginationMetaImpl(
      OptionalValue<Integer> totalCount, OptionalValue<Integer> pageCount) {
    this.totalCount = totalCount;
    this.pageCount = pageCount;
  }

  @JsonIgnore
  public Integer getTotalCount() {
    return totalCount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> totalCount() {
    return totalCount;
  }

  @JsonIgnore
  public Integer getPageCount() {
    return pageCount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> pageCount() {
    return pageCount;
  }

  /** Return true if this PaginationMeta object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationMetaImpl paginationMeta = (PaginationMetaImpl) o;
    return Objects.equals(this.totalCount, paginationMeta.totalCount)
        && Objects.equals(this.pageCount, paginationMeta.pageCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, pageCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationMetaImpl {\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
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
  static class Builder implements PaginationMeta.Builder {
    OptionalValue<Integer> totalCount = OptionalValue.empty();
    OptionalValue<Integer> pageCount = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TOTAL_COUNT, required = true)
    public Builder setTotalCount(Integer totalCount) {
      this.totalCount = OptionalValue.of(totalCount);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PAGE_COUNT, required = true)
    public Builder setPageCount(Integer pageCount) {
      this.pageCount = OptionalValue.of(pageCount);
      return this;
    }

    public PaginationMeta build() {
      return new PaginationMetaImpl(totalCount, pageCount);
    }
  }
}
