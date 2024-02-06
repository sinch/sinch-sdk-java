package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.models.E164PhoneNumber;

/** Identity based onto a phone number */
public class NumberIdentity extends Identity {

  private final String endpoint;

  /**
   * Get related endpoint
   *
   * <p>See {@link Builder#setEndpoint(String)} setter
   *
   * @return Phone number value
   */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * @param endpoint An E.164-compatible phone number.
   */
  private NumberIdentity(String endpoint) {
    super("number");
    this.endpoint = endpoint;
  }

  @Override
  public String toString() {
    return "NumberIdentity{" + "endpoint='" + endpoint + '\'' + "} " + super.toString();
  }

  /**
   * Create a NumberIdentity from a phone number as a String
   *
   * @param phoneNumber String representation of phone number
   * @return Instance of NumberIdentity
   * @since 1.0
   */
  public static NumberIdentity valueOf(String phoneNumber) {
    return builder().setEndpoint(phoneNumber).build();
  }

  /**
   * Create a NumberIdentity from a phone number as a E164PhoneNumber
   *
   * @param phoneNumber E164PhoneNumber representation of phone number
   * @return Instance of NumberIdentity
   * @since 1.0
   */
  public static NumberIdentity valueOf(E164PhoneNumber phoneNumber) {
    return builder().setEndpoint(phoneNumber.stringValue()).build();
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   */
  public static Builder builder() {
    return new Builder();
  }

  /** Dedicated Builder */
  public static class Builder {

    String endpoint;

    private Builder() {}

    /**
     * Endpoint to be used for number identity (the phone number)
     *
     * @param endpoint Phone number value
     * @return Current builder
     */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    public NumberIdentity build() {
      return new NumberIdentity(endpoint);
    }
  }
}
