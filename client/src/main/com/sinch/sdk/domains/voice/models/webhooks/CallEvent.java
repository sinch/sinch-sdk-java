package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.domains.sms.models.DeliveryReportBatch.Builder;
import java.time.Instant;

public class CallEvent extends WebhooksEvent {

  private final Instant timestamp;
  private final String custom;

  protected CallEvent(String callId, Instant timestamp, Integer version, String custom) {
    super(callId, version);
    this.timestamp = timestamp;
    this.custom = custom;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public String getCustom() {
    return custom;
  }

  @Override
  public String toString() {
    return "CallEvent{" + "timestamp=" + timestamp + ", custom='" + custom + '\'' + '}';
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends WebhooksEvent.Builder<B> {

    Instant timestamp;
    String custom;

    public B setTimestamp(Instant timestamp) {
      this.timestamp = timestamp;
      return self();
    }

    public B setCustom(String custom) {
      this.custom = custom;
      return self();
    }

    public CallEvent build() {
      return new CallEvent(callId, timestamp, version, custom);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
