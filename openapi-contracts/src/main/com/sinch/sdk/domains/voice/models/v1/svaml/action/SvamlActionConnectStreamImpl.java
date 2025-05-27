package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationWebSocket;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionConnectStreamImpl.JSON_PROPERTY_NAME,
  SvamlActionConnectStreamImpl.JSON_PROPERTY_DESTINATION,
  SvamlActionConnectStreamImpl.JSON_PROPERTY_MAX_DURATION,
  SvamlActionConnectStreamImpl.JSON_PROPERTY_CALL_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectStreamImpl
    implements SvamlActionConnectStream,
        com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<DestinationWebSocket> destination;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public static final String JSON_PROPERTY_CALL_HEADERS = "callHeaders";

  private OptionalValue<List<CallHeader>> callHeaders;

  public SvamlActionConnectStreamImpl() {}

  protected SvamlActionConnectStreamImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<DestinationWebSocket> destination,
      OptionalValue<Integer> maxDuration,
      OptionalValue<List<CallHeader>> callHeaders) {
    this.name = name;
    this.destination = destination;
    this.maxDuration = maxDuration;
    this.callHeaders = callHeaders;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  @JsonIgnore
  public DestinationWebSocket getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DestinationWebSocket> destination() {
    return destination;
  }

  @JsonIgnore
  public Integer getMaxDuration() {
    return maxDuration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDuration() {
    return maxDuration;
  }

  @JsonIgnore
  public List<CallHeader> getCallHeaders() {
    return callHeaders.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<CallHeader>> callHeaders() {
    return callHeaders;
  }

  /** Return true if this svaml.action.connectStream object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectStreamImpl svamlActionConnectStream = (SvamlActionConnectStreamImpl) o;
    return Objects.equals(this.name, svamlActionConnectStream.name)
        && Objects.equals(this.destination, svamlActionConnectStream.destination)
        && Objects.equals(this.maxDuration, svamlActionConnectStream.maxDuration)
        && Objects.equals(this.callHeaders, svamlActionConnectStream.callHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, destination, maxDuration, callHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectStreamImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    callHeaders: ").append(toIndentedString(callHeaders)).append("\n");
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
  static class Builder implements SvamlActionConnectStream.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONNECT_STREAM);
    OptionalValue<DestinationWebSocket> destination = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<List<CallHeader>> callHeaders = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_DESTINATION, required = true)
    public Builder setDestination(DestinationWebSocket destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    public SvamlActionConnectStream build() {
      return new SvamlActionConnectStreamImpl(name, destination, maxDuration, callHeaders);
    }
  }
}
