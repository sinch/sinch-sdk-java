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
   * Callouts Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  CalloutsService callouts();

  /**
   * Conference Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  ConferencesService conferences();

  /**
   * Calls Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  CallsService calls();

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  ApplicationsService applications();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.0
   */
  WebHooksService webhooks();
}
