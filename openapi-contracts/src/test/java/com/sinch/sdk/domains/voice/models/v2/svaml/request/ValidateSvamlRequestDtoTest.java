package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInputDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.request.ValidateSvamlRequest.ValidationTypeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ValidateSvamlRequestDtoTest extends BaseTest {

  public static final ValidateSvamlRequest expectedValidateSvamlRequest =
      ValidateSvamlRequest.builder()
          .setSvaml(SvamlInputDtoTest.expectedSvamlInput)
          .setValidationType(ValidationTypeEnum.STRICT)
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/request/ValidateSvamlRequestDto.json")
  String jsonValidateSvamlRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedValidateSvamlRequest);

    JSONAssert.assertEquals(jsonValidateSvamlRequest, serializedString, true);
  }
}
