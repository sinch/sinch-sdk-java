package com.sinch.sdk.domains.verification.models;

/** Identity based onto a number */
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
