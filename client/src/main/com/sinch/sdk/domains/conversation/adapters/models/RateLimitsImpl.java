package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.domains.conversation.models.RateLimits;

public class RateLimitsImpl implements RateLimits {

  private final Long inBound;
  private final Long outBound;
  private final Long webhooks;

  public RateLimitsImpl(Long inBound, Long outBound, Long webhooks) {
    this.inBound = inBound;
    this.outBound = outBound;
    this.webhooks = webhooks;
  }

  public Long getInBound() {
    return inBound;
  }

  public Long getOutBound() {
    return outBound;
  }

  public Long getWebhooks() {
    return webhooks;
  }

  @Override
  public String toString() {
    return "RateLimits{"
        + "inBound="
        + inBound
        + ", outBound="
        + outBound
        + ", webhooks="
        + webhooks
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements RateLimits.Builder {

    Long inBound;
    Long outBound;
    Long webhooks;

    public Builder setInBound(Long inBound) {
      this.inBound = inBound;
      return this;
    }

    public Builder setOutBound(Long outBound) {
      this.outBound = outBound;
      return this;
    }

    public Builder setWebhooks(Long webhooks) {
      this.webhooks = webhooks;
      return this;
    }

    public RateLimitsImpl build() {
      return new RateLimitsImpl(inBound, outBound, webhooks);
    }
  }
}
