package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectSip.TransportEnum;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionConnectSipTest extends BaseTest {

  public static SvamlActionConnectSip dto =
      SvamlActionConnectSip.builder()
          .setDestination(
              Destination.builder()
                  .setType(DestinationType.SIP)
                  .setEndpoint("a sip string")
                  .build())
          .setMaxDuration(456)
          .setCli("a cli value")
          .setTransport(TransportEnum.TLS)
          .setSuppressCallbacks(true)
          .setCallHeaders(
              Collections.singletonList(
                  CallHeader.builder().setKey("left string").setValue("right string").build()))
          .setMusicOnHold(MusicOnHold.MUSIC2)
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionConnectSipDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
