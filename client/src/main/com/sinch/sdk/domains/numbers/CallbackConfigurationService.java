package com.sinch.sdk.domains.numbers;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;

/**
 * Callback Configuration Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/</a>
 * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService}
 *     instead.
 */
@Deprecated
public interface CallbackConfigurationService {

  /**
   * Get callbacks configuration
   *
   * @return callbacks configuration for the project
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService#get()}
   *     instead.
   */
  @Deprecated
  CallbackConfiguration get() throws ApiException;

  /**
   * Update callbacks configuration
   *
   * @param parameters Parameters to be updated
   * @return Updated callbacks configuration
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService#update(CallbackConfigurationUpdateRequest)}
   *     instead.
   */
  @Deprecated
  CallbackConfiguration update(CallbackConfigurationUpdateRequestParameters parameters)
      throws ApiException;
}
