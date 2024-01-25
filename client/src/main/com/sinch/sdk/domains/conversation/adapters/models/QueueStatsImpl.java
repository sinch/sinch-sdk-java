package com.sinch.sdk.domains.conversation.adapters.models;

import com.sinch.sdk.domains.conversation.models.QueueStats;

public class QueueStatsImpl implements QueueStats {

  private final Long outboundSize;
  private final Long outboundLimit;

  public QueueStatsImpl(Long outboundSize, Long outboundLimit) {
    this.outboundSize = outboundSize;
    this.outboundLimit = outboundLimit;
  }

  public Long getOutboundSize() {
    return outboundSize;
  }

  public Long getOutboundLimit() {
    return outboundLimit;
  }

  @Override
  public String toString() {
    return "QueueStats{"
        + "outboundSize="
        + outboundSize
        + ", outboundLimit="
        + outboundLimit
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder implements QueueStats.Builder {

    Long outboundSize;
    Long outboundLimit;

    public Builder setOutboundSize(Long outboundSize) {
      this.outboundSize = outboundSize;
      return this;
    }

    public Builder setOutboundLimit(Long outboundLimit) {
      this.outboundLimit = outboundLimit;
      return this;
    }

    public QueueStatsImpl build() {
      return new QueueStatsImpl(outboundSize, outboundLimit);
    }
  }
}
