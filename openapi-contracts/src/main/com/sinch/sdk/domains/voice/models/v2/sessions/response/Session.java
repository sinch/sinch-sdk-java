package com.sinch.sdk.domains.voice.models.v2.sessions.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.time.Instant;
import java.util.List;

/**
 * A session represents the complete lifecycle of a voice interaction initiated through the Voice
 * API.
 *
 * <p>A session can contain one or more related call legs (for example, an original outbound call
 * plus additional dials or transfers triggered by SVAML commands). Use {@link #getCalls()} to
 * inspect all call legs associated with the session and {@link #getState()} to determine whether
 * the session is still ongoing or has reached a final state.
 */
@JsonDeserialize(builder = SessionImpl.Builder.class)
public interface Session {

  /**
   * The ID of the session.
   *
   * <p>Field is required
   *
   * @return sessionId
   */
  String getSessionId();

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
   * Call legs associated with the session.
   *
   * <p>Field is required
   *
   * @return calls
   */
  List<Call> getCalls();

  /**
   * Timestamp (RFC 3339) indicating when the session was created.
   *
   * <p>Field is required
   *
   * @return createTime
   */
  Instant getCreateTime();

  /**
   * Timestamp (RFC 3339) indicating when the session was last updated.
   *
   * <p>Omitted if no updates were performed on this session.
   *
   * @return updateTime
   */
  Instant getUpdateTime();

  /**
   * Timestamp (RFC 3339) indicating when the session ended.
   *
   * <p>Omitted for ongoing sessions.
   *
   * @return endTime
   */
  Instant getEndTime();

  /**
   * Current state of the session.
   *
   * <p>Field is required
   *
   * @return state
   */
  SessionState getState();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SessionImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param calls see getter
     * @return Current builder
     * @see #getCalls
     */
    Builder setCalls(List<Call> calls);

    /**
     * see getter
     *
     * @param createTime see getter
     * @return Current builder
     * @see #getCreateTime
     */
    Builder setCreateTime(Instant createTime);

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
     * @param endTime see getter
     * @return Current builder
     * @see #getEndTime
     */
    Builder setEndTime(Instant endTime);

    /**
     * see getter
     *
     * @param state see getter
     * @return Current builder
     * @see #getState
     */
    Builder setState(SessionState state);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    Session build();
  }
}
