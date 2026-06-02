package com.sinch.sdk.domains.number_lookup.api.v2;

/**
 * Number Lookup Service V2
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/number-lookup-api-v2">https://developers.sinch.com/docs/number-lookup-api-v2</a>
 * @since 2.1
 */
public interface NumberLookupService {

  /**
   * Number Lookup Service instance
   *
   * @return service instance for project
   * @since 2.1
   */
  NumberLookupV2Service lookup();
}
