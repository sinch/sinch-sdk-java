package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.core.exceptions.ApiException;
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
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.VerificationStatusCallout;
import com.sinch.sdk.domains.verification.models.VerificationStatusFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusSMS;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationReportRequestCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationReportRequestFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceFlashCallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceIdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceMethodDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResponseFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResponseSeamlessDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResponseSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SeamlessInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SmsInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SmsVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SmsVerificationReportRequestSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationMethodDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationPriceInformationDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceFlashcallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationResponseDto;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
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
                      new InitiateVerificationResourceFlashCallOptionsDto(
                          new FlashcallOptionsDto().dialTimeout(f))));
    }
    return dto;
  }

  public static InitiateVerificationResourceIdentityDto convert(Identity client) {
    IdentityDto dto = new IdentityDto();
    if (client instanceof NumberIdentity) {
      dto.type(IDENTITY_TYPE_NUMBER).endpoint(((NumberIdentity) client).getEndpoint());
    }
    return new InitiateVerificationResourceIdentityDto(dto);
  }

  public static InitiateVerificationResourceMethodDto convert(VerificationMethodType client) {
    VerificationMethodDto dto =
        VerificationMethodDto.fromValue(EnumDynamicConverter.convert(client));
    return new InitiateVerificationResourceMethodDto(dto);
  }

  public static StartVerificationResponse convert(InitiateVerificationResponseDto dto) {
    StartVerificationResponse.Builder<?> builder;
    switch (dto.getMethod()) {
      case SMS:
        {
          StartVerificationResponseSMS.Builder aBuilder = StartVerificationResponseSMS.builder();
          InitiateVerificationResponseSmsDto aresponse = dto.getSms();
          if (null != aresponse) {
            SmsInitiateVerificationResponseDto response =
                aresponse.getSmsInitiateVerificationResponseDto();
            aBuilder
                .setTemplate(response.getTemplate())
                .setInterceptionTimeOut(response.getInterceptionTimeout());
          }
          builder = aBuilder;
          break;
        }
      case FLASHCALL:
        {
          StartVerificationResponseFlashCall.Builder aBuilder =
              StartVerificationResponseFlashCall.builder();
          InitiateVerificationResponseFlashCallDto aresponse = dto.getFlashCall();
          if (null != aresponse) {
            FlashCallInitiateVerificationResponseDto response =
                aresponse.getFlashCallInitiateVerificationResponseDto();
            aBuilder
                .setCliFilter(response.getCliFilter())
                .setInterceptionTimeOut(response.getInterceptionTimeout())
                .setReportTimeout(response.getReportTimeout())
                .setDenyCallAfter(response.getDenyCallAfter());
          }
          builder = aBuilder;
          break;
        }
      case CALLOUT:
        {
          // noop: no specific parameters for callout but we create a specific builder for trace
          // purpose
          builder = StartVerificationResponseCallout.builder();
          break;
        }
      case SEAMLESS:
        {
          StartVerificationResponseSeamless.Builder aBuilder =
              StartVerificationResponseSeamless.builder();
          InitiateVerificationResponseSeamlessDto aresponse = dto.getSeamless();
          if (null != aresponse) {
            SeamlessInitiateVerificationResponseDto response =
                aresponse.getSeamlessInitiateVerificationResponseDto();
            aBuilder.setTargetUri(response.getTargetUri());
          }
          builder = aBuilder;
          break;
        }
      default:
        builder = StartVerificationResponse.builder();
    }
    return builder
        .setId(VerificationId.valueOf(dto.getId()))
        .setLinks(LinkDtoConverter.convert(dto.getLinks()))
        .build();
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

    FlashcallVerificationReportRequestFlashCallDto subfield = new  FlashcallVerificationReportRequestFlashCallDto();
    client.getCli().ifPresent(subfield::cli);

    FlashcallVerificationReportRequestDto dto = new FlashcallVerificationReportRequestDto()
        .method(FlashcallVerificationReportRequestDto.MethodEnum.FLASHCALL.getValue())
        .flashCall(subfield);
        return dto;
  }


  private static SmsVerificationReportRequestDto convert(
      VerificationReportSMSRequestParameters client) {

    SmsVerificationReportRequestSmsDto subfield = new SmsVerificationReportRequestSmsDto();
    client.getCode().ifPresent(subfield::code);
    client.getCli().ifPresent(subfield::cli);

    SmsVerificationReportRequestDto dto = new SmsVerificationReportRequestDto()
        .method(SmsVerificationReportRequestDto.MethodEnum.SMS.getValue())
        .sms(subfield);
        return dto;
  }

  private static CalloutVerificationReportRequestDto convert(
      VerificationReportCalloutRequestParameters client) {

    CalloutVerificationReportRequestCalloutDto subfield = new CalloutVerificationReportRequestCalloutDto();
    client.getCode().ifPresent(subfield::code);

    CalloutVerificationReportRequestDto dto = new CalloutVerificationReportRequestDto()
        .method(CalloutVerificationReportRequestDto.MethodEnum.CALLOUT.getValue())
        .callout(subfield);
    return dto;
  }

  public static VerificationReport convert(VerificationReportResponseDto dto) {
    switch (dto.getMethod()) {
      case SMS:
        return  VerificationReportSMS.builder().build();
      case  FLASHCALL:
        return  VerificationReportFlashCall.builder().build();
      case CALLOUT:
        return  VerificationReportCallout.builder().build();
      default:
        LOGGER.severe(String.format("Unexpected value '%s'", dto.getMethod()));
        return  VerificationReport.builder().build();
    }
  }


    public static VerificationStatus convert(VerificationResponseDto dto) {
    VerificationStatus.Builder<?> builder;

    switch (dto.getMethod()) {
      case FLASHCALL:
        {
          VerificationStatusFlashCall.Builder abuilder = VerificationStatusFlashCall.builder();

          if (null != dto.getSource()) {
            abuilder.setSource(VerificationSourceType.from(dto.getSource()));
          }
          if (null != dto.getPrice()
              && null != dto.getPrice().getVerificationPriceInformationDto()) {
            VerificationPriceInformationDto price =
                dto.getPrice().getVerificationPriceInformationDto();
            abuilder.setVerificationPrice(
                PriceDtoConverter.convert(price.getVerificationPrice().getMoneyDto()));
            abuilder.setTerminationPrice(
                PriceDtoConverter.convert(price.getTerminationPrice().getMoneyDto()));
            abuilder.setBillableDuration(price.getBillableDuration());
          }
          builder = abuilder;
          break;
        }
      case SMS:
        {
          VerificationStatusSMS.Builder abuilder = VerificationStatusSMS.builder();
          if (null != dto.getSource()) {
            abuilder.setSource(VerificationSourceType.from(dto.getSource()));
          }
          if (null != dto.getPrice()
              && null != dto.getPrice().getVerificationPriceInformationDto()) {
            VerificationPriceInformationDto price =
                dto.getPrice().getVerificationPriceInformationDto();
            abuilder.setVerificationPrice(
                PriceDtoConverter.convert(price.getVerificationPrice().getMoneyDto()));
          }
          builder = abuilder;
          break;
        }
      case CALLOUT:
        {
          VerificationStatusCallout.Builder abuilder =
              VerificationStatusCallout.builder().setCallComplete(dto.getCallComplete());
          if (null != dto.getPrice()
              && null != dto.getPrice().getVerificationPriceInformationDto()) {
            VerificationPriceInformationDto price =
                dto.getPrice().getVerificationPriceInformationDto();
            abuilder.setVerificationPrice(
                PriceDtoConverter.convert(price.getVerificationPrice().getMoneyDto()));
            abuilder.setTerminationPrice(
                PriceDtoConverter.convert(price.getTerminationPrice().getMoneyDto()));
            abuilder.setBillableDuration(price.getBillableDuration());
          }
          builder = abuilder;
          break;
        }
      default:
        throw new ApiException("Unexpected method: " + dto.getMethod());
    }
    return builder
        .setId(VerificationId.valueOf(dto.getId()))
        .setReason(VerificationStatusReasonType.from(dto.getReason()))
        .setStatus(VerificationStatusType.from(dto.getStatus()))
        .setReference(VerificationReference.valueOf(dto.getReference()))
        .build();
  }
}
