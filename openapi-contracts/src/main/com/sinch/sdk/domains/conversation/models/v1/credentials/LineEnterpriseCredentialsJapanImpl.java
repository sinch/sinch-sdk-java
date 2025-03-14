package com.sinch.sdk.domains.conversation.models.v1.credentials;

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
import com.sinch.sdk.domains.conversation.models.v1.credentials.internal.LineEnterpriseCredentialsDetailsInternal;
import com.sinch.sdk.domains.conversation.models.v1.credentials.internal.LineEnterpriseCredentialsDetailsInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({
  LineEnterpriseCredentialsJapanImpl.JSON_PROPERTY_LINE_JAPAN,
  LineEnterpriseCredentialsJapanImpl.JSON_PROPERTY_LINE_THAILAND,
  LineEnterpriseCredentialsJapanImpl.JSON_PROPERTY_IS_DEFAULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineEnterpriseCredentialsJapanImpl
    implements LineEnterpriseCredentialsJapan, LineEnterpriseCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINE_JAPAN = "line_japan";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan;

  public static final String JSON_PROPERTY_LINE_THAILAND = "line_thailand";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand;

  public static final String JSON_PROPERTY_IS_DEFAULT = "is_default";

  private OptionalValue<Boolean> isDefault;

  public LineEnterpriseCredentialsJapanImpl() {}

  protected LineEnterpriseCredentialsJapanImpl(
      OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan,
      OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand,
      OptionalValue<Boolean> isDefault) {
    this.lineJapan = lineJapan;
    this.lineThailand = lineThailand;
    this.isDefault = isDefault;
  }

  @JsonIgnore
  public LineEnterpriseCredentialsDetailsInternal getLineJapan() {
    return lineJapan.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE_JAPAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan() {
    return lineJapan;
  }

  @JsonIgnore
  public LineEnterpriseCredentialsDetailsInternal getLineThailand() {
    return lineThailand.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE_THAILAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand() {
    return lineThailand;
  }

  @JsonIgnore
  public Boolean getIsDefault() {
    return isDefault.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> isDefault() {
    return isDefault;
  }

  @JsonIgnore
  public String getToken() {
    if (null == lineJapan || !lineJapan.isPresent() || null == lineJapan.get().getToken()) {
      return null;
    }
    return lineJapan.get().getToken();
  }

  public OptionalValue<String> token() {
    return null != lineJapan && lineJapan.isPresent()
        ? lineJapan
            .map(f -> ((LineEnterpriseCredentialsDetailsInternalImpl) f).token())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getSecret() {
    if (null == lineJapan || !lineJapan.isPresent() || null == lineJapan.get().getSecret()) {
      return null;
    }
    return lineJapan.get().getSecret();
  }

  public OptionalValue<String> secret() {
    return null != lineJapan && lineJapan.isPresent()
        ? lineJapan
            .map(f -> ((LineEnterpriseCredentialsDetailsInternalImpl) f).secret())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this LineEnterpriseCredentialsJapan object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineEnterpriseCredentialsJapanImpl lineEnterpriseCredentialsJapan =
        (LineEnterpriseCredentialsJapanImpl) o;
    return Objects.equals(this.lineJapan, lineEnterpriseCredentialsJapan.lineJapan)
        && Objects.equals(this.lineThailand, lineEnterpriseCredentialsJapan.lineThailand)
        && Objects.equals(this.isDefault, lineEnterpriseCredentialsJapan.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineJapan, lineThailand, isDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineEnterpriseCredentialsJapanImpl {\n");
    sb.append("    lineJapan: ").append(toIndentedString(lineJapan)).append("\n");
    sb.append("    lineThailand: ").append(toIndentedString(lineThailand)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
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
  static class Builder implements LineEnterpriseCredentialsJapan.Builder {
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan = OptionalValue.empty();
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();

    LineEnterpriseCredentialsDetailsInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_LINE_JAPAN, required = true)
    public Builder setLineJapan(LineEnterpriseCredentialsDetailsInternal lineJapan) {
      this.lineJapan = OptionalValue.of(lineJapan);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LINE_THAILAND)
    public Builder setLineThailand(LineEnterpriseCredentialsDetailsInternal lineThailand) {
      this.lineThailand = OptionalValue.of(lineThailand);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_IS_DEFAULT)
    public Builder setIsDefault(Boolean isDefault) {
      this.isDefault = OptionalValue.of(isDefault);
      return this;
    }

    @JsonIgnore
    public Builder setToken(String token) {
      getDelegatedBuilder().setToken(token);
      return this;
    }

    @JsonIgnore
    public Builder setSecret(String secret) {
      getDelegatedBuilder().setSecret(secret);
      return this;
    }

    private LineEnterpriseCredentialsDetailsInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = LineEnterpriseCredentialsDetailsInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public LineEnterpriseCredentialsJapan build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.lineJapan = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new LineEnterpriseCredentialsJapanImpl(lineJapan, lineThailand, isDefault);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<LineEnterpriseCredentialsJapan>> {
    @Override
    public void serialize(
        OptionalValue<LineEnterpriseCredentialsJapan> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      LineEnterpriseCredentialsJapanImpl impl = (LineEnterpriseCredentialsJapanImpl) value.get();
      jgen.writeObject(null != impl ? impl.getLineJapan() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<LineEnterpriseCredentialsJapan> {
    @Override
    public LineEnterpriseCredentialsJapan deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      LineEnterpriseCredentialsJapanImpl.Builder builder =
          new LineEnterpriseCredentialsJapanImpl.Builder();
      LineEnterpriseCredentialsDetailsInternalImpl deserialized =
          jp.readValueAs(LineEnterpriseCredentialsDetailsInternalImpl.class);
      builder.setLineJapan(deserialized);
      return builder.build();
    }
  }

  public static Optional<LineEnterpriseCredentialsJapan> delegatedConverter(
      LineEnterpriseCredentialsDetailsInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setLineJapan(internal).build());
  }
}
