package com.sinch.sdk.domains.voice.api.v2;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Map;

/**
 * Sinch Events service
 *
 * <p>Helpers to handle, from your backend, the Sinch Events sent by the Voice Platform: validate
 * their signature, parse their payload, and serialize the SVAML document to respond with.
 *
 * <p>This service requires no credentials from the client configuration: the service credentials
 * used to validate a Sinch Event are given on each call.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice-2.0">https://developers.sinch.com/docs/voice-2.0</a>
 * @since 2.3
 */
public interface SinchEventsService {

  /**
   * The Voice Platform signs every Sinch Event request with the secret of the service the event
   * belongs to. The signature is carried in the <code>Authorization</code> header, using the <code>
   * service</code> scheme: <code>Authorization: service &lt;serviceId&gt;:&lt;signature&gt;</code>
   *
   * <p>By using following function, you can ensure authentication according to received payload
   * from your backend. The request is rejected when:
   *
   * <ul>
   *   <li>the <code>Authorization</code> or the <code>x-timestamp</code> header is missing
   *   <li>the scheme is not <code>service</code>
   *   <li>the service ID in the header differs from <code>serviceId</code>
   *   <li>the signature does not match the one computed from the received request
   * </ul>
   *
   * <p><b>Replay protection is the caller's responsibility</b>: this function does not check the
   * <code>x-timestamp</code> header against the current time. Reject requests whose <code>
   * x-timestamp</code> lies outside the clock-skew window your application accepts.
   *
   * @param serviceId The ID of the service the Sinch Event belongs to
   * @param serviceSecret The secret of the service, as issued (Base64 encoded)
   * @param method The HTTP method used to handle the Sinch Event (always <code>POST</code> for
   *     Voice Platform requests)
   * @param path The path to your backend endpoint used for the Sinch Event (scheme, host, query
   *     string and fragment are not part of the signature)
   * @param headers Received headers
   * @param jsonPayload Received payload, exactly as delivered (before any parsing or
   *     re-serialization)
   * @return Is authentication validated (true) or not (false)
   * @throws IllegalArgumentException if <code>serviceId</code> or <code>serviceSecret</code> is
   *     empty, or if <code>serviceSecret</code> is not valid Base64
   * @since 2.3
   */
  boolean validateAuthenticationHeader(
      String serviceId,
      String serviceSecret,
      String method,
      String path,
      Map<String, String> headers,
      String jsonPayload);

  /**
   * This function can be called to deserialize received payload onto Voice Sinch Event class
   *
   * <p>CloudEvents headers (<code>ce-*</code>) are not part of the returned event.
   *
   * <p>Custom events, triggered by the {@link
   * com.sinch.sdk.domains.voice.models.v2.svaml.customevents.CustomEventCommand}, are sent by the
   * API as <code>call.webhook.&lt;name&gt;</code> and returned as <code>
   * call.customEvent.&lt;name&gt;</code>.
   *
   * @param jsonPayload Received payload to be deserialized
   * @return The Voice Sinch Event
   * @throws ApiMappingException if the payload cannot be deserialized
   * @since 2.3
   */
  VoiceSinchEvent parseEvent(String jsonPayload) throws ApiMappingException;

  /**
   * This function can be called to serialize the SVAML document to be sent in response to a Sinch
   * Event
   *
   * @param response The response to be serialized
   * @return The JSON string to be sent
   * @throws ApiMappingException if the response cannot be serialized
   * @since 2.3
   */
  String serializeResponse(SvamlInput response) throws ApiMappingException;
}
