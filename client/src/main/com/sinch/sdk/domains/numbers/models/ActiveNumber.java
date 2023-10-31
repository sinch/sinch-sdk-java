package com.sinch.sdk.domains.numbers.models;

import java.time.Instant;
import java.util.Collection;

/**
 * Active Number
 *
 * @since 1.0
 */
public class ActiveNumber {
  private final String phoneNumber;

  private final String projectId;

  private final String displayName;

  private final String regionCode;

  private final NumberType type;

  private final Collection<Capability> capability;

  private final Money money;

  private final Integer paymentIntervalMonths;

  private final Instant nextChargeDate;

  private final Instant expireAt;

  private final SMSConfiguration smsConfiguration;

  private final VoiceConfiguration voiceConfiguration;

  private final String callbackUrl;

  /**
   * @param phoneNumber The phone number in E.164 format with leading +. Example: +12025550134.
   * @param projectId Project ID. Your project ID can be found on your Sinch Customer Dashboard.
   * @param displayName User supplied name for the phone number.
   * @param regionCode ISO 3166-1 alpha-2 country code of the phone number. Example US, UK or SE.
   * @param type The number type.
   * @param capability The capability of the number
   * @param money An object giving details on currency code and the amount charged.
   * @param paymentIntervalMonths How often the recurring price is charged in months.
   * @param nextChargeDate The date of the next charge
   * @param expireAt The timestamp when the subscription will expire if an expiration date has been
   *     set.
   * @param smsConfiguration The current SMS configuration for this number.
   * @param voiceConfiguration The current voice configuration for this number.
   * @param callbackUrl The callback URL to be called for a rented number's provisioning /
   *     deprovisioning operations.
   */
  public ActiveNumber(
      String phoneNumber,
      String projectId,
      String displayName,
      String regionCode,
      NumberType type,
      Collection<Capability> capability,
      Money money,
      Integer paymentIntervalMonths,
      Instant nextChargeDate,
      Instant expireAt,
      SMSConfiguration smsConfiguration,
      VoiceConfiguration voiceConfiguration,
      String callbackUrl) {
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public NumberType getType() {
    return type;
  }

  public Collection<Capability> getCapability() {
    return capability;
  }

  public Money getMoney() {
    return money;
  }

  public Integer getPaymentIntervalMonths() {
    return paymentIntervalMonths;
  }

  public Instant getNextChargeDate() {
    return nextChargeDate;
  }

  public Instant getExpireAt() {
    return expireAt;
  }

  public SMSConfiguration getSmsConfiguration() {
    return smsConfiguration;
  }

  public VoiceConfiguration getVoiceConfiguration() {
    return voiceConfiguration;
  }

  public String getCallbackUrl() {
    return callbackUrl;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "ActiveNumber{"
        + "phoneNumber='"
        + phoneNumber
        + '\''
        + ", projectId='"
        + projectId
        + '\''
        + ", displayName='"
        + displayName
        + '\''
        + ", regionCode='"
        + regionCode
        + '\''
        + ", type="
        + type
        + ", capability="
        + capability
        + ", money="
        + money
        + ", paymentIntervalMonths="
        + paymentIntervalMonths
        + ", nextChargeDate="
        + nextChargeDate
        + ", expireAt="
        + expireAt
        + ", smsConfiguration="
        + smsConfiguration
        + ", voiceConfiguration="
        + voiceConfiguration
        + ", callbackUrl='"
        + callbackUrl
        + '\''
        + '}';
  }

  public static class Builder {
    private String phoneNumber;

    private String projectId;

    private String displayName;

    private String regionCode;

    private NumberType type;

    private Collection<Capability> capability;

    private Money money;

    private Integer paymentIntervalMonths;

    private Instant nextChargeDate;

    private Instant expireAt;

    private SMSConfiguration smsConfiguration;

    private VoiceConfiguration voiceConfiguration;

    private String callbackUrl;

    private Builder() {}

    public ActiveNumber build() {
      return new ActiveNumber(
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

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    public Builder setDisplayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder setRegionCode(String regionCode) {
      this.regionCode = regionCode;
      return this;
    }

    public Builder setType(NumberType type) {
      this.type = type;
      return this;
    }

    public Builder setCapability(Collection<Capability> capability) {
      this.capability = capability;
      return this;
    }

    public Builder setMoney(Money money) {
      this.money = money;
      return this;
    }

    public Builder setPaymentIntervalMonths(Integer paymentIntervalMonths) {
      this.paymentIntervalMonths = paymentIntervalMonths;
      return this;
    }

    public Builder setNextChargeDate(Instant nextChargeDate) {
      this.nextChargeDate = nextChargeDate;
      return this;
    }

    public Builder setExpireAt(Instant expireAt) {
      this.expireAt = expireAt;
      return this;
    }

    public Builder setSmsConfiguration(SMSConfiguration smsConfiguration) {
      this.smsConfiguration = smsConfiguration;
      return this;
    }

    public Builder setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
      this.voiceConfiguration = voiceConfiguration;
      return this;
    }

    public Builder setCallbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }
  }
}
