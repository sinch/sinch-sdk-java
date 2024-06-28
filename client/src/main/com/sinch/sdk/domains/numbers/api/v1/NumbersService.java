package com.sinch.sdk.domains.numbers.api.v1;

/**
 * Numbers Service
 *
 * @see <a href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/">online
 *     documentation</a>
 * @since TODO NEXT_RELEASE_VERSION
 */
public interface NumbersService {

  /**
   * Available Number Service instance
   *
   * @return service instance for project
   * @since TODO NEXT_RELEASE_VERSION
   */
  AvailableNumberService available();

  /**
   * Available Region Service instance
   *
   * @return service instance for project
   * @since TODO NEXT_RELEASE_VERSION
   */
  AvailableRegionService regions();

  /**
   * Active Number Service instance
   *
   * @return service instance for project
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumberService active();

  /**
   * Callbacks Configuration Service instance
   *
   * @return service instance for project
   * @since TODO NEXT_RELEASE_VERSION
   */
  CallbackConfigurationService callback();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since TODO NEXT_RELEASE_VERSION
   */
  WebHooksService webhooks();
}
