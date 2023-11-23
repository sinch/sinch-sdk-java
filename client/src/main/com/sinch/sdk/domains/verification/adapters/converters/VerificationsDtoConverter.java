package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallInitiateVerificationResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallOptionsDto;
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
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationMethodDto;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;

public class VerificationsDtoConverter {

  private static final String IDENTITY_TYPE_NUMBER = "number";

  public static InitiateVerificationResourceDto convert(StartVerificationRequestParameters client) {
    InitiateVerificationResourceDto dto = new InitiateVerificationResourceDto();

    dto.identity(convert(client.getIdentity()))
        .method(convert(client.getMethod()))
        .reference(client.getReference().orElse(null))
        .custom(client.getCustom().orElse(null));

    if (client instanceof StartVerificationFlashCallRequestParameters) {
      StartVerificationFlashCallRequestParameters options =
          (StartVerificationFlashCallRequestParameters) client;
      dto.flashCallOptions(
          options
              .getDialTimeOut()
              .map(
                  f ->
                      new InitiateVerificationResourceFlashCallOptionsDto(
                          new FlashcallOptionsDto().dialTimeout(f)))
              .orElse(null));
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

  public static InitiateVerificationResourceMethodDto convert(VerificationMethod client) {
    VerificationMethodDto dto = VerificationMethodDto.fromValue(client.value());
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
    return builder.setId(dto.getId()).setLinks(LinkDtoConverter.convert(dto.getLinks())).build();
  }
}
