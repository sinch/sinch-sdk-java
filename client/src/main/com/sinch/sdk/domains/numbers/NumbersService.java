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
}
