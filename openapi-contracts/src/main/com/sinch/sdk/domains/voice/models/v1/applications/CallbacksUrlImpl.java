package com.sinch.sdk.domains.voice.models.v1.applications;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  CallbacksUrlImpl.JSON_PROPERTY_PRIMARY,
  CallbacksUrlImpl.JSON_PROPERTY_FALLBACK
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallbacksUrlImpl implements CallbacksUrl {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PRIMARY = "primary";

  private OptionalValue<String> primary;

  public static final String JSON_PROPERTY_FALLBACK = "fallback";

  private OptionalValue<String> fallback;

  public CallbacksUrlImpl() {}

  protected CallbacksUrlImpl(OptionalValue<String> primary, OptionalValue<String> fallback) {
    this.primary = primary;
    this.fallback = fallback;
  }

  @JsonIgnore
  public String getPrimary() {
    return primary.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRIMARY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> primary() {
    return primary;
  }

  @JsonIgnore
  public String getFallback() {
    return fallback.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> fallback() {
    return fallback;
  }

  /** Return true if this callbacks_url object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbacksUrlImpl callbacksUrl = (CallbacksUrlImpl) o;
    return Objects.equals(this.primary, callbacksUrl.primary)
        && Objects.equals(this.fallback, callbacksUrl.fallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(primary, fallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbacksUrlImpl {\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    fallback: ").append(toIndentedString(fallback)).append("\n");
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
  static class Builder implements CallbacksUrl.Builder {
    OptionalValue<String> primary = OptionalValue.empty();
    OptionalValue<String> fallback = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PRIMARY)
    public Builder setPrimary(String primary) {
      this.primary = OptionalValue.of(primary);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FALLBACK)
    public Builder setFallback(String fallback) {
      this.fallback = OptionalValue.of(fallback);
      return this;
    }

    public CallbacksUrl build() {
      return new CallbacksUrlImpl(primary, fallback);
    }
  }
}
