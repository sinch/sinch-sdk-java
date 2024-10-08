package com.sinch.sdk.domains.voice.models.v1.applications;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.UpdateNumbersDto;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ApplicationsUpdateNumberRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/applications/ApplicationsUpdateNumbersRequestDto.json")
  String jsonRequest;

  public static UpdateNumbersDto updateNumbersDto =
      new UpdateNumbersDto()
          .numbers(Arrays.asList("+12073091712"))
          .applicationkey("an app key")
          .capability("voice");

  @Test
  void serializeUpdateNumbersDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(updateNumbersDto);

    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }
}
