package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class CallsTest extends HelpersBaseTest {

  @Test
  void answer() throws JsonProcessingException, JSONException {
    assertJson(Calls.answer(), "{\"command\":\"answer\"}");
  }

  @Test
  void hangup() throws JsonProcessingException, JSONException {
    assertJson(Calls.hangup(), HANGUP_JSON);
  }

  @Test
  void hangupNamedLeg() throws JsonProcessingException, JSONException {
    assertJson(Calls.hangup("customer"), "{\"command\":\"hangup\",\"callName\":\"customer\"}");
  }

  @Test
  void pause() throws JsonProcessingException, JSONException {
    assertJson(Calls.pause(1200), "{\"command\":\"pause\",\"durationMilliseconds\":1200}");
  }

  @Test
  void bridgeCall() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.bridgeCall("support-queue"),
        "{\"command\":\"bridgeCall\",\"bridgeName\":\"support-queue\"}");
  }

  @Test
  void dialOnlySetsTo() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.dial(Destination.phone("+15551234567")).build(),
        "{\"command\":\"dial\",\"to\":" + PHONE_JSON + "}");
  }

  @Test
  void dialParsesStringDestination() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.dial("phone:+15551234567").build(),
        "{\"command\":\"dial\",\"to\":" + PHONE_JSON + "}");
  }

  @Test
  void dialAllFields() throws JsonProcessingException, JSONException {
    DialCommand dial =
        Calls.dial("sip:alice@example.com")
            .from("+15551234567")
            .name("customer")
            .timeoutDurationSeconds(25)
            .maxDurationSeconds(3600)
            .onAnswer(Calls.answer())
            .onBusy(Calls.pause(100))
            .onReject(Calls.bridgeCall("queue"))
            .onTimeout(Calls.hangup("other"))
            .onHangup(Messages.stop("greeting"))
            .onFailure(Calls.hangup())
            .build();

    assertJson(
        dial,
        "{\"command\":\"dial\","
            + "\"to\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:alice@example.com\"}},"
            + "\"from\":"
            + PHONE_JSON
            + ",\"callName\":\"customer\",\"dialTimeoutDurationSeconds\":25,"
            + "\"maxCallDurationSeconds\":3600,"
            + "\"events\":{"
            + "\"onAnswer\":[{\"command\":\"answer\"}],"
            + "\"onBusy\":[{\"command\":\"pause\",\"durationMilliseconds\":100}],"
            + "\"onReject\":[{\"command\":\"bridgeCall\",\"bridgeName\":\"queue\"}],"
            + "\"onTimeout\":[{\"command\":\"hangup\",\"callName\":\"other\"}],"
            + "\"onHangup\":[{\"command\":\"stopMessages\",\"messagesName\":\"greeting\"}],"
            + "\"onFailure\":[{\"command\":\"hangup\"}]}}");
  }

  @Test
  void dialFromCallOrigin() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.dial("+15550000000").from(Destination.sipFrom("sip:bob@example.com")).build(),
        "{\"command\":\"dial\","
            + "\"to\":{\"type\":\"PHONE\",\"phone\":{\"number\":\"+15550000000\"}},"
            + "\"from\":{\"type\":\"SIP\",\"sip\":{\"endpoint\":\"sip:bob@example.com\"}}}");
  }

  @Test
  void dialHandlersAppend() throws JsonProcessingException, JSONException {
    DialCommand dial =
        Calls.dial("+15551234567")
            .onAnswer(Calls.answer())
            .onAnswer(Arrays.asList(Calls.pause(500), Calls.hangup()))
            .build();

    assertJson(
        dial,
        "{\"command\":\"dial\",\"to\":"
            + PHONE_JSON
            + ",\"events\":{\"onAnswer\":[{\"command\":\"answer\"},"
            + "{\"command\":\"pause\",\"durationMilliseconds\":500},"
            + HANGUP_JSON
            + "]}}");
  }

  @Test
  void dialKeepsExplicitlyEmptyHandler() throws JsonProcessingException, JSONException {
    assertJson(
        Calls.dial("+15551234567").onBusy().build(),
        "{\"command\":\"dial\",\"to\":" + PHONE_JSON + ",\"events\":{\"onBusy\":[]}}");
  }

  @Test
  void dialBuildIsNotAffectedByLaterChanges() {
    DialCreator creator = Calls.dial("+15551234567").onAnswer(Calls.answer());
    DialCommand first = creator.build();

    creator.onAnswer(Calls.hangup());

    Assertions.assertThat(first.getEvents().getOnAnswer()).hasSize(1);
    Assertions.assertThat(creator.build().getEvents().getOnAnswer()).hasSize(2);
  }

  @Test
  void rejectsNullValues() {
    Assertions.assertThatThrownBy(() -> Calls.dial((CallDestination) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Calls.dial((String) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Calls.dial("+15551234567").name(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Calls.dial("+15551234567").onAnswer((SvamlCommand) null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Calls.bridgeCall(null))
        .isInstanceOf(NullPointerException.class);
    Assertions.assertThatThrownBy(() -> Calls.hangup(null))
        .isInstanceOf(NullPointerException.class);
  }
}
