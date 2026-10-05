package com.sinch.sdk.domains.voice.models.v2.batches.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Options for batch dialing */
@JsonDeserialize(builder = BatchOptionsImpl.Builder.class)
public interface BatchOptions {

  /**
   * Requested maximum call initiation rate, in calls per second (CPS), for this batch.
   *
   * <p>Actual CPS may be lower depending on routing, carrier, and platform capacity, as well as
   * account limitations. minimum: 1 maximum: 1000
   *
   * @return maxCps
   */
  Integer getMaxCps();

  /**
   * Batch time-to-live (TTL). The maximum amount of time the platform will keep attempting to start
   * queued call sessions in this batch.
   *
   * <p>When the TTL expires, any call sessions that have not yet been initiated will stop being
   * processed (calls already in progress are not affected). minimum: 1 maximum: 10800
   *
   * @return ttlSeconds
   */
  Integer getTtlSeconds();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new BatchOptionsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param maxCps see getter
     * @return Current builder
     * @see #getMaxCps
     */
    Builder setMaxCps(Integer maxCps);

    /**
     * see getter
     *
     * @param ttlSeconds see getter
     * @return Current builder
     * @see #getTtlSeconds
     */
    Builder setTtlSeconds(Integer ttlSeconds);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    BatchOptions build();
  }
}
