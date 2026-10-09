package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInputDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class DescribeSvamlRequestDtoTest extends BaseTest {

  public static final DescribeSvamlRequest expectedDescribeSvamlRequest =
      DescribeSvamlRequest.builder().setSvaml(SvamlInputDtoTest.expectedSvamlInput).build();

  @GivenTextResource("/domains/voice/v2/svaml/request/DescribeSvamlRequestDto.json")
  String jsonDescribeSvamlRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDescribeSvamlRequest);

    JSONAssert.assertEquals(jsonDescribeSvamlRequest, serializedString, true);
  }
}
