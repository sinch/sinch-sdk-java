package com.sinch.sdk.domains.verification.models.dto.v1.start.request.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartSmsOptions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationStartSmsOptionsTest extends VerificationBaseTest {

  public static VerificationStartSmsOptions startVerificationSmsOptionDto =
      VerificationStartSmsOptions.builder()
          .setExpiry("01:02:03")
          .setCodeType(VerificationStartSmsOptions.CodeTypeEnum.ALPHANUMERIC)
          .setTemplate("My template requires to use '{{CODE}}' placeholder")
          .build();

  public static VerificationStartSmsOptions startVerificationSmsOptionWithAdditionalPropertiesDto =
      VerificationStartSmsOptions.builder()
          .setExpiry("01:02:03")
          .setCodeType(VerificationStartSmsOptions.CodeTypeEnum.ALPHANUMERIC)
          .setTemplate("My template requires to use '{{CODE}}' placeholder")
          .put("a key", "a value")
          .put("secondKey", "second value")
          .build();

  public static VerificationStartSmsOptions startVerificationSmsOptionDtoWithAcceptLanguage =
      VerificationStartSmsOptions.builder()
          .setExpiry("01:02:03")
          .setCodeType(VerificationStartSmsOptions.CodeTypeEnum.ALPHANUMERIC)
          .setTemplate("My template requires to use '{{CODE}}' placeholder")
          .setAcceptLanguage("es-ES")
          .build();

  @GivenTextResource(
      "/domains/verification/v1/start/request/internal/VerificationStartSmsOptionsDto.json")
  String jsonVerificationStartSmsOptions;

  @GivenTextResource(
      "/domains/verification/v1/start/request/internal/VerificationStartSmsOptionsWithAdditionalPropertiesDto.json")
  String jsonVerificationStartSmsOptionsWithAdditionalProperties;

  @Test
  void serializeStartVerificationSmsOptions() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSmsOptionDto);

    JSONAssert.assertEquals(jsonVerificationStartSmsOptions, serializedString, true);
  }

  @Test
  void deserializeStartVerificationSmsOptions() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonVerificationStartSmsOptions, VerificationStartSmsOptions.class);

    TestHelpers.recursiveEquals(startVerificationSmsOptionDto, deserialized);
  }

  @Test
  void serializeStartVerificationSmsOptionsWithAdditionalProperties()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(startVerificationSmsOptionWithAdditionalPropertiesDto);

    JSONAssert.assertEquals(
        jsonVerificationStartSmsOptionsWithAdditionalProperties, serializedString, true);
  }

  @Test
  void deserializeStartVerificationSmsOptionsWithAdditionalProperties()
      throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonVerificationStartSmsOptionsWithAdditionalProperties,
            VerificationStartSmsOptions.class);

    TestHelpers.recursiveEquals(
        deserialized, startVerificationSmsOptionWithAdditionalPropertiesDto);
  }

  @Test
  void serializeStartSmsCallWithAcceptLanguage() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(startVerificationSmsOptionDtoWithAcceptLanguage);
    // acceptLanguage do not have to be serialized
    JSONAssert.assertEquals(jsonVerificationStartSmsOptions, serializedString, true);
  }

  @Test
  void deserializeStartSmsCallWithAcceptLanguage() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonVerificationStartSmsOptions, VerificationStartSmsOptions.class);

    // We are not expecting acceptLanguage to be un-serialized because of not present from body/
    // So this test is based onto startVerificationSmsOptionDto is having same content has the
    // acceptLanguage instance... but without the language
    TestHelpers.recursiveEquals(deserialized, startVerificationSmsOptionDto);
  }
}
