package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.Coordinates;
import java.util.Objects;

@JsonPropertyOrder({
  LocationMessageInternalImpl.JSON_PROPERTY_COORDINATES,
  LocationMessageInternalImpl.JSON_PROPERTY_LABEL,
  LocationMessageInternalImpl.JSON_PROPERTY_TITLE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LocationMessageInternalImpl implements LocationMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COORDINATES = "coordinates";

  private OptionalValue<Coordinates> coordinates;

  public static final String JSON_PROPERTY_LABEL = "label";

  private OptionalValue<String> label;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public LocationMessageInternalImpl() {}

  protected LocationMessageInternalImpl(
      OptionalValue<Coordinates> coordinates,
      OptionalValue<String> label,
      OptionalValue<String> title) {
    this.coordinates = coordinates;
    this.label = label;
    this.title = title;
  }

  @JsonIgnore
  public Coordinates getCoordinates() {
    return coordinates.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COORDINATES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Coordinates> coordinates() {
    return coordinates;
  }

  @JsonIgnore
  public String getLabel() {
    return label.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> label() {
    return label;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> title() {
    return title;
  }

  /** Return true if this Location_Message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationMessageInternalImpl locationMessage = (LocationMessageInternalImpl) o;
    return Objects.equals(this.coordinates, locationMessage.coordinates)
        && Objects.equals(this.label, locationMessage.label)
        && Objects.equals(this.title, locationMessage.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordinates, label, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationMessageInternalImpl {\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
  static class Builder implements LocationMessageInternal.Builder {
    OptionalValue<Coordinates> coordinates = OptionalValue.empty();
    OptionalValue<String> label = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_COORDINATES)
    public Builder setCoordinates(Coordinates coordinates) {
      this.coordinates = OptionalValue.of(coordinates);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LABEL)
    public Builder setLabel(String label) {
      this.label = OptionalValue.of(label);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    public LocationMessageInternal build() {
      return new LocationMessageInternalImpl(coordinates, label, title);
    }
  }
}
