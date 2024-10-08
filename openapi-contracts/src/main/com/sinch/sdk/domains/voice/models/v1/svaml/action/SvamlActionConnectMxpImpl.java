package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionConnectMxpImpl.JSON_PROPERTY_NAME,
  SvamlActionConnectMxpImpl.JSON_PROPERTY_DESTINATION,
  SvamlActionConnectMxpImpl.JSON_PROPERTY_CALLHEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectMxpImpl
    implements SvamlActionConnectMxp,
        com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<Destination> destination;

  public static final String JSON_PROPERTY_CALLHEADERS = "callheaders";

  private OptionalValue<List<CallHeader>> callheaders;

  public SvamlActionConnectMxpImpl() {}

  protected SvamlActionConnectMxpImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<Destination> destination,
      OptionalValue<List<CallHeader>> callheaders) {
    this.name = name;
    this.destination = destination;
    this.callheaders = callheaders;
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
  public Destination getDestination() {
    return destination.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Destination> destination() {
    return destination;
  }

  @JsonIgnore
  public List<CallHeader> getCallheaders() {
    return callheaders.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLHEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<CallHeader>> callheaders() {
    return callheaders;
  }

  /** Return true if this svaml.action.connectMxp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectMxpImpl svamlActionConnectMxp = (SvamlActionConnectMxpImpl) o;
    return Objects.equals(this.name, svamlActionConnectMxp.name)
        && Objects.equals(this.destination, svamlActionConnectMxp.destination)
        && Objects.equals(this.callheaders, svamlActionConnectMxp.callheaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, destination, callheaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectMxpImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    callheaders: ").append(toIndentedString(callheaders)).append("\n");
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
  static class Builder implements SvamlActionConnectMxp.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONNECT_MXP);
    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<List<CallHeader>> callheaders = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DESTINATION)
    public Builder setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLHEADERS)
    public Builder setCallheaders(List<CallHeader> callheaders) {
      this.callheaders = OptionalValue.of(callheaders);
      return this;
    }

    public SvamlActionConnectMxp build() {
      return new SvamlActionConnectMxpImpl(name, destination, callheaders);
    }
  }
}
