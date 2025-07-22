package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;

/**
 * Numbers Service
 *
 * @see <a href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference">online
 *     documentation</a>
 * @since 1.2
 */
public interface NumbersService extends ActiveNumberService, AvailableNumberService {

  /**
   * Activate a new phone number
   *
   * @param phoneNumber Number to be activated
   * @return Activated number See {@link #rent(String, AvailableNumberRentRequest)}.
   * @since 1.7
   */
  ActiveNumber rent(String phoneNumber) throws ApiException;

  /**
   * Available Region Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  AvailableRegionsService regions();

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
