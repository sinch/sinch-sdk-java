package com.sinch.sdk.domains.voice.models;

import com.sinch.sdk.models.E164PhoneNumber;

public class ApplicationAssignedNumber {

  private final E164PhoneNumber number;
  private final String applicationKey;
  private final CapabilityType capability;

  private ApplicationAssignedNumber(
      E164PhoneNumber number, String applicationKey, CapabilityType capability) {
    this.number = number;
    this.applicationKey = applicationKey;
    this.capability = capability;
  }

  /**
   * The phone number
   *
   * @return The phone number
   */
  public E164PhoneNumber getNumber() {
    return number;
  }

  /**
   * Indicates the application where the number was assigned.
   *
   * @return Application key value
   */
  public String getApplicationKey() {
    return applicationKey;
  }

  /**
   * Indicates the DID (Direct Inward CapabilityType) capabilityType that was assigned to the chosen
   * application.
   *
   * <p>Please note that the DID needs to support the selected capabilityType.
   *
   * @return The capabilityType
   */
  public CapabilityType getCapability() {
    return capability;
  }

  @Override
  public String toString() {
    return "ApplicationAssignedNumber{"
        + "number="
        + number
        + ", applicationKey='"
        + applicationKey
        + '\''
        + ", capabilityType="
        + capability
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

    E164PhoneNumber number;
    String applicationKey;
    CapabilityType capabilityType;

    /**
     * @param number the number value
     * @return Current builder
     * @see ApplicationAssignedNumber#getNumber() () getter
     */
    public Builder setNumber(E164PhoneNumber number) {
      this.number = number;
      return this;
    }

    /**
     * @param applicationKey the application key
     * @return Current builder
     * @see ApplicationAssignedNumber#getApplicationKey() getter
     */
    public Builder setApplicationKey(String applicationKey) {
      this.applicationKey = applicationKey;
      return this;
    }

    /**
     * @param capabilityType the capabilityType value
     * @return Current builder
     * @see ApplicationAssignedNumber#getCapability() getter
     */
    public Builder setCapability(CapabilityType capabilityType) {
      this.capabilityType = capabilityType;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public ApplicationAssignedNumber build() {
      return new ApplicationAssignedNumber(number, applicationKey, capabilityType);
    }
  }
}
