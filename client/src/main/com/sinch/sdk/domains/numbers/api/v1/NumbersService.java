package com.sinch.sdk.domains.numbers.api.v1;

/**
 * Numbers Service
 *
 * @see <a href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference">online
 *     documentation</a>
 * @since 1.2
 */
public interface NumbersService {

  /**
   * Available Number Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  AvailableNumberService available();

  /**
   * Available Region Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  AvailableRegionService regions();

  /**
   * Active Number Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  ActiveNumberService active();

  /**
   * Callbacks Configuration Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  CallbackConfigurationService callback();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.2
   */
  WebHooksService webhooks();
}
