package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest.CommandEnum;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ConferencesDtoConverter {

  public static Collection<ConferenceParticipant> convert(GetConferenceInfoResponse dto) {
    if (null == dto) {
      return null;
    }
    List<com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipant> list =
        dto.getParticipants();

    return list.stream().map(ConferencesDtoConverter::convert).collect(Collectors.toList());
  }

  private static ConferenceParticipant convert(
      com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceParticipant dto) {

    return ConferenceParticipant.builder()
        .setCli(dto.getCli())
        .setId(dto.getId())
        .setDuration(dto.getDuration())
        .setMuted(dto.getMuted())
        .setOnhold(dto.getOnHold())
        .build();
  }

  public static ManageConferenceParticipantRequest convert(
      ConferenceManageParticipantRequestParameters client) {

    ManageConferenceParticipantRequest.Builder dto = ManageConferenceParticipantRequest.builder();
    client
        .getCommand()
        .ifPresent(f -> dto.setCommand(CommandEnum.from(EnumDynamicConverter.convert(f))));
    client
        .getMusicOnHold()
        .ifPresent(f -> dto.setMusicOnHold(MusicOnHold.from(EnumDynamicConverter.convert(f))));
    return dto.build();
  }
}
