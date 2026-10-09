package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.CallReason;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import java.time.Instant;

/**
 * Query parameters for listing calls
 *
 * @since 2.3
 */
public interface ListCallsQueryParameters {

  /**
   * The ID of the service.
   *
   * @return serviceId
   */
  OptionalValue<String> getServiceId();

  /**
   * Only include calls where <code>from</code> matches this origin. For inbound calls, this is the
   * caller; for outbound calls, this is the calling party.
   *
   * @return from
   */
  OptionalValue<String> getFrom();

  /**
   * Only include calls where <code>to</code> matches this destination. For inbound calls, this is
   * the called party; for outbound calls, this is the callee/recipient.
   *
   * @return to
   */
  OptionalValue<String> getTo();

  /**
   * Only include calls of the specified type.
   *
   * <p>If omitted, calls of all types are included.
   *
   * @return callType
   */
  OptionalValue<CallType> getCallType();

  /**
   * Only include calls that started <strong>at or after</strong> <code>startTime</code>.
   *
   * @return startTime
   */
  OptionalValue<Instant> getStartTime();

  /**
   * Only include calls that ended <strong>before</strong> <code>endTime</code> (exclusive).
   *
   * @return endTime
   */
  OptionalValue<Instant> getEndTime();

  /**
   * Filter results to only include calls whose <code>callResult</code> matches the specified value.
   *
   * <p>If omitted, calls with any result are included.
   *
   * @return callResult
   */
  OptionalValue<CallResult> getCallResult();

  /**
   * Filter results to only include calls whose <code>callReason</code> matches the specified value.
   *
   * <p>If omitted, calls with any reason are included.
   *
   * @return callReason
   */
  OptionalValue<CallReason> getCallReason();

  /**
   * Number of items to be returned on each page. minimum: 1 maximum: 100
   *
   * @return pageSize
   */
  OptionalValue<Integer> getPageSize();

  /**
   * Page number (1-based) minimum: 1
   *
   * @return page
   */
  OptionalValue<Integer> getPage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListCallsQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @param parameters Instance to copy the values from
   * @return New Builder instance
   */
  static Builder builder(ListCallsQueryParameters parameters) {
    return new ListCallsQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param from see getter
     * @return Current builder
     * @see #getFrom
     */
    Builder setFrom(String from);

    /**
     * see getter
     *
     * @param to see getter
     * @return Current builder
     * @see #getTo
     */
    Builder setTo(String to);

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
     * @param startTime see getter
     * @return Current builder
     * @see #getStartTime
     */
    Builder setStartTime(Instant startTime);

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
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize
     */
    Builder setPageSize(Integer pageSize);

    /**
     * see getter
     *
     * @param page see getter
     * @return Current builder
     * @see #getPage
     */
    Builder setPage(Integer page);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListCallsQueryParameters build();
  }
}
