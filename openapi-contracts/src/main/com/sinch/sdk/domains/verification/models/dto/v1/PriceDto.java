/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** PriceDto */
@JsonPropertyOrder({PriceDto.JSON_PROPERTY_CURRENCY_ID, PriceDto.JSON_PROPERTY_AMOUNT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PriceDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CURRENCY_ID = "currencyId";
  private String currencyId;
  private boolean currencyIdDefined = false;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Float amount;
  private boolean amountDefined = false;

  public PriceDto() {}

  public PriceDto currencyId(String currencyId) {
    this.currencyId = currencyId;
    this.currencyIdDefined = true;
    return this;
  }

  /**
   * ISO 4217 currency code
   *
   * @return currencyId
   */
  @JsonProperty(JSON_PROPERTY_CURRENCY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCurrencyId() {
    return currencyId;
  }

  @JsonIgnore
  public boolean getCurrencyIdDefined() {
    return currencyIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CURRENCY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrencyId(String currencyId) {
    this.currencyId = currencyId;
    this.currencyIdDefined = true;
  }

  public PriceDto amount(Float amount) {
    this.amount = amount;
    this.amountDefined = true;
    return this;
  }

  /**
   * Get amount
   *
   * @return amount
   */
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Float getAmount() {
    return amount;
  }

  @JsonIgnore
  public boolean getAmountDefined() {
    return amountDefined;
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(Float amount) {
    this.amount = amount;
    this.amountDefined = true;
  }

  /** Return true if this Price object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceDto price = (PriceDto) o;
    return Objects.equals(this.currencyId, price.currencyId)
        && Objects.equals(this.amount, price.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceDto {\n");
    sb.append("    currencyId: ").append(toIndentedString(currencyId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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