package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Delays execution of the next command in the sequence for a specified duration. This is a blocking
 * command — no further commands execute until the pause completes.
 *
 * <p>The pause does not affect call audio; the call remains connected and audio continues
 * uninterrupted.
 */
@JsonDeserialize(builder = PauseCommandImpl.Builder.class)
public interface PauseCommand extends SvamlCommand {

  /**
   * Duration of the pause in milliseconds.
   *
   * <p>Field is required
   *
   * @return durationMilliseconds
   */
  Integer getDurationMilliseconds();

  /**
   * Create a pause command of the given duration
   *
   * @param durationMilliseconds see {@link #getDurationMilliseconds()}
   * @return A new PauseCommand
   */
  static PauseCommand of(int durationMilliseconds) {
    return builder().setDurationMilliseconds(durationMilliseconds).build();
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PauseCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param durationMilliseconds see getter
     * @return Current builder
     * @see #getDurationMilliseconds
     */
    Builder setDurationMilliseconds(Integer durationMilliseconds);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PauseCommand build();
  }
}
