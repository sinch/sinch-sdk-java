package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDto.MethodEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.ConferenceCalloutRequestConferenceDtmfOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.ConferenceCalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.CustomCalloutRequestDto;
import com.sinch.sdk.domains.voice.models.dto.v1.GetCalloutResponseObjDto;
import com.sinch.sdk.domains.voice.models.dto.v1.TtsCalloutRequestDto;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTS;

public class CalloutsDtoConverter {

  public static CalloutRequestDto convert(CalloutRequestParameters client) {

    if (client instanceof CalloutRequestParametersConference) {
      CalloutRequestParametersConference parameters = (CalloutRequestParametersConference) client;
      return convert(parameters);
    } else if (client instanceof CalloutRequestParametersTTS) {
      CalloutRequestParametersTTS parameters = (CalloutRequestParametersTTS) client;
      return convert(parameters);
    } else if (client instanceof CalloutRequestParametersCustom) {
      CalloutRequestParametersCustom parameters = (CalloutRequestParametersCustom) client;
      return convert(parameters);
    }
    return null;
  }

  public static String convert(GetCalloutResponseObjDto dto) {
    if (null == dto) {
      return null;
    }
    return dto.getCallId();
  }

  private static CalloutRequestDto convert(CalloutRequestParametersConference client) {

    ConferenceCalloutRequestDto dto = new ConferenceCalloutRequestDto();

    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(f.stringValue()));
    client.getCustom().ifPresent(dto::setCustom);

    client.getConferenceId().ifPresent(dto::conferenceId);
    client.getDtfmOptions().ifPresent(f -> dto.setConferenceDtmfOptions(convert(f)));

    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getEnableAce().ifPresent(dto::setEnableAce);
    client.getEnableDice().ifPresent(dto::setEnableDice);
    client.getEnablePie().ifPresent(dto::setEnablePie);
    client.getLocale().ifPresent(dto::setLocale);
    client.getGreeting().ifPresent(dto::setGreeting);
    client.getMohClass().ifPresent(f -> dto.setMohClass(EnumDynamicConverter.convert(f)));
    client.getDomain().ifPresent(f -> dto.setDomain(EnumDynamicConverter.convert(f)));

    return new CalloutRequestDto()
        .method(MethodEnum.CONFERENCECALLOUT.getValue())
        .conferenceCallout(dto);
  }

  private static CalloutRequestDto convert(CalloutRequestParametersTTS client) {

    TtsCalloutRequestDto dto = new TtsCalloutRequestDto();

    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(f.stringValue()));
    client.getCustom().ifPresent(dto::setCustom);
    client.getEnableAce().ifPresent(dto::setEnableAce);
    client.getEnableDice().ifPresent(dto::setEnableDice);
    client.getEnablePie().ifPresent(dto::setEnablePie);
    client.getLocale().ifPresent(dto::setLocale);
    client.getDomain().ifPresent(f -> dto.setDomain(EnumDynamicConverter.convert(f)));
    client.getText().ifPresent(dto::setText);
    client.getPrompts().ifPresent(dto::setPrompts);

    return new CalloutRequestDto().method(MethodEnum.TTSCALLOUT.getValue()).ttsCallout(dto);
  }

  private static CalloutRequestDto convert(CalloutRequestParametersCustom client) {

    CustomCalloutRequestDto dto = new CustomCalloutRequestDto();

    client.getDestination().ifPresent(f -> dto.setDestination(DestinationDtoConverter.convert(f)));
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(f.stringValue()));
    client.getCustom().ifPresent(dto::setCustom);

    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getIce().ifPresent(f -> dto.setIce(ControlDtoConverter.convert(f)));
    client.getAce().ifPresent(f -> dto.setAce(ControlDtoConverter.convert(f)));
    client.getPie().ifPresent(f -> dto.setPie(ControlDtoConverter.convert(f)));

    return new CalloutRequestDto().method(MethodEnum.CUSTOMCALLOUT.getValue()).customCallout(dto);
  }

  private static ConferenceCalloutRequestConferenceDtmfOptionsDto convert(
      ConferenceDtfmOptions client) {
    ConferenceCalloutRequestConferenceDtmfOptionsDto dto =
        new ConferenceCalloutRequestConferenceDtmfOptionsDto();
    client.getMode().ifPresent(f -> dto.setMode(EnumDynamicConverter.convert(f)));
    client.getMaxDigits().ifPresent(dto::setMaxDigits);
    client.getTimeoutMills().ifPresent(dto::setTimeoutMills);
    return dto;
  }
}
