package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.VoiceName;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class MessagesTest extends HelpersBaseTest {

  static final String SAY_JSON =
      "{\"type\":\"SAY\",\"say\":{\"text\":\"Hello\",\"voiceName\":\"Emma\"}}";
  static final String PLAY_JSON =
      "{\"type\":\"PLAY\",\"play\":{\"url\":\"https://example.com/a.mp3\"}}";

  @Test
  void textLeavesFormatUnset() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.text("Hello", "Emma"),
        "{\"command\":\"messages\",\"messages\":[" + SAY_JSON + "]}");
  }

  @Test
  void ssml() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.ssml("<speak>Hello</speak>", "Emma"),
        "{\"command\":\"messages\",\"messages\":[{\"type\":\"SAY\",\"say\":"
            + "{\"text\":\"<speak>Hello</speak>\",\"voiceName\":\"Emma\",\"format\":\"SSML\"}}]}");
  }

  @Test
  void play() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.play("https://example.com/a.mp3"),
        "{\"command\":\"messages\",\"messages\":[" + PLAY_JSON + "]}");
  }

  @Test
  void startKeepsMessagesInOrder() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.start()
            .text("Hello", "Emma")
            .play("https://example.com/a.mp3")
            .name("greeting")
            .onFinish(Calls.hangup())
            .build(),
        "{\"command\":\"messages\",\"messagesName\":\"greeting\",\"messages\":["
            + SAY_JSON
            + ","
            + PLAY_JSON
            + "],\"events\":{\"onFinish\":["
            + HANGUP_JSON
            + "]}}");
  }

  @Test
  void startRequiresAMessage() {
    Assertions.assertThatThrownBy(() -> Messages.start().name("greeting").build())
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void stop() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.stop("greeting"), "{\"command\":\"stopMessages\",\"messagesName\":\"greeting\"}");
  }

  @Test
  void shortcutsAcceptNameAndOnFinish() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.text("Hello", "Emma", m -> m.name("greeting").onFinish(Calls.hangup())),
        "{\"command\":\"messages\",\"messagesName\":\"greeting\",\"messages\":["
            + SAY_JSON
            + "],\"events\":{\"onFinish\":["
            + HANGUP_JSON
            + "]}}");
    assertJson(
        Messages.ssml("<speak>Hello</speak>", "Emma", m -> m.name("greeting")),
        "{\"command\":\"messages\",\"messagesName\":\"greeting\",\"messages\":[{\"type\":\"SAY\","
            + "\"say\":{\"text\":\"<speak>Hello</speak>\",\"voiceName\":\"Emma\","
            + "\"format\":\"SSML\"}}]}");
    assertJson(
        Messages.play("https://example.com/a.mp3", m -> m.onFinish(s -> s.hangup())),
        "{\"command\":\"messages\",\"messages\":["
            + PLAY_JSON
            + "],\"events\":{\"onFinish\":["
            + HANGUP_JSON
            + "]}}");
  }

  @Test
  void shortcutLambdaCanAddMessages() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.text("Hello", "Emma", m -> m.play("https://example.com/a.mp3")),
        "{\"command\":\"messages\",\"messages\":[" + SAY_JSON + "," + PLAY_JSON + "]}");
  }

  @Test
  void rejectsNullShortcutLambda() {
    Assertions.assertThatThrownBy(() -> Messages.text("Hello", "Emma", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Messages.play("https://example.com/a.mp3", null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void acceptsAVoiceNameFromTheCatalog() throws JsonProcessingException, JSONException {
    assertJson(
        Messages.text("Hello", VoiceName.EMMA),
        objectMapper.writeValueAsString(Messages.text("Hello", "Emma")));
    assertJson(
        Messages.ssml("<speak>Hello</speak>", VoiceName.EMMA, m -> m.name("greeting")),
        objectMapper.writeValueAsString(
            Messages.ssml("<speak>Hello</speak>", "Emma", m -> m.name("greeting"))));
    assertJson(
        Messages.start()
            .text("Hello", VoiceName.EMMA)
            .ssml("<speak>Hi</speak>", VoiceName.EMMA_3)
            .build(),
        objectMapper.writeValueAsString(
            Messages.start().text("Hello", "Emma").ssml("<speak>Hi</speak>", "Emma_3").build()));
  }

  @Test
  void rejectsNullVoiceName() {
    Assertions.assertThatThrownBy(() -> Messages.text("Hello", (VoiceName) null))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Messages.text(null, "Emma"))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Messages.text("Hello", (String) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Messages.play(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Messages.stop(null))
        .isInstanceOf(NullPointerException.class);
  }
}
