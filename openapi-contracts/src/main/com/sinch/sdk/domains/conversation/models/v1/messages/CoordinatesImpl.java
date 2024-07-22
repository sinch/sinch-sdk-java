package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CoordinatesImpl.JSON_PROPERTY_LATITUDE,
  CoordinatesImpl.JSON_PROPERTY_LONGITUDE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CoordinatesImpl implements Coordinates {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LATITUDE = "latitude";

  private OptionalValue<Float> latitude;

  public static final String JSON_PROPERTY_LONGITUDE = "longitude";

  private OptionalValue<Float> longitude;

  public CoordinatesImpl() {}

  protected CoordinatesImpl(OptionalValue<Float> latitude, OptionalValue<Float> longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  @JsonIgnore
  public Float getLatitude() {
    return latitude.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Float> latitude() {
    return latitude;
  }

  @JsonIgnore
  public Float getLongitude() {
    return longitude.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Float> longitude() {
    return longitude;
  }

  /** Return true if this Coordinates object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoordinatesImpl coordinates = (CoordinatesImpl) o;
    return Objects.equals(this.latitude, coordinates.latitude)
        && Objects.equals(this.longitude, coordinates.longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoordinatesImpl {\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
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
  static class Builder implements Coordinates.Builder {
    OptionalValue<Float> latitude = OptionalValue.empty();
    OptionalValue<Float> longitude = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LATITUDE)
    public Builder setLatitude(Float latitude) {
      this.latitude = OptionalValue.of(latitude);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LONGITUDE)
    public Builder setLongitude(Float longitude) {
      this.longitude = OptionalValue.of(longitude);
      return this;
    }

    public Coordinates build() {
      return new CoordinatesImpl(latitude, longitude);
    }
  }
}