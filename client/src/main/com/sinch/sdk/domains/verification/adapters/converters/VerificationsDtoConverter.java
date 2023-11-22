package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashcallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceFlashCallOptionsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceIdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceMethodDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationMethodDto;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;

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
}
