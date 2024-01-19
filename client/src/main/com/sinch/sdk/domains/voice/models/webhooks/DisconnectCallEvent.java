package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.Price;
import java.time.Instant;

public class DisconnectCallEvent extends CallEvent {

  private final CallReasonType reason;
  private final CallResultType result;
  private final Price debit;
  private final Price userRate;
  private final Destination to;
  private final String applicationKey;
  private final Integer duration;
  private final String from;

  private DisconnectCallEvent(
      String callId,
      Instant timestamp,
      Integer version,
      String custom,
      CallReasonType reason,
      CallResultType result,
      Price debit,
      Price userRate,
      Destination to,
      String applicationKey,
      Integer duration,
      String from) {
    super(callId, timestamp, version, custom);
    this.reason = reason;
    this.result = result;
    this.debit = debit;
    this.userRate = userRate;
    this.to = to;
    this.applicationKey = applicationKey;
    this.duration = duration;
    this.from = from;
  }

  public CallReasonType getReason() {
    return reason;
  }

  public CallResultType getResult() {
    return result;
  }

  public Price getDebit() {
    return debit;
  }

  public Price getUserRate() {
    return userRate;
  }

  public Destination getTo() {
    return to;
  }

  public String getApplicationKey() {
    return applicationKey;
  }

  public Integer getDuration() {
    return duration;
  }

  public String getFrom() {
    return from;
  }

  @Override
  public String toString() {
    return "DisconnectCallEvent{"
        + "reason='"
        + reason
        + '\''
        + ", result='"
        + result
        + '\''
        + ", debit="
        + debit
        + ", userRate="
        + userRate
        + ", to="
        + to
        + ", applicationKey='"
        + applicationKey
        + '\''
        + ", duration="
        + duration
        + ", from='"
        + from
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> extends CallEvent.Builder<Builder<B>> {

    CallReasonType reason;
    CallResultType result;
    Price debit;
    Price userRate;
    Destination to;
    String applicationKey;
    Integer duration;
    String from;

    public B setReason(CallReasonType reason) {
      this.reason = reason;
      return self();
    }

    public B setResult(CallResultType result) {
      this.result = result;
      return self();
    }

    public B setDebit(Price debit) {
      this.debit = debit;
      return self();
    }

    public B setUserRate(Price userRate) {
      this.userRate = userRate;
      return self();
    }

    public B setTo(Destination to) {
      this.to = to;
      return self();
    }

    public B setApplicationKey(String applicationKey) {
      this.applicationKey = applicationKey;
      return self();
    }

    public B setDuration(Integer duration) {
      this.duration = duration;
      return self();
    }

    public B setFrom(String from) {
      this.from = from;
      return self();
    }

    public DisconnectCallEvent build() {
      return new DisconnectCallEvent(
          callId,
          timestamp,
          version,
          custom,
          reason,
          result,
          debit,
          userRate,
          to,
          applicationKey,
          duration,
          from);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
