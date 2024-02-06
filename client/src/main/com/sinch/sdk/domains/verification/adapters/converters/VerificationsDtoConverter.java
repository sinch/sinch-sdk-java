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
import com.sinch.sdk.domains.verification.models.VerificationReportReasonType;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.VerificationReportStatusType;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutVerificationReportRequestDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallVerificationReportRequestDto;
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
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationMethodDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationPriceInformationDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceFlashcallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceSmsDto;
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

public class VerificationsDtoConverter {

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

    client
        .getMethod()
        .ifPresent(
            f -> dto.method(VerificationMethodDto.fromValue(EnumDynamicConverter.convert(f))));

    if (client instanceof VerificationReportFlashCallRequestParameters) {
      VerificationReportFlashCallRequestParameters typedClient =
          (VerificationReportFlashCallRequestParameters) client;
      dto.flashcall(convert(typedClient));
    } else if (client instanceof VerificationReportSMSRequestParameters) {
      VerificationReportSMSRequestParameters typedClient =
          (VerificationReportSMSRequestParameters) client;
      dto.sms(convert(typedClient));
    } else if (client instanceof VerificationReportCalloutRequestParameters) {
      VerificationReportCalloutRequestParameters typedClient =
          (VerificationReportCalloutRequestParameters) client;
      dto.callout(convert(typedClient));
    }
    return dto;
  }

  private static VerificationReportRequestResourceFlashcallDto convert(
      VerificationReportFlashCallRequestParameters client) {

    FlashcallVerificationReportRequestDto dto = new FlashcallVerificationReportRequestDto();

    client.getCli().ifPresent(dto::cli);
    return new VerificationReportRequestResourceFlashcallDto(dto);
  }

  private static VerificationReportRequestResourceSmsDto convert(
      VerificationReportSMSRequestParameters client) {

    SmsVerificationReportRequestDto dto = new SmsVerificationReportRequestDto();
    client.getCode().ifPresent(dto::code);
    client.getCli().ifPresent(dto::cli);
    return new VerificationReportRequestResourceSmsDto(dto);
  }

  private static VerificationReportRequestResourceCalloutDto convert(
      VerificationReportCalloutRequestParameters client) {

    CalloutVerificationReportRequestDto dto = new CalloutVerificationReportRequestDto();
    client.getCode().ifPresent(dto::code);

    return new VerificationReportRequestResourceCalloutDto(dto);
  }

  public static VerificationReport convert(VerificationResponseDto dto) {
    VerificationReport.Builder<?> builder;

    switch (dto.getMethod()) {
      case FLASHCALL:
        {
          VerificationReportFlashCall.Builder abuilder = VerificationReportFlashCall.builder();

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
          VerificationReportSMS.Builder abuilder = VerificationReportSMS.builder();
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
          VerificationReportCallout.Builder abuilder =
              VerificationReportCallout.builder().setCallComplete(dto.getCallComplete());
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
        .setReason(VerificationReportReasonType.from(dto.getReason()))
        .setStatus(VerificationReportStatusType.from(dto.getStatus()))
        .setReference(VerificationReference.valueOf(dto.getReference()))
        .build();
  }
}
