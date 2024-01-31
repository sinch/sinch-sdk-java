package com.sinch.sdk.domains.voice.models.svaml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.voice.adapters.converters.SVAMLActionDtoConverterTest;
import com.sinch.sdk.domains.voice.adapters.converters.SVAMLInstructionDtoConverterTest;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class SVAMLControlTest {

  public static final SVAMLControl parameters =
      SVAMLControl.builder()
          .setAction(SVAMLActionDtoConverterTest.actionConnectConference)
          .setInstructions(
              Collections.singletonList(SVAMLInstructionDtoConverterTest.instructionAnswer))
          .build();

  @Test
  void action() {
    assertEquals(SVAMLActionDtoConverterTest.actionConnectConference, parameters.getAction().get());
  }

  @Test
  void instructions() {
    assertEquals(
        Collections.singletonList(SVAMLInstructionDtoConverterTest.instructionAnswer),
        parameters.getInstructions().get());
  }
}
