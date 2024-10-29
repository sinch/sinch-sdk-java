package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import com.sinch.sdk.domains.voice.models.svaml.InstructionAnswer;
import com.sinch.sdk.domains.voice.models.svaml.InstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSay;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSendDtfm;
import com.sinch.sdk.domains.voice.models.svaml.InstructionSetCookie;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStartRecording;
import com.sinch.sdk.domains.voice.models.svaml.InstructionStopRecording;
import com.sinch.sdk.domains.voice.models.svaml.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.svaml.TranscriptionOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionAnswer;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionPlayFiles;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSendDtmf;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSetCookie;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStartRecording;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStopRecording;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SVAMLInstructionDtoConverter {

  private static final Logger LOGGER =
      Logger.getLogger(SVAMLInstructionDtoConverter.class.getName());

  public static List<SvamlInstruction> convert(Collection<Instruction> instructions) {
    if (null == instructions) {
      return null;
    }
    return instructions.stream()
        .map(SVAMLInstructionDtoConverter::convertInstruction)
        .collect(Collectors.toList());
  }

  private static SvamlInstruction convertInstruction(Instruction client) {
    if (null == client) {
      return null;
    }

    SvamlInstruction convertedDto = null;
    if (client instanceof InstructionAnswer) {
      InstructionAnswer typedClient = (InstructionAnswer) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionPlayFiles) {
      InstructionPlayFiles typedClient = (InstructionPlayFiles) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionSay) {
      InstructionSay typedClient = (InstructionSay) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionSendDtfm) {
      InstructionSendDtfm typedClient = (InstructionSendDtfm) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionSetCookie) {
      InstructionSetCookie typedClient = (InstructionSetCookie) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionStartRecording) {
      InstructionStartRecording typedClient = (InstructionStartRecording) client;
      convertedDto = convert(typedClient);
    } else if (client instanceof InstructionStopRecording) {
      InstructionStopRecording typedClient = (InstructionStopRecording) client;
      convertedDto = convert(typedClient);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }

    return convertedDto;
  }

  private static SvamlInstructionAnswer convert(InstructionAnswer client) {
    if (null == client) {
      return null;
    }
    return SvamlInstructionAnswer.DEFAULT;
  }

  private static SvamlInstructionPlayFiles convert(InstructionPlayFiles client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionPlayFiles.Builder dto = SvamlInstructionPlayFiles.builder();
    client.getIds().ifPresent(f -> dto.setIds(new ArrayList<>(f)));
    client.getLocale().ifPresent(dto::setLocale);
    return dto.build();
  }

  private static SvamlInstructionSay convert(InstructionSay client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSay.Builder dto = SvamlInstructionSay.builder();
    client.getText().ifPresent(dto::setText);
    client.getLocale().ifPresent(dto::setLocale);
    return dto.build();
  }

  private static SvamlInstructionSendDtmf convert(InstructionSendDtfm client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSendDtmf.Builder dto = SvamlInstructionSendDtmf.builder();
    client.getTDtfm().ifPresent(f -> dto.setValue(f.stringValue()));
    return dto.build();
  }

  private static SvamlInstructionSetCookie convert(InstructionSetCookie client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSetCookie.Builder dto = SvamlInstructionSetCookie.builder();
    dto.setKey(client.getKey());
    dto.setValue(client.getValue());
    return dto.build();
  }

  private static SvamlInstructionStartRecording convert(InstructionStartRecording client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionStartRecording.Builder dto = SvamlInstructionStartRecording.builder();
    client.getOptions().ifPresent(f -> dto.setOptions(convert(f)));
    return dto.build();
  }

  private static SvamlInstructionStopRecording convert(InstructionStopRecording client) {
    if (null == client) {
      return null;
    }
    return SvamlInstructionStopRecording.DEFAULT;
  }

  private static com.sinch.sdk.domains.voice.models.v1.svaml.instruction.StartRecordingOptions
      convert(StartRecordingOptions client) {
    if (null == client) {
      return null;
    }
    com.sinch.sdk.domains.voice.models.v1.svaml.instruction.StartRecordingOptions.Builder dto =
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.StartRecordingOptions.builder();

    client.getDestinationUrl().ifPresent(dto::setDestinationUrl);
    client.getCredentials().ifPresent(dto::setCredentials);
    client.getFormat().ifPresent(dto::setFormat);
    client.getNotificationEvents().ifPresent(dto::setNotificationEvents);
    client.getTranscriptionOptions().ifPresent(f -> dto.setTranscriptionOptions(convert(f)));
    return dto.build();
  }

  private static com.sinch.sdk.domains.voice.models.v1.svaml.instruction.TranscriptionOptions
      convert(TranscriptionOptions client) {
    if (null == client) {
      return null;
    }
    com.sinch.sdk.domains.voice.models.v1.svaml.instruction.TranscriptionOptions.Builder dto =
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.TranscriptionOptions.builder();
    client.getEnabled().ifPresent(dto::setEnabled);
    client.getLocale().ifPresent(dto::setLocale);
    return dto.build();
  }
}
