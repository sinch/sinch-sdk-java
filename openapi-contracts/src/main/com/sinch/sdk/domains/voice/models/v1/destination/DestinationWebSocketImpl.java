package com.sinch.sdk.domains.voice.models.v1.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  DestinationWebSocketImpl.JSON_PROPERTY_TYPE,
  DestinationWebSocketImpl.JSON_PROPERTY_ENDPOINT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DestinationWebSocketImpl implements DestinationWebSocket {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public DestinationWebSocketImpl() {}

  protected DestinationWebSocketImpl(OptionalValue<TypeEnum> type, OptionalValue<String> endpoint) {
    this.type = type;
    this.endpoint = endpoint;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
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

  /** Return true if this destinationWebSocket object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationWebSocketImpl destinationWebSocket = (DestinationWebSocketImpl) o;
    return Objects.equals(this.type, destinationWebSocket.type)
        && Objects.equals(this.endpoint, destinationWebSocket.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationWebSocketImpl {\n");
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
  static class Builder implements DestinationWebSocket.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(DestinationWebSocket.TypeEnum.WEBSOCKET);
    OptionalValue<String> endpoint = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    public DestinationWebSocket build() {
      return new DestinationWebSocketImpl(type, endpoint);
    }
  }
}
