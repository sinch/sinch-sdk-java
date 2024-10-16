package com.sinch.sdk.domains.voice.models.v1.applications.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UpdateCallbackUrlsRequestTest extends BaseTest {

  public static Callbacks expected =
      Callbacks.builder()
          .setUrl(
              CallbacksUrl.builder()
                  .setPrimary("https://foo.com")
                  .setFallback("https://fallback.foo.com")
                  .build())
          .build();

  @GivenTextResource("/domains/voice/v1/applications/request/UpdateCallbackUrlsRequestDto.json")
  String jsonRequest;

  @Test
  void serializeRequest() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expected);
    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }
}
