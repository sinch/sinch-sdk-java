package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseCalloutSpeechDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallRequestEventResponseFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSRequestEventResponseSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationEventDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationEventResponseActionDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationRequestEventDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationResultEventDto;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseCalloutSpeech;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

public class WebHooksDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(WebHooksDtoConverter.class.getName());

  public static VerificationEvent convert(VerificationEventDto dto) {

    if (dto.getActualInstance() instanceof VerificationRequestEventDto) {
      return convert(dto.getVerificationRequestEventDto());
    } else if (dto.getActualInstance() instanceof VerificationResultEventDto) {
      return convert(dto.getVerificationResultEventDto());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      return null;
    }
  }

  static VerificationRequestEvent convert(VerificationRequestEventDto dto) {

    return new VerificationRequestEvent(
        dto.getId(),
        null != dto.getMethod() ? VerificationMethodType.from(dto.getMethod()) : null,
        null != dto.getIdentity() ? NumberIdentity.valueOf(dto.getIdentity().getEndpoint()) : null,
        PriceDtoConverter.convert(dto.getPrice()),
        null != dto.getReference() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        dto.getAcceptLanguage());
  }

  static VerificationResultEvent convert(VerificationResultEventDto dto) {

    return new VerificationResultEvent(
        dto.getId(),
        null != dto.getMethod() ? VerificationMethodType.from(dto.getMethod()) : null,
        null != dto.getIdentity() ? NumberIdentity.valueOf(dto.getIdentity().getEndpoint()) : null,
        null != dto.getReference() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        VerificationStatusType.from(dto.getStatus().getValue()),
        null != dto.getReason()
            ? VerificationStatusReasonType.from(dto.getReason().getValue())
            : null,
        null != dto.getSource() ? VerificationSourceType.from(dto.getSource()) : null);
  }

  public static Object convert(VerificationResponse client) {

    if (client instanceof VerificationResponseCallout) {
      return convert((VerificationResponseCallout) client);
    } else if (client instanceof VerificationResponseFlashCall) {
      return convert((VerificationResponseFlashCall) client);
    } else if (client instanceof VerificationResponseSMS) {
      return convert((VerificationResponseSMS) client);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client));
      return null;
    }
  }

  static CalloutRequestEventResponseDto convert(VerificationResponseCallout client) {
    CalloutRequestEventResponseDto dto = new CalloutRequestEventResponseDto();

    if (null != client.getAction()) {
      dto.action(VerificationEventResponseActionDto.fromValue(client.getAction().getValue()));
    }
    CalloutRequestEventResponseCalloutDto calloutDto = null;

    if (null != client.getCode()) {
      if (null == calloutDto) {
        calloutDto = new CalloutRequestEventResponseCalloutDto();
      }
      calloutDto.code(client.getCode());
    }

    if (null != client.getSpeech()) {
      if (null == calloutDto) {
        calloutDto = new CalloutRequestEventResponseCalloutDto();
      }
      calloutDto.speech(convert(client.getSpeech()));
    }
    if (null != calloutDto) {
      dto.callout(calloutDto);
    }
    return dto;
  }

  static CalloutRequestEventResponseCalloutSpeechDto convert(
      VerificationResponseCalloutSpeech client) {
    if (null == client) {
      return null;
    }
    return new CalloutRequestEventResponseCalloutSpeechDto().locale(client.getLocale());
  }

  static FlashCallRequestEventResponseDto convert(VerificationResponseFlashCall client) {
    FlashCallRequestEventResponseDto dto = new FlashCallRequestEventResponseDto();

    if (null != client.getAction()) {
      dto.action(VerificationEventResponseActionDto.fromValue(client.getAction().getValue()));
    }
    FlashCallRequestEventResponseFlashCallDto flashcallDto = null;

    if (null != client.getCli()) {
      if (null == flashcallDto) {
        flashcallDto = new FlashCallRequestEventResponseFlashCallDto();
      }
      flashcallDto.cli(client.getCli());
    }

    if (null != client.getDialTimeout()) {
      if (null == flashcallDto) {
        flashcallDto = new FlashCallRequestEventResponseFlashCallDto();
      }
      flashcallDto.dialTimeout(client.getDialTimeout());
    }
    if (null != flashcallDto) {
      dto.flashCall(flashcallDto);
    }
    return dto;
  }

  static SMSRequestEventResponseDto convert(VerificationResponseSMS client) {
    SMSRequestEventResponseDto dto = new SMSRequestEventResponseDto();

    if (null != client.getAction()) {
      dto.action(VerificationEventResponseActionDto.fromValue(client.getAction().getValue()));
    }
    SMSRequestEventResponseSmsDto smsDto = null;

    if (null != client.getCode()) {
      if (null == smsDto) {
        smsDto = new SMSRequestEventResponseSmsDto();
      }
      smsDto.code(client.getCode());
    }

    if (null != client.getAcceptLanguage()) {
      if (null == smsDto) {
        smsDto = new SMSRequestEventResponseSmsDto();
      }
      smsDto.acceptLanguage(new ArrayList<>(client.getAcceptLanguage()));
    }
    if (null != smsDto) {
      dto.sms(smsDto);
    }
    return dto;
  }
}
