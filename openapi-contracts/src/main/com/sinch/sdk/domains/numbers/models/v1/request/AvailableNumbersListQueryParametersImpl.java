package com.sinch.sdk.domains.numbers.models.v1.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.List;
import java.util.Objects;

public class AvailableNumbersListQueryParametersImpl
    implements AvailableNumbersListQueryParameters {

  private final OptionalValue<String> searchPattern;
  private final OptionalValue<SearchPosition> searchPosition;
  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<List<Capability>> capabilities;
  private final OptionalValue<Integer> size;

  private AvailableNumbersListQueryParametersImpl(
      OptionalValue<String> searchPattern,
      OptionalValue<SearchPosition> searchPosition,
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<List<Capability>> capabilities,
      OptionalValue<Integer> size) {
    this.searchPattern = searchPattern;
    this.searchPosition = searchPosition;
    this.regionCode = regionCode;
    this.type = type;
    this.capabilities = capabilities;
    this.size = size;
  }

  public OptionalValue<String> getSearchPattern() {
    return searchPattern;
  }

  public OptionalValue<SearchPosition> getSearchPosition() {
    return searchPosition;
  }

  public OptionalValue<String> getRegionCode() {
    return regionCode;
  }

  public OptionalValue<NumberType> getType() {
    return type;
  }

  public OptionalValue<List<Capability>> getCapabilities() {
    return capabilities;
  }

  public OptionalValue<Integer> getSize() {
    return size;
  }

  /** Return true if this NumberServiceListAvailableNumbersQueryParameters object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumbersListQueryParametersImpl numberServiceListAvailableNumbersQueryParameters =
        (AvailableNumbersListQueryParametersImpl) o;
    return Objects.equals(
            this.searchPattern, numberServiceListAvailableNumbersQueryParameters.searchPattern)
        && Objects.equals(
            this.searchPosition, numberServiceListAvailableNumbersQueryParameters.searchPosition)
        && Objects.equals(
            this.regionCode, numberServiceListAvailableNumbersQueryParameters.regionCode)
        && Objects.equals(this.type, numberServiceListAvailableNumbersQueryParameters.type)
        && Objects.equals(
            this.capabilities, numberServiceListAvailableNumbersQueryParameters.capabilities)
        && Objects.equals(this.size, numberServiceListAvailableNumbersQueryParameters.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchPattern, searchPosition, regionCode, type, capabilities, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumbersListQueryParametersImpl {\n");
    sb.append("    searchPattern: ").append(toIndentedString(searchPattern)).append("\n");
    sb.append("    searchPosition: ").append(toIndentedString(searchPosition)).append("\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

  static class Builder implements AvailableNumbersListQueryParameters.Builder {
    OptionalValue<String> searchPattern = OptionalValue.empty();
    OptionalValue<SearchPosition> searchPosition = OptionalValue.empty();
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<List<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<Integer> size = OptionalValue.empty();

    protected Builder() {}

    protected Builder(AvailableNumbersListQueryParameters _parameters) {
      if (null == _parameters) {
        return;
      }
      AvailableNumbersListQueryParametersImpl parameters =
          (AvailableNumbersListQueryParametersImpl) _parameters;
      this.searchPattern = parameters.getSearchPattern();
      this.searchPosition = parameters.getSearchPosition();
      this.regionCode = parameters.getRegionCode();
      this.type = parameters.getType();
      this.capabilities = parameters.getCapabilities();
      this.size = parameters.getSize();
    }

    public Builder setSearchPattern(String searchPattern) {
      this.searchPattern = OptionalValue.of(searchPattern);
      return this;
    }

    public Builder setSearchPosition(SearchPosition searchPosition) {
      this.searchPosition = OptionalValue.of(searchPosition);
      return this;
    }

    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
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

    public Builder setSize(Integer size) {
      this.size = OptionalValue.of(size);
      return this;
    }

    public AvailableNumbersListQueryParameters build() {
      return new AvailableNumbersListQueryParametersImpl(
          searchPattern, searchPosition, regionCode, type, capabilities, size);
    }
  }
}
