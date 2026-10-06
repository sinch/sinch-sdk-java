package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.SessionState;

/** Identifier and current execution state of a call session within a batch. */
@JsonDeserialize(builder = BatchSessionSummaryImpl.Builder.class)
public interface BatchSessionSummary {

  /**
   * Unique identifier of the call session within the batch (ULID). This identifies the session, not
   * an individual call.
   *
   * <p>Use it with <code>/v2/projects/{projectId}/sessions/{sessionId}</code> to retrieve full
   * session details.
   *
   * @return id
   */
  String getId();

  /**
   * Current execution state of the call session.
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
    return new BatchSessionSummaryImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

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
    BatchSessionSummary build();
  }
}
