package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

/**
 * Routes the call through the Voice Relay service, enabling real-time speech-to-text (STT) and
 * text-to-speech (TTS) via a WebSocket connection to the application backend.
 */
@JsonDeserialize(builder = VoiceRelayImpl.Builder.class)
public interface VoiceRelay extends CallDestination {

  /**
   * URL to the server that will accept the web-socket request
   *
   * <p>Field is required
   *
   * @return endpoint
   */
  String getEndpoint();

  /**
   * Allow "barge-in" during text-to-speech (TTS) playback.
   *
   * <p>When <code>true</code>, TTS playback is interrupted as soon as inbound speech is detected,
   * unless the currently playing content is marked as uninterruptible.
   *
   * <p>When <code>false</code>, TTS playback continues uninterrupted, but an interruption signal is
   * still sent over the WebSocket so the client application can choose to stop playback manually if
   * needed.
   *
   * @return enableInterruptions
   */
  Boolean getEnableInterruptions();

  /**
   * Name of the voice to be used when synthesizing speech.
   *
   * <p>This is the default voice used, if no override voice is provided in the web-socket TTS
   * message.
   *
   * <p>Supported voices include: Emma, Brian, and others. For a complete list of available voices
   * and their characteristics, see the Text-to-Speech Voices documentation.
   *
   * <p>Field is required
   *
   * @return ttsVoice
   */
  String getTtsVoice();

  /**
   * BCP-47 language tag used for speech-to-text transcription of the inbound audio.
   *
   * <p>This value determines which language model is used for transcription.
   *
   * <p>Field is required
   *
   * @return sttLanguage
   */
  String getSttLanguage();

  /**
   * Custom headers to be sent in the call setup.
   *
   * @return callHeaders
   */
  List<CallHeader> getCallHeaders();

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
     * @param endpoint see getter
     * @return Current builder
     * @see #getEndpoint
     */
    Builder setEndpoint(String endpoint);

    /**
     * see getter
     *
     * @param enableInterruptions see getter
     * @return Current builder
     * @see #getEnableInterruptions
     */
    Builder setEnableInterruptions(Boolean enableInterruptions);

    /**
     * see getter
     *
     * @param ttsVoice see getter
     * @return Current builder
     * @see #getTtsVoice
     */
    Builder setTtsVoice(String ttsVoice);

    /**
     * see getter
     *
     * @param sttLanguage see getter
     * @return Current builder
     * @see #getSttLanguage
     */
    Builder setSttLanguage(String sttLanguage);

    /**
     * see getter
     *
     * @param callHeaders see getter
     * @return Current builder
     * @see #getCallHeaders
     */
    Builder setCallHeaders(List<CallHeader> callHeaders);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceRelay build();
  }
}
