package com.sinch.sdk.domains.verification.models;

/** Price object representation */
public class Price {
  private final String currencyId;
  private final Float amount;

  private Price(String currencyId, Float amount) {
    this.currencyId = currencyId;
    this.amount = amount;
  }

  /**
   * ISO 4217 currency code
   *
   * @return Currency value
   * @since 1.0
   */
  public String getCurrencyId() {
    return currencyId;
  }

  /**
   * Amount value
   *
   * @return The amount
   * @since 1.0
   */
  public Float getAmount() {
    return amount;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "Price{" + "currencyId='" + currencyId + '\'' + ", amount=" + amount + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String currencyId;
    Float amount;

    private Builder() {}

    /**
     * Setter
     *
     * @param currencyId See {@link Price#getCurrencyId()} getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setCurrencyId(String currencyId) {
      this.currencyId = currencyId;
      return this;
    }

    /**
     * Setter
     *
     * @param amount See {@link Price#getAmount()} getter
     * @return Current builder
     * @since 1.0
     */
    public Builder setAmount(Float amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public Price build() {
      return new Price(currencyId, amount);
    }
  }
}
