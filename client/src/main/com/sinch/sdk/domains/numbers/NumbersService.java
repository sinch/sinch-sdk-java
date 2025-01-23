package com.sinch.sdk.domains.numbers;

/**
 * Numbers Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers">https://developers.sinch.com/docs/numbers</a>
 * @since 1.0
 */
public interface NumbersService {

  /**
   * Numbers Service V1
   *
   * @return V1 service instance for project
   * @see <a
   *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/">Documentation</a>
   * @since 1.2
   */
  com.sinch.sdk.domains.numbers.api.v1.NumbersService v1();

  /**
   * Non versioned Available Number Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.numbers.api.v1.NumbersService}
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService} instead.
   */
  @Deprecated
  AvailableNumberService available();

  /**
   * Non versioned Available Region Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService}
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#regions()} instead.
   */
  @Deprecated
  AvailableRegionService regions();

  /**
   * Non versioned Active Number Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.numbers.api.v1.NumbersService}
   * @return service instance for project
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService} instead.
   * @since 1.0
   */
  @Deprecated
  ActiveNumberService active();

  /**
   * Non versioned Callbacks Configuration Service instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService}
   * @return service instance for project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#callback()} instead.
   */
  @Deprecated
  CallbackConfigurationService callback();

  /**
   * Non versioned Webhooks helpers instance
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.numbers.api.v1.WebHooksService}
   * @return instance service related to webhooks helpers
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#webhooks()} instead.
   */
  @Deprecated
  WebHooksService webhooks();
}
