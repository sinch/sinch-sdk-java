package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({MoneyImpl.JSON_PROPERTY_CURRENCY_CODE, MoneyImpl.JSON_PROPERTY_AMOUNT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MoneyImpl implements Money {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CURRENCY_CODE = "currencyCode";

  private OptionalValue<String> currencyCode;

  public static final String JSON_PROPERTY_AMOUNT = "amount";

  private OptionalValue<String> amount;

  public MoneyImpl() {}

  protected MoneyImpl(OptionalValue<String> currencyCode, OptionalValue<String> amount) {
    this.currencyCode = currencyCode;
    this.amount = amount;
  }

  @JsonIgnore
  public String getCurrencyCode() {
    return currencyCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CURRENCY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> currencyCode() {
    return currencyCode;
  }

  @JsonIgnore
  public String getAmount() {
    return amount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> amount() {
    return amount;
  }

  /** Return true if this Money object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneyImpl money = (MoneyImpl) o;
    return Objects.equals(this.currencyCode, money.currencyCode)
        && Objects.equals(this.amount, money.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyCode, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyImpl {\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements Money.Builder {
    OptionalValue<String> currencyCode = OptionalValue.empty();
    OptionalValue<String> amount = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CURRENCY_CODE, required = true)
    public Builder setCurrencyCode(String currencyCode) {
      this.currencyCode = OptionalValue.of(currencyCode);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_AMOUNT, required = true)
    public Builder setAmount(String amount) {
      this.amount = OptionalValue.of(amount);
      return this;
    }

    public Money build() {
      return new MoneyImpl(currencyCode, amount);
    }
  }
}
