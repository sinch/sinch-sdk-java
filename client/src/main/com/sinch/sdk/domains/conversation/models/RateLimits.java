package com.sinch.sdk.domains.conversation.models;

public interface RateLimits {

  Long getInBound();

  Long getOutBound();

  Long getWebhooks();

  static Builder builder() {
    return BuildersDelegation.RateLimitsBuilder();
  }

  interface Builder {

    Builder setInBound(Long inBound);

    Builder setOutBound(Long outBound);

    Builder setWebhooks(Long webhooks);

    RateLimits build();
  }
}
