package com.sinch.sdk.domains.conversation.templates.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateV1Impl.JSON_PROPERTY_CHANNEL,
  TemplateV1Impl.JSON_PROPERTY_CREATE_TIME,
  TemplateV1Impl.JSON_PROPERTY_DEFAULT_TRANSLATION,
  TemplateV1Impl.JSON_PROPERTY_DESCRIPTION,
  TemplateV1Impl.JSON_PROPERTY_ID,
  TemplateV1Impl.JSON_PROPERTY_TRANSLATIONS,
  TemplateV1Impl.JSON_PROPERTY_UPDATE_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateV1Impl implements TemplateV1 {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL = "channel";

  private OptionalValue<TemplateChannel> channel;

  public static final String JSON_PROPERTY_CREATE_TIME = "create_time";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_DEFAULT_TRANSLATION = "default_translation";

  private OptionalValue<String> defaultTranslation;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_TRANSLATIONS = "translations";

  private OptionalValue<List<TemplateTranslation>> translations;

  public static final String JSON_PROPERTY_UPDATE_TIME = "update_time";

  private OptionalValue<Instant> updateTime;

  public TemplateV1Impl() {}

  protected TemplateV1Impl(
      OptionalValue<TemplateChannel> channel,
      OptionalValue<Instant> createTime,
      OptionalValue<String> defaultTranslation,
      OptionalValue<String> description,
      OptionalValue<String> id,
      OptionalValue<List<TemplateTranslation>> translations,
      OptionalValue<Instant> updateTime) {
    this.channel = channel;
    this.createTime = createTime;
    this.defaultTranslation = defaultTranslation;
    this.description = description;
    this.id = id;
    this.translations = translations;
    this.updateTime = updateTime;
  }

  @JsonIgnore
  public TemplateChannel getChannel() {
    return channel.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateChannel> channel() {
    return channel;
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
  public String getDefaultTranslation() {
    return defaultTranslation.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DEFAULT_TRANSLATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> defaultTranslation() {
    return defaultTranslation;
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
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public List<TemplateTranslation> getTranslations() {
    return translations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateTranslation>> translations() {
    return translations;
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

  /** Return true if this typeTemplate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateV1Impl typeTemplate = (TemplateV1Impl) o;
    return Objects.equals(this.channel, typeTemplate.channel)
        && Objects.equals(this.createTime, typeTemplate.createTime)
        && Objects.equals(this.defaultTranslation, typeTemplate.defaultTranslation)
        && Objects.equals(this.description, typeTemplate.description)
        && Objects.equals(this.id, typeTemplate.id)
        && Objects.equals(this.translations, typeTemplate.translations)
        && Objects.equals(this.updateTime, typeTemplate.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channel, createTime, defaultTranslation, description, id, translations, updateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateV1Impl {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    defaultTranslation: ").append(toIndentedString(defaultTranslation)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    translations: ").append(toIndentedString(translations)).append("\n");
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
  static class Builder implements TemplateV1.Builder {
    OptionalValue<TemplateChannel> channel = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<String> defaultTranslation = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<List<TemplateTranslation>> translations = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    public Builder setChannel(TemplateChannel channel) {
      this.channel = OptionalValue.of(channel);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public Builder setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT_TRANSLATION)
    public Builder setDefaultTranslation(String defaultTranslation) {
      this.defaultTranslation = OptionalValue.of(defaultTranslation);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
    public Builder setTranslations(List<TemplateTranslation> translations) {
      this.translations = OptionalValue.of(translations);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    public TemplateV1 build() {
      return new TemplateV1Impl(
          channel, createTime, defaultTranslation, description, id, translations, updateTime);
    }
  }
}
