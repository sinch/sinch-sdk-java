package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.errors.internal.NotFoundError;
import com.sinch.sdk.domains.numbers.models.v1.errors.internal.NotFoundErrorImpl;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({NotFoundImpl.JSON_PROPERTY_ERROR})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NotFoundImpl implements NotFound {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<NotFoundError> error;

  public NotFoundImpl() {}

  protected NotFoundImpl(OptionalValue<NotFoundError> error) {
    this.error = error;
  }

  @JsonIgnore
  public NotFoundError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NotFoundError> error() {
    return error;
  }

  @JsonIgnore
  public CodeEnum getCode() {
    if (null == error || !error.isPresent() || null == error.get().getCode()) {
      return null;
    }
    return CodeEnum.from(error.get().getCode().value());
  }

  public OptionalValue<CodeEnum> code() {
    return null != error
        ? error.map(f -> CodeEnum.from(error.get().getCode().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getMessage() {
    if (null == error || !error.isPresent() || null == error.get().getMessage()) {
      return null;
    }
    return error.get().getMessage();
  }

  public OptionalValue<String> message() {
    return null != error ? error.map(NotFoundError::getMessage) : OptionalValue.empty();
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    if (null == error || !error.isPresent() || null == error.get().getStatus()) {
      return null;
    }
    return StatusEnum.from(error.get().getStatus().value());
  }

  public OptionalValue<StatusEnum> status() {
    return null != error
        ? error.map(f -> StatusEnum.from(error.get().getStatus().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public List<Object> getDetails() {
    if (null == error || !error.isPresent() || null == error.get().getDetails()) {
      return null;
    }
    return error.get().getDetails();
  }

  public OptionalValue<List<Object>> details() {
    return null != error ? error.map(NotFoundError::getDetails) : OptionalValue.empty();
  }

  /** Return true if this NotFound object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotFoundImpl notFound = (NotFoundImpl) o;
    return Objects.equals(this.error, notFound.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotFoundImpl {\n");
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
  static class Builder implements NotFound.Builder {
    OptionalValue<NotFoundError> error = OptionalValue.empty();

    NotFoundError.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(NotFoundError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    @JsonIgnore
    public Builder setCode(CodeEnum code) {
      getDelegatedBuilder()
          .setCode(null != code ? NotFoundErrorImpl.CodeEnum.from(code.value()) : null);
      return this;
    }

    @JsonIgnore
    public Builder setMessage(String message) {
      getDelegatedBuilder().setMessage(message);
      return this;
    }

    @JsonIgnore
    public Builder setStatus(StatusEnum status) {
      getDelegatedBuilder()
          .setStatus(null != status ? NotFoundErrorImpl.StatusEnum.from(status.value()) : null);
      return this;
    }

    @JsonIgnore
    public Builder setDetails(List<Object> details) {
      getDelegatedBuilder().setDetails(details);
      return this;
    }

    private NotFoundError.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = NotFoundError.builder();
      }
      return this._delegatedBuilder;
    }

    public NotFound build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.error = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new NotFoundImpl(error);
    }
  }
}
