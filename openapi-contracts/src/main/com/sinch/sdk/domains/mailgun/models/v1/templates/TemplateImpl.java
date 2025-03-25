package com.sinch.sdk.domains.mailgun.models.v1.templates;

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
  TemplateImpl.JSON_PROPERTY_NAME,
  TemplateImpl.JSON_PROPERTY_DESCRIPTION,
  TemplateImpl.JSON_PROPERTY_CREATED_AT,
  TemplateImpl.JSON_PROPERTY_CREATED_BY,
  TemplateImpl.JSON_PROPERTY_ID,
  TemplateImpl.JSON_PROPERTY_VERSION,
  TemplateImpl.JSON_PROPERTY_VERSIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateImpl implements Template {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";

  private OptionalValue<Instant> createdAt;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";

  private OptionalValue<String> createdBy;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<VersionDetails> version;

  public static final String JSON_PROPERTY_VERSIONS = "versions";

  private OptionalValue<List<Version>> versions;

  public TemplateImpl() {}

  protected TemplateImpl(
      OptionalValue<String> name,
      OptionalValue<String> description,
      OptionalValue<Instant> createdAt,
      OptionalValue<String> createdBy,
      OptionalValue<String> id,
      OptionalValue<VersionDetails> version,
      OptionalValue<List<Version>> versions) {
    this.name = name;
    this.description = description;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.id = id;
    this.version = version;
    this.versions = versions;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> name() {
    return name;
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
  public Instant getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> createdAt() {
    return createdAt;
  }

  @JsonIgnore
  public String getCreatedBy() {
    return createdBy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> createdBy() {
    return createdBy;
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
  public VersionDetails getVersion() {
    return version.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<VersionDetails> version() {
    return version;
  }

  @JsonIgnore
  public List<Version> getVersions() {
    return versions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Version>> versions() {
    return versions;
  }

  /** Return true if this github.com-mailgun-temple-model-Template object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateImpl githubComMailgunTempleModelTemplate = (TemplateImpl) o;
    return Objects.equals(this.name, githubComMailgunTempleModelTemplate.name)
        && Objects.equals(this.description, githubComMailgunTempleModelTemplate.description)
        && Objects.equals(this.createdAt, githubComMailgunTempleModelTemplate.createdAt)
        && Objects.equals(this.createdBy, githubComMailgunTempleModelTemplate.createdBy)
        && Objects.equals(this.id, githubComMailgunTempleModelTemplate.id)
        && Objects.equals(this.version, githubComMailgunTempleModelTemplate.version)
        && Objects.equals(this.versions, githubComMailgunTempleModelTemplate.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, createdAt, createdBy, id, version, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
  static class Builder implements Template.Builder {
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<String> createdBy = OptionalValue.empty();
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<VersionDetails> version = OptionalValue.empty();
    OptionalValue<List<Version>> versions = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    public Builder setCreatedBy(String createdBy) {
      this.createdBy = OptionalValue.of(createdBy);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public Builder setVersion(VersionDetails version) {
      this.version = OptionalValue.of(version);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VERSIONS)
    public Builder setVersions(List<Version> versions) {
      this.versions = OptionalValue.of(versions);
      return this;
    }

    public Template build() {
      return new TemplateImpl(name, description, createdAt, createdBy, id, version, versions);
    }
  }
}
