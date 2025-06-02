package com.sinch.sdk.domains.voice.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AnsweringMachineDetectionQueryImpl.JSON_PROPERTY_ENABLED,
  AnsweringMachineDetectionQueryImpl.JSON_PROPERTY_ASYNC
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AnsweringMachineDetectionQueryImpl implements AnsweringMachineDetectionQuery {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ENABLED = "enabled";

  private OptionalValue<Boolean> enabled;

  public static final String JSON_PROPERTY_ASYNC = "async";

  private OptionalValue<Boolean> async;

  public AnsweringMachineDetectionQueryImpl() {}

  protected AnsweringMachineDetectionQueryImpl(
      OptionalValue<Boolean> enabled, OptionalValue<Boolean> async) {
    this.enabled = enabled;
    this.async = async;
  }

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> enabled() {
    return enabled;
  }

  @JsonIgnore
  public Boolean getAsync() {
    return async.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ASYNC)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> async() {
    return async;
  }

  /** Return true if this amdRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnsweringMachineDetectionQueryImpl amdRequest = (AnsweringMachineDetectionQueryImpl) o;
    return Objects.equals(this.enabled, amdRequest.enabled)
        && Objects.equals(this.async, amdRequest.async);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, async);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnsweringMachineDetectionQueryImpl {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    async: ").append(toIndentedString(async)).append("\n");
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
  static class Builder implements AnsweringMachineDetectionQuery.Builder {
    OptionalValue<Boolean> enabled = OptionalValue.empty();
    OptionalValue<Boolean> async = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENABLED)
    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ASYNC)
    public Builder setAsync(Boolean async) {
      this.async = OptionalValue.of(async);
      return this;
    }

    public AnsweringMachineDetectionQuery build() {
      return new AnsweringMachineDetectionQueryImpl(enabled, async);
    }
  }
}
