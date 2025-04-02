package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  VersionImpl.JSON_PROPERTY_TAG,
  VersionImpl.JSON_PROPERTY_ENGINE,
  VersionImpl.JSON_PROPERTY_MJML,
  VersionImpl.JSON_PROPERTY_CREATED_AT,
  VersionImpl.JSON_PROPERTY_COMMENT,
  VersionImpl.JSON_PROPERTY_ACTIVE,
  VersionImpl.JSON_PROPERTY_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VersionImpl implements Version {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TAG = "tag";

  private OptionalValue<String> tag;

  public static final String JSON_PROPERTY_ENGINE = "engine";

  private OptionalValue<String> engine;

  public static final String JSON_PROPERTY_MJML = "mjml";

  private OptionalValue<String> mjml;

  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";

  private OptionalValue<Instant> createdAt;

  public static final String JSON_PROPERTY_COMMENT = "comment";

  private OptionalValue<String> comment;

  public static final String JSON_PROPERTY_ACTIVE = "active";

  private OptionalValue<Boolean> active;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public VersionImpl() {}

  protected VersionImpl(
      OptionalValue<String> tag,
      OptionalValue<String> engine,
      OptionalValue<String> mjml,
      OptionalValue<Instant> createdAt,
      OptionalValue<String> comment,
      OptionalValue<Boolean> active,
      OptionalValue<String> id) {
    this.tag = tag;
    this.engine = engine;
    this.mjml = mjml;
    this.createdAt = createdAt;
    this.comment = comment;
    this.active = active;
    this.id = id;
  }

  @JsonIgnore
  public String getTag() {
    return tag.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> tag() {
    return tag;
  }

  @JsonIgnore
  public String getEngine() {
    return engine.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENGINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> engine() {
    return engine;
  }

  @JsonIgnore
  public String getMjml() {
    return mjml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MJML)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> mjml() {
    return mjml;
  }

  @JsonIgnore
  public Instant getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createdAt() {
    return createdAt;
  }

  @JsonIgnore
  public String getComment() {
    return comment.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> comment() {
    return comment;
  }

  @JsonIgnore
  public Boolean getActive() {
    return active.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> active() {
    return active;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> id() {
    return id;
  }

  /** Return true if this TemplateVersion object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionImpl templateVersion = (VersionImpl) o;
    return Objects.equals(this.tag, templateVersion.tag)
        && Objects.equals(this.engine, templateVersion.engine)
        && Objects.equals(this.mjml, templateVersion.mjml)
        && Objects.equals(this.createdAt, templateVersion.createdAt)
        && Objects.equals(this.comment, templateVersion.comment)
        && Objects.equals(this.active, templateVersion.active)
        && Objects.equals(this.id, templateVersion.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag, engine, mjml, createdAt, comment, active, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionImpl {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    mjml: ").append(toIndentedString(mjml)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
  static class Builder implements Version.Builder {
    OptionalValue<String> tag = OptionalValue.empty();
    OptionalValue<String> engine = OptionalValue.empty();
    OptionalValue<String> mjml = OptionalValue.empty();
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<String> comment = OptionalValue.empty();
    OptionalValue<Boolean> active = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TAG)
    public Builder setTag(String tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENGINE)
    public Builder setEngine(String engine) {
      this.engine = OptionalValue.of(engine);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MJML)
    public Builder setMjml(String mjml) {
      this.mjml = OptionalValue.of(mjml);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_COMMENT)
    public Builder setComment(String comment) {
      this.comment = OptionalValue.of(comment);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVE)
    public Builder setActive(Boolean active) {
      this.active = OptionalValue.of(active);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    public Version build() {
      return new VersionImpl(tag, engine, mjml, createdAt, comment, active, id);
    }
  }
}
