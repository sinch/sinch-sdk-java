package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConferencesResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/voice/v1/ConferenceGetResponseDto.json")
  GetConferenceInfoResponseDto loadedGetConferenceInfoResponseDto;

  public static GetConferenceInfoResponseDto expectedGetConferenceInfoResponseDto =
      new GetConferenceInfoResponseDto()
          .addParticipantsItem(
              new GetConferenceInfoResponseParticipantsInnerDto()
                  .cli("a cli")
                  .id("an id")
                  .duration(5)
                  .muted(true)
                  .onhold(false));

  @Test
  void deserializeGetConferenceInfoResponseDto() {
    Assertions.assertThat(loadedGetConferenceInfoResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedGetConferenceInfoResponseDto);
  }
}
