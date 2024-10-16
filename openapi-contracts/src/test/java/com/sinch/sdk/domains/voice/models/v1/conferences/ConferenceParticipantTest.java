package com.sinch.sdk.domains.voice.models.v1.conferences;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConferenceParticipantTest extends BaseTest {

  @GivenJsonResource("/domains/voice/v1/conferences/ConferenceParticipantDto.json")
  ConferenceParticipant loadedParticipant;

  public static ConferenceParticipant expectedGetConferenceInfoResponseDto =
      ConferenceParticipant.builder()
          .setCli("a cli")
          .setId("an id")
          .setDuration(5)
          .setMuted(true)
          .setOnHold(false)
          .build();

  @Test
  void deserializeGetConferenceInfoResponseDto() {
    TestHelpers.recursiveEquals(loadedParticipant, expectedGetConferenceInfoResponseDto);
  }
}
