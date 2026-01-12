package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({RequestEntityTooLargeImpl.JSON_PROPERTY_ERROR})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RequestEntityTooLargeImpl implements RequestEntityTooLarge {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<RequestEntityTooLargeError> error;

  public RequestEntityTooLargeImpl() {}

  protected RequestEntityTooLargeImpl(OptionalValue<RequestEntityTooLargeError> error) {
    this.error = error;
  }

  @JsonIgnore
  public RequestEntityTooLargeError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RequestEntityTooLargeError> error() {
    return error;
  }

  /** Return true if this RequestEntityTooLarge object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestEntityTooLargeImpl requestEntityTooLarge = (RequestEntityTooLargeImpl) o;
    return Objects.equals(this.error, requestEntityTooLarge.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestEntityTooLargeImpl {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
  static class Builder implements RequestEntityTooLarge.Builder {
    OptionalValue<RequestEntityTooLargeError> error = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(RequestEntityTooLargeError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    public RequestEntityTooLarge build() {
      return new RequestEntityTooLargeImpl(error);
    }
  }
}
