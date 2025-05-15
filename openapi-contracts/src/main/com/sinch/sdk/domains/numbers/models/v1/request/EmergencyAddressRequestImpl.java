package com.sinch.sdk.domains.numbers.models.v1.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import java.util.Objects;

@JsonPropertyOrder({
  EmergencyAddressRequestImpl.JSON_PROPERTY_DISPLAY_NAME,
  EmergencyAddressRequestImpl.JSON_PROPERTY_ADDRESS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EmergencyAddressRequestImpl implements EmergencyAddressRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_ADDRESS = "address";

  private OptionalValue<EmergencyAddress> address;

  public EmergencyAddressRequestImpl() {}

  protected EmergencyAddressRequestImpl(
      OptionalValue<String> displayName, OptionalValue<EmergencyAddress> address) {
    this.displayName = displayName;
    this.address = address;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  @JsonIgnore
  public EmergencyAddress getAddress() {
    return address.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<EmergencyAddress> address() {
    return address;
  }

  /** Return true if this EmergencyAddressRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmergencyAddressRequestImpl emergencyAddressRequest = (EmergencyAddressRequestImpl) o;
    return Objects.equals(this.displayName, emergencyAddressRequest.displayName)
        && Objects.equals(this.address, emergencyAddressRequest.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmergencyAddressRequestImpl {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
  static class Builder implements EmergencyAddressRequest.Builder {
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<EmergencyAddress> address = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_DISPLAY_NAME, required = true)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ADDRESS, required = true)
    public Builder setAddress(EmergencyAddress address) {
      this.address = OptionalValue.of(address);
      return this;
    }

    public EmergencyAddressRequest build() {
      return new EmergencyAddressRequestImpl(displayName, address);
    }
  }
}
