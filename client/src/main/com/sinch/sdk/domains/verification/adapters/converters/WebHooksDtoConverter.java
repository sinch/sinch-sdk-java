package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationEventDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationRequestEventDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationResultEventDto;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
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
}
