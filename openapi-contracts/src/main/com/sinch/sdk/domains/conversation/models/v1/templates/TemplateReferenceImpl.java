package com.sinch.sdk.domains.conversation.models.v1.templates;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateReferenceImpl.JSON_PROPERTY_LANGUAGE_CODE,
  TemplateReferenceImpl.JSON_PROPERTY_PARAMETERS,
  TemplateReferenceImpl.JSON_PROPERTY_TEMPLATE_ID,
  TemplateReferenceImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateReferenceImpl implements TemplateReference {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LANGUAGE_CODE = "language_code";

  private OptionalValue<String> languageCode;

  public static final String JSON_PROPERTY_PARAMETERS = "parameters";

  private OptionalValue<Map<String, String>> parameters;

  public static final String JSON_PROPERTY_TEMPLATE_ID = "template_id";

  private OptionalValue<String> templateId;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<String> version;

  public TemplateReferenceImpl() {}

  protected TemplateReferenceImpl(
      OptionalValue<String> languageCode,
      OptionalValue<Map<String, String>> parameters,
      OptionalValue<String> templateId,
      OptionalValue<String> version) {
    this.languageCode = languageCode;
    this.parameters = parameters;
    this.templateId = templateId;
    this.version = version;
  }

  @JsonIgnore
  public String getLanguageCode() {
    return languageCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> languageCode() {
    return languageCode;
  }

  @JsonIgnore
  public Map<String, String> getParameters() {
    return parameters.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PARAMETERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, String>> parameters() {
    return parameters;
  }

  @JsonIgnore
  public String getTemplateId() {
    return templateId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> templateId() {
    return templateId;
  }

  @JsonIgnore
  public String getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> version() {
    return version;
  }

  /** Return true if this TemplateReference object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateReferenceImpl templateReference = (TemplateReferenceImpl) o;
    return Objects.equals(this.languageCode, templateReference.languageCode)
        && Objects.equals(this.parameters, templateReference.parameters)
        && Objects.equals(this.templateId, templateReference.templateId)
        && Objects.equals(this.version, templateReference.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languageCode, parameters, templateId, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateReferenceImpl {\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    templateId: ").append(toIndentedString(templateId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
  static class Builder implements TemplateReference.Builder {
    OptionalValue<String> languageCode = OptionalValue.empty();
    OptionalValue<Map<String, String>> parameters = OptionalValue.empty();
    OptionalValue<String> templateId = OptionalValue.empty();
    OptionalValue<String> version = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LANGUAGE_CODE)
    public Builder setLanguageCode(String languageCode) {
      this.languageCode = OptionalValue.of(languageCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    public Builder setParameters(Map<String, String> parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE_ID)
    public Builder setTemplateId(String templateId) {
      this.templateId = OptionalValue.of(templateId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(String version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    public TemplateReference build() {
      return new TemplateReferenceImpl(languageCode, parameters, templateId, version);
    }
  }
}
