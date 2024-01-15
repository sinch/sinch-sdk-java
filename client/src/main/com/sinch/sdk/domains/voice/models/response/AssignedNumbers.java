package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.domains.voice.models.ApplicationAssignedNumber;
import java.util.Collection;

/**
 * Get information about your numbers. It returns a list of numbers that you own, as well as their
 * capability (voice or SMS). For the ones that are assigned to an app, it returns the application
 * key of the app
 */
public class AssignedNumbers {

  private final Collection<ApplicationAssignedNumber> numbers;

  private AssignedNumbers(Collection<ApplicationAssignedNumber> numbers) {
    this.numbers = numbers;
  }

  /**
   * Associated application numbers
   *
   * @return The numbers list
   */
  public Collection<ApplicationAssignedNumber> getNumbers() {
    return numbers;
  }

  @Override
  public String toString() {
    return "AssignedNumbers{" + "numbers=" + numbers + '}';
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

    Collection<ApplicationAssignedNumber> numbers;

    /**
     * @param numbers the numbers list
     * @return Current builder
     * @see AssignedNumbers#getNumbers() getter
     */
    public Builder setNumbers(Collection<ApplicationAssignedNumber> numbers) {
      this.numbers = numbers;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public AssignedNumbers build() {
      return new AssignedNumbers(numbers);
    }
  }
}
