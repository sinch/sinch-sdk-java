package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateV2Impl.JSON_PROPERTY_ID,
  TemplateV2Impl.JSON_PROPERTY_DESCRIPTION,
  TemplateV2Impl.JSON_PROPERTY_VERSION,
  TemplateV2Impl.JSON_PROPERTY_DEFAULT_TRANSLATION,
  TemplateV2Impl.JSON_PROPERTY_TRANSLATIONS,
  TemplateV2Impl.JSON_PROPERTY_CREATE_TIME,
  TemplateV2Impl.JSON_PROPERTY_UPDATE_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateV2Impl implements TemplateV2 {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<Integer> version;

  public static final String JSON_PROPERTY_DEFAULT_TRANSLATION = "default_translation";

  private OptionalValue<String> defaultTranslation;

  public static final String JSON_PROPERTY_TRANSLATIONS = "translations";

  private OptionalValue<Collection<TemplateTranslation>> translations;

  public static final String JSON_PROPERTY_CREATE_TIME = "create_time";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "update_time";

  private OptionalValue<Instant> updateTime;

  public TemplateV2Impl() {}

  protected TemplateV2Impl(
      OptionalValue<String> id,
      OptionalValue<String> description,
      OptionalValue<Integer> version,
      OptionalValue<String> defaultTranslation,
      OptionalValue<Collection<TemplateTranslation>> translations,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime) {
    this.id = id;
    this.description = description;
    this.version = version;
    this.defaultTranslation = defaultTranslation;
    this.translations = translations;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public Integer getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> version() {
    return version;
  }

  @JsonIgnore
  public String getDefaultTranslation() {
    return defaultTranslation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DEFAULT_TRANSLATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> defaultTranslation() {
    return defaultTranslation;
  }

  @JsonIgnore
  public Collection<TemplateTranslation> getTranslations() {
    return translations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Collection<TemplateTranslation>> translations() {
    return translations;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  /** Return true if this v2Template object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateV2Impl v2Template = (TemplateV2Impl) o;
    return Objects.equals(this.id, v2Template.id)
        && Objects.equals(this.description, v2Template.description)
        && Objects.equals(this.version, v2Template.version)
        && Objects.equals(this.defaultTranslation, v2Template.defaultTranslation)
        && Objects.equals(this.translations, v2Template.translations)
        && Objects.equals(this.createTime, v2Template.createTime)
        && Objects.equals(this.updateTime, v2Template.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, description, version, defaultTranslation, translations, createTime, updateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateV2Impl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    defaultTranslation: ").append(toIndentedString(defaultTranslation)).append("\n");
    sb.append("    translations: ").append(toIndentedString(translations)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
  static class Builder implements TemplateV2.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Integer> version = OptionalValue.empty();
    OptionalValue<String> defaultTranslation = OptionalValue.empty();
    OptionalValue<Collection<TemplateTranslation>> translations = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(Integer version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT_TRANSLATION)
    public Builder setDefaultTranslation(String defaultTranslation) {
      this.defaultTranslation = OptionalValue.of(defaultTranslation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
    public Builder setTranslations(Collection<TemplateTranslation> translations) {
      this.translations = OptionalValue.of(translations);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    public TemplateV2 build() {
      return new TemplateV2Impl(
          id, description, version, defaultTranslation, translations, createTime, updateTime);
    }
  }
}
