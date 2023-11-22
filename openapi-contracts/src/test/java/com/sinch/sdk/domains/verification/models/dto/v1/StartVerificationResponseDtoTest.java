package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class StartVerificationResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/StartVerificationCalloutResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationCalloutDto;

  public static InitiateVerificationResponseDto expectedStartVerificationCalloutDto =
      new InitiateVerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.CALLOUT)
          .links(LinksDtoTest.expectedLinks)
          .callout(
              new InitiateVerificationResponseCalloutDto(
                  new CalloutInitiateVerificationResponseDto()));

  @GivenJsonResource("/domains/verification/v1/StartVerificationFlashCallResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationFlashCallDto;

  public static InitiateVerificationResponseDto expectedStartVerificationFlashCallDto =
      new InitiateVerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.FLASHCALL)
          .links(LinksDtoTest.expectedLinks)
          .flashCall(
              new InitiateVerificationResponseFlashCallDto(
                  new FlashCallInitiateVerificationResponseDto()
                      .cliFilter("(.*)5312(.*)")
                      .interceptionTimeout(45)
                      .reportTimeout(75)
                      .denyCallAfter(0)
                      .callId("a call id")));

  @GivenJsonResource("/domains/verification/v1/StartVerificationSeamlessResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationSeamlessDto;

  public static InitiateVerificationResponseDto expectedStartVerificationSeamlessDto =
      new InitiateVerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.SEAMLESS)
          .links(LinksDtoTest.expectedLinks)
          .seamless(
              new InitiateVerificationResponseSeamlessDto(
                  new SeamlessInitiateVerificationResponseDto().targetUri("target URI")));

  @GivenJsonResource("/domains/verification/v1/StartVerificationSMSResponseDto.json")
  InitiateVerificationResponseDto loadedStartVerificationSMSDto;

  public static InitiateVerificationResponseDto expectedStartVerificationSMSDto =
      new InitiateVerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.SMS)
          .links(LinksDtoTest.expectedLinks)
          .sms(
              new InitiateVerificationResponseSmsDto(
                  new SmsInitiateVerificationResponseDto()
                      .template("Your verification code is {{CODE}}. Verified by Sinch")
                      .interceptionTimeout(298)));

  @Test
  void deserializeStartCallout() {
    Assertions.assertThat(loadedStartVerificationCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationCalloutDto);
  }

  @Test
  void deserializeStartFlashCall() {
    Assertions.assertThat(loadedStartVerificationFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallDto);
  }

  @Test
  void deserializeStartSeamless() {
    Assertions.assertThat(loadedStartVerificationSeamlessDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSeamlessDto);
  }

  @Test
  void deserializeSMS() {
    Assertions.assertThat(loadedStartVerificationSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSMSDto);
  }
}
