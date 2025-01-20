package com.sinch.sdk.domains.sms.models.v1.inbounds.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ApiInboundListImpl.JSON_PROPERTY_COUNT,
  ApiInboundListImpl.JSON_PROPERTY_PAGE,
  ApiInboundListImpl.JSON_PROPERTY_INBOUNDS,
  ApiInboundListImpl.JSON_PROPERTY_PAGE_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiInboundListImpl implements ApiInboundList {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COUNT = "count";

  private OptionalValue<Long> count;

  public static final String JSON_PROPERTY_PAGE = "page";

  private OptionalValue<Integer> page;

  public static final String JSON_PROPERTY_INBOUNDS = "inbounds";

  private OptionalValue<List<InboundMessage>> items;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  private OptionalValue<Integer> pageSize;

  public ApiInboundListImpl() {}

  protected ApiInboundListImpl(
      OptionalValue<Long> count,
      OptionalValue<Integer> page,
      OptionalValue<List<InboundMessage>> items,
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
  public List<InboundMessage> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INBOUNDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<InboundMessage>> items() {
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

  /** Return true if this ApiInboundList object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiInboundListImpl apiInboundList = (ApiInboundListImpl) o;
    return Objects.equals(this.count, apiInboundList.count)
        && Objects.equals(this.page, apiInboundList.page)
        && Objects.equals(this.items, apiInboundList.items)
        && Objects.equals(this.pageSize, apiInboundList.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, items, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiInboundListImpl {\n");
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
  static class Builder implements ApiInboundList.Builder {
    OptionalValue<Long> count = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<List<InboundMessage>> items = OptionalValue.empty();
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

    @JsonProperty(JSON_PROPERTY_INBOUNDS)
    public Builder setItems(List<InboundMessage> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public ApiInboundList build() {
      return new ApiInboundListImpl(count, page, items, pageSize);
    }
  }
}
