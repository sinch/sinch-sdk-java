package com.sinch.sdk.domains.voice.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.models.CallReasonType;
import com.sinch.sdk.domains.voice.models.CallResultType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.Price;
import com.sinch.sdk.domains.voice.models.v1.webhooks.VoiceWebhookEventTest;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswer;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerReasonType;
import com.sinch.sdk.domains.voice.models.webhooks.AmdAnswerStatusType;
import com.sinch.sdk.domains.voice.models.webhooks.AnsweredCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.DisconnectCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.IncomingCallEvent;
import com.sinch.sdk.domains.voice.models.webhooks.MenuInputType;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResult;
import com.sinch.sdk.domains.voice.models.webhooks.MenuResultInputMethodType;
import com.sinch.sdk.domains.voice.models.webhooks.NotifyEvent;
import com.sinch.sdk.domains.voice.models.webhooks.PromptInputEvent;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksEventDtoConverterTest extends BaseTest {

  public static IncomingCallEvent expectedIncomingCallEvent =
      IncomingCallEvent.builder()
          .setCallId("a call id")
          .setCallResourceUrl("https://calling-euc1.api.sinch.com/calling/v1/calls/id/a call id")
          .setTimestamp(Instant.parse("2024-01-16T16:46:36Z"))
          .setVersion(1)
          .setCli("cli number")
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.0F).build())
          .setCustom("my custom")
          .setTo(DestinationNumber.valueOf("+123456879"))
          .setDomain(DomainType.MXP)
          .setApplicationKey("an app key")
          .setOriginationType(DomainType.MXP)
          .setRdnis("rdnis value")
          .setCallHeaders(Collections.singletonList(new Pair<>("the key", "the value")))
          .build();

  public static DisconnectCallEvent expectedDisconnectCallEvent =
      DisconnectCallEvent.builder()
          .setCallId("a call id")
          .setTimestamp(Instant.parse("2024-01-19T12:49:53Z"))
          .setReason(CallReasonType.MANAGER_HANGUP)
          .setResult(CallResultType.ANSWERED)
          .setVersion(1)
          .setCustom("my custom value")
          .setDebit(Price.builder().setCurrencyId("EUR").setAmount(0.1758F).build())
          .setUserRate(Price.builder().setCurrencyId("USD").setAmount(0.345F).build())
          .setTo(DestinationNumber.valueOf("123456789"))
          .setApplicationKey("an app key")
          .setDuration(1)
          .setFrom("private")
          .build();

  public static AnsweredCallEvent expectedAnsweredCallEvent =
      AnsweredCallEvent.builder()
          .setCallId("a call id")
          .setTimestamp(Instant.parse("2024-01-19T12:49:53Z"))
          .setVersion(1)
          .setCustom("my custom value")
          .setAmd(
              AmdAnswer.builder()
                  .setStatus(AmdAnswerStatusType.HUMAN)
                  .setReason(AmdAnswerReasonType.LONG_GREETING)
                  .setDuration(15)
                  .build())
          .build();

  public static PromptInputEvent expectedPromptInputEvent =
      PromptInputEvent.builder()
          .setCallId("a call id")
          .setCustom("my custom value")
          .setTimestamp(Instant.parse(("2024-01-23T15:04:28Z")))
          .setVersion(1)
          .setApplicationKey("my application key")
          .setMenuResult(
              MenuResult.builder()
                  .setMenuId("confirm")
                  .setType(MenuInputType.SEQUENCE)
                  .setValue("1452")
                  .setInputMethod(MenuResultInputMethodType.DTMF)
                  .build())
          .build();

  public static NotifyEvent expectedNotifyEvent =
      NotifyEvent.builder()
          .setCallId("a call id")
          .setCustom("my custom value")
          .setVersion(1)
          .setType("recording_finished")
          .build();

  @Test
  void convertIncomingCallRequest() {

    TestHelpers.recursiveEquals(
        WebhooksEventDtoConverter.convert(VoiceWebhookEventTest.expectedIceRequestDto),
        expectedIncomingCallEvent);
  }

  @Test
  void convertDisconnectCallRequest() {

    TestHelpers.recursiveEquals(
        WebhooksEventDtoConverter.convert(VoiceWebhookEventTest.expectedDiceRequestDto),
        expectedDisconnectCallEvent);
  }

  @Test
  void convertAnsweredCallEvent() {

    TestHelpers.recursiveEquals(
        WebhooksEventDtoConverter.convert(VoiceWebhookEventTest.expectedAceRequestDto),
        expectedAnsweredCallEvent);
  }

  @Test
  void convertPieEvent() {

    TestHelpers.recursiveEquals(
        WebhooksEventDtoConverter.convert(VoiceWebhookEventTest.expectedPieRequestDto),
        expectedPromptInputEvent);
  }

  @Test
  void convertNotifyEvent() {

    TestHelpers.recursiveEquals(
        WebhooksEventDtoConverter.convert(VoiceWebhookEventTest.expectedNotifyRequestDto),
        expectedNotifyEvent);
  }
}
