package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.dto.v1.GetConferenceInfoResponseDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetConferenceInfoResponseParticipantsInnerDto;
import com.sinch.sdk.domains.voice.models.dto.v1.ManageConferenceParticipantRequestDto;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConferencesDtoConverter {

  public static Collection<ConferenceParticipant> convert(GetConferenceInfoResponseDto dto) {
    if (null == dto) {
      return null;
    }
    List<GetConferenceInfoResponseParticipantsInnerDto> list = dto.getParticipants();

    return list.stream().map(ConferencesDtoConverter::convert).collect(Collectors.toList());
  }

  private static ConferenceParticipant convert(GetConferenceInfoResponseParticipantsInnerDto dto) {

    return ConferenceParticipant.builder()
        .setCli(dto.getCli())
        .setId(dto.getId())
        .setDuration(dto.getDuration())
        .setMuted(dto.getMuted())
        .setOnhold(dto.getOnhold())
        .build();
  }

  public static ManageConferenceParticipantRequestDto convert(
      ConferenceManageParticipantRequestParameters client) {

    ManageConferenceParticipantRequestDto dto = new ManageConferenceParticipantRequestDto();
    client.getCommand().ifPresent(f -> dto.command(EnumDynamicConverter.convert(f)));
    client.getMusicOnHold().ifPresent(f -> dto.moh(EnumDynamicConverter.convert(f)));
    return dto;
  }
}
