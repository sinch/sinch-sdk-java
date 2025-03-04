package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.Price;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallResult;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.CallHeader;
import com.sinch.sdk.domains.voice.models.v1.webhooks.AnsweredCallEventAnsweringMachineDetection.StatusEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.DisconnectedCallEvent.ReasonEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult.InputMethodEnum;
import com.sinch.sdk.domains.voice.models.v1.webhooks.MenuResult.TypeEnum;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VoiceWebhookEventTest extends VoiceBaseTest {

  @GivenJsonResource("/domains/voice/v1/webhooks/IncomingCallEventDto.json")
  IncomingCallEvent loadedIceRequestDto;

  @GivenJsonResource("/domains/voice/v1/webhooks/DisconnectedCallEventDto.json")
  DisconnectedCallEvent loadedDiceRequestDto;

  @GivenJsonResource("/domains/voice/v1/webhooks/AnsweredCallEventDto.json")
  AnsweredCallEvent loadedAceRequestDto;

  @GivenJsonResource("/domains/voice/v1/webhooks/PromptInputEventDto.json")
  PromptInputEvent loadedPieRequestDto;

  @GivenJsonResource("/domains/voice/v1/webhooks/NotificationEventDto.json")
  NotificationEvent loadedNotifyRequestDto;

  public static IncomingCallEvent expectedIceRequestDto =
      IncomingCallEvent.builder()
          .setCallid("a call id")
          .setVersion(1)
          .setCallResourceUrl("https://calling-euc1.api.sinch.com/calling/v1/calls/id/a call id")
          .setTimestamp(Instant.parse("2024-01-16T16:46:36Z"))
          .setCustom("my custom")
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.0F).build())
          .setCli("cli number")
          .setTo(DestinationPstn.from("+123456879"))
          .setDomain(Domain.MXP)
          .setApplicationKey("an app key")
          .setOriginationType(Domain.MXP2)
          .setRdnis("rdnis value")
          .setCallHeaders(
              Collections.singletonList(
                  CallHeader.builder().setKey("the key").setValue("the value").build()))
          .build();

  public static DisconnectedCallEvent expectedDiceRequestDto =
      DisconnectedCallEvent.builder()
          .setCallid("a call id")
          .setTimestamp(Instant.parse("2024-01-19T12:49:53Z"))
          .setVersion(1)
          .setCustom("my custom value")
          .setTo(DestinationPstn.from("123456789"))
          .setApplicationKey("an app key")
          .setResult(CallResult.ANSWERED)
          .setReason(ReasonEnum.MANAGERHANGUP)
          .setFrom("private")
          .setDuration(1)
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.345F).build())
          .build();

  public static AnsweredCallEvent expectedAceRequestDto =
      AnsweredCallEvent.builder()
          .setCallid("a call id")
          .setTimestamp(Instant.parse("2024-01-19T12:49:53Z"))
          .setVersion(1)
          .setCustom("my custom value")
          .setApplicationKey("my application key")
          .setAmd(
              AnsweredCallEventAnsweringMachineDetection.builder()
                  .setStatus(StatusEnum.HUMAN)
                  .setReason(AnsweredCallEventAnsweringMachineDetection.ReasonEnum.LONGGREETING)
                  .setDuration(15)
                  .build())
          .build();

  public static PromptInputEvent expectedPieRequestDto =
      PromptInputEvent.builder()
          .setCallid("a call id")
          .setTimestamp(Instant.parse("2024-01-23T15:04:28Z"))
          .setVersion(1)
          .setCustom("my custom value")
          .setApplicationKey("my application key")
          .setMenuResult(
              MenuResult.builder()
                  .setMenuId("confirm")
                  .setType(TypeEnum.SEQUENCE)
                  .setValue("1452")
                  .setInputMethod(InputMethodEnum.DTMF)
                  .build())
          .build();

  public static NotificationEvent expectedNotifyRequestDto =
      NotificationEvent.builder()
          .setCallid("a call id")
          .setVersion(1)
          .setCustom("my custom value")
          .setType("recording_finished")
          .build();

  @Test
  void deserializeIceRequest() {
    TestHelpers.recursiveEquals(loadedIceRequestDto, expectedIceRequestDto);
  }

  @Test
  void deserializeDiceRequest() {
    TestHelpers.recursiveEquals(loadedDiceRequestDto, expectedDiceRequestDto);
  }

  @Test
  void deserializeAceRequest() {
    TestHelpers.recursiveEquals(loadedAceRequestDto, expectedAceRequestDto);
  }

  @Test
  void deserializePieRequest() {
    TestHelpers.recursiveEquals(loadedPieRequestDto, expectedPieRequestDto);
  }

  @Test
  void deserializeNotifyRequest() {
    TestHelpers.recursiveEquals(loadedNotifyRequestDto, expectedNotifyRequestDto);
  }
}
