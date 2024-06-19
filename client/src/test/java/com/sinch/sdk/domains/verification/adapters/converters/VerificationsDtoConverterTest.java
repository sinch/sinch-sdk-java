package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.VerificationStartRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.VerificationStartResponseTest;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseTest;
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

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(startVerificationPhoneCallRequest),
        VerificationStartRequestTest.startVerificationPhoneCallDto
            .getVerificationStartRequestPhoneCallImpl());
  }

  @Test
  void convertStartFlashCallRequest() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(startVerificationFlashCallRequest),
        VerificationStartRequestTest.startVerificationFlashCallDto
            .getVerificationStartRequestFlashCallImpl());
  }

  @Test
  void convertStartDataRequest() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(startVerificationDataRequest),
        VerificationStartRequestTest.startVerificationDataDto
            .getVerificationStartRequestDataImpl());
  }

  @Test
  void convertStartSmsRequest() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(startVerificationSmsRequest),
        VerificationStartRequestTest.startVerificationSmsDto.getVerificationStartRequestSmsImpl());
  }

  @Test
  void convertStartPhoneCallResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationStartResponseTest.expectedStartVerificationPhoneCallDto
                .getVerificationStartResponsePhoneCallImpl()),
        expectedStartVerificationPhoneCallResponse);
  }

  @Test
  void convertStartFlashCallResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationStartResponseTest.expectedStartVerificationFlashCallDto
                .getVerificationStartResponseFlashCallImpl()),
        expectedStartVerificationFlashCallResponse);
  }

  @Test
  void convertStartDataResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationStartResponseTest.expectedStartVerificationDataDto
                .getVerificationStartResponseDataImpl()),
        expectedStartVerificationDataResponse);
  }

  @Test
  void convertStartSmsResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationStartResponseTest.expectedStartVerificationSmsDto
                .getVerificationStartResponseSmsImpl()),
        expectedStartVerificationSmsResponse);
  }

  public static VerificationReportCalloutRequestParameters verificationReportPhoneCallRequest =
      VerificationReportCalloutRequestParameters.builder().setCode("foo code").build();

  public static VerificationReportCallout expectedVerificationReportPhoneCallResponse =
      VerificationReportCallout.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .build();

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

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(verificationReportPhoneCallRequest),
        VerificationReportRequestDtoTest.verificationReportPhoneCallDto
            .getVerificationReportRequestPhoneCallImpl());
  }

  @Test
  void convertReportPhoneCallResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationReportResponseDtoTest.verificationReportPhoneCallDto
                .getVerificationReportResponsePhoneCallImpl()),
        expectedVerificationReportPhoneCallResponse);
  }

  @Test
  void convertStatusPhoneCallResponse() {

    TestHelpers.recursiveEquals(
        StatusDtoConverter.convert(
            VerificationStatusResponseTest.expectedVerificationPhoneCallDto
                .getVerificationStatusResponsePhoneCallImpl()),
        expectedVerificationStatusPhoneCallResponse);
  }

  public static VerificationReportFlashCallRequestParameters verificationReportFlashCallRequest =
      VerificationReportFlashCallRequestParameters.builder().setCli("foo cli").build();

  public static VerificationReportFlashCall expectedVerificationReportFlashCallResponse =
      VerificationReportFlashCall.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
          .build();
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

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(verificationReportFlashCallRequest),
        VerificationReportRequestDtoTest.verificationReportFlashCallDto
            .getVerificationReportRequestFlashCallImpl());
  }

  @Test
  void convertReportFlashCallResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationReportResponseDtoTest.verificationReportFlashCallDto
                .getVerificationReportResponseFlashCallImpl()),
        expectedVerificationReportFlashCallResponse);
  }

  @Test
  void convertStatusFlashCallResponse() {

    TestHelpers.recursiveEquals(
        StatusDtoConverter.convert(
            VerificationStatusResponseTest.expectedVerificationFlashCallDto
                .getVerificationStatusResponseFlashCallImpl()),
        expectedVerificationStatusFlashCallResponse);
  }

  public static VerificationReportSMSRequestParameters verificationReportSmsRequest =
      VerificationReportSMSRequestParameters.builder()
          .setCode("foo code")
          .setCli("foo cli")
          .build();

  public static VerificationReportSMS expectedVerificationReportSmsResponse =
      VerificationReportSMS.builder()
          .setId(VerificationId.valueOf("the id"))
          .setStatus(VerificationStatusType.FAIL)
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

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(verificationReportSmsRequest),
        VerificationReportRequestDtoTest.verificationReportSmsDto
            .getVerificationReportRequestSmsImpl());
  }

  @Test
  void convertReportSmsResponse() {

    TestHelpers.recursiveEquals(
        VerificationsDtoConverter.convert(
            VerificationReportResponseDtoTest.verificationReportSmsDto
                .getVerificationReportResponseSmsImpl()),
        expectedVerificationReportSmsResponse);
  }

  @Test
  void convertStatusSmsResponse() {

    TestHelpers.recursiveEquals(
        StatusDtoConverter.convert(
            VerificationStatusResponseTest.expectedVerificationSmsDto
                .getVerificationStatusResponseSmsImpl()),
        expectedVerificationStatusSmsResponse);
  }
}
