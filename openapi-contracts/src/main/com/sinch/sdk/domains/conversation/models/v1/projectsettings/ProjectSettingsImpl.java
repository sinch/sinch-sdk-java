package com.sinch.sdk.domains.conversation.models.v1.projectsettings;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ProjectSettingsImpl.JSON_PROPERTY_CONTACT_SETTINGS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProjectSettingsImpl implements ProjectSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_SETTINGS = "contact_settings";

  private OptionalValue<ContactSettings> contactSettings;

  public ProjectSettingsImpl() {}

  protected ProjectSettingsImpl(OptionalValue<ContactSettings> contactSettings) {
    this.contactSettings = contactSettings;
  }

  @JsonIgnore
  public ContactSettings getContactSettings() {
    return contactSettings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactSettings> contactSettings() {
    return contactSettings;
  }

  /** Return true if this ProjectSettings_settings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectSettingsImpl projectSettingsSettings = (ProjectSettingsImpl) o;
    return Objects.equals(this.contactSettings, projectSettingsSettings.contactSettings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactSettings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectSettingsImpl {\n");
    sb.append("    contactSettings: ").append(toIndentedString(contactSettings)).append("\n");
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
  static class Builder implements ProjectSettings.Builder {
    OptionalValue<ContactSettings> contactSettings = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_SETTINGS)
    public Builder setContactSettings(ContactSettings contactSettings) {
      this.contactSettings = OptionalValue.of(contactSettings);
      return this;
    }

    public ProjectSettings build() {
      return new ProjectSettingsImpl(contactSettings);
    }
  }
}
