package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationWebSocket;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionConnectStreamTest extends BaseTest {

  public static SvamlActionConnectStream dto =
      SvamlActionConnectStream.builder()
          .setDestination(DestinationWebSocket.from("wss://yourcompany.com/websocket-server"))
          .setMaxDuration(456)
          .setCallHeaders(
              Collections.singletonList(
                  CallHeader.builder().setKey("left string").setValue("right string").build()))
          .setStreamingOptions(ConnectStreamStreamingOptionsTest.streamingOptions)
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionConnectStreamDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
