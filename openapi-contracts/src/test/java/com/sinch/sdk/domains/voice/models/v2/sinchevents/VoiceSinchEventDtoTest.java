package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.CallDtoTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VoiceSinchEventDtoTest extends BaseTest {

  public static final VoiceSinchEvent expectedVoiceSinchEvent =
      VoiceSinchEvent.builder()
          .setEvent(SinchEventType.CALL_MENU)
          .setCall(CallDtoTest.expectedCall)
          .setMenu(MenuInputDtoTest.expectedMenuInput)
          .build();

  public static final VoiceSinchEvent expectedVoiceSinchEventCustomEvent =
      VoiceSinchEvent.builder()
          .setEvent(SinchEventType.from("call.webhook.on-answer"))
          .setCall(CallDtoTest.expectedCall)
          .build();

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventDto.json")
  String jsonVoiceSinchEvent;

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventCustomEventDto.json")
  String jsonVoiceSinchEventCustomEvent;

  @Test
  void deserialize() throws JsonProcessingException {
    VoiceSinchEvent deserialized =
        objectMapper.readValue(jsonVoiceSinchEvent, VoiceSinchEvent.class);

    TestHelpers.recursiveEquals(deserialized, expectedVoiceSinchEvent);
  }

  @Test
  void deserializeCustomEvent() throws JsonProcessingException {
    VoiceSinchEvent deserialized =
        objectMapper.readValue(jsonVoiceSinchEventCustomEvent, VoiceSinchEvent.class);

    TestHelpers.recursiveEquals(deserialized, expectedVoiceSinchEventCustomEvent);
    Assertions.assertThat(SinchEventType.valueOf(deserialized.getEvent()))
        .isEqualTo("call.webhook.on-answer");
  }
}
