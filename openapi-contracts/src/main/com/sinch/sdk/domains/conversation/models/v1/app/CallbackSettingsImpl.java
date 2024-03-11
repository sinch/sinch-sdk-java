package com.sinch.sdk.domains.conversation.models.v1.app;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({CallbackSettingsImpl.JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallbackSettingsImpl implements CallbackSettings {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS =
      "secret_for_overridden_callback_urls";

  private OptionalValue<String> secretForOverriddenCallbackUrls;

  public CallbackSettingsImpl() {}

  protected CallbackSettingsImpl(OptionalValue<String> secretForOverriddenCallbackUrls) {
    this.secretForOverriddenCallbackUrls = secretForOverriddenCallbackUrls;
  }

  @JsonIgnore
  public String getSecretForOverriddenCallbackUrls() {
    return secretForOverriddenCallbackUrls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> secretForOverriddenCallbackUrls() {
    return secretForOverriddenCallbackUrls;
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
    CallbackSettingsImpl callbackSettings = (CallbackSettingsImpl) o;
    return Objects.equals(
        this.secretForOverriddenCallbackUrls, callbackSettings.secretForOverriddenCallbackUrls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretForOverriddenCallbackUrls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackSettingsImpl {\n");
    sb.append("    secretForOverriddenCallbackUrls: ")
        .append(toIndentedString(secretForOverriddenCallbackUrls))
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
  static class Builder implements CallbackSettings.Builder {
    OptionalValue<String> secretForOverriddenCallbackUrls = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SECRET_FOR_OVERRIDDEN_CALLBACK_URLS)
    public Builder setSecretForOverriddenCallbackUrls(String secretForOverriddenCallbackUrls) {
      this.secretForOverriddenCallbackUrls = OptionalValue.of(secretForOverriddenCallbackUrls);
      return this;
    }

    public CallbackSettings build() {
      return new CallbackSettingsImpl(secretForOverriddenCallbackUrls);
    }
  }
}
