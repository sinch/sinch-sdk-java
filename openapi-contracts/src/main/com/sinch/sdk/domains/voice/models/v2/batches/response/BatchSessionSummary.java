package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.SessionState;
import java.util.Map;

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
   * Plain key-value set of parameters from the {@link
   * com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest#getParameters()
   * parameters} entry that was used to initiate this call session.
   *
   * @return parameters
   */
  Map<String, String> getParameters();

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
     * see getter
     *
     * @param parameters see getter
     * @return Current builder
     * @see #getParameters
     */
    Builder setParameters(Map<String, String> parameters);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchSessionSummary build();
  }
}
