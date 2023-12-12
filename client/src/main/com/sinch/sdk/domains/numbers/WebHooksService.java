package com.sinch.sdk.domains.numbers;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;

/**
 * Webhooks service
 *
 * <p>Callback events are used to get notified about Numbers usage according to your configured
 * callback URL
 *
 * <p>see <a
 * href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Callbacks/#tag/Callbacks/operation/ImportedNumberService_EventsCallback</a>
 *
 * @since 1.0
 */
public interface WebHooksService {

  /**
   * This function can be called to deserialize received payload onto callback. Function return Java
   * class instance from un-serialized payload
   *
   * @param jsonPayload Received payload to be un-serialized
   * @return The decoded event notification instance class
   * @since 1.0
   */
  EventNotification unserializeEventNotification(String jsonPayload) throws ApiMappingException;
}
