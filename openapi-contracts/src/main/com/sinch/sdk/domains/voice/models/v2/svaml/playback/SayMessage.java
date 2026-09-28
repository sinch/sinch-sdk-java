package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A text-to-speech (TTS) message item. The platform synthesizes the provided text into speech and
 * plays it on the call.
 */
@JsonDeserialize(builder = SayMessageImpl.Builder.class)
public interface SayMessage extends Message {

  /**
   * Get say
   *
   * <p>Field is required
   *
   * @return say
   */
  Say getSay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SayMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param say see getter
     * @return Current builder
     * @see #getSay
     */
    Builder setSay(Say say);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SayMessage build();
  }
}
