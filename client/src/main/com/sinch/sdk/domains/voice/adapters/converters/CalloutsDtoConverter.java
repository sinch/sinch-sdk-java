package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTS;
import com.sinch.sdk.domains.voice.models.v1.Domain;
import com.sinch.sdk.domains.voice.models.v1.MusicOnHold;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.callouts.response.CalloutResponse;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferenceDtmfOptions;
import com.sinch.sdk.domains.voice.models.v1.destination.Destination;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationConference;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationCustom;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationTextToSpeech;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.util.logging.Logger;

public class CalloutsDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(CalloutsDtoConverter.class.getName());

  public static CalloutRequest convert(CalloutRequestParameters client) {

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

  public static String convert(CalloutResponse dto) {
    if (null == dto) {
      return null;
    }
    return dto.getCallId();
  }

  private static CalloutRequestConference convert(CalloutRequestParametersConference client) {

    CalloutRequestConference.Builder dto = CalloutRequestConference.builder();

    client
        .getDestination()
        .ifPresent(
            f -> {
              Destination destination = DestinationDtoConverter.convert(f);
              if (destination instanceof DestinationConference) {
                dto.setDestination((DestinationConference) destination);
                return;
              }
              LOGGER.severe(String.format("Unexpected class: %s", f));
            });
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(DualToneMultiFrequency.valueOf(f.stringValue())));
    client.getCustom().ifPresent(dto::setCustom);

    client.getConferenceId().ifPresent(dto::setConferenceId);
    client.getDtfmOptions().ifPresent(f -> dto.setConferenceDtmfOptions(convert(f)));

    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getEnableAce().ifPresent(dto::setEnableAce);
    client.getEnableDice().ifPresent(dto::setEnableDice);
    client.getEnablePie().ifPresent(dto::setEnablePie);
    client.getLocale().ifPresent(dto::setLocale);
    client.getGreeting().ifPresent(dto::setGreeting);
    client
        .getMusicOnHold()
        .ifPresent(f -> dto.setMusicOnHold(MusicOnHold.from(EnumDynamicConverter.convert(f))));
    client.getDomain().ifPresent(f -> dto.setDomain(Domain.from(EnumDynamicConverter.convert(f))));

    return dto.build();
  }

  private static CalloutRequestTTS convert(CalloutRequestParametersTTS client) {

    CalloutRequestTTS.Builder dto = CalloutRequestTTS.builder();

    client
        .getDestination()
        .ifPresent(
            f -> {
              Destination destination = DestinationDtoConverter.convert(f);
              if (destination instanceof DestinationTextToSpeech) {
                dto.setDestination((DestinationTextToSpeech) destination);
                return;
              }
              LOGGER.severe(String.format("Unexpected class: %s", f));
            });
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(DualToneMultiFrequency.valueOf(f.stringValue())));
    client.getCustom().ifPresent(dto::setCustom);
    client.getEnableAce().ifPresent(dto::setEnableAce);
    client.getEnableDice().ifPresent(dto::setEnableDice);
    client.getEnablePie().ifPresent(dto::setEnablePie);
    client.getLocale().ifPresent(dto::setLocale);
    client.getDomain().ifPresent(f -> dto.setDomain(Domain.from(EnumDynamicConverter.convert(f))));
    client.getText().ifPresent(dto::setText);
    client.getPrompts().ifPresent(dto::setPrompts);
    return dto.build();
  }

  private static CalloutRequestCustom convert(CalloutRequestParametersCustom client) {

    CalloutRequestCustom.Builder dto = CalloutRequestCustom.builder();

    client
        .getDestination()
        .ifPresent(
            f -> {
              Destination destination = DestinationDtoConverter.convert(f);
              if (destination instanceof DestinationCustom) {
                dto.setDestination((DestinationCustom) destination);
                return;
              }
              LOGGER.severe(String.format("Unexpected class: %s", f));
            });
    client.getCli().ifPresent(f -> dto.setCli(f.stringValue()));
    client.getDtfm().ifPresent(f -> dto.setDtmf(DualToneMultiFrequency.valueOf(f.stringValue())));
    client.getCustom().ifPresent(dto::setCustom);
    client.getMaxDuration().ifPresent(dto::setMaxDuration);
    client.getIce().ifPresent(f -> dto.setIce(ControlDtoConverter.convertControl(f)));
    client.getAce().ifPresent(f -> dto.setAce(ControlDtoConverter.convertControl(f)));
    client.getPie().ifPresent(f -> dto.setPie(ControlDtoConverter.convertControl(f)));
    return dto.build();
  }

  private static ConferenceDtmfOptions convert(ConferenceDtfmOptions client) {
    ConferenceDtmfOptions.Builder dto = ConferenceDtmfOptions.builder();
    client
        .getMode()
        .ifPresent(
            f -> dto.setMode(ConferenceDtmfOptions.ModeEnum.from(EnumDynamicConverter.convert(f))));
    client.getMaxDigits().ifPresent(dto::setMaxDigits);
    client.getTimeoutMills().ifPresent(dto::setTimeoutMills);
    return dto.build();
  }
}
