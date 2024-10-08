package com.sinch.sdk.domains.voice.models.v1.applications;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CallbacksDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CallbacksUrlDto;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ApplicationsCallbackUrlsDtoTest extends BaseTest {

  public static CallbacksDto expected =
      new CallbacksDto()
          .url(
              new CallbacksUrlDto()
                  .primary("https://foo.com")
                  .fallback("https://fallback.foo.com"));

  @GivenJsonResource("/domains/voice/v1/applications/ApplicationsGetCallbackUrlsResponseDto.json")
  CallbacksDto loaded;

  @GivenTextResource("/domains/voice/v1/applications/ApplicationsGetCallbackUrlsRequestDto.json")
  String jsonRequest;

  @Test
  void serializeResponse() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expected);
    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }

  @Test
  void deserializeResponse() {
    Assertions.assertThat(loaded).usingRecursiveComparison().isEqualTo(expected);
  }
}
