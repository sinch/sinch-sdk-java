package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.RetentionPolicy;
import com.sinch.sdk.domains.conversation.models.RetentionPolicyType;

public class RetentionPolicyImpl implements RetentionPolicy {

  private final OptionalValue<RetentionPolicyType> retentionType;
  private final OptionalValue<Integer> ttlDays;

  private RetentionPolicyImpl(
      OptionalValue<RetentionPolicyType> retentionType, OptionalValue<Integer> ttlDays) {
    this.retentionType = retentionType;
    this.ttlDays = ttlDays;
  }

  public RetentionPolicyType getRetentionType() {
    return retentionType.orElse(null);
  }

  public OptionalValue<RetentionPolicyType> retentionType() {
    return retentionType;
  }

  public Integer getTtlDays() {
    return ttlDays.orElse(null);
  }

  public OptionalValue<Integer> ttlDays() {
    return ttlDays;
  }

  @Override
  public String toString() {
    return "RetentionPolicy{" + "retentionType=" + retentionType + ", ttlDays=" + ttlDays + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements RetentionPolicy.Builder {

    OptionalValue<RetentionPolicyType> retentionType = OptionalValue.empty();
    OptionalValue<Integer> ttlDays = OptionalValue.empty();

    public Builder setRetentionType(RetentionPolicyType retentionType) {
      this.retentionType = OptionalValue.of(retentionType);
      return this;
    }

    public Builder setTtlDays(Integer ttlDays) {
      this.ttlDays = OptionalValue.of(ttlDays);
      return this;
    }

    public RetentionPolicyImpl build() {
      return new RetentionPolicyImpl(retentionType, ttlDays);
    }
  }
}
