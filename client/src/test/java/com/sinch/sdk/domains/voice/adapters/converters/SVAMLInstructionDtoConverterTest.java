package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionDto;
import com.sinch.sdk.domains.voice.models.svaml.InstructionAnswer;
import com.sinch.sdk.domains.voice.models.svaml.InstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSendDtfm;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSetCookie;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStopRecording;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.svaml.TranscriptionOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionAnswerDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionPlayFilesDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionSayDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionSendDtfmDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionSetCookieDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionStartRecordingDtoTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.InstructionStopRecordingDtoTest;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.Collections;
import org.assertj.core.api.Assertions;
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
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionAnswer)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(new SvamlInstructionDto(InstructionAnswerDtoTest.dto)));
  }

  @Test
  void convertInstructionPlayFiles() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionPlayFiles)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(new SvamlInstructionDto(InstructionPlayFilesDtoTest.dto)));
  }

  @Test
  void convertInstructionSay() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionSay)))
        .usingRecursiveComparison()
        .isEqualTo(Collections.singletonList(new SvamlInstructionDto(InstructionSayDtoTest.dto)));
  }

  @Test
  void convertInstructionSendDtfm() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionDtfm)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(new SvamlInstructionDto(InstructionSendDtfmDtoTest.dto)));
  }

  @Test
  void convertInstructionSetCookie() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(Collections.singletonList(instructionSetCookie)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(new SvamlInstructionDto(InstructionSetCookieDtoTest.dto)));
  }

  @Test
  void convertInstructionStartRecording() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(
                Collections.singletonList(instructionStartRecording)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(
                new SvamlInstructionDto(InstructionStartRecordingDtoTest.dto)));
  }

  @Test
  void convertInstructionStopRecording() {
    Assertions.assertThat(
            SVAMLInstructionDtoConverter.convert(
                Collections.singletonList(instructionStopRecording)))
        .usingRecursiveComparison()
        .isEqualTo(
            Collections.singletonList(
                new SvamlInstructionDto(InstructionStopRecordingDtoTest.dto)));
  }
}
