package com.sinch.sdk.domains.voice.api.v2;

/**
 * Voice Service V2
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice-2.0">https://developers.sinch.com/docs/voice-2.0</a>
 * @since 2.3
 */
public interface VoiceService {

  /**
   * Calls Service instance
   *
   * @return service instance for project
   * @since 2.3
   */
  CallsService calls();

  /**
   * Batches Service instance
   *
   * @return service instance for project
   * @since 2.3
   */
  BatchesService batches();

  /**
   * Sessions Service instance
   *
   * @return service instance for project
   * @since 2.3
   */
  SessionsService sessions();
}
