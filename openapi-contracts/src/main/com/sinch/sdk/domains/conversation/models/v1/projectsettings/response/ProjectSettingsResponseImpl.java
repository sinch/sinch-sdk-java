package com.sinch.sdk.domains.conversation.models.v1.projectsettings.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ProjectSettings;
import java.util.Objects;

@JsonPropertyOrder({
  ProjectSettingsResponseImpl.JSON_PROPERTY_PROJECT_ID,
  ProjectSettingsResponseImpl.JSON_PROPERTY_SETTINGS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProjectSettingsResponseImpl implements ProjectSettingsResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROJECT_ID = "project_id";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_SETTINGS = "settings";

  private OptionalValue<ProjectSettings> settings;

  public ProjectSettingsResponseImpl() {}

  protected ProjectSettingsResponseImpl(
      OptionalValue<String> projectId, OptionalValue<ProjectSettings> settings) {
    this.projectId = projectId;
    this.settings = settings;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public ProjectSettings getSettings() {
    return settings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProjectSettings> settings() {
    return settings;
  }

  /** Return true if this ProjectSettings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectSettingsResponseImpl projectSettings = (ProjectSettingsResponseImpl) o;
    return Objects.equals(this.projectId, projectSettings.projectId)
        && Objects.equals(this.settings, projectSettings.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, settings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectSettingsResponseImpl {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
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
  static class Builder implements ProjectSettingsResponse.Builder {
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<ProjectSettings> settings = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SETTINGS)
    public Builder setSettings(ProjectSettings settings) {
      this.settings = OptionalValue.of(settings);
      return this;
    }

    public ProjectSettingsResponse build() {
      return new ProjectSettingsResponseImpl(projectId, settings);
    }
  }
}
