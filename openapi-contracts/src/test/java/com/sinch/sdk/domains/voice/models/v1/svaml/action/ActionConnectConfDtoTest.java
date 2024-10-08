package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectConfConferenceDtmfOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectConfDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectConfDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionConnectConfDtoTest extends BaseTest {

  public static SvamlActionConnectConfDto dto =
      new SvamlActionConnectConfDto()
          .name(NameEnum.CONNECTCONF.getValue())
          .conferenceId("My Conference Id")
          .conferenceDtmfOptions(
              new SvamlActionConnectConfConferenceDtmfOptionsDto()
                  .mode("forward")
                  .maxDigits(45)
                  .timeoutMills(456))
          .moh("music3");

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionConnectConferenceDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
