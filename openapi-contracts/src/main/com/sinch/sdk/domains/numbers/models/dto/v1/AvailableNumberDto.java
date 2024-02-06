/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The phone numbers that are available to be rented in the &lt;a
 * href&#x3D;\&quot;https://dashboard.sinch.com/numbers/buy-numbers\&quot;
 * target&#x3D;\&quot;_blank\&quot;&gt;Sinch Customer Dashboard&lt;/a&gt; or via the public numbers
 * API.
 */
@JsonPropertyOrder({
  AvailableNumberDto.JSON_PROPERTY_PHONE_NUMBER,
  AvailableNumberDto.JSON_PROPERTY_REGION_CODE,
  AvailableNumberDto.JSON_PROPERTY_TYPE,
  AvailableNumberDto.JSON_PROPERTY_CAPABILITY,
  AvailableNumberDto.JSON_PROPERTY_SETUP_PRICE,
  AvailableNumberDto.JSON_PROPERTY_MONTHLY_PRICE,
  AvailableNumberDto.JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS,
  AvailableNumberDto.JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumberDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  private String phoneNumber;
  private boolean phoneNumberDefined = false;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";
  private String regionCode;
  private boolean regionCodeDefined = false;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_CAPABILITY = "capability";
  private List<String> capability;
  private boolean capabilityDefined = false;

  public static final String JSON_PROPERTY_SETUP_PRICE = "setupPrice";
  private MoneyDto setupPrice;
  private boolean setupPriceDefined = false;

  public static final String JSON_PROPERTY_MONTHLY_PRICE = "monthlyPrice";
  private MoneyDto monthlyPrice;
  private boolean monthlyPriceDefined = false;

  public static final String JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS = "paymentIntervalMonths";
  private Integer paymentIntervalMonths;
  private boolean paymentIntervalMonthsDefined = false;

  public static final String JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED =
      "supportingDocumentationRequired";
  private Boolean supportingDocumentationRequired;
  private boolean supportingDocumentationRequiredDefined = false;

  public AvailableNumberDto() {}

  @JsonCreator
  public AvailableNumberDto(
      @JsonProperty(JSON_PROPERTY_PHONE_NUMBER) String phoneNumber,
      @JsonProperty(JSON_PROPERTY_REGION_CODE) String regionCode,
      @JsonProperty(JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS) Integer paymentIntervalMonths,
      @JsonProperty(JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED)
          Boolean supportingDocumentationRequired) {
    this();
    this.phoneNumber = phoneNumber;
    this.phoneNumberDefined = true;
    this.regionCode = regionCode;
    this.regionCodeDefined = true;
    this.paymentIntervalMonths = paymentIntervalMonths;
    this.paymentIntervalMonthsDefined = true;
    this.supportingDocumentationRequired = supportingDocumentationRequired;
    this.supportingDocumentationRequiredDefined = true;
  }

  /**
   * The phone number in &lt;a
   * href&#x3D;\&quot;https://community.sinch.com/t5/Glossary/E-164/ta-p/7537\&quot;
   * target&#x3D;\&quot;_blank\&quot;&gt;E.164&lt;/a&gt; format with leading &#x60;+&#x60;. Example
   * &#x60;+12025550134&#x60;.
   *
   * @return phoneNumber
   */
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @JsonIgnore
  public boolean getPhoneNumberDefined() {
    return phoneNumberDefined;
  }

  /**
   * ISO 3166-1 alpha-2 country code of the phone number. Example: &#x60;US&#x60;, &#x60;GB&#x60; or
   * &#x60;SE&#x60;.
   *
   * @return regionCode
   */
  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRegionCode() {
    return regionCode;
  }

  @JsonIgnore
  public boolean getRegionCodeDefined() {
    return regionCodeDefined;
  }

  public AvailableNumberDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * The number type.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public AvailableNumberDto capability(List<String> capability) {
    this.capability = capability;
    this.capabilityDefined = true;
    return this;
  }

  public AvailableNumberDto addCapabilityItem(String capabilityItem) {
    if (this.capability == null) {
      this.capability = new ArrayList<>();
    }
    this.capabilityDefined = true;
    this.capability.add(capabilityItem);
    return this;
  }

  /**
   * The capability of the number.
   *
   * @return capability
   */
  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getCapability() {
    return capability;
  }

  @JsonIgnore
  public boolean getCapabilityDefined() {
    return capabilityDefined;
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCapability(List<String> capability) {
    this.capability = capability;
    this.capabilityDefined = true;
  }

  public AvailableNumberDto setupPrice(MoneyDto setupPrice) {
    this.setupPrice = setupPrice;
    this.setupPriceDefined = true;
    return this;
  }

  /**
   * Get setupPrice
   *
   * @return setupPrice
   */
  @JsonProperty(JSON_PROPERTY_SETUP_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MoneyDto getSetupPrice() {
    return setupPrice;
  }

  @JsonIgnore
  public boolean getSetupPriceDefined() {
    return setupPriceDefined;
  }

  @JsonProperty(JSON_PROPERTY_SETUP_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSetupPrice(MoneyDto setupPrice) {
    this.setupPrice = setupPrice;
    this.setupPriceDefined = true;
  }

  public AvailableNumberDto monthlyPrice(MoneyDto monthlyPrice) {
    this.monthlyPrice = monthlyPrice;
    this.monthlyPriceDefined = true;
    return this;
  }

  /**
   * Get monthlyPrice
   *
   * @return monthlyPrice
   */
  @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MoneyDto getMonthlyPrice() {
    return monthlyPrice;
  }

  @JsonIgnore
  public boolean getMonthlyPriceDefined() {
    return monthlyPriceDefined;
  }

  @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMonthlyPrice(MoneyDto monthlyPrice) {
    this.monthlyPrice = monthlyPrice;
    this.monthlyPriceDefined = true;
  }

  /**
   * How often the recurring price is charged in months.
   *
   * @return paymentIntervalMonths
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getPaymentIntervalMonths() {
    return paymentIntervalMonths;
  }

  @JsonIgnore
  public boolean getPaymentIntervalMonthsDefined() {
    return paymentIntervalMonthsDefined;
  }

  /**
   * Whether or not supplementary documentation will be required to complete the number rental.
   *
   * @return supportingDocumentationRequired
   */
  @JsonProperty(JSON_PROPERTY_SUPPORTING_DOCUMENTATION_REQUIRED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getSupportingDocumentationRequired() {
    return supportingDocumentationRequired;
  }

  @JsonIgnore
  public boolean getSupportingDocumentationRequiredDefined() {
    return supportingDocumentationRequiredDefined;
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
    AvailableNumberDto availableNumber = (AvailableNumberDto) o;
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
    sb.append("class AvailableNumberDto {\n");
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
}
