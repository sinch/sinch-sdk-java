package com.sinch.sdk.domains.number_lookup;

/**
 * Number Lookup Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/number-lookup-api-v2">https://developers.sinch.com/docs/number-lookup-api-v2</a>
 * @since 2.1
 */
public interface NumberLookupService {

  /**
   * Number Lookup Service V2
   *
   * @return V2 service instance for project
   * @since 2.1
   */
  com.sinch.sdk.domains.number_lookup.api.v2.NumberLookupService v2();
}
