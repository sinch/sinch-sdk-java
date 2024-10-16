package com.sinch.sdk.domains.voice.models.v1.conferences.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipantTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConferencesResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/voice/v1/conferences/response/ConferenceGetResponseDto.json")
  GetConferenceInfoResponse loadedGetConferenceInfoResponseDto;

  public static GetConferenceInfoResponse expectedGetConferenceInfoResponseDto =
      GetConferenceInfoResponse.builder()
          .setParticipants(
              Arrays.asList(ConferenceParticipantTest.expectedGetConferenceInfoResponseDto))
          .build();

  @Test
  void deserializeGetConferenceInfoResponseDto() {
    TestHelpers.recursiveEquals(
        loadedGetConferenceInfoResponseDto, expectedGetConferenceInfoResponseDto);
  }
}
