package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({LocationMessageImpl.JSON_PROPERTY_LOCATION_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LocationMessageImpl implements LocationMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessageLocationMessage> locationMessage;

  public LocationMessageImpl() {}

  protected LocationMessageImpl(OptionalValue<LocationMessageLocationMessage> locationMessage) {
    this.locationMessage = locationMessage;
  }

  @JsonIgnore
  public LocationMessageLocationMessage getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessageLocationMessage> locationMessage() {
    return locationMessage;
  }

  /** Return true if this LocationMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationMessageImpl locationMessage = (LocationMessageImpl) o;
    return Objects.equals(this.locationMessage, locationMessage.locationMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationMessageImpl {\n");
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
  static class Builder implements LocationMessage.Builder {
    OptionalValue<LocationMessageLocationMessage> locationMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessageLocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    public LocationMessage build() {
      return new LocationMessageImpl(locationMessage);
    }
  }
}
