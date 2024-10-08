package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CallHeaderDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationDto;
import com.sinch.sdk.domains.voice.models.dto.v1.DestinationTypeDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectSipDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectSipDto.NameEnum;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionConnectSipDtoTest extends BaseTest {

  public static SvamlActionConnectSipDto dto =
      new SvamlActionConnectSipDto()
          .name(NameEnum.CONNECTSIP.getValue())
          .destination(new DestinationDto().type(DestinationTypeDto.SIP).endpoint("a sip string"))
          .maxDuration(456)
          .cli("a cli value")
          .transport("TLS")
          .suppressCallbacks(true)
          .callHeaders(
              Collections.singletonList(
                  new CallHeaderDto().key("left string").value("right string")))
          .moh("music2");

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionConnectSipDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
