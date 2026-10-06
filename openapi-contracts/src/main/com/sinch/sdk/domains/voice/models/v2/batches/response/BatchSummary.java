package com.sinch.sdk.domains.voice.models.v2.batches.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/**
 * Summary of a batch call operation, including counts of call sessions by state and overall
 * progress.
 */
@JsonDeserialize(builder = BatchSummaryImpl.Builder.class)
public interface BatchSummary {

  /**
   * Unique identifier of the batch call operation (ULID).
   *
   * <p>Use this value to retrieve the batch details or stop processing the batch.
   *
   * <p>Field is required
   *
   * @return batchId
   */
  String getBatchId();

  /**
   * Total number of call sessions requested in this batch.
   *
   * <p>Field is required
   *
   * @return sessionCount
   */
  Integer getSessionCount();

  /**
   * Timestamp (RFC 3339) when the batch finished processing (all call sessions reached a final
   * state).
   *
   * <p>Omitted if the batch is still in progress or has not completed yet.
   *
   * @return endTime
   */
  Instant getEndTime();

  /**
   * Number of call sessions that are queued and waiting to be initiated (not yet in progress).
   *
   * <p>Field is required
   *
   * @return queued
   */
  Integer getQueued();

  /**
   * Number of call sessions that are in progress.
   *
   * <p>Field is required
   *
   * @return inProgress
   */
  Integer getInProgress();

  /**
   * Number of call sessions that have completed successfully.
   *
   * <p>Field is required
   *
   * @return completed
   */
  Integer getCompleted();

  /**
   * Number of queued call sessions that were not initiated before the batch TTL ({@link
   * #getTtlSeconds()}) elapsed and therefore expired.
   *
   * <p>Field is required
   *
   * @return expired
   */
  Integer getExpired();

  /**
   * Batch time-to-live (TTL) in seconds. The maximum amount of time the platform will keep
   * attempting to start queued call sessions in this batch.
   *
   * <p>When the TTL expires, any call sessions that have not yet been initiated will stop being
   * processed (calls already in progress are not affected).
   *
   * @return ttlSeconds
   */
  Integer getTtlSeconds();

  /**
   * Requested maximum call initiation rate, in calls per second (CPS), for this batch.
   *
   * <p>Actual CPS may be lower depending on routing, carrier, and platform capacity, as well as
   * account limitations.
   *
   * <p>Field is required
   *
   * @return requestedCps
   */
  Integer getRequestedCps();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BatchSummaryImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param sessionCount see getter
     * @return Current builder
     * @see #getSessionCount
     */
    Builder setSessionCount(Integer sessionCount);

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
     * @param queued see getter
     * @return Current builder
     * @see #getQueued
     */
    Builder setQueued(Integer queued);

    /**
     * see getter
     *
     * @param inProgress see getter
     * @return Current builder
     * @see #getInProgress
     */
    Builder setInProgress(Integer inProgress);

    /**
     * see getter
     *
     * @param completed see getter
     * @return Current builder
     * @see #getCompleted
     */
    Builder setCompleted(Integer completed);

    /**
     * see getter
     *
     * @param expired see getter
     * @return Current builder
     * @see #getExpired
     */
    Builder setExpired(Integer expired);

    /**
     * see getter
     *
     * @param ttlSeconds see getter
     * @return Current builder
     * @see #getTtlSeconds
     */
    Builder setTtlSeconds(Integer ttlSeconds);

    /**
     * see getter
     *
     * @param requestedCps see getter
     * @return Current builder
     * @see #getRequestedCps
     */
    Builder setRequestedCps(Integer requestedCps);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchSummary build();
  }
}
