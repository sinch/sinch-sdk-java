package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A monetary amount with an associated currency code. */
@JsonDeserialize(builder = MoneyImpl.Builder.class)
public interface Money {

  /**
   * The 3-letter currency code defined in <a
   * href="https://www.iso.org/iso-4217-currency-codes.html">ISO 4217</a>.
   *
   * <p>Field is required
   *
   * @return currencyCode
   */
  String getCurrencyCode();

  /**
   * The monetary amount as a string to preserve precision. Supports up to 4 decimal places (e.g.,
   * &quot;10.5000&quot;, &quot;0.9999&quot;).
   *
   * <p>Field is required
   *
   * @return amount
   */
  String getAmount();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MoneyImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param currencyCode see getter
     * @return Current builder
     * @see #getCurrencyCode
     */
    Builder setCurrencyCode(String currencyCode);

    /**
     * see getter
     *
     * @param amount see getter
     * @return Current builder
     * @see #getAmount
     */
    Builder setAmount(String amount);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Money build();
  }
}
