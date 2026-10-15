package com.sinch.sdk.domains.voice.models.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneDtoTest;
import com.sinch.sdk.domains.voice.models.v2.destination.SipFromDtoTest;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallDtoTest extends BaseTest {

  public static final Call expectedCall =
      Call.builder()
          .setCallId("01ARZ3NDEKTSV4RRFFQ69G5FAA")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setSessionId("01BX5ZZKBKACTAV9WEVGEMMVRB")
          .setCallName("origin")
          .setBridgeName("my-bridge")
          .setBatchId("01BX5ZZKBKACTAV9WEVGEMMVRC")
          .setFrom(SipFromDtoTest.expectedSipFrom)
          .setTo(PhoneDtoTest.expectedPhone)
          .setStartTime(Instant.parse("2025-02-10T09:00:00Z"))
          .setUpdateTime(Instant.parse("2025-02-10T09:00:47Z"))
          .setCallType(CallType.PHONE)
          .setDirection(CallDirection.INBOUND)
          .setAnswerTime(Instant.parse("2025-02-10T09:00:05Z"))
          .setEndTime(Instant.parse("2025-02-10T09:00:47Z"))
          .setCallDurationSeconds(42)
          .setCallResult(CallResult.COMPLETED)
          .setCallReason(CallReason.CALLEE_HANGUP)
          .setOriginationType(OriginationType.SIP)
          .setCallRate(MoneyDtoTest.expectedMoney)
          .setCallResourceUrl(
              "https://voice.api.sinch.com/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/calls/01ARZ3NDEKTSV4RRFFQ69G5FAA")
          .build();

  public static final Call expectedCallMinimal =
      Call.builder()
          .setCallId("01ARZ3NDEKTSV4RRFFQ69G5FAA")
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setSessionId("01BX5ZZKBKACTAV9WEVGEMMVRB")
          .setStartTime(Instant.parse("2025-02-10T09:00:00Z"))
          .setCallType(CallType.PHONE)
          .setDirection(CallDirection.OUTBOUND)
          .setCallResult(CallResult.QUEUED)
          .setOriginationType(OriginationType.SERVER)
          .setCallRate(MoneyDtoTest.expectedMoney)
          .setCallResourceUrl(
              "https://voice.api.sinch.com/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/calls/01ARZ3NDEKTSV4RRFFQ69G5FAA")
          .build();

  @GivenTextResource("/domains/voice/v2/CallDto.json")
  String jsonCall;

  @GivenTextResource("/domains/voice/v2/CallMinimalDto.json")
  String jsonCallMinimal;

  @Test
  void deserialize() throws JsonProcessingException {
    Call deserialized = objectMapper.readValue(jsonCall, Call.class);

    TestHelpers.recursiveEquals(deserialized, expectedCall);
  }

  @Test
  void deserializeMinimalDto() throws JsonProcessingException {
    Call deserialized = objectMapper.readValue(jsonCallMinimal, Call.class);

    TestHelpers.recursiveEquals(deserialized, expectedCallMinimal);
  }
}
