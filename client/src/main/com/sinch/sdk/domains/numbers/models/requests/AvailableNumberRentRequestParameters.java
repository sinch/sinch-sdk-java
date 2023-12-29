package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Parameters request to rent a number
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_RentNumber">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_RentNumber</a>
 * @since 1.0
 */
public class AvailableNumberRentRequestParameters {
  private final OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration;
  private final OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration;
  private final OptionalValue<String> callbackUrl;

  private AvailableNumberRentRequestParameters(
      OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration,
      OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration,
      OptionalValue<String> callbackUrl) {
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  public OptionalValue<RentSMSConfigurationRequestParameters> getSmsConfiguration() {
    return smsConfiguration;
  }

  public OptionalValue<RentVoiceConfigurationRequestParameters> getVoiceConfiguration() {
    return voiceConfiguration;
  }

  public OptionalValue<String> getCallBackUrl() {
    return callbackUrl;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration = OptionalValue.empty();
    OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration =
        OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();

    private Builder() {}

    /**
     * @param smsConfiguration The current SMS configuration for this number
     * @return current builder
     */
    public Builder setSmsConfiguration(RentSMSConfigurationRequestParameters smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    /**
     * @param voiceConfiguration The current voice configuration for this number. During scheduled
     *     provisioning, the app ID value may be empty in a response if it is still processing or if
     *     it has failed. The status of scheduled provisioning will show under a
     *     scheduledVoiceProvisioning object if it's still running. Once processed successfully, the
     *     appId sent will appear directly under the voiceConfiguration object.
     * @return current builder
     */
    public Builder setVoiceConfiguration(
        RentVoiceConfigurationRequestParameters voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    /**
     * @param callbackUrl The callback URL to be called for a rented number's provisioning /
     *     de-provisioning operations.
     * @return current builder
     */
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    public AvailableNumberRentRequestParameters build() {
      return new AvailableNumberRentRequestParameters(
          smsConfiguration, voiceConfiguration, callbackUrl);
    }
  }
}
