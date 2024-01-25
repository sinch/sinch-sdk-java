package com.sinch.sdk.domains.conversation.models;

import com.sinch.sdk.domains.conversation.adapters.AppBuilders;

public interface RetentionPolicy {

  RetentionPolicyType getRetentionType();

  Integer getTtlDays();

  static Builder builder() {
    return AppBuilders.RetentionPolicyBuilder();
  }

  interface Builder {

    Builder setRetentionType(RetentionPolicyType retentionType);

    Builder setTtlDays(Integer ttlDays);

    RetentionPolicy build();
  }
}
