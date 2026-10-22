package com.sinch.sdk.domains.voice.models.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.sinchevents.VoiceSinchEventResponse;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.AnswerCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommand;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/** The Voice V2 models holding SVAML commands accept one or more commands, as well as a list */
class SingleCommandBuilderTest {

  static final SvamlCommand HANGUP = HangupCommand.HANGUP_COMMAND;
  static final List<SvamlCommand> ONE = Collections.singletonList(HANGUP);
  static final List<SvamlCommand> TWO = Arrays.asList(AnswerCommand.ANSWER_COMMAND, HANGUP);

  @Test
  void startCallRequest() {
    Assertions.assertThat(StartCallRequest.builder().setCommands(HANGUP).build())
        .isEqualTo(StartCallRequest.builder().setCommands(ONE).build());
    Assertions.assertThat(
            StartCallRequest.builder()
                .setCommands(AnswerCommand.ANSWER_COMMAND, HANGUP)
                .build()
                .getCommands())
        .isEqualTo(TWO);
  }

  @Test
  void startBatchRequest() {
    Assertions.assertThat(StartBatchRequest.builder().setCommands(HANGUP).build())
        .isEqualTo(StartBatchRequest.builder().setCommands(ONE).build());
  }

  @Test
  void callPatchRequest() {
    Assertions.assertThat(CallPatchRequest.builder().setCommands(HANGUP).build())
        .isEqualTo(CallPatchRequest.builder().setCommands(ONE).build());
  }

  @Test
  void svamlInput() {
    Assertions.assertThat(SvamlInput.builder().setCommands(HANGUP).build())
        .isEqualTo(SvamlInput.builder().setCommands(ONE).build());
  }

  @Test
  void voiceSinchEventResponse() {
    Assertions.assertThat(VoiceSinchEventResponse.builder().setCommands(HANGUP).build())
        .isEqualTo(VoiceSinchEventResponse.builder().setCommands(ONE).build());
  }

  /** Jackson still deserializes the builders: the overload is not a second setter for it */
  @Test
  void deserializationIsUnchanged() throws Exception {
    ObjectMapper mapper = Mapper.getInstance();
    for (Object model :
        Arrays.asList(
            StartCallRequest.builder().setCommands(HANGUP).build(),
            StartBatchRequest.builder()
                .setCommands(HANGUP)
                .setParameters(Collections.singletonList(Collections.singletonMap("to", "+1")))
                .build(),
            CallPatchRequest.builder().setCommands(HANGUP).build(),
            SvamlInput.builder().setCommands(HANGUP).build(),
            VoiceSinchEventResponse.builder().setCommands(HANGUP).build())) {
      String json = mapper.writeValueAsString(model);
      Object read = mapper.readValue(json, model.getClass().getInterfaces()[0]);

      Assertions.assertThat(mapper.writeValueAsString(read)).isEqualTo(json);
    }
  }
}
