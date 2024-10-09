package com.sinch.sdk.domains.voice.api.v1;

import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;

/**
 * Using the Conferences endpoint, you can perform tasks like retrieving information about an
 * on-going conference, muting or unmuting participants, or removing participants from a conference.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Conferences">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Conferences</a>
 * @since 1.4
 */
public interface ConferencesService {

  /**
   * Calls a phone number or a user to join a conference. When the call is answered, it's connected
   * to a conference room.
   *
   * @param parameters Conference parameters
   * @return The returned call identifier (callId)
   * @since 1.4
   */
  String call(CalloutRequestConference parameters);

  /**
   * Returns information about a conference that matches the provided conference ID.
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @return The list of participants joined the conference
   * @since 1.4
   */
  GetConferenceInfoResponse get(String conferenceId);

  /**
   * Removes all participants from a conference
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @since 1.4
   */
  void kickAll(String conferenceId);

  /**
   * Remove a specified conference participant from a specified conference
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @param callId The unique identifier of the call. This value is generated by the system
   * @since 1.4
   */
  void kickParticipant(String conferenceId, String callId);

  /**
   * Manages conference participant in a specified conference:
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @param callId The unique identifier of the call. This value is generated by the system
   * @param parameters Parameters to manage participant
   * @since 1.4
   */
  void manageParticipant(
      String conferenceId, String callId, ManageConferenceParticipant parameters);
}
