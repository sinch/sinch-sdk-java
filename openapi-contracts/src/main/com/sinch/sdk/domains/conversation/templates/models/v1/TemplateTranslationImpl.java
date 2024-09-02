package com.sinch.sdk.domains.conversation.templates.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateTranslationImpl.JSON_PROPERTY_CONTENT,
  TemplateTranslationImpl.JSON_PROPERTY_CREATE_TIME,
  TemplateTranslationImpl.JSON_PROPERTY_LANGUAGE_CODE,
  TemplateTranslationImpl.JSON_PROPERTY_UPDATE_TIME,
  TemplateTranslationImpl.JSON_PROPERTY_VARIABLES,
  TemplateTranslationImpl.JSON_PROPERTY_VERSION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateTranslationImpl implements TemplateTranslation {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTENT = "content";

  private OptionalValue<String> content;

  public static final String JSON_PROPERTY_CREATE_TIME = "create_time";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_LANGUAGE_CODE = "language_code";

  private OptionalValue<String> languageCode;

  public static final String JSON_PROPERTY_UPDATE_TIME = "update_time";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_VARIABLES = "variables";

  private OptionalValue<List<TemplateVariable>> variables;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<String> version;

  public TemplateTranslationImpl() {}

  protected TemplateTranslationImpl(
      OptionalValue<String> content,
      OptionalValue<Instant> createTime,
      OptionalValue<String> languageCode,
      OptionalValue<Instant> updateTime,
      OptionalValue<List<TemplateVariable>> variables,
      OptionalValue<String> version) {
    this.content = content;
    this.createTime = createTime;
    this.languageCode = languageCode;
    this.updateTime = updateTime;
    this.variables = variables;
    this.version = version;
  }

  @JsonIgnore
  public String getContent() {
    return content.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> content() {
    return content;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> createTime() {
    return createTime;
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
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  @JsonIgnore
  public List<TemplateVariable> getVariables() {
    return variables.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateVariable>> variables() {
    return variables;
  }

  @JsonIgnore
  public String getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> version() {
    return version;
  }

  /** Return true if this typeTemplateTranslation object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateTranslationImpl typeTemplateTranslation = (TemplateTranslationImpl) o;
    return Objects.equals(this.content, typeTemplateTranslation.content)
        && Objects.equals(this.createTime, typeTemplateTranslation.createTime)
        && Objects.equals(this.languageCode, typeTemplateTranslation.languageCode)
        && Objects.equals(this.updateTime, typeTemplateTranslation.updateTime)
        && Objects.equals(this.variables, typeTemplateTranslation.variables)
        && Objects.equals(this.version, typeTemplateTranslation.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, createTime, languageCode, updateTime, variables, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateTranslationImpl {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
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
  static class Builder implements TemplateTranslation.Builder {
    OptionalValue<String> content = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<String> languageCode = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<List<TemplateVariable>> variables = OptionalValue.empty();
    OptionalValue<String> version = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTENT)
    public Builder setContent(String content) {
      this.content = OptionalValue.of(content);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LANGUAGE_CODE)
    public Builder setLanguageCode(String languageCode) {
      this.languageCode = OptionalValue.of(languageCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VARIABLES)
    public Builder setVariables(List<TemplateVariable> variables) {
      this.variables = OptionalValue.of(variables);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(String version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    public TemplateTranslation build() {
      return new TemplateTranslationImpl(
          content, createTime, languageCode, updateTime, variables, version);
    }
  }
}
