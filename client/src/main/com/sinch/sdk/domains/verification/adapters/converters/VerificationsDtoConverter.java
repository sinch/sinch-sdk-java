package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationReportRequestCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationStatusResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.DataInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.DataInitiateVerificationResponseSeamlessDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallInitiateVerificationResponseFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationReportRequestFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationStatusResponseAllOfPriceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationStatusResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto.TypeEnum;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceCalloutOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceCalloutOptionsSpeechDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceFlashCallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceSmsOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSInitiateVerificationResponseSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSVerificationStatusResponseAllOfPriceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSVerificationStatusResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SmsVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SmsVerificationReportRequestSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationMethodDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationResponseDto;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutSpeechOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSOptions;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import java.time.Instant;
import java.util.logging.Logger;

public class VerificationsDtoConverter {

  private static final Logger LOGGER = Logger.getLogger(VerificationsDtoConverter.class.getName());

  private static final String IDENTITY_TYPE_NUMBER = "number";

  public static InitiateVerificationResourceDto convert(StartVerificationRequestParameters client) {
    InitiateVerificationResourceDto dto = new InitiateVerificationResourceDto();

    dto.method(convert(client.getMethod()));
    client.getIdentity().ifPresent(f -> dto.identity(convert(f)));
    client.getReference().ifPresent(f -> dto.reference(f.getReference()));
    client.getCustom().ifPresent(dto::custom);

    if (client instanceof StartVerificationFlashCallRequestParameters) {
      StartVerificationFlashCallRequestParameters options =
          (StartVerificationFlashCallRequestParameters) client;
      options
          .getDialTimeOut()
          .ifPresent(
              f ->
                  dto.flashCallOptions(
                      new InitiateVerificationResourceFlashCallOptionsDto().dialTimeout(f)));
    } else if (client instanceof StartVerificationSMSRequestParameters) {
      StartVerificationSMSRequestParameters options =
          (StartVerificationSMSRequestParameters) client;
      options.getOptions().ifPresent(f -> dto.smsOptions(convert(f)));
    } else if (client instanceof StartVerificationCalloutRequestParameters) {
      StartVerificationCalloutRequestParameters options =
          (StartVerificationCalloutRequestParameters) client;
      options.getOptions().ifPresent(f -> dto.calloutOptions(convert(f)));
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    return dto;
  }

  static InitiateVerificationResourceSmsOptionsDto convert(StartVerificationSMSOptions client) {
    InitiateVerificationResourceSmsOptionsDto dto = new InitiateVerificationResourceSmsOptionsDto();
    client.getExpiry().ifPresent(dto::setExpiry);
    client.getCodeType().ifPresent(f -> dto.setCodeType(f.value()));
    client.getTemplate().ifPresent(dto::setTemplate);
    return dto;
  }

  static InitiateVerificationResourceCalloutOptionsDto convert(
      StartVerificationCalloutOptions client) {
    InitiateVerificationResourceCalloutOptionsDto dto =
        new InitiateVerificationResourceCalloutOptionsDto();
    client.getSpeech().ifPresent(f -> dto.setSpeech(convert(f)));
    return dto;
  }

  static InitiateVerificationResourceCalloutOptionsSpeechDto convert(
      StartVerificationCalloutSpeechOptions client) {
    InitiateVerificationResourceCalloutOptionsSpeechDto dto =
        new InitiateVerificationResourceCalloutOptionsSpeechDto();
    client.getLocale().ifPresent(dto::setLocale);
    return dto;
  }

  public static IdentityDto convert(Identity client) {
    IdentityDto dto = new IdentityDto();
    if (client instanceof NumberIdentity) {
      dto.type(IDENTITY_TYPE_NUMBER).endpoint(((NumberIdentity) client).getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", client.getClass()));
    }
    return dto;
  }

  public static Identity convert(IdentityDto dto) {
    Identity identity = null;
    if (TypeEnum.NUMBER.getValue().equals(dto.getType())) {
      identity = NumberIdentity.valueOf(dto.getEndpoint());
    } else {
      LOGGER.severe(String.format("Unexpected '%s'", dto));
    }
    return identity;
  }

  public static VerificationMethodDto convert(VerificationMethodType client) {
    return VerificationMethodDto.fromValue(EnumDynamicConverter.convert(client));
  }

  public static StartVerificationResponse convert(InitiateVerificationResponseDto dto) {
    StartVerificationResponse.Builder<?> builder;

    if (dto.getActualInstance() instanceof SMSInitiateVerificationResponseDto) {
      builder = convert(dto.getSMSInitiateVerificationResponseDto());
    } else if (dto.getActualInstance() instanceof FlashCallInitiateVerificationResponseDto) {
      builder = convert(dto.getFlashCallInitiateVerificationResponseDto());
    } else if (dto.getActualInstance() instanceof CalloutInitiateVerificationResponseDto) {
      builder = convert(dto.getCalloutInitiateVerificationResponseDto());
    } else if (dto.getActualInstance() instanceof DataInitiateVerificationResponseDto) {
      builder = convert(dto.getDataInitiateVerificationResponseDto());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto.getActualInstance()));
      builder = StartVerificationResponse.builder();
    }
    return builder.build();
  }

  static StartVerificationResponseSMS.Builder convert(SMSInitiateVerificationResponseDto dto) {
    StartVerificationResponseSMS.Builder builder = StartVerificationResponseSMS.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getLinksDefined()) {
      builder.setLinks(LinkDtoConverter.convert((dto.getLinks())));
    }

    if (dto.getSmsDefined()) {
      SMSInitiateVerificationResponseSmsDto sms = dto.getSms();
      if (sms.getTemplateDefined()) {
        builder.setTemplate(sms.getTemplate());
      }
      if (sms.getInterceptionTimeoutDefined()) {
        builder.setInterceptionTimeOut(Integer.valueOf(sms.getInterceptionTimeout()));
      }
    }

    return builder;
  }

  static StartVerificationResponseFlashCall.Builder convert(
      FlashCallInitiateVerificationResponseDto dto) {

    StartVerificationResponseFlashCall.Builder builder =
        StartVerificationResponseFlashCall.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getLinksDefined()) {
      builder.setLinks(LinkDtoConverter.convert((dto.getLinks())));
    }

    if (dto.getFlashCallDefined()) {
      FlashCallInitiateVerificationResponseFlashCallDto flashCallDto = dto.getFlashCall();
      if (flashCallDto.getCliFilterDefined()) {
        builder.setCliFilter(flashCallDto.getCliFilter());
      }
      if (flashCallDto.getInterceptionTimeoutDefined()) {
        builder.setInterceptionTimeOut(flashCallDto.getInterceptionTimeout());
      }
      if (flashCallDto.getReportTimeoutDefined()) {
        builder.setReportTimeout(flashCallDto.getReportTimeout());
      }
      if (flashCallDto.getDenyCallAfterDefined()) {
        builder.setDenyCallAfter(flashCallDto.getDenyCallAfter());
      }
    }
    return builder;
  }

  static StartVerificationResponseCallout.Builder convert(
      CalloutInitiateVerificationResponseDto dto) {

    StartVerificationResponseCallout.Builder builder = StartVerificationResponseCallout.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getLinksDefined()) {
      builder.setLinks(LinkDtoConverter.convert((dto.getLinks())));
    }
    return builder;
  }

  static StartVerificationResponseSeamless.Builder convert(
      DataInitiateVerificationResponseDto dto) {

    StartVerificationResponseSeamless.Builder builder = StartVerificationResponseSeamless.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getLinksDefined()) {
      builder.setLinks(LinkDtoConverter.convert((dto.getLinks())));
    }

    if (dto.getSeamlessDefined()) {
      DataInitiateVerificationResponseSeamlessDto seamlessDto = dto.getSeamless();
      if (seamlessDto.getTargetUriDefined()) {
        builder.setTargetUri(seamlessDto.getTargetUri());
      }
    }
    return builder;
  }

  public static VerificationReportRequestResourceDto convert(
      VerificationReportRequestParameters client) {

    VerificationReportRequestResourceDto dto = new VerificationReportRequestResourceDto();

    if (client instanceof VerificationReportFlashCallRequestParameters) {
      VerificationReportFlashCallRequestParameters typedClient =
          (VerificationReportFlashCallRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    } else if (client instanceof VerificationReportSMSRequestParameters) {
      VerificationReportSMSRequestParameters typedClient =
          (VerificationReportSMSRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    } else if (client instanceof VerificationReportCalloutRequestParameters) {
      VerificationReportCalloutRequestParameters typedClient =
          (VerificationReportCalloutRequestParameters) client;
      dto.setActualInstance(convert(typedClient));
    }
    return dto;
  }

  private static FlashcallVerificationReportRequestDto convert(
      VerificationReportFlashCallRequestParameters client) {

    FlashcallVerificationReportRequestFlashCallDto subfield =
        new FlashcallVerificationReportRequestFlashCallDto();
    client.getCli().ifPresent(subfield::cli);

    return new FlashcallVerificationReportRequestDto()
        .method(FlashcallVerificationReportRequestDto.MethodEnum.FLASHCALL.getValue())
        .flashCall(subfield);
  }

  private static SmsVerificationReportRequestDto convert(
      VerificationReportSMSRequestParameters client) {

    SmsVerificationReportRequestSmsDto subfield = new SmsVerificationReportRequestSmsDto();
    client.getCode().ifPresent(subfield::code);
    client.getCli().ifPresent(subfield::cli);

    return new SmsVerificationReportRequestDto()
        .method(SmsVerificationReportRequestDto.MethodEnum.SMS.getValue())
        .sms(subfield);
  }

  private static CalloutVerificationReportRequestDto convert(
      VerificationReportCalloutRequestParameters client) {

    CalloutVerificationReportRequestCalloutDto subfield =
        new CalloutVerificationReportRequestCalloutDto();
    client.getCode().ifPresent(subfield::code);

    return new CalloutVerificationReportRequestDto()
        .method(CalloutVerificationReportRequestDto.MethodEnum.CALLOUT.getValue())
        .callout(subfield);
  }

  public static VerificationReport convert(VerificationReportResponseDto dto) {
    VerificationReport.Builder<?> builder;
    switch (dto.getMethod()) {
      case SMS:
        builder = VerificationReportSMS.builder();
        break;
      case FLASHCALL:
        builder = VerificationReportFlashCall.builder();
        break;
      case CALLOUT:
        builder = VerificationReportCallout.builder();
        break;
      default:
        LOGGER.severe(String.format("Unexpected value '%s'", dto.getMethod()));
        return VerificationReport.builder().build();
    }

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getStatusDefined()) {
      builder.setStatus(VerificationStatusType.from(dto.getStatus().getValue()));
    }
    return builder.build();
  }

  public static VerificationStatus convert(VerificationResponseDto dto) {
    VerificationStatus.Builder<?> builder;

    if (dto.getActualInstance() instanceof FlashcallVerificationStatusResponseDto) {
      builder = convert(dto.getFlashcallVerificationStatusResponseDto());
    } else if (dto.getActualInstance() instanceof SMSVerificationStatusResponseDto) {
      builder = convert(dto.getSMSVerificationStatusResponseDto());
    } else if (dto.getActualInstance() instanceof CalloutVerificationStatusResponseDto) {
      builder = convert(dto.getCalloutVerificationStatusResponseDto());
    } else {
      LOGGER.severe(String.format("Unexpected class '%s'", dto));
      builder = VerificationStatus.builder();
    }
    return builder.build();
  }

  static VerificationStatusFlashCall.Builder convert(FlashcallVerificationStatusResponseDto dto) {

    VerificationStatusFlashCall.Builder builder = VerificationStatusFlashCall.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getStatusDefined()) {
      builder.setStatus(VerificationStatusType.from(dto.getStatus().getValue()));
    }
    if (dto.getReasonDefined()) {
      builder.setReason(VerificationStatusReasonType.from(dto.getReason().getValue()));
    }
    if (dto.getReferenceDefined()) {
      builder.setReference(VerificationReference.valueOf(dto.getReference()));
    }
    if (dto.getIdentityDefined()) {
      builder.setIdentity(convert(dto.getIdentity()));
    }
    if (dto.getCountryIdDefined()) {
      builder.setCountryId(dto.getCountryId());
    }
    if (dto.getVerificationTimestampDefined()) {
      builder.setVerificationTimeStamp(Instant.parse(dto.getVerificationTimestamp()));
    }

    if (dto.getSourceDefined()) {
      builder.setSource(VerificationSourceType.from(dto.getSource()));
    }
    if (dto.getPriceDefined()) {
      FlashcallVerificationStatusResponseAllOfPriceDto price = dto.getPrice();
      if (price.getVerificationPriceDefined()) {
        builder.setVerificationPrice(PriceDtoConverter.convert(price.getVerificationPrice()));
      }
      if (price.getTerminationPriceDefined()) {
        builder.setTerminationPrice(PriceDtoConverter.convert(price.getTerminationPrice()));
      }
      if (price.getBillableDurationDefined()) {
        builder.setBillableDuration(price.getBillableDuration());
      }
    }
    return builder;
  }

  static VerificationStatusSMS.Builder convert(SMSVerificationStatusResponseDto dto) {

    VerificationStatusSMS.Builder builder = VerificationStatusSMS.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getStatusDefined()) {
      builder.setStatus(VerificationStatusType.from(dto.getStatus().getValue()));
    }
    if (dto.getReasonDefined()) {
      builder.setReason(VerificationStatusReasonType.from(dto.getReason().getValue()));
    }
    if (dto.getReferenceDefined()) {
      builder.setReference(VerificationReference.valueOf(dto.getReference()));
    }
    if (dto.getIdentityDefined()) {
      builder.setIdentity(convert(dto.getIdentity()));
    }
    if (dto.getCountryIdDefined()) {
      builder.setCountryId(dto.getCountryId());
    }
    if (dto.getVerificationTimestampDefined()) {
      builder.setVerificationTimeStamp(Instant.parse(dto.getVerificationTimestamp()));
    }

    if (dto.getSourceDefined()) {
      builder.setSource(VerificationSourceType.from(dto.getSource()));
    }
    if (dto.getPriceDefined()) {
      SMSVerificationStatusResponseAllOfPriceDto price = dto.getPrice();
      if (price.getVerificationPriceDefined()) {
        builder.setVerificationPrice(PriceDtoConverter.convert(price.getVerificationPrice()));
      }
    }
    return builder;
  }

  static VerificationStatusCallout.Builder convert(CalloutVerificationStatusResponseDto dto) {

    VerificationStatusCallout.Builder builder = VerificationStatusCallout.builder();

    if (dto.getIdDefined()) {
      builder.setId(VerificationId.valueOf(dto.getId()));
    }
    if (dto.getStatusDefined()) {
      builder.setStatus(VerificationStatusType.from(dto.getStatus().getValue()));
    }
    if (dto.getReasonDefined()) {
      builder.setReason(VerificationStatusReasonType.from(dto.getReason().getValue()));
    }
    if (dto.getReferenceDefined()) {
      builder.setReference(VerificationReference.valueOf(dto.getReference()));
    }
    if (dto.getIdentityDefined()) {
      builder.setIdentity(convert(dto.getIdentity()));
    }
    if (dto.getCountryIdDefined()) {
      builder.setCountryId(dto.getCountryId());
    }
    if (dto.getVerificationTimestampDefined()) {
      builder.setVerificationTimeStamp(Instant.parse(dto.getVerificationTimestamp()));
    }

    if (dto.getCallCompleteDefined()) {
      builder.setCallComplete(dto.getCallComplete());
    }
    if (dto.getPriceDefined()) {
      FlashcallVerificationStatusResponseAllOfPriceDto price = dto.getPrice();
      if (price.getVerificationPriceDefined()) {
        builder.setVerificationPrice(PriceDtoConverter.convert(price.getVerificationPrice()));
      }
      if (price.getTerminationPriceDefined()) {
        builder.setTerminationPrice(PriceDtoConverter.convert(price.getTerminationPrice()));
      }
      if (price.getBillableDurationDefined()) {
        builder.setBillableDuration(price.getBillableDuration());
      }
    }
    return builder;
  }
}
