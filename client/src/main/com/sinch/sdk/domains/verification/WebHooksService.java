package com.sinch.sdk.domains.verification;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import java.util.Map;

/**
 * Webhooks service
 *
 * <p>Callback events are used to authorize and manage your verification requests and return
 * verification results.
 *
 * <p>see <a
 * href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationRequestEvent/post</a>
 *
 * @since 1.0
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
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.WebHooksService#validateAuthenticationHeader(String,
   *     String, Map, String)}
   * @param method The HTTP method used ot handle the callback
   * @param path The path to you backend endpoint used for callback
   * @param headers Received headers
   * @param jsonPayload Received payload
   * @return Is authentication is validated (true) or not (false)
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/authentication/callback-signed-request">https://developers.sinch.com/docs/verification/api-reference/authentication/callback-signed-request</a>
   * @since 1.0
   */
  boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload);

  /**
   * This function can be called to deserialize received payload onto callback onto proper java
   * verification event class
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.WebHooksService#parseEvent(String)}
   * @param jsonPayload Received payload to be deserialized
   * @return The verification event instance class
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/</a>
   * @since 1.0
   */
  VerificationEvent parseEvent(String jsonPayload) throws ApiMappingException;

  /**
   * This function can be called to serialize a verification response to be sent as JSON
   *
   * @apiNote This version is no longer updated, to get updates use V1 version: {@link
   *     com.sinch.sdk.domains.verification.api.v1.WebHooksService#serializeResponse(VerificationRequestEventResponse)}
   * @param response The response to be serialized
   * @return The JSON string to be sent
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/</a>
   * @since 1.0
   */
  String serializeResponse(VerificationResponse response) throws ApiMappingException;
}
