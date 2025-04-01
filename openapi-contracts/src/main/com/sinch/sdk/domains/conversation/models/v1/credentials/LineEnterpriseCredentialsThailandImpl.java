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
  LineEnterpriseCredentialsThailandImpl.JSON_PROPERTY_LINE_JAPAN,
  LineEnterpriseCredentialsThailandImpl.JSON_PROPERTY_LINE_THAILAND,
  LineEnterpriseCredentialsThailandImpl.JSON_PROPERTY_IS_DEFAULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineEnterpriseCredentialsThailandImpl
    implements LineEnterpriseCredentialsThailand, LineEnterpriseCredentials {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINE_JAPAN = "line_japan";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan;

  public static final String JSON_PROPERTY_LINE_THAILAND = "line_thailand";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand;

  public static final String JSON_PROPERTY_IS_DEFAULT = "is_default";

  private OptionalValue<Boolean> isDefault;

  public LineEnterpriseCredentialsThailandImpl() {}

  protected LineEnterpriseCredentialsThailandImpl(
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
    if (null == lineThailand
        || !lineThailand.isPresent()
        || null == lineThailand.get().getToken()) {
      return null;
    }
    return lineThailand.get().getToken();
  }

  public OptionalValue<String> token() {
    return null != lineThailand && lineThailand.isPresent()
        ? lineThailand
            .map(f -> ((LineEnterpriseCredentialsDetailsInternalImpl) f).token())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getSecret() {
    if (null == lineThailand
        || !lineThailand.isPresent()
        || null == lineThailand.get().getSecret()) {
      return null;
    }
    return lineThailand.get().getSecret();
  }

  public OptionalValue<String> secret() {
    return null != lineThailand && lineThailand.isPresent()
        ? lineThailand
            .map(f -> ((LineEnterpriseCredentialsDetailsInternalImpl) f).secret())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this LineEnterpriseCredentialsThailand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineEnterpriseCredentialsThailandImpl lineEnterpriseCredentialsThailand =
        (LineEnterpriseCredentialsThailandImpl) o;
    return Objects.equals(this.lineJapan, lineEnterpriseCredentialsThailand.lineJapan)
        && Objects.equals(this.lineThailand, lineEnterpriseCredentialsThailand.lineThailand)
        && Objects.equals(this.isDefault, lineEnterpriseCredentialsThailand.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineJapan, lineThailand, isDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineEnterpriseCredentialsThailandImpl {\n");
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
  static class Builder implements LineEnterpriseCredentialsThailand.Builder {
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan = OptionalValue.empty();
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();

    LineEnterpriseCredentialsDetailsInternal.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_LINE_JAPAN)
    public Builder setLineJapan(LineEnterpriseCredentialsDetailsInternal lineJapan) {
      this.lineJapan = OptionalValue.of(lineJapan);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_LINE_THAILAND, required = true)
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

    public LineEnterpriseCredentialsThailand build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.lineThailand = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new LineEnterpriseCredentialsThailandImpl(lineJapan, lineThailand, isDefault);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<LineEnterpriseCredentialsThailand>> {
    @Override
    public void serialize(
        OptionalValue<LineEnterpriseCredentialsThailand> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      LineEnterpriseCredentialsThailandImpl impl =
          (LineEnterpriseCredentialsThailandImpl) value.get();
      jgen.writeObject(null != impl ? impl.getLineThailand() : null);
    }
  }

  public static class DelegatedDeSerializer
      extends JsonDeserializer<LineEnterpriseCredentialsThailand> {
    @Override
    public LineEnterpriseCredentialsThailand deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      LineEnterpriseCredentialsThailandImpl.Builder builder =
          new LineEnterpriseCredentialsThailandImpl.Builder();
      LineEnterpriseCredentialsDetailsInternalImpl deserialized =
          jp.readValueAs(LineEnterpriseCredentialsDetailsInternalImpl.class);
      builder.setLineThailand(deserialized);
      return builder.build();
    }
  }

  public static Optional<LineEnterpriseCredentialsThailand> delegatedConverter(
      LineEnterpriseCredentialsDetailsInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setLineThailand(internal).build());
  }
}
