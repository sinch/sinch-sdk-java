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
import com.sinch.sdk.domains.voice.models.v1.destination.internal.PstnDestination;
import java.util.Objects;

@JsonPropertyOrder({
  DestinationPstnImpl.JSON_PROPERTY_TYPE,
  DestinationPstnImpl.JSON_PROPERTY_ENDPOINT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DestinationPstnImpl
    implements DestinationPstn,
        Destination,
        DestinationConference,
        DestinationCustom,
        DestinationTextToSpeech,
        CallInformationFrom,
        CallInformationTo {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<PstnDestination> type;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public DestinationPstnImpl() {}

  protected DestinationPstnImpl(
      OptionalValue<PstnDestination> type, OptionalValue<String> endpoint) {
    this.type = type;
    this.endpoint = endpoint;
  }

  @JsonIgnore
  public PstnDestination getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<PstnDestination> type() {
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

  /** Return true if this destinationPstn object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationPstnImpl destinationPstn = (DestinationPstnImpl) o;
    return Objects.equals(this.type, destinationPstn.type)
        && Objects.equals(this.endpoint, destinationPstn.endpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, endpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationPstnImpl {\n");
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
  static class Builder implements DestinationPstn.Builder {
    OptionalValue<PstnDestination> type = OptionalValue.of(PstnDestination.NUMBER);
    OptionalValue<String> endpoint = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    public DestinationPstn build() {
      return new DestinationPstnImpl(type, endpoint);
    }
  }
}
