package com.sinch.sdk.domains.voice.models.webhooks;

import java.time.Instant;

public class AnsweredCallEvent extends CallEvent {

  private final AmdAnswer amd;

  private AnsweredCallEvent(
      String callId, Instant timestamp, Integer version, String custom, AmdAnswer amd) {
    super(callId, timestamp, version, custom);
    this.amd = amd;
  }

  public AmdAnswer getAmd() {
    return amd;
  }

  @Override
  public String toString() {
    return "AnsweredCallEvent{" + "amd=" + amd + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends CallEvent.Builder<Builder<B>> {

    AmdAnswer amd;

    public Builder<B> setAmd(AmdAnswer amd) {
      this.amd = amd;
      return this;
    }

    public AnsweredCallEvent build() {
      return new AnsweredCallEvent(callId, timestamp, version, custom, amd);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
