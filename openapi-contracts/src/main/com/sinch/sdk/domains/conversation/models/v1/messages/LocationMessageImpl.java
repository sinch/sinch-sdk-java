package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.LocationMessageInternal;
import java.util.Objects;

@JsonPropertyOrder({LocationMessageImpl.JSON_PROPERTY_LOCATION_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LocationMessageImpl
    implements LocationMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessageInternal> locationMessage;

  public LocationMessageImpl() {}

  protected LocationMessageImpl(OptionalValue<LocationMessageInternal> locationMessage) {
    this.locationMessage = locationMessage;
  }

  @JsonIgnore
  public LocationMessageInternal getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessageInternal> locationMessage() {
    return locationMessage;
  }

  @JsonIgnore
  public Coordinates getCoordinates() {
    if (null == locationMessage
        || !locationMessage.isPresent()
        || null == locationMessage.get().getCoordinates()) {
      return null;
    }
    return locationMessage.get().getCoordinates();
  }

  public OptionalValue<Coordinates> coordinates() {
    return null != locationMessage
        ? locationMessage.map(LocationMessageInternal::getCoordinates)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getLabel() {
    if (null == locationMessage
        || !locationMessage.isPresent()
        || null == locationMessage.get().getLabel()) {
      return null;
    }
    return locationMessage.get().getLabel();
  }

  public OptionalValue<String> label() {
    return null != locationMessage
        ? locationMessage.map(LocationMessageInternal::getLabel)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTitle() {
    if (null == locationMessage
        || !locationMessage.isPresent()
        || null == locationMessage.get().getTitle()) {
      return null;
    }
    return locationMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != locationMessage
        ? locationMessage.map(LocationMessageInternal::getTitle)
        : OptionalValue.empty();
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
    LocationMessageImpl locationMessageField = (LocationMessageImpl) o;
    return Objects.equals(this.locationMessage, locationMessageField.locationMessage);
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
    OptionalValue<LocationMessageInternal> locationMessage = OptionalValue.empty();

    LocationMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_LOCATION_MESSAGE, required = true)
    public Builder setLocationMessage(LocationMessageInternal locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonIgnore
    public Builder setCoordinates(Coordinates coordinates) {
      getDelegatedBuilder().setCoordinates(coordinates);
      return this;
    }

    @JsonIgnore
    public Builder setLabel(String label) {
      getDelegatedBuilder().setLabel(label);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    private LocationMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = LocationMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public LocationMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.locationMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new LocationMessageImpl(locationMessage);
    }
  }
}
