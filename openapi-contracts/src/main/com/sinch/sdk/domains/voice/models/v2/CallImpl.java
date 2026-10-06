package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  CallImpl.JSON_PROPERTY_CALL_ID,
  CallImpl.JSON_PROPERTY_PROJECT_ID,
  CallImpl.JSON_PROPERTY_SERVICE_ID,
  CallImpl.JSON_PROPERTY_SESSION_ID,
  CallImpl.JSON_PROPERTY_CALL_NAME,
  CallImpl.JSON_PROPERTY_BRIDGE_NAME,
  CallImpl.JSON_PROPERTY_BATCH_ID,
  CallImpl.JSON_PROPERTY_FROM,
  CallImpl.JSON_PROPERTY_TO,
  CallImpl.JSON_PROPERTY_START_TIME,
  CallImpl.JSON_PROPERTY_UPDATE_TIME,
  CallImpl.JSON_PROPERTY_CALL_TYPE,
  CallImpl.JSON_PROPERTY_DIRECTION,
  CallImpl.JSON_PROPERTY_ANSWER_TIME,
  CallImpl.JSON_PROPERTY_END_TIME,
  CallImpl.JSON_PROPERTY_CALL_DURATION_SECONDS,
  CallImpl.JSON_PROPERTY_CALL_RESULT,
  CallImpl.JSON_PROPERTY_CALL_REASON,
  CallImpl.JSON_PROPERTY_ORIGINATION_TYPE,
  CallImpl.JSON_PROPERTY_CALL_RATE,
  CallImpl.JSON_PROPERTY_CALL_RESOURCE_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallImpl implements Call {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CALL_ID = "callId";

  private OptionalValue<String> callId;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_SESSION_ID = "sessionId";

  private OptionalValue<String> sessionId;

  public static final String JSON_PROPERTY_CALL_NAME = "callName";

  private OptionalValue<String> callName;

  public static final String JSON_PROPERTY_BRIDGE_NAME = "bridgeName";

  private OptionalValue<String> bridgeName;

  public static final String JSON_PROPERTY_BATCH_ID = "batchId";

  private OptionalValue<String> batchId;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<CallOrigin> from;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<CallDestination> to;

  public static final String JSON_PROPERTY_START_TIME = "startTime";

  private OptionalValue<Instant> startTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "updateTime";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_CALL_TYPE = "callType";

  private OptionalValue<CallType> callType;

  public static final String JSON_PROPERTY_DIRECTION = "direction";

  private OptionalValue<CallDirection> direction;

  public static final String JSON_PROPERTY_ANSWER_TIME = "answerTime";

  private OptionalValue<Instant> answerTime;

  public static final String JSON_PROPERTY_END_TIME = "endTime";

  private OptionalValue<Instant> endTime;

  public static final String JSON_PROPERTY_CALL_DURATION_SECONDS = "callDurationSeconds";

  private OptionalValue<Integer> callDurationSeconds;

  public static final String JSON_PROPERTY_CALL_RESULT = "callResult";

  private OptionalValue<CallResult> callResult;

  public static final String JSON_PROPERTY_CALL_REASON = "callReason";

  private OptionalValue<CallReason> callReason;

  public static final String JSON_PROPERTY_ORIGINATION_TYPE = "originationType";

  private OptionalValue<OriginationType> originationType;

  public static final String JSON_PROPERTY_CALL_RATE = "callRate";

  private OptionalValue<Money> callRate;

  public static final String JSON_PROPERTY_CALL_RESOURCE_URL = "callResourceUrl";

  private OptionalValue<String> callResourceUrl;

  public CallImpl() {}

  protected CallImpl(
      OptionalValue<String> callId,
      OptionalValue<String> projectId,
      OptionalValue<String> serviceId,
      OptionalValue<String> sessionId,
      OptionalValue<String> callName,
      OptionalValue<String> bridgeName,
      OptionalValue<String> batchId,
      OptionalValue<CallOrigin> from,
      OptionalValue<CallDestination> to,
      OptionalValue<Instant> startTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<CallType> callType,
      OptionalValue<CallDirection> direction,
      OptionalValue<Instant> answerTime,
      OptionalValue<Instant> endTime,
      OptionalValue<Integer> callDurationSeconds,
      OptionalValue<CallResult> callResult,
      OptionalValue<CallReason> callReason,
      OptionalValue<OriginationType> originationType,
      OptionalValue<Money> callRate,
      OptionalValue<String> callResourceUrl) {
    this.callId = callId;
    this.projectId = projectId;
    this.serviceId = serviceId;
    this.sessionId = sessionId;
    this.callName = callName;
    this.bridgeName = bridgeName;
    this.batchId = batchId;
    this.from = from;
    this.to = to;
    this.startTime = startTime;
    this.updateTime = updateTime;
    this.callType = callType;
    this.direction = direction;
    this.answerTime = answerTime;
    this.endTime = endTime;
    this.callDurationSeconds = callDurationSeconds;
    this.callResult = callResult;
    this.callReason = callReason;
    this.originationType = originationType;
    this.callRate = callRate;
    this.callResourceUrl = callResourceUrl;
  }

  @JsonIgnore
  public String getCallId() {
    return callId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> callId() {
    return callId;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public String getSessionId() {
    return sessionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SESSION_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> sessionId() {
    return sessionId;
  }

  @JsonIgnore
  public String getCallName() {
    return callName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callName() {
    return callName;
  }

  @JsonIgnore
  public String getBridgeName() {
    return bridgeName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BRIDGE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> bridgeName() {
    return bridgeName;
  }

  @JsonIgnore
  public String getBatchId() {
    return batchId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BATCH_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> batchId() {
    return batchId;
  }

  @JsonIgnore
  public CallOrigin getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallOrigin> from() {
    return from;
  }

  @JsonIgnore
  public CallDestination getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallDestination> to() {
    return to;
  }

  @JsonIgnore
  public Instant getStartTime() {
    return startTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_START_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> startTime() {
    return startTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
  }

  @JsonIgnore
  public CallType getCallType() {
    return callType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CallType> callType() {
    return callType;
  }

  @JsonIgnore
  public CallDirection getDirection() {
    return direction.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIRECTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CallDirection> direction() {
    return direction;
  }

  @JsonIgnore
  public Instant getAnswerTime() {
    return answerTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ANSWER_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> answerTime() {
    return answerTime;
  }

  @JsonIgnore
  public Instant getEndTime() {
    return endTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_END_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> endTime() {
    return endTime;
  }

  @JsonIgnore
  public Integer getCallDurationSeconds() {
    return callDurationSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_DURATION_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> callDurationSeconds() {
    return callDurationSeconds;
  }

  @JsonIgnore
  public CallResult getCallResult() {
    return callResult.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_RESULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CallResult> callResult() {
    return callResult;
  }

  @JsonIgnore
  public CallReason getCallReason() {
    return callReason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallReason> callReason() {
    return callReason;
  }

  @JsonIgnore
  public OriginationType getOriginationType() {
    return originationType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORIGINATION_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OriginationType> originationType() {
    return originationType;
  }

  @JsonIgnore
  public Money getCallRate() {
    return callRate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_RATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Money> callRate() {
    return callRate;
  }

  @JsonIgnore
  public String getCallResourceUrl() {
    return callResourceUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_RESOURCE_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> callResourceUrl() {
    return callResourceUrl;
  }

  /** Return true if this Call object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallImpl call = (CallImpl) o;
    return Objects.equals(this.callId, call.callId)
        && Objects.equals(this.projectId, call.projectId)
        && Objects.equals(this.serviceId, call.serviceId)
        && Objects.equals(this.sessionId, call.sessionId)
        && Objects.equals(this.callName, call.callName)
        && Objects.equals(this.bridgeName, call.bridgeName)
        && Objects.equals(this.batchId, call.batchId)
        && Objects.equals(this.from, call.from)
        && Objects.equals(this.to, call.to)
        && Objects.equals(this.startTime, call.startTime)
        && Objects.equals(this.updateTime, call.updateTime)
        && Objects.equals(this.callType, call.callType)
        && Objects.equals(this.direction, call.direction)
        && Objects.equals(this.answerTime, call.answerTime)
        && Objects.equals(this.endTime, call.endTime)
        && Objects.equals(this.callDurationSeconds, call.callDurationSeconds)
        && Objects.equals(this.callResult, call.callResult)
        && Objects.equals(this.callReason, call.callReason)
        && Objects.equals(this.originationType, call.originationType)
        && Objects.equals(this.callRate, call.callRate)
        && Objects.equals(this.callResourceUrl, call.callResourceUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        callId,
        projectId,
        serviceId,
        sessionId,
        callName,
        bridgeName,
        batchId,
        from,
        to,
        startTime,
        updateTime,
        callType,
        direction,
        answerTime,
        endTime,
        callDurationSeconds,
        callResult,
        callReason,
        originationType,
        callRate,
        callResourceUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallImpl {\n");
    sb.append("    callId: ").append(toIndentedString(callId)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    callName: ").append(toIndentedString(callName)).append("\n");
    sb.append("    bridgeName: ").append(toIndentedString(bridgeName)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    callType: ").append(toIndentedString(callType)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    answerTime: ").append(toIndentedString(answerTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    callDurationSeconds: ")
        .append(toIndentedString(callDurationSeconds))
        .append("\n");
    sb.append("    callResult: ").append(toIndentedString(callResult)).append("\n");
    sb.append("    callReason: ").append(toIndentedString(callReason)).append("\n");
    sb.append("    originationType: ").append(toIndentedString(originationType)).append("\n");
    sb.append("    callRate: ").append(toIndentedString(callRate)).append("\n");
    sb.append("    callResourceUrl: ").append(toIndentedString(callResourceUrl)).append("\n");
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
  static class Builder implements Call.Builder {
    OptionalValue<String> callId = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<String> sessionId = OptionalValue.empty();
    OptionalValue<String> callName = OptionalValue.empty();
    OptionalValue<String> bridgeName = OptionalValue.empty();
    OptionalValue<String> batchId = OptionalValue.empty();
    OptionalValue<CallOrigin> from = OptionalValue.empty();
    OptionalValue<CallDestination> to = OptionalValue.empty();
    OptionalValue<Instant> startTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<CallType> callType = OptionalValue.empty();
    OptionalValue<CallDirection> direction = OptionalValue.empty();
    OptionalValue<Instant> answerTime = OptionalValue.empty();
    OptionalValue<Instant> endTime = OptionalValue.empty();
    OptionalValue<Integer> callDurationSeconds = OptionalValue.empty();
    OptionalValue<CallResult> callResult = OptionalValue.empty();
    OptionalValue<CallReason> callReason = OptionalValue.empty();
    OptionalValue<OriginationType> originationType = OptionalValue.empty();
    OptionalValue<Money> callRate = OptionalValue.empty();
    OptionalValue<String> callResourceUrl = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_CALL_ID, required = true)
    public Builder setCallId(String callId) {
      this.callId = OptionalValue.of(callId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_PROJECT_ID, required = true)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SERVICE_ID, required = true)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SESSION_ID, required = true)
    public Builder setSessionId(String sessionId) {
      this.sessionId = OptionalValue.of(sessionId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_NAME)
    public Builder setCallName(String callName) {
      this.callName = OptionalValue.of(callName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BRIDGE_NAME)
    public Builder setBridgeName(String bridgeName) {
      this.bridgeName = OptionalValue.of(bridgeName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BATCH_ID)
    public Builder setBatchId(String batchId) {
      this.batchId = OptionalValue.of(batchId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(CallOrigin from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    public Builder setTo(CallDestination to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_START_TIME, required = true)
    public Builder setStartTime(Instant startTime) {
      this.startTime = OptionalValue.of(startTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public Builder setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALL_TYPE, required = true)
    public Builder setCallType(CallType callType) {
      this.callType = OptionalValue.of(callType);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DIRECTION, required = true)
    public Builder setDirection(CallDirection direction) {
      this.direction = OptionalValue.of(direction);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ANSWER_TIME)
    public Builder setAnswerTime(Instant answerTime) {
      this.answerTime = OptionalValue.of(answerTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_END_TIME)
    public Builder setEndTime(Instant endTime) {
      this.endTime = OptionalValue.of(endTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_DURATION_SECONDS)
    public Builder setCallDurationSeconds(Integer callDurationSeconds) {
      this.callDurationSeconds = OptionalValue.of(callDurationSeconds);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALL_RESULT, required = true)
    public Builder setCallResult(CallResult callResult) {
      this.callResult = OptionalValue.of(callResult);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_REASON)
    public Builder setCallReason(CallReason callReason) {
      this.callReason = OptionalValue.of(callReason);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ORIGINATION_TYPE, required = true)
    public Builder setOriginationType(OriginationType originationType) {
      this.originationType = OptionalValue.of(originationType);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALL_RATE, required = true)
    public Builder setCallRate(Money callRate) {
      this.callRate = OptionalValue.of(callRate);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_CALL_RESOURCE_URL, required = true)
    public Builder setCallResourceUrl(String callResourceUrl) {
      this.callResourceUrl = OptionalValue.of(callResourceUrl);
      return this;
    }

    public Call build() {
      return new CallImpl(
          callId,
          projectId,
          serviceId,
          sessionId,
          callName,
          bridgeName,
          batchId,
          from,
          to,
          startTime,
          updateTime,
          callType,
          direction,
          answerTime,
          endTime,
          callDurationSeconds,
          callResult,
          callReason,
          originationType,
          callRate,
          callResourceUrl);
    }
  }
}
