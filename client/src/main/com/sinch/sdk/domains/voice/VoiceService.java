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
   * Voice Service V1
   *
   * @return V1 service instance for project
   * @see <a href="https://developers.sinch.com/docs/voice">Documentation</a>
   * @since 1.1
   */
  com.sinch.sdk.domains.voice.api.v1.VoiceService v1();

  /**
   * Voice Service V2
   *
   * @return V2 service instance for project
   * @see <a href="https://developers.sinch.com/docs/voice-2.0">Documentation</a>
   * @since 2.3
   */
  com.sinch.sdk.domains.voice.api.v2.VoiceService v2();
}
