package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ActiveNumberImpl.JSON_PROPERTY_PHONE_NUMBER,
  ActiveNumberImpl.JSON_PROPERTY_PROJECT_ID,
  ActiveNumberImpl.JSON_PROPERTY_DISPLAY_NAME,
  ActiveNumberImpl.JSON_PROPERTY_REGION_CODE,
  ActiveNumberImpl.JSON_PROPERTY_TYPE,
  ActiveNumberImpl.JSON_PROPERTY_CAPABILITY,
  ActiveNumberImpl.JSON_PROPERTY_MONEY,
  ActiveNumberImpl.JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS,
  ActiveNumberImpl.JSON_PROPERTY_NEXT_CHARGE_DATE,
  ActiveNumberImpl.JSON_PROPERTY_EXPIRE_AT,
  ActiveNumberImpl.JSON_PROPERTY_SMS_CONFIGURATION,
  ActiveNumberImpl.JSON_PROPERTY_VOICE_CONFIGURATION,
  ActiveNumberImpl.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ActiveNumberImpl implements ActiveNumber {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

  private OptionalValue<String> displayName;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<NumberType> type;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";

  private OptionalValue<List<Capability>> capability;

  public static final String JSON_PROPERTY_MONEY = "money";

  private OptionalValue<Money> money;

  public static final String JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS = "paymentIntervalMonths";

  private OptionalValue<Integer> paymentIntervalMonths;

  public static final String JSON_PROPERTY_NEXT_CHARGE_DATE = "nextChargeDate";

  private OptionalValue<Instant> nextChargeDate;

  public static final String JSON_PROPERTY_EXPIRE_AT = "expireAt";

  private OptionalValue<Instant> expireAt;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";

  private OptionalValue<SmsConfiguration> smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";

  private OptionalValue<VoiceConfiguration> voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";

  private OptionalValue<String> callbackUrl;

  public ActiveNumberImpl() {}

  protected ActiveNumberImpl(
      OptionalValue<String> phoneNumber,
      OptionalValue<String> projectId,
      OptionalValue<String> displayName,
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<List<Capability>> capability,
      OptionalValue<Money> money,
      OptionalValue<Integer> paymentIntervalMonths,
      OptionalValue<Instant> nextChargeDate,
      OptionalValue<Instant> expireAt,
      OptionalValue<SmsConfiguration> smsConfiguration,
      OptionalValue<VoiceConfiguration> voiceConfiguration,
      OptionalValue<String> callbackUrl) {
    this.phoneNumber = phoneNumber;
    this.projectId = projectId;
    this.displayName = displayName;
    this.regionCode = regionCode;
    this.type = type;
    this.capability = capability;
    this.money = money;
    this.paymentIntervalMonths = paymentIntervalMonths;
    this.nextChargeDate = nextChargeDate;
    this.expireAt = expireAt;
    this.smsConfiguration = smsConfiguration;
    this.voiceConfiguration = voiceConfiguration;
    this.callbackUrl = callbackUrl;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getDisplayName() {
    return displayName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> displayName() {
    return displayName;
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
  public NumberType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberType> type() {
    return type;
  }

  @JsonIgnore
  public List<Capability> getCapability() {
    return capability.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Capability>> capability() {
    return capability;
  }

  @JsonIgnore
  public Money getMoney() {
    return money.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MONEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Money> money() {
    return money;
  }

  @JsonIgnore
  public Integer getPaymentIntervalMonths() {
    return paymentIntervalMonths.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Integer> paymentIntervalMonths() {
    return paymentIntervalMonths;
  }

  @JsonIgnore
  public Instant getNextChargeDate() {
    return nextChargeDate.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> nextChargeDate() {
    return nextChargeDate;
  }

  @JsonIgnore
  public Instant getExpireAt() {
    return expireAt.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> expireAt() {
    return expireAt;
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

  /** Return true if this ActiveNumberResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveNumberImpl activeNumberResponse = (ActiveNumberImpl) o;
    return Objects.equals(this.phoneNumber, activeNumberResponse.phoneNumber)
        && Objects.equals(this.projectId, activeNumberResponse.projectId)
        && Objects.equals(this.displayName, activeNumberResponse.displayName)
        && Objects.equals(this.regionCode, activeNumberResponse.regionCode)
        && Objects.equals(this.type, activeNumberResponse.type)
        && Objects.equals(this.capability, activeNumberResponse.capability)
        && Objects.equals(this.money, activeNumberResponse.money)
        && Objects.equals(this.paymentIntervalMonths, activeNumberResponse.paymentIntervalMonths)
        && Objects.equals(this.nextChargeDate, activeNumberResponse.nextChargeDate)
        && Objects.equals(this.expireAt, activeNumberResponse.expireAt)
        && Objects.equals(this.smsConfiguration, activeNumberResponse.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, activeNumberResponse.voiceConfiguration)
        && Objects.equals(this.callbackUrl, activeNumberResponse.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        phoneNumber,
        projectId,
        displayName,
        regionCode,
        type,
        capability,
        money,
        paymentIntervalMonths,
        nextChargeDate,
        expireAt,
        smsConfiguration,
        voiceConfiguration,
        callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveNumberImpl {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
    sb.append("    money: ").append(toIndentedString(money)).append("\n");
    sb.append("    paymentIntervalMonths: ")
        .append(toIndentedString(paymentIntervalMonths))
        .append("\n");
    sb.append("    nextChargeDate: ").append(toIndentedString(nextChargeDate)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
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
  static class Builder implements ActiveNumber.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> displayName = OptionalValue.empty();
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<List<Capability>> capability = OptionalValue.empty();
    OptionalValue<Money> money = OptionalValue.empty();
    OptionalValue<Integer> paymentIntervalMonths = OptionalValue.empty();
    OptionalValue<Instant> nextChargeDate = OptionalValue.empty();
    OptionalValue<Instant> expireAt = OptionalValue.empty();
    OptionalValue<SmsConfiguration> smsConfiguration = OptionalValue.empty();
    OptionalValue<VoiceConfiguration> voiceConfiguration = OptionalValue.empty();
    OptionalValue<String> callbackUrl = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public Builder setDisplayName(String displayName) {
      this.displayName = OptionalValue.of(displayName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REGION_CODE)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    public Builder setType(NumberType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAPABILITY)
    public Builder setCapability(List<Capability> capability) {
      this.capability = OptionalValue.of(capability);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MONEY)
    public Builder setMoney(Money money) {
      this.money = OptionalValue.of(money);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS)
    public Builder setPaymentIntervalMonths(Integer paymentIntervalMonths) {
      this.paymentIntervalMonths = OptionalValue.of(paymentIntervalMonths);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_CHARGE_DATE)
    public Builder setNextChargeDate(Instant nextChargeDate) {
      this.nextChargeDate = OptionalValue.of(nextChargeDate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRE_AT)
    public Builder setExpireAt(Instant expireAt) {
      this.expireAt = OptionalValue.of(expireAt);
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

    public ActiveNumber build() {
      return new ActiveNumberImpl(
          phoneNumber,
          projectId,
          displayName,
          regionCode,
          type,
          capability,
          money,
          paymentIntervalMonths,
          nextChargeDate,
          expireAt,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl);
    }
  }
}
