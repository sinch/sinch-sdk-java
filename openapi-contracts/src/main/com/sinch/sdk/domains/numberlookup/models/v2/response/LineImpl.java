package com.sinch.sdk.domains.numberlookup.models.v2.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numberlookup.models.v2.errors.LookupError;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  LineImpl.JSON_PROPERTY_CARRIER,
  LineImpl.JSON_PROPERTY_TYPE,
  LineImpl.JSON_PROPERTY_MOBILE_COUNTRY_CODE,
  LineImpl.JSON_PROPERTY_MOBILE_NETWORK_CODE,
  LineImpl.JSON_PROPERTY_PORTED,
  LineImpl.JSON_PROPERTY_PORTING_DATE,
  LineImpl.JSON_PROPERTY_ERROR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineImpl implements Line {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CARRIER = "carrier";

  private OptionalValue<String> carrier;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<LineType> type;

  public static final String JSON_PROPERTY_MOBILE_COUNTRY_CODE = "mobileCountryCode";

  private OptionalValue<String> mobileCountryCode;

  public static final String JSON_PROPERTY_MOBILE_NETWORK_CODE = "mobileNetworkCode";

  private OptionalValue<String> mobileNetworkCode;

  public static final String JSON_PROPERTY_PORTED = "ported";

  private OptionalValue<Boolean> ported;

  public static final String JSON_PROPERTY_PORTING_DATE = "portingDate";

  private OptionalValue<Instant> portingDate;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<LookupError> error;

  public LineImpl() {}

  protected LineImpl(
      OptionalValue<String> carrier,
      OptionalValue<LineType> type,
      OptionalValue<String> mobileCountryCode,
      OptionalValue<String> mobileNetworkCode,
      OptionalValue<Boolean> ported,
      OptionalValue<Instant> portingDate,
      OptionalValue<LookupError> error) {
    this.carrier = carrier;
    this.type = type;
    this.mobileCountryCode = mobileCountryCode;
    this.mobileNetworkCode = mobileNetworkCode;
    this.ported = ported;
    this.portingDate = portingDate;
    this.error = error;
  }

  @JsonIgnore
  public String getCarrier() {
    return carrier.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARRIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> carrier() {
    return carrier;
  }

  @JsonIgnore
  public LineType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineType> type() {
    return type;
  }

  @JsonIgnore
  public String getMobileCountryCode() {
    return mobileCountryCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOBILE_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mobileCountryCode() {
    return mobileCountryCode;
  }

  @JsonIgnore
  public String getMobileNetworkCode() {
    return mobileNetworkCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOBILE_NETWORK_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mobileNetworkCode() {
    return mobileNetworkCode;
  }

  @JsonIgnore
  public Boolean getPorted() {
    return ported.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PORTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> ported() {
    return ported;
  }

  @JsonIgnore
  public Instant getPortingDate() {
    return portingDate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PORTING_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> portingDate() {
    return portingDate;
  }

  @JsonIgnore
  public LookupError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LookupError> error() {
    return error;
  }

  /** Return true if this LineResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineImpl lineResponse = (LineImpl) o;
    return Objects.equals(this.carrier, lineResponse.carrier)
        && Objects.equals(this.type, lineResponse.type)
        && Objects.equals(this.mobileCountryCode, lineResponse.mobileCountryCode)
        && Objects.equals(this.mobileNetworkCode, lineResponse.mobileNetworkCode)
        && Objects.equals(this.ported, lineResponse.ported)
        && Objects.equals(this.portingDate, lineResponse.portingDate)
        && Objects.equals(this.error, lineResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        carrier, type, mobileCountryCode, mobileNetworkCode, ported, portingDate, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineImpl {\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    mobileCountryCode: ").append(toIndentedString(mobileCountryCode)).append("\n");
    sb.append("    mobileNetworkCode: ").append(toIndentedString(mobileNetworkCode)).append("\n");
    sb.append("    ported: ").append(toIndentedString(ported)).append("\n");
    sb.append("    portingDate: ").append(toIndentedString(portingDate)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
  static class Builder implements Line.Builder {
    OptionalValue<String> carrier = OptionalValue.empty();
    OptionalValue<LineType> type = OptionalValue.empty();
    OptionalValue<String> mobileCountryCode = OptionalValue.empty();
    OptionalValue<String> mobileNetworkCode = OptionalValue.empty();
    OptionalValue<Boolean> ported = OptionalValue.empty();
    OptionalValue<Instant> portingDate = OptionalValue.empty();
    OptionalValue<LookupError> error = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CARRIER)
    public Builder setCarrier(String carrier) {
      this.carrier = OptionalValue.of(carrier);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(LineType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOBILE_COUNTRY_CODE)
    public Builder setMobileCountryCode(String mobileCountryCode) {
      this.mobileCountryCode = OptionalValue.of(mobileCountryCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOBILE_NETWORK_CODE)
    public Builder setMobileNetworkCode(String mobileNetworkCode) {
      this.mobileNetworkCode = OptionalValue.of(mobileNetworkCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PORTED)
    public Builder setPorted(Boolean ported) {
      this.ported = OptionalValue.of(ported);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PORTING_DATE)
    public Builder setPortingDate(Instant portingDate) {
      this.portingDate = OptionalValue.of(portingDate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(LookupError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    public Line build() {
      return new LineImpl(
          carrier, type, mobileCountryCode, mobileNetworkCode, ported, portingDate, error);
    }
  }
}
