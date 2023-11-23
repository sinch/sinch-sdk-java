package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartVerificationRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/verification/v1/StartVerificationCalloutRequestDto.json")
  String jsonStartVerificationCallout;

  public static InitiateVerificationResourceDto startVerificationCalloutDto =
      new InitiateVerificationResourceDto()
          .method(new InitiateVerificationResourceMethodDto(VerificationMethodDto.CALLOUT))
          .custom("a custom")
          .reference("a reference")
          .identity(
              new InitiateVerificationResourceIdentityDto(
                  new IdentityDto().type("number").endpoint("+endpoint")));

  @GivenTextResource("/domains/verification/v1/StartVerificationFlashCallRequestDto.json")
  String jsonStartVerificationFlashCall;

  public static InitiateVerificationResourceDto startVerificationFlashCallDto =
      new InitiateVerificationResourceDto()
          .method(new InitiateVerificationResourceMethodDto(VerificationMethodDto.FLASHCALL))
          .custom("a custom")
          .reference("a reference")
          .identity(
              new InitiateVerificationResourceIdentityDto(
                  new IdentityDto().type("number").endpoint("+endpoint")))
          .flashCallOptions(
              new InitiateVerificationResourceFlashCallOptionsDto(
                  new FlashcallOptionsDto().dialTimeout(17)));

  @GivenTextResource("/domains/verification/v1/StartVerificationSeamlessRequestDto.json")
  String jsonStartVerificationSeamless;

  public static InitiateVerificationResourceDto startVerificationSeamlessDto =
      new InitiateVerificationResourceDto()
          .method(new InitiateVerificationResourceMethodDto(VerificationMethodDto.SEAMLESS))
          .custom("a custom")
          .reference("a reference")
          .identity(
              new InitiateVerificationResourceIdentityDto(
                  new IdentityDto().type("number").endpoint("+endpoint")));

  @GivenTextResource("/domains/verification/v1/StartVerificationSMSRequestDto.json")
  String jsonStartVerificationSMS;

  public static InitiateVerificationResourceDto startVerificationSMSDto =
      new InitiateVerificationResourceDto()
          .method(new InitiateVerificationResourceMethodDto(VerificationMethodDto.SMS))
          .custom("a custom")
          .reference("a reference")
          .identity(
              new InitiateVerificationResourceIdentityDto(
                  new IdentityDto().type("number").endpoint("+endpoint")));

  @Test
  void serializeStartCallout() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationCalloutDto);

    JSONAssert.assertEquals(jsonStartVerificationCallout, serializedString, true);
  }

  @Test
  void serializeStartFlashCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationFlashCallDto);

    JSONAssert.assertEquals(jsonStartVerificationFlashCall, serializedString, true);
  }

  @Test
  void serializeSeamlessCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSeamlessDto);

    JSONAssert.assertEquals(jsonStartVerificationSeamless, serializedString, true);
  }

  @Test
  void serializeSMSCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(startVerificationSMSDto);

    JSONAssert.assertEquals(jsonStartVerificationSMS, serializedString, true);
  }
}
