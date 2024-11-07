package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.svaml.InstructionAnswer;
import com.sinch.sdk.domains.voice.models.svaml.InstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSendDtfm;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSetCookie;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStopRecording;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.svaml.TranscriptionOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionAnswerTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionPlayFilesTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSayTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSendDtmfDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSetCookieTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStartRecordingTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStopRecordingTest;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class SVAMLInstructionDtoConverterTest {

  public static final InstructionAnswer instructionAnswer = InstructionAnswer.builder().build();

  InstructionPlayFiles instructionPlayFiles =
      InstructionPlayFiles.builder()
          .setIds(Collections.singletonList("[Welcome]"))
          .setLocale("en")
          .build();

  InstructionSay instructionSay =
      InstructionSay.builder().setText("[Welcome]").setLocale("en").build();

  InstructionSendDtfm instructionDtfm =
      InstructionSendDtfm.builder().setDtfm(DualToneMultiFrequency.valueOf("ww123#")).build();

  InstructionSetCookie instructionSetCookie =
      InstructionSetCookie.builder().setKey("a key").setValue("a value").build();

  InstructionStartRecording instructionStartRecording =
      InstructionStartRecording.builder()
          .setOptions(
              StartRecordingOptions.builder()
                  .setCredentials("credential value")
                  .setDestinationUrl("destination value")
                  .setFormat("mp3")
                  .setNotificationEvents(true)
                  .setTranscriptionOptions(
                      TranscriptionOptions.builder().setEnabled(true).setLocale("en-US").build())
                  .build())
          .build();

  InstructionStopRecording instructionStopRecording = InstructionStopRecording.builder().build();

  @Test
  void convertInstructionAnswer() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionAnswer)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionAnswerTest.dto)));
  }

  @Test
  void convertInstructionPlayFiles() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionPlayFiles)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionPlayFilesTest.dto)));
  }

  @Test
  void convertInstructionSay() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionSay)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionSayTest.dto)));
  }

  @Test
  void convertInstructionSendDtfm() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionDtfm)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionSendDtmfDtoTest.dto)));
  }

  @Test
  void convertInstructionSetCookie() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionSetCookie)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionSetCookieTest.dto)));
  }

  @Test
  void convertInstructionStartRecording() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionStartRecording)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionStartRecordingTest.dto)));
  }

  @Test
  void convertInstructionStopRecording() {
    TestHelpers.recursiveEquals(
        SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionStopRecording)),
        new ArrayList<>(Collections.singletonList(SvamlInstructionStopRecordingTest.dto)));
  }
}
