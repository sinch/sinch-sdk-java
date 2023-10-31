package com.sinch.sdk.domains.numbers.models;

import java.util.Collection;

/**
 * Active Number
 *
 * @since 1.0
 */
public class AvailableNumber {
  private final String phoneNumber;

  private final String regionCode;

  private final NumberType type;

  private final Collection<Capability> capability;

  private final Money setupPrice;

  private final Money monthlyPrice;

  private final Integer paymentIntervalMonths;

  private final Boolean supportingDocumentationRequired;

  /**
   * @param phoneNumber The phone number in E.164 format with leading +. Example +12025550134.
   * @param regionCode ISO 3166-1 alpha-2 country code of the phone number. Example: US, UK or SE.
   * @param type The number type.
   * @param capability The capability of the number.
   * @param setupPrice An object giving details on currency code and the amount charged.
   * @param monthlyPrice An object giving details on currency code and the amount charged.
   * @param paymentIntervalMonths How often the recurring price is charged in months.
   * @param supportingDocumentationRequired Whether or not supplementary documentation will be
   *     required to complete the number rental.
   */
  public AvailableNumber(
      String phoneNumber,
      String regionCode,
      NumberType type,
      Collection<Capability> capability,
      Money setupPrice,
      Money monthlyPrice,
      Integer paymentIntervalMonths,
      Boolean supportingDocumentationRequired) {
    this.phoneNumber = phoneNumber;
    this.regionCode = regionCode;
    this.type = type;
    this.capability = capability;
    this.setupPrice = setupPrice;
    this.monthlyPrice = monthlyPrice;
    this.paymentIntervalMonths = paymentIntervalMonths;
    this.supportingDocumentationRequired = supportingDocumentationRequired;
  }

  public String getPhoneNumber() {
    return phoneNumber;
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

  public Money getSetupPrice() {
    return setupPrice;
  }

  public Money getMonthlyPrice() {
    return monthlyPrice;
  }

  public Integer getPaymentIntervalMonths() {
    return paymentIntervalMonths;
  }

  public Boolean getSupportingDocumentationRequired() {
    return supportingDocumentationRequired;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AvailableNumber{"
        + "phoneNumber='"
        + phoneNumber
        + '\''
        + ", regionCode='"
        + regionCode
        + '\''
        + ", type='"
        + type
        + '\''
        + ", capability="
        + capability
        + ", setupPrice="
        + setupPrice
        + ", monthlyPrice="
        + monthlyPrice
        + ", paymentIntervalMonths="
        + paymentIntervalMonths
        + ", supportingDocumentationRequired="
        + supportingDocumentationRequired
        + '}';
  }

  public static class Builder {
    private String phoneNumber;

    private String regionCode;

    private NumberType type;

    private Collection<Capability> capability;

    private Money setupPrice;

    private Money monthlyPrice;

    private Integer paymentIntervalMonths;

    private Boolean supportingDocumentationRequired;

    private Builder() {}

    public AvailableNumber build() {
      return new AvailableNumber(
          phoneNumber,
          regionCode,
          type,
          capability,
          setupPrice,
          monthlyPrice,
          paymentIntervalMonths,
          supportingDocumentationRequired);
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
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

    public Builder setSetupPrice(Money setupPrice) {
      this.setupPrice = setupPrice;
      return this;
    }

    public Builder setMonthlyPrice(Money monthlyPrice) {
      this.monthlyPrice = monthlyPrice;
      return this;
    }

    public Builder setPaymentIntervalMonths(Integer paymentIntervalMonths) {
      this.paymentIntervalMonths = paymentIntervalMonths;
      return this;
    }

    public Builder setSupportingDocumentationRequired(Boolean supportingDocumentationRequired) {
      this.supportingDocumentationRequired = supportingDocumentationRequired;
      return this;
    }
  }
}
