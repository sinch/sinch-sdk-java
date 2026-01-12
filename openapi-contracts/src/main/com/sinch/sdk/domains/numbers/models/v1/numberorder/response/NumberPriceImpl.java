package com.sinch.sdk.domains.numbers.models.v1.numberorder.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.Money;
import java.util.Objects;

@JsonPropertyOrder({
  NumberPriceImpl.JSON_PROPERTY_SETUP_PRICE,
  NumberPriceImpl.JSON_PROPERTY_MONTHLY_PRICE,
  NumberPriceImpl.JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberPriceImpl implements NumberPrice {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SETUP_PRICE = "setupPrice";

  private OptionalValue<Money> setupPrice;

  public static final String JSON_PROPERTY_MONTHLY_PRICE = "monthlyPrice";

  private OptionalValue<Money> monthlyPrice;

  public static final String JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS = "paymentIntervalMonths";

  private OptionalValue<Integer> paymentIntervalMonths;

  public NumberPriceImpl() {}

  protected NumberPriceImpl(
      OptionalValue<Money> setupPrice,
      OptionalValue<Money> monthlyPrice,
      OptionalValue<Integer> paymentIntervalMonths) {
    this.setupPrice = setupPrice;
    this.monthlyPrice = monthlyPrice;
    this.paymentIntervalMonths = paymentIntervalMonths;
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

  @JsonProperty(JSON_PROPERTY_PAYMENT_INTERVAL_MONTHS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> paymentIntervalMonths() {
    return paymentIntervalMonths;
  }

  /** Return true if this NumberPrice object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberPriceImpl numberPrice = (NumberPriceImpl) o;
    return Objects.equals(this.setupPrice, numberPrice.setupPrice)
        && Objects.equals(this.monthlyPrice, numberPrice.monthlyPrice)
        && Objects.equals(this.paymentIntervalMonths, numberPrice.paymentIntervalMonths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(setupPrice, monthlyPrice, paymentIntervalMonths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberPriceImpl {\n");
    sb.append("    setupPrice: ").append(toIndentedString(setupPrice)).append("\n");
    sb.append("    monthlyPrice: ").append(toIndentedString(monthlyPrice)).append("\n");
    sb.append("    paymentIntervalMonths: ")
        .append(toIndentedString(paymentIntervalMonths))
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
  static class Builder implements NumberPrice.Builder {
    OptionalValue<Money> setupPrice = OptionalValue.empty();
    OptionalValue<Money> monthlyPrice = OptionalValue.empty();
    OptionalValue<Integer> paymentIntervalMonths = OptionalValue.empty();

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

    public NumberPrice build() {
      return new NumberPriceImpl(setupPrice, monthlyPrice, paymentIntervalMonths);
    }
  }
}
