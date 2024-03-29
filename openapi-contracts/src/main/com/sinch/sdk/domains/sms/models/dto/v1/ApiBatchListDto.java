/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ApiBatchListDto */
@JsonPropertyOrder({
  ApiBatchListDto.JSON_PROPERTY_COUNT,
  ApiBatchListDto.JSON_PROPERTY_PAGE,
  ApiBatchListDto.JSON_PROPERTY_BATCHES,
  ApiBatchListDto.JSON_PROPERTY_PAGE_SIZE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ApiBatchListDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_COUNT = "count";
  private Long count;
  private boolean countDefined = false;

  public static final String JSON_PROPERTY_PAGE = "page";
  private Integer page;
  private boolean pageDefined = false;

  public static final String JSON_PROPERTY_BATCHES = "batches";
  private List<ApiBatchListBatchesInnerDto> batches;
  private boolean batchesDefined = false;

  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";
  private Integer pageSize;
  private boolean pageSizeDefined = false;

  public ApiBatchListDto() {}

  public ApiBatchListDto count(Long count) {
    this.count = count;
    this.countDefined = true;
    return this;
  }

  /**
   * The total number of entries matching the given filters.
   *
   * @return count
   */
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getCount() {
    return count;
  }

  @JsonIgnore
  public boolean getCountDefined() {
    return countDefined;
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCount(Long count) {
    this.count = count;
    this.countDefined = true;
  }

  public ApiBatchListDto page(Integer page) {
    this.page = page;
    this.pageDefined = true;
    return this;
  }

  /**
   * The requested page.
   *
   * @return page
   */
  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getPage() {
    return page;
  }

  @JsonIgnore
  public boolean getPageDefined() {
    return pageDefined;
  }

  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPage(Integer page) {
    this.page = page;
    this.pageDefined = true;
  }

  public ApiBatchListDto batches(List<ApiBatchListBatchesInnerDto> batches) {
    this.batches = batches;
    this.batchesDefined = true;
    return this;
  }

  public ApiBatchListDto addBatchesItem(ApiBatchListBatchesInnerDto batchesItem) {
    if (this.batches == null) {
      this.batches = new ArrayList<>();
    }
    this.batchesDefined = true;
    this.batches.add(batchesItem);
    return this;
  }

  /**
   * The page of batches matching the given filters.
   *
   * @return batches
   */
  @JsonProperty(JSON_PROPERTY_BATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ApiBatchListBatchesInnerDto> getBatches() {
    return batches;
  }

  @JsonIgnore
  public boolean getBatchesDefined() {
    return batchesDefined;
  }

  @JsonProperty(JSON_PROPERTY_BATCHES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBatches(List<ApiBatchListBatchesInnerDto> batches) {
    this.batches = batches;
    this.batchesDefined = true;
  }

  public ApiBatchListDto pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    this.pageSizeDefined = true;
    return this;
  }

  /**
   * The number of entries returned in this request.
   *
   * @return pageSize
   */
  @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getPageSize() {
    return pageSize;
  }

  @JsonIgnore
  public boolean getPageSizeDefined() {
    return pageSizeDefined;
  }

  @JsonProperty(JSON_PROPERTY_PAGE_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    this.pageSizeDefined = true;
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
    ApiBatchListDto apiBatchList = (ApiBatchListDto) o;
    return Objects.equals(this.count, apiBatchList.count)
        && Objects.equals(this.page, apiBatchList.page)
        && Objects.equals(this.batches, apiBatchList.batches)
        && Objects.equals(this.pageSize, apiBatchList.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, page, batches, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiBatchListDto {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    batches: ").append(toIndentedString(batches)).append("\n");
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
}
