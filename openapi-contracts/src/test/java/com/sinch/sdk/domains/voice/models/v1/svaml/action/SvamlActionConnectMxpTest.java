package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionConnectMxpTest extends BaseTest {

  public static SvamlActionConnectMxp dto =
      SvamlActionConnectMxp.builder()
          .setDestination(
              Destination.builder()
                  .setType(DestinationType.USERNAME)
                  .setEndpoint("a user string")
                  .build())
          .setCallheaders(
              Collections.singletonList(
                  CallHeader.builder().setKey("left string").setValue("right string").build()))
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionConnectMxpDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
