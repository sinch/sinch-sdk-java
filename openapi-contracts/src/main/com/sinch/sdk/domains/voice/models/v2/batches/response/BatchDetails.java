package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/**
 * Detailed per-session view of a batch call operation. Contains one entry for each call session in
 * the batch, including the session identifier and its current execution state.
 */
@JsonDeserialize(builder = BatchDetailsImpl.Builder.class)
public interface BatchDetails {

  /**
   * Per-session details for the batch.
   *
   * <p><code>EXPIRED</code> sessions are never returned because they were never initiated.
   *
   * <p>Field is required
   *
   * @return sessions
   */
  List<BatchSessionSummary> getSessions();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BatchDetailsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param sessions see getter
     * @return Current builder
     * @see #getSessions
     */
    Builder setSessions(List<BatchSessionSummary> sessions);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchDetails build();
  }
}
