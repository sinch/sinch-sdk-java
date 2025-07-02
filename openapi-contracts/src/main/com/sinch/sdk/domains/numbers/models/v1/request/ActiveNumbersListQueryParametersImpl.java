package com.sinch.sdk.domains.numbers.models.v1.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.List;
import java.util.Objects;

public class ActiveNumbersListQueryParametersImpl implements ActiveNumbersListQueryParameters {

  private final OptionalValue<String> regionCode;
  private final OptionalValue<String> searchPattern;
  private final OptionalValue<SearchPosition> searchPosition;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<List<Capability>> capabilities;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<String> pageToken;
  private final OptionalValue<OrderByEnum> orderBy;

  private ActiveNumbersListQueryParametersImpl(
      OptionalValue<String> regionCode,
      OptionalValue<String> searchPattern,
      OptionalValue<SearchPosition> searchPosition,
      OptionalValue<NumberType> type,
      OptionalValue<List<Capability>> capabilities,
      OptionalValue<Integer> pageSize,
      OptionalValue<String> pageToken,
      OptionalValue<OrderByEnum> orderBy) {
    this.regionCode = regionCode;
    this.searchPattern = searchPattern;
    this.searchPosition = searchPosition;
    this.type = type;
    this.capabilities = capabilities;
    this.pageSize = pageSize;
    this.pageToken = pageToken;
    this.orderBy = orderBy;
  }

  public OptionalValue<String> getRegionCode() {
    return regionCode;
  }

  public OptionalValue<String> getSearchPattern() {
    return searchPattern;
  }

  public OptionalValue<SearchPosition> getSearchPosition() {
    return searchPosition;
  }

  public OptionalValue<NumberType> getType() {
    return type;
  }

  public OptionalValue<List<Capability>> getCapabilities() {
    return capabilities;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public OptionalValue<String> getPageToken() {
    return pageToken;
  }

  public OptionalValue<OrderByEnum> getOrderBy() {
    return orderBy;
  }

  /** Return true if this NumberServiceListActiveNumbersQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveNumbersListQueryParametersImpl numberServiceListActiveNumbersQueryParameters =
        (ActiveNumbersListQueryParametersImpl) o;
    return Objects.equals(this.regionCode, numberServiceListActiveNumbersQueryParameters.regionCode)
        && Objects.equals(
            this.searchPattern, numberServiceListActiveNumbersQueryParameters.searchPattern)
        && Objects.equals(
            this.searchPosition, numberServiceListActiveNumbersQueryParameters.searchPosition)
        && Objects.equals(this.type, numberServiceListActiveNumbersQueryParameters.type)
        && Objects.equals(
            this.capabilities, numberServiceListActiveNumbersQueryParameters.capabilities)
        && Objects.equals(this.pageSize, numberServiceListActiveNumbersQueryParameters.pageSize)
        && Objects.equals(this.pageToken, numberServiceListActiveNumbersQueryParameters.pageToken)
        && Objects.equals(this.orderBy, numberServiceListActiveNumbersQueryParameters.orderBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        regionCode,
        searchPattern,
        searchPosition,
        type,
        capabilities,
        pageSize,
        pageToken,
        orderBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveNumbersListQueryParametersImpl {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    searchPattern: ").append(toIndentedString(searchPattern)).append("\n");
    sb.append("    searchPosition: ").append(toIndentedString(searchPosition)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
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

  static class Builder implements ActiveNumbersListQueryParameters.Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<String> searchPattern = OptionalValue.empty();
    OptionalValue<SearchPosition> searchPosition = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<List<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<String> pageToken = OptionalValue.empty();
    OptionalValue<OrderByEnum> orderBy = OptionalValue.empty();

    protected Builder() {}

    protected Builder(ActiveNumbersListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      ActiveNumbersListQueryParametersImpl parameters =
          (ActiveNumbersListQueryParametersImpl) _parameters;
      this.regionCode = parameters.getRegionCode();
      this.searchPattern = parameters.getSearchPattern();
      this.searchPosition = parameters.getSearchPosition();
      this.type = parameters.getType();
      this.capabilities = parameters.getCapabilities();
      this.pageSize = parameters.getPageSize();
      this.pageToken = parameters.getPageToken();
      this.orderBy = parameters.getOrderBy();
    }

    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    public Builder setSearchPattern(String searchPattern) {
      this.searchPattern = OptionalValue.of(searchPattern);
      return this;
    }

    public Builder setSearchPosition(SearchPosition searchPosition) {
      this.searchPosition = OptionalValue.of(searchPosition);
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    public Builder setCapabilities(List<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public Builder setPageToken(String pageToken) {
      this.pageToken = OptionalValue.of(pageToken);
      return this;
    }

    public Builder setOrderBy(OrderByEnum orderBy) {
      this.orderBy = OptionalValue.of(orderBy);
      return this;
    }

    public ActiveNumbersListQueryParameters build() {
      return new ActiveNumbersListQueryParametersImpl(
          regionCode,
          searchPattern,
          searchPosition,
          type,
          capabilities,
          pageSize,
          pageToken,
          orderBy);
    }
  }
}
