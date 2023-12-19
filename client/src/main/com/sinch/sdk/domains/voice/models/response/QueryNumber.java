package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.domains.voice.models.NumberInformation;

/** Information related to a number */
public class QueryNumber {

  private final NumberInformation numberInformation;

  public QueryNumber(NumberInformation numberInformation) {
    this.numberInformation = numberInformation;
  }

  /**
   * Get information details about number
   *
   * @return Information details
   */
  public NumberInformation getNumberInformation() {
    return numberInformation;
  }

  @Override
  public String toString() {
    return "QueryNumber{" + "numberInformation=" + numberInformation + '}';
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

    NumberInformation numberInformation;

    public Builder setNumberInformation(NumberInformation numberInformation) {
      this.numberInformation = numberInformation;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public QueryNumber build() {
      return new QueryNumber(numberInformation);
    }
  }
}
