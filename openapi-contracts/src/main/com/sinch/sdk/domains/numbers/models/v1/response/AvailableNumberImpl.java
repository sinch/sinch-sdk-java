package com.sinch.sdk.domains.numbers.models.v1.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.Money;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AvailableNumberImpl.JSON_PROPERTY_PHONE_NUMBER,
  AvailableNumberImpl.JSON_PROPERTY_REGION_CODE,
  AvailableNumberImpl.JSON_PROPERTY_TYPE,
  AvailableNumberImpl.JSON_PROPERTY_CAPABILITY,
  AvailableNumberImpl.JSON_PROPERTY_SETUP_PRICE,
  AvailableNumberImpl.JSON_PROPERTY_MONTHLY_PRICE,
  AvailableNumberImpl.JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS,
  AvailableNumberImpl.JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumberImpl implements AvailableNumber {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";

  private OptionalValue<String> phoneNumber;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<NumberType> type;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";

  private OptionalValue<List<Capability>> capability;

  public static final String JSON_PROPERTY_SETUP_PRICE = "setupPrice";

  private OptionalValue<Money> setupPrice;

  public static final String JSON_PROPERTY_MONTHLY_PRICE = "monthlyPrice";

  private OptionalValue<Money> monthlyPrice;

  public static final String JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS = "paymentIntervalMonths";

  private OptionalValue<Integer> paymentIntervalMonths;

  public static final String JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED =
      "supportingDocumentationRequired";

  private OptionalValue<Boolean> supportingDocumentationRequired;

  public AvailableNumberImpl() {}

  protected AvailableNumberImpl(
      OptionalValue<String> phoneNumber,
      OptionalValue<String> regionCode,
      OptionalValue<NumberType> type,
      OptionalValue<List<Capability>> capability,
      OptionalValue<Money> setupPrice,
      OptionalValue<Money> monthlyPrice,
      OptionalValue<Integer> paymentIntervalMonths,
      OptionalValue<Boolean> supportingDocumentationRequired) {
    this.phoneNumber = phoneNumber;
    this.regionCode = regionCode;
    this.type = type;
    this.capability = capability;
    this.setupPrice = setupPrice;
    this.monthlyPrice = monthlyPrice;
    this.paymentIntervalMonths = paymentIntervalMonths;
    this.supportingDocumentationRequired = supportingDocumentationRequired;
  }

  @JsonIgnore
  public String getPhoneNumber() {
    return phoneNumber.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> phoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonIgnore
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
  public Money getSetupPrice() {
    return setupPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SETUP_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Money> setupPrice() {
    return setupPrice;
  }

  @JsonIgnore
  public Money getMonthlyPrice() {
    return monthlyPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Money> monthlyPrice() {
    return monthlyPrice;
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
  public Boolean getSupportingDocumentationRequired() {
    return supportingDocumentationRequired.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Boolean> supportingDocumentationRequired() {
    return supportingDocumentationRequired;
  }

  /** Return true if this AvailableNumber object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumberImpl availableNumber = (AvailableNumberImpl) o;
    return Objects.equals(this.phoneNumber, availableNumber.phoneNumber)
        && Objects.equals(this.regionCode, availableNumber.regionCode)
        && Objects.equals(this.type, availableNumber.type)
        && Objects.equals(this.capability, availableNumber.capability)
        && Objects.equals(this.setupPrice, availableNumber.setupPrice)
        && Objects.equals(this.monthlyPrice, availableNumber.monthlyPrice)
        && Objects.equals(this.paymentIntervalMonths, availableNumber.paymentIntervalMonths)
        && Objects.equals(
            this.supportingDocumentationRequired, availableNumber.supportingDocumentationRequired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        phoneNumber,
        regionCode,
        type,
        capability,
        setupPrice,
        monthlyPrice,
        paymentIntervalMonths,
        supportingDocumentationRequired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumberImpl {\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
    sb.append("    setupPrice: ").append(toIndentedString(setupPrice)).append("\n");
    sb.append("    monthlyPrice: ").append(toIndentedString(monthlyPrice)).append("\n");
    sb.append("    paymentIntervalMonths: ")
        .append(toIndentedString(paymentIntervalMonths))
        .append("\n");
    sb.append("    supportingDocumentationRequired: ")
        .append(toIndentedString(supportingDocumentationRequired))
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
  static class Builder implements AvailableNumber.Builder {
    OptionalValue<String> phoneNumber = OptionalValue.empty();
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> type = OptionalValue.empty();
    OptionalValue<List<Capability>> capability = OptionalValue.empty();
    OptionalValue<Money> setupPrice = OptionalValue.empty();
    OptionalValue<Money> monthlyPrice = OptionalValue.empty();
    OptionalValue<Integer> paymentIntervalMonths = OptionalValue.empty();
    OptionalValue<Boolean> supportingDocumentationRequired = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = OptionalValue.of(phoneNumber);
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

    @JsonProperty(JSON_PROPERTY_SETUP_PRICE)
    public Builder setSetupPrice(Money setupPrice) {
      this.setupPrice = OptionalValue.of(setupPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE)
    public Builder setMonthlyPrice(Money monthlyPrice) {
      this.monthlyPrice = OptionalValue.of(monthlyPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS)
    public Builder setPaymentIntervalMonths(Integer paymentIntervalMonths) {
      this.paymentIntervalMonths = OptionalValue.of(paymentIntervalMonths);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED)
    public Builder setSupportingDocumentationRequired(Boolean supportingDocumentationRequired) {
      this.supportingDocumentationRequired = OptionalValue.of(supportingDocumentationRequired);
      return this;
    }

    public AvailableNumber build() {
      return new AvailableNumberImpl(
          phoneNumber,
          regionCode,
          type,
          capability,
          setupPrice,
          monthlyPrice,
          paymentIntervalMonths,
          supportingDocumentationRequired);
    }
  }
}
