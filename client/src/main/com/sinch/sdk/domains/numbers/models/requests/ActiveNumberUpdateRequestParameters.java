package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Parameters request to update an active number for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/#tag/Active-Number/operation/NumberService_UpdateActiveNumber">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/#tag/Active-Number/operation/NumberService_UpdateActiveNumber</a>
 * @since 1.0
 */
public class ActiveNumberUpdateRequestParameters {
  private final OptionalValue<String> displayName;
  private final OptionalValue<ActiveNumberUpdateSMSConfigurationRequestParameters> smsConfiguration;
  private final OptionalValue<ActiveNumberUpdateVoiceConfigurationRequestParameters>
      voiceConfiguration;
  private final OptionalValue<String> callback;

  private ActiveNumberUpdateRequestParameters(
      OptionalValue<String> displayName,
      OptionalValue<ActiveNumberUpdateSMSConfigurationRequestParameters> smsConfiguration,
      OptionalValue<ActiveNumberUpdateVoiceConfigurationRequestParameters> voiceConfiguration,
      OptionalValue<String> callback) {
    this.displayName = displayName;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callback = callback;
  }

  public OptionalValue<String> getDisplayName() {
    return displayName;
  }

  public OptionalValue<ActiveNumberUpdateSMSConfigurationRequestParameters> getSmsConfiguration() {
    return smsConfiguration;
  }

  public OptionalValue<ActiveNumberUpdateVoiceConfigurationRequestParameters>
      getVoiceConfiguration() {
    return voiceConfiguration;
  }

  public OptionalValue<String> getCallback() {
    return callback;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<ActiveNumberUpdateSMSConfigurationRequestParameters> smsConfiguration =
        OptionalValue.empty();
    OptionalValue<ActiveNumberUpdateVoiceConfigurationRequestParameters> voiceConfiguration =
        OptionalValue.empty();
    OptionalValue<String> callback = OptionalValue.empty();

    private Builder() {}

    /**
     * @param displayName User supplied name for the phone number
     * @return current builder
     */
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    /**
     * @param smsConfiguration The current SMS configuration for this number
     * @return current builder
     */
    public Builder setSmsConfiguration(
        ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    /**
     * @param voiceConfiguration The current voice configuration for this number
     * @return current builder
     */
    public Builder setVoiceConfiguration(
        ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    /**
     * @param callback The callback URL to be called for a rented number's provisioning /
     *     deprovisioning operations ({@link com.sinch.sdk.domains.numbers.WebHooksService see
     *     WebHooksService})
     * @return current builder
     */
    public Builder setCallback(String callback) {
      this.callback = OptionalValue.of(callback);
      return this;
    }

    public ActiveNumberUpdateRequestParameters build() {
      return new ActiveNumberUpdateRequestParameters(
          displayName, smsConfiguration, voiceConfiguration, callback);
    }
  }
}
