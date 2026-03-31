package com.sinch.sdk.domains.conversation.models.v1.projectsettings.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.projectsettings.ContactSettings;
import java.util.Objects;

@JsonPropertyOrder({ProjectSettingsRequestImpl.JSON_PROPERTY_CONTACT_SETTINGS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProjectSettingsRequestImpl implements ProjectSettingsRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CONTACT_SETTINGS = "contact_settings";

  private OptionalValue<ContactSettings> contactSettings;

  public ProjectSettingsRequestImpl() {}

  protected ProjectSettingsRequestImpl(OptionalValue<ContactSettings> contactSettings) {
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

  /** Return true if this ProjectSettingsRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectSettingsRequestImpl projectSettingsRequest = (ProjectSettingsRequestImpl) o;
    return Objects.equals(this.contactSettings, projectSettingsRequest.contactSettings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactSettings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectSettingsRequestImpl {\n");
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
  static class Builder implements ProjectSettingsRequest.Builder {
    OptionalValue<ContactSettings> contactSettings = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CONTACT_SETTINGS)
    public Builder setContactSettings(ContactSettings contactSettings) {
      this.contactSettings = OptionalValue.of(contactSettings);
      return this;
    }

    public ProjectSettingsRequest build() {
      return new ProjectSettingsRequestImpl(contactSettings);
    }
  }
}
