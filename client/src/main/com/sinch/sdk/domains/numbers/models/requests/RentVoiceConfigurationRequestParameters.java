package com.sinch.sdk.domains.numbers.models.requests;

/**
 * Voice configuration parameters request to rent a number
 *
 * @since 1.0
 */
public class RentVoiceConfigurationRequestParameters {
  private final String appId;

  /**
   * @param appId Your app ID for the Voice API. The appId can be found in your Sinch Customer
   *     Dashboard under Voice, then apps.
   */
  public RentVoiceConfigurationRequestParameters(String appId) {
    this.appId = appId;
  }

  public String getAppId() {
    return appId;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String appId;

    private Builder() {}

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public RentVoiceConfigurationRequestParameters build() {
      return new RentVoiceConfigurationRequestParameters(appId);
    }
  }
}
