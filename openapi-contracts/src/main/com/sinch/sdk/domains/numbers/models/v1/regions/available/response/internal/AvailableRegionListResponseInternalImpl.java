package com.sinch.sdk.domains.numbers.models.v1.regions.available.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegion;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({AvailableRegionListResponseInternalImpl.JSON_PROPERTY_AVAILABLE_REGIONS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableRegionListResponseInternalImpl
    implements AvailableRegionListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AVAILABLE_REGIONS = "availableRegions";

  private OptionalValue<List<AvailableRegion>> availableRegions;

  public AvailableRegionListResponseInternalImpl() {}

  protected AvailableRegionListResponseInternalImpl(
      OptionalValue<List<AvailableRegion>> availableRegions) {
    this.availableRegions = availableRegions;
  }

  @JsonIgnore
  public List<AvailableRegion> getAvailableRegions() {
    return availableRegions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AVAILABLE_REGIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<AvailableRegion>> availableRegions() {
    return availableRegions;
  }

  /** Return true if this ListAvailableRegionsResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableRegionListResponseInternalImpl listAvailableRegionsResponse =
        (AvailableRegionListResponseInternalImpl) o;
    return Objects.equals(this.availableRegions, listAvailableRegionsResponse.availableRegions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableRegions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableRegionListResponseInternalImpl {\n");
    sb.append("    availableRegions: ").append(toIndentedString(availableRegions)).append("\n");
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
  static class Builder implements AvailableRegionListResponseInternal.Builder {
    OptionalValue<List<AvailableRegion>> availableRegions = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_AVAILABLE_REGIONS)
    public Builder setAvailableRegions(List<AvailableRegion> availableRegions) {
      this.availableRegions = OptionalValue.of(availableRegions);
      return this;
    }

    public AvailableRegionListResponseInternal build() {
      return new AvailableRegionListResponseInternalImpl(availableRegions);
    }
  }
}
