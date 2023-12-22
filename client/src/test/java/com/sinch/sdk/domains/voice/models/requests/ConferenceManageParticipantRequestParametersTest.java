package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConferenceManageParticipantRequestParametersTest {

  public static final ConferenceManageParticipantRequestParameters
      conferenceManageParticipantRequestParameters =
          ConferenceManageParticipantRequestParameters.builder()
              .setCommand(ConferenceManageParticipantCommandType.UNMUTE)
              .setMoh(MohClassType.RING)
              .build();

  @Test
  void command() {
    assertEquals(
        ConferenceManageParticipantCommandType.UNMUTE,
        conferenceManageParticipantRequestParameters.getCommand().get());
  }

  @Test
  void moh() {
    assertEquals(MohClassType.RING, conferenceManageParticipantRequestParameters.getMoh().get());
  }
}
