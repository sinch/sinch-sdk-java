package com.sinch.sdk.domains.conversation.models;

public interface QueueStats {

  Long getOutboundSize();

  Long getOutboundLimit();

  static Builder builder() {
    return BuildersDelegation.QueueStatsBuilder();
  }

  interface Builder {

    Builder setOutboundSize(Long value);

    Builder setOutboundLimit(Long value);

    QueueStats build();
  }
}
