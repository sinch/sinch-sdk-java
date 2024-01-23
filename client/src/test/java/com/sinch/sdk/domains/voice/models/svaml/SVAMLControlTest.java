package com.sinch.sdk.domains.voice.models.svaml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.voice.adapters.converters.SAVMLActionDtoConverterTest;
import com.sinch.sdk.domains.voice.adapters.converters.SAVMLInstructionDtoConverterTest;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class SVAMLControlTest {

  public static final SVAMLControl parameters =
      SVAMLControl.builder()
          .setAction(SAVMLActionDtoConverterTest.actionConnectConference)
          .setInstructions(
              Collections.singletonList(SAVMLInstructionDtoConverterTest.instructionAnswer))
          .build();

  @Test
  void action() {
    assertEquals(SAVMLActionDtoConverterTest.actionConnectConference, parameters.getAction().get());
  }

  @Test
  void instructions() {
    assertEquals(
        Collections.singletonList(SAVMLInstructionDtoConverterTest.instructionAnswer),
        parameters.getInstructions().get());
  }
}
