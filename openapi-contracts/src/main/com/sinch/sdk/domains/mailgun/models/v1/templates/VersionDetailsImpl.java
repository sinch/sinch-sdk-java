package com.sinch.sdk.domains.mailgun.models.v1.templates;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VersionDetailsImpl.JSON_PROPERTY_TAG,
  VersionDetailsImpl.JSON_PROPERTY_TEMPLATE,
  VersionDetailsImpl.JSON_PROPERTY_ENGINE,
  VersionDetailsImpl.JSON_PROPERTY_MJML,
  VersionDetailsImpl.JSON_PROPERTY_CREATED_AT,
  VersionDetailsImpl.JSON_PROPERTY_COMMENT,
  VersionDetailsImpl.JSON_PROPERTY_ACTIVE,
  VersionDetailsImpl.JSON_PROPERTY_ID,
  VersionDetailsImpl.JSON_PROPERTY_HEADERS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VersionDetailsImpl implements VersionDetails, Version {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TAG = "tag";

  private OptionalValue<String> tag;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

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

  public static final String JSON_PROPERTY_HEADERS = "headers";

  private OptionalValue<Map<String, String>> headers;

  public VersionDetailsImpl() {}

  protected VersionDetailsImpl(
      OptionalValue<String> tag,
      OptionalValue<String> template,
      OptionalValue<String> engine,
      OptionalValue<String> mjml,
      OptionalValue<Instant> createdAt,
      OptionalValue<String> comment,
      OptionalValue<Boolean> active,
      OptionalValue<String> id,
      OptionalValue<Map<String, String>> headers) {
    this.tag = tag;
    this.template = template;
    this.engine = engine;
    this.mjml = mjml;
    this.createdAt = createdAt;
    this.comment = comment;
    this.active = active;
    this.id = id;
    this.headers = headers;
  }

  @JsonIgnore
  public String getTag() {
    return tag.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> tag() {
    return tag;
  }

  @JsonIgnore
  public String getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> template() {
    return template;
  }

  @JsonIgnore
  public String getEngine() {
    return engine.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENGINE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> engine() {
    return engine;
  }

  @JsonIgnore
  public String getMjml() {
    return mjml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MJML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> comment() {
    return comment;
  }

  @JsonIgnore
  public Boolean getActive() {
    return active.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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

  @JsonIgnore
  public Map<String, String> getHeaders() {
    return headers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<String, String>> headers() {
    return headers;
  }

  /** Return true if this TemplateVersionDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionDetailsImpl templateVersionDetails = (VersionDetailsImpl) o;
    return Objects.equals(this.tag, templateVersionDetails.tag)
        && Objects.equals(this.template, templateVersionDetails.template)
        && Objects.equals(this.engine, templateVersionDetails.engine)
        && Objects.equals(this.mjml, templateVersionDetails.mjml)
        && Objects.equals(this.createdAt, templateVersionDetails.createdAt)
        && Objects.equals(this.comment, templateVersionDetails.comment)
        && Objects.equals(this.active, templateVersionDetails.active)
        && Objects.equals(this.id, templateVersionDetails.id)
        && Objects.equals(this.headers, templateVersionDetails.headers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag, template, engine, mjml, createdAt, comment, active, id, headers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionDetailsImpl {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
    sb.append("    mjml: ").append(toIndentedString(mjml)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
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
  static class Builder implements VersionDetails.Builder {
    OptionalValue<String> tag = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<String> engine = OptionalValue.empty();
    OptionalValue<String> mjml = OptionalValue.empty();
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<String> comment = OptionalValue.empty();
    OptionalValue<Boolean> active = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<Map<String, String>> headers = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TAG, required = true)
    public Builder setTag(String tag) {
      this.tag = OptionalValue.of(tag);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ENGINE, required = true)
    public Builder setEngine(String engine) {
      this.engine = OptionalValue.of(engine);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MJML, required = true)
    public Builder setMjml(String mjml) {
      this.mjml = OptionalValue.of(mjml);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CREATED_AT, required = true)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_COMMENT, required = true)
    public Builder setComment(String comment) {
      this.comment = OptionalValue.of(comment);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ACTIVE, required = true)
    public Builder setActive(Boolean active) {
      this.active = OptionalValue.of(active);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ID, required = true)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HEADERS)
    public Builder setHeaders(Map<String, String> headers) {
      this.headers = OptionalValue.of(headers);
      return this;
    }

    public VersionDetails build() {
      return new VersionDetailsImpl(
          tag, template, engine, mjml, createdAt, comment, active, id, headers);
    }
  }
}
