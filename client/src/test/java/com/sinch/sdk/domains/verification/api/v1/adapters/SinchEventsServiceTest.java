package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.SinchEventsService;
import com.sinch.sdk.domains.verification.models.dto.v1.sinchevents.VerificationRequestEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.sinchevents.VerificationResponseEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.sinchevents.VerificationResultEventDtoTest;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.io.IOException;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SinchEventsServiceTest extends VerificationBaseTest {

  @GivenTextResource("/domains/verification/v1/sinchevents/VerificationStartEventDto.json")
  static String jsonVerificationRequestEventDto;

  @GivenTextResource("/domains/verification/v1/sinchevents/VerificationResultEventDto.json")
  static String jsonVerificationResultEventDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponsePhoneCallDto.json")
  String jsonResponsePhoneCall;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseFlashCallDto.json")
  String jsonResponseFlashCall;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseSmsDto.json")
  String jsonResponseSms;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseWhatsAppDto.json")
  String jsonResponseWhatsApp;

  SinchEventsService sinchEventsService;

  @Test
  void checkParseEventVerificationRequestEventDto() throws ApiException {

    TestHelpers.recursiveEquals(
        sinchEventsService.parseEvent(jsonVerificationRequestEventDto),
        VerificationRequestEventDtoTest.expectedRequestEventDto.getVerificationStartEventImpl());
  }

  @Test
  void checkParseEventVerificationResultEventDto() throws ApiException {

    TestHelpers.recursiveEquals(
        sinchEventsService.parseEvent(jsonVerificationResultEventDto),
        VerificationResultEventDtoTest.expectedResultEvent.getVerificationResultEventImpl());
  }

  @Test
  void checkSerializeResponsePhoneCall() throws JSONException {

    JSONAssert.assertEquals(
        sinchEventsService.serializeResponse(
            VerificationResponseEventDtoTest.expectedPhoneCallRequestEventResponseDto),
        jsonResponsePhoneCall,
        true);
  }

  @Test
  void checkSerializeResponseFlashCall() throws JSONException {

    JSONAssert.assertEquals(
        sinchEventsService.serializeResponse(
            VerificationResponseEventDtoTest.expectedFlashCallRequestEventResponseDto),
        jsonResponseFlashCall,
        true);
  }

  @Test
  void checkSerializeResponseSms() throws JSONException {

    JSONAssert.assertEquals(
        sinchEventsService.serializeResponse(
            VerificationResponseEventDtoTest.expectedSmsRequestEventResponseDto),
        jsonResponseSms,
        true);
  }

  @Test
  void checkSerializeResponseWhatsApp() throws JSONException {

    JSONAssert.assertEquals(
        sinchEventsService.serializeResponse(
            VerificationResponseEventDtoTest.expectedWhatsAppRequestEventResponseDto),
        jsonResponseWhatsApp,
        true);
  }

  @BeforeEach
  public void setUp() throws IOException {

    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("789")
            .setApplicationSecret("9876543210")
            .build();
    VerificationContext context = VerificationContext.builder().setVerificationUrl("foo").build();
    sinchEventsService = new VerificationService(credentials, context, null).sinchEvents();
  }
}
