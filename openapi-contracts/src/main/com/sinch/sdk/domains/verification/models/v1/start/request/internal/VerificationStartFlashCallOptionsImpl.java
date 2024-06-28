package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({VerificationStartFlashCallOptionsImpl.JSON_PROPERTY_DIAL_TIMEOUT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartFlashCallOptionsImpl implements VerificationStartFlashCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public VerificationStartFlashCallOptionsImpl() {}

  protected VerificationStartFlashCallOptionsImpl(OptionalValue<Integer> dialTimeout) {
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

  /**
   * Return true if this VerificationStartRequestFlashCall_allOf_flashCallOptions object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartFlashCallOptionsImpl verificationStartRequestFlashCallAllOfFlashCallOptions =
        (VerificationStartFlashCallOptionsImpl) o;
    return Objects.equals(
        this.dialTimeout, verificationStartRequestFlashCallAllOfFlashCallOptions.dialTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dialTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartFlashCallOptionsImpl {\n");
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
  static class Builder implements VerificationStartFlashCallOptions.Builder {
    OptionalValue<Integer> dialTimeout = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    public VerificationStartFlashCallOptions build() {
      return new VerificationStartFlashCallOptionsImpl(dialTimeout);
    }
  }
}
