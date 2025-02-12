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
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.VoiceService#callouts()} instead.
   */
  @Deprecated
  CalloutsService callouts();

  /**
   * Conference Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.VoiceService#conferences()} instead.
   */
  @Deprecated
  ConferencesService conferences();

  /**
   * Calls Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.VoiceService#calls()} instead.
   */
  @Deprecated
  CallsService calls();

  /**
   * Applications Service instance
   *
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.VoiceService#applications()} instead.
   */
  @Deprecated
  ApplicationsService applications();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.VoiceService#webhooks()} instead.
   */
  @Deprecated
  WebHooksService webhooks();
}
