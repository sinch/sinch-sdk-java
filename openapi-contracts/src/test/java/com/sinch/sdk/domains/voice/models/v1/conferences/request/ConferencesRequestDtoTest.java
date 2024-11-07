package com.sinch.sdk.domains.voice.models.v1.conferences.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest.CommandEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConferencesRequestDtoTest extends BaseTest {

  @GivenTextResource(
      "/domains/voice/v1/conferences/request/ConferenceManageParticipantRequestDto.json")
  String jsonConferenceManageParticipantDto;

  public static ManageConferenceParticipantRequest manageConferenceParticipantRequestDto =
      ManageConferenceParticipantRequest.builder()
          .setCommand(CommandEnum.UNMUTE)
          .setMusicOnHold(MusicOnHold.RING)
          .build();

  @Test
  void serializeManageConferenceParticipantRequestDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(manageConferenceParticipantRequestDto);

    JSONAssert.assertEquals(jsonConferenceManageParticipantDto, serializedString, true);
  }
}
