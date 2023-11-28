package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.ActiveNumber.Builder;
import java.util.Optional;

/**
 * Parameters request to rent a number
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_RentNumber">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_RentNumber</a>
 * @since 1.0
 */
public class AvailableNumberRentRequestParameters {
  private final RentSMSConfigurationRequestParameters smsConfiguration;
  private final RentVoiceConfigurationRequestParameters voiceConfiguration;
  private final String callbackUrl;

  /**
   * @param smsConfiguration The current SMS configuration for this number
   * @param voiceConfiguration The current voice configuration for this number. During scheduled
   *     provisioning, the app ID value may be empty in a response if it is still processing or if
   *     it has failed. The status of scheduled provisioning will show under a
   *     scheduledVoiceProvisioning object if it's still running. Once processed successfully, the
   *     appId sent will appear directly under the voiceConfiguration object.
   * @param callbackUrl The callback URL to be called for a rented number's provisioning /
   *     deprovisioning operations.
   */
  public AvailableNumberRentRequestParameters(
      RentSMSConfigurationRequestParameters smsConfiguration,
      RentVoiceConfigurationRequestParameters voiceConfiguration,
      String callbackUrl) {
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  public Optional<RentSMSConfigurationRequestParameters> getSmsConfiguration() {
    return Optional.ofNullable(smsConfiguration);
  }

  public Optional<RentVoiceConfigurationRequestParameters> getVoiceConfiguration() {
    return Optional.ofNullable(voiceConfiguration);
  }

  public Optional<String> getCallBackUrl() {
    return Optional.ofNullable(callbackUrl);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    RentSMSConfigurationRequestParameters smsConfiguration;
    RentVoiceConfigurationRequestParameters voiceConfiguration;
    String callbackUrl;

    private Builder() {}

    public Builder setSmsConfiguration(RentSMSConfigurationRequestParameters smsConfiguration) {
      this.smsConfiguration = smsConfiguration;
      return this;
    }

    public Builder setVoiceConfiguration(
        RentVoiceConfigurationRequestParameters voiceConfiguration) {
      this.voiceConfiguration = voiceConfiguration;
      return this;
    }

    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    public AvailableNumberRentRequestParameters build() {
      return new AvailableNumberRentRequestParameters(
          smsConfiguration, voiceConfiguration, callbackUrl);
    }
  }
}
