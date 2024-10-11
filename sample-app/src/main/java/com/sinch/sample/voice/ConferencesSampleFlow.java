package com.sinch.sample.voice;

import static com.sinch.sample.BaseApplication.CONFERENCE_ID_KEY;
import static com.sinch.sample.BaseApplication.PHONE_NUMBER_KEY;
import static com.sinch.sample.Utils.echo;
import static com.sinch.sample.Utils.echoStep;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest.CommandEnum;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;

public class ConferencesSampleFlow {

  private static final Logger LOGGER =
      Utils.initializeLogger(ConferencesSampleFlow.class.getName());

  public static void main(String[] args) {

    try {
      var properties = Utils.loadProperties(LOGGER);
      var configuration = Utils.loadConfiguration(LOGGER);
      var conferenceId =
          null != System.getenv(CONFERENCE_ID_KEY)
              ? System.getenv(CONFERENCE_ID_KEY)
              : properties.getProperty(CONFERENCE_ID_KEY);
      var phoneNumber =
          null != System.getenv(PHONE_NUMBER_KEY)
              ? System.getenv(PHONE_NUMBER_KEY)
              : properties.getProperty(PHONE_NUMBER_KEY);
      new ConferencesSampleFlow().run(configuration, conferenceId, phoneNumber);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      System.exit(-1);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void run(Configuration configuration, String conferenceId, String phoneNumber)
      throws InterruptedException {

    SinchClient sinch = new SinchClient(configuration);

    ConferencesService service = sinch.voice().v1().conferences();
    CallsService callsService = sinch.voice().v1().calls();

    int step = 0;

    // 1. Joining conference
    var callId = joinConference(++step, service, conferenceId, phoneNumber);

    // 2. Waiting for participant to join the conference (trying during 1 minute)
    waitForParticipant(++step, service, conferenceId, callId);

    // 3. Get participant information
    getCallInformation(++step, callsService, callId);

    // 4. Mute participant
    muteParticipant(++step, service, conferenceId, callId);
    Thread.sleep(3000);

    // 5. Get conference information
    getConferenceInfo(++step, service, conferenceId);

    // 6. Get participant information
    getCallInformation(++step, callsService, callId);

    // 7. Kick all participants
    kickAllParticipants(++step, service, conferenceId);
    Thread.sleep(3000);

    // 8. Get participant information
    getCallInformation(++step, callsService, callId);

    // 9. Get conference information
    getConferenceInfo(++step, service, conferenceId);
  }

  String joinConference(
      int step, ConferencesService service, String conferenceId, String phoneNumber) {

    echoStep(
        step, "Join conference '%s' for phone number '%s'".formatted(conferenceId, phoneNumber));

    // 1. Build the request payload
    var payload =
        CalloutRequestConference.builder()
            .setConferenceId(conferenceId)
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint(phoneNumber)
                    .build())
            .setGreeting("Hello from Sinch Conference sample with Jav SDK")
            .setMusicOnHold(MusicOnHold.MUSIC1)
            .setCli("+1123456789")
            .build();

    // 2. Perform the request
    var response = service.call(payload);

    echo("The callId for conference is '%s'\n".formatted(response));

    // return the callId
    return response;
  }

  void waitForParticipant(int step, ConferencesService service, String conferenceId, String callId)
      throws InterruptedException {

    echoStep(step, "Waiting for participant to join the conference'");

    // Waiting for participant to join the conference (trying during 1 minute)
    Optional<ConferenceParticipant> participant = Optional.empty();
    for (int i = 0; i < 12 && participant.isEmpty(); i++) {
      // Pause for 5 seconds
      Thread.sleep(5000);
      echo("Attempt: '%d'\n".formatted(i + 1));

      // Get conference info
      var participants = getConferenceInfo(++step, service, conferenceId);
      //  Looking for participant
      participant = participants.stream().filter(f -> f.getId().equals(callId)).findFirst();
    }

    // Looking for participant
    var found =
        participant.orElseThrow(
            () ->
                new ApiException(
                    "Participant with callId '%s' did not joined the conference"
                        .formatted(callId)));
    echo("Participant joined the conference: '%s'\n".formatted(found));
  }

  Collection<ConferenceParticipant> getConferenceInfo(
      int step, ConferencesService service, String conferenceId) {

    echoStep(step, "Getting information for conference '%s'".formatted(conferenceId));

    // 1. Request for conference information
    Collection<ConferenceParticipant> list = Collections.emptyList();
    try {
      GetConferenceInfoResponse response = service.get(conferenceId);
      list = response.getParticipants();
    } catch (ApiException e) {
      // NOP
    }
    // 2. return the phone number
    echo("Conference participants are:");
    list.stream().iterator().forEachRemaining(f -> echo("- %s".formatted(f)));

    return list;
  }

  void getCallInformation(int step, CallsService service, String callId) {

    echoStep(step, "Get call information for participant '%s'".formatted(callId));

    var response = service.get(callId);

    echo("Call information: %s".formatted(response));
  }

  void muteParticipant(int step, ConferencesService service, String conferenceId, String callId) {

    echoStep(step, "Muting participant '%s'".formatted(callId));

    var payload = ManageConferenceParticipantRequest.builder().setCommand(CommandEnum.MUTE).build();

    service.manageParticipant(conferenceId, callId, payload);

    echo("Conference participants muted\n");
  }

  void kickAllParticipants(int step, ConferencesService service, String conferenceId) {

    echoStep(step, "Kicking all participants");
    service.kickAll(conferenceId);

    echo("Done\n");
  }
}
