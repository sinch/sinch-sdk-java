package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.destination.internal.StreamInternal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({StreamImpl.JSON_PROPERTY_TYPE, StreamImpl.JSON_PROPERTY_STREAM})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StreamImpl implements Stream, CallDestination {
  private static final long serialVersionUID = 1L;

  /** The type property. Must have the value <code>STREAM</code>. */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    /** The <code>STREAM</code> type. */
    public static final TypeEnum STREAM = new TypeEnum("STREAM");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(TypeEnum.class, TypeEnum::new, Arrays.asList(STREAM));

    private TypeEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_STREAM = "stream";

  private OptionalValue<StreamInternal> stream;

  public StreamImpl() {}

  protected StreamImpl(OptionalValue<TypeEnum> type, OptionalValue<StreamInternal> stream) {
    this.type = type;
    this.stream = stream;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public StreamInternal getStream() {
    return stream.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STREAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<StreamInternal> stream() {
    return stream;
  }

  @JsonIgnore
  public String getEndpoint() {
    if (null == stream || !stream.isPresent() || null == stream.get().getEndpoint()) {
      return null;
    }
    return stream.get().getEndpoint();
  }

  @JsonIgnore
  public StreamOptions getStreamOptions() {
    if (null == stream || !stream.isPresent() || null == stream.get().getStreamOptions()) {
      return null;
    }
    return stream.get().getStreamOptions();
  }

  @JsonIgnore
  public List<CallHeader> getCallHeaders() {
    if (null == stream || !stream.isPresent() || null == stream.get().getCallHeaders()) {
      return null;
    }
    return stream.get().getCallHeaders();
  }

  /** Return true if this Stream object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamImpl stream = (StreamImpl) o;
    return Objects.equals(this.type, stream.type) && Objects.equals(this.stream, stream.stream);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, stream);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    stream: ").append(toIndentedString(stream)).append("\n");
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
  static class Builder implements Stream.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.STREAM);
    OptionalValue<StreamInternal> stream = OptionalValue.empty();

    StreamInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.STREAM)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.STREAM, type));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_STREAM, required = true)
    public Builder setStream(StreamInternal stream) {
      this.stream = OptionalValue.of(stream);
      return this;
    }

    @JsonIgnore
    public Builder setEndpoint(String endpoint) {
      getDelegatedBuilder().setEndpoint(endpoint);
      return this;
    }

    @JsonIgnore
    public Builder setStreamOptions(StreamOptions streamOptions) {
      getDelegatedBuilder().setStreamOptions(streamOptions);
      return this;
    }

    @JsonIgnore
    public Builder setCallHeaders(List<CallHeader> callHeaders) {
      getDelegatedBuilder().setCallHeaders(callHeaders);
      return this;
    }

    private StreamInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StreamInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public Stream build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.stream = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StreamImpl(type, stream);
    }
  }
}
