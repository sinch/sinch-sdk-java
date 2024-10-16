package com.sinch.sdk.domains.voice.models.v1.conferences;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ConferenceDtmfOptionsImpl.JSON_PROPERTY_MODE,
  ConferenceDtmfOptionsImpl.JSON_PROPERTY_MAX_DIGITS,
  ConferenceDtmfOptionsImpl.JSON_PROPERTY_TIMEOUT_MILLS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConferenceDtmfOptionsImpl implements ConferenceDtmfOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MODE = "mode";

  private OptionalValue<ModeEnum> mode;

  public static final String JSON_PROPERTY_MAX_DIGITS = "maxDigits";

  private OptionalValue<Integer> maxDigits;

  public static final String JSON_PROPERTY_TIMEOUT_MILLS = "timeoutMills";

  private OptionalValue<Integer> timeoutMills;

  public ConferenceDtmfOptionsImpl() {}

  protected ConferenceDtmfOptionsImpl(
      OptionalValue<ModeEnum> mode,
      OptionalValue<Integer> maxDigits,
      OptionalValue<Integer> timeoutMills) {
    this.mode = mode;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
  }

  @JsonIgnore
  public ModeEnum getMode() {
    return mode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ModeEnum> mode() {
    return mode;
  }

  @JsonIgnore
  public Integer getMaxDigits() {
    return maxDigits.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxDigits() {
    return maxDigits;
  }

  @JsonIgnore
  public Integer getTimeoutMills() {
    return timeoutMills.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> timeoutMills() {
    return timeoutMills;
  }

  /** Return true if this conferenceDtmfOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceDtmfOptionsImpl conferenceDtmfOptions = (ConferenceDtmfOptionsImpl) o;
    return Objects.equals(this.mode, conferenceDtmfOptions.mode)
        && Objects.equals(this.maxDigits, conferenceDtmfOptions.maxDigits)
        && Objects.equals(this.timeoutMills, conferenceDtmfOptions.timeoutMills);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, maxDigits, timeoutMills);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceDtmfOptionsImpl {\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    maxDigits: ").append(toIndentedString(maxDigits)).append("\n");
    sb.append("    timeoutMills: ").append(toIndentedString(timeoutMills)).append("\n");
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
  static class Builder implements ConferenceDtmfOptions.Builder {
    OptionalValue<ModeEnum> mode = OptionalValue.empty();
    OptionalValue<Integer> maxDigits = OptionalValue.empty();
    OptionalValue<Integer> timeoutMills = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MODE)
    public Builder setMode(ModeEnum mode) {
      this.mode = OptionalValue.of(mode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = OptionalValue.of(maxDigits);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = OptionalValue.of(timeoutMills);
      return this;
    }

    public ConferenceDtmfOptions build() {
      return new ConferenceDtmfOptionsImpl(mode, maxDigits, timeoutMills);
    }
  }
}
