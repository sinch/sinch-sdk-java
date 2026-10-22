package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class AmdTest extends HelpersBaseTest {

  @Test
  void activateWithoutHandlers() throws JsonProcessingException, JSONException {
    assertJson(Amd.activate().build(), "{\"command\":\"amd\"}");
  }

  @Test
  void activateAllHandlers() throws JsonProcessingException, JSONException {
    assertJson(
        Amd.activate()
            .onHuman(Calls.bridgeCall("support"))
            .onMachine(Calls.hangup())
            .onBeep(Calls.pause(1500))
            .onUnknown(Collections.singletonList(Calls.hangup("origin")))
            .build(),
        "{\"command\":\"amd\",\"events\":{"
            + "\"onHuman\":[{\"command\":\"bridgeCall\",\"bridgeName\":\"support\"}],"
            + "\"onMachine\":["
            + HANGUP_JSON
            + "],"
            + "\"onBeep\":[{\"command\":\"pause\",\"durationMilliseconds\":1500}],"
            + "\"onUnknown\":[{\"command\":\"hangup\",\"callName\":\"origin\"}]}}");
  }

  @Test
  void handlersAppend() throws JsonProcessingException, JSONException {
    assertJson(
        Amd.activate().onMachine(Calls.pause(1200)).onMachine(Calls.hangup()).build(),
        "{\"command\":\"amd\",\"events\":{\"onMachine\":["
            + "{\"command\":\"pause\",\"durationMilliseconds\":1200},"
            + HANGUP_JSON
            + "]}}");
  }
}
