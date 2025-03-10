package com.sinch.sdk.domains.numbers.models.v1.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_NUMBER_PATTERN,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_REGION_CODE,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_TYPE,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_CAPABILITIES,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  AvailableNumberRentAnyRequestImpl.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumberRentAnyRequestImpl implements AvailableNumberRentAnyRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER_PATTERN = "numberPattern";

  private OptionalValue<SearchPattern> numberPattern;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<NumberType> type;

  public static final String JSON_PROPERTY_CAPABILITIES = "capabilities";

  private OptionalValue<List<Capability>> capabilities;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<SmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<VoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";

  private OptionalValue<String> callbackUrl;

  public AvailableNumberRentAnyRequestImpl() {}

  protected AvailableNumberRentAnyRequestImpl(
      OptionalValue<SearchPattern> numberPattern,
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<List<Capability>> capabilities,
      OptionalValue<SmsConfiguration> smsConfiguration,
      OptionalValue<VoiceConfiguration> voiceConfiguration,
      OptionalValue<String> callbackUrl) {
    this.numberPattern = numberPattern;
    this.regionCode = regionCode;
    this.type = type;
    this.capabilities = capabilities;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  @JsonIgnore
  public SearchPattern getNumberPattern() {
    return numberPattern.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SearchPattern> numberPattern() {
    return numberPattern;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  @JsonIgnore
  public NumberType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NumberType> type() {
    return type;
  }

  @JsonIgnore
  public List<Capability> getCapabilities() {
    return capabilities.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Capability>> capabilities() {
    return capabilities;
  }

  @JsonIgnore
  public SmsConfiguration getSmsConfiguration() {
    return smsConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SmsConfiguration> smsConfiguration() {
    return smsConfiguration;
  }

  @JsonIgnore
  public VoiceConfiguration getVoiceConfiguration() {
    return voiceConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VoiceConfiguration> voiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonIgnore
  public String getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callbackUrl() {
    return callbackUrl;
  }

  /** Return true if this RentAnyNumberRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumberRentAnyRequestImpl rentAnyNumberRequest = (AvailableNumberRentAnyRequestImpl) o;
    return Objects.equals(this.numberPattern, rentAnyNumberRequest.numberPattern)
        && Objects.equals(this.regionCode, rentAnyNumberRequest.regionCode)
        && Objects.equals(this.type, rentAnyNumberRequest.type)
        && Objects.equals(this.capabilities, rentAnyNumberRequest.capabilities)
        && Objects.equals(this.smsConfiguration, rentAnyNumberRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, rentAnyNumberRequest.voiceConfiguration)
        && Objects.equals(this.callbackUrl, rentAnyNumberRequest.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        numberPattern,
        regionCode,
        type,
        capabilities,
        smsConfiguration,
        voiceConfiguration,
        callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumberRentAnyRequestImpl {\n");
    sb.append("    numberPattern: ").append(toIndentedString(numberPattern)).append("\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements AvailableNumberRentAnyRequest.Builder {
    OptionalValue<SearchPattern> numberPattern = OptionalValue.empty();
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<List<Capability>> capabilities = OptionalValue.empty();
    OptionalValue<SmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<VoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
    public Builder setNumberPattern(SearchPattern numberPattern) {
      this.numberPattern = OptionalValue.of(numberPattern);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_REGION_CODE, required = true)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAPABILITIES)
    public Builder setCapabilities(List<Capability> capabilities) {
      this.capabilities = OptionalValue.of(capabilities);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
    public Builder setSmsConfiguration(SmsConfiguration smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
    public Builder setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    public AvailableNumberRentAnyRequest build() {
      return new AvailableNumberRentAnyRequestImpl(
          numberPattern,
          regionCode,
          type,
          capabilities,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl);
    }
  }
}
