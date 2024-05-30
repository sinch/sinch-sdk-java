package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.webhooks.FlashCallRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.PhoneCallRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventResponseAction;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEventImpl;
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

  public static VerificationEvent convert(
      com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent _dto) {
    com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventImpl dto =
        (com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventImpl) _dto;
    if (dto.getActualInstance() instanceof VerificationRequestEventImpl) {
      return convert(dto.getVerificationRequestEventImpl());
    } else if (dto.getActualInstance() instanceof VerificationResultEventImpl) {
      return convert(dto.getVerificationResultEventImpl());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      return null;
    }
  }

  static VerificationRequestEvent convert(VerificationRequestEventImpl dto) {

    return new VerificationRequestEvent(
        dto.getId(),
        dto.method().isPresent() ? VerificationMethodType.from(dto.getMethod().value()) : null,
        dto.identity().isPresent() ? NumberIdentity.valueOf(dto.getIdentity().getEndpoint()) : null,
        dto.price().isPresent() ? PriceDtoConverter.convert(dto.getPrice()) : null,
        dto.reference().isPresent() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        dto.getAcceptLanguage());
  }

  static VerificationResultEvent convert(VerificationResultEventImpl dto) {

    return new VerificationResultEvent(
        dto.getId(),
        dto.method().isPresent() ? VerificationMethodType.from(dto.getMethod().value()) : null,
        dto.identity().isPresent() ? NumberIdentity.valueOf(dto.getIdentity().getEndpoint()) : null,
        dto.reference().isPresent() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        dto.status().isPresent() ? VerificationStatusType.from(dto.getStatus().value()) : null,
        dto.reason().isPresent()
            ? VerificationStatusReasonType.from(dto.getReason().value())
            : null,
        dto.source().isPresent() ? VerificationSourceType.from(dto.getSource().value()) : null);
  }

  public static Object convert(VerificationResponse client) {

    if (null == client) {
      return null;
    }
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

  static PhoneCallRequestEventResponse convert(VerificationResponseCallout client) {
    PhoneCallRequestEventResponse.Builder dto = PhoneCallRequestEventResponse.builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    com.sinch.sdk.domains.verification.models.v1.webhooks
            .PhoneCallRequestEventResponsePhoneCallContent.Builder
        calloutDto = null;

    if (null != client.getCode()) {
      if (null == calloutDto) {
        calloutDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks
                .PhoneCallRequestEventResponsePhoneCallContent.builder();
      }
      calloutDto.setCode(client.getCode());
    }

    if (null != client.getSpeech()) {
      if (null == calloutDto) {
        calloutDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks
                .PhoneCallRequestEventResponsePhoneCallContent.builder();
      }
      calloutDto.setSpeech(convert(client.getSpeech()));
    }
    if (null != calloutDto) {
      dto.setCallout(calloutDto.build());
    }
    return dto.build();
  }

  static PhoneCallSpeech convert(VerificationResponseCalloutSpeech client) {
    if (null == client) {
      return null;
    }
    return PhoneCallSpeech.builder().setLocale(client.getLocale()).build();
  }

  static com.sinch.sdk.domains.verification.models.v1.webhooks.FlashCallRequestEventResponse
      convert(VerificationResponseFlashCall client) {
    FlashCallRequestEventResponse.Builder dto =
        com.sinch.sdk.domains.verification.models.v1.webhooks.FlashCallRequestEventResponse
            .builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    com.sinch.sdk.domains.verification.models.v1.webhooks
            .FlashCallRequestEventResponseFlashCallContent.Builder
        flashcallDto = null;

    if (null != client.getCli()) {
      if (null == flashcallDto) {
        flashcallDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks
                .FlashCallRequestEventResponseFlashCallContent.builder();
      }
      flashcallDto.setCli(client.getCli());
    }

    if (null != client.getDialTimeout()) {
      if (null == flashcallDto) {
        flashcallDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks
                .FlashCallRequestEventResponseFlashCallContent.builder();
      }
      flashcallDto.setDialTimeout(client.getDialTimeout());
    }
    if (null != flashcallDto) {
      dto.setFlashCall(flashcallDto.build());
    }
    return dto.build();
  }

  static com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponse convert(
      VerificationResponseSMS client) {
    com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponse.Builder dto =
        com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponse.builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponseSmsContent.Builder
        smsDto = null;

    if (null != client.getCode()) {
      if (null == smsDto) {
        smsDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponseSmsContent
                .builder();
      }
      smsDto.setCode(client.getCode());
    }

    if (null != client.getAcceptLanguage()) {
      if (null == smsDto) {
        smsDto =
            com.sinch.sdk.domains.verification.models.v1.webhooks.SmsRequestEventResponseSmsContent
                .builder();
      }
      smsDto.setAcceptLanguage(new ArrayList<>(client.getAcceptLanguage()));
    }
    if (null != smsDto) {
      dto.setSms(smsDto.build());
    }
    return dto.build();
  }
}
