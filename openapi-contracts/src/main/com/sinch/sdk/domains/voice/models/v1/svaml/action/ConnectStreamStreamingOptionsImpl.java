package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ConnectStreamStreamingOptionsImpl.JSON_PROPERTY_VERSION,
  ConnectStreamStreamingOptionsImpl.JSON_PROPERTY_SAMPLE_RATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConnectStreamStreamingOptionsImpl implements ConnectStreamStreamingOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<Integer> version;

  public static final String JSON_PROPERTY_SAMPLE_RATE = "sampleRate";

  private OptionalValue<Integer> sampleRate;

  public ConnectStreamStreamingOptionsImpl() {}

  protected ConnectStreamStreamingOptionsImpl(
      OptionalValue<Integer> version, OptionalValue<Integer> sampleRate) {
    this.version = version;
    this.sampleRate = sampleRate;
  }

  @JsonIgnore
  public Integer getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> version() {
    return version;
  }

  @JsonIgnore
  public Integer getSampleRate() {
    return sampleRate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SAMPLE_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> sampleRate() {
    return sampleRate;
  }

  /** Return true if this svaml_action_connectStream_streamingOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectStreamStreamingOptionsImpl svamlActionConnectStreamStreamingOptions =
        (ConnectStreamStreamingOptionsImpl) o;
    return Objects.equals(this.version, svamlActionConnectStreamStreamingOptions.version)
        && Objects.equals(this.sampleRate, svamlActionConnectStreamStreamingOptions.sampleRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, sampleRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectStreamStreamingOptionsImpl {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    sampleRate: ").append(toIndentedString(sampleRate)).append("\n");
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
  static class Builder implements ConnectStreamStreamingOptions.Builder {
    OptionalValue<Integer> version = OptionalValue.empty();
    OptionalValue<Integer> sampleRate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(Integer version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SAMPLE_RATE)
    public Builder setSampleRate(Integer sampleRate) {
      this.sampleRate = OptionalValue.of(sampleRate);
      return this;
    }

    public ConnectStreamStreamingOptions build() {
      return new ConnectStreamStreamingOptionsImpl(version, sampleRate);
    }
  }
}
