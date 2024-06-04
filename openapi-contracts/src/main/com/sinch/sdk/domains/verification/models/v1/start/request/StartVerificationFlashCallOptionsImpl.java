package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({StartVerificationFlashCallOptionsImpl.JSON_PROPERTY_DIAL_TIMEOUT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationFlashCallOptionsImpl implements StartVerificationFlashCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public StartVerificationFlashCallOptionsImpl() {}

  protected StartVerificationFlashCallOptionsImpl(OptionalValue<Integer> dialTimeout) {
    this.dialTimeout = dialTimeout;
  }

  @JsonIgnore
  public Integer getDialTimeout() {
    return dialTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> dialTimeout() {
    return dialTimeout;
  }

  /** Return true if this InitiateVerificationResource_flashCallOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationFlashCallOptionsImpl initiateVerificationResourceFlashCallOptions =
        (StartVerificationFlashCallOptionsImpl) o;
    return Objects.equals(
        this.dialTimeout, initiateVerificationResourceFlashCallOptions.dialTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dialTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationFlashCallOptionsImpl {\n");
    sb.append("    dialTimeout: ").append(toIndentedString(dialTimeout)).append("\n");
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
  static class Builder implements StartVerificationFlashCallOptions.Builder {
    OptionalValue<Integer> dialTimeout = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    public StartVerificationFlashCallOptions build() {
      return new StartVerificationFlashCallOptionsImpl(dialTimeout);
    }
  }
}