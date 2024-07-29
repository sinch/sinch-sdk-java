package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  MachineLearningPIIResultImpl.JSON_PROPERTY_MESSAGE,
  MachineLearningPIIResultImpl.JSON_PROPERTY_MASKED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MachineLearningPIIResultImpl implements MachineLearningPIIResult {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_MASKED = "masked";

  private OptionalValue<String> masked;

  public MachineLearningPIIResultImpl() {}

  protected MachineLearningPIIResultImpl(
      OptionalValue<String> message, OptionalValue<String> masked) {
    this.message = message;
    this.masked = masked;
  }

  @JsonIgnore
  public String getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> message() {
    return message;
  }

  @JsonIgnore
  public String getMasked() {
    return masked.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MASKED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> masked() {
    return masked;
  }

  /** Return true if this MachineLearningPIIResult object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MachineLearningPIIResultImpl machineLearningPIIResult = (MachineLearningPIIResultImpl) o;
    return Objects.equals(this.message, machineLearningPIIResult.message)
        && Objects.equals(this.masked, machineLearningPIIResult.masked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, masked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MachineLearningPIIResultImpl {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    masked: ").append(toIndentedString(masked)).append("\n");
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
  static class Builder implements MachineLearningPIIResult.Builder {
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<String> masked = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MASKED)
    public Builder setMasked(String masked) {
      this.masked = OptionalValue.of(masked);
      return this;
    }

    public MachineLearningPIIResult build() {
      return new MachineLearningPIIResultImpl(message, masked);
    }
  }
}
