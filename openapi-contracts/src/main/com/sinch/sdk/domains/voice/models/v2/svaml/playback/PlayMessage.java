package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * An audio file playback message item. The platform fetches and plays the audio file at the
 * provided URL on the call.
 */
@JsonDeserialize(builder = PlayMessageImpl.Builder.class)
public interface PlayMessage extends Message {

  /**
   * Get play
   *
   * <p>Field is required
   *
   * @return play
   */
  Play getPlay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new PlayMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param play see getter
     * @return Current builder
     * @see #getPlay
     */
    Builder setPlay(Play play);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    PlayMessage build();
  }
}
