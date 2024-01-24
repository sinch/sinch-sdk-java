package com.sinch.sdk.domains.voice;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import java.util.Map;

/**
 * Webhooks service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/</a>
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
   * @param method The HTTP method used ot handle the callback
   * @param path The path to you backend endpoint used for callback
   * @param headers Received headers
   * @param jsonPayload Received payload
   * @return Is authentication is validated (true) or not (false)
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/voice/api-reference/authentication/callback-signed-request">https://developers.sinch.com/docs/voice/api-reference/authentication/callback-signed-request/</a>
   * @since 1.0
   */
  boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload);

  /**
   * This function can be called to deserialize received payload onto callback onto proper java
   * Voice event class
   *
   * @param jsonPayload Received payload to be deserialized
   * @return The Voice event instance class
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/</a>
   * @since 1.0
   */
  WebhooksEvent unserializeWebhooksEvent(String jsonPayload) throws ApiMappingException;

  /**
   * This function can be called to serialize a Voice response to be sent as JSON
   *
   * @param response The response to be serialized
   * @return The JSON string to be sent
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callbacks/</a>
   * @since 1.0
   */
  String serializeWebhooksResponse(SVAMLControl response) throws ApiMappingException;
}
