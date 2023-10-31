package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.ActiveNumber.Builder;

/***
 * SMS configuration parameters request to update an active number for a project
 * @since 1.0
 */

public class ActiveNumberUpdateVoiceConfigurationRequestParameters {
  private final String appId;

  /**
   * @param appId Your app ID for the Voice API. The appId can be found in your Sinch Customer
   *     Dashboard under Voice, then apps.
   */
  public ActiveNumberUpdateVoiceConfigurationRequestParameters(String appId) {
    this.appId = appId;
  }

  public String getAppId() {
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
    String appId;

    private Builder() {}

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public ActiveNumberUpdateVoiceConfigurationRequestParameters build() {
      return new ActiveNumberUpdateVoiceConfigurationRequestParameters(appId);
    }
  }
}
