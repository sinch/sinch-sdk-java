package com.sinch.sdk.domains.voice.models.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.voice.adapters.converters.SAVMLActionDtoConverterTest;
import com.sinch.sdk.domains.voice.adapters.converters.SAVMLInstructionDtoConverterTest;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class CallsUpdateRequestParametersTest {

  public static final CallsUpdateRequestParameters parameters =
      CallsUpdateRequestParameters.builder()
          .setAction(SAVMLActionDtoConverterTest.actionConnectConference)
          .setInstructions(
              Collections.singletonList(SAVMLInstructionDtoConverterTest.instructionAnswer))
          .build();

  @Test
  void action() {
    assertEquals(SAVMLActionDtoConverterTest.actionConnectConference, parameters.getAction());
  }

  @Test
  void instructions() {
    assertEquals(
        Collections.singletonList(SAVMLInstructionDtoConverterTest.instructionAnswer),
        parameters.getInstructions());
  }
}
