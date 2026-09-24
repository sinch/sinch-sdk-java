package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  StreamDetailsImpl.JSON_PROPERTY_ENDPOINT,
  StreamDetailsImpl.JSON_PROPERTY_STREAM_OPTIONS,
  StreamDetailsImpl.JSON_PROPERTY_CALL_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StreamDetailsImpl implements StreamDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENDPOINT = "endpoint";

  private OptionalValue<String> endpoint;

  public static final String JSON_PROPERTY_STREAM_OPTIONS = "streamOptions";

  private OptionalValue<StreamOptions> streamOptions;

  public static final String JSON_PROPERTY_CALL_HEADERS = "callHeaders";

  private OptionalValue<List<CallHeader>> callHeaders;

  public StreamDetailsImpl() {}

  protected StreamDetailsImpl(
      OptionalValue<String> endpoint,
      OptionalValue<StreamOptions> streamOptions,
      OptionalValue<List<CallHeader>> callHeaders) {
    this.endpoint = endpoint;
    this.streamOptions = streamOptions;
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
  public StreamOptions getStreamOptions() {
    return streamOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STREAM_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StreamOptions> streamOptions() {
    return streamOptions;
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

  /** Return true if this StreamDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamDetailsImpl streamDetails = (StreamDetailsImpl) o;
    return Objects.equals(this.endpoint, streamDetails.endpoint)
        && Objects.equals(this.streamOptions, streamDetails.streamOptions)
        && Objects.equals(this.callHeaders, streamDetails.callHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, streamOptions, callHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamDetailsImpl {\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    streamOptions: ").append(toIndentedString(streamOptions)).append("\n");
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
  static class Builder implements StreamDetails.Builder {
    OptionalValue<String> endpoint = OptionalValue.empty();
    OptionalValue<StreamOptions> streamOptions = OptionalValue.empty();
    OptionalValue<List<CallHeader>> callHeaders = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_ENDPOINT, required = true)
    public Builder setEndpoint(String endpoint) {
      this.endpoint = OptionalValue.of(endpoint);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STREAM_OPTIONS)
    public Builder setStreamOptions(StreamOptions streamOptions) {
      this.streamOptions = OptionalValue.of(streamOptions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_HEADERS)
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      this.callHeaders = OptionalValue.of(callHeaders);
      return this;
    }

    public StreamDetails build() {
      return new StreamDetailsImpl(endpoint, streamOptions, callHeaders);
    }
  }
}
