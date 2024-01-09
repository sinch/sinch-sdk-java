package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import java.time.Instant;

public class CallInformation {
  private final Destination from;
  private final Destination to;
  private final DomainType domain;
  private final String callId;
  private final Integer duration;
  private final CallStatusType status;
  private final CallResultType result;
  private final CallReasonType reason;
  private final Instant timeStamp;
  private final String custom;
  private final Price userRate;
  private final Price debit;

  public CallInformation(
      Destination from,
      Destination to,
      DomainType domain,
      String callId,
      Integer duration,
      CallStatusType status,
      CallResultType result,
      CallReasonType reason,
      Instant timeStamp,
      String custom,
      Price userRate,
      Price debit) {
    this.from = from;
    this.to = to;
    this.domain = domain;
    this.callId = callId;
    this.duration = duration;
    this.status = status;
    this.result = result;
    this.reason = reason;
    this.timeStamp = timeStamp;
    this.custom = custom;
    this.userRate = userRate;
    this.debit = debit;
  }

  public Destination getFrom() {
    return from;
  }

  public Destination getTo() {
    return to;
  }

  public DomainType getDomain() {
    return domain;
  }

  public String getCallId() {
    return callId;
  }

  public Integer getDuration() {
    return duration;
  }

  public CallStatusType getStatus() {
    return status;
  }

  public CallResultType getResult() {
    return result;
  }

  public CallReasonType getReason() {
    return reason;
  }

  public Instant getTimeStamp() {
    return timeStamp;
  }

  public String getCustom() {
    return custom;
  }

  public Price getUserRate() {
    return userRate;
  }

  public Price getDebit() {
    return debit;
  }

  @Override
  public String toString() {
    return "CallInformation{"
        + "from='"
        + from
        + '\''
        + ", to='"
        + to
        + '\''
        + ", domain="
        + domain
        + ", callId='"
        + callId
        + '\''
        + ", duration="
        + duration
        + ", status="
        + status
        + ", result="
        + result
        + ", reason="
        + reason
        + ", timeStamp="
        + timeStamp
        + ", custom='"
        + custom
        + '\''
        + ", userRate='"
        + userRate
        + '\''
        + ", debit='"
        + debit
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    Destination from;
    Destination to;
    DomainType domain;
    String callId;
    Integer duration;
    CallStatusType status;
    CallResultType result;
    CallReasonType reason;
    Instant timeStamp;
    String custom;
    Price userRate;
    Price debit;

    public Builder setFrom(Destination from) {
      this.from = from;
      return this;
    }

    public Builder setTo(Destination to) {
      this.to = to;
      return this;
    }

    public Builder setDomain(DomainType domain) {
      this.domain = domain;
      return this;
    }

    public Builder setCallId(String callId) {
      this.callId = callId;
      return this;
    }

    public Builder setDuration(Integer duration) {
      this.duration = duration;
      return this;
    }

    public Builder setStatus(CallStatusType status) {
      this.status = status;
      return this;
    }

    public Builder setResult(CallResultType result) {
      this.result = result;
      return this;
    }

    public Builder setReason(CallReasonType reason) {
      this.reason = reason;
      return this;
    }

    public Builder setTimeStamp(Instant timeStamp) {
      this.timeStamp = timeStamp;
      return this;
    }

    public Builder setCustom(String custom) {
      this.custom = custom;
      return this;
    }

    public Builder setUserRate(Price userRate) {
      this.userRate = userRate;
      return this;
    }

    public Builder setDebit(Price debit) {
      this.debit = debit;
      return this;
    }

    public CallInformation build() {
      return new CallInformation(
          from, to, domain, callId, duration, status, result, reason, timeStamp, custom, userRate,
          debit);
    }
  }
}
