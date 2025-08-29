package com.sinch.sdk.domains.verification.models.dto.v1.start.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.dto.v1.start.LinkTest;
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseDataImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsAppImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStartResponseTest extends BaseTest {

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponsePhoneCallDto.json")
  VerificationStartResponseInternal loadedStartVerificationPhoneCallDto;

  public static VerificationStartResponseInternalImpl expectedStartVerificationPhoneCallDto =
      new VerificationStartResponseInternalImpl(
          (VerificationStartResponsePhoneCallImpl)
              VerificationStartResponsePhoneCall.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .build());

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseFlashCallDto.json")
  VerificationStartResponseInternal loadedStartVerificationFlashCallDto;

  public static VerificationStartResponseInternalImpl expectedStartVerificationFlashCallDto =
      new VerificationStartResponseInternalImpl(
          (VerificationStartResponseFlashCallImpl)
              VerificationStartResponseFlashCall.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setCliFilter("(.*)5312(.*)")
                  .setInterceptionTimeout(45)
                  .setReportTimeout(75)
                  .setDenyCallAfter(0)
                  .putExtraOption("my key", "my value")
                  .build());

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseDataDto.json")
  VerificationStartResponseInternal loadedStartVerificationDataDto;

  public static VerificationStartResponseInternalImpl expectedStartVerificationDataDto =
      new VerificationStartResponseInternalImpl(
          (VerificationStartResponseDataImpl)
              VerificationStartResponseData.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setTargetUri("target URI")
                  .build());

  @GivenJsonResource("/domains/verification/v1/start/response/VerificationStartResponseSmsDto.json")
  VerificationStartResponseInternal loadedStartVerificationSmsDto;

  public static VerificationStartResponseInternalImpl expectedStartVerificationSmsDto =
      new VerificationStartResponseInternalImpl(
          (VerificationStartResponseSmsImpl)
              VerificationStartResponseSms.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
                  .setInterceptionTimeout(298)
                  .setCodeType(SmsCodeType.NUMERIC)
                  .putExtraOption("my key", "my value")
                  .build());

  @GivenJsonResource(
      "/domains/verification/v1/start/response/VerificationStartResponseWhatsAppDto.json")
  VerificationStartResponseInternal loadedStartVerificationWhatsAppDto;

  public static VerificationStartResponseInternalImpl expectedStartVerificationWhatsAppDto =
      new VerificationStartResponseInternalImpl(
          (VerificationStartResponseWhatsAppImpl)
              VerificationStartResponseWhatsApp.builder()
                  .setId("the id")
                  .setLinks(LinkTest.expectedLinks)
                  .setCodeType(WhatsAppCodeType.NUMERIC)
                  .putExtraOption("my key", "my value")
                  .build());

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
