package com.sinch.sdk.domains.conversation.models;

public interface DispatchRetentionPolicy {

  Integer getTtlDays();

  static Builder builder() {
    return BuildersDelegation.DispatchRetentionPolicyBuilder();
  }

  interface Builder {

    Builder setTtlDays(Integer ttlDays);

    DispatchRetentionPolicy build();
  }
}
