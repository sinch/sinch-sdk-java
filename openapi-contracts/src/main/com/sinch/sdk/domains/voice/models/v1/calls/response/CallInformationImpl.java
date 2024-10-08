package com.sinch.sdk.domains.voice.models.v1.calls.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.Price;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  CallInformationImpl.JSON_PROPERTY_FROM,
  CallInformationImpl.JSON_PROPERTY_TO,
  CallInformationImpl.JSON_PROPERTY_DOMAIN,
  CallInformationImpl.JSON_PROPERTY_CALL_ID,
  CallInformationImpl.JSON_PROPERTY_DURATION,
  CallInformationImpl.JSON_PROPERTY_STATUS,
  CallInformationImpl.JSON_PROPERTY_RESULT,
  CallInformationImpl.JSON_PROPERTY_REASON,
  CallInformationImpl.JSON_PROPERTY_TIMESTAMP,
  CallInformationImpl.JSON_PROPERTY_CUSTOM,
  CallInformationImpl.JSON_PROPERTY_USER_RATE,
  CallInformationImpl.JSON_PROPERTY_DEBIT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallInformationImpl implements CallInformation {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<Destination> from;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<Destination> to;

  public static final String JSON_PROPERTY_DOMAIN = "domain";

  private OptionalValue<DomainEnum> domain;

  public static final String JSON_PROPERTY_CALL_ID = "callId";

  private OptionalValue<String> callId;

  public static final String JSON_PROPERTY_DURATION = "duration";

  private OptionalValue<Integer> duration;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> status;

  public static final String JSON_PROPERTY_RESULT = "result";

  private OptionalValue<CallResult> result;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<ReasonEnum> reason;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";

  private OptionalValue<Instant> timestamp;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_USER_RATE = "userRate";

  private OptionalValue<Price> userRate;

  public static final String JSON_PROPERTY_DEBIT = "debit";

  private OptionalValue<Price> debit;

  public CallInformationImpl() {}

  protected CallInformationImpl(
      OptionalValue<Destination> from,
      OptionalValue<Destination> to,
      OptionalValue<DomainEnum> domain,
      OptionalValue<String> callId,
      OptionalValue<Integer> duration,
      OptionalValue<StatusEnum> status,
      OptionalValue<CallResult> result,
      OptionalValue<ReasonEnum> reason,
      OptionalValue<Instant> timestamp,
      OptionalValue<String> custom,
      OptionalValue<Price> userRate,
      OptionalValue<Price> debit) {
    this.from = from;
    this.to = to;
    this.domain = domain;
    this.callId = callId;
    this.duration = duration;
    this.status = status;
    this.result = result;
    this.reason = reason;
    this.timestamp = timestamp;
    this.custom = custom;
    this.userRate = userRate;
    this.debit = debit;
  }

  @JsonIgnore
  public Destination getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Destination> from() {
    return from;
  }

  @JsonIgnore
  public Destination getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Destination> to() {
    return to;
  }

  @JsonIgnore
  public DomainEnum getDomain() {
    return domain.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DOMAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DomainEnum> domain() {
    return domain;
  }

  @JsonIgnore
  public String getCallId() {
    return callId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callId() {
    return callId;
  }

  @JsonIgnore
  public Integer getDuration() {
    return duration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> duration() {
    return duration;
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusEnum> status() {
    return status;
  }

  @JsonIgnore
  public CallResult getResult() {
    return result.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallResult> result() {
    return result;
  }

  @JsonIgnore
  public ReasonEnum getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReasonEnum> reason() {
    return reason;
  }

  @JsonIgnore
  public Instant getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> timestamp() {
    return timestamp;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public Price getUserRate() {
    return userRate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_USER_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> userRate() {
    return userRate;
  }

  @JsonIgnore
  public Price getDebit() {
    return debit.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DEBIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> debit() {
    return debit;
  }

  /** Return true if this getCallResponseObj object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallInformationImpl getCallResponseObj = (CallInformationImpl) o;
    return Objects.equals(this.from, getCallResponseObj.from)
        && Objects.equals(this.to, getCallResponseObj.to)
        && Objects.equals(this.domain, getCallResponseObj.domain)
        && Objects.equals(this.callId, getCallResponseObj.callId)
        && Objects.equals(this.duration, getCallResponseObj.duration)
        && Objects.equals(this.status, getCallResponseObj.status)
        && Objects.equals(this.result, getCallResponseObj.result)
        && Objects.equals(this.reason, getCallResponseObj.reason)
        && Objects.equals(this.timestamp, getCallResponseObj.timestamp)
        && Objects.equals(this.custom, getCallResponseObj.custom)
        && Objects.equals(this.userRate, getCallResponseObj.userRate)
        && Objects.equals(this.debit, getCallResponseObj.debit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        from, to, domain, callId, duration, status, result, reason, timestamp, custom, userRate,
        debit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallInformationImpl {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    callId: ").append(toIndentedString(callId)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    userRate: ").append(toIndentedString(userRate)).append("\n");
    sb.append("    debit: ").append(toIndentedString(debit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements CallInformation.Builder {
    OptionalValue<Destination> from = OptionalValue.empty();
    OptionalValue<Destination> to = OptionalValue.empty();
    OptionalValue<DomainEnum> domain = OptionalValue.empty();
    OptionalValue<String> callId = OptionalValue.empty();
    OptionalValue<Integer> duration = OptionalValue.empty();
    OptionalValue<StatusEnum> status = OptionalValue.empty();
    OptionalValue<CallResult> result = OptionalValue.empty();
    OptionalValue<ReasonEnum> reason = OptionalValue.empty();
    OptionalValue<Instant> timestamp = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<Price> userRate = OptionalValue.empty();
    OptionalValue<Price> debit = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(Destination from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(Destination to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN)
    public Builder setDomain(DomainEnum domain) {
      this.domain = OptionalValue.of(domain);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_ID)
    public Builder setCallId(String callId) {
      this.callId = OptionalValue.of(callId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DURATION)
    public Builder setDuration(Integer duration) {
      this.duration = OptionalValue.of(duration);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(StatusEnum status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESULT)
    public Builder setResult(CallResult result) {
      this.result = OptionalValue.of(result);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(ReasonEnum reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TIMESTAMP)
    public Builder setTimestamp(Instant timestamp) {
      this.timestamp = OptionalValue.of(timestamp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_USER_RATE)
    public Builder setUserRate(Price userRate) {
      this.userRate = OptionalValue.of(userRate);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DEBIT)
    public Builder setDebit(Price debit) {
      this.debit = OptionalValue.of(debit);
      return this;
    }

    public CallInformation build() {
      return new CallInformationImpl(
          from, to, domain, callId, duration, status, result, reason, timestamp, custom, userRate,
          debit);
    }
  }
}
