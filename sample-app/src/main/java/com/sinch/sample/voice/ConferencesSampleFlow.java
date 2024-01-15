package com.sinch.sample.voice;

import static com.sinch.sample.BaseApplication.CONFERENCE_ID;
import static com.sinch.sample.BaseApplication.PHONE_NUMBER_KEY;
import static com.sinch.sample.Utils.echo;
import static com.sinch.sample.Utils.echoStep;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantCommandType;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.E164PhoneNumber;
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
          null != System.getenv(CONFERENCE_ID)
              ? System.getenv(CONFERENCE_ID)
              : properties.getProperty(CONFERENCE_ID);
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

    int step = 0;

    // 1. Joining conference
    var callId = joinConference(++step, sinch, conferenceId, phoneNumber);

    // 2. Waiting for participant to join the conference (trying during 1 minute)
    waitForParticipant(++step, sinch, conferenceId, callId);

    // 3. Get participant information
    getCallInformation(++step, sinch, conferenceId, callId);

    // 4. Mute participant
    muteParticipant(++step, sinch, conferenceId, callId);
    Thread.sleep(3000);

    // 5. Get conference information
    getConferenceInfo(++step, sinch, conferenceId);

    // 6. Get participant information
    getCallInformation(++step, sinch, conferenceId, callId);

    // 7. Kick all participants
    kickAllParticipants(++step, sinch, conferenceId);
    Thread.sleep(3000);

    // 8. Get participant information
    getCallInformation(++step, sinch, conferenceId, callId);

    // 9. Get conference information
    getConferenceInfo(++step, sinch, conferenceId);
  }

  String joinConference(
      int step, SinchClient sinchClient, String conferenceId, String phoneNumber) {

    echoStep(
        step, "Join conference '%s' for phone number '%s'".formatted(conferenceId, phoneNumber));

    // 1. Build the request payload
    var payload =
        CalloutRequestParametersConference.builder()
            .setConferenceId(conferenceId)
            .setDestination(DestinationNumber.valueOf(phoneNumber))
            .setGreeting("Hello from Sinch Conference sample with Jav SDK")
            .setMohClass(MohClassType.MUSIC1)
            .setCli(E164PhoneNumber.valueOf("+1123456789"))
            .build();

    // 2. Perform the request
    var response = sinchClient.voice().conferences().call(payload);

    echo("The callId for conference is '%s'\n".formatted(response));

    // return the callId
    return response;
  }

  void waitForParticipant(int step, SinchClient sinchClient, String conferenceId, String callId)
      throws InterruptedException {

    echoStep(step, "Waiting for participant to join the conference'");

    // Waiting for participant to join the conference (trying during 1 minute)
    Optional<ConferenceParticipant> participant = Optional.empty();
    for (int i = 0; i < 12 && participant.isEmpty(); i++) {
      // Pause for 5 seconds
      Thread.sleep(5000);
      echo("Attempt: '%d'\n".formatted(i + 1));

      // Get conference info
      var participants = getConferenceInfo(++step, sinchClient, conferenceId);
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
      int step, SinchClient sinchClient, String conferenceId) {

    echoStep(step, "Getting information for conference '%s'".formatted(conferenceId));

    // 1. Request for conference information
    Collection<ConferenceParticipant> response = Collections.emptyList();
    try {
      response = sinchClient.voice().conferences().get(conferenceId);
    } catch (ApiException e) {
      // NOP
    }
    // 2. return the phone number
    echo("Conference participants are:");
    response.stream().iterator().forEachRemaining(f -> echo("- %s".formatted(f)));

    return response;
  }

  void getCallInformation(int step, SinchClient sinchClient, String conferenceId, String callId) {

    echoStep(step, "Get call information for participant '%s'".formatted(callId));

    var response = sinchClient.voice().calls().get(callId);

    echo("Call information: %s".formatted(response));
  }

  void muteParticipant(int step, SinchClient sinchClient, String conferenceId, String callId) {

    echoStep(step, "Muting participant '%s'".formatted(callId));

    var payload =
        ConferenceManageParticipantRequestParameters.builder()
            .setCommand(ConferenceManageParticipantCommandType.MUTE)
            .build();

    sinchClient.voice().conferences().manageParticipant(conferenceId, callId, payload);

    echo("Conference participants muted\n");
  }

  void kickAllParticipants(int step, SinchClient sinchClient, String conferenceId) {

    echoStep(step, "Kicking all participants");
    sinchClient.voice().conferences().kickAll(conferenceId);

    echo("Done\n");
  }
}
