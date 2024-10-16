package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class ManageParticipant extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ManageParticipant.class.getName());

  public ManageParticipant() throws IOException {}

  public static void main(String[] args) {
    try {
      new ManageParticipant().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConferencesService service = client.voice().v1().conferences();

    var command = ManageConferenceParticipantRequest.CommandEnum.MUTE;
    var moh = MusicOnHold.MUSIC1;

    LOGGER.info(
        "Manage participant '%s' for conference '%s'. Setting command to '%s' and moh to '%s'"
            .formatted(callId, conferenceId, command, moh));

    service.manageParticipant(
        conferenceId,
        callId,
        ManageConferenceParticipantRequest.builder()
            .setCommand(command)
            .setMusicOnHold(moh)
            .build());
  }
}
