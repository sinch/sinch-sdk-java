package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import java.util.Collection;

/**
 * Using the Conferences endpoint, you can perform tasks like retrieving information about an
 * on-going conference, muting or unmuting participants, or removing participants from a conference.
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/voice/api-reference/voice/tag/Conferences">https://developers.sinch.com/docs/voice/api-reference/voice/tag/Conferences</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.ConferencesService} instead.
 */
@Deprecated
public interface ConferencesService {

  /**
   * Calls a phone number or a user to join a conference. When the call is answered, it's connected
   * to a conference room.
   *
   * @param parameters Conference parameters
   * @return The returned call identifier (callId)
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ConferencesService#call(CalloutRequestConference)}
   *     instead.
   */
  @Deprecated
  String call(CalloutRequestParametersConference parameters);

  /**
   * Returns information about a conference that matches the provided conference ID.
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @return The list of participants joined the conference
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.ConferencesService#get(String)}
   *     instead.
   */
  @Deprecated
  Collection<ConferenceParticipant> get(String conferenceId);

  /**
   * Removes all participants from a conference
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.ConferencesService#kickAll(String)}
   *     instead.
   */
  @Deprecated
  void kickAll(String conferenceId);

  /**
   * Remove a specified conference participant from a specified conference
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @param callId The unique identifier of the call. This value is generated by the system
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ConferencesService#kickParticipant(String, String)}
   *     instead.
   */
  @Deprecated
  void kickParticipant(String conferenceId, String callId);

  /**
   * Manages conference participant in a specified conference:
   *
   * @param conferenceId The unique identifier of the conference. The user sets this value.
   * @param callId The unique identifier of the call. This value is generated by the system
   * @param parameters Parameters to manage participant
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ConferencesService#manageParticipant(String, String,
   *     ManageConferenceParticipantRequest)} instead.
   */
  @Deprecated
  void manageParticipant(
      String conferenceId, String callId, ConferenceManageParticipantRequestParameters parameters);
}
