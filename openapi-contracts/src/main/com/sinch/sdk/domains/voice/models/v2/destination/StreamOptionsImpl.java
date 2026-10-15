package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StreamOptionsImpl.JSON_PROPERTY_VERSION,
  StreamOptionsImpl.JSON_PROPERTY_CODEC,
  StreamOptionsImpl.JSON_PROPERTY_SAMPLE_RATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StreamOptionsImpl implements StreamOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<Integer> version;

  public static final String JSON_PROPERTY_CODEC = "codec";

  private OptionalValue<CodecEnum> codec;

  public static final String JSON_PROPERTY_SAMPLE_RATE = "sampleRate";

  private OptionalValue<SampleRateEnum> sampleRate;

  public StreamOptionsImpl() {}

  protected StreamOptionsImpl(
      OptionalValue<Integer> version,
      OptionalValue<CodecEnum> codec,
      OptionalValue<SampleRateEnum> sampleRate) {
    this.version = version;
    this.codec = codec;
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
  public CodecEnum getCodec() {
    return codec.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODEC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CodecEnum> codec() {
    return codec;
  }

  @JsonIgnore
  public SampleRateEnum getSampleRate() {
    return sampleRate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SAMPLE_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SampleRateEnum> sampleRate() {
    return sampleRate;
  }

  /** Return true if this StreamOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamOptionsImpl streamOptions = (StreamOptionsImpl) o;
    return Objects.equals(this.version, streamOptions.version)
        && Objects.equals(this.codec, streamOptions.codec)
        && Objects.equals(this.sampleRate, streamOptions.sampleRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, codec, sampleRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamOptionsImpl {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
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
  static class Builder implements StreamOptions.Builder {
    OptionalValue<Integer> version = OptionalValue.empty();
    OptionalValue<CodecEnum> codec = OptionalValue.empty();
    OptionalValue<SampleRateEnum> sampleRate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(Integer version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODEC)
    public Builder setCodec(CodecEnum codec) {
      this.codec = OptionalValue.of(codec);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SAMPLE_RATE)
    public Builder setSampleRate(SampleRateEnum sampleRate) {
      this.sampleRate = OptionalValue.of(sampleRate);
      return this;
    }

    public StreamOptions build() {
      return new StreamOptionsImpl(version, codec, sampleRate);
    }
  }
}
