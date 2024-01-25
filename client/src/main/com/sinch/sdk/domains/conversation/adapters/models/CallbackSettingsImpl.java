package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.CallbackSettings;

public class CallbackSettingsImpl implements CallbackSettings {

  private final OptionalValue<String> secretForOverriddenCallbackUrls;

  private CallbackSettingsImpl(OptionalValue<String> secretForOverriddenCallbackUrls) {
    this.secretForOverriddenCallbackUrls = secretForOverriddenCallbackUrls;
  }

  public String getSecretForOverriddenCallbackUrls() {
    return secretForOverriddenCallbackUrls.orElse(null);
  }

  public OptionalValue<String> secretForOverriddenCallbackUrls() {
    return secretForOverriddenCallbackUrls;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CallbackSettings{"
        + "secretForOverriddenCallbackUrls='"
        + secretForOverriddenCallbackUrls
        + '\''
        + '}';
  }

  public static class Builder implements CallbackSettings.Builder {

    OptionalValue<String> secretForOverriddenCallbackUrls = OptionalValue.empty();

    public Builder setSecretForOverriddenCallbackUrls(String secretForOverriddenCallbackUrls) {
      this.secretForOverriddenCallbackUrls = OptionalValue.of(secretForOverriddenCallbackUrls);
      return this;
    }

    public CallbackSettingsImpl build() {
      return new CallbackSettingsImpl(secretForOverriddenCallbackUrls);
    }
  }
}
