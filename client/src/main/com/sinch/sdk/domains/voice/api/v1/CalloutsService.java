package com.sinch.sdk.domains.voice.api.v1;

import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;

/**
 * A callout is a call made to a phone number or app using the API.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Callouts</a>
 * @since 1.4
 */
public interface CalloutsService {

  /**
   * The text-to-speech callout calls a phone number and plays a synthesized text messages or
   * pre-recorded sound files.
   *
   * @param parameters Text to speech parameters
   * @return The returned call identifier (callId)
   * @since 1.4
   */
  String textToSpeech(CalloutRequestTTS parameters);

  /**
   * The conference callout calls a phone number or a user. When the call is answered, it's
   * connected to a conference room.
   *
   * @param parameters Conference parameters
   * @return The returned call identifier (callId)
   * @since 1.4
   */
  String conference(CalloutRequestConference parameters);

  /**
   * The custom callout, the server initiates a call from the servers that can be controlled by
   * specifying how the call should progress at each call event.
   *
   * @param parameters Custom parameters
   * @return The returned call identifier (callId)
   * @since 1.4
   */
  String custom(CalloutRequestCustom parameters);

  /**
   * Makes a call out to a phone number. The types of callouts currently supported are conference
   * callouts, text-to-speech callouts, and custom callouts. The custom callout is the most
   * flexible, but text-to-speech and conference callouts are more convenient.
   *
   * @param parameters Callout type to be performed
   * @return The returned call identifier (callId)
   * @since 1.4
   */
  String call(CalloutRequest parameters);
}
