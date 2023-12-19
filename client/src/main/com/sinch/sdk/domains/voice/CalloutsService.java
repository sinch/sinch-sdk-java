package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;

/**
 * A callout is a call made to a phone number or app using the API.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts</a>
 * @since 1.0
 */
public interface CalloutsService {

  /**
   * Makes a call out to a phone number. The types of callouts currently supported are conference
   * callouts, text-to-speech callouts, and custom callouts. The custom callout is the most
   * flexible, but text-to-speech and conference callouts are more convenient.
   *
   * @param parameters Callout type to be performed
   * @return The returned call identifier
   * @since 1.0
   */
  String call(CalloutRequestParameters parameters);
}
