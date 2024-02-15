package com.sinch.sdk.domains.conversation.models;

/** Queue stats */
public interface QueueStats {

  /**
   * The current size of the App's MT queue
   *
   * @return outbound size value
   * @since 1.0
   */
  Long getOutboundSize();

  /**
   * The limit of the App's MT queue. The default limit is 500000 messages
   *
   * @return outbound limit
   * @since 1.0
   */
  Long getOutboundLimit();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.QueueStatsBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see QueueStats#getOutboundSize()
     * @since 1.0
     */
    Builder setOutboundSize(Long value);

    /**
     * see getter
     *
     * @param value see getter
     * @return Current builder
     * @see QueueStats#getOutboundLimit()
     * @since 1.0
     */
    Builder setOutboundLimit(Long value);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    QueueStats build();
  }
}
