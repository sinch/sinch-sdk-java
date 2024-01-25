package com.sinch.sdk.domains.conversation.models;

public interface CallbackSettings {

  public String getSecretForOverriddenCallbackUrls();

  public static Builder builder() {
    return BuildersDelegation.CallbackSettingsBuilder();
  }

  public interface Builder {

    public Builder setSecretForOverriddenCallbackUrls(String secretForOverriddenCallbackUrls);

    public CallbackSettings build();
  }
}
