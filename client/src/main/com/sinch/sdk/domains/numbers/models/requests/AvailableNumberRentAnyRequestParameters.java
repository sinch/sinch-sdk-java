package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to rent a number using criteria
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.0
 */
public class AvailableNumberRentAnyRequestParameters {
  private final String regionCode;
  private final NumberType type;
  private final NumberPattern numberPattern;
  private final Collection<Capability> capabilities;
  private final RentSMSConfigurationRequestParameters smsConfiguration;
  private final RentVoiceConfigurationRequestParameters voiceConfiguration;
  private final String callbackUrl;

  public AvailableNumberRentAnyRequestParameters(
      String regionCode,
      NumberType type,
      NumberPattern numberPattern,
      Collection<Capability> capabilities,
      RentSMSConfigurationRequestParameters smsConfiguration,
      RentVoiceConfigurationRequestParameters voiceConfiguration,
      String callbackUrl) {
    this.regionCode = regionCode;
    this.type = type;
    this.numberPattern = numberPattern;
    this.capabilities = capabilities;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public NumberType getType() {
    return type;
  }

  public Optional<NumberPattern> getNumberPattern() {
    return Optional.ofNullable(numberPattern);
  }

  public Optional<Collection<Capability>> getCapabilities() {
    return Optional.ofNullable(capabilities);
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
    String regionCode;
    NumberType type;
    NumberPattern numberPattern;
    Collection<Capability> capabilities;
    RentSMSConfigurationRequestParameters smsConfiguration;
    RentVoiceConfigurationRequestParameters voiceConfiguration;
    String callbackUrl;

    private Builder() {}

    public Builder setRegionCode(String regionCode) {
      this.regionCode = regionCode;
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = type;
      return this;
    }

    public Builder setNumberPattern(NumberPattern numberPattern) {
      this.numberPattern = numberPattern;
      return this;
    }

    public Builder setCapabilities(Collection<Capability> capabilities) {
      this.capabilities = capabilities;
      return this;
    }

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
