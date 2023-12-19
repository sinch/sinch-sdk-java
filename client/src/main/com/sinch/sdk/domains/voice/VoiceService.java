package com.sinch.sdk.domains.voice;

/**
 * Voice service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/">https://developers.sinch.com/docs/voice/</a>
 * @since 1.0
 */
public interface VoiceService {

  /**
   * Callouts Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  CalloutsService callouts();
}
