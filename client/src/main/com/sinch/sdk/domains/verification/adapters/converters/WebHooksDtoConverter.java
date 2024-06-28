package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventResponseAction;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseSms;
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
      com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent dto) {

    if (dto instanceof VerificationRequestEventImpl) {
      return convert((VerificationRequestEventImpl) dto);
    } else if (dto instanceof VerificationResultEventImpl) {
      return convert((VerificationResultEventImpl) dto);
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      return null;
    }
  }

  static VerificationRequestEvent convert(VerificationRequestEventImpl dto) {

    return new VerificationRequestEvent(
        dto.getId(),
        dto.method().isPresent() ? VerificationMethodType.from(dto.getMethod().value()) : null,
        dto.identity().isPresent() ? IdentityDtoConverter.convert(dto.getIdentity()) : null,
        dto.price().isPresent() ? PriceDtoConverter.convert(dto.getPrice()) : null,
        dto.reference().isPresent() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        dto.getAcceptLanguage());
  }

  static VerificationResultEvent convert(VerificationResultEventImpl dto) {

    return new VerificationResultEvent(
        dto.getId(),
        dto.method().isPresent() ? VerificationMethodType.from(dto.getMethod().value()) : null,
        dto.identity().isPresent() ? IdentityDtoConverter.convert(dto.getIdentity()) : null,
        dto.reference().isPresent() ? VerificationReference.valueOf(dto.getReference()) : null,
        dto.getCustom(),
        dto.status().isPresent() ? VerificationStatusType.from(dto.getStatus().value()) : null,
        dto.reason().isPresent()
            ? VerificationStatusReasonType.from(dto.getReason().value())
            : null,
        dto.source().isPresent() ? VerificationSourceType.from(dto.getSource().value()) : null);
  }

  public static VerificationRequestEventResponse convert(VerificationResponse client) {

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

  static VerificationRequestEventResponsePhoneCall convert(VerificationResponseCallout client) {
    VerificationRequestEventResponsePhoneCall.Builder dto =
        VerificationRequestEventResponsePhoneCall.builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    if (null != client.getCode()) {
      dto.setCode(client.getCode());
    }
    if (null != client.getSpeech()) {
      dto.setSpeech(convert(client.getSpeech()));
    }
    return dto.build();
  }

  static PhoneCallSpeech convert(VerificationResponseCalloutSpeech client) {
    if (null == client) {
      return null;
    }
    return PhoneCallSpeech.builder().setLocale(client.getLocale()).build();
  }

  static VerificationRequestEventResponseFlashCall convert(VerificationResponseFlashCall client) {
    VerificationRequestEventResponseFlashCall.Builder dto =
        VerificationRequestEventResponseFlashCall.builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    if (null != client.getCli()) {
      dto.setCli(client.getCli());
    }
    if (null != client.getDialTimeout()) {
      dto.setDialTimeout(client.getDialTimeout());
    }
    return dto.build();
  }

  static VerificationRequestEventResponseSms convert(VerificationResponseSMS client) {
    VerificationRequestEventResponseSms.Builder dto = VerificationRequestEventResponseSms.builder();

    if (null != client.getAction()) {
      dto.setAction(VerificationEventResponseAction.from(client.getAction().getValue()));
    }
    if (null != client.getCode()) {
      dto.setCode(client.getCode());
    }
    if (null != client.getAcceptLanguage()) {
      dto.setAcceptLanguage(new ArrayList<>(client.getAcceptLanguage()));
    }
    return dto.build();
  }
}
