package com.sinch.sdk.domains.voice.models.webhooks;

import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.Destination;
import com.sinch.sdk.domains.voice.models.Price;
import java.time.Instant;

/**
 * This callback is made when the call is disconnected.
 *
 * <p>It's a POST request to the specified calling callback URL. This event doesn't support
 * instructions and only supports the hangup action.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/#tag/Callbacks/operation/dice">DICE</a>
 */
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

  /**
   * The reason the call was disconnected
   *
   * @return Reason value
   */
  public CallReasonType getReason() {
    return reason;
  }

  /**
   * The result of the call
   *
   * @return Result value
   */
  public CallResultType getResult() {
    return result;
  }

  /**
   * Amount charged for the call
   *
   * @return charge value
   */
  public Price getDebit() {
    return debit;
  }

  /**
   * Rate per minute for the call
   *
   * @return rate value
   */
  public Price getUserRate() {
    return userRate;
  }

  /**
   * Information about the recipient of the call
   *
   * @return Recipient information
   */
  public Destination getTo() {
    return to;
  }

  /**
   * The unique application key
   *
   * @return Application key value
   */
  public String getApplicationKey() {
    return applicationKey;
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
   * Information about the initiator of the call.
   *
   * @return Initiator information
   */
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
