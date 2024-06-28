package com.sinch.sdk.domains.numbers;

/**
 * Numbers Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/">https://developers.sinch.com/docs/numbers/api-reference/</a>
 * @since 1.0
 */
public interface NumbersService {

  /**
   * Numbers Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/">Documentation</a>
   * @since TODO NEXT_RELEASE_VERSION
   */
  com.sinch.sdk.domains.numbers.api.v1.NumbersService v1();

  /**
   * Available Number Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  AvailableNumberService available();

  /**
   * Available Region Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  AvailableRegionService regions();

  /**
   * Active Number Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  ActiveNumberService active();

  /**
   * Callbacks Configuration Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  CallbackConfigurationService callback();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.0
   */
  WebHooksService webhooks();
}
