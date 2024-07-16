package com.sinch.sdk.domains.numbers.models.v1.errors.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.errors.BadRequest;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  InvalidArgumentErrorImpl.JSON_PROPERTY_CODE,
  InvalidArgumentErrorImpl.JSON_PROPERTY_MESSAGE,
  InvalidArgumentErrorImpl.JSON_PROPERTY_STATUS,
  InvalidArgumentErrorImpl.JSON_PROPERTY_DETAILS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InvalidArgumentErrorImpl implements InvalidArgumentError {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<CodeEnum> code;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<String> message;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> status;

  public static final String JSON_PROPERTY_DETAILS = "details";

  private OptionalValue<List<BadRequest>> details;

  public InvalidArgumentErrorImpl() {}

  protected InvalidArgumentErrorImpl(
      OptionalValue<CodeEnum> code,
      OptionalValue<String> message,
      OptionalValue<StatusEnum> status,
      OptionalValue<List<BadRequest>> details) {
    this.code = code;
    this.message = message;
    this.status = status;
    this.details = details;
  }

  @JsonIgnore
  public CodeEnum getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CodeEnum> code() {
    return code;
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
  public StatusEnum getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusEnum> status() {
    return status;
  }

  @JsonIgnore
  public List<BadRequest> getDetails() {
    return details.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<BadRequest>> details() {
    return details;
  }

  /** Return true if this InvalidArgument_error object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidArgumentErrorImpl invalidArgumentError = (InvalidArgumentErrorImpl) o;
    return Objects.equals(this.code, invalidArgumentError.code)
        && Objects.equals(this.message, invalidArgumentError.message)
        && Objects.equals(this.status, invalidArgumentError.status)
        && Objects.equals(this.details, invalidArgumentError.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, status, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidArgumentErrorImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
  static class Builder implements InvalidArgumentError.Builder {
    OptionalValue<CodeEnum> code = OptionalValue.empty();
    OptionalValue<String> message = OptionalValue.empty();
    OptionalValue<StatusEnum> status = OptionalValue.empty();
    OptionalValue<List<BadRequest>> details = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(CodeEnum code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(String message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(StatusEnum status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DETAILS)
    public Builder setDetails(List<BadRequest> details) {
      this.details = OptionalValue.of(details);
      return this;
    }

    public InvalidArgumentError build() {
      return new InvalidArgumentErrorImpl(code, message, status, details);
    }
  }
}
