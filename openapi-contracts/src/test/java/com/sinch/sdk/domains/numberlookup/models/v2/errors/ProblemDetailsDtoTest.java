package com.sinch.sdk.domains.numberlookup.models.v2.errors;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ProblemDetailsDtoTest extends BaseTest {

  public static ProblemDetails problemDetailsDto =
      ProblemDetails.builder()
          .setType("https://developers.sinch.com/docs/lookup/api/errors/validation")
          .setTitle("Validation error")
          .setStatus(400)
          .setTraceId("84c1fd4063c38d9f3900d06e56542d48")
          .build();

  @GivenTextResource("/domains/numberlookup/v2/errors/ProblemDetailsDto.json")
  String jsonProblemDetailsDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(problemDetailsDto);

    JSONAssert.assertEquals(jsonProblemDetailsDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    ProblemDetails deserialized =
        objectMapper.readValue(jsonProblemDetailsDto, ProblemDetails.class);

    TestHelpers.recursiveEquals(deserialized, problemDetailsDto);
  }
}
