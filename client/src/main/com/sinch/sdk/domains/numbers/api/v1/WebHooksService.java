package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import java.util.Map;

/**
 * Webhooks service
 *
 * <p>Callback events are used to get notified about Numbers usage according to your configured
 * callback URL
 *
 * <p>see <a
 * href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks/#tag/Numbers-Callbacks/operation/ImportedNumberService_EventsCallback">online
 * documentation</a>
 *
 * @since 1.2
 */
public interface WebHooksService {

  /**
   * The Sinch Platform can initiate callback requests to a URL you define (Callback URL) on request
   * and result events. All callback requests are signed using your Application key and secret pair
   * found on your dashboard. The signature is included in the Authorization header of the request
   *
   * <p>By using following function, you can ensure authentication according to received payload
   * from your backend
   *
   * @param secret The HMAC secret used for hashing the callback body using the HMAC-SHA1 algorithm
   *     and for creating the X-Sinch-Signature header.
   * @param headers Received headers
   * @param jsonPayload Received payload
   * @return Is authentication is validated (true) or not (false)
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Numbers-Callbacks/#tag/Numbers-Callbacks">online
   *     documentation</a>
   * @since 1.2.1
   */
  boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload);

  /**
   * This function can be called to deserialize received payload onto callback. Function return Java
   * class instance from un-serialized payload
   *
   * @param jsonPayload Received payload to be un-serialized
   * @return The decoded event notification instance class
   * @since 1.2
   */
  NumberEvent parseEvent(String jsonPayload) throws ApiMappingException;
}
