package com.sinch.sdk.domains.conversation.api.v1;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import java.util.Map;

/**
 * Webhooks service
 *
 * <p>The Conversation API delivers contact messages, delivery receipts for app messages and various
 * notifications through callbacks.
 *
 * <p>see <a href="https://developers.sinch.com/docs/conversation/callbacks">online
 * documentation</a>
 *
 * @since _NEXT_VERSION_
 */
public interface WebHooksService {

  /**
   * The Sinch Platform can initiate callback requests to a URL you define (Callback URL) on request
   * and result events. All callback requests are signed and the signature is included in the
   * Authorization header of the request
   *
   * <p>By using following function, you can ensure authentication according to received payload
   * from your backend
   *
   * @param secret Secret token to be used to validate received request. See <a href=
   *     "https://dashboard.sinch.com/convapi/apps">App's webhook configuration onto dashboard</a>
   * @param headers Received headers
   * @param jsonPayload Received payload
   * @return Is authentication is validated (true) or not (false)
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/conversation/callbacks/#validating-callbacks">online
   *     documentation</a>
   * @since _NEXT_VERSION_
   */
  boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload);

  /**
   * This function can be called to deserialize received payload onto callback onto proper java
   * verification event class
   *
   * @param jsonPayload Received payload to be deserialized
   * @return The verification event instance class
   *     <p>see <a
   *     href="https://developers.sinch.com/docs/conversation/callbacks/#webhook-triggers">triggered
   *     events</a>
   * @since _NEXT_VERSION_
   */
  ConversationWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException;
}
