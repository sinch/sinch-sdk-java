package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  EmergencyAddressImpl.JSON_PROPERTY_STREET_NUMBER,
  EmergencyAddressImpl.JSON_PROPERTY_STREET_INFO,
  EmergencyAddressImpl.JSON_PROPERTY_LOCATION,
  EmergencyAddressImpl.JSON_PROPERTY_CITY,
  EmergencyAddressImpl.JSON_PROPERTY_STATE,
  EmergencyAddressImpl.JSON_PROPERTY_POSTAL_CODE,
  EmergencyAddressImpl.JSON_PROPERTY_POSTAL_CODE_PLUS_FOUR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EmergencyAddressImpl implements EmergencyAddress {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STREET_NUMBER = "streetNumber";

  private OptionalValue<String> streetNumber;

  public static final String JSON_PROPERTY_STREET_INFO = "streetInfo";

  private OptionalValue<String> streetInfo;

  public static final String JSON_PROPERTY_LOCATION = "location";

  private OptionalValue<String> location;

  public static final String JSON_PROPERTY_CITY = "city";

  private OptionalValue<String> city;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<String> state;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";

  private OptionalValue<String> postalCode;

  public static final String JSON_PROPERTY_POSTAL_CODE_PLUS_FOUR = "postalCodePlusFour";

  private OptionalValue<String> postalCodePlusFour;

  public EmergencyAddressImpl() {}

  protected EmergencyAddressImpl(
      OptionalValue<String> streetNumber,
      OptionalValue<String> streetInfo,
      OptionalValue<String> location,
      OptionalValue<String> city,
      OptionalValue<String> state,
      OptionalValue<String> postalCode,
      OptionalValue<String> postalCodePlusFour) {
    this.streetNumber = streetNumber;
    this.streetInfo = streetInfo;
    this.location = location;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.postalCodePlusFour = postalCodePlusFour;
  }

  @JsonIgnore
  public String getStreetNumber() {
    return streetNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STREET_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> streetNumber() {
    return streetNumber;
  }

  @JsonIgnore
  public String getStreetInfo() {
    return streetInfo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STREET_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> streetInfo() {
    return streetInfo;
  }

  @JsonIgnore
  public String getLocation() {
    return location.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> location() {
    return location;
  }

  @JsonIgnore
  public String getCity() {
    return city.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> city() {
    return city;
  }

  @JsonIgnore
  public String getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> state() {
    return state;
  }

  @JsonIgnore
  public String getPostalCode() {
    return postalCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> postalCode() {
    return postalCode;
  }

  @JsonIgnore
  public String getPostalCodePlusFour() {
    return postalCodePlusFour.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTAL_CODE_PLUS_FOUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> postalCodePlusFour() {
    return postalCodePlusFour;
  }

  /** Return true if this EmergencyAddress object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmergencyAddressImpl emergencyAddress = (EmergencyAddressImpl) o;
    return Objects.equals(this.streetNumber, emergencyAddress.streetNumber)
        && Objects.equals(this.streetInfo, emergencyAddress.streetInfo)
        && Objects.equals(this.location, emergencyAddress.location)
        && Objects.equals(this.city, emergencyAddress.city)
        && Objects.equals(this.state, emergencyAddress.state)
        && Objects.equals(this.postalCode, emergencyAddress.postalCode)
        && Objects.equals(this.postalCodePlusFour, emergencyAddress.postalCodePlusFour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        streetNumber, streetInfo, location, city, state, postalCode, postalCodePlusFour);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmergencyAddressImpl {\n");
    sb.append("    streetNumber: ").append(toIndentedString(streetNumber)).append("\n");
    sb.append("    streetInfo: ").append(toIndentedString(streetInfo)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    postalCodePlusFour: ").append(toIndentedString(postalCodePlusFour)).append("\n");
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
  static class Builder implements EmergencyAddress.Builder {
    OptionalValue<String> streetNumber = OptionalValue.empty();
    OptionalValue<String> streetInfo = OptionalValue.empty();
    OptionalValue<String> location = OptionalValue.empty();
    OptionalValue<String> city = OptionalValue.empty();
    OptionalValue<String> state = OptionalValue.empty();
    OptionalValue<String> postalCode = OptionalValue.empty();
    OptionalValue<String> postalCodePlusFour = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STREET_NUMBER)
    public Builder setStreetNumber(String streetNumber) {
      this.streetNumber = OptionalValue.of(streetNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STREET_INFO)
    public Builder setStreetInfo(String streetInfo) {
      this.streetInfo = OptionalValue.of(streetInfo);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION)
    public Builder setLocation(String location) {
      this.location = OptionalValue.of(location);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CITY)
    public Builder setCity(String city) {
      this.city = OptionalValue.of(city);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    public Builder setState(String state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
    public Builder setPostalCode(String postalCode) {
      this.postalCode = OptionalValue.of(postalCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_POSTAL_CODE_PLUS_FOUR)
    public Builder setPostalCodePlusFour(String postalCodePlusFour) {
      this.postalCodePlusFour = OptionalValue.of(postalCodePlusFour);
      return this;
    }

    public EmergencyAddress build() {
      return new EmergencyAddressImpl(
          streetNumber, streetInfo, location, city, state, postalCode, postalCodePlusFour);
    }
  }
}
