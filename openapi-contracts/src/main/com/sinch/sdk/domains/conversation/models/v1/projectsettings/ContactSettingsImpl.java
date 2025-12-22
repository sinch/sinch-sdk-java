package com.sinch.sdk.domains.conversation.models.v1.projectsettings;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ContactSettingsImpl.JSON_PROPERTY_UNIFIED_CONTACT_ID_ENABLED})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactSettingsImpl implements ContactSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_UNIFIED_CONTACT_ID_ENABLED =
      "unified_contact_id_enabled";

  private OptionalValue<Boolean> unifiedContactIdEnabled;

  public ContactSettingsImpl() {}

  protected ContactSettingsImpl(OptionalValue<Boolean> unifiedContactIdEnabled) {
    this.unifiedContactIdEnabled = unifiedContactIdEnabled;
  }

  @JsonIgnore
  public Boolean getUnifiedContactIdEnabled() {
    return unifiedContactIdEnabled.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UNIFIED_CONTACT_ID_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> unifiedContactIdEnabled() {
    return unifiedContactIdEnabled;
  }

  /** Return true if this ContactSettings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactSettingsImpl contactSettings = (ContactSettingsImpl) o;
    return Objects.equals(this.unifiedContactIdEnabled, contactSettings.unifiedContactIdEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unifiedContactIdEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactSettingsImpl {\n");
    sb.append("    unifiedContactIdEnabled: ")
        .append(toIndentedString(unifiedContactIdEnabled))
        .append("\n");
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
  static class Builder implements ContactSettings.Builder {
    OptionalValue<Boolean> unifiedContactIdEnabled = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_UNIFIED_CONTACT_ID_ENABLED)
    public Builder setUnifiedContactIdEnabled(Boolean unifiedContactIdEnabled) {
      this.unifiedContactIdEnabled = OptionalValue.of(unifiedContactIdEnabled);
      return this;
    }

    public ContactSettings build() {
      return new ContactSettingsImpl(unifiedContactIdEnabled);
    }
  }
}
