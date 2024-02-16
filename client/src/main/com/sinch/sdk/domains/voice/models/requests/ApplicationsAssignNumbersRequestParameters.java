package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Collection;

/**
 * Request parameters when updating a numbers list
 *
 * @since 1.0
 */
public class ApplicationsAssignNumbersRequestParameters {

  private final OptionalValue<Collection<E164PhoneNumber>> numbers;
  private final OptionalValue<String> applicationKey;
  private final OptionalValue<CapabilityType> capability;

  private ApplicationsAssignNumbersRequestParameters(
      OptionalValue<Collection<E164PhoneNumber>> numbers,
      OptionalValue<String> applicationKey,
      OptionalValue<CapabilityType> capability) {
    this.numbers = numbers;
    this.applicationKey = applicationKey;
    this.capability = capability;
  }

  /**
   * Number list to be edited
   *
   * @return The numbers list
   * @see Builder#getNumbers() getter
   * @since 1.0
   */
  public OptionalValue<Collection<E164PhoneNumber>> getNumbers() {
    return numbers;
  }

  /**
   * Application key to be assigned to numbers
   *
   * @return The application key
   * @see Builder#getApplicationKey() getter
   * @since 1.0
   */
  public OptionalValue<String> getApplicationKey() {
    return applicationKey;
  }

  /**
   * Capability to be set
   *
   * @return The capability
   * @see Builder#getCapability() () getter
   * @since 1.0
   */
  public OptionalValue<CapabilityType> getCapability() {
    return capability;
  }

  @Override
  public String toString() {
    return "ApplicationsAssignNumbersRequestParameters{"
        + "numbers="
        + numbers
        + ", applicationKey='"
        + applicationKey
        + '\''
        + ", capability="
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

    OptionalValue<Collection<E164PhoneNumber>> numbers = OptionalValue.empty();
    OptionalValue<String> applicationKey = OptionalValue.empty();
    OptionalValue<CapabilityType> capability = OptionalValue.empty();

    /**
     * The phone number list to be updated or assigned to application
     *
     * @param numbers The phone number list
     * @return Current builder
     * @since 1.0
     */
    public Builder setNumbers(Collection<E164PhoneNumber> numbers) {
      this.numbers = OptionalValue.of(numbers);
      return this;
    }

    /**
     * Indicates the application where the numbers will be assigned.
     *
     * <p>If empty, the application key that is used to authenticate
     *
     * @param applicationKey The application where the numbers will be assigned
     * @return Current builder
     * @since 1.0
     */
    public Builder setApplicationKey(String applicationKey) {
      this.applicationKey = OptionalValue.of(applicationKey);
      return this;
    }

    /**
     * Indicates the DID capability that needs to be assigned to the chosen application.
     *
     * <p>Please note that the DID needs to support the selected capability.
     *
     * @param capability The capability value
     * @return Current builder
     * @since 1.0
     */
    public Builder setCapability(CapabilityType capability) {
      this.capability = OptionalValue.of(capability);
      return this;
    }

    public ApplicationsAssignNumbersRequestParameters build() {
      return new ApplicationsAssignNumbersRequestParameters(numbers, applicationKey, capability);
    }
  }
}
