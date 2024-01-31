package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionAnswerDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionPlayFilesDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionPlayFilesDto.NameEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSayDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSendDtmfDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSetCookieDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStopRecordingDto;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SVAMLInstructionDtoConverter {

  private static final Logger LOGGER =
      Logger.getLogger(SVAMLInstructionDtoConverter.class.getName());

  public static List<SvamlInstructionDto> convert(Collection<Instruction> instructions) {
    if (null == instructions) {
      return null;
    }
    return instructions.stream()
        .map(SVAMLInstructionDtoConverter::convertInstruction)
        .collect(Collectors.toList());
  }

  private static SvamlInstructionDto convertInstruction(Instruction client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionDto dto = new SvamlInstructionDto();

    Object convertedDto = null;
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

    dto.setActualInstance(convertedDto);
    return dto;
  }

  private static SvamlInstructionAnswerDto convert(InstructionAnswer client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionAnswerDto dto = new SvamlInstructionAnswerDto();
    dto.setName(SvamlInstructionAnswerDto.NameEnum.ANSWER.getValue());
    return dto;
  }

  private static SvamlInstructionPlayFilesDto convert(InstructionPlayFiles client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionPlayFilesDto dto = new SvamlInstructionPlayFilesDto();
    dto.setName(NameEnum.PLAYFILES.getValue());
    client.getIds().ifPresent(f -> dto.setIds(new ArrayList<>(f)));
    client.getLocale().ifPresent(dto::locale);
    return dto;
  }

  private static SvamlInstructionSayDto convert(InstructionSay client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSayDto dto = new SvamlInstructionSayDto();
    dto.setName(SvamlInstructionSayDto.NameEnum.SAY.getValue());
    client.getText().ifPresent(dto::setText);
    client.getLocale().ifPresent(dto::setLocale);
    return dto;
  }

  private static SvamlInstructionSendDtmfDto convert(InstructionSendDtfm client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSendDtmfDto dto = new SvamlInstructionSendDtmfDto();
    dto.setName(SvamlInstructionSendDtmfDto.NameEnum.SENDDTMF.getValue());
    client.getTDtfm().ifPresent(f -> dto.setValue(f.stringValue()));
    return dto;
  }

  private static SvamlInstructionSetCookieDto convert(InstructionSetCookie client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionSetCookieDto dto = new SvamlInstructionSetCookieDto();
    dto.setName(SvamlInstructionSetCookieDto.NameEnum.SETCOOKIE.getValue());

    dto.setKey(client.getKey());
    dto.setValue(client.getValue());
    return dto;
  }

  private static SvamlInstructionStartRecordingDto convert(InstructionStartRecording client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionStartRecordingDto dto = new SvamlInstructionStartRecordingDto();
    dto.setName(SvamlInstructionStartRecordingDto.NameEnum.STARTRECORDING.getValue());
    client.getOptions().ifPresent(f -> dto.setOptions(convert(f)));
    return dto;
  }

  private static SvamlInstructionStopRecordingDto convert(InstructionStopRecording client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionStopRecordingDto dto = new SvamlInstructionStopRecordingDto();
    dto.setName(SvamlInstructionStopRecordingDto.NameEnum.STOPRECORDING.getValue());
    return dto;
  }

  private static SvamlInstructionStartRecordingOptionsDto convert(StartRecordingOptions client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionStartRecordingOptionsDto dto = new SvamlInstructionStartRecordingOptionsDto();

    client.getDestinationUrl().ifPresent(dto::setDestinationUrl);
    client.getCredentials().ifPresent(dto::setCredentials);
    client.getFormat().ifPresent(dto::setFormat);
    client.getNotificationEvents().ifPresent(dto::setNotificationEvents);
    client.getTranscriptionOptions().ifPresent(f -> dto.setTranscriptionOptions(convert(f)));
    return dto;
  }

  private static SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto convert(
      TranscriptionOptions client) {
    if (null == client) {
      return null;
    }
    SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto dto =
        new SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto();
    client.getEnabled().ifPresent(dto::setEnabled);
    client.getLocale().ifPresent(dto::locale);
    return dto;
  }
}
