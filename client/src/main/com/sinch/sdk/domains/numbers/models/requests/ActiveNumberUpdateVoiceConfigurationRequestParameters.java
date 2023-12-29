package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/***
 * SMS configuration parameters request to update an active number for a project
 * @since 1.0
 */

public class ActiveNumberUpdateVoiceConfigurationRequestParameters {
  private final OptionalValue<String> appId;

  private ActiveNumberUpdateVoiceConfigurationRequestParameters(OptionalValue<String> appId) {
    this.appId = appId;
  }

  public OptionalValue<String> getAppId() {
    return appId;
  }

  @Override
  public String toString() {
    return "ActiveNumberUpdateVoiceConfigurationRequestParameters{"
        + "appId='"
        + appId
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<String> appId = OptionalValue.empty();

    private Builder() {}

    /**
     * @param appId Your app ID for the Voice API. The appId can be found in your Sinch Customer
     *     Dashboard under Voice, then apps.
     * @return current builder
     */
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public ActiveNumberUpdateVoiceConfigurationRequestParameters build() {
      return new ActiveNumberUpdateVoiceConfigurationRequestParameters(appId);
    }
  }
}
