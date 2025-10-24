package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConnectStreamStreamingOptionsTest extends BaseTest {

  public static ConnectStreamStreamingOptions streamingOptions =
      ConnectStreamStreamingOptions.builder().setVersion(2).setSampleRate(16000).build();

  @GivenTextResource("/domains/voice/v1/svaml/action/ConnectStreamStreamingOptionsDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(streamingOptions);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
