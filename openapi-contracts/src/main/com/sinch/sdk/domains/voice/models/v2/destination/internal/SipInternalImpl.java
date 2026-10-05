package com.sinch.sdk.domains.voice.models.v2.destination.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.destination.Sip.TransportEnum;
import com.sinch.sdk.domains.voice.models.v2.destination.SipCallHeader;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  SipInternalImpl.JSON_PROPERTY_ENDPOINT,
  SipInternalImpl.JSON_PROPERTY_TRANSPORT,
  SipInternalImpl.JSON_PROPERTY_CALL_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SipInternalImpl implements SipInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public static final String JSON_PROPERTY_TRANSPORT = "transport";

  private OptionalValue<TransportEnum> transport;

  public static final String JSON_PROPERTY_CALL_HEADERS = "callHeaders";

  private OptionalValue<List<SipCallHeader>> callHeaders;

  public SipInternalImpl() {}

  protected SipInternalImpl(
      OptionalValue<String> endpoint,
      OptionalValue<TransportEnum> transport,
      OptionalValue<List<SipCallHeader>> callHeaders) {
    this.endpoint = endpoint;
    this.transport = transport;
    this.callHeaders = callHeaders;
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
  public TransportEnum getTransport() {
    return transport.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TransportEnum> transport() {
    return transport;
  }

  @JsonIgnore
  public List<SipCallHeader> getCallHeaders() {
    return callHeaders.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SipCallHeader>> callHeaders() {
    return callHeaders;
  }

  /** Return true if this SipInternal object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SipInternalImpl sipDetails = (SipInternalImpl) o;
    return Objects.equals(this.endpoint, sipDetails.endpoint)
        && Objects.equals(this.transport, sipDetails.transport)
        && Objects.equals(this.callHeaders, sipDetails.callHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, transport, callHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SipInternalImpl {\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    transport: ").append(toIndentedString(transport)).append("\n");
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
  static class Builder implements SipInternal.Builder {
    OptionalValue<String> endpoint = OptionalValue.empty();
    OptionalValue<TransportEnum> transport = OptionalValue.empty();
    OptionalValue<List<SipCallHeader>> callHeaders = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSPORT)
    public Builder setTransport(TransportEnum transport) {
      this.transport = OptionalValue.of(transport);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
    public Builder setCallHeaders(List<SipCallHeader> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    public SipInternal build() {
      return new SipInternalImpl(endpoint, transport, callHeaders);
    }
  }
}
