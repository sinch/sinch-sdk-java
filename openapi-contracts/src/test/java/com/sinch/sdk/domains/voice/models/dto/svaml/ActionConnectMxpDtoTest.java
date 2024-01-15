package com.sinch.sdk.domains.voice.models.dto.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CallHeaderDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationTypeDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectMxpDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectMxpDto.NameEnum;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionConnectMxpDtoTest extends BaseTest {

  public static SvamlActionConnectMxpDto dto =
      new SvamlActionConnectMxpDto()
          .name(NameEnum.CONNECTMXP.getValue())
          .destination(
              new DestinationDto().type(DestinationTypeDto.USERNAME).endpoint("a user string"))
          .callheaders(
              Collections.singletonList(
                  new CallHeaderDto().key("left string").value("right string")));

  @GivenTextResource("/domains/voice/svaml/ActionConnectMxpDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
