package com.sinch.sdk.domains.conversation.models.v1.credentials.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  LineEnterpriseCredentialsInternalImpl.JSON_PROPERTY_LINE_JAPAN,
  LineEnterpriseCredentialsInternalImpl.JSON_PROPERTY_LINE_THAILAND,
  LineEnterpriseCredentialsInternalImpl.JSON_PROPERTY_IS_DEFAULT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LineEnterpriseCredentialsInternalImpl implements LineEnterpriseCredentialsInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LINE_JAPAN = "line_japan";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan;

  public static final String JSON_PROPERTY_LINE_THAILAND = "line_thailand";

  private OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand;

  public static final String JSON_PROPERTY_IS_DEFAULT = "is_default";

  private OptionalValue<Boolean> isDefault;

  public LineEnterpriseCredentialsInternalImpl() {}

  protected LineEnterpriseCredentialsInternalImpl(
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

  /** Return true if this LINE_Enterprise_Credentials object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineEnterpriseCredentialsInternalImpl liNEEnterpriseCredentials =
        (LineEnterpriseCredentialsInternalImpl) o;
    return Objects.equals(this.lineJapan, liNEEnterpriseCredentials.lineJapan)
        && Objects.equals(this.lineThailand, liNEEnterpriseCredentials.lineThailand)
        && Objects.equals(this.isDefault, liNEEnterpriseCredentials.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineJapan, lineThailand, isDefault);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineEnterpriseCredentialsInternalImpl {\n");
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
  static class Builder implements LineEnterpriseCredentialsInternal.Builder {
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineJapan = OptionalValue.empty();
    OptionalValue<LineEnterpriseCredentialsDetailsInternal> lineThailand = OptionalValue.empty();
    OptionalValue<Boolean> isDefault = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LINE_JAPAN)
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

    public LineEnterpriseCredentialsInternal build() {
      return new LineEnterpriseCredentialsInternalImpl(lineJapan, lineThailand, isDefault);
    }
  }
}
