package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Calls are handled dynamically by sending Sinch Events to the configured event destination. The
 * backend responds with SVAML commands that control the call flow in real time.
 *
 * <p>Sent on the wire as the <code>WEBHOOK</code> call behavior.
 */
@JsonDeserialize(builder = EventDestinationCallBehaviorImpl.Builder.class)
public interface EventDestinationCallBehavior extends CallBehavior {

  /**
   * Event destination receiving the Sinch Events.
   *
   * <p>Field is required
   *
   * @return eventDestination
   */
  EventDestinationConfiguration getEventDestination();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new EventDestinationCallBehaviorImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param eventDestination see getter
     * @return Current builder
     * @see #getEventDestination
     */
    Builder setEventDestination(EventDestinationConfiguration eventDestination);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    EventDestinationCallBehavior build();
  }
}
