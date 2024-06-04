package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseInternalTest;
import com.sinch.sdk.domains.verification.models.requests.SMSCodeType;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutSpeechOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificationsDtoConverterTest extends BaseTest {

  public static StartVerificationCalloutRequestParameters startVerificationPhoneCallRequest =
      StartVerificationCalloutRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setOptions(
              StartVerificationCalloutOptions.builder()
                  .setSpeech(
                      StartVerificationCalloutSpeechOptions.builder().setLocale("fr-FR").build())
                  .build())
          .build();

  public static StartVerificationResponseCallout expectedStartVerificationPhoneCallResponse =
      StartVerificationResponseCallout.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .build();

  public static StartVerificationFlashCallRequestParameters startVerificationFlashCallRequest =
      StartVerificationFlashCallRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setDialTimeOut(17)
          .build();
  public static StartVerificationResponseFlashCall expectedStartVerificationFlashCallResponse =
      StartVerificationResponseFlashCall.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setCliFilter("(.*)5312(.*)")
          .setInterceptionTimeOut(45)
          .setReportTimeout(75)
          .setDenyCallAfter(0)
          .build();
  public static StartVerificationSeamlessRequestParameters startVerificationDataRequest =
      StartVerificationSeamlessRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .build();
  public static StartVerificationResponseSeamless expectedStartVerificationDataResponse =
      StartVerificationResponseSeamless.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTargetUri("target URI")
          .build();
  public static StartVerificationSMSRequestParameters startVerificationSmsRequest =
      StartVerificationSMSRequestParameters.builder()
          .setCustom("a custom")
          .setReference(VerificationReference.valueOf("a reference"))
          .setIdentity(NumberIdentity.builder().setEndpoint("+endpoint").build())
          .setOptions(
              StartVerificationSMSOptions.builder()
                  .setExpiry("01:02:03")
                  .setCodeType(SMSCodeType.ALPHANUMERIC)
                  .setTemplate("My template require to use '{{CODE}}' code")
                  .build())
          .build();
  public static StartVerificationResponseSMS expectedStartVerificationSmsResponse =
      StartVerificationResponseSMS.builder()
          .setId(VerificationId.valueOf("the id"))
          .setLinks(LinkDtoConverterTest.linksClient)
          .setTemplate("Your verification code is {{CODE}}. Verified by Sinch")
          .setInterceptionTimeOut(298)
          .build();

  @Test
  void convertStartPhoneCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationPhoneCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationPhoneCallDto);
  }

  @Test
  void convertStartFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationFlashCallDto);
  }

  @Test
  void convertStartDataRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationDataRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationDataDto);
  }

  @Test
  void convertStartSmsRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(startVerificationSmsRequest))
        .usingRecursiveComparison()
        .isEqualTo(StartVerificationRequestTest.startVerificationSmsDto);
  }

  @Test
  void convertStartPhoneCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationPhoneCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationPhoneCallResponse);
  }

  @Test
  void convertStartFlashCallResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationFlashCallResponse);
  }

  @Test
  void convertStartDataResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationDataDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationDataResponse);
  }

  @Test
  void convertStartSmsResponse() {

    Assertions.assertThat(
            VerificationsDtoConverter.convert(
                StartVerificationResponseTest.expectedStartVerificationSmsDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedStartVerificationSmsResponse);
  }

  public static VerificationReportCalloutRequestParameters verificationReportPhoneCallRequest =
      VerificationReportCalloutRequestParameters.builder().setCode("foo code").build();

  public static VerificationStatusCallout expectedVerificationStatusPhoneCallResponse =
      VerificationStatusCallout.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setCallComplete(true)
          .setReference(VerificationReference.valueOf("my reference"))
          .setVerificationPrice(
              Price.builder()
                  .setCurrencyId("verificationPrice currency id")
                  .setAmount(3.141516F)
                  .build())
          .setTerminationPrice(
              Price.builder()
                  .setCurrencyId("terminationPrice currency id")
                  .setAmount(6.626070F)
                  .build())
          .setBillableDuration(34)
          .build();

  @Test
  void convertReportPhoneCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportPhoneCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportPhoneCallDto);
  }

  @Test
  void convertStatusPhoneCallResponse() {

    Assertions.assertThat(
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationPhoneCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationStatusPhoneCallResponse);
  }

  public static VerificationReportFlashCallRequestParameters verificationReportFlashCallRequest =
      VerificationReportFlashCallRequestParameters.builder().setCli("foo cli").build();

  public static VerificationStatusFlashCall expectedVerificationStatusFlashCallResponse =
      VerificationStatusFlashCall.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setReference(VerificationReference.valueOf("my reference"))
          .setSource(VerificationSourceType.MANUAL)
          .setVerificationPrice(
              Price.builder()
                  .setCurrencyId("verificationPrice currency id")
                  .setAmount(3.141516F)
                  .build())
          .setTerminationPrice(
              Price.builder()
                  .setCurrencyId("terminationPrice currency id")
                  .setAmount(6.626070F)
                  .build())
          .setBillableDuration(34)
          .build();

  @Test
  void convertReportFlashCallRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportFlashCallRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportFlashCallDto);
  }

  @Test
  void convertStatusFlashCallResponse() {

    Assertions.assertThat(
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationFlashCallDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationStatusFlashCallResponse);
  }

  public static VerificationReportSMSRequestParameters verificationReportSmsRequest =
      VerificationReportSMSRequestParameters.builder()
          .setCode("foo code")
          .setCli("foo cli")
          .build();

  public static VerificationStatusSMS expectedVerificationStatusSmsResponse =
      VerificationStatusSMS.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .setReason(VerificationStatusReasonType.FRAUD)
          .setReference(VerificationReference.valueOf("my reference"))
          .setIdentity(NumberIdentity.valueOf("endpoint value"))
          .setCountryId("es-ES")
          .setVerificationTimeStamp(Instant.parse("2024-05-22T09:38:59.559043700Z"))
          .setSource(VerificationSourceType.INTERCEPTED)
          .setVerificationPrice(
              Price.builder()
                  .setCurrencyId("verificationPrice currency id")
                  .setAmount(3.141516F)
                  .build())
          .build();

  @Test
  void convertReportSmsRequest() {

    Assertions.assertThat(VerificationsDtoConverter.convert(verificationReportSmsRequest))
        .usingRecursiveComparison()
        .isEqualTo(VerificationReportRequestDtoTest.verificationReportSmsDto);
  }

  @Test
  void convertStatusSmsResponse() {

    Assertions.assertThat(
            StatusDtoConverter.convert(
                VerificationStatusResponseInternalTest.expectedVerificationSmsDto))
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationStatusSmsResponse);
  }
}
