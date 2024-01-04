package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Voice configuration parameters request to rent a number
 *
 * @since 1.0
 */
public class RentVoiceConfigurationRequestParameters {
  private final OptionalValue<String> appId;

  private RentVoiceConfigurationRequestParameters(OptionalValue<String> appId) {
    this.appId = appId;
  }

  public OptionalValue<String> getAppId() {
    return appId;
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

    public RentVoiceConfigurationRequestParameters build() {
      return new RentVoiceConfigurationRequestParameters(appId);
    }
  }
}
