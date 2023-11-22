package com.sinch.sdk.domains.verification.models;

import com.sinch.sdk.domains.sms.models.Group.Builder;

public class NumberIdentity extends Identity {
  private final String endpoint;

  public String getEndpoint() {
    return endpoint;
  }

  public NumberIdentity(String endpoint) {
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
    ;

    public Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public NumberIdentity build() {
      return new NumberIdentity(endpoint);
    }
  }
}
