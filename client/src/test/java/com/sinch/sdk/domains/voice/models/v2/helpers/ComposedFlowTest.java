package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingDestinationType;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

/** The "Voice V2 Helpers meeting discussion" Confluence example, built with the helpers */
class ComposedFlowTest extends HelpersBaseTest {

  static final String EXPECTED =
      "{\"commands\":[{\"command\":\"dial\",\"callName\":\"customer\","
          + "\"from\":{\"type\":\"PHONE\",\"phone\":{\"number\":\"+34910000000\"}},"
          + "\"to\":{\"type\":\"PHONE\",\"phone\":{\"number\":\"+34600111222\"}},"
          + "\"dialTimeoutDurationSeconds\":25,"
          + "\"events\":{"
          + "\"onAnswer\":[{\"command\":\"amd\",\"events\":{"
          + "\"onHuman\":["
          + "{\"command\":\"messages\",\"messages\":[{\"type\":\"SAY\",\"say\":"
          + "{\"text\":\"Connecting you to support, one moment.\",\"voiceName\":\"Emma\"}}]},"
          + "{\"command\":\"startRecording\",\"recordingName\":\"support-call\","
          + "\"recordingOptions\":{\"destination\":\"AWS\","
          + "\"destinationUrl\":\"s3://voice-recordings/support\","
          + "\"credentials\":\"key:secret:eu-west-1\"}},"
          + "{\"command\":\"bridgeCall\",\"bridgeName\":\"support-queue\"}],"
          + "\"onMachine\":["
          + "{\"command\":\"pause\",\"durationMilliseconds\":1200},"
          + "{\"command\":\"messages\",\"messages\":[{\"type\":\"SAY\",\"say\":"
          + "{\"text\":\"This is a call from support, please call us back.\","
          + "\"voiceName\":\"Emma\"}}]},"
          + "{\"command\":\"hangup\"}]}}],"
          + "\"onHangup\":[{\"command\":\"stopRecording\",\"recordingName\":\"support-call\"}]"
          + "}}]}";

  @Test
  void supportCallFlow() throws JsonProcessingException, JSONException {
    StartCallRequest request =
        StartCallRequest.builder()
            .setCommands(
                Collections.singletonList(
                    Calls.dial("+34600111222")
                        .name("customer")
                        .from("+34910000000")
                        .timeoutDurationSeconds(25)
                        .onAnswer(
                            Amd.activate()
                                .onHuman(
                                    Messages.text("Connecting you to support, one moment.", "Emma"),
                                    Recording.start(
                                            RecordingDestinationType.AWS,
                                            "s3://voice-recordings/support",
                                            "key:secret:eu-west-1")
                                        .name("support-call")
                                        .build(),
                                    Calls.bridgeCall("support-queue"))
                                .onMachine(
                                    Calls.pause(1200),
                                    Messages.text(
                                        "This is a call from support, please call us back.",
                                        "Emma"),
                                    Calls.hangup())
                                .build())
                        .onHangup(Recording.stop("support-call"))
                        .build()))
            .build();

    assertJson(request, EXPECTED);
  }
}
