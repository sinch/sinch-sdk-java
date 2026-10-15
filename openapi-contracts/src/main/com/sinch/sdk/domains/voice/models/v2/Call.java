package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import java.time.Instant;

/** Call details */
@JsonDeserialize(builder = CallImpl.Builder.class)
public interface Call {

  /**
   * The ID of the call.
   *
   * <p>Field is required
   *
   * @return callId
   */
  String getCallId();

  /**
   * The ID of the project associated with the call.
   *
   * <p>Field is required
   *
   * @return projectId
   */
  String getProjectId();

  /**
   * The ID of the service used.
   *
   * <p>Field is required
   *
   * @return serviceId
   */
  String getServiceId();

  /**
   * The ID of the session.
   *
   * <p>Field is required
   *
   * @return sessionId
   */
  String getSessionId();

  /**
   * The name identifying this call leg within the session, as assigned by the <code>callName</code>
   * property in the <code>dial</code> command or in the SVAML response to an incoming call webhook.
   *
   * <p>Omitted for calls that were not assigned a name.
   *
   * @return callName
   */
  String getCallName();

  /**
   * The name of the bridge the call belongs to. Omitted for calls not assigned to any bridge.
   *
   * @return bridgeName
   */
  String getBridgeName();

  /**
   * The ID of the batch.
   *
   * @return batchId
   */
  String getBatchId();

  /**
   * Call origin - Phone Number or SIP endpoint
   *
   * @return from
   */
  CallOrigin getFrom();

  /**
   * Call destination - Phone Number or Stream URI
   *
   * @return to
   */
  CallDestination getTo();

  /**
   * Timestamp (RFC 3339) indicating when the call was created and call setup was initiated (start
   * of the call attempt).
   *
   * <p>Field is required
   *
   * @return startTime
   */
  Instant getStartTime();

  /**
   * Timestamp (RFC 3339) indicating when the call was last updated.
   *
   * <p>Omitted if no updates were performed on this call.
   *
   * @return updateTime
   */
  Instant getUpdateTime();

  /**
   * The type of channel used for the call.
   *
   * <p>Field is required
   *
   * @return callType
   */
  CallType getCallType();

  /**
   * Indicates the direction of the call.
   *
   * <p>Field is required
   *
   * @return direction
   */
  CallDirection getDirection();

  /**
   * Timestamp (RFC 3339) indicating when the call was answered.
   *
   * <p>Omitted if the call was not answered.
   *
   * @return answerTime
   */
  Instant getAnswerTime();

  /**
   * Timestamp (RFC 3339) indicating when the call ended.
   *
   * <p>Omitted for ongoing calls.
   *
   * @return endTime
   */
  Instant getEndTime();

  /**
   * Duration of the call in seconds
   *
   * @return callDurationSeconds
   */
  Integer getCallDurationSeconds();

  /**
   * The outcome/state of the call.
   *
   * <p>Field is required
   *
   * @return callResult
   */
  CallResult getCallResult();

  /**
   * Reason explaining why the call ended in the given {@link #getCallResult() callResult}.
   *
   * @return callReason
   */
  CallReason getCallReason();

  /**
   * Indicates the origin/source of the call.
   *
   * <p>Field is required
   *
   * @return originationType
   */
  OriginationType getOriginationType();

  /**
   * The rate charged for this call, expressed as a monetary amount <b>per minute</b> in the
   * specified currency.
   *
   * <p>Field is required
   *
   * @return callRate
   */
  Money getCallRate();

  /**
   * Absolute URI to this call resource. Use this URL to retrieve the call details
   *
   * <p>Field is required
   *
   * @return callResourceUrl
   */
  String getCallResourceUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new CallImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param callId see getter
     * @return Current builder
     * @see #getCallId
     */
    Builder setCallId(String callId);

    /**
     * see getter
     *
     * @param projectId see getter
     * @return Current builder
     * @see #getProjectId
     */
    Builder setProjectId(String projectId);

    /**
     * see getter
     *
     * @param serviceId see getter
     * @return Current builder
     * @see #getServiceId
     */
    Builder setServiceId(String serviceId);

    /**
     * see getter
     *
     * @param sessionId see getter
     * @return Current builder
     * @see #getSessionId
     */
    Builder setSessionId(String sessionId);

    /**
     * see getter
     *
     * @param callName see getter
     * @return Current builder
     * @see #getCallName
     */
    Builder setCallName(String callName);

    /**
     * see getter
     *
     * @param bridgeName see getter
     * @return Current builder
     * @see #getBridgeName
     */
    Builder setBridgeName(String bridgeName);

    /**
     * see getter
     *
     * @param batchId see getter
     * @return Current builder
     * @see #getBatchId
     */
    Builder setBatchId(String batchId);

    /**
     * see getter
     *
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(CallOrigin from);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(CallDestination to);

    /**
     * see getter
     *
     * @param startTime see getter
     * @return Current builder
     * @see #getStartTime
     */
    Builder setStartTime(Instant startTime);

    /**
     * see getter
     *
     * @param updateTime see getter
     * @return Current builder
     * @see #getUpdateTime
     */
    Builder setUpdateTime(Instant updateTime);

    /**
     * see getter
     *
     * @param callType see getter
     * @return Current builder
     * @see #getCallType
     */
    Builder setCallType(CallType callType);

    /**
     * see getter
     *
     * @param direction see getter
     * @return Current builder
     * @see #getDirection
     */
    Builder setDirection(CallDirection direction);

    /**
     * see getter
     *
     * @param answerTime see getter
     * @return Current builder
     * @see #getAnswerTime
     */
    Builder setAnswerTime(Instant answerTime);

    /**
     * see getter
     *
     * @param endTime see getter
     * @return Current builder
     * @see #getEndTime
     */
    Builder setEndTime(Instant endTime);

    /**
     * see getter
     *
     * @param callDurationSeconds see getter
     * @return Current builder
     * @see #getCallDurationSeconds
     */
    Builder setCallDurationSeconds(Integer callDurationSeconds);

    /**
     * see getter
     *
     * @param callResult see getter
     * @return Current builder
     * @see #getCallResult
     */
    Builder setCallResult(CallResult callResult);

    /**
     * see getter
     *
     * @param callReason see getter
     * @return Current builder
     * @see #getCallReason
     */
    Builder setCallReason(CallReason callReason);

    /**
     * see getter
     *
     * @param originationType see getter
     * @return Current builder
     * @see #getOriginationType
     */
    Builder setOriginationType(OriginationType originationType);

    /**
     * see getter
     *
     * @param callRate see getter
     * @return Current builder
     * @see #getCallRate
     */
    Builder setCallRate(Money callRate);

    /**
     * see getter
     *
     * @param callResourceUrl see getter
     * @return Current builder
     * @see #getCallResourceUrl
     */
    Builder setCallResourceUrl(String callResourceUrl);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Call build();
  }
}
