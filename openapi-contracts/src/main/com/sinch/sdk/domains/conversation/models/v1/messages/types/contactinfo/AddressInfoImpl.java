package com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AddressInfoImpl.JSON_PROPERTY_CITY,
  AddressInfoImpl.JSON_PROPERTY_COUNTRY,
  AddressInfoImpl.JSON_PROPERTY_STATE,
  AddressInfoImpl.JSON_PROPERTY_ZIP,
  AddressInfoImpl.JSON_PROPERTY_TYPE,
  AddressInfoImpl.JSON_PROPERTY_COUNTRY_CODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AddressInfoImpl implements AddressInfo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CITY = "city";

  private OptionalValue<String> city;

  public static final String JSON_PROPERTY_COUNTRY = "country";

  private OptionalValue<String> country;

  public static final String JSON_PROPERTY_STATE = "state";

  private OptionalValue<String> state;

  public static final String JSON_PROPERTY_ZIP = "zip";

  private OptionalValue<String> zip;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<String> type;

  public static final String JSON_PROPERTY_COUNTRY_CODE = "country_code";

  private OptionalValue<String> countryCode;

  public AddressInfoImpl() {}

  protected AddressInfoImpl(
      OptionalValue<String> city,
      OptionalValue<String> country,
      OptionalValue<String> state,
      OptionalValue<String> zip,
      OptionalValue<String> type,
      OptionalValue<String> countryCode) {
    this.city = city;
    this.country = country;
    this.state = state;
    this.zip = zip;
    this.type = type;
    this.countryCode = countryCode;
  }

  @JsonIgnore
  public String getCity() {
    return city.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> city() {
    return city;
  }

  @JsonIgnore
  public String getCountry() {
    return country.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> country() {
    return country;
  }

  @JsonIgnore
  public String getState() {
    return state.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> state() {
    return state;
  }

  @JsonIgnore
  public String getZip() {
    return zip.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ZIP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> zip() {
    return zip;
  }

  @JsonIgnore
  public String getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> type() {
    return type;
  }

  @JsonIgnore
  public String getCountryCode() {
    return countryCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> countryCode() {
    return countryCode;
  }

  /** Return true if this AddressInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressInfoImpl addressInfo = (AddressInfoImpl) o;
    return Objects.equals(this.city, addressInfo.city)
        && Objects.equals(this.country, addressInfo.country)
        && Objects.equals(this.state, addressInfo.state)
        && Objects.equals(this.zip, addressInfo.zip)
        && Objects.equals(this.type, addressInfo.type)
        && Objects.equals(this.countryCode, addressInfo.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, country, state, zip, type, countryCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressInfoImpl {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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
  static class Builder implements AddressInfo.Builder {
    OptionalValue<String> city = OptionalValue.empty();
    OptionalValue<String> country = OptionalValue.empty();
    OptionalValue<String> state = OptionalValue.empty();
    OptionalValue<String> zip = OptionalValue.empty();
    OptionalValue<String> type = OptionalValue.empty();
    OptionalValue<String> countryCode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CITY)
    public Builder setCity(String city) {
      this.city = OptionalValue.of(city);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY)
    public Builder setCountry(String country) {
      this.country = OptionalValue.of(country);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    public Builder setState(String state) {
      this.state = OptionalValue.of(state);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ZIP)
    public Builder setZip(String zip) {
      this.zip = OptionalValue.of(zip);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(String type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
    public Builder setCountryCode(String countryCode) {
      this.countryCode = OptionalValue.of(countryCode);
      return this;
    }

    public AddressInfo build() {
      return new AddressInfoImpl(city, country, state, zip, type, countryCode);
    }
  }
}
