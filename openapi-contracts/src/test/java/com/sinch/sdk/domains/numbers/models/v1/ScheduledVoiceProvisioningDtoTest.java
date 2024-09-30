package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.internal.ScheduledVoiceProvisioningInternalImpl;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ScheduledVoiceProvisioningDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/active/ScheduledVoiceProvisioningDtoEST.json")
  String provisioningJsonEST;

  @GivenTextResource("/domains/numbers/v1/active/ScheduledVoiceProvisioningDtoFAX.json")
  String provisioningJsonFAX;

  @GivenTextResource("/domains/numbers/v1/active/ScheduledVoiceProvisioningDtoRTC.json")
  String provisioningJsonRTC;

  public static ScheduledVoiceProvisioningEST provisioningEST =
      ScheduledVoiceProvisioningEST.builder()
          .setTrunkId("EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA")
          .setStatus(ProvisioningStatus.WAITING)
          .setLastUpdatedTime(Instant.parse("2024-07-01T11:58:35.610198Z"))
          .build();

  public static ScheduledVoiceProvisioningFAX provisioningFAX =
      ScheduledVoiceProvisioningFAX.builder()
          .setServiceId("EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA")
          .setStatus(ProvisioningStatus.WAITING)
          .setLastUpdatedTime(Instant.parse("2024-07-01T11:58:35.610198Z"))
          .build();
  public static ScheduledVoiceProvisioningRTC provisioningRTC =
      ScheduledVoiceProvisioningRTC.builder()
          .setAppId("EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA")
          .setStatus(ProvisioningStatus.WAITING)
          .setLastUpdatedTime(Instant.parse("2024-07-01T11:58:35.610198Z"))
          .build();

  @Test
  void deserializeEST() throws JsonProcessingException {

    ScheduledVoiceProvisioningInternalImpl deserializedString =
        objectMapper.readValue(provisioningJsonEST, ScheduledVoiceProvisioningInternalImpl.class);

    TestHelpers.recursiveEquals(
        provisioningEST, deserializedString.getScheduledVoiceProvisioningESTImpl());
  }

  @Test
  void deserializeFAX() throws JsonProcessingException {

    ScheduledVoiceProvisioningInternalImpl deserializedString =
        objectMapper.readValue(provisioningJsonFAX, ScheduledVoiceProvisioningInternalImpl.class);

    TestHelpers.recursiveEquals(
        provisioningFAX, deserializedString.getScheduledVoiceProvisioningFAXImpl());
  }

  @Test
  void deserializeRTC() throws JsonProcessingException {

    ScheduledVoiceProvisioningInternalImpl deserializedString =
        objectMapper.readValue(provisioningJsonRTC, ScheduledVoiceProvisioningInternalImpl.class);

    TestHelpers.recursiveEquals(
        provisioningRTC, deserializedString.getScheduledVoiceProvisioningRTCImpl());
  }
}
