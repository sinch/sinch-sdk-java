package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.errors.internal.InternalErrorError;
import com.sinch.sdk.domains.numbers.models.v1.errors.internal.InternalErrorErrorImpl;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({InternalErrorImpl.JSON_PROPERTY_ERROR})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class InternalErrorImpl implements InternalError {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<InternalErrorError> error;

  public InternalErrorImpl() {}

  protected InternalErrorImpl(OptionalValue<InternalErrorError> error) {
    this.error = error;
  }

  @JsonIgnore
  public InternalErrorError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<InternalErrorError> error() {
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
    return null != error && error.isPresent()
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
    return null != error && error.isPresent()
        ? error.map(f -> ((InternalErrorErrorImpl) f).message()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    if (null == error || !error.isPresent() || null == error.get().getStatus()) {
      return null;
    }
    return StatusEnum.from(error.get().getStatus().value());
  }

  public OptionalValue<StatusEnum> status() {
    return null != error && error.isPresent()
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
    return null != error && error.isPresent()
        ? error.map(f -> ((InternalErrorErrorImpl) f).details()).orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this InternalError object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternalErrorImpl internalError = (InternalErrorImpl) o;
    return Objects.equals(this.error, internalError.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternalErrorImpl {\n");
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
  static class Builder implements InternalError.Builder {
    OptionalValue<InternalErrorError> error = OptionalValue.empty();

    InternalErrorError.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(InternalErrorError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    @JsonIgnore
    public Builder setCode(CodeEnum code) {
      getDelegatedBuilder()
          .setCode(null != code ? InternalErrorErrorImpl.CodeEnum.from(code.value()) : null);
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
          .setStatus(
              null != status ? InternalErrorErrorImpl.StatusEnum.from(status.value()) : null);
      return this;
    }

    @JsonIgnore
    public Builder setDetails(List<Object> details) {
      getDelegatedBuilder().setDetails(details);
      return this;
    }

    private InternalErrorError.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = InternalErrorError.builder();
      }
      return this._delegatedBuilder;
    }

    public InternalError build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.error = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new InternalErrorImpl(error);
    }
  }

  public static class DelegatedSerializer extends JsonSerializer<OptionalValue<InternalError>> {
    @Override
    public void serialize(
        OptionalValue<InternalError> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      InternalErrorImpl impl = (InternalErrorImpl) value.get();
      jgen.writeObject(null != impl ? impl.getError() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<InternalError> {
    @Override
    public InternalError deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      InternalErrorImpl.Builder builder = new InternalErrorImpl.Builder();
      InternalErrorErrorImpl deserialized = jp.readValueAs(InternalErrorErrorImpl.class);
      builder.setError(deserialized);
      return builder.build();
    }
  }

  public static Optional<InternalError> delegatedConverter(InternalErrorError internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setError(internal).build());
  }
}
