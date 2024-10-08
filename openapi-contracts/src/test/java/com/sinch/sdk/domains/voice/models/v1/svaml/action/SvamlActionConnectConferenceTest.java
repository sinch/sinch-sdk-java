package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions.ModeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionConnectConferenceTest extends BaseTest {

  public static SvamlActionConnectConference dto =
      SvamlActionConnectConference.builder()
          .setConferenceId("My Conference Id")
          .setConferenceDtmfOptions(
              ConferenceDtmfOptions.builder()
                  .setMode(ModeEnum.FORWARD)
                  .setMaxDigits(45)
                  .setTimeoutMills(456)
                  .build())
          .setMoh(MusicOnHold.MUSIC3)
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionConnectConferenceDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
