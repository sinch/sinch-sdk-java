package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConferencesRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/ConferenceManageParticipantRequestDto.json")
  String jsonConferenceManageParticipantDto;

  public static ManageConferenceParticipantRequestDto manageConferenceParticipantRequestDto =
      new ManageConferenceParticipantRequestDto().command("unmute").moh("ring");

  @Test
  void serializeManageConferenceParticipantRequestDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(manageConferenceParticipantRequestDto);

    JSONAssert.assertEquals(jsonConferenceManageParticipantDto, serializedString, true);
  }
}
