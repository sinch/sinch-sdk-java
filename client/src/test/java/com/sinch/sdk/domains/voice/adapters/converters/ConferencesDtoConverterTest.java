package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.dto.v1.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.ConferencesResponseDtoTest;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParametersTest;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConferencesDtoConverterTest {

  public static Collection<ConferenceParticipant> expectedConferenceGetInfoResponse =
      Collections.singletonList(
          ConferenceParticipant.builder()
              .setCli("a cli")
              .setId("an id")
              .setDuration(5)
              .setMuted(true)
              .setOnhold(false)
              .build());

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
