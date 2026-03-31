package com.sinch.sdk.domains.voice.models.v1.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationFrom;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformationTo;
import com.sinch.sdk.domains.voice.models.v1.destination.internal.MxpDestination;
import java.util.Objects;
import java.util.stream.Stream;

@JsonPropertyOrder({
  DestinationMxpImpl.JSON_PROPERTY_TYPE,
  DestinationMxpImpl.JSON_PROPERTY_ENDPOINT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DestinationMxpImpl
    implements DestinationMxp,
        Destination,
        DestinationConference,
        DestinationCustom,
        DestinationTextToSpeech,
        CallInformationFrom,
        CallInformationTo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<MxpDestination> type;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public DestinationMxpImpl() {}

  protected DestinationMxpImpl(OptionalValue<MxpDestination> type, OptionalValue<String> endpoint) {
    this.type = type;
    this.endpoint = endpoint;
  }

  @JsonIgnore
  public MxpDestination getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MxpDestination> type() {
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

  /** Return true if this destinationMxp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationMxpImpl destinationMxp = (DestinationMxpImpl) o;
    return Objects.equals(this.type, destinationMxp.type)
        && Objects.equals(this.endpoint, destinationMxp.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationMxpImpl {\n");
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
  static class Builder implements DestinationMxp.Builder {
    OptionalValue<MxpDestination> type = OptionalValue.of(MxpDestination.USERNAME);
    OptionalValue<String> endpoint = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(MxpDestination type) {
      if (Stream.of(MxpDestination.USERNAME, MxpDestination.USERNAME2)
          .noneMatch(d -> Objects.equals(d, type))) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", type, MxpDestination.USERNAME));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    public DestinationMxp build() {
      return new DestinationMxpImpl(type, endpoint);
    }
  }
}
