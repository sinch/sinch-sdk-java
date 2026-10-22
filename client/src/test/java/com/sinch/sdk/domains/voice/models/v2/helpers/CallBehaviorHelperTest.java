package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.services.StaticCallBehavior;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class CallBehaviorHelperTest extends HelpersBaseTest {

  @Test
  void none() throws JsonProcessingException, JSONException {
    assertJson(CallBehaviorHelper.none(), "{\"type\":\"NONE\"}");
  }

  @Test
  void eventDestination() throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.eventDestination("https://example.com/events"),
        "{\"type\":\"WEBHOOK\",\"webhook\":{\"url\":\"https://example.com/events\"}}");
  }

  @Test
  void eventDestinationWithFallbackUrl() throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.eventDestination(
            "https://example.com/events", "https://fallback.example.com/events"),
        "{\"type\":\"WEBHOOK\",\"webhook\":{\"url\":\"https://example.com/events\","
            + "\"fallbackUrl\":\"https://fallback.example.com/events\"}}");
  }

  @Test
  void staticBehaviorOnlySetsCommands() throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.staticBehavior(Calls.answer(), Calls.hangup()).build(),
        "{\"type\":\"STATIC\",\"static\":{\"commands\":[{\"command\":\"answer\"},"
            + HANGUP_JSON
            + "]}}");
  }

  @Test
  void staticBehaviorAllFields() throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.staticBehavior(seq -> seq.answer().text("Hello", "Emma"))
            .name("welcome")
            .onHangup(Calls.hangup("origin"))
            .onHangup(Collections.singletonList(Calls.pause(10)))
            .build(),
        "{\"type\":\"STATIC\",\"static\":{\"commands\":[{\"command\":\"answer\"},"
            + "{\"command\":\"messages\",\"messages\":[{\"type\":\"SAY\",\"say\":"
            + "{\"text\":\"Hello\",\"voiceName\":\"Emma\"}}]}],"
            + "\"callName\":\"welcome\",\"events\":{\"onHangup\":["
            + "{\"command\":\"hangup\",\"callName\":\"origin\"},"
            + "{\"command\":\"pause\",\"durationMilliseconds\":10}]}}}");
  }

  @Test
  void staticBehaviorFromCollectionAndOnHangupLambda()
      throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.staticBehavior(Collections.singletonList(Calls.answer()))
            .onHangup(seq -> seq.hangup())
            .build(),
        "{\"type\":\"STATIC\",\"static\":{\"commands\":[{\"command\":\"answer\"}],"
            + "\"events\":{\"onHangup\":["
            + HANGUP_JSON
            + "]}}}");
  }

  @Test
  void staticBehaviorRejectsGotoMenuOutsideAMenu() {
    Assertions.assertThatThrownBy(
            () -> CallBehaviorHelper.staticBehavior(seq -> seq.gotoMenu("main")).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("only valid within a menu");
    Assertions.assertThatThrownBy(
            () ->
                CallBehaviorHelper.staticBehavior(Calls.answer())
                    .onHangup(Menu.gotoMenu("main"))
                    .build())
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void staticBehaviorAcceptsValidMenu() {
    Assertions.assertThatCode(
            () ->
                CallBehaviorHelper.staticBehavior(
                        seq ->
                            seq.menu(
                                "main",
                                menu ->
                                    menu.item(
                                        "main", item -> item.onFailure(Menu.gotoMenu("main")))))
                    .build())
        .doesNotThrowAnyException();
  }

  @Test
  void staticBehaviorKeepsExplicitlyEmptyOnHangup() throws JsonProcessingException, JSONException {
    assertJson(
        CallBehaviorHelper.staticBehavior(Calls.answer()).onHangup().build(),
        "{\"type\":\"STATIC\",\"static\":{\"commands\":[{\"command\":\"answer\"}],"
            + "\"events\":{\"onHangup\":[]}}}");
  }

  @Test
  void staticBehaviorBuildIsNotAffectedByLaterChanges() {
    StaticCallBehaviorCreator creator =
        CallBehaviorHelper.staticBehavior(Calls.answer()).onHangup(Calls.hangup());
    StaticCallBehavior first = creator.build();

    creator.onHangup(Calls.pause(10)).name("later");

    Assertions.assertThat(first.getStatic().getEvents().getOnHangup()).hasSize(1);
    Assertions.assertThat(first.getStatic().getCallName()).isNull();
    Assertions.assertThat(creator.build().getStatic().getEvents().getOnHangup()).hasSize(2);
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> CallBehaviorHelper.eventDestination(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> CallBehaviorHelper.eventDestination("https://example.com", null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(
            () -> CallBehaviorHelper.staticBehavior(Calls.answer()).name(null))
        .isInstanceOf(NullPointerException.class);
  }
}
