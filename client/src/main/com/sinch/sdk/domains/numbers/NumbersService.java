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
   * Callbacks Configuraiton Service instance
   *
   * @return service instance for project
   * @since 1.0
   */
  CallbackConfigurationService callback();
}
