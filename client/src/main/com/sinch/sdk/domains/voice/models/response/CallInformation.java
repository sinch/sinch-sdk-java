package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.requests.CallUpdateRequestParameters.Builder;
import java.time.Instant;

/** Information related to a specific call */
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

  private CallInformation(
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

  /**
   * The caller information
   *
   * @return Destination instance describing caller
   */
  public Destination getFrom() {
    return from;
  }

  /**
   * The callee information
   *
   * @return Destination instance describing callee
   */
  public Destination getTo() {
    return to;
  }

  /**
   * The domain type
   *
   * @return Domain type
   */
  public DomainType getDomain() {
    return domain;
  }

  /**
   * The unique identifier of the call
   *
   * @return Call identifier
   */
  public String getCallId() {
    return callId;
  }

  /**
   * The duration of the call in seconds
   *
   * @return Call duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * The status of the call.
   *
   * @return Call status
   */
  public CallStatusType getStatus() {
    return status;
  }

  /**
   * Contains the result of a call.
   *
   * @return Call result
   */
  public CallResultType getResult() {
    return result;
  }

  /**
   * Contains the reason why a call ended
   *
   * @return Call ended reason
   */
  public CallReasonType getReason() {
    return reason;
  }

  /**
   * The date and time of the call
   *
   * @return Date time information related to call
   */
  public Instant getTimeStamp() {
    return timeStamp;
  }

  /**
   * Custom data passed onto callout
   *
   * @return The custom data value
   */
  public String getCustom() {
    return custom;
  }

  /**
   * The rate per minute that was charged for the call.
   *
   * @return Price information
   */
  public Price getUserRate() {
    return userRate;
  }

  /**
   * The total amount charged for the call
   *
   * @return Price information
   */
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

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   */
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

    /**
     * @see CallInformation#getFrom getter
     * @return Current builder
     */
    public Builder setFrom(Destination from) {
      this.from = from;
      return this;
    }

    /**
     * @see CallInformation#getTo() getter
     * @return Current builder
     */
    public Builder setTo(Destination to) {
      this.to = to;
      return this;
    }

    /**
     * @see CallInformation#getDomain() getter
     * @return Current builder
     */
    public Builder setDomain(DomainType domain) {
      this.domain = domain;
      return this;
    }

    /**
     * @see CallInformation#getCallId() getter
     * @return Current builder
     */
    public Builder setCallId(String callId) {
      this.callId = callId;
      return this;
    }

    /**
     * @see CallInformation#getDuration() getter
     * @return Current builder
     */
    public Builder setDuration(Integer duration) {
      this.duration = duration;
      return this;
    }

    /**
     * @see CallInformation#getStatus() getter
     * @return Current builder
     */
    public Builder setStatus(CallStatusType status) {
      this.status = status;
      return this;
    }

    /**
     * @see CallInformation#getResult() getter
     * @return Current builder
     */
    public Builder setResult(CallResultType result) {
      this.result = result;
      return this;
    }

    /**
     * @see CallInformation#getReason() getter
     * @return Current builder
     */
    public Builder setReason(CallReasonType reason) {
      this.reason = reason;
      return this;
    }

    /**
     * @see CallInformation#getTimeStamp() getter
     * @return Current builder
     */
    public Builder setTimeStamp(Instant timeStamp) {
      this.timeStamp = timeStamp;
      return this;
    }

    /**
     * @see CallInformation#getCustom() getter
     * @return Current builder
     */
    public Builder setCustom(String custom) {
      this.custom = custom;
      return this;
    }

    /**
     * @see CallInformation#getUserRate() getter
     * @return Current builder
     */
    public Builder setUserRate(Price userRate) {
      this.userRate = userRate;
      return this;
    }

    /**
     * @see CallInformation#getDebit() getter
     * @return Current builder
     */
    public Builder setDebit(Price debit) {
      this.debit = debit;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public CallInformation build() {
      return new CallInformation(
          from, to, domain, callId, duration, status, result, reason, timeStamp, custom, userRate,
          debit);
    }
  }
}
