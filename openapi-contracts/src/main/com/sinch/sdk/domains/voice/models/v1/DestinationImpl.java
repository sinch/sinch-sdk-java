package com.sinch.sdk.domains.voice.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({DestinationImpl.JSON_PROPERTY_TYPE, DestinationImpl.JSON_PROPERTY_ENDPOINT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DestinationImpl implements Destination {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<DestinationType> type;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public DestinationImpl() {}

  protected DestinationImpl(OptionalValue<DestinationType> type, OptionalValue<String> endpoint) {
    this.type = type;
    this.endpoint = endpoint;
  }

  @JsonIgnore
  public DestinationType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DestinationType> type() {
    return type;
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

  /** Return true if this destination object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationImpl destination = (DestinationImpl) o;
    return Objects.equals(this.type, destination.type)
        && Objects.equals(this.endpoint, destination.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
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
  static class Builder implements Destination.Builder {
    OptionalValue<DestinationType> type = OptionalValue.empty();
    OptionalValue<String> endpoint = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(DestinationType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    public Destination build() {
      return new DestinationImpl(type, endpoint);
    }
  }
}
