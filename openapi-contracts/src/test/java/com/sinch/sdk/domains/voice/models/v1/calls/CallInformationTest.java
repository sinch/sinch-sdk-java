package com.sinch.sdk.domains.voice.models.v1.calls;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.DomainEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.ReasonEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation.StatusEnum;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallResult;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationMxp;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallInformationTest extends VoiceBaseTest {

  @GivenJsonResource("/domains/voice/v1/calls/GetCallInformationResponseDto.json")
  CallInformation getCallInformationResponseDto;

  public static CallInformation expectedCallsGetInformationResponseDto =
      CallInformation.builder()
          .setFrom(DestinationMxp.from("user name endpoint validation"))
          .setTo(DestinationPstn.from("+33123456789"))
          .setDomain(DomainEnum.PSTN)
          .setCallId("a call UUID")
          .setDuration(138)
          .setStatus(StatusEnum.FINAL)
          .setResult(CallResult.ANSWERED)
          .setReason(ReasonEnum.CALLEEHANGUP)
          .setTimestamp(Instant.parse("2024-01-08T09:48:12Z"))
          .setCustom("{}")
          .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.5274F).build())
          .build();

  @Test
  void deserializeResponseCallout() {
    TestHelpers.recursiveEquals(
        getCallInformationResponseDto, expectedCallsGetInformationResponseDto);
  }
}
