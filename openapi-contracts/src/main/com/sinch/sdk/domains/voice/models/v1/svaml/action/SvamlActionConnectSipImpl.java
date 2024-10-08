package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlActionConnectSipImpl.JSON_PROPERTY_NAME,
  SvamlActionConnectSipImpl.JSON_PROPERTY_DESTINATION,
  SvamlActionConnectSipImpl.JSON_PROPERTY_MAX_DURATION,
  SvamlActionConnectSipImpl.JSON_PROPERTY_CLI,
  SvamlActionConnectSipImpl.JSON_PROPERTY_TRANSPORT,
  SvamlActionConnectSipImpl.JSON_PROPERTY_SUPPRESS_CALLBACKS,
  SvamlActionConnectSipImpl.JSON_PROPERTY_CALL_HEADERS,
  SvamlActionConnectSipImpl.JSON_PROPERTY_MOH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectSipImpl
    implements SvamlActionConnectSip,
        com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_DESTINATION = "destination";

  private OptionalValue<Destination> destination;

  public static final String JSON_PROPERTY_MAX_DURATION = "maxDuration";

  private OptionalValue<Integer> maxDuration;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public static final String JSON_PROPERTY_TRANSPORT = "transport";

  private OptionalValue<TransportEnum> transport;

  public static final String JSON_PROPERTY_SUPPRESS_CALLBACKS = "suppressCallbacks";

  private OptionalValue<Boolean> suppressCallbacks;

  public static final String JSON_PROPERTY_CALL_HEADERS = "callHeaders";

  private OptionalValue<List<CallHeader>> callHeaders;

  public static final String JSON_PROPERTY_MOH = "moh";

  private OptionalValue<MusicOnHold> moh;

  public SvamlActionConnectSipImpl() {}

  protected SvamlActionConnectSipImpl(
      OptionalValue<NameEnum> name,
      OptionalValue<Destination> destination,
      OptionalValue<Integer> maxDuration,
      OptionalValue<String> cli,
      OptionalValue<TransportEnum> transport,
      OptionalValue<Boolean> suppressCallbacks,
      OptionalValue<List<CallHeader>> callHeaders,
      OptionalValue<MusicOnHold> moh) {
    this.name = name;
    this.destination = destination;
    this.maxDuration = maxDuration;
    this.cli = cli;
    this.transport = transport;
    this.suppressCallbacks = suppressCallbacks;
    this.callHeaders = callHeaders;
    this.moh = moh;
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Destination> destination() {
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
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  @JsonIgnore
  public TransportEnum getTransport() {
    return transport.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TransportEnum> transport() {
    return transport;
  }

  @JsonIgnore
  public Boolean getSuppressCallbacks() {
    return suppressCallbacks.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> suppressCallbacks() {
    return suppressCallbacks;
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

  @JsonIgnore
  public MusicOnHold getMoh() {
    return moh.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MusicOnHold> moh() {
    return moh;
  }

  /** Return true if this svaml.action.connectSip object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectSipImpl svamlActionConnectSip = (SvamlActionConnectSipImpl) o;
    return Objects.equals(this.name, svamlActionConnectSip.name)
        && Objects.equals(this.destination, svamlActionConnectSip.destination)
        && Objects.equals(this.maxDuration, svamlActionConnectSip.maxDuration)
        && Objects.equals(this.cli, svamlActionConnectSip.cli)
        && Objects.equals(this.transport, svamlActionConnectSip.transport)
        && Objects.equals(this.suppressCallbacks, svamlActionConnectSip.suppressCallbacks)
        && Objects.equals(this.callHeaders, svamlActionConnectSip.callHeaders)
        && Objects.equals(this.moh, svamlActionConnectSip.moh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name, destination, maxDuration, cli, transport, suppressCallbacks, callHeaders, moh);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectSipImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
    sb.append("    transport: ").append(toIndentedString(transport)).append("\n");
    sb.append("    suppressCallbacks: ").append(toIndentedString(suppressCallbacks)).append("\n");
    sb.append("    callHeaders: ").append(toIndentedString(callHeaders)).append("\n");
    sb.append("    moh: ").append(toIndentedString(moh)).append("\n");
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
  static class Builder implements SvamlActionConnectSip.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.CONNECT_SIP);
    OptionalValue<Destination> destination = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();
    OptionalValue<TransportEnum> transport = OptionalValue.empty();
    OptionalValue<Boolean> suppressCallbacks = OptionalValue.empty();
    OptionalValue<List<CallHeader>> callHeaders = OptionalValue.empty();
    OptionalValue<MusicOnHold> moh = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DESTINATION)
    public Builder setDestination(Destination destination) {
      this.destination = OptionalValue.of(destination);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DURATION)
    public Builder setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSPORT)
    public Builder setTransport(TransportEnum transport) {
      this.transport = OptionalValue.of(transport);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUPPRESS_CALLBACKS)
    public Builder setSuppressCallbacks(Boolean suppressCallbacks) {
      this.suppressCallbacks = OptionalValue.of(suppressCallbacks);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MOH)
    public Builder setMoh(MusicOnHold moh) {
      this.moh = OptionalValue.of(moh);
      return this;
    }

    public SvamlActionConnectSip build() {
      return new SvamlActionConnectSipImpl(
          name, destination, maxDuration, cli, transport, suppressCallbacks, callHeaders, moh);
    }
  }
}
