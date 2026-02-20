package com.sinch.sdk.domains.verification.models.dto.v1.start.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.LinkTest;
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsApp;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStartResponseTest extends VerificationBaseTest {

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponsePhoneCallDto.json")
  VerificationStartResponse loadedStartVerificationPhoneCallDto;

  public static VerificationStartResponse expectedStartVerificationPhoneCallDto =
      VerificationStartResponsePhoneCall.builder()
          .setId("the id")
          .setLinks(LinkTest.expectedLinks)
          .build();

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseFlashCallDto.json")
  VerificationStartResponse loadedStartVerificationFlashCallDto;

  public static VerificationStartResponse expectedStartVerificationFlashCallDto =
      VerificationStartResponseFlashCall.builder()
          .setId("the id")
          .setLinks(LinkTest.expectedLinks)
          .setCliFilter("(.*)5312(.*)")
          .setInterceptionTimeout(45)
          .setReportTimeout(75)
          .setDenyCallAfter(0)
          .putExtraOption("my key", "my value")
          .build();

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseDataDto.json")
  VerificationStartResponse loadedStartVerificationDataDto;

  public static VerificationStartResponse expectedStartVerificationDataDto =
      VerificationStartResponseData.builder()
          .setId("the id")
          .setLinks(LinkTest.expectedLinks)
          .setTargetUri("target URI")
          .build();

  @GivenJsonResource("/domains/verification/v1/start/response/VerificationStartResponseSmsDto.json")
  VerificationStartResponse loadedStartVerificationSmsDto;

  public static VerificationStartResponse expectedStartVerificationSmsDto =
      VerificationStartResponseSms.builder()
          .setId("the id")
          .setLinks(LinkTest.expectedLinks)
          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
          .setInterceptionTimeout(298)
          .setCodeType(SmsCodeType.NUMERIC)
          .putExtraOption("my key", "my value")
          .build();

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseWhatsAppDto.json")
  VerificationStartResponse loadedStartVerificationWhatsAppDto;

  public static VerificationStartResponse expectedStartVerificationWhatsAppDto =
      VerificationStartResponseWhatsApp.builder()
          .setId("the id")
          .setLinks(LinkTest.expectedLinks)
          .setCodeType(WhatsAppCodeType.NUMERIC)
          .putExtraOption("my key", "my value")
          .build();

  @Test
  void deserializeStartPhoneCall() {
    TestHelpers.recursiveEquals(
        loadedStartVerificationPhoneCallDto, expectedStartVerificationPhoneCallDto);
  }

  @Test
  void deserializeStartFlashCall() {
    TestHelpers.recursiveEquals(
        loadedStartVerificationFlashCallDto, expectedStartVerificationFlashCallDto);
  }

  @Test
  void deserializeStartData() {
    TestHelpers.recursiveEquals(loadedStartVerificationDataDto, expectedStartVerificationDataDto);
  }

  @Test
  void deserializeStartSms() {
    TestHelpers.recursiveEquals(loadedStartVerificationSmsDto, expectedStartVerificationSmsDto);
  }

  @Test
  void deserializeStartWhatsApp() {
    TestHelpers.recursiveEquals(
        loadedStartVerificationWhatsAppDto, expectedStartVerificationWhatsAppDto);
  }
}
