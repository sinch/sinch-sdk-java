package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import java.util.Objects;

@JsonPropertyOrder({LocationMessageFieldInternalImpl.JSON_PROPERTY_LOCATION_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LocationMessageFieldInternalImpl implements LocationMessageFieldInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessage> locationMessage;

  public LocationMessageFieldInternalImpl() {}

  protected LocationMessageFieldInternalImpl(OptionalValue<LocationMessage> locationMessage) {
    this.locationMessage = locationMessage;
  }

  @JsonIgnore
  public LocationMessage getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessage> locationMessage() {
    return locationMessage;
  }

  /** Return true if this LocationMessageField object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationMessageFieldInternalImpl locationMessageField = (LocationMessageFieldInternalImpl) o;
    return Objects.equals(this.locationMessage, locationMessageField.locationMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationMessageFieldInternalImpl {\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
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
  static class Builder implements LocationMessageFieldInternal.Builder {
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    public LocationMessageFieldInternal build() {
      return new LocationMessageFieldInternalImpl(locationMessage);
    }
  }
}