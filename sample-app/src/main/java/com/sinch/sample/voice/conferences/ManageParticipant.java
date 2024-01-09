package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.MohClassType;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantCommandType;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
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

    String callId = "e429ecbb-6057-4756-8148-2b498f968136";

    var command = ConferenceManageParticipantCommandType.MUTE;
    var moh = MohClassType.MUSIC1;

    LOGGER.info(
        "Manage participant '%s' for conference '%s'. Setting command to '%s' and moh to '%s'"
            .formatted(callId, conferenceId, command, moh));

    client
        .voice()
        .conferences()
        .manageParticipant(
            conferenceId,
            callId,
            ConferenceManageParticipantRequestParameters.builder()
                .setCommand(command)
                .setMoh(moh)
                .build());
  }
}
