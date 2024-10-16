package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectPstn.IndicationsEnum;
import com.sinch.sdk.models.DualToneMultiFrequency;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionConnectPstnTest extends BaseTest {

  public static SvamlActionConnectPstn dto =
      SvamlActionConnectPstn.builder()
          .setNumber("+123456789")
          .setLocale("fr")
          .setMaxDuration(123)
          .setDialTimeout(456)
          .setCli("cli value")
          .setSuppressCallbacks(true)
          .setDtmf(DualToneMultiFrequency.valueOf("#w123"))
          .setIndications(IndicationsEnum.from("unknown value"))
          .setAmd(ConnectPstnAnsweringMachineDetection.builder().setEnabled(true).build())
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionConnectPstnDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
