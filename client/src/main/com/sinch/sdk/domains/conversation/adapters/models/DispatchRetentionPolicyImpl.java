package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.DispatchRetentionPolicy;

public class DispatchRetentionPolicyImpl implements DispatchRetentionPolicy {

  private final OptionalValue<Integer> ttlDays;

  private DispatchRetentionPolicyImpl(OptionalValue<Integer> ttlDays) {
    this.ttlDays = ttlDays;
  }

  public Integer getTtlDays() {
    return ttlDays.orElse(null);
  }

  public OptionalValue<Integer> ttlDays() {
    return ttlDays;
  }

  @Override
  public String toString() {
    return "DispatchRetentionPolicy{" + "ttlDays=" + ttlDays + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements DispatchRetentionPolicy.Builder {

    OptionalValue<Integer> ttlDays = OptionalValue.empty();

    public Builder setTtlDays(Integer ttlDays) {
      this.ttlDays = OptionalValue.of(ttlDays);
      return this;
    }

    public DispatchRetentionPolicyImpl build() {
      return new DispatchRetentionPolicyImpl(ttlDays);
    }
  }
}
