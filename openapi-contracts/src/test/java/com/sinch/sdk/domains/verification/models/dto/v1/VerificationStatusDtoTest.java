package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStatusDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/VerificationStatusCalloutResponseDto.json")
  VerificationResponseDto loadedVerificationCalloutDto;

  public static VerificationResponseDto expectedVerificationCalloutDto =
      new VerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.CALLOUT)
          .status("FAIL")
          .reason("Fraud")
          .callComplete(true)
          .reference("my reference")
          .price(
              new VerificationResponsePriceDto(
                  new VerificationPriceInformationDto()
                      .verificationPrice(
                          new VerificationPriceInformationVerificationPriceDto(
                              new MoneyDto()
                                  .currencyId("verificationPrice currency id")
                                  .amount(3.141516F)))
                      .terminationPrice(
                          new VerificationPriceInformationTerminationPriceDto(
                              new MoneyDto()
                                  .currencyId("terminationPrice currency id")
                                  .amount(6.626070F)))
                      .billableDuration(34)));

  @GivenJsonResource("/domains/verification/v1/VerificationStatusFlashCallResponseDto.json")
  VerificationResponseDto loadedVerificationFlashCallDto;

  public static VerificationResponseDto expectedVerificationFlashCallDto =
      new VerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.FLASHCALL)
          .status("FAIL")
          .reason("Fraud")
          .reference("my reference")
          .source("manual");

  @GivenJsonResource("/domains/verification/v1/VerificationStatusSMSResponseDto.json")
  VerificationResponseDto loadedVerificationSMSDto;

  public static VerificationResponseDto expectedVerificationSMSDto =
      new VerificationResponseDto()
          .id("the id")
          .method(VerificationMethodDto.SMS)
          .status("FAIL")
          .reason("Fraud")
          .reference("my reference")
          .source("intercepted")
          .price(
              new VerificationResponsePriceDto(
                  new VerificationPriceInformationDto()
                      .verificationPrice(
                          new VerificationPriceInformationVerificationPriceDto(
                              new MoneyDto()
                                  .currencyId("verificationPrice currency id")
                                  .amount(3.141516F)))));

  @Test
  void deserializeCallout() {
    Assertions.assertThat(loadedVerificationCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationCalloutDto);
  }

  @Test
  void deserializeFlashCall() {
    Assertions.assertThat(loadedVerificationFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationFlashCallDto);
  }

  @Test
  void deserializeSMS() {
    Assertions.assertThat(loadedVerificationSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationSMSDto);
  }
}
