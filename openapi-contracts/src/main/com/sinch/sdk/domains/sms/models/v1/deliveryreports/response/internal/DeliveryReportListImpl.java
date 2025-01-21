package com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  DeliveryReportListImpl.JSON_PROPERTY_COUNT,
  DeliveryReportListImpl.JSON_PROPERTY_PAGE,
  DeliveryReportListImpl.JSON_PROPERTY_PAGE_SIZE,
  DeliveryReportListImpl.JSON_PROPERTY_DELIVERY_REPORTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DeliveryReportListImpl implements DeliveryReportList {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COUNT = "count";

  private OptionalValue<Long> count;

  public static final String JSON_PROPERTY_PAGE = "page";

  private OptionalValue<Integer> page;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  private OptionalValue<Integer> pageSize;

  public static final String JSON_PROPERTY_DELIVERY_REPORTS = "delivery_reports";

  private OptionalValue<List<RecipientDeliveryReport>> items;

  public DeliveryReportListImpl() {}

  protected DeliveryReportListImpl(
      OptionalValue<Long> count,
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<List<RecipientDeliveryReport>> items) {
    this.count = count;
    this.page = page;
    this.pageSize = pageSize;
    this.items = items;
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
  public Integer getPageSize() {
    return pageSize.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> pageSize() {
    return pageSize;
  }

  @JsonIgnore
  public List<RecipientDeliveryReport> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DELIVERY_REPORTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<RecipientDeliveryReport>> items() {
    return items;
  }

  /** Return true if this DeliveryReportList object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryReportListImpl deliveryReportList = (DeliveryReportListImpl) o;
    return Objects.equals(this.count, deliveryReportList.count)
        && Objects.equals(this.page, deliveryReportList.page)
        && Objects.equals(this.pageSize, deliveryReportList.pageSize)
        && Objects.equals(this.items, deliveryReportList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, pageSize, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryReportListImpl {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
  static class Builder implements DeliveryReportList.Builder {
    OptionalValue<Long> count = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<List<RecipientDeliveryReport>> items = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DELIVERY_REPORTS)
    public Builder setItems(List<RecipientDeliveryReport> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    public DeliveryReportList build() {
      return new DeliveryReportListImpl(count, page, pageSize, items);
    }
  }
}
