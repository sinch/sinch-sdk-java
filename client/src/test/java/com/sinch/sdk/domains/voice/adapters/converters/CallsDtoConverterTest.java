package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DestinationUser;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.response.CallStatusType;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControlTest;
import com.sinch.sdk.domains.voice.models.v1.calls.CallInformationTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectConferenceTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionAnswerTest;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CallsDtoConverterTest extends BaseTest {

  public static CallInformation expectedCallInformation =
      CallInformation.builder()
          .setFrom(DestinationUser.valueOf("user name endpoint validation"))
          .setTo(DestinationNumber.valueOf("+33123456789"))
          .setDomain(DomainType.PSTN)
          .setCallId("a call UUID")
          .setDuration(138)
          .setStatus(CallStatusType.FINAL)
          .setResult(CallResultType.ANSWERED)
          .setReason(CallReasonType.CALLEE_HANGUP)
          .setTimeStamp(Instant.parse("2024-01-08T09:48:12Z"))
          .setCustom("{}")
          .setUserRate(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.5274F).build())
          .build();

  public static SvamlControl svamlControlDto =
      SvamlControl.builder()
          .setAction(SvamlActionConnectConferenceTest.dto)
          .setInstructions(Collections.singletonList(SvamlInstructionAnswerTest.dto))
          .build();

  @Test
  void convertCallInformation() {

    TestHelpers.recursiveEquals(
        CallsDtoConverter.convert(CallInformationTest.expectedCallsGetInformationResponseDto),
        expectedCallInformation);
  }

  @Test
  void convertCallsUpdateRequestParameters() {

    TestHelpers.recursiveEquals(
        svamlControlDto, ControlDtoConverter.convertControl(SVAMLControlTest.parameters));
  }
}
