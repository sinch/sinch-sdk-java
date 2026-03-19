package com.sinch.sdk.domains.conversation.models.v1.apps;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({EventDestinationSettingsImpl.JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDestinationSettingsImpl implements EventDestinationSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS =
      "secret_for_overridden_callback_urls";

  private OptionalValue<String> secretForOverriddenTarget;

  public EventDestinationSettingsImpl() {}

  protected EventDestinationSettingsImpl(OptionalValue<String> secretForOverriddenTarget) {
    this.secretForOverriddenTarget = secretForOverriddenTarget;
  }

  @JsonIgnore
  public String getSecretForOverriddenTarget() {
    return secretForOverriddenTarget.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secretForOverriddenTarget() {
    return secretForOverriddenTarget;
  }

  /** Return true if this CallbackSettings object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDestinationSettingsImpl callbackSettings = (EventDestinationSettingsImpl) o;
    return Objects.equals(
        this.secretForOverriddenTarget, callbackSettings.secretForOverriddenTarget);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretForOverriddenTarget);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDestinationSettingsImpl {\n");
    sb.append("    secretForOverriddenTarget: ").append(toIndentedString("***")).append("\n");
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
  static class Builder implements EventDestinationSettings.Builder {
    OptionalValue<String> secretForOverriddenTarget = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS)
    public Builder setSecretForOverriddenTarget(String secretForOverriddenTarget) {
      this.secretForOverriddenTarget = OptionalValue.of(secretForOverriddenTarget);
      return this;
    }

    public EventDestinationSettings build() {
      return new EventDestinationSettingsImpl(secretForOverriddenTarget);
    }
  }
}
