package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;

/**
 * Parameters request to rent a number using criteria
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.0
 */
public class AvailableNumberRentAnyRequestParameters {
  private final OptionalValue<String> regionCode;
  private final OptionalValue<NumberType> type;
  private final OptionalValue<NumberPattern> numberPattern;
  private final OptionalValue<Collection<Capability>> capabilities;
  private final OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration;
  private final OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration;
  private final OptionalValue<String> callbackUrl;

  private AvailableNumberRentAnyRequestParameters(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<NumberPattern> numberPattern,
      OptionalValue<Collection<Capability>> capabilities,
      OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration,
      OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration,
      OptionalValue<String> callbackUrl) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  public OptionalValue<String> getRegionCode() {
    return regionCode;
  }

  public OptionalValue<NumberType> getType() {
    return type;
  }

  public OptionalValue<NumberPattern> getNumberPattern() {
    return numberPattern;
  }

  public OptionalValue<Collection<Capability>> getCapabilities() {
    return capabilities;
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
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<NumberPattern> numberPattern = OptionalValue.empty();
    OptionalValue<Collection<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<RentSMSConfigurationRequestParameters> smsConfiguration = OptionalValue.empty();
    OptionalValue<RentVoiceConfigurationRequestParameters> voiceConfiguration =
        OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();

    private Builder() {}

    /**
     * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
     *     number. Example: US, GB or SE.
     * @return current builder
     */
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    /**
     * @param type Number type to filter by
     * @return current builder
     */
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    /**
     * @param numberPattern Search pattern
     * @return current builder
     */
    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = OptionalValue.of(numberPattern);
      return this;
    }

    /**
     * @param capabilities Capabilities to filter by
     * @return current builder
     */
    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    /**
     * @param smsConfiguration The current SMS configuration for this number
     * @return current builder
     */
    public Builder setSmsConfiguration(RentSMSConfigurationRequestParameters smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    /**
     * @param voiceConfiguration The current voice configuration for this number
     * @return current builder
     */
    public Builder setVoiceConfiguration(
        RentVoiceConfigurationRequestParameters voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    /**
     * @param callbackUrl The callback URL to be called for a rented number's provisioning /
     *     de-provisioning operations ({@link com.sinch.sdk.domains.numbers.WebHooksService see
     *     WebHooksService})
     * @return current builder
     */
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    public AvailableNumberRentAnyRequestParameters build() {
      return new AvailableNumberRentAnyRequestParameters(
          regionCode,
          type,
          numberPattern,
          capabilities,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl);
    }
  }
}
