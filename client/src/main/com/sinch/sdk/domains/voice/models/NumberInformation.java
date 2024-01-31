package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.models.E164PhoneNumber;

/** Detailed information about a number */
public class NumberInformation {
  private final String countryId;
  private final NumberType numberType;
  private final E164PhoneNumber normalizedNumber;
  private final Boolean restricted;
  private final Price rate;

  public NumberInformation(
      String countryId,
      NumberType numberType,
      E164PhoneNumber normalizedNumber,
      Boolean restricted,
      Price rate) {
    this.countryId = countryId;
    this.numberType = numberType;
    this.normalizedNumber = normalizedNumber;
    this.restricted = restricted;
    this.rate = rate;
  }

  /**
   * The ISO 3166-1 formatted country code
   *
   * @return Country Id
   */
  public String getCountryId() {
    return countryId;
  }

  /**
   * The type of the number
   *
   * @return Number type
   */
  public NumberType getNumberType() {
    return numberType;
  }

  /**
   * The number in E.164 format
   *
   * @return The number
   */
  public E164PhoneNumber getNormalizedNumber() {
    return normalizedNumber;
  }

  /**
   * Concerns whether the number is restricted or not
   *
   * @return Restricted or not
   */
  public Boolean getRestricted() {
    return restricted;
  }

  /**
   * The cost per minute to call the destination number
   *
   * @return Price
   */
  public Price getRate() {
    return rate;
  }

  @Override
  public String toString() {
    return "NumberInformation{"
        + "countryId='"
        + countryId
        + '\''
        + ", numberType='"
        + numberType
        + '\''
        + ", normalizedNumber='"
        + normalizedNumber
        + '\''
        + ", restricted="
        + restricted
        + ", rate="
        + rate
        + '}';
  }

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   */
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String countryId;
    NumberType numberType;
    E164PhoneNumber normalizedNumber;
    Boolean restricted;
    Price rate;

    public Builder setCountryId(String countryId) {
      this.countryId = countryId;
      return this;
    }

    public Builder setNumberType(NumberType numberType) {
      this.numberType = numberType;
      return this;
    }

    public Builder setNormalizedNumber(E164PhoneNumber normalizedNumber) {
      this.normalizedNumber = normalizedNumber;
      return this;
    }

    public Builder setRestricted(Boolean restricted) {
      this.restricted = restricted;
      return this;
    }

    public Builder setRate(Price rate) {
      this.rate = rate;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public NumberInformation build() {
      return new NumberInformation(countryId, numberType, normalizedNumber, restricted, rate);
    }
  }
}
