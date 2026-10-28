package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class CustomEventsTest extends HelpersBaseTest {

  @Test
  void trigger() throws JsonProcessingException, JSONException {
    assertJson(
        CustomEvents.trigger("my.custom.event", "https://example.com/events"),
        "{\"command\":\"webhook\",\"webhookName\":\"my.custom.event\","
            + "\"url\":\"https://example.com/events\"}");
  }

  @Test
  void triggerWithFallbackUrl() throws JsonProcessingException, JSONException {
    assertJson(
        CustomEvents.trigger(
            "my.custom.event", "https://example.com/events", "https://fallback.example.com/events"),
        "{\"command\":\"webhook\",\"webhookName\":\"my.custom.event\","
            + "\"url\":\"https://example.com/events\","
            + "\"fallbackUrl\":\"https://fallback.example.com/events\"}");
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> CustomEvents.trigger(null, "https://example.com"))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> CustomEvents.trigger("name", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> CustomEvents.trigger("name", "https://example.com", null))
        .isInstanceOf(NullPointerException.class);
  }
}
