package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.domains.voice.models.MusicOnHoldType;
import org.junit.jupiter.api.Test;

public class ConferenceManageParticipantRequestParametersTest {

  public static final ConferenceManageParticipantRequestParameters
      conferenceManageParticipantRequestParameters =
          ConferenceManageParticipantRequestParameters.builder()
              .setCommand(ConferenceManageParticipantCommandType.UNMUTE)
              .setMusicOnHold(MusicOnHoldType.RING)
              .build();

  @Test
  void command() {
    assertEquals(
        ConferenceManageParticipantCommandType.UNMUTE,
        conferenceManageParticipantRequestParameters.getCommand().get());
  }

  @Test
  void moh() {
    assertEquals(
        MusicOnHoldType.RING, conferenceManageParticipantRequestParameters.getMusicOnHold().get());
  }
}
