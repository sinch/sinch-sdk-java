package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import com.sinch.sdk.domains.verification.models.dto.v1.StartStartVerificationResponseDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.StartVerificationRequestDtoTest;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificationsDtoConverterTest extends BaseTest {

  public static StartVerificationRequestParameters startVerificationCalloutRequest =
      StartVerificationRequestParameters.builder(VerificationMethod.CALLOUT)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();

  public static StartVerificationResponseCallout expectedStartVerificationCalloutResponse =
      StartVerificationResponseCallout.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .build();

  public static StartVerificationRequestParameters startVerificationFlashCallRequest =
      StartVerificationFlashCallRequestParameters.builder()
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setDialTimeOut(17)
          .build();
  public static StartVerificationResponseFlashCall expectedStartVerificationFlashCallResponse =
      StartVerificationResponseFlashCall.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setCliFilter("(.*)5312(.*)")
          .setInterceptionTimeOut(45)
          .setReportTimeout(75)
          .setDenyCallAfter(0)
          .build();
  public static StartVerificationRequestParameters startVerificationSeamlessRequest =
      StartVerificationRequestParameters.builder(VerificationMethod.SEAMLESS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSeamless expectedStartVerificationSeamlessResponse =
      StartVerificationResponseSeamless.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTargetUri("target URI")
          .build();
  public static StartVerificationRequestParameters startVerificationSMSRequest =
      StartVerificationRequestParameters.builder(VerificationMethod.SMS)
          .setCustom("a custom")
          .setReference("a reference")
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSMS expectedStartVerificationSMSResponse =
      StartVerificationResponseSMS.builder()
          .setId("the id")
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
          .setInterceptionTimeOut(298)
          .build();

  @Test
  void convertStartCalloutRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationCalloutRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationCalloutDto);
  }

  @Test
  void convertStartFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationFlashCallDto);
  }

  @Test
  void convertStartSeamlessRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSeamlessRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationSeamlessDto);
  }

  @Test
  void convertStartSMSRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSMSRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestDtoTest.startVerificationSMSDto);
  }

  @Test
  void convertStartCalloutResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartStartVerificationResponseDtoTest.expectedStartVerificationCalloutDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationCalloutResponse);
  }

  @Test
  void convertStartFlashCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartStartVerificationResponseDtoTest.expectedStartVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallResponse);
  }

  @Test
  void convertStartSeamlessResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartStartVerificationResponseDtoTest.expectedStartVerificationSeamlessDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSeamlessResponse);
  }

  @Test
  void convertStartSMSResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartStartVerificationResponseDtoTest.expectedStartVerificationSMSDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSMSResponse);
  }
}
