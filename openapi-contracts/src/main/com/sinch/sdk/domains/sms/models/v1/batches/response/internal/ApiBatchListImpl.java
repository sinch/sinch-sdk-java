package com.sinch.sdk.domains.sms.models.v1.batches.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ApiBatchListImpl.JSON_PROPERTY_COUNT,
  ApiBatchListImpl.JSON_PROPERTY_PAGE,
  ApiBatchListImpl.JSON_PROPERTY_BATCHES,
  ApiBatchListImpl.JSON_PROPERTY_PAGE_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiBatchListImpl implements ApiBatchList {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COUNT = "count";

  private OptionalValue<Long> count;

  public static final String JSON_PROPERTY_PAGE = "page";

  private OptionalValue<Integer> page;

  public static final String JSON_PROPERTY_BATCHES = "batches";

  private OptionalValue<List<BatchResponse>> items;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  private OptionalValue<Integer> pageSize;

  public ApiBatchListImpl() {}

  protected ApiBatchListImpl(
      OptionalValue<Long> count,
      OptionalValue<Integer> page,
      OptionalValue<List<BatchResponse>> items,
      OptionalValue<Integer> pageSize) {
    this.count = count;
    this.page = page;
    this.items = items;
    this.pageSize = pageSize;
  }

  @JsonIgnore
  public Long getCount() {
    return count.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Long> count() {
    return count;
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
  public List<BatchResponse> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<BatchResponse>> items() {
    return items;
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

  /** Return true if this ApiBatchList object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiBatchListImpl apiBatchList = (ApiBatchListImpl) o;
    return Objects.equals(this.count, apiBatchList.count)
        && Objects.equals(this.page, apiBatchList.page)
        && Objects.equals(this.items, apiBatchList.items)
        && Objects.equals(this.pageSize, apiBatchList.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, items, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiBatchListImpl {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ApiBatchList.Builder {
    OptionalValue<Long> count = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<List<BatchResponse>> items = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_COUNT)
    public Builder setCount(Long count) {
      this.count = OptionalValue.of(count);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE)
    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BATCHES)
    public Builder setItems(List<BatchResponse> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public ApiBatchList build() {
      return new ApiBatchListImpl(count, page, items, pageSize);
    }
  }
}
