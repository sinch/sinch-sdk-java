package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;

/**
 * Callback Configuration Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/#numberscallback-endpoint-category">online
 *     documentation</a>
 * @since 1.2
 */
public interface CallbackConfigurationService {

  /**
   * Get callbacks configuration
   *
   * @return callbacks configuration for the project
   * @since 1.2
   */
  CallbackConfigurationResponse get() throws ApiException;

  /**
   * Update callbacks configuration
   *
   * @param parameters Parameters to be updated
   * @return Updated callbacks configuration
   * @since 1.2
   */
  CallbackConfigurationResponse update(CallbackConfigurationUpdateRequest parameters)
      throws ApiException;
}
