package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.ActiveNumber.Builder;
import java.util.Optional;

/**
 * Parameters request to update an active number for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/#tag/Active-Number/operation/NumberService_UpdateActiveNumber">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/#tag/Active-Number/operation/NumberService_UpdateActiveNumber</a>
 * @since 1.0
 */
public class ActiveNumberUpdateRequestParameters {
  private final String displayName;
  private final ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration;
  private final ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration;
  private final String callback;

  /**
   * @param displayName User supplied name for the phone number
   * @param smsConfiguration The current SMS configuration for this number
   * @param voiceConfiguration The current voice configuration for this number
   * @param callback The callback URL to be called for a rented number's provisioning /
   *     deprovisioning operations
   */
  public ActiveNumberUpdateRequestParameters(
      String displayName,
      ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration,
      ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration,
      String callback) {
    this.displayName = displayName;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callback = callback;
  }

  public Optional<String> getDisplayName() {
    return Optional.ofNullable(displayName);
  }

  public Optional<ActiveNumberUpdateSMSConfigurationRequestParameters> getSmsConfiguration() {
    return Optional.ofNullable(smsConfiguration);
  }

  public Optional<ActiveNumberUpdateVoiceConfigurationRequestParameters> getVoiceConfiguration() {
    return Optional.ofNullable(voiceConfiguration);
  }

  public Optional<String> getCallback() {
    return Optional.ofNullable(callback);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String displayName;
    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration;
    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration;
    String callback;

    private Builder() {}

    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder setSmsConfiguration(
        ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration) {
      this.smsConfiguration = smsConfiguration;
      return this;
    }

    public Builder setVoiceConfiguration(
        ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration) {
      this.voiceConfiguration = voiceConfiguration;
      return this;
    }

    public Builder setCallback(String callback) {
      this.callback = callback;
      return this;
    }

    public ActiveNumberUpdateRequestParameters build() {
      return new ActiveNumberUpdateRequestParameters(
          displayName, smsConfiguration, voiceConfiguration, callback);
    }
  }
}
