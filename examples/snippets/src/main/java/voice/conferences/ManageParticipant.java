/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package voice.conferences;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class ManageParticipant {

  private static final Logger LOGGER = Logger.getLogger(ManageParticipant.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The ID of the conference to manage a participant in
    String conferenceId = "CONFERENCE_ID";
    // The Call ID of the participant to manage in the conference
    String callId = "CALL_ID";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ConferencesService conferencesService = client.voice().v1().conferences();

    ManageConferenceParticipantRequest.CommandEnum command =
        ManageConferenceParticipantRequest.CommandEnum.MUTE;
    MusicOnHold moh = MusicOnHold.MUSIC1;

    LOGGER.info(
        String.format(
            "Manage participant with ID '%s' for conference with ID '%s'. Setting command to '%s'"
                + " and music on hold to '%s'",
            callId, conferenceId, command, moh));

    ManageConferenceParticipantRequest request =
        ManageConferenceParticipantRequest.builder()
            .setCommand(command)
            .setMusicOnHold(moh)
            .build();

    conferencesService.manageParticipant(conferenceId, callId, request);

    LOGGER.info("Done");
  }
}
