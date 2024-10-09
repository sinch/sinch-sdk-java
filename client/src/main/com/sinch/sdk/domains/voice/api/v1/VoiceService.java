package com.sinch.sdk.domains.voice.api.v1;

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
   * @since 1.4
   */
  CalloutsService callouts();

  /**
   * Conference Service instance
   *
   * @return service instance for project
   * @since 1.4
   */
  ConferencesService conferences();

  /**
   * Calls Service instance
   *
   * @return service instance for project
   * @since 1.4
   */
  CallsService calls();

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since 1.4
   */
  // ApplicationsService applications();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.4
   */
  // WebHooksService webhooks();
}
