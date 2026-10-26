package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class SinchEventResponsesTest extends HelpersBaseTest {

  @Test
  void response() throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.response(Calls.answer(), Calls.hangup()),
        "{\"commands\":[{\"command\":\"answer\"}," + HANGUP_JSON + "]}");
  }

  @Test
  void responseFromCollectionAndLambda() throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.response(Collections.singletonList(Calls.hangup())),
        "{\"commands\":[" + HANGUP_JSON + "]}");
    assertJson(
        SinchEventResponses.response(seq -> seq.text("Bye", "Emma").hangup()),
        "{\"commands\":[{\"command\":\"messages\",\"messages\":[{\"type\":\"SAY\",\"say\":"
            + "{\"text\":\"Bye\",\"voiceName\":\"Emma\"}}]},"
            + HANGUP_JSON
            + "]}");
  }

  @Test
  void responseAcceptsNoCommand() throws JsonProcessingException, JSONException {
    assertJson(SinchEventResponses.response(), "{\"commands\":[]}");
  }

  @Test
  void incomingCallResponseOnlySetsCommands() throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.incomingCallResponse(Calls.answer()).build(),
        "{\"commands\":[{\"command\":\"answer\"}]}");
  }

  @Test
  void incomingCallResponseAllFields() throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.incomingCallResponse(seq -> seq.answer().bridgeCall("support"))
            .name("customer")
            .onHangup(Calls.hangup("agent"))
            .onHangup(seq -> seq.stopRecording("rec"))
            .build(),
        "{\"commands\":[{\"command\":\"answer\"},"
            + "{\"command\":\"bridgeCall\",\"bridgeName\":\"support\"}],"
            + "\"callName\":\"customer\",\"events\":{\"onHangup\":["
            + "{\"command\":\"hangup\",\"callName\":\"agent\"},"
            + "{\"command\":\"stopRecording\",\"recordingName\":\"rec\"}]}}");
  }

  @Test
  void incomingCallResponseFromCollection() throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.incomingCallResponse(Collections.singletonList(Calls.answer()))
            .onHangup(Collections.singletonList(Calls.hangup()))
            .build(),
        "{\"commands\":[{\"command\":\"answer\"}],\"events\":{\"onHangup\":["
            + HANGUP_JSON
            + "]}}");
  }

  @Test
  void responseAcceptsGotoMenu() throws JsonProcessingException, JSONException {
    // the event may have been triggered within a menu, where gotoMenu is valid
    assertJson(
        SinchEventResponses.response(Menu.gotoMenu("main")),
        "{\"commands\":[{\"command\":\"gotoMenu\",\"menuName\":\"main\"}]}");
  }

  @Test
  void incomingCallResponseRejectsGotoMenuOutsideAMenu() {
    Assertions.assertThatThrownBy(
            () -> SinchEventResponses.incomingCallResponse(Menu.gotoMenu("main")).build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("only valid within a menu");
    Assertions.assertThatThrownBy(
            () ->
                SinchEventResponses.incomingCallResponse(Calls.answer())
                    .onHangup(seq -> seq.gotoMenu("main"))
                    .build())
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void acceptsValidMenu() {
    Assertions.assertThatCode(
            () ->
                SinchEventResponses.response(
                    seq ->
                        seq.menu(
                            "main",
                            menu ->
                                menu.item("main", item -> item.match("1", Menu.gotoMenu("main"))))))
        .doesNotThrowAnyException();
    Assertions.assertThatCode(
            () ->
                SinchEventResponses.incomingCallResponse(
                        Menu.create("main")
                            .item("main", item -> item.onFailure(Menu.gotoMenu("main")))
                            .build())
                    .build())
        .doesNotThrowAnyException();
  }

  @Test
  void incomingCallResponseKeepsExplicitlyEmptyOnHangup()
      throws JsonProcessingException, JSONException {
    assertJson(
        SinchEventResponses.incomingCallResponse(Calls.answer()).onHangup().build(),
        "{\"commands\":[{\"command\":\"answer\"}],\"events\":{\"onHangup\":[]}}");
  }

  @Test
  void incomingCallResponseBuildIsNotAffectedByLaterChanges() {
    IncomingCallResponseCreator creator =
        SinchEventResponses.incomingCallResponse(Calls.answer()).onHangup(Calls.hangup());
    VoiceSinchEventResponse first = creator.build();

    creator.onHangup(Calls.pause(10)).name("later");

    Assertions.assertThat(first.getEvents().getOnHangup()).hasSize(1);
    Assertions.assertThat(first.getCallName()).isNull();
    Assertions.assertThat(creator.build().getEvents().getOnHangup()).hasSize(2);
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(
            () -> SinchEventResponses.incomingCallResponse(Calls.answer()).name(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> SinchEventResponses.response(Calls.answer(), null))
        .isInstanceOf(NullPointerException.class);
  }
}
