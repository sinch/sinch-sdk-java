package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  BatchOptionsImpl.JSON_PROPERTY_MAX_CPS,
  BatchOptionsImpl.JSON_PROPERTY_TTL_SECONDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BatchOptionsImpl implements BatchOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MAX_CPS = "maxCps";

  private OptionalValue<Integer> maxCps;

  public static final String JSON_PROPERTY_TTL_SECONDS = "ttlSeconds";

  private OptionalValue<Integer> ttlSeconds;

  public BatchOptionsImpl() {}

  protected BatchOptionsImpl(OptionalValue<Integer> maxCps, OptionalValue<Integer> ttlSeconds) {
    this.maxCps = maxCps;
    this.ttlSeconds = ttlSeconds;
  }

  @JsonIgnore
  public Integer getMaxCps() {
    return maxCps.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_CPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxCps() {
    return maxCps;
  }

  @JsonIgnore
  public Integer getTtlSeconds() {
    return ttlSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TTL_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> ttlSeconds() {
    return ttlSeconds;
  }

  /** Return true if this batchOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchOptionsImpl batchOptions = (BatchOptionsImpl) o;
    return Objects.equals(this.maxCps, batchOptions.maxCps)
        && Objects.equals(this.ttlSeconds, batchOptions.ttlSeconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxCps, ttlSeconds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchOptionsImpl {\n");
    sb.append("    maxCps: ").append(toIndentedString(maxCps)).append("\n");
    sb.append("    ttlSeconds: ").append(toIndentedString(ttlSeconds)).append("\n");
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
  static class Builder implements BatchOptions.Builder {
    OptionalValue<Integer> maxCps = OptionalValue.empty();
    OptionalValue<Integer> ttlSeconds = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MAX_CPS)
    public Builder setMaxCps(Integer maxCps) {
      this.maxCps = OptionalValue.of(maxCps);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TTL_SECONDS)
    public Builder setTtlSeconds(Integer ttlSeconds) {
      this.ttlSeconds = OptionalValue.of(ttlSeconds);
      return this;
    }

    public BatchOptions build() {
      return new BatchOptionsImpl(maxCps, ttlSeconds);
    }
  }
}
