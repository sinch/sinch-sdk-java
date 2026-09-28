package com.sinch.sdk.domains.voice.models.v2.svaml.amd;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * AMD (Answering Machine Detection) command to detect what answered the call. Possible outcomes
 * are: human, machine, beep, or unknown.
 *
 * <p>This is a non-blocking command — the next command in the sequence executes immediately while
 * detection runs in parallel. Results are delivered via the <code>events</code> property.
 */
@JsonDeserialize(builder = AmdCommandImpl.Builder.class)
public interface AmdCommand extends SvamlCommand {

  /**
   * SVAML commands to execute based on the answering machine detection result. These events define
   * different call flows depending on whether a human, machine, beep, or unknown entity answers the
   * call.
   *
   * @return events
   */
  AmdEvents getEvents();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AmdCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param events see getter
     * @return Current builder
     * @see #getEvents
     */
    Builder setEvents(AmdEvents events);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AmdCommand build();
  }
}
