package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Routes the call through the Voice Relay service, enabling real-time speech-to-text (STT) and
 * text-to-speech (TTS) via a WebSocket connection to the application backend.
 */
@JsonDeserialize(builder = VoiceRelayImpl.Builder.class)
public interface VoiceRelay extends CallDestination {

  /**
   * Get voiceRelay
   *
   * <p>Field is required
   *
   * @return voiceRelay
   */
  VoiceRelayDetails getVoiceRelay();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceRelayImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param voiceRelay see getter
     * @return Current builder
     * @see #getVoiceRelay
     */
    Builder setVoiceRelay(VoiceRelayDetails voiceRelay);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceRelay build();
  }
}
