package com.sinch.sdk.domains.verification.models;

/** Identity based onto a number */
public class NumberIdentity extends Identity {

  private final String endpoint;

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String endpoint;

    private Builder() {}

    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public NumberIdentity build() {
      return new NumberIdentity(endpoint);
    }
  }
}
