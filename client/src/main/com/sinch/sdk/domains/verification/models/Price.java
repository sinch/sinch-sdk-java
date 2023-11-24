package com.sinch.sdk.domains.verification.models;

public class Price {
  private final String currencyId;
  private final Float amount;

  /**
   * @param currencyId ISO 4217 currency code
   * @param amount The amount
   */
  public Price(String currencyId, Float amount) {
    this.currencyId = currencyId;
    this.amount = amount;
  }

  public String getCurrencyId() {
    return currencyId;
  }

  public Float getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Price{" + "currencyId='" + currencyId + '\'' + ", amount=" + amount + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String currencyId;
    Float amount;

    private Builder() {}

    public Builder setCurrencyId(String currencyId) {
      this.currencyId = currencyId;
      return this;
    }

    public Builder setAmount(Float amount) {
      this.amount = amount;
      return this;
    }

    public Price build() {
      return new Price(currencyId, amount);
    }
  }
}
