package com.sinch.sdk.domains.conversation.templates.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateVariableImpl.JSON_PROPERTY_KEY,
  TemplateVariableImpl.JSON_PROPERTY_PREVIEW_VALUE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateVariableImpl implements TemplateVariable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KEY = "key";

  private OptionalValue<String> key;

  public static final String JSON_PROPERTY_PREVIEW_VALUE = "preview_value";

  private OptionalValue<String> previewValue;

  public TemplateVariableImpl() {}

  protected TemplateVariableImpl(OptionalValue<String> key, OptionalValue<String> previewValue) {
    this.key = key;
    this.previewValue = previewValue;
  }

  @JsonIgnore
  public String getKey() {
    return key.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> key() {
    return key;
  }

  @JsonIgnore
  public String getPreviewValue() {
    return previewValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PREVIEW_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> previewValue() {
    return previewValue;
  }

  /** Return true if this typeTemplateVariable object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateVariableImpl typeTemplateVariable = (TemplateVariableImpl) o;
    return Objects.equals(this.key, typeTemplateVariable.key)
        && Objects.equals(this.previewValue, typeTemplateVariable.previewValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, previewValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateVariableImpl {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    previewValue: ").append(toIndentedString(previewValue)).append("\n");
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
  static class Builder implements TemplateVariable.Builder {
    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<String> previewValue = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KEY)
    public Builder setKey(String key) {
      this.key = OptionalValue.of(key);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PREVIEW_VALUE)
    public Builder setPreviewValue(String previewValue) {
      this.previewValue = OptionalValue.of(previewValue);
      return this;
    }

    public TemplateVariable build() {
      return new TemplateVariableImpl(key, previewValue);
    }
  }
}
