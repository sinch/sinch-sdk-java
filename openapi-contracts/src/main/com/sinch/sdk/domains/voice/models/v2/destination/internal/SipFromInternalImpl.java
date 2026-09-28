package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SipFromInternalImpl.JSON_PROPERTY_ENDPOINT,
  SipFromInternalImpl.JSON_PROPERTY_DISPLAY_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SipFromInternalImpl implements SipFromInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

  private OptionalValue<String> displayName;

  public SipFromInternalImpl() {}

  protected SipFromInternalImpl(OptionalValue<String> endpoint, OptionalValue<String> displayName) {
    this.endpoint = endpoint;
    this.displayName = displayName;
  }

  @JsonIgnore
  public String getEndpoint() {
    return endpoint.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENDPOINT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> endpoint() {
    return endpoint;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
  }

  /** Return true if this SipFromInternal object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SipFromInternalImpl sipFromDetails = (SipFromInternalImpl) o;
    return Objects.equals(this.endpoint, sipFromDetails.endpoint)
        && Objects.equals(this.displayName, sipFromDetails.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, displayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SipFromInternalImpl {\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
  static class Builder implements SipFromInternal.Builder {
    OptionalValue<String> endpoint = OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    public SipFromInternal build() {
      return new SipFromInternalImpl(endpoint, displayName);
    }
  }
}
