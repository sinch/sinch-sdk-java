package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartFlashCallOptionsImpl.JSON_PROPERTY_DIAL_TIMEOUT,
  VerificationStartFlashCallOptionsImpl.JSON_PROPERTY_INTERCEPTION_TIMEOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartFlashCallOptionsImpl implements VerificationStartFlashCallOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT = "dialTimeout";

  private OptionalValue<Integer> dialTimeout;

  public static final String JSON_PROPERTY_INTERCEPTION_TIMEOUT = "interceptionTimeout";

  private OptionalValue<Integer> interceptionTimeout;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartFlashCallOptionsImpl() {}

  protected VerificationStartFlashCallOptionsImpl(
      OptionalValue<Integer> dialTimeout,
      OptionalValue<Integer> interceptionTimeout,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.dialTimeout = dialTimeout;
    this.interceptionTimeout = interceptionTimeout;
    this.additionalProperties = additionalProperties;
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

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    return interceptionTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> interceptionTimeout() {
    return interceptionTimeout;
  }

  @JsonIgnore
  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

  @JsonAnyGetter
  public Map<String, Object> additionalProperties() {
    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return additionalProperties.get();
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
            this.dialTimeout, verificationStartRequestFlashCallAllOfFlashCallOptions.dialTimeout)
        && Objects.equals(
            this.interceptionTimeout,
            verificationStartRequestFlashCallAllOfFlashCallOptions.interceptionTimeout)
        && Objects.equals(
            this.additionalProperties,
            verificationStartRequestFlashCallAllOfFlashCallOptions.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dialTimeout, interceptionTimeout, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartFlashCallOptionsImpl {\n");
    sb.append("    dialTimeout: ").append(toIndentedString(dialTimeout)).append("\n");
    sb.append("    interceptionTimeout: ")
        .append(toIndentedString(interceptionTimeout))
        .append("\n");
    sb.append("    additionalProperties: ")
        .append(toIndentedString(additionalProperties))
        .append("\n");
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
    OptionalValue<Integer> interceptionTimeout = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT)
    public Builder setDialTimeout(Integer dialTimeout) {
      this.dialTimeout = OptionalValue.of(dialTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      this.interceptionTimeout = OptionalValue.of(interceptionTimeout);
      return this;
    }

    @JsonAnySetter
    public Builder put(String key, Object value) {
      if (!this.additionalProperties.isPresent()) {
        this.additionalProperties = OptionalValue.of(new HashMap<String, Object>());
      }
      this.additionalProperties.get().put(key, value);
      return this;
    }

    public VerificationStartFlashCallOptions build() {
      return new VerificationStartFlashCallOptionsImpl(
          dialTimeout, interceptionTimeout, additionalProperties);
    }
  }
}
