package com.sinch.sdk.domains.numbers.models.v1.regions.available.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AvailableRegionImpl.JSON_PROPERTY_REGION_CODE,
  AvailableRegionImpl.JSON_PROPERTY_REGION_NAME,
  AvailableRegionImpl.JSON_PROPERTY_TYPES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableRegionImpl implements AvailableRegion {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_REGION_NAME = "regionName";

  private OptionalValue<String> regionName;

  public static final String JSON_PROPERTY_TYPES = "types";

  private OptionalValue<List<NumberType>> types;

  public AvailableRegionImpl() {}

  protected AvailableRegionImpl(
      OptionalValue<String> regionCode,
      OptionalValue<String> regionName,
      OptionalValue<List<NumberType>> types) {
    this.regionCode = regionCode;
    this.regionName = regionName;
    this.types = types;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  @JsonIgnore
  public String getRegionName() {
    return regionName.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> regionName() {
    return regionName;
  }

  @JsonIgnore
  public List<NumberType> getTypes() {
    return types.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<List<NumberType>> types() {
    return types;
  }

  /** Return true if this AvailableRegion object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableRegionImpl availableRegion = (AvailableRegionImpl) o;
    return Objects.equals(this.regionCode, availableRegion.regionCode)
        && Objects.equals(this.regionName, availableRegion.regionName)
        && Objects.equals(this.types, availableRegion.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionCode, regionName, types);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableRegionImpl {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
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
  static class Builder implements AvailableRegion.Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<String> regionName = OptionalValue.empty();
    OptionalValue<List<NumberType>> types = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REGION_CODE)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REGION_NAME)
    public Builder setRegionName(String regionName) {
      this.regionName = OptionalValue.of(regionName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPES)
    public Builder setTypes(List<NumberType> types) {
      this.types = OptionalValue.of(types);
      return this;
    }

    public AvailableRegion build() {
      return new AvailableRegionImpl(regionCode, regionName, types);
    }
  }
}
