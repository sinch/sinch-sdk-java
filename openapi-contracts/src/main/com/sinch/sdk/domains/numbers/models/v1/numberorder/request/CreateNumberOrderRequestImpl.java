package com.sinch.sdk.domains.numbers.models.v1.numberorder.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.OrderSmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.OrderVoiceConfiguration;
import java.net.URI;
import java.util.Objects;

@JsonPropertyOrder({
  CreateNumberOrderRequestImpl.JSON_PROPERTY_REGION_CODE,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_NUMBER_TYPE,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_CALLBACK_URL,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_NUMBER_ORDER_OPTION,
  CreateNumberOrderRequestImpl.JSON_PROPERTY_QUANTITY_ORDER_OPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CreateNumberOrderRequestImpl implements CreateNumberOrderRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";

  private OptionalValue<NumberType> numberType;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<OrderSmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<OrderVoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";

  private OptionalValue<URI> callbackUrl;

  public static final String JSON_PROPERTY_NUMBER_ORDER_OPTION = "numberOrderOption";

  private OptionalValue<CreateNumberOrderOption> numberOrderOption;

  public static final String JSON_PROPERTY_QUANTITY_ORDER_OPTION = "quantityOrderOption";

  private OptionalValue<CreateQuantityOrderOption> quantityOrderOption;

  public CreateNumberOrderRequestImpl() {}

  protected CreateNumberOrderRequestImpl(
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> numberType,
      OptionalValue<OrderSmsConfiguration> smsConfiguration,
      OptionalValue<OrderVoiceConfiguration> voiceConfiguration,
      OptionalValue<URI> callbackUrl,
      OptionalValue<CreateNumberOrderOption> numberOrderOption,
      OptionalValue<CreateQuantityOrderOption> quantityOrderOption) {
    this.regionCode = regionCode;
    this.numberType = numberType;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
    this.numberOrderOption = numberOrderOption;
    this.quantityOrderOption = quantityOrderOption;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  @JsonIgnore
  public NumberType getNumberType() {
    return numberType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberType> numberType() {
    return numberType;
  }

  @JsonIgnore
  public OrderSmsConfiguration getSmsConfiguration() {
    return smsConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrderSmsConfiguration> smsConfiguration() {
    return smsConfiguration;
  }

  @JsonIgnore
  public OrderVoiceConfiguration getVoiceConfiguration() {
    return voiceConfiguration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrderVoiceConfiguration> voiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonIgnore
  public URI getCallbackUrl() {
    return callbackUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<URI> callbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public CreateNumberOrderOption getNumberOrderOption() {
    return numberOrderOption.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_ORDER_OPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CreateNumberOrderOption> numberOrderOption() {
    return numberOrderOption;
  }

  @JsonIgnore
  public CreateQuantityOrderOption getQuantityOrderOption() {
    return quantityOrderOption.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUANTITY_ORDER_OPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CreateQuantityOrderOption> quantityOrderOption() {
    return quantityOrderOption;
  }

  /** Return true if this CreateNumberOrderRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNumberOrderRequestImpl createNumberOrderRequest = (CreateNumberOrderRequestImpl) o;
    return Objects.equals(this.regionCode, createNumberOrderRequest.regionCode)
        && Objects.equals(this.numberType, createNumberOrderRequest.numberType)
        && Objects.equals(this.smsConfiguration, createNumberOrderRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, createNumberOrderRequest.voiceConfiguration)
        && Objects.equals(this.callbackUrl, createNumberOrderRequest.callbackUrl)
        && Objects.equals(this.numberOrderOption, createNumberOrderRequest.numberOrderOption)
        && Objects.equals(this.quantityOrderOption, createNumberOrderRequest.quantityOrderOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        regionCode,
        numberType,
        smsConfiguration,
        voiceConfiguration,
        callbackUrl,
        numberOrderOption,
        quantityOrderOption);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNumberOrderRequestImpl {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    numberType: ").append(toIndentedString(numberType)).append("\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    numberOrderOption: ").append(toIndentedString(numberOrderOption)).append("\n");
    sb.append("    quantityOrderOption: ")
        .append(toIndentedString(quantityOrderOption))
        .append("\n");
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
  static class Builder implements CreateNumberOrderRequest.Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> numberType = OptionalValue.empty();
    OptionalValue<OrderSmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<OrderVoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<URI> callbackUrl = OptionalValue.empty();
    OptionalValue<CreateNumberOrderOption> numberOrderOption = OptionalValue.empty();
    OptionalValue<CreateQuantityOrderOption> quantityOrderOption = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REGION_CODE)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
    public Builder setNumberType(NumberType numberType) {
      this.numberType = OptionalValue.of(numberType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
    public Builder setSmsConfiguration(OrderSmsConfiguration smsConfiguration) {
      this.smsConfiguration = OptionalValue.of(smsConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
    public Builder setVoiceConfiguration(OrderVoiceConfiguration voiceConfiguration) {
      this.voiceConfiguration = OptionalValue.of(voiceConfiguration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
    public Builder setCallbackUrl(URI callbackUrl) {
      this.callbackUrl = OptionalValue.of(callbackUrl);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NUMBER_ORDER_OPTION, required = true)
    public Builder setNumberOrderOption(CreateNumberOrderOption numberOrderOption) {
      this.numberOrderOption = OptionalValue.of(numberOrderOption);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_QUANTITY_ORDER_OPTION, required = true)
    public Builder setQuantityOrderOption(CreateQuantityOrderOption quantityOrderOption) {
      this.quantityOrderOption = OptionalValue.of(quantityOrderOption);
      return this;
    }

    public CreateNumberOrderRequest build() {
      return new CreateNumberOrderRequestImpl(
          regionCode,
          numberType,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl,
          numberOrderOption,
          quantityOrderOption);
    }
  }
}
