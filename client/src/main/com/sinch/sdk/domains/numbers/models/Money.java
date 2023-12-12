package com.sinch.sdk.domains.numbers.models;

/**
 * An object giving details on currency code and the amount charged.
 *
 * @since 1.0
 */
public class Money {
  private final String currencyCode;

  private final Double amount;

  /**
   * @param currencyCode The 3-letter currency code defined in ISO 4217.
   * @param amount The amount. There are no guarantees on the precision unless documented by the
   *     message origin. The amount cannot be updated and is read-only.
   */
  public Money(String currencyCode, Double amount) {
    this.currencyCode = currencyCode;
    this.amount = amount;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public Double getAmount() {
    return amount;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Money{" + "currencyCode='" + currencyCode + '\'' + ", amount='" + amount + '\'' + '}';
  }

  public static class Builder {
    private String currencyCode;

    private Double amount;

    private Builder() {}

    Builder setCurrencyCode(String value) {
      this.currencyCode = value;
      return this;
    }

    Builder setAmount(Double value) {
      this.amount = value;
      return this;
    }

    Money build() {
      return new Money(this.currencyCode, this.amount);
    }
  }
}
