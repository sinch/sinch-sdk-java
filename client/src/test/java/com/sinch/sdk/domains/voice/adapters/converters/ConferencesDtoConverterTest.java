package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParametersTest;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.ConferencesResponseDtoTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConferencesDtoConverterTest {

  public static Collection<ConferenceParticipant> expectedConferenceGetInfoResponse =
      new ArrayList<>(
          Collections.singletonList(
              ConferenceParticipant.builder()
                  .setCli("a cli")
                  .setId("an id")
                  .setDuration(5)
                  .setMuted(true)
                  .setOnhold(false)
                  .build()));

  @Test
  void convertGetConferenceInfoResponseDto() {
    Assertions.assertThat(
            ConferencesDtoConverter.convert(
                ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedConferenceGetInfoResponse);
  }

  @Test
  void testConferenceManageParticipantRequestParameters() {
    Assertions.assertThat(
            ConferencesDtoConverter.convert(
                ConferenceManageParticipantRequestParametersTest
                    .conferenceManageParticipantRequestParameters))
        .usingRecursiveComparison()
        .isEqualTo(ConferencesRequestDtoTest.manageConferenceParticipantRequestDto);
  }
}
